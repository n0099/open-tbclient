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
    public BdListView MR = null;
    private d ihE = null;
    private View igm = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.i mPullView = null;
    private PersonFriendModel ihD = null;
    private int mPageType = 0;
    int hro = 0;
    private boolean mIsHost = true;
    private ar ihF = null;
    private boolean ihG = true;
    private boolean hZE = false;
    private int pageNum = 0;
    private int ihH = 20;
    private final CustomMessageListener ihI = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bZE() != null) {
                    PersonFriendFragment.this.ihF = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener ihJ = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.hZE = false;
                if (PersonFriendFragment.this.bZE() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bZE().getUniqueId()) {
                    PersonFriendFragment.this.MR.completePullRefreshPostDelayed(0L);
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
    public PersonFriendActivity bZE() {
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
        if (bZE() != null) {
            this.ihD = bZE().bZD();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.ihE != null) {
            this.ihE.bZF();
            this.ihE = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ihJ);
        MessageManager.getInstance().unRegisterListener(this.ihI);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.ihJ);
        registerListener(this.ihI);
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
        if (this.ihE != null) {
            this.ihE.bZF();
            this.ihE = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
        this.ihE = new d(bZE(), bZE().bDe(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.hro = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bMF();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.hZE) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihD.bZG().getPage().acn() + 1;
                    PersonFriendFragment.this.hZE = true;
                    PersonFriendFragment.this.bME();
                }
            }
        });
        this.MR = (BdListView) inflate.findViewById(R.id.my_friend_list);
        this.MR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.ihE != null && PersonFriendFragment.this.ihE.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.ihE.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bZE().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.MR.setAdapter((ListAdapter) this.ihE);
        this.mPullView = new com.baidu.tbadk.core.view.i(bZE().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (PersonFriendFragment.this.bZE() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.ihG = true;
                    PersonFriendFragment.this.ihD.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bZE().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.ihH);
                }
            }
        });
        this.MR.setPullRefresh(this.mPullView);
        this.mIsHost = bZE().bDe();
        if (bZE() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(R.string.person_friend_no_personal_info), getString(R.string.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(R.string.person_friend_no_personal_info), bZE().bDd());
        } else {
            str = getString(R.string.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.oy(str), null);
        this.igm = inflate.findViewById(R.id.friend_fragment_parent);
        this.MR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.hZE) {
                    PersonFriendFragment.this.ihG = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.ihD.bZG().getPage().acn() + 1;
                    PersonFriendFragment.this.hZE = true;
                    PersonFriendFragment.this.bME();
                }
            }
        });
        if (bZE() != null) {
            this.ihD = bZE().bZD();
            if (this.mIsHost) {
                bZg();
            }
        }
        if (this.mPageType == bZE().bDc()) {
            this.pageNum = 0;
            this.MR.startPullRefresh();
        }
        return inflate;
    }

    public void bZg() {
        if (this.ihD != null) {
            this.ihD.bZg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bME() {
        if (this.ihE != null) {
            this.ihE.pv(true);
            this.ihE.notifyDataSetChanged();
        }
        this.pageNum = this.ihD.bZG().getPage().acn() + 1;
        this.ihD.a(this.mIsHost, this.ihD.getId(), this.pageNum, this.ihH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMF() {
        UserData userData;
        if (this.ihE != null && this.ihE.getItemViewType(this.hro) == 0 && (userData = (UserData) this.ihE.getItem(this.hro)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bZE().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bZE().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.igm != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.igm);
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
            this.MR.completePullRefreshPostDelayed(0L);
            if (this.ihD != null && bZE() != null) {
                if (!z) {
                    if (this.ihG) {
                        this.ihG = false;
                        if (this.mPageType == bZE().bDc()) {
                            this.ihD.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == bZE().bDc()) {
                            a(arVar);
                        }
                        arVar2 = this.ihD.bZG();
                    }
                    this.ihF = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.ihF = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.ihD != null) {
            this.ihD.bZG().acs().addAll(arVar.acs());
            this.ihD.bZG().act().addAll(arVar.act());
            this.ihD.bZG().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.ihE != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    d dVar = this.ihE;
                    if (page == null || page.acp() != 1) {
                        z = false;
                    }
                    dVar.setHasMore(z);
                    this.ihE.setData(arVar.acs());
                } else {
                    if (arVar.act().size() < this.ihH) {
                        this.ihE.setHasMore(false);
                    } else {
                        this.ihE.setHasMore(true);
                    }
                    this.ihE.setData(arVar.act());
                }
                this.ihE.pv(false);
                this.ihE.bMC();
                this.ihE.notifyDataSetChanged();
                return;
            }
            this.ihE.setHasMore(false);
            this.ihE.setData(new ArrayList<>());
            this.ihE.pv(false);
            this.ihE.bMC();
            this.ihE.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (bZE() != null && this.ihD != null) {
            if (this.mPageType == 0) {
                if (this.ihD.bZG().acs().size() == 0) {
                    if (this.ihF != null && this.ihF.acs().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.MR.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.MR.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.MR.setVisibility(0);
                }
            } else if (this.ihD.bZG().act().size() == 0) {
                if (this.ihF != null && this.ihF.act().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.MR.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.MR.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.MR.setVisibility(0);
            }
            bZE().bT(this.ihD.bZG().acu(), this.ihD.bZG().acv());
        }
    }
}
