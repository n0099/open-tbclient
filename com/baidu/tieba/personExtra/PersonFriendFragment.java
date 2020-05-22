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
    private d kpz = null;
    private View knO = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel kpy = null;
    private int mPageType = 0;
    int jsL = 0;
    private boolean mIsHost = true;
    private au kpA = null;
    private boolean fcl = true;
    private boolean khg = false;
    private int pageNum = 0;
    private int kpB = 20;
    private final CustomMessageListener kpC = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cOB() != null) {
                    PersonFriendFragment.this.kpA = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener kpD = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.khg = false;
                if (PersonFriendFragment.this.cOB() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cOB().getUniqueId()) {
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
    public PersonFriendActivity cOB() {
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
        if (cOB() != null) {
            this.kpy = cOB().cOA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kpz != null) {
            this.kpz.cOC();
            this.kpz = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kpD);
        MessageManager.getInstance().unRegisterListener(this.kpC);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kpD);
        registerListener(this.kpC);
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
            this.mNoDataView.aVZ();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kpz != null) {
            this.kpz.cOC();
            this.kpz = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.kpz = new d(cOB(), cOB().coK(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jsL = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cyP();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.khg) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kpy.cOD().getPage().aPr() + 1;
                    PersonFriendFragment.this.khg = true;
                    PersonFriendFragment.this.cyO();
                }
            }
        });
        this.Um = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Um.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.kpz != null && PersonFriendFragment.this.kpz.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.kpz.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cOB().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Um.setAdapter((ListAdapter) this.kpz);
        this.mPullView = new com.baidu.tbadk.core.view.g(cOB().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cOB() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fcl = true;
                    PersonFriendFragment.this.kpy.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cOB().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.kpB);
                }
            }
        });
        this.Um.setPullRefresh(this.mPullView);
        this.mIsHost = cOB().coK();
        if (cOB() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cOB().coJ());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.wR(str), null);
        this.knO = inflate.findViewById(R.id.friend_fragment_parent);
        this.Um.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.khg) {
                    PersonFriendFragment.this.fcl = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kpy.cOD().getPage().aPr() + 1;
                    PersonFriendFragment.this.khg = true;
                    PersonFriendFragment.this.cyO();
                }
            }
        });
        if (cOB() != null) {
            this.kpy = cOB().cOA();
            if (this.mIsHost) {
                cOa();
            }
        }
        if (this.mPageType == cOB().coI()) {
            this.pageNum = 0;
            this.Um.startPullRefresh();
        }
        return inflate;
    }

    public void cOa() {
        if (this.kpy != null) {
            this.kpy.cOa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyO() {
        if (this.kpz != null) {
            this.kpz.sW(true);
            this.kpz.notifyDataSetChanged();
        }
        this.pageNum = this.kpy.cOD().getPage().aPr() + 1;
        this.kpy.a(this.mIsHost, this.kpy.getId(), this.pageNum, this.kpB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyP() {
        UserData userData;
        if (this.kpz != null && this.kpz.getItemViewType(this.jsL) == 0 && (userData = (UserData) this.kpz.getItem(this.jsL)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cOB().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cOB().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.knO != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.knO);
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
            if (this.kpy != null && cOB() != null) {
                if (!z) {
                    if (this.fcl) {
                        this.fcl = false;
                        if (this.mPageType == cOB().coI()) {
                            this.kpy.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cOB().coI()) {
                            a(auVar);
                        }
                        auVar2 = this.kpy.cOD();
                    }
                    this.kpA = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.kpA = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.kpy != null) {
            this.kpy.cOD().aPw().addAll(auVar.aPw());
            this.kpy.cOD().aPx().addAll(auVar.aPx());
            this.kpy.cOD().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.kpz != null) {
            if (auVar != null) {
                ao page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.kpz;
                    if (page == null || page.aPt() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.kpz.setData(auVar.aPw());
                } else {
                    if (auVar.aPx().size() < this.kpB) {
                        this.kpz.setHasMore(false);
                    } else {
                        this.kpz.setHasMore(true);
                    }
                    this.kpz.setData(auVar.aPx());
                }
                this.kpz.sW(false);
                this.kpz.bvW();
                this.kpz.notifyDataSetChanged();
                return;
            }
            this.kpz.setHasMore(false);
            this.kpz.setData(new ArrayList<>());
            this.kpz.sW(false);
            this.kpz.bvW();
            this.kpz.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cOB() != null && this.kpy != null) {
            if (this.mPageType == 0) {
                if (this.kpy.cOD().aPw().size() == 0) {
                    if (this.kpA != null && this.kpA.aPw().size() > 0) {
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
            } else if (this.kpy.cOD().aPx().size() == 0) {
                if (this.kpA != null && this.kpA.aPx().size() > 0) {
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
            cOB().cv(this.kpy.cOD().aPy(), this.kpy.cOD().aPz());
        }
    }
}
