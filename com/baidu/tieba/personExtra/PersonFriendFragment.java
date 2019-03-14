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
    private c hPs = null;
    private View hOa = null;
    private NoDataView mNoDataView = null;
    private i mPullView = null;
    private PersonFriendModel hPr = null;
    private int mPageType = 0;
    int haf = 0;
    private boolean mIsHost = true;
    private ar hPt = null;
    private boolean hPu = true;
    private boolean hHO = false;
    private int pageNum = 0;
    private int hPv = 20;
    private final CustomMessageListener hPw = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                ar personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.bRy() != null) {
                    PersonFriendFragment.this.hPt = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener hPx = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.hHO = false;
                if (PersonFriendFragment.this.bRy() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.bRy().getUniqueId()) {
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
    public PersonFriendActivity bRy() {
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
        if (bRy() != null) {
            this.hPr = bRy().bRx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.hPs != null) {
            this.hPs.bRz();
            this.hPs = null;
        }
        MessageManager.getInstance().unRegisterListener(this.hPx);
        MessageManager.getInstance().unRegisterListener(this.hPw);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.hPx);
        registerListener(this.hPw);
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
        if (this.hPs != null) {
            this.hPs.bRz();
            this.hPs = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.hPs = new c(bRy(), bRy().bvu(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonFriendFragment.this.haf = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.bET();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PersonFriendFragment.this.hHO) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.hPr.bRA().getPage().XI() + 1;
                    PersonFriendFragment.this.hHO = true;
                    PersonFriendFragment.this.bES();
                }
            }
        });
        this.Pj = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.Pj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.hPs != null && PersonFriendFragment.this.hPs.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.hPs.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.bRy().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.Pj.setAdapter((ListAdapter) this.hPs);
        this.mPullView = new i(bRy().getPageContext());
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (PersonFriendFragment.this.bRy() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.hPu = true;
                    PersonFriendFragment.this.hPr.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.bRy().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.hPv);
                }
            }
        });
        this.Pj.setPullRefresh(this.mPullView);
        this.mIsHost = bRy().bvu();
        if (bRy() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.j.person_friend_no_personal_info), getString(d.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.j.person_friend_no_personal_info), bRy().bvt());
        } else {
            str = getString(d.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.no(str), null);
        this.hOa = inflate.findViewById(d.g.friend_fragment_parent);
        this.Pj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.hHO) {
                    PersonFriendFragment.this.hPu = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.hPr.bRA().getPage().XI() + 1;
                    PersonFriendFragment.this.hHO = true;
                    PersonFriendFragment.this.bES();
                }
            }
        });
        if (bRy() != null) {
            this.hPr = bRy().bRx();
            if (this.mIsHost) {
                bRj();
            }
        }
        if (this.mPageType == bRy().bvs()) {
            this.pageNum = 0;
            this.Pj.startPullRefresh();
        }
        return inflate;
    }

    public void bRj() {
        if (this.hPr != null) {
            this.hPr.bRj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bES() {
        if (this.hPs != null) {
            this.hPs.oF(true);
            this.hPs.notifyDataSetChanged();
        }
        this.pageNum = this.hPr.bRA().getPage().XI() + 1;
        this.hPr.a(this.mIsHost, this.hPr.getId(), this.pageNum, this.hPv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        UserData userData;
        if (this.hPs != null && this.hPs.getItemViewType(this.haf) == 0 && (userData = (UserData) this.hPs.getItem(this.haf)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bRy().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bRy().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(userData.getUserId(), 0L), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.hOa != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.hOa);
            }
            if (this.mNoDataView != null) {
                al.k(this.mNoDataView, d.C0277d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.ic(i);
            }
        }
    }

    public void a(ar arVar, boolean z) {
        ar arVar2;
        if (arVar != null) {
            this.Pj.completePullRefreshPostDelayed(0L);
            if (this.hPr != null && bRy() != null) {
                if (!z) {
                    if (this.hPu) {
                        this.hPu = false;
                        if (this.mPageType == bRy().bvs()) {
                            this.hPr.d(arVar);
                            arVar2 = arVar;
                        }
                    } else {
                        if (this.mPageType == bRy().bvs()) {
                            a(arVar);
                        }
                        arVar2 = this.hPr.bRA();
                    }
                    this.hPt = arVar2;
                    b(arVar2);
                    c(arVar);
                }
                arVar2 = arVar;
                this.hPt = arVar2;
                b(arVar2);
                c(arVar);
            }
        }
    }

    public void a(ar arVar) {
        if (arVar != null && this.hPr != null) {
            this.hPr.bRA().XN().addAll(arVar.XN());
            this.hPr.bRA().XO().addAll(arVar.XO());
            this.hPr.bRA().setPage(arVar.getPage());
        }
    }

    private void b(ar arVar) {
        boolean z = true;
        if (this.hPs != null) {
            if (arVar != null) {
                an page = arVar.getPage();
                if (this.mPageType == 0) {
                    c cVar = this.hPs;
                    if (page == null || page.XK() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.hPs.setData(arVar.XN());
                } else {
                    if (arVar.XO().size() < this.hPv) {
                        this.hPs.setHasMore(false);
                    } else {
                        this.hPs.setHasMore(true);
                    }
                    this.hPs.setData(arVar.XO());
                }
                this.hPs.oF(false);
                this.hPs.bEQ();
                this.hPs.notifyDataSetChanged();
                return;
            }
            this.hPs.setHasMore(false);
            this.hPs.setData(new ArrayList<>());
            this.hPs.oF(false);
            this.hPs.bEQ();
            this.hPs.notifyDataSetChanged();
        }
    }

    private void c(ar arVar) {
        if (bRy() != null && this.hPr != null) {
            if (this.mPageType == 0) {
                if (this.hPr.bRA().XN().size() == 0) {
                    if (this.hPt != null && this.hPt.XN().size() > 0) {
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
            } else if (this.hPr.bRA().XO().size() == 0) {
                if (this.hPt != null && this.hPt.XO().size() > 0) {
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
            bRy().bM(this.hPr.bRA().XP(), this.hPr.bRA().XQ());
        }
    }
}
