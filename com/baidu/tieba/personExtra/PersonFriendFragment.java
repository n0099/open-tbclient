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
    public BdListView VX = null;
    private d lHM = null;
    private View lGa = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel lHL = null;
    private int mPageType = 0;
    int kGW = 0;
    private boolean mIsHost = true;
    private bb lHN = null;
    private boolean fTJ = true;
    private boolean lzi = false;
    private int pageNum = 0;
    private int lHO = 20;
    private final CustomMessageListener lHP = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                bb personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.dpn() != null) {
                    PersonFriendFragment.this.lHN = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener lHQ = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.lzi = false;
                if (PersonFriendFragment.this.dpn() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.dpn().getUniqueId()) {
                    PersonFriendFragment.this.VX.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity dpn() {
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
        if (dpn() != null) {
            this.lHL = dpn().dpm();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.lHM != null) {
            this.lHM.dpo();
            this.lHM = null;
        }
        MessageManager.getInstance().unRegisterListener(this.lHQ);
        MessageManager.getInstance().unRegisterListener(this.lHP);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.lHQ);
        registerListener(this.lHP);
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
            this.mNoDataView.bnV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.lHM != null) {
            this.lHM.dpo();
            this.lHM = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.lHM = new d(dpn(), dpn().SR(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.kGW = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cYR();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.lzi) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lHL.dpp().getPage().bgV() + 1;
                    PersonFriendFragment.this.lzi = true;
                    PersonFriendFragment.this.cYQ();
                }
            }
        });
        this.VX = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.VX.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.lHM != null && PersonFriendFragment.this.lHM.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.lHM.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.dpn().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.VX.setAdapter((ListAdapter) this.lHM);
        this.mPullView = new com.baidu.tbadk.core.view.g(dpn().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.dpn() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fTJ = true;
                    PersonFriendFragment.this.lHL.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.dpn().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.lHO);
                }
            }
        });
        this.VX.setPullRefresh(this.mPullView);
        this.mIsHost = dpn().SR();
        if (dpn() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), dpn().cOR());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.BK(str), null);
        this.lGa = inflate.findViewById(R.id.friend_fragment_parent);
        this.VX.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.lzi) {
                    PersonFriendFragment.this.fTJ = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.lHL.dpp().getPage().bgV() + 1;
                    PersonFriendFragment.this.lzi = true;
                    PersonFriendFragment.this.cYQ();
                }
            }
        });
        if (dpn() != null) {
            this.lHL = dpn().dpm();
            if (this.mIsHost) {
                doL();
            }
        }
        if (this.mPageType == dpn().cOQ()) {
            this.pageNum = 0;
            this.VX.startPullRefresh();
        }
        return inflate;
    }

    public void doL() {
        if (this.lHL != null) {
            this.lHL.doL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYQ() {
        if (this.lHM != null) {
            this.lHM.vr(true);
            this.lHM.notifyDataSetChanged();
        }
        this.pageNum = this.lHL.dpp().getPage().bgV() + 1;
        this.lHL.a(this.mIsHost, this.lHL.getId(), this.pageNum, this.lHO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYR() {
        UserData userData;
        if (this.lHM != null && this.lHM.getItemViewType(this.kGW) == 0 && (userData = (UserData) this.lHM.getItem(this.kGW)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(dpn().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(dpn().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.lGa != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.lGa);
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
            this.VX.completePullRefreshPostDelayed(0L);
            if (this.lHL != null && dpn() != null) {
                if (!z) {
                    if (this.fTJ) {
                        this.fTJ = false;
                        if (this.mPageType == dpn().cOQ()) {
                            this.lHL.d(bbVar);
                            bbVar2 = bbVar;
                        }
                    } else {
                        if (this.mPageType == dpn().cOQ()) {
                            a(bbVar);
                        }
                        bbVar2 = this.lHL.dpp();
                    }
                    this.lHN = bbVar2;
                    b(bbVar2);
                    c(bbVar);
                }
                bbVar2 = bbVar;
                this.lHN = bbVar2;
                b(bbVar2);
                c(bbVar);
            }
        }
    }

    public void a(bb bbVar) {
        if (bbVar != null && this.lHL != null) {
            this.lHL.dpp().bha().addAll(bbVar.bha());
            this.lHL.dpp().bhb().addAll(bbVar.bhb());
            this.lHL.dpp().setPage(bbVar.getPage());
        }
    }

    private void b(bb bbVar) {
        boolean z = true;
        if (this.lHM != null) {
            if (bbVar != null) {
                av page = bbVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.lHM;
                    if (page == null || page.bgX() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.lHM.setData(bbVar.bha());
                } else {
                    if (bbVar.bhb().size() < this.lHO) {
                        this.lHM.setHasMore(false);
                    } else {
                        this.lHM.setHasMore(true);
                    }
                    this.lHM.setData(bbVar.bhb());
                }
                this.lHM.vr(false);
                this.lHM.bQe();
                this.lHM.notifyDataSetChanged();
                return;
            }
            this.lHM.setHasMore(false);
            this.lHM.setData(new ArrayList<>());
            this.lHM.vr(false);
            this.lHM.bQe();
            this.lHM.notifyDataSetChanged();
        }
    }

    private void c(bb bbVar) {
        if (dpn() != null && this.lHL != null) {
            if (this.mPageType == 0) {
                if (this.lHL.dpp().bha().size() == 0) {
                    if (this.lHN != null && this.lHN.bha().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.VX.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.VX.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.VX.setVisibility(0);
                }
            } else if (this.lHL.dpp().bhb().size() == 0) {
                if (this.lHN != null && this.lHN.bhb().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.VX.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.VX.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.VX.setVisibility(0);
            }
            dpn().cP(this.lHL.dpp().bhc(), this.lHL.dpp().bhd());
        }
    }
}
