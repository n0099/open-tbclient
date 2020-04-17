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
    public BdListView TX = null;
    private d jXC = null;
    private View jVR = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jXB = null;
    private int mPageType = 0;
    int jdE = 0;
    private boolean mIsHost = true;
    private au jXD = null;
    private boolean ePy = true;
    private boolean jPk = false;
    private int pageNum = 0;
    private int jXE = 20;
    private final CustomMessageListener jXF = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cHE() != null) {
                    PersonFriendFragment.this.jXD = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jXG = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jPk = false;
                if (PersonFriendFragment.this.cHE() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cHE().getUniqueId()) {
                    PersonFriendFragment.this.TX.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cHE() {
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
        if (cHE() != null) {
            this.jXB = cHE().cHD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jXC != null) {
            this.jXC.cHF();
            this.jXC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jXG);
        MessageManager.getInstance().unRegisterListener(this.jXF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jXG);
        registerListener(this.jXF);
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
            this.mNoDataView.aPY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jXC != null) {
            this.jXC.cHF();
            this.jXC = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jXC = new d(cHE(), cHE().cio(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jdE = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.csp();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jPk) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jXB.cHG().getPage().aJy() + 1;
                    PersonFriendFragment.this.jPk = true;
                    PersonFriendFragment.this.cso();
                }
            }
        });
        this.TX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.TX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jXC != null && PersonFriendFragment.this.jXC.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jXC.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cHE().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.TX.setAdapter((ListAdapter) this.jXC);
        this.mPullView = new com.baidu.tbadk.core.view.h(cHE().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cHE() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ePy = true;
                    PersonFriendFragment.this.jXB.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cHE().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jXE);
                }
            }
        });
        this.TX.setPullRefresh(this.mPullView);
        this.mIsHost = cHE().cio();
        if (cHE() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cHE().cin());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.vi(str), null);
        this.jVR = inflate.findViewById(R.id.friend_fragment_parent);
        this.TX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jPk) {
                    PersonFriendFragment.this.ePy = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jXB.cHG().getPage().aJy() + 1;
                    PersonFriendFragment.this.jPk = true;
                    PersonFriendFragment.this.cso();
                }
            }
        });
        if (cHE() != null) {
            this.jXB = cHE().cHD();
            if (this.mIsHost) {
                cHd();
            }
        }
        if (this.mPageType == cHE().cim()) {
            this.pageNum = 0;
            this.TX.startPullRefresh();
        }
        return inflate;
    }

    public void cHd() {
        if (this.jXB != null) {
            this.jXB.cHd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cso() {
        if (this.jXC != null) {
            this.jXC.sy(true);
            this.jXC.notifyDataSetChanged();
        }
        this.pageNum = this.jXB.cHG().getPage().aJy() + 1;
        this.jXB.a(this.mIsHost, this.jXB.getId(), this.pageNum, this.jXE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csp() {
        UserData userData;
        if (this.jXC != null && this.jXC.getItemViewType(this.jdE) == 0 && (userData = (UserData) this.jXC.getItem(this.jdE)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cHE().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cHE().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jVR != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jVR);
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
            this.TX.completePullRefreshPostDelayed(0L);
            if (this.jXB != null && cHE() != null) {
                if (!z) {
                    if (this.ePy) {
                        this.ePy = false;
                        if (this.mPageType == cHE().cim()) {
                            this.jXB.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cHE().cim()) {
                            a(auVar);
                        }
                        auVar2 = this.jXB.cHG();
                    }
                    this.jXD = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jXD = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jXB != null) {
            this.jXB.cHG().aJD().addAll(auVar.aJD());
            this.jXB.cHG().aJE().addAll(auVar.aJE());
            this.jXB.cHG().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jXC != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jXC;
                    if (page == null || page.aJA() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jXC.setData(auVar.aJD());
                } else {
                    if (auVar.aJE().size() < this.jXE) {
                        this.jXC.setHasMore(false);
                    } else {
                        this.jXC.setHasMore(true);
                    }
                    this.jXC.setData(auVar.aJE());
                }
                this.jXC.sy(false);
                this.jXC.bqg();
                this.jXC.notifyDataSetChanged();
                return;
            }
            this.jXC.setHasMore(false);
            this.jXC.setData(new ArrayList<>());
            this.jXC.sy(false);
            this.jXC.bqg();
            this.jXC.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cHE() != null && this.jXB != null) {
            if (this.mPageType == 0) {
                if (this.jXB.cHG().aJD().size() == 0) {
                    if (this.jXD != null && this.jXD.aJD().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.TX.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.TX.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.TX.setVisibility(0);
                }
            } else if (this.jXB.cHG().aJE().size() == 0) {
                if (this.jXD != null && this.jXD.aJE().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.TX.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.TX.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.TX.setVisibility(0);
            }
            cHE().cq(this.jXB.cHG().aJF(), this.jXB.cHG().aJG());
        }
    }
}
