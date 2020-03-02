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
    private d jlC = null;
    private View jjR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jlB = null;
    private int mPageType = 0;
    int irN = 0;
    private boolean mIsHost = true;
    private au jlD = null;
    private boolean elv = true;
    private boolean jdu = false;
    private int pageNum = 0;
    private int jlE = 20;
    private final CustomMessageListener jlF = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cwz() != null) {
                    PersonFriendFragment.this.jlD = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jlG = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jdu = false;
                if (PersonFriendFragment.this.cwz() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cwz().getUniqueId()) {
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
    public PersonFriendActivity cwz() {
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
        if (cwz() != null) {
            this.jlB = cwz().cwy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jlC != null) {
            this.jlC.cwA();
            this.jlC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jlG);
        MessageManager.getInstance().unRegisterListener(this.jlF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jlG);
        registerListener(this.jlF);
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
            this.mNoDataView.aHB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jlC != null) {
            this.jlC.cwA();
            this.jlC = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jlC = new d(cwz(), cwz().bXu(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.irN = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.chn();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jdu) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlB.cwB().getPage().aBi() + 1;
                    PersonFriendFragment.this.jdu = true;
                    PersonFriendFragment.this.chm();
                }
            }
        });
        this.AG = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.AG.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jlC != null && PersonFriendFragment.this.jlC.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jlC.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cwz().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.AG.setAdapter((ListAdapter) this.jlC);
        this.mPullView = new com.baidu.tbadk.core.view.h(cwz().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cwz() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.elv = true;
                    PersonFriendFragment.this.jlB.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cwz().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jlE);
                }
            }
        });
        this.AG.setPullRefresh(this.mPullView);
        this.mIsHost = cwz().bXu();
        if (cwz() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cwz().bXt());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.tU(str), null);
        this.jjR = inflate.findViewById(R.id.friend_fragment_parent);
        this.AG.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jdu) {
                    PersonFriendFragment.this.elv = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jlB.cwB().getPage().aBi() + 1;
                    PersonFriendFragment.this.jdu = true;
                    PersonFriendFragment.this.chm();
                }
            }
        });
        if (cwz() != null) {
            this.jlB = cwz().cwy();
            if (this.mIsHost) {
                cvY();
            }
        }
        if (this.mPageType == cwz().bXs()) {
            this.pageNum = 0;
            this.AG.startPullRefresh();
        }
        return inflate;
    }

    public void cvY() {
        if (this.jlB != null) {
            this.jlB.cvY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chm() {
        if (this.jlC != null) {
            this.jlC.ro(true);
            this.jlC.notifyDataSetChanged();
        }
        this.pageNum = this.jlB.cwB().getPage().aBi() + 1;
        this.jlB.a(this.mIsHost, this.jlB.getId(), this.pageNum, this.jlE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        UserData userData;
        if (this.jlC != null && this.jlC.getItemViewType(this.irN) == 0 && (userData = (UserData) this.jlC.getItem(this.irN)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cwz().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cwz().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jjR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jjR);
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
            if (this.jlB != null && cwz() != null) {
                if (!z) {
                    if (this.elv) {
                        this.elv = false;
                        if (this.mPageType == cwz().bXs()) {
                            this.jlB.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cwz().bXs()) {
                            a(auVar);
                        }
                        auVar2 = this.jlB.cwB();
                    }
                    this.jlD = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jlD = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jlB != null) {
            this.jlB.cwB().aBn().addAll(auVar.aBn());
            this.jlB.cwB().aBo().addAll(auVar.aBo());
            this.jlB.cwB().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jlC != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jlC;
                    if (page == null || page.aBk() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jlC.setData(auVar.aBn());
                } else {
                    if (auVar.aBo().size() < this.jlE) {
                        this.jlC.setHasMore(false);
                    } else {
                        this.jlC.setHasMore(true);
                    }
                    this.jlC.setData(auVar.aBo());
                }
                this.jlC.ro(false);
                this.jlC.bgJ();
                this.jlC.notifyDataSetChanged();
                return;
            }
            this.jlC.setHasMore(false);
            this.jlC.setData(new ArrayList<>());
            this.jlC.ro(false);
            this.jlC.bgJ();
            this.jlC.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cwz() != null && this.jlB != null) {
            if (this.mPageType == 0) {
                if (this.jlB.cwB().aBn().size() == 0) {
                    if (this.jlD != null && this.jlD.aBn().size() > 0) {
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
            } else if (this.jlB.cwB().aBo().size() == 0) {
                if (this.jlD != null && this.jlD.aBo().size() > 0) {
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
            cwz().cj(this.jlB.cwB().aBp(), this.jlB.cwB().aBq());
        }
    }
}
