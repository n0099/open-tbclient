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
    public BdListView auY = null;
    private h gmL = null;
    private View glx = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private PersonFriendModel gmK = null;
    private int mPageType = 0;
    int fxx = 0;
    private boolean mIsHost = true;
    private ap gmM = null;
    private boolean gmN = true;
    private boolean gfm = false;
    private int pageNum = 0;
    private int gmO = 20;
    private final CustomMessageListener gmP = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && g.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (g.this.bjI() != null) {
                    g.this.gmM = personFriendData;
                    g.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gmQ = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                g.this.gfm = false;
                if (g.this.bjI() != null && httpResponsedMessage.getOrginalMessage().getTag() == g.this.bjI().getUniqueId()) {
                    g.this.auY.completePullRefreshPostDelayed(2000L);
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
    public PersonFriendActivity bjI() {
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
        if (bjI() != null) {
            this.gmK = bjI().bjH();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gmL != null) {
            this.gmL.bjJ();
            this.gmL = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gmQ);
        MessageManager.getInstance().unRegisterListener(this.gmP);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gmQ);
        registerListener(this.gmP);
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
        if (this.gmL != null) {
            this.gmL.bjJ();
            this.gmL = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.gmL = new h(bjI(), bjI().aLp(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fxx = ((Integer) view.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    g.this.aXy();
                } else {
                    TbadkCoreApplication.getInst().login(g.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) g.this.getBaseFragmentActivity().getPageContext().getPageActivity(), g.this.getString(d.j.login_to_chat), true, 11028)));
                }
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!g.this.gfm) {
                    g.this.pageNum = g.this.gmK.bjK().yA().yu() + 1;
                    g.this.gfm = true;
                    g.this.aXx();
                }
            }
        });
        this.auY = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.auY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.g.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (g.this.gmL != null && g.this.gmL.getItemViewType(i) == 0 && (userData = (UserData) g.this.gmL.getItem(i)) != null && userData.getUserId() != null) {
                    g.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.bjI().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.auY.setAdapter((ListAdapter) this.gmL);
        this.mPullView = new com.baidu.tbadk.core.view.k(bjI().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.g.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (g.this.bjI() != null) {
                    g.this.pageNum = 0;
                    g.this.gmN = true;
                    g.this.gmK.a(g.this.mIsHost, g.this.bjI().getUid(), g.this.pageNum, g.this.gmO);
                }
            }
        });
        this.auY.setPullRefresh(this.mPullView);
        this.mIsHost = bjI().aLp();
        if (bjI() == null) {
            str = null;
        } else if (this.mIsHost) {
            str = String.format(getString(d.j.person_friend_no_personal_info), getString(d.j.you));
        } else if (this.mPageType == 0) {
            str = String.format(getString(d.j.person_friend_no_personal_info), bjI().aLo());
        } else {
            str = getString(d.j.person_friend_no_common_info);
        }
        this.mNoDataView = NoDataViewFactory.a(getActivity(), inflate, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.eT(str), null);
        this.glx = inflate.findViewById(d.g.friend_fragment_parent);
        this.auY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.g.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!g.this.gfm) {
                    g.this.gmN = false;
                    g.this.pageNum = g.this.gmK.bjK().yA().yu() + 1;
                    g.this.gfm = true;
                    g.this.aXx();
                }
            }
        });
        if (bjI() != null) {
            this.gmK = bjI().bjH();
            if (this.mIsHost) {
                bjt();
            }
        }
        if (this.mPageType == bjI().aLn()) {
            this.pageNum = 0;
            this.auY.startPullRefresh();
        }
        return inflate;
    }

    public void bjt() {
        if (this.gmK != null) {
            this.gmK.bjt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (this.gmL != null) {
            this.gmL.lx(true);
            this.gmL.notifyDataSetChanged();
        }
        this.pageNum = this.gmK.bjK().yA().yu() + 1;
        this.gmK.a(this.mIsHost, this.gmK.getId(), this.pageNum, this.gmO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        UserData userData;
        if (this.gmL != null && this.gmL.getItemViewType(this.fxx) == 0 && (userData = (UserData) this.gmL.getItem(this.fxx)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bjI().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bjI().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glx != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glx);
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
            this.auY.completePullRefreshPostDelayed(2000L);
            if (this.gmK != null && bjI() != null) {
                if (!z) {
                    if (this.gmN) {
                        this.gmN = false;
                        if (this.mPageType == bjI().aLn()) {
                            this.gmK.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bjI().aLn()) {
                            a(apVar);
                        }
                        apVar2 = this.gmK.bjK();
                    }
                    this.gmM = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gmM = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gmK != null) {
            this.gmK.bjK().yB().addAll(apVar.yB());
            this.gmK.bjK().yC().addAll(apVar.yC());
            this.gmK.bjK().a(apVar.yA());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gmL != null) {
            if (apVar != null) {
                al yA = apVar.yA();
                if (this.mPageType == 0) {
                    h hVar = this.gmL;
                    if (yA == null || yA.yw() != 1) {
                        z = false;
                    }
                    hVar.setHasMore(z);
                    this.gmL.setData(apVar.yB());
                } else {
                    if (apVar.yC().size() < this.gmO) {
                        this.gmL.setHasMore(false);
                    } else {
                        this.gmL.setHasMore(true);
                    }
                    this.gmL.setData(apVar.yC());
                }
                this.gmL.lx(false);
                this.gmL.aXu();
                this.gmL.notifyDataSetChanged();
                return;
            }
            this.gmL.setHasMore(false);
            this.gmL.setData(new ArrayList<>());
            this.gmL.lx(false);
            this.gmL.aXu();
            this.gmL.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bjI() != null && this.gmK != null) {
            if (this.mPageType == 0) {
                if (this.gmK.bjK().yB().size() == 0) {
                    if (this.gmM != null && this.gmM.yB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.auY.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.auY.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.auY.setVisibility(0);
                }
            } else if (this.gmK.bjK().yC().size() == 0) {
                if (this.gmM != null && this.gmM.yC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.auY.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.auY.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.auY.setVisibility(0);
            }
            bjI().ce(this.gmK.bjK().yD(), this.gmK.bjK().yE());
        }
    }
}
