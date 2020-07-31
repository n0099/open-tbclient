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
import com.baidu.tbadk.core.data.au;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView UL = null;
    private d kTE = null;
    private View kRT = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.g mPullView = null;
    private PersonFriendModel kTD = null;
    private int mPageType = 0;
    int jTG = 0;
    private boolean mIsHost = true;
    private ba kTF = null;
    private boolean fsP = true;
    private boolean kLb = false;
    private int pageNum = 0;
    private int kTG = 20;
    private final CustomMessageListener kTH = new CustomMessageListener(CmdConfigCustom.CMD_QUERY_PERSON_FRIEND_LOCAL_HISTORY) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ba personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.cWZ() != null) {
                    PersonFriendFragment.this.kTF = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener kTI = new HttpMessageListener(1002001) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.kLb = false;
                if (PersonFriendFragment.this.cWZ() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.cWZ().getUniqueId()) {
                    PersonFriendFragment.this.UL.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity cWZ() {
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
        if (cWZ() != null) {
            this.kTD = cWZ().cWY();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.kTE != null) {
            this.kTE.cXa();
            this.kTE = null;
        }
        MessageManager.getInstance().unRegisterListener(this.kTI);
        MessageManager.getInstance().unRegisterListener(this.kTH);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.kTI);
        registerListener(this.kTH);
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
            this.mNoDataView.bbU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.kTE != null) {
            this.kTE.cXa();
            this.kTE = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.kTE = new d(cWZ(), cWZ().cwL(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.jTG = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.cGM();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.kLb) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kTD.cXb().getPage().aUZ() + 1;
                    PersonFriendFragment.this.kLb = true;
                    PersonFriendFragment.this.cGL();
                }
            }
        });
        this.UL = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.UL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.kTE != null && PersonFriendFragment.this.kTE.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.kTE.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonFriendFragment.this.cWZ().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.UL.setAdapter((ListAdapter) this.kTE);
        this.mPullView = new com.baidu.tbadk.core.view.g(cWZ().getPageContext());
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (PersonFriendFragment.this.cWZ() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fsP = true;
                    PersonFriendFragment.this.kTD.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.cWZ().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.kTG);
                }
            }
        });
        this.UL.setPullRefresh(this.mPullView);
        this.mIsHost = cWZ().cwL();
        if (cWZ() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), cWZ().cwK());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.yn(str), null);
        this.kRT = inflate.findViewById(R.id.friend_fragment_parent);
        this.UL.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.kLb) {
                    PersonFriendFragment.this.fsP = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.kTD.cXb().getPage().aUZ() + 1;
                    PersonFriendFragment.this.kLb = true;
                    PersonFriendFragment.this.cGL();
                }
            }
        });
        if (cWZ() != null) {
            this.kTD = cWZ().cWY();
            if (this.mIsHost) {
                cWy();
            }
        }
        if (this.mPageType == cWZ().cwJ()) {
            this.pageNum = 0;
            this.UL.startPullRefresh();
        }
        return inflate;
    }

    public void cWy() {
        if (this.kTD != null) {
            this.kTD.cWy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGL() {
        if (this.kTE != null) {
            this.kTE.tQ(true);
            this.kTE.notifyDataSetChanged();
        }
        this.pageNum = this.kTD.cXb().getPage().aUZ() + 1;
        this.kTD.a(this.mIsHost, this.kTD.getId(), this.pageNum, this.kTG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGM() {
        UserData userData;
        if (this.kTE != null && this.kTE.getItemViewType(this.jTG) == 0 && (userData = (UserData) this.kTE.getItem(this.jTG)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(cWZ().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(cWZ().getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.kRT != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.kRT);
            }
            if (this.mNoDataView != null) {
                ao.setBackgroundResource(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.changeSkin(i);
            }
        }
    }

    public void a(ba baVar, boolean z) {
        ba baVar2;
        if (baVar != null) {
            this.UL.completePullRefreshPostDelayed(0L);
            if (this.kTD != null && cWZ() != null) {
                if (!z) {
                    if (this.fsP) {
                        this.fsP = false;
                        if (this.mPageType == cWZ().cwJ()) {
                            this.kTD.d(baVar);
                            baVar2 = baVar;
                        }
                    } else {
                        if (this.mPageType == cWZ().cwJ()) {
                            a(baVar);
                        }
                        baVar2 = this.kTD.cXb();
                    }
                    this.kTF = baVar2;
                    b(baVar2);
                    c(baVar);
                }
                baVar2 = baVar;
                this.kTF = baVar2;
                b(baVar2);
                c(baVar);
            }
        }
    }

    public void a(ba baVar) {
        if (baVar != null && this.kTD != null) {
            this.kTD.cXb().aVe().addAll(baVar.aVe());
            this.kTD.cXb().aVf().addAll(baVar.aVf());
            this.kTD.cXb().setPage(baVar.getPage());
        }
    }

    private void b(ba baVar) {
        boolean z = true;
        if (this.kTE != null) {
            if (baVar != null) {
                au page = baVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.kTE;
                    if (page == null || page.aVb() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.kTE.setData(baVar.aVe());
                } else {
                    if (baVar.aVf().size() < this.kTG) {
                        this.kTE.setHasMore(false);
                    } else {
                        this.kTE.setHasMore(true);
                    }
                    this.kTE.setData(baVar.aVf());
                }
                this.kTE.tQ(false);
                this.kTE.bCi();
                this.kTE.notifyDataSetChanged();
                return;
            }
            this.kTE.setHasMore(false);
            this.kTE.setData(new ArrayList<>());
            this.kTE.tQ(false);
            this.kTE.bCi();
            this.kTE.notifyDataSetChanged();
        }
    }

    private void c(ba baVar) {
        if (cWZ() != null && this.kTD != null) {
            if (this.mPageType == 0) {
                if (this.kTD.cXb().aVe().size() == 0) {
                    if (this.kTF != null && this.kTF.aVe().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.UL.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.UL.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.UL.setVisibility(0);
                }
            } else if (this.kTD.cXb().aVf().size() == 0) {
                if (this.kTF != null && this.kTF.aVf().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.UL.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.UL.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.UL.setVisibility(0);
            }
            cWZ().cE(this.kTD.cXb().aVg(), this.kTD.cXb().aVh());
        }
    }
}
