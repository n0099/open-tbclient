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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView US = null;
    private d kKD = null;
    private View kIS = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel kKC = null;
    private int mPageType = 0;
    int jLi = 0;
    private boolean mIsHost = true;
    private az kKE = null;
    private boolean fnG = true;
    private boolean kBZ = false;
    private int pageNum = 0;
    private int kKF = 20;
    private final CustomMessageListener kKG = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                az personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cTj() != null) {
                    PersonFriendFragment.this.kKE = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener kKH = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.kBZ = false;
                if (PersonFriendFragment.this.cTj() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cTj().getUniqueId()) {
                    PersonFriendFragment.this.US.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cTj() {
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
        if (cTj() != null) {
            this.kKC = cTj().cTi();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kKD != null) {
            this.kKD.cTk();
            this.kKD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kKH);
        MessageManager.getInstance().unRegisterListener(this.kKG);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kKH);
        registerListener(this.kKG);
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
            this.mNoDataView.aXU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kKD != null) {
            this.kKD.cTk();
            this.kKD = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.kKD = new d(cTj(), cTj().csJ(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jLi = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cDe();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.kBZ) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kKC.cTl().getPage().aRd() + 1;
                    PersonFriendFragment.this.kBZ = true;
                    PersonFriendFragment.this.cDd();
                }
            }
        });
        this.US = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.US.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.kKD != null && PersonFriendFragment.this.kKD.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.kKD.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cTj().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.US.setAdapter((ListAdapter) this.kKD);
        this.mPullView = new com.baidu.tbadk.core.view.g(cTj().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cTj() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fnG = true;
                    PersonFriendFragment.this.kKC.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cTj().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.kKF);
                }
            }
        });
        this.US.setPullRefresh(this.mPullView);
        this.mIsHost = cTj().csJ();
        if (cTj() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cTj().csI());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.xi(str), null);
        this.kIS = inflate.findViewById(R.id.friend_fragment_parent);
        this.US.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.kBZ) {
                    PersonFriendFragment.this.fnG = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kKC.cTl().getPage().aRd() + 1;
                    PersonFriendFragment.this.kBZ = true;
                    PersonFriendFragment.this.cDd();
                }
            }
        });
        if (cTj() != null) {
            this.kKC = cTj().cTi();
            if (this.mIsHost) {
                cSI();
            }
        }
        if (this.mPageType == cTj().csH()) {
            this.pageNum = 0;
            this.US.startPullRefresh();
        }
        return inflate;
    }

    public void cSI() {
        if (this.kKC != null) {
            this.kKC.cSI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDd() {
        if (this.kKD != null) {
            this.kKD.tk(true);
            this.kKD.notifyDataSetChanged();
        }
        this.pageNum = this.kKC.cTl().getPage().aRd() + 1;
        this.kKC.a(this.mIsHost, this.kKC.getId(), this.pageNum, this.kKF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDe() {
        UserData userData;
        if (this.kKD != null && this.kKD.getItemViewType(this.jLi) == 0 && (userData = (UserData) this.kKD.getItem(this.jLi)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cTj().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cTj().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kIS != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.kIS);
            }
            if (this.mNoDataView != null) {
                an.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(az azVar, boolean z) {
        az azVar2;
        if (azVar != null) {
            this.US.completePullRefreshPostDelayed(0L);
            if (this.kKC != null && cTj() != null) {
                if (!z) {
                    if (this.fnG) {
                        this.fnG = false;
                        if (this.mPageType == cTj().csH()) {
                            this.kKC.d(azVar);
                            azVar2 = azVar;
                        }
                    } else {
                        if (this.mPageType == cTj().csH()) {
                            a(azVar);
                        }
                        azVar2 = this.kKC.cTl();
                    }
                    this.kKE = azVar2;
                    b(azVar2);
                    c(azVar);
                }
                azVar2 = azVar;
                this.kKE = azVar2;
                b(azVar2);
                c(azVar);
            }
        }
    }

    public void a(az azVar) {
        if (azVar != null && this.kKC != null) {
            this.kKC.cTl().aRi().addAll(azVar.aRi());
            this.kKC.cTl().aRj().addAll(azVar.aRj());
            this.kKC.cTl().setPage(azVar.getPage());
        }
    }

    private void b(az azVar) {
        boolean z = true;
        if (this.kKD != null) {
            if (azVar != null) {
                at page = azVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.kKD;
                    if (page == null || page.aRf() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.kKD.setData(azVar.aRi());
                } else {
                    if (azVar.aRj().size() < this.kKF) {
                        this.kKD.setHasMore(false);
                    } else {
                        this.kKD.setHasMore(true);
                    }
                    this.kKD.setData(azVar.aRj());
                }
                this.kKD.tk(false);
                this.kKD.byU();
                this.kKD.notifyDataSetChanged();
                return;
            }
            this.kKD.setHasMore(false);
            this.kKD.setData(new ArrayList<>());
            this.kKD.tk(false);
            this.kKD.byU();
            this.kKD.notifyDataSetChanged();
        }
    }

    private void c(az azVar) {
        if (cTj() != null && this.kKC != null) {
            if (this.mPageType == 0) {
                if (this.kKC.cTl().aRi().size() == 0) {
                    if (this.kKE != null && this.kKE.aRi().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.US.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.US.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.US.setVisibility(0);
                }
            } else if (this.kKC.cTl().aRj().size() == 0) {
                if (this.kKE != null && this.kKE.aRj().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.US.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.US.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.US.setVisibility(0);
            }
            cTj().cB(this.kKC.cTl().aRk(), this.kKC.cTl().aRl());
        }
    }
}
