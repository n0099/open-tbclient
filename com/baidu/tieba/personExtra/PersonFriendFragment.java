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
    private d jno = null;
    private View jlC = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jnn = null;
    private int mPageType = 0;
    int itz = 0;
    private boolean mIsHost = true;
    private au jnp = null;
    private boolean elY = true;
    private boolean jff = false;
    private int pageNum = 0;
    private int jnq = 20;
    private final CustomMessageListener jnr = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cwT() != null) {
                    PersonFriendFragment.this.jnp = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jns = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jff = false;
                if (PersonFriendFragment.this.cwT() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cwT().getUniqueId()) {
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
    public PersonFriendActivity cwT() {
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
        if (cwT() != null) {
            this.jnn = cwT().cwS();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jno != null) {
            this.jno.cwU();
            this.jno = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jns);
        MessageManager.getInstance().unRegisterListener(this.jnr);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jns);
        registerListener(this.jnr);
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
            this.mNoDataView.aHG();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jno != null) {
            this.jno.cwU();
            this.jno = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jno = new d(cwT(), cwT().bXN(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.itz = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.chI();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jff) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jnn.cwV().getPage().aBl() + 1;
                    PersonFriendFragment.this.jff = true;
                    PersonFriendFragment.this.chH();
                }
            }
        });
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jno != null && PersonFriendFragment.this.jno.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jno.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cwT().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.AG.setAdapter((ListAdapter) this.jno);
        this.mPullView = new com.baidu.tbadk.core.view.h(cwT().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cwT() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.elY = true;
                    PersonFriendFragment.this.jnn.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cwT().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jnq);
                }
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        this.mIsHost = cwT().bXN();
        if (cwT() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cwT().bXM());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tU(str), null);
        this.jlC = inflate.findViewById(R.id.friend_fragment_parent);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jff) {
                    PersonFriendFragment.this.elY = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jnn.cwV().getPage().aBl() + 1;
                    PersonFriendFragment.this.jff = true;
                    PersonFriendFragment.this.chH();
                }
            }
        });
        if (cwT() != null) {
            this.jnn = cwT().cwS();
            if (this.mIsHost) {
                cws();
            }
        }
        if (this.mPageType == cwT().bXL()) {
            this.pageNum = 0;
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void cws() {
        if (this.jnn != null) {
            this.jnn.cws();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chH() {
        if (this.jno != null) {
            this.jno.ru(true);
            this.jno.notifyDataSetChanged();
        }
        this.pageNum = this.jnn.cwV().getPage().aBl() + 1;
        this.jnn.a(this.mIsHost, this.jnn.getId(), this.pageNum, this.jnq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chI() {
        UserData userData;
        if (this.jno != null && this.jno.getItemViewType(this.itz) == 0 && (userData = (UserData) this.jno.getItem(this.itz)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cwT().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cwT().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jlC != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jlC);
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
            if (this.jnn != null && cwT() != null) {
                if (!z) {
                    if (this.elY) {
                        this.elY = false;
                        if (this.mPageType == cwT().bXL()) {
                            this.jnn.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cwT().bXL()) {
                            a(auVar);
                        }
                        auVar2 = this.jnn.cwV();
                    }
                    this.jnp = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jnp = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jnn != null) {
            this.jnn.cwV().aBq().addAll(auVar.aBq());
            this.jnn.cwV().aBr().addAll(auVar.aBr());
            this.jnn.cwV().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jno != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jno;
                    if (page == null || page.aBn() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jno.setData(auVar.aBq());
                } else {
                    if (auVar.aBr().size() < this.jnq) {
                        this.jno.setHasMore(false);
                    } else {
                        this.jno.setHasMore(true);
                    }
                    this.jno.setData(auVar.aBr());
                }
                this.jno.ru(false);
                this.jno.bgP();
                this.jno.notifyDataSetChanged();
                return;
            }
            this.jno.setHasMore(false);
            this.jno.setData(new ArrayList<>());
            this.jno.ru(false);
            this.jno.bgP();
            this.jno.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cwT() != null && this.jnn != null) {
            if (this.mPageType == 0) {
                if (this.jnn.cwV().aBq().size() == 0) {
                    if (this.jnp != null && this.jnp.aBq().size() > 0) {
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
            } else if (this.jnn.cwV().aBr().size() == 0) {
                if (this.jnp != null && this.jnp.aBr().size() > 0) {
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
            cwT().ck(this.jnn.cwV().aBs(), this.jnn.cwV().aBt());
        }
    }
}
