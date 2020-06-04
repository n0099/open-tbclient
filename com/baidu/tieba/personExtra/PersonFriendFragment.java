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
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Um = null;
    private d kqF = null;
    private View koU = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel kqE = null;
    private int mPageType = 0;
    int jtR = 0;
    private boolean mIsHost = true;
    private au kqG = null;
    private boolean fcw = true;
    private boolean kin = false;
    private int pageNum = 0;
    private int kqH = 20;
    private final CustomMessageListener kqI = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cOR() != null) {
                    PersonFriendFragment.this.kqG = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener kqJ = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.kin = false;
                if (PersonFriendFragment.this.cOR() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cOR().getUniqueId()) {
                    PersonFriendFragment.this.Um.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cOR() {
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
        if (cOR() != null) {
            this.kqE = cOR().cOQ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kqF != null) {
            this.kqF.cOS();
            this.kqF = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kqJ);
        MessageManager.getInstance().unRegisterListener(this.kqI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kqJ);
        registerListener(this.kqI);
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
            this.mNoDataView.aWa();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kqF != null) {
            this.kqF.cOS();
            this.kqF = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.kqF = new d(cOR(), cOR().coT(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jtR = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.czg();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.kin) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kqE.cOT().getPage().aPr() + 1;
                    PersonFriendFragment.this.kin = true;
                    PersonFriendFragment.this.czf();
                }
            }
        });
        this.Um = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Um.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.kqF != null && PersonFriendFragment.this.kqF.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.kqF.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cOR().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Um.setAdapter((ListAdapter) this.kqF);
        this.mPullView = new com.baidu.tbadk.core.view.g(cOR().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cOR() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fcw = true;
                    PersonFriendFragment.this.kqE.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cOR().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.kqH);
                }
            }
        });
        this.Um.setPullRefresh(this.mPullView);
        this.mIsHost = cOR().coT();
        if (cOR() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cOR().coS());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.wR(str), null);
        this.koU = inflate.findViewById(R.id.friend_fragment_parent);
        this.Um.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.kin) {
                    PersonFriendFragment.this.fcw = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kqE.cOT().getPage().aPr() + 1;
                    PersonFriendFragment.this.kin = true;
                    PersonFriendFragment.this.czf();
                }
            }
        });
        if (cOR() != null) {
            this.kqE = cOR().cOQ();
            if (this.mIsHost) {
                cOq();
            }
        }
        if (this.mPageType == cOR().coR()) {
            this.pageNum = 0;
            this.Um.startPullRefresh();
        }
        return inflate;
    }

    public void cOq() {
        if (this.kqE != null) {
            this.kqE.cOq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czf() {
        if (this.kqF != null) {
            this.kqF.sW(true);
            this.kqF.notifyDataSetChanged();
        }
        this.pageNum = this.kqE.cOT().getPage().aPr() + 1;
        this.kqE.a(this.mIsHost, this.kqE.getId(), this.pageNum, this.kqH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czg() {
        UserData userData;
        if (this.kqF != null && this.kqF.getItemViewType(this.jtR) == 0 && (userData = (UserData) this.kqF.getItem(this.jtR)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cOR().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cOR().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.koU != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.koU);
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
            this.Um.completePullRefreshPostDelayed(0L);
            if (this.kqE != null && cOR() != null) {
                if (!z) {
                    if (this.fcw) {
                        this.fcw = false;
                        if (this.mPageType == cOR().coR()) {
                            this.kqE.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cOR().coR()) {
                            a(auVar);
                        }
                        auVar2 = this.kqE.cOT();
                    }
                    this.kqG = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.kqG = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.kqE != null) {
            this.kqE.cOT().aPw().addAll(auVar.aPw());
            this.kqE.cOT().aPx().addAll(auVar.aPx());
            this.kqE.cOT().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.kqF != null) {
            if (auVar != null) {
                ao page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.kqF;
                    if (page == null || page.aPt() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.kqF.setData(auVar.aPw());
                } else {
                    if (auVar.aPx().size() < this.kqH) {
                        this.kqF.setHasMore(false);
                    } else {
                        this.kqF.setHasMore(true);
                    }
                    this.kqF.setData(auVar.aPx());
                }
                this.kqF.sW(false);
                this.kqF.bvY();
                this.kqF.notifyDataSetChanged();
                return;
            }
            this.kqF.setHasMore(false);
            this.kqF.setData(new ArrayList<>());
            this.kqF.sW(false);
            this.kqF.bvY();
            this.kqF.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cOR() != null && this.kqE != null) {
            if (this.mPageType == 0) {
                if (this.kqE.cOT().aPw().size() == 0) {
                    if (this.kqG != null && this.kqG.aPw().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Um.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Um.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Um.setVisibility(0);
                }
            } else if (this.kqE.cOT().aPx().size() == 0) {
                if (this.kqG != null && this.kqG.aPx().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Um.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Um.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Um.setVisibility(0);
            }
            cOR().cv(this.kqE.cOT().aPy(), this.kqE.cOT().aPz());
        }
    }
}
