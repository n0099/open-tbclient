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
    private d jlO = null;
    private View jkd = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jlN = null;
    private int mPageType = 0;
    int irZ = 0;
    private boolean mIsHost = true;
    private au jlP = null;
    private boolean elI = true;
    private boolean jdG = false;
    private int pageNum = 0;
    private int jlQ = 20;
    private final CustomMessageListener jlR = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cwA() != null) {
                    PersonFriendFragment.this.jlP = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jlS = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jdG = false;
                if (PersonFriendFragment.this.cwA() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cwA().getUniqueId()) {
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
    public PersonFriendActivity cwA() {
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
        if (cwA() != null) {
            this.jlN = cwA().cwz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jlO != null) {
            this.jlO.cwB();
            this.jlO = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jlS);
        MessageManager.getInstance().unRegisterListener(this.jlR);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jlS);
        registerListener(this.jlR);
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
            this.mNoDataView.aHC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jlO != null) {
            this.jlO.cwB();
            this.jlO = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jlO = new d(cwA(), cwA().bXv(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.irZ = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cho();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jdG) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlN.cwC().getPage().aBi() + 1;
                    PersonFriendFragment.this.jdG = true;
                    PersonFriendFragment.this.chn();
                }
            }
        });
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jlO != null && PersonFriendFragment.this.jlO.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jlO.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cwA().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.AG.setAdapter((ListAdapter) this.jlO);
        this.mPullView = new com.baidu.tbadk.core.view.h(cwA().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cwA() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.elI = true;
                    PersonFriendFragment.this.jlN.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cwA().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jlQ);
                }
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        this.mIsHost = cwA().bXv();
        if (cwA() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cwA().bXu());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tV(str), null);
        this.jkd = inflate.findViewById(R.id.friend_fragment_parent);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jdG) {
                    PersonFriendFragment.this.elI = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlN.cwC().getPage().aBi() + 1;
                    PersonFriendFragment.this.jdG = true;
                    PersonFriendFragment.this.chn();
                }
            }
        });
        if (cwA() != null) {
            this.jlN = cwA().cwz();
            if (this.mIsHost) {
                cvZ();
            }
        }
        if (this.mPageType == cwA().bXt()) {
            this.pageNum = 0;
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void cvZ() {
        if (this.jlN != null) {
            this.jlN.cvZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        if (this.jlO != null) {
            this.jlO.ro(true);
            this.jlO.notifyDataSetChanged();
        }
        this.pageNum = this.jlN.cwC().getPage().aBi() + 1;
        this.jlN.a(this.mIsHost, this.jlN.getId(), this.pageNum, this.jlQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        UserData userData;
        if (this.jlO != null && this.jlO.getItemViewType(this.irZ) == 0 && (userData = (UserData) this.jlO.getItem(this.irZ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cwA().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cwA().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jkd != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jkd);
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
            if (this.jlN != null && cwA() != null) {
                if (!z) {
                    if (this.elI) {
                        this.elI = false;
                        if (this.mPageType == cwA().bXt()) {
                            this.jlN.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cwA().bXt()) {
                            a(auVar);
                        }
                        auVar2 = this.jlN.cwC();
                    }
                    this.jlP = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jlP = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jlN != null) {
            this.jlN.cwC().aBn().addAll(auVar.aBn());
            this.jlN.cwC().aBo().addAll(auVar.aBo());
            this.jlN.cwC().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jlO != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jlO;
                    if (page == null || page.aBk() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jlO.setData(auVar.aBn());
                } else {
                    if (auVar.aBo().size() < this.jlQ) {
                        this.jlO.setHasMore(false);
                    } else {
                        this.jlO.setHasMore(true);
                    }
                    this.jlO.setData(auVar.aBo());
                }
                this.jlO.ro(false);
                this.jlO.bgK();
                this.jlO.notifyDataSetChanged();
                return;
            }
            this.jlO.setHasMore(false);
            this.jlO.setData(new ArrayList<>());
            this.jlO.ro(false);
            this.jlO.bgK();
            this.jlO.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cwA() != null && this.jlN != null) {
            if (this.mPageType == 0) {
                if (this.jlN.cwC().aBn().size() == 0) {
                    if (this.jlP != null && this.jlP.aBn().size() > 0) {
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
            } else if (this.jlN.cwC().aBo().size() == 0) {
                if (this.jlP != null && this.jlP.aBo().size() > 0) {
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
            cwA().cj(this.jlN.cwC().aBp(), this.jlN.cwC().aBq());
        }
    }
}
