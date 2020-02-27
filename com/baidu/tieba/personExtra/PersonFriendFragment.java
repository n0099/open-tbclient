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
/* loaded from: classes11.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView AG = null;
    private d jlA = null;
    private View jjP = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jlz = null;
    private int mPageType = 0;
    int irL = 0;
    private boolean mIsHost = true;
    private au jlB = null;
    private boolean elu = true;
    private boolean jds = false;
    private int pageNum = 0;
    private int jlC = 20;
    private final CustomMessageListener jlD = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cwx() != null) {
                    PersonFriendFragment.this.jlB = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jlE = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jds = false;
                if (PersonFriendFragment.this.cwx() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cwx().getUniqueId()) {
                    PersonFriendFragment.this.AG.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cwx() {
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
        if (cwx() != null) {
            this.jlz = cwx().cww();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jlA != null) {
            this.jlA.cwy();
            this.jlA = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jlE);
        MessageManager.getInstance().unRegisterListener(this.jlD);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jlE);
        registerListener(this.jlD);
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
            this.mNoDataView.aHz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jlA != null) {
            this.jlA.cwy();
            this.jlA = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jlA = new d(cwx(), cwx().bXs(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.irL = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.chl();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jds) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlz.cwz().getPage().aBg() + 1;
                    PersonFriendFragment.this.jds = true;
                    PersonFriendFragment.this.chk();
                }
            }
        });
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jlA != null && PersonFriendFragment.this.jlA.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jlA.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cwx().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.AG.setAdapter((ListAdapter) this.jlA);
        this.mPullView = new com.baidu.tbadk.core.view.h(cwx().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cwx() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.elu = true;
                    PersonFriendFragment.this.jlz.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cwx().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jlC);
                }
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        this.mIsHost = cwx().bXs();
        if (cwx() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cwx().bXr());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tU(str), null);
        this.jjP = inflate.findViewById(R.id.friend_fragment_parent);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jds) {
                    PersonFriendFragment.this.elu = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlz.cwz().getPage().aBg() + 1;
                    PersonFriendFragment.this.jds = true;
                    PersonFriendFragment.this.chk();
                }
            }
        });
        if (cwx() != null) {
            this.jlz = cwx().cww();
            if (this.mIsHost) {
                cvW();
            }
        }
        if (this.mPageType == cwx().bXq()) {
            this.pageNum = 0;
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void cvW() {
        if (this.jlz != null) {
            this.jlz.cvW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        if (this.jlA != null) {
            this.jlA.ro(true);
            this.jlA.notifyDataSetChanged();
        }
        this.pageNum = this.jlz.cwz().getPage().aBg() + 1;
        this.jlz.a(this.mIsHost, this.jlz.getId(), this.pageNum, this.jlC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chl() {
        UserData userData;
        if (this.jlA != null && this.jlA.getItemViewType(this.irL) == 0 && (userData = (UserData) this.jlA.getItem(this.irL)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cwx().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cwx().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jjP != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jjP);
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
            this.AG.completePullRefreshPostDelayed(0L);
            if (this.jlz != null && cwx() != null) {
                if (!z) {
                    if (this.elu) {
                        this.elu = false;
                        if (this.mPageType == cwx().bXq()) {
                            this.jlz.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cwx().bXq()) {
                            a(auVar);
                        }
                        auVar2 = this.jlz.cwz();
                    }
                    this.jlB = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jlB = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jlz != null) {
            this.jlz.cwz().aBl().addAll(auVar.aBl());
            this.jlz.cwz().aBm().addAll(auVar.aBm());
            this.jlz.cwz().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jlA != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jlA;
                    if (page == null || page.aBi() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jlA.setData(auVar.aBl());
                } else {
                    if (auVar.aBm().size() < this.jlC) {
                        this.jlA.setHasMore(false);
                    } else {
                        this.jlA.setHasMore(true);
                    }
                    this.jlA.setData(auVar.aBm());
                }
                this.jlA.ro(false);
                this.jlA.bgH();
                this.jlA.notifyDataSetChanged();
                return;
            }
            this.jlA.setHasMore(false);
            this.jlA.setData(new ArrayList<>());
            this.jlA.ro(false);
            this.jlA.bgH();
            this.jlA.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cwx() != null && this.jlz != null) {
            if (this.mPageType == 0) {
                if (this.jlz.cwz().aBl().size() == 0) {
                    if (this.jlB != null && this.jlB.aBl().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.AG.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.AG.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.AG.setVisibility(0);
                }
            } else if (this.jlz.cwz().aBm().size() == 0) {
                if (this.jlB != null && this.jlB.aBm().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.AG.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.AG.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.AG.setVisibility(0);
            }
            cwx().cj(this.jlz.cwz().aBn(), this.jlz.cwz().aBo());
        }
    }
}
