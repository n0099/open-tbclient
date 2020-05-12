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
    public BdListView Ua = null;
    private d jXG = null;
    private View jVV = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.h mPullView = null;
    private PersonFriendModel jXF = null;
    private int mPageType = 0;
    int jdI = 0;
    private boolean mIsHost = true;
    private au jXH = null;
    private boolean ePD = true;
    private boolean jPo = false;
    private int pageNum = 0;
    private int jXI = 20;
    private final CustomMessageListener jXJ = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                au personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cHC() != null) {
                    PersonFriendFragment.this.jXH = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener jXK = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.jPo = false;
                if (PersonFriendFragment.this.cHC() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cHC().getUniqueId()) {
                    PersonFriendFragment.this.Ua.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cHC() {
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
        if (cHC() != null) {
            this.jXF = cHC().cHB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.jXG != null) {
            this.jXG.cHD();
            this.jXG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.jXK);
        MessageManager.getInstance().unRegisterListener(this.jXJ);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.jXK);
        registerListener(this.jXJ);
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
            this.mNoDataView.aPV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.jXG != null) {
            this.jXG.cHD();
            this.jXG = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.jXG = new d(cHC(), cHC().cin(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jdI = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.csn();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.jPo) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jXF.cHE().getPage().aJw() + 1;
                    PersonFriendFragment.this.jPo = true;
                    PersonFriendFragment.this.csm();
                }
            }
        });
        this.Ua = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.Ua.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.jXG != null && PersonFriendFragment.this.jXG.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.jXG.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cHC().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Ua.setAdapter((ListAdapter) this.jXG);
        this.mPullView = new com.baidu.tbadk.core.view.h(cHC().getPageContext());
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cHC() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ePD = true;
                    PersonFriendFragment.this.jXF.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cHC().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.jXI);
                }
            }
        });
        this.Ua.setPullRefresh(this.mPullView);
        this.mIsHost = cHC().cin();
        if (cHC() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cHC().cim());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.vl(str), null);
        this.jVV = inflate.findViewById(R.id.friend_fragment_parent);
        this.Ua.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.jPo) {
                    PersonFriendFragment.this.ePD = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.jXF.cHE().getPage().aJw() + 1;
                    PersonFriendFragment.this.jPo = true;
                    PersonFriendFragment.this.csm();
                }
            }
        });
        if (cHC() != null) {
            this.jXF = cHC().cHB();
            if (this.mIsHost) {
                cHb();
            }
        }
        if (this.mPageType == cHC().cil()) {
            this.pageNum = 0;
            this.Ua.startPullRefresh();
        }
        return inflate;
    }

    public void cHb() {
        if (this.jXF != null) {
            this.jXF.cHb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csm() {
        if (this.jXG != null) {
            this.jXG.sy(true);
            this.jXG.notifyDataSetChanged();
        }
        this.pageNum = this.jXF.cHE().getPage().aJw() + 1;
        this.jXF.a(this.mIsHost, this.jXF.getId(), this.pageNum, this.jXI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        UserData userData;
        if (this.jXG != null && this.jXG.getItemViewType(this.jdI) == 0 && (userData = (UserData) this.jXG.getItem(this.jdI)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cHC().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cHC().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.jVV != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.jVV);
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
            this.Ua.completePullRefreshPostDelayed(0L);
            if (this.jXF != null && cHC() != null) {
                if (!z) {
                    if (this.ePD) {
                        this.ePD = false;
                        if (this.mPageType == cHC().cil()) {
                            this.jXF.d(auVar);
                            auVar2 = auVar;
                        }
                    } else {
                        if (this.mPageType == cHC().cil()) {
                            a(auVar);
                        }
                        auVar2 = this.jXF.cHE();
                    }
                    this.jXH = auVar2;
                    b(auVar2);
                    c(auVar);
                }
                auVar2 = auVar;
                this.jXH = auVar2;
                b(auVar2);
                c(auVar);
            }
        }
    }

    public void a(au auVar) {
        if (auVar != null && this.jXF != null) {
            this.jXF.cHE().aJB().addAll(auVar.aJB());
            this.jXF.cHE().aJC().addAll(auVar.aJC());
            this.jXF.cHE().setPage(auVar.getPage());
        }
    }

    private void b(au auVar) {
        boolean z = true;
        if (this.jXG != null) {
            if (auVar != null) {
                ap page = auVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.jXG;
                    if (page == null || page.aJy() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.jXG.setData(auVar.aJB());
                } else {
                    if (auVar.aJC().size() < this.jXI) {
                        this.jXG.setHasMore(false);
                    } else {
                        this.jXG.setHasMore(true);
                    }
                    this.jXG.setData(auVar.aJC());
                }
                this.jXG.sy(false);
                this.jXG.bqe();
                this.jXG.notifyDataSetChanged();
                return;
            }
            this.jXG.setHasMore(false);
            this.jXG.setData(new ArrayList<>());
            this.jXG.sy(false);
            this.jXG.bqe();
            this.jXG.notifyDataSetChanged();
        }
    }

    private void c(au auVar) {
        if (cHC() != null && this.jXF != null) {
            if (this.mPageType == 0) {
                if (this.jXF.cHE().aJB().size() == 0) {
                    if (this.jXH != null && this.jXH.aJB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Ua.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Ua.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Ua.setVisibility(0);
                }
            } else if (this.jXF.cHE().aJC().size() == 0) {
                if (this.jXH != null && this.jXH.aJC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Ua.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Ua.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Ua.setVisibility(0);
            }
            cHC().cq(this.jXF.cHE().aJD(), this.jXF.cHE().aJE());
        }
    }
}
