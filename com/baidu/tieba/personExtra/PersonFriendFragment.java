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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView LO = null;
    private c fYq = null;
    private View fWZ = null;
    private NoDataView mNoDataView = null;
    private h mPullView = null;
    private PersonFriendModel fYp = null;
    private int mPageType = 0;
    int fiS = 0;
    private boolean mIsHost = true;
    private ap fYr = null;
    private boolean fYs = true;
    private boolean fQC = false;
    private int pageNum = 0;
    private int fYt = 20;
    private final CustomMessageListener fYu = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.biH() != null) {
                    PersonFriendFragment.this.fYr = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fYv = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fQC = false;
                if (PersonFriendFragment.this.biH() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.biH().getUniqueId()) {
                    PersonFriendFragment.this.LO.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(f.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity biH() {
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
        if (biH() != null) {
            this.fYp = biH().biG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fYq != null) {
            this.fYq.biI();
            this.fYq = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fYv);
        MessageManager.getInstance().unRegisterListener(this.fYu);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fYv);
        registerListener(this.fYu);
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
        if (this.fYq != null) {
            this.fYq.biI();
            this.fYq = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(f.h.friend_fragment, viewGroup, false);
        this.fYq = new c(biH(), biH().aMK(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.fiS = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aWo();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.fQC) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fYp.biJ().uv().up() + 1;
                    PersonFriendFragment.this.fQC = true;
                    PersonFriendFragment.this.aWn();
                }
            }
        });
        this.LO = (BdListView) inflate.findViewById(f.g.my_friend_list);
        this.LO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fYq != null && PersonFriendFragment.this.fYq.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fYq.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.biH().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.LO.setAdapter((ListAdapter) this.fYq);
        this.mPullView = new h(biH().getPageContext());
        this.mPullView.a(new g.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (PersonFriendFragment.this.biH() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fYs = true;
                    PersonFriendFragment.this.fYp.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.biH().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fYt);
                }
            }
        });
        this.LO.setPullRefresh(this.mPullView);
        this.mIsHost = biH().aMK();
        if (biH() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(f.j.person_friend_no_personal_info), getString(f.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(f.j.person_friend_no_personal_info), biH().aMJ());
        } else {
            str = getString(f.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.fm(str), null);
        this.fWZ = inflate.findViewById(f.g.friend_fragment_parent);
        this.LO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fQC) {
                    PersonFriendFragment.this.fYs = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fYp.biJ().uv().up() + 1;
                    PersonFriendFragment.this.fQC = true;
                    PersonFriendFragment.this.aWn();
                }
            }
        });
        if (biH() != null) {
            this.fYp = biH().biG();
            if (this.mIsHost) {
                bis();
            }
        }
        if (this.mPageType == biH().aMI()) {
            this.pageNum = 0;
            this.LO.startPullRefresh();
        }
        return inflate;
    }

    public void bis() {
        if (this.fYp != null) {
            this.fYp.bis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWn() {
        if (this.fYq != null) {
            this.fYq.le(true);
            this.fYq.notifyDataSetChanged();
        }
        this.pageNum = this.fYp.biJ().uv().up() + 1;
        this.fYp.a(this.mIsHost, this.fYp.getId(), this.pageNum, this.fYt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWo() {
        UserData userData;
        if (this.fYq != null && this.fYq.getItemViewType(this.fiS) == 0 && (userData = (UserData) this.fYq.getItem(this.fiS)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(biH().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(biH().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fWZ != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.fWZ);
            }
            if (this.mNoDataView != null) {
                am.i(this.mNoDataView, f.d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dB(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.LO.completePullRefreshPostDelayed(2000L);
            if (this.fYp != null && biH() != null) {
                if (!z) {
                    if (this.fYs) {
                        this.fYs = false;
                        if (this.mPageType == biH().aMI()) {
                            this.fYp.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == biH().aMI()) {
                            a(apVar);
                        }
                        apVar2 = this.fYp.biJ();
                    }
                    this.fYr = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.fYr = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.fYp != null) {
            this.fYp.biJ().uw().addAll(apVar.uw());
            this.fYp.biJ().ux().addAll(apVar.ux());
            this.fYp.biJ().a(apVar.uv());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.fYq != null) {
            if (apVar != null) {
                al uv = apVar.uv();
                if (this.mPageType == 0) {
                    c cVar = this.fYq;
                    if (uv == null || uv.ur() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fYq.setData(apVar.uw());
                } else {
                    if (apVar.ux().size() < this.fYt) {
                        this.fYq.setHasMore(false);
                    } else {
                        this.fYq.setHasMore(true);
                    }
                    this.fYq.setData(apVar.ux());
                }
                this.fYq.le(false);
                this.fYq.aWl();
                this.fYq.notifyDataSetChanged();
                return;
            }
            this.fYq.setHasMore(false);
            this.fYq.setData(new ArrayList<>());
            this.fYq.le(false);
            this.fYq.aWl();
            this.fYq.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (biH() != null && this.fYp != null) {
            if (this.mPageType == 0) {
                if (this.fYp.biJ().uw().size() == 0) {
                    if (this.fYr != null && this.fYr.uw().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.LO.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.LO.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.LO.setVisibility(0);
                }
            } else if (this.fYp.biJ().ux().size() == 0) {
                if (this.fYr != null && this.fYr.ux().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.LO.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.LO.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.LO.setVisibility(0);
            }
            biH().bi(this.fYp.biJ().uy(), this.fYp.biJ().uz());
        }
    }
}
