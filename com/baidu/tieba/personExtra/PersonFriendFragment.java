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
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView VY = null;
    private d lUi = null;
    private View lSw = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel lUh = null;
    private int mPageType = 0;
    int kTt = 0;
    private boolean mIsHost = true;
    private bb lUj = null;
    private boolean gdM = true;
    private boolean lLF = false;
    private int pageNum = 0;
    private int lUk = 20;
    private final CustomMessageListener lUl = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dsu() != null) {
                    PersonFriendFragment.this.lUj = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener lUm = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.lLF = false;
                if (PersonFriendFragment.this.dsu() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dsu().getUniqueId()) {
                    PersonFriendFragment.this.VY.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dsu() {
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
        if (dsu() != null) {
            this.lUh = dsu().dst();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lUi != null) {
            this.lUi.dsv();
            this.lUi = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lUm);
        MessageManager.getInstance().unRegisterListener(this.lUl);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lUm);
        registerListener(this.lUl);
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
            this.mNoDataView.bpO();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.lUi != null) {
            this.lUi.dsv();
            this.lUi = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.lUi = new d(dsu(), dsu().TQ(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kTt = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.dbZ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.lLF) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lUh.dsw().getPage().biO() + 1;
                    PersonFriendFragment.this.lLF = true;
                    PersonFriendFragment.this.dbY();
                }
            }
        });
        this.VY = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.lUi != null && PersonFriendFragment.this.lUi.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.lUi.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dsu().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.VY.setAdapter((ListAdapter) this.lUi);
        this.mPullView = new com.baidu.tbadk.core.view.g(dsu().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dsu() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.gdM = true;
                    PersonFriendFragment.this.lUh.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dsu().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.lUk);
                }
            }
        });
        this.VY.setPullRefresh(this.mPullView);
        this.mIsHost = dsu().TQ();
        if (dsu() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dsu().cRY());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.Cd(str), null);
        this.lSw = inflate.findViewById(R.id.friend_fragment_parent);
        this.VY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.lLF) {
                    PersonFriendFragment.this.gdM = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lUh.dsw().getPage().biO() + 1;
                    PersonFriendFragment.this.lLF = true;
                    PersonFriendFragment.this.dbY();
                }
            }
        });
        if (dsu() != null) {
            this.lUh = dsu().dst();
            if (this.mIsHost) {
                drS();
            }
        }
        if (this.mPageType == dsu().cRX()) {
            this.pageNum = 0;
            this.VY.startPullRefresh();
        }
        return inflate;
    }

    public void drS() {
        if (this.lUh != null) {
            this.lUh.drS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbY() {
        if (this.lUi != null) {
            this.lUi.vI(true);
            this.lUi.notifyDataSetChanged();
        }
        this.pageNum = this.lUh.dsw().getPage().biO() + 1;
        this.lUh.a(this.mIsHost, this.lUh.getId(), this.pageNum, this.lUk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbZ() {
        UserData userData;
        if (this.lUi != null && this.lUi.getItemViewType(this.kTt) == 0 && (userData = (UserData) this.lUi.getItem(this.kTt)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dsu().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dsu().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lSw != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lSw);
            }
            if (this.mNoDataView != null) {
                ap.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(bb bbVar, boolean z) {
        bb bbVar2;
        if (bbVar != null) {
            this.VY.completePullRefreshPostDelayed(0L);
            if (this.lUh != null && dsu() != null) {
                if (!z) {
                    if (this.gdM) {
                        this.gdM = false;
                        if (this.mPageType == dsu().cRX()) {
                            this.lUh.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == dsu().cRX()) {
                            a(bbVar);
                        }
                        bbVar2 = this.lUh.dsw();
                    }
                    this.lUj = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.lUj = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.lUh != null) {
            this.lUh.dsw().biT().addAll(bbVar.biT());
            this.lUh.dsw().biU().addAll(bbVar.biU());
            this.lUh.dsw().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.lUi != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.lUi;
                    if (page == null || page.biQ() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.lUi.setData(bbVar.biT());
                } else {
                    if (bbVar.biU().size() < this.lUk) {
                        this.lUi.setHasMore(false);
                    } else {
                        this.lUi.setHasMore(true);
                    }
                    this.lUi.setData(bbVar.biU());
                }
                this.lUi.vI(false);
                this.lUi.bTb();
                this.lUi.notifyDataSetChanged();
                return;
            }
            this.lUi.setHasMore(false);
            this.lUi.setData(new ArrayList<>());
            this.lUi.vI(false);
            this.lUi.bTb();
            this.lUi.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (dsu() != null && this.lUh != null) {
            if (this.mPageType == 0) {
                if (this.lUh.dsw().biT().size() == 0) {
                    if (this.lUj != null && this.lUj.biT().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.VY.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.VY.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.VY.setVisibility(0);
                }
            } else if (this.lUh.dsw().biU().size() == 0) {
                if (this.lUj != null && this.lUj.biU().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.VY.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.VY.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.VY.setVisibility(0);
            }
            dsu().cR(this.lUh.dsw().biV(), this.lUh.dsw().biW());
        }
    }
}
