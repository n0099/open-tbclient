package com.baidu.tieba.personExtra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Op = null;
    private c gfG = null;
    private View gep = null;
    private NoDataView mNoDataView = null;
    private k mPullView = null;
    private PersonFriendModel gfF = null;
    private int mPageType = 0;
    int fqo = 0;
    private boolean mIsHost = true;
    private ap gfH = null;
    private boolean gfI = true;
    private boolean fXS = false;
    private int pageNum = 0;
    private int gfJ = 20;
    private final CustomMessageListener gfK = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bli() != null) {
                    PersonFriendFragment.this.gfH = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gfL = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fXS = false;
                if (PersonFriendFragment.this.bli() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bli().getUniqueId()) {
                    PersonFriendFragment.this.Op.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(e.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bli() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        if (baseFragmentActivity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) baseFragmentActivity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (bli() != null) {
            this.gfF = bli().blh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gfG != null) {
            this.gfG.blj();
            this.gfG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gfL);
        MessageManager.getInstance().unRegisterListener(this.gfK);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gfL);
        registerListener(this.gfK);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.mNoDataView != null) {
            this.mNoDataView.e(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.gfG != null) {
            this.gfG.blj();
            this.gfG = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(e.h.friend_fragment, viewGroup, false);
        this.gfG = new c(bli(), bli().aOZ(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fqo = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aYB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.fXS) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gfF.blk().vy().vs() + 1;
                    PersonFriendFragment.this.fXS = true;
                    PersonFriendFragment.this.aYA();
                }
            }
        });
        this.Op = (BdListView) inflate.findViewById(e.g.my_friend_list);
        this.Op.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.gfG != null && PersonFriendFragment.this.gfG.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.gfG.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bli().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Op.setAdapter((ListAdapter) this.gfG);
        this.mPullView = new k(bli().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (PersonFriendFragment.this.bli() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gfI = true;
                    PersonFriendFragment.this.gfF.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bli().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.gfJ);
                }
            }
        });
        this.Op.setPullRefresh(this.mPullView);
        this.mIsHost = bli().aOZ();
        if (bli() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(e.j.person_friend_no_personal_info), getString(e.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(e.j.person_friend_no_personal_info), bli().aOY());
        } else {
            str = getString(e.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fG(str), null);
        this.gep = inflate.findViewById(e.g.friend_fragment_parent);
        this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fXS) {
                    PersonFriendFragment.this.gfI = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.gfF.blk().vy().vs() + 1;
                    PersonFriendFragment.this.fXS = true;
                    PersonFriendFragment.this.aYA();
                }
            }
        });
        if (bli() != null) {
            this.gfF = bli().blh();
            if (this.mIsHost) {
                bkT();
            }
        }
        if (this.mPageType == bli().aOX()) {
            this.pageNum = 0;
            this.Op.startPullRefresh();
        }
        return inflate;
    }

    public void bkT() {
        if (this.gfF != null) {
            this.gfF.bkT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYA() {
        if (this.gfG != null) {
            this.gfG.lA(true);
            this.gfG.notifyDataSetChanged();
        }
        this.pageNum = this.gfF.blk().vy().vs() + 1;
        this.gfF.a(this.mIsHost, this.gfF.getId(), this.pageNum, this.gfJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYB() {
        UserData userData;
        if (this.gfG != null && this.gfG.getItemViewType(this.fqo) == 0 && (userData = (UserData) this.gfG.getItem(this.fqo)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bli().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bli().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.gep != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.gep);
            }
            if (this.mNoDataView != null) {
                al.i(this.mNoDataView, e.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dM(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.Op.completePullRefreshPostDelayed(2000L);
            if (this.gfF != null && bli() != null) {
                if (!z) {
                    if (this.gfI) {
                        this.gfI = false;
                        if (this.mPageType == bli().aOX()) {
                            this.gfF.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bli().aOX()) {
                            a(apVar);
                        }
                        apVar2 = this.gfF.blk();
                    }
                    this.gfH = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gfH = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gfF != null) {
            this.gfF.blk().vz().addAll(apVar.vz());
            this.gfF.blk().vA().addAll(apVar.vA());
            this.gfF.blk().a(apVar.vy());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gfG != null) {
            if (apVar != null) {
                com.baidu.tbadk.core.data.al vy = apVar.vy();
                if (this.mPageType == 0) {
                    c cVar = this.gfG;
                    if (vy == null || vy.vu() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.gfG.setData(apVar.vz());
                } else {
                    if (apVar.vA().size() < this.gfJ) {
                        this.gfG.setHasMore(false);
                    } else {
                        this.gfG.setHasMore(true);
                    }
                    this.gfG.setData(apVar.vA());
                }
                this.gfG.lA(false);
                this.gfG.aYy();
                this.gfG.notifyDataSetChanged();
                return;
            }
            this.gfG.setHasMore(false);
            this.gfG.setData(new ArrayList<>());
            this.gfG.lA(false);
            this.gfG.aYy();
            this.gfG.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bli() != null && this.gfF != null) {
            if (this.mPageType == 0) {
                if (this.gfF.blk().vz().size() == 0) {
                    if (this.gfH != null && this.gfH.vz().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Op.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Op.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Op.setVisibility(0);
                }
            } else if (this.gfF.blk().vA().size() == 0) {
                if (this.gfH != null && this.gfH.vA().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Op.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Op.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Op.setVisibility(0);
            }
            bli().bm(this.gfF.blk().vB(), this.gfF.blk().vC());
        }
    }
}
