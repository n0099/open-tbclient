package com.baidu.tieba.personExtra;

import android.content.Context;
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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView FL = null;
    private c fHy = null;
    private View fGk = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.f mPullView = null;
    private PersonFriendModel fHx = null;
    private int mPageType = 0;
    int eSx = 0;
    private boolean mIsHost = true;
    private aq fHz = null;
    private boolean fHA = true;
    private boolean fzY = false;
    private int pageNum = 0;
    private int fHB = 20;
    private final CustomMessageListener fHC = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                aq personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.beL() != null) {
                    PersonFriendFragment.this.fHz = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fHD = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fzY = false;
                if (PersonFriendFragment.this.beL() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.beL().getUniqueId()) {
                    PersonFriendFragment.this.FL.completePullRefreshPostDelayed(2000L);
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
    public PersonFriendActivity beL() {
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
        if (beL() != null) {
            this.fHx = beL().beK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fHy != null) {
            this.fHy.beM();
            this.fHy = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fHD);
        MessageManager.getInstance().unRegisterListener(this.fHC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fHD);
        registerListener(this.fHC);
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
        if (this.fHy != null) {
            this.fHy.beM();
            this.fHy = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.fHy = new c(beL(), beL().aGn(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonFriendFragment.this.eSx = ((Integer) view2.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aSu();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), PersonFriendFragment.this.getString(d.k.login_to_chat), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PersonFriendFragment.this.fzY) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fHx.beN().rg().ra() + 1;
                    PersonFriendFragment.this.fzY = true;
                    PersonFriendFragment.this.aSt();
                }
            }
        });
        this.FL = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.FL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fHy != null && PersonFriendFragment.this.fHy.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fHy.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.beL().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.FL.setAdapter((ListAdapter) this.fHy);
        this.mPullView = new com.baidu.tbadk.core.view.f(beL().getPageContext());
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (PersonFriendFragment.this.beL() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fHA = true;
                    PersonFriendFragment.this.fHx.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.beL().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fHB);
                }
            }
        });
        this.FL.setPullRefresh(this.mPullView);
        this.mIsHost = beL().aGn();
        if (beL() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.k.person_friend_no_personal_info), getString(d.k.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.k.person_friend_no_personal_info), beL().aGm());
        } else {
            str = getString(d.k.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eL(str), null);
        this.fGk = inflate.findViewById(d.g.friend_fragment_parent);
        this.FL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fzY) {
                    PersonFriendFragment.this.fHA = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fHx.beN().rg().ra() + 1;
                    PersonFriendFragment.this.fzY = true;
                    PersonFriendFragment.this.aSt();
                }
            }
        });
        if (beL() != null) {
            this.fHx = beL().beK();
            if (this.mIsHost) {
                bew();
            }
        }
        if (this.mPageType == beL().aGl()) {
            this.pageNum = 0;
            this.FL.startPullRefresh();
        }
        return inflate;
    }

    public void bew() {
        if (this.fHx != null) {
            this.fHx.bew();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        if (this.fHy != null) {
            this.fHy.lb(true);
            this.fHy.notifyDataSetChanged();
        }
        this.pageNum = this.fHx.beN().rg().ra() + 1;
        this.fHx.a(this.mIsHost, this.fHx.getId(), this.pageNum, this.fHB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        UserData userData;
        if (this.fHy != null && this.fHy.getItemViewType(this.eSx) == 0 && (userData = (UserData) this.fHy.getItem(this.eSx)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(beL().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(beL().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fGk != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().u(this.fGk);
            }
            if (this.mNoDataView != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dv(i);
            }
        }
    }

    public void a(aq aqVar, boolean z) {
        aq aqVar2;
        if (aqVar != null) {
            this.FL.completePullRefreshPostDelayed(2000L);
            if (this.fHx != null && beL() != null) {
                if (!z) {
                    if (this.fHA) {
                        this.fHA = false;
                        if (this.mPageType == beL().aGl()) {
                            this.fHx.d(aqVar);
                            aqVar2 = aqVar;
                        }
                    } else {
                        if (this.mPageType == beL().aGl()) {
                            a(aqVar);
                        }
                        aqVar2 = this.fHx.beN();
                    }
                    this.fHz = aqVar2;
                    b(aqVar2);
                    c(aqVar);
                }
                aqVar2 = aqVar;
                this.fHz = aqVar2;
                b(aqVar2);
                c(aqVar);
            }
        }
    }

    public void a(aq aqVar) {
        if (aqVar != null && this.fHx != null) {
            this.fHx.beN().rh().addAll(aqVar.rh());
            this.fHx.beN().ri().addAll(aqVar.ri());
            this.fHx.beN().a(aqVar.rg());
        }
    }

    private void b(aq aqVar) {
        boolean z = true;
        if (this.fHy != null) {
            if (aqVar != null) {
                am rg = aqVar.rg();
                if (this.mPageType == 0) {
                    c cVar = this.fHy;
                    if (rg == null || rg.rc() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fHy.setData(aqVar.rh());
                } else {
                    if (aqVar.ri().size() < this.fHB) {
                        this.fHy.setHasMore(false);
                    } else {
                        this.fHy.setHasMore(true);
                    }
                    this.fHy.setData(aqVar.ri());
                }
                this.fHy.lb(false);
                this.fHy.aSq();
                this.fHy.notifyDataSetChanged();
                return;
            }
            this.fHy.setHasMore(false);
            this.fHy.setData(new ArrayList<>());
            this.fHy.lb(false);
            this.fHy.aSq();
            this.fHy.notifyDataSetChanged();
        }
    }

    private void c(aq aqVar) {
        if (beL() != null && this.fHx != null) {
            if (this.mPageType == 0) {
                if (this.fHx.beN().rh().size() == 0) {
                    if (this.fHz != null && this.fHz.rh().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.FL.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.FL.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.FL.setVisibility(0);
                }
            } else if (this.fHx.beN().ri().size() == 0) {
                if (this.fHz != null && this.fHz.ri().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.FL.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.FL.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.FL.setVisibility(0);
            }
            beL().bg(this.fHx.beN().rj(), this.fHx.beN().rk());
        }
    }
}
