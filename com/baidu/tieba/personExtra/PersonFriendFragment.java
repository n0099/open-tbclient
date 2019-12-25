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
/* loaded from: classes8.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Ak = null;
    private d jgZ = null;
    private View jfo = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jgY = null;
    private int mPageType = 0;
    int iml = 0;
    private boolean mIsHost = true;
    private au jha = null;
    private boolean jhb = true;
    private boolean iYO = false;
    private int pageNum = 0;
    private int jhc = 20;
    private final CustomMessageListener jhd = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.ctV() != null) {
                    PersonFriendFragment.this.jha = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jhe = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.iYO = false;
                if (PersonFriendFragment.this.ctV() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.ctV().getUniqueId()) {
                    PersonFriendFragment.this.Ak.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity ctV() {
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
        if (ctV() != null) {
            this.jgY = ctV().ctU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jgZ != null) {
            this.jgZ.ctW();
            this.jgZ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jhe);
        MessageManager.getInstance().unRegisterListener(this.jhd);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jhe);
        registerListener(this.jhd);
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
            this.mNoDataView.aEU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jgZ != null) {
            this.jgZ.ctW();
            this.jgZ = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jgZ = new d(ctV(), ctV().bUI(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.iml = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cey();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.iYO) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jgY.ctX().getPage().ayw() + 1;
                    PersonFriendFragment.this.iYO = true;
                    PersonFriendFragment.this.cex();
                }
            }
        });
        this.Ak = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ak.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jgZ != null && PersonFriendFragment.this.jgZ.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jgZ.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.ctV().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Ak.setAdapter((ListAdapter) this.jgZ);
        this.mPullView = new com.baidu.tbadk.core.view.h(ctV().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.ctV() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.jhb = true;
                    PersonFriendFragment.this.jgY.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.ctV().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jhc);
                }
            }
        });
        this.Ak.setPullRefresh(this.mPullView);
        this.mIsHost = ctV().bUI();
        if (ctV() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), ctV().bUH());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tA(str), null);
        this.jfo = inflate.findViewById(R.id.friend_fragment_parent);
        this.Ak.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.iYO) {
                    PersonFriendFragment.this.jhb = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jgY.ctX().getPage().ayw() + 1;
                    PersonFriendFragment.this.iYO = true;
                    PersonFriendFragment.this.cex();
                }
            }
        });
        if (ctV() != null) {
            this.jgY = ctV().ctU();
            if (this.mIsHost) {
                ctu();
            }
        }
        if (this.mPageType == ctV().bUG()) {
            this.pageNum = 0;
            this.Ak.startPullRefresh();
        }
        return inflate;
    }

    public void ctu() {
        if (this.jgY != null) {
            this.jgY.ctu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cex() {
        if (this.jgZ != null) {
            this.jgZ.qX(true);
            this.jgZ.notifyDataSetChanged();
        }
        this.pageNum = this.jgY.ctX().getPage().ayw() + 1;
        this.jgY.a(this.mIsHost, this.jgY.getId(), this.pageNum, this.jhc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cey() {
        UserData userData;
        if (this.jgZ != null && this.jgZ.getItemViewType(this.iml) == 0 && (userData = (UserData) this.jgZ.getItem(this.iml)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(ctV().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(ctV().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jfo != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jfo);
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
            this.Ak.completePullRefreshPostDelayed(0L);
            if (this.jgY != null && ctV() != null) {
                if (!z) {
                    if (this.jhb) {
                        this.jhb = false;
                        if (this.mPageType == ctV().bUG()) {
                            this.jgY.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == ctV().bUG()) {
                            a(auVar);
                        }
                        auVar2 = this.jgY.ctX();
                    }
                    this.jha = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jha = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jgY != null) {
            this.jgY.ctX().ayB().addAll(auVar.ayB());
            this.jgY.ctX().ayC().addAll(auVar.ayC());
            this.jgY.ctX().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jgZ != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jgZ;
                    if (page == null || page.ayy() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jgZ.setData(auVar.ayB());
                } else {
                    if (auVar.ayC().size() < this.jhc) {
                        this.jgZ.setHasMore(false);
                    } else {
                        this.jgZ.setHasMore(true);
                    }
                    this.jgZ.setData(auVar.ayC());
                }
                this.jgZ.qX(false);
                this.jgZ.bec();
                this.jgZ.notifyDataSetChanged();
                return;
            }
            this.jgZ.setHasMore(false);
            this.jgZ.setData(new ArrayList<>());
            this.jgZ.qX(false);
            this.jgZ.bec();
            this.jgZ.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (ctV() != null && this.jgY != null) {
            if (this.mPageType == 0) {
                if (this.jgY.ctX().ayB().size() == 0) {
                    if (this.jha != null && this.jha.ayB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Ak.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Ak.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Ak.setVisibility(0);
                }
            } else if (this.jgY.ctX().ayC().size() == 0) {
                if (this.jha != null && this.jha.ayC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Ak.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Ak.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Ak.setVisibility(0);
            }
            ctV().cj(this.jgY.ctX().ayD(), this.jgY.ctX().ayE());
        }
    }
}
