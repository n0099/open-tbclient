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
    private d ihA = null;
    private View igi = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ihz = null;
    private int mPageType = 0;
    int hrk = 0;
    private boolean mIsHost = true;
    private ar ihB = null;
    private boolean ihC = true;
    private boolean hZA = false;
    private int pageNum = 0;
    private int ihD = 20;
    private final CustomMessageListener ihE = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bZA() != null) {
                    PersonFriendFragment.this.ihB = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ihF = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.hZA = false;
                if (PersonFriendFragment.this.bZA() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bZA().getUniqueId()) {
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
    public PersonFriendActivity bZA() {
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
        if (bZA() != null) {
            this.ihz = bZA().bZz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ihA != null) {
            this.ihA.bZB();
            this.ihA = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihF);
        MessageManager.getInstance().unRegisterListener(this.ihE);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ihF);
        registerListener(this.ihE);
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
        if (this.ihA != null) {
            this.ihA.bZB();
            this.ihA = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ihA = new d(bZA(), bZA().bDa(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hrk = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bMB();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.hZA) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihz.bZC().getPage().acn() + 1;
                    PersonFriendFragment.this.hZA = true;
                    PersonFriendFragment.this.bMA();
                }
            }
        });
        this.MS = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ihA != null && PersonFriendFragment.this.ihA.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ihA.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bZA().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.MS.setAdapter((ListAdapter) this.ihA);
        this.mPullView = new com.baidu.tbadk.core.view.i(bZA().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonFriendFragment.this.bZA() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ihC = true;
                    PersonFriendFragment.this.ihz.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bZA().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ihD);
                }
            }
        });
        this.MS.setPullRefresh(this.mPullView);
        this.mIsHost = bZA().bDa();
        if (bZA() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), bZA().bCZ());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oz(str), null);
        this.igi = inflate.findViewById(R.id.friend_fragment_parent);
        this.MS.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.hZA) {
                    PersonFriendFragment.this.ihC = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihz.bZC().getPage().acn() + 1;
                    PersonFriendFragment.this.hZA = true;
                    PersonFriendFragment.this.bMA();
                }
            }
        });
        if (bZA() != null) {
            this.ihz = bZA().bZz();
            if (this.mIsHost) {
                bZc();
            }
        }
        if (this.mPageType == bZA().bCY()) {
            this.pageNum = 0;
            this.MS.startPullRefresh();
        }
        return inflate;
    }

    public void bZc() {
        if (this.ihz != null) {
            this.ihz.bZc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        if (this.ihA != null) {
            this.ihA.pu(true);
            this.ihA.notifyDataSetChanged();
        }
        this.pageNum = this.ihz.bZC().getPage().acn() + 1;
        this.ihz.a(this.mIsHost, this.ihz.getId(), this.pageNum, this.ihD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        UserData userData;
        if (this.ihA != null && this.ihA.getItemViewType(this.hrk) == 0 && (userData = (UserData) this.ihA.getItem(this.hrk)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bZA().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bZA().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igi != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igi);
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
            if (this.ihz != null && bZA() != null) {
                if (!z) {
                    if (this.ihC) {
                        this.ihC = false;
                        if (this.mPageType == bZA().bCY()) {
                            this.ihz.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == bZA().bCY()) {
                            a(arVar);
                        }
                        arVar2 = this.ihz.bZC();
                    }
                    this.ihB = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ihB = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ihz != null) {
            this.ihz.bZC().acs().addAll(arVar.acs());
            this.ihz.bZC().act().addAll(arVar.act());
            this.ihz.bZC().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ihA != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ihA;
                    if (page == null || page.acp() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ihA.setData(arVar.acs());
                } else {
                    if (arVar.act().size() < this.ihD) {
                        this.ihA.setHasMore(false);
                    } else {
                        this.ihA.setHasMore(true);
                    }
                    this.ihA.setData(arVar.act());
                }
                this.ihA.pu(false);
                this.ihA.bMy();
                this.ihA.notifyDataSetChanged();
                return;
            }
            this.ihA.setHasMore(false);
            this.ihA.setData(new ArrayList<>());
            this.ihA.pu(false);
            this.ihA.bMy();
            this.ihA.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (bZA() != null && this.ihz != null) {
            if (this.mPageType == 0) {
                if (this.ihz.bZC().acs().size() == 0) {
                    if (this.ihB != null && this.ihB.acs().size() > 0) {
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
            } else if (this.ihz.bZC().act().size() == 0) {
                if (this.ihB != null && this.ihB.act().size() > 0) {
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
            bZA().bT(this.ihz.bZC().acu(), this.ihz.bZC().acv());
        }
    }
}
