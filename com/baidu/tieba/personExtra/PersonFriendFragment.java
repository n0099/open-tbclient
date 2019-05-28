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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView MS = null;
    private d ihD = null;
    private View igl = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ihC = null;
    private int mPageType = 0;
    int hrn = 0;
    private boolean mIsHost = true;
    private ar ihE = null;
    private boolean ihF = true;
    private boolean hZD = false;
    private int pageNum = 0;
    private int ihG = 20;
    private final CustomMessageListener ihH = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bZD() != null) {
                    PersonFriendFragment.this.ihE = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ihI = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.hZD = false;
                if (PersonFriendFragment.this.bZD() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bZD().getUniqueId()) {
                    PersonFriendFragment.this.MS.completePullRefreshPostDelayed(0L);
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
        com.baidu.tieba.tbadkCore.a.a.b(2001182, g.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bZD() {
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
        if (bZD() != null) {
            this.ihC = bZD().bZC();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ihD != null) {
            this.ihD.bZE();
            this.ihD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihI);
        MessageManager.getInstance().unRegisterListener(this.ihH);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ihI);
        registerListener(this.ihH);
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
            this.mNoDataView.onActivityStop();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ihD != null) {
            this.ihD.bZE();
            this.ihD = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ihD = new d(bZD(), bZD().bDd(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hrn = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bME();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.hZD) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihC.bZF().getPage().acn() + 1;
                    PersonFriendFragment.this.hZD = true;
                    PersonFriendFragment.this.bMD();
                }
            }
        });
        this.MS = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ihD != null && PersonFriendFragment.this.ihD.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ihD.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bZD().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.MS.setAdapter((ListAdapter) this.ihD);
        this.mPullView = new com.baidu.tbadk.core.view.i(bZD().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonFriendFragment.this.bZD() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ihF = true;
                    PersonFriendFragment.this.ihC.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bZD().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ihG);
                }
            }
        });
        this.MS.setPullRefresh(this.mPullView);
        this.mIsHost = bZD().bDd();
        if (bZD() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), bZD().bDc());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oz(str), null);
        this.igl = inflate.findViewById(R.id.friend_fragment_parent);
        this.MS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.hZD) {
                    PersonFriendFragment.this.ihF = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihC.bZF().getPage().acn() + 1;
                    PersonFriendFragment.this.hZD = true;
                    PersonFriendFragment.this.bMD();
                }
            }
        });
        if (bZD() != null) {
            this.ihC = bZD().bZC();
            if (this.mIsHost) {
                bZf();
            }
        }
        if (this.mPageType == bZD().bDb()) {
            this.pageNum = 0;
            this.MS.startPullRefresh();
        }
        return inflate;
    }

    public void bZf() {
        if (this.ihC != null) {
            this.ihC.bZf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMD() {
        if (this.ihD != null) {
            this.ihD.pu(true);
            this.ihD.notifyDataSetChanged();
        }
        this.pageNum = this.ihC.bZF().getPage().acn() + 1;
        this.ihC.a(this.mIsHost, this.ihC.getId(), this.pageNum, this.ihG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        UserData userData;
        if (this.ihD != null && this.ihD.getItemViewType(this.hrn) == 0 && (userData = (UserData) this.ihD.getItem(this.hrn)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bZD().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bZD().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igl != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igl);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, R.color.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.iP(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.MS.completePullRefreshPostDelayed(0L);
            if (this.ihC != null && bZD() != null) {
                if (!z) {
                    if (this.ihF) {
                        this.ihF = false;
                        if (this.mPageType == bZD().bDb()) {
                            this.ihC.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == bZD().bDb()) {
                            a(arVar);
                        }
                        arVar2 = this.ihC.bZF();
                    }
                    this.ihE = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ihE = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ihC != null) {
            this.ihC.bZF().acs().addAll(arVar.acs());
            this.ihC.bZF().act().addAll(arVar.act());
            this.ihC.bZF().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ihD != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ihD;
                    if (page == null || page.acp() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ihD.setData(arVar.acs());
                } else {
                    if (arVar.act().size() < this.ihG) {
                        this.ihD.setHasMore(false);
                    } else {
                        this.ihD.setHasMore(true);
                    }
                    this.ihD.setData(arVar.act());
                }
                this.ihD.pu(false);
                this.ihD.bMB();
                this.ihD.notifyDataSetChanged();
                return;
            }
            this.ihD.setHasMore(false);
            this.ihD.setData(new ArrayList<>());
            this.ihD.pu(false);
            this.ihD.bMB();
            this.ihD.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (bZD() != null && this.ihC != null) {
            if (this.mPageType == 0) {
                if (this.ihC.bZF().acs().size() == 0) {
                    if (this.ihE != null && this.ihE.acs().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.MS.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.MS.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.MS.setVisibility(0);
                }
            } else if (this.ihC.bZF().act().size() == 0) {
                if (this.ihE != null && this.ihE.act().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.MS.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.MS.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.MS.setVisibility(0);
            }
            bZD().bT(this.ihC.bZF().acu(), this.ihC.bZF().acv());
        }
    }
}
