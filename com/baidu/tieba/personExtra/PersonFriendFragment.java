package com.baidu.tieba.personExtra;

import android.content.Context;
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
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class PersonFriendFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView FH = null;
    private c fIB = null;
    private View fHn = null;
    private NoDataView mNoDataView = null;
    private com.baidu.tbadk.core.view.f mPullView = null;
    private PersonFriendModel fIA = null;
    private int mPageType = 0;
    int eTB = 0;
    private boolean mIsHost = true;
    private aq fIC = null;
    private boolean fID = true;
    private boolean fBb = false;
    private int pageNum = 0;
    private int fIE = 20;
    private final CustomMessageListener fIF = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && PersonFriendFragment.this.mIsHost) {
                aq personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (PersonFriendFragment.this.beL() != null) {
                    PersonFriendFragment.this.fIC = personFriendData;
                    PersonFriendFragment.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener fIG = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                PersonFriendFragment.this.fBb = false;
                if (PersonFriendFragment.this.beL() != null && httpResponsedMessage.getOrginalMessage().getTag() == PersonFriendFragment.this.beL().getUniqueId()) {
                    PersonFriendFragment.this.FH.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            PersonFriendFragment.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    PersonFriendFragment.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? PersonFriendFragment.this.getResources().getString(d.k.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, f.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity beL() {
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
        if (beL() != null) {
            this.fIA = beL().beK();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.fIB != null) {
            this.fIB.beM();
            this.fIB = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fIG);
        MessageManager.getInstance().unRegisterListener(this.fIF);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.fIG);
        registerListener(this.fIF);
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
        if (this.fIB != null) {
            this.fIB.beM();
            this.fIB = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.i.friend_fragment, viewGroup, false);
        this.fIB = new c(beL(), beL().aGl(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonFriendFragment.this.eTB = ((Integer) view2.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    PersonFriendFragment.this.aSu();
                } else {
                    TbadkCoreApplication.getInst().login(PersonFriendFragment.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) PersonFriendFragment.this.getBaseFragmentActivity().getPageContext().getPageActivity(), PersonFriendFragment.this.getString(d.k.login_to_chat), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!PersonFriendFragment.this.fBb) {
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fIA.beN().rf().qZ() + 1;
                    PersonFriendFragment.this.fBb = true;
                    PersonFriendFragment.this.aSt();
                }
            }
        });
        this.FH = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.FH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                UserData userData;
                if (PersonFriendFragment.this.fIB != null && PersonFriendFragment.this.fIB.getItemViewType(i) == 0 && (userData = (UserData) PersonFriendFragment.this.fIB.getItem(i)) != null && userData.getUserId() != null) {
                    PersonFriendFragment.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonFriendFragment.this.beL().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.FH.setAdapter((ListAdapter) this.fIB);
        this.mPullView = new com.baidu.tbadk.core.view.f(beL().getPageContext());
        this.mPullView.a(new e.b() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.4
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (PersonFriendFragment.this.beL() != null) {
                    PersonFriendFragment.this.pageNum = 0;
                    PersonFriendFragment.this.fID = true;
                    PersonFriendFragment.this.fIA.a(PersonFriendFragment.this.mIsHost, PersonFriendFragment.this.beL().getUid(), PersonFriendFragment.this.pageNum, PersonFriendFragment.this.fIE);
                }
            }
        });
        this.FH.setPullRefresh(this.mPullView);
        this.mIsHost = beL().aGl();
        if (beL() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.k.person_friend_no_personal_info), getString(d.k.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.k.person_friend_no_personal_info), beL().aGk());
        } else {
            str = getString(d.k.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eL(str), null);
        this.fHn = inflate.findViewById(d.g.friend_fragment_parent);
        this.FH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.PersonFriendFragment.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!PersonFriendFragment.this.fBb) {
                    PersonFriendFragment.this.fID = false;
                    PersonFriendFragment.this.pageNum = PersonFriendFragment.this.fIA.beN().rf().qZ() + 1;
                    PersonFriendFragment.this.fBb = true;
                    PersonFriendFragment.this.aSt();
                }
            }
        });
        if (beL() != null) {
            this.fIA = beL().beK();
            if (this.mIsHost) {
                bew();
            }
        }
        if (this.mPageType == beL().aGj()) {
            this.pageNum = 0;
            this.FH.startPullRefresh();
        }
        return inflate;
    }

    public void bew() {
        if (this.fIA != null) {
            this.fIA.bew();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSt() {
        if (this.fIB != null) {
            this.fIB.lc(true);
            this.fIB.notifyDataSetChanged();
        }
        this.pageNum = this.fIA.beN().rf().qZ() + 1;
        this.fIA.a(this.mIsHost, this.fIA.getId(), this.pageNum, this.fIE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSu() {
        UserData userData;
        if (this.fIB != null && this.fIB.getItemViewType(this.eTB) == 0 && (userData = (UserData) this.fIB.getItem(this.eTB)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(beL().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(beL().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.fHn != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().u(this.fHn);
            }
            if (this.mNoDataView != null) {
                ak.i(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.dw(i);
            }
        }
    }

    public void a(aq aqVar, boolean z) {
        aq aqVar2;
        if (aqVar != null) {
            this.FH.completePullRefreshPostDelayed(2000L);
            if (this.fIA != null && beL() != null) {
                if (!z) {
                    if (this.fID) {
                        this.fID = false;
                        if (this.mPageType == beL().aGj()) {
                            this.fIA.d(aqVar);
                            aqVar2 = aqVar;
                        }
                    } else {
                        if (this.mPageType == beL().aGj()) {
                            a(aqVar);
                        }
                        aqVar2 = this.fIA.beN();
                    }
                    this.fIC = aqVar2;
                    b(aqVar2);
                    c(aqVar);
                }
                aqVar2 = aqVar;
                this.fIC = aqVar2;
                b(aqVar2);
                c(aqVar);
            }
        }
    }

    public void a(aq aqVar) {
        if (aqVar != null && this.fIA != null) {
            this.fIA.beN().rg().addAll(aqVar.rg());
            this.fIA.beN().rh().addAll(aqVar.rh());
            this.fIA.beN().a(aqVar.rf());
        }
    }

    private void b(aq aqVar) {
        boolean z = true;
        if (this.fIB != null) {
            if (aqVar != null) {
                am rf = aqVar.rf();
                if (this.mPageType == 0) {
                    c cVar = this.fIB;
                    if (rf == null || rf.rb() != 1) {
                        z = false;
                    }
                    cVar.setHasMore(z);
                    this.fIB.setData(aqVar.rg());
                } else {
                    if (aqVar.rh().size() < this.fIE) {
                        this.fIB.setHasMore(false);
                    } else {
                        this.fIB.setHasMore(true);
                    }
                    this.fIB.setData(aqVar.rh());
                }
                this.fIB.lc(false);
                this.fIB.aSq();
                this.fIB.notifyDataSetChanged();
                return;
            }
            this.fIB.setHasMore(false);
            this.fIB.setData(new ArrayList<>());
            this.fIB.lc(false);
            this.fIB.aSq();
            this.fIB.notifyDataSetChanged();
        }
    }

    private void c(aq aqVar) {
        if (beL() != null && this.fIA != null) {
            if (this.mPageType == 0) {
                if (this.fIA.beN().rg().size() == 0) {
                    if (this.fIC != null && this.fIC.rg().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.FH.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.FH.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.FH.setVisibility(0);
                }
            } else if (this.fIA.beN().rh().size() == 0) {
                if (this.fIC != null && this.fIC.rh().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.FH.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.FH.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.FH.setVisibility(0);
            }
            beL().bf(this.fIA.beN().ri(), this.fIA.beN().rj());
        }
    }
}
