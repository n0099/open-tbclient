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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Ao = null;
    private d jkC = null;
    private View jiR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jkB = null;
    private int mPageType = 0;
    int ipQ = 0;
    private boolean mIsHost = true;
    private au jkD = null;
    private boolean eho = true;
    private boolean jcr = false;
    private int pageNum = 0;
    private int jkE = 20;
    private final CustomMessageListener jkF = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cvc() != null) {
                    PersonFriendFragment.this.jkD = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jkG = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jcr = false;
                if (PersonFriendFragment.this.cvc() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cvc().getUniqueId()) {
                    PersonFriendFragment.this.Ao.completePullRefreshPostDelayed(0L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY, g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity cvc() {
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
        if (cvc() != null) {
            this.jkB = cvc().cvb();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jkC != null) {
            this.jkC.cvd();
            this.jkC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jkG);
        MessageManager.getInstance().unRegisterListener(this.jkF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jkG);
        registerListener(this.jkF);
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
            this.mNoDataView.aFn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jkC != null) {
            this.jkC.cvd();
            this.jkC = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jkC = new d(cvc(), cvc().bVR(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.ipQ = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cfG();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jcr) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jkB.cve().getPage().ayP() + 1;
                    PersonFriendFragment.this.jcr = true;
                    PersonFriendFragment.this.cfF();
                }
            }
        });
        this.Ao = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ao.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jkC != null && PersonFriendFragment.this.jkC.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jkC.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cvc().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Ao.setAdapter((ListAdapter) this.jkC);
        this.mPullView = new com.baidu.tbadk.core.view.h(cvc().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cvc() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.eho = true;
                    PersonFriendFragment.this.jkB.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cvc().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jkE);
                }
            }
        });
        this.Ao.setPullRefresh(this.mPullView);
        this.mIsHost = cvc().bVR();
        if (cvc() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cvc().bVQ());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tE(str), null);
        this.jiR = inflate.findViewById(R.id.friend_fragment_parent);
        this.Ao.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jcr) {
                    PersonFriendFragment.this.eho = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jkB.cve().getPage().ayP() + 1;
                    PersonFriendFragment.this.jcr = true;
                    PersonFriendFragment.this.cfF();
                }
            }
        });
        if (cvc() != null) {
            this.jkB = cvc().cvb();
            if (this.mIsHost) {
                cuB();
            }
        }
        if (this.mPageType == cvc().bVP()) {
            this.pageNum = 0;
            this.Ao.startPullRefresh();
        }
        return inflate;
    }

    public void cuB() {
        if (this.jkB != null) {
            this.jkB.cuB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        if (this.jkC != null) {
            this.jkC.rk(true);
            this.jkC.notifyDataSetChanged();
        }
        this.pageNum = this.jkB.cve().getPage().ayP() + 1;
        this.jkB.a(this.mIsHost, this.jkB.getId(), this.pageNum, this.jkE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfG() {
        UserData userData;
        if (this.jkC != null && this.jkC.getItemViewType(this.ipQ) == 0 && (userData = (UserData) this.jkC.getItem(this.ipQ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cvc().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cvc().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jiR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jiR);
            }
            if (this.mNoDataView != null) {
                am.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(au auVar, boolean z) {
        au auVar2;
        if (auVar != null) {
            this.Ao.completePullRefreshPostDelayed(0L);
            if (this.jkB != null && cvc() != null) {
                if (!z) {
                    if (this.eho) {
                        this.eho = false;
                        if (this.mPageType == cvc().bVP()) {
                            this.jkB.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cvc().bVP()) {
                            a(auVar);
                        }
                        auVar2 = this.jkB.cve();
                    }
                    this.jkD = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jkD = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jkB != null) {
            this.jkB.cve().ayU().addAll(auVar.ayU());
            this.jkB.cve().ayV().addAll(auVar.ayV());
            this.jkB.cve().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jkC != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jkC;
                    if (page == null || page.ayR() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jkC.setData(auVar.ayU());
                } else {
                    if (auVar.ayV().size() < this.jkE) {
                        this.jkC.setHasMore(false);
                    } else {
                        this.jkC.setHasMore(true);
                    }
                    this.jkC.setData(auVar.ayV());
                }
                this.jkC.rk(false);
                this.jkC.bex();
                this.jkC.notifyDataSetChanged();
                return;
            }
            this.jkC.setHasMore(false);
            this.jkC.setData(new ArrayList<>());
            this.jkC.rk(false);
            this.jkC.bex();
            this.jkC.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cvc() != null && this.jkB != null) {
            if (this.mPageType == 0) {
                if (this.jkB.cve().ayU().size() == 0) {
                    if (this.jkD != null && this.jkD.ayU().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Ao.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Ao.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Ao.setVisibility(0);
                }
            } else if (this.jkB.cve().ayV().size() == 0) {
                if (this.jkD != null && this.jkD.ayV().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Ao.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Ao.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Ao.setVisibility(0);
            }
            cvc().ci(this.jkB.cve().ayW(), this.jkB.cve().ayX());
        }
    }
}
