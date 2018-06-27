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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView LS = null;
    private c fXZ = null;
    private View fWI = null;
    private NoDataView mNoDataView = null;
    private h mPullView = null;
    private PersonFriendModel fXY = null;
    private int mPageType = 0;
    int fiM = 0;
    private boolean mIsHost = true;
    private aq fYa = null;
    private boolean fYb = true;
    private boolean fQz = false;
    private int pageNum = 0;
    private int fYc = 20;
    private final CustomMessageListener fYd = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                aq personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bkr() != null) {
                    PersonFriendFragment.this.fYa = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fYe = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fQz = false;
                if (PersonFriendFragment.this.bkr() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bkr().getUniqueId()) {
                    PersonFriendFragment.this.LS.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bkr() {
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
        if (bkr() != null) {
            this.fXY = bkr().bkq();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fXZ != null) {
            this.fXZ.bks();
            this.fXZ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fYe);
        MessageManager.getInstance().unRegisterListener(this.fYd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fYe);
        registerListener(this.fYd);
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
        if (this.fXZ != null) {
            this.fXZ.bks();
            this.fXZ = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.fXZ = new c(bkr(), bkr().aLM(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fiM = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aXX();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.fQz) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fXY.bkt().uJ().uD() + 1;
                    PersonFriendFragment.this.fQz = true;
                    PersonFriendFragment.this.aXW();
                }
            }
        });
        this.LS = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.LS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fXZ != null && PersonFriendFragment.this.fXZ.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fXZ.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bkr().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.LS.setAdapter((ListAdapter) this.fXZ);
        this.mPullView = new h(bkr().getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (PersonFriendFragment.this.bkr() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fYb = true;
                    PersonFriendFragment.this.fXY.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bkr().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fYc);
                }
            }
        });
        this.LS.setPullRefresh(this.mPullView);
        this.mIsHost = bkr().aLM();
        if (bkr() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.k.person_friend_no_personal_info), getString(d.k.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.k.person_friend_no_personal_info), bkr().aLL());
        } else {
            str = getString(d.k.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fo(str), null);
        this.fWI = inflate.findViewById(d.g.friend_fragment_parent);
        this.LS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fQz) {
                    PersonFriendFragment.this.fYb = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fXY.bkt().uJ().uD() + 1;
                    PersonFriendFragment.this.fQz = true;
                    PersonFriendFragment.this.aXW();
                }
            }
        });
        if (bkr() != null) {
            this.fXY = bkr().bkq();
            if (this.mIsHost) {
                bkc();
            }
        }
        if (this.mPageType == bkr().aLK()) {
            this.pageNum = 0;
            this.LS.startPullRefresh();
        }
        return inflate;
    }

    public void bkc() {
        if (this.fXY != null) {
            this.fXY.bkc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXW() {
        if (this.fXZ != null) {
            this.fXZ.ls(true);
            this.fXZ.notifyDataSetChanged();
        }
        this.pageNum = this.fXY.bkt().uJ().uD() + 1;
        this.fXY.a(this.mIsHost, this.fXY.getId(), this.pageNum, this.fYc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXX() {
        UserData userData;
        if (this.fXZ != null && this.fXZ.getItemViewType(this.fiM) == 0 && (userData = (UserData) this.fXZ.getItem(this.fiM)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bkr().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bkr().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fWI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fWI);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, d.C0142d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dz(i);
            }
        }
    }

    public void a(aq aqVar, boolean z) {
        aq aqVar2;
        if (aqVar != null) {
            this.LS.completePullRefreshPostDelayed(2000L);
            if (this.fXY != null && bkr() != null) {
                if (!z) {
                    if (this.fYb) {
                        this.fYb = false;
                        if (this.mPageType == bkr().aLK()) {
                            this.fXY.d(aqVar);
                            aqVar2 = aqVar;
                        }
                    } else {
                        if (this.mPageType == bkr().aLK()) {
                            a(aqVar);
                        }
                        aqVar2 = this.fXY.bkt();
                    }
                    this.fYa = aqVar2;
                    b(aqVar2);
                    c(aqVar);
                }
                aqVar2 = aqVar;
                this.fYa = aqVar2;
                b(aqVar2);
                c(aqVar);
            }
        }
    }

    public void a(aq aqVar) {
        if (aqVar != null && this.fXY != null) {
            this.fXY.bkt().uK().addAll(aqVar.uK());
            this.fXY.bkt().uL().addAll(aqVar.uL());
            this.fXY.bkt().a(aqVar.uJ());
        }
    }

    private void b(aq aqVar) {
        boolean z = true;
        if (this.fXZ != null) {
            if (aqVar != null) {
                com.baidu.tbadk.core.data.am uJ = aqVar.uJ();
                if (this.mPageType == 0) {
                    c cVar = this.fXZ;
                    if (uJ == null || uJ.uF() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fXZ.setData(aqVar.uK());
                } else {
                    if (aqVar.uL().size() < this.fYc) {
                        this.fXZ.setHasMore(false);
                    } else {
                        this.fXZ.setHasMore(true);
                    }
                    this.fXZ.setData(aqVar.uL());
                }
                this.fXZ.ls(false);
                this.fXZ.aXU();
                this.fXZ.notifyDataSetChanged();
                return;
            }
            this.fXZ.setHasMore(false);
            this.fXZ.setData(new ArrayList<>());
            this.fXZ.ls(false);
            this.fXZ.aXU();
            this.fXZ.notifyDataSetChanged();
        }
    }

    private void c(aq aqVar) {
        if (bkr() != null && this.fXY != null) {
            if (this.mPageType == 0) {
                if (this.fXY.bkt().uK().size() == 0) {
                    if (this.fYa != null && this.fYa.uK().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.LS.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.LS.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.LS.setVisibility(0);
                }
            } else if (this.fXY.bkt().uL().size() == 0) {
                if (this.fYa != null && this.fYa.uL().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.LS.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.LS.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.LS.setVisibility(0);
            }
            bkr().bg(this.fXY.bkt().uM(), this.fXY.bkt().uN());
        }
    }
}
