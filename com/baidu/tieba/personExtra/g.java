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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g extends BaseFragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView auZ = null;
    private h gnb = null;
    private View glN = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private PersonFriendModel gna = null;
    private int mPageType = 0;
    int fxN = 0;
    private boolean mIsHost = true;
    private ap gnc = null;
    private boolean gnd = true;
    private boolean gfC = false;
    private int pageNum = 0;
    private int gne = 20;
    private final CustomMessageListener gnf = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && g.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (g.this.bjJ() != null) {
                    g.this.gnc = personFriendData;
                    g.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gng = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                g.this.gfC = false;
                if (g.this.bjJ() != null && httpResponsedMessage.getOrginalMessage().getTag() == g.this.bjJ().getUniqueId()) {
                    g.this.auZ.completePullRefreshPostDelayed(2000L);
                    if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonFriendResponseMessage)) {
                        PersonFriendResponseMessage personFriendResponseMessage = (PersonFriendResponseMessage) httpResponsedMessage;
                        if (personFriendResponseMessage.getError() == 0) {
                            g.this.a(personFriendResponseMessage.getPersonFriendData(), false);
                            return;
                        } else {
                            g.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? g.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                            return;
                        }
                    }
                    g.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? g.this.getResources().getString(d.j.neterror) : httpResponsedMessage.getErrorString());
                }
            }
        }
    };

    static {
        com.baidu.tieba.tbadkCore.a.a.b(2001182, k.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity bjJ() {
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
        if (bjJ() != null) {
            this.gna = bjJ().bjI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gnb != null) {
            this.gnb.bjK();
            this.gnb = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gng);
        MessageManager.getInstance().unRegisterListener(this.gnf);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gng);
        registerListener(this.gnf);
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
        if (this.gnb != null) {
            this.gnb.bjK();
            this.gnb = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.gnb = new h(bjJ(), bjJ().aLq(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fxN = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    g.this.aXz();
                } else {
                    TbadkCoreApplication.getInst().login(g.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) g.this.getBaseFragmentActivity().getPageContext().getPageActivity(), g.this.getString(d.j.login_to_chat), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.gfC) {
                    g.this.pageNum = g.this.gna.bjL().yA().yu() + 1;
                    g.this.gfC = true;
                    g.this.aXy();
                }
            }
        });
        this.auZ = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.auZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.g.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (g.this.gnb != null && g.this.gnb.getItemViewType(i) == 0 && (userData = (UserData) g.this.gnb.getItem(i)) != null && userData.getUserId() != null) {
                    g.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.bjJ().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.auZ.setAdapter((ListAdapter) this.gnb);
        this.mPullView = new com.baidu.tbadk.core.view.k(bjJ().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.g.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (g.this.bjJ() != null) {
                    g.this.pageNum = 0;
                    g.this.gnd = true;
                    g.this.gna.a(g.this.mIsHost, g.this.bjJ().getUid(), g.this.pageNum, g.this.gne);
                }
            }
        });
        this.auZ.setPullRefresh(this.mPullView);
        this.mIsHost = bjJ().aLq();
        if (bjJ() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.j.person_friend_no_personal_info), getString(d.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.j.person_friend_no_personal_info), bjJ().aLp());
        } else {
            str = getString(d.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eT(str), null);
        this.glN = inflate.findViewById(d.g.friend_fragment_parent);
        this.auZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.g.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!g.this.gfC) {
                    g.this.gnd = false;
                    g.this.pageNum = g.this.gna.bjL().yA().yu() + 1;
                    g.this.gfC = true;
                    g.this.aXy();
                }
            }
        });
        if (bjJ() != null) {
            this.gna = bjJ().bjI();
            if (this.mIsHost) {
                bju();
            }
        }
        if (this.mPageType == bjJ().aLo()) {
            this.pageNum = 0;
            this.auZ.startPullRefresh();
        }
        return inflate;
    }

    public void bju() {
        if (this.gna != null) {
            this.gna.bju();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.gnb != null) {
            this.gnb.lC(true);
            this.gnb.notifyDataSetChanged();
        }
        this.pageNum = this.gna.bjL().yA().yu() + 1;
        this.gna.a(this.mIsHost, this.gna.getId(), this.pageNum, this.gne);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        UserData userData;
        if (this.gnb != null && this.gnb.getItemViewType(this.fxN) == 0 && (userData = (UserData) this.gnb.getItem(this.fxN)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bjJ().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bjJ().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glN != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glN);
            }
            if (this.mNoDataView != null) {
                aj.s(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.auZ.completePullRefreshPostDelayed(2000L);
            if (this.gna != null && bjJ() != null) {
                if (!z) {
                    if (this.gnd) {
                        this.gnd = false;
                        if (this.mPageType == bjJ().aLo()) {
                            this.gna.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bjJ().aLo()) {
                            a(apVar);
                        }
                        apVar2 = this.gna.bjL();
                    }
                    this.gnc = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gnc = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gna != null) {
            this.gna.bjL().yB().addAll(apVar.yB());
            this.gna.bjL().yC().addAll(apVar.yC());
            this.gna.bjL().a(apVar.yA());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gnb != null) {
            if (apVar != null) {
                al yA = apVar.yA();
                if (this.mPageType == 0) {
                    h hVar = this.gnb;
                    if (yA == null || yA.yw() != 1) {
                        z = false;
                    }
                    hVar.setHasMore(z);
                    this.gnb.setData(apVar.yB());
                } else {
                    if (apVar.yC().size() < this.gne) {
                        this.gnb.setHasMore(false);
                    } else {
                        this.gnb.setHasMore(true);
                    }
                    this.gnb.setData(apVar.yC());
                }
                this.gnb.lC(false);
                this.gnb.aXv();
                this.gnb.notifyDataSetChanged();
                return;
            }
            this.gnb.setHasMore(false);
            this.gnb.setData(new ArrayList<>());
            this.gnb.lC(false);
            this.gnb.aXv();
            this.gnb.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bjJ() != null && this.gna != null) {
            if (this.mPageType == 0) {
                if (this.gna.bjL().yB().size() == 0) {
                    if (this.gnc != null && this.gnc.yB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.auZ.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.auZ.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.auZ.setVisibility(0);
                }
            } else if (this.gna.bjL().yC().size() == 0) {
                if (this.gnc != null && this.gnc.yC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.auZ.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.auZ.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.auZ.setVisibility(0);
            }
            bjJ().ce(this.gna.bjL().yD(), this.gna.bjL().yE());
        }
    }
}
