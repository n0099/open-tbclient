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
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView Pj = null;
    private c hPe = null;
    private View hNM = null;
    private NoDataView mNoDataView = null;
    private i mPullView = null;
    private PersonFriendModel hPd = null;
    private int mPageType = 0;
    int gZS = 0;
    private boolean mIsHost = true;
    private ar hPf = null;
    private boolean hPg = true;
    private boolean hHA = false;
    private int pageNum = 0;
    private int hPh = 20;
    private final CustomMessageListener hPi = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bRu() != null) {
                    PersonFriendFragment.this.hPf = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener hPj = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.hHA = false;
                if (PersonFriendFragment.this.bRu() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bRu().getUniqueId()) {
                    PersonFriendFragment.this.Pj.completePullRefreshPostDelayed(0L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bRu() {
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
        if (bRu() != null) {
            this.hPd = bRu().bRt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.hPe != null) {
            this.hPe.bRv();
            this.hPe = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hPj);
        MessageManager.getInstance().unRegisterListener(this.hPi);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.hPj);
        registerListener(this.hPi);
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
        if (this.hPe != null) {
            this.hPe.bRv();
            this.hPe = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.hPe = new c(bRu(), bRu().bvr(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.gZS = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bEQ();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.hHA) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.hPd.bRw().getPage().XF() + 1;
                    PersonFriendFragment.this.hHA = true;
                    PersonFriendFragment.this.bEP();
                }
            }
        });
        this.Pj = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.hPe != null && PersonFriendFragment.this.hPe.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.hPe.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bRu().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Pj.setAdapter((ListAdapter) this.hPe);
        this.mPullView = new i(bRu().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonFriendFragment.this.bRu() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.hPg = true;
                    PersonFriendFragment.this.hPd.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bRu().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.hPh);
                }
            }
        });
        this.Pj.setPullRefresh(this.mPullView);
        this.mIsHost = bRu().bvr();
        if (bRu() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.j.person_friend_no_personal_info), getString(d.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.j.person_friend_no_personal_info), bRu().bvq());
        } else {
            str = getString(d.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.np(str), null);
        this.hNM = inflate.findViewById(d.g.friend_fragment_parent);
        this.Pj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.hHA) {
                    PersonFriendFragment.this.hPg = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.hPd.bRw().getPage().XF() + 1;
                    PersonFriendFragment.this.hHA = true;
                    PersonFriendFragment.this.bEP();
                }
            }
        });
        if (bRu() != null) {
            this.hPd = bRu().bRt();
            if (this.mIsHost) {
                bRf();
            }
        }
        if (this.mPageType == bRu().bvp()) {
            this.pageNum = 0;
            this.Pj.startPullRefresh();
        }
        return inflate;
    }

    public void bRf() {
        if (this.hPd != null) {
            this.hPd.bRf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEP() {
        if (this.hPe != null) {
            this.hPe.oF(true);
            this.hPe.notifyDataSetChanged();
        }
        this.pageNum = this.hPd.bRw().getPage().XF() + 1;
        this.hPd.a(this.mIsHost, this.hPd.getId(), this.pageNum, this.hPh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        UserData userData;
        if (this.hPe != null && this.hPe.getItemViewType(this.gZS) == 0 && (userData = (UserData) this.hPe.getItem(this.gZS)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bRu().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bRu().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.hNM != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.hNM);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ib(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.Pj.completePullRefreshPostDelayed(0L);
            if (this.hPd != null && bRu() != null) {
                if (!z) {
                    if (this.hPg) {
                        this.hPg = false;
                        if (this.mPageType == bRu().bvp()) {
                            this.hPd.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == bRu().bvp()) {
                            a(arVar);
                        }
                        arVar2 = this.hPd.bRw();
                    }
                    this.hPf = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.hPf = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.hPd != null) {
            this.hPd.bRw().XK().addAll(arVar.XK());
            this.hPd.bRw().XL().addAll(arVar.XL());
            this.hPd.bRw().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.hPe != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    c cVar = this.hPe;
                    if (page == null || page.XH() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.hPe.setData(arVar.XK());
                } else {
                    if (arVar.XL().size() < this.hPh) {
                        this.hPe.setHasMore(false);
                    } else {
                        this.hPe.setHasMore(true);
                    }
                    this.hPe.setData(arVar.XL());
                }
                this.hPe.oF(false);
                this.hPe.bEN();
                this.hPe.notifyDataSetChanged();
                return;
            }
            this.hPe.setHasMore(false);
            this.hPe.setData(new ArrayList<>());
            this.hPe.oF(false);
            this.hPe.bEN();
            this.hPe.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (bRu() != null && this.hPd != null) {
            if (this.mPageType == 0) {
                if (this.hPd.bRw().XK().size() == 0) {
                    if (this.hPf != null && this.hPf.XK().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.Pj.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.Pj.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.Pj.setVisibility(0);
                }
            } else if (this.hPd.bRw().XL().size() == 0) {
                if (this.hPf != null && this.hPf.XL().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.Pj.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.Pj.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.Pj.setVisibility(0);
            }
            bRu().bM(this.hPd.bRw().XM(), this.hPd.bRw().XN());
        }
    }
}
