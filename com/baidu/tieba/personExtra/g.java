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
    public BdListView avh = null;
    private h gmW = null;
    private View glI = null;
    private com.baidu.tbadk.core.view.h mNoDataView = null;
    private com.baidu.tbadk.core.view.k mPullView = null;
    private PersonFriendModel gmV = null;
    private int mPageType = 0;
    int fxJ = 0;
    private boolean mIsHost = true;
    private ap gmX = null;
    private boolean gmY = true;
    private boolean gfx = false;
    private int pageNum = 0;
    private int gmZ = 20;
    private final CustomMessageListener gna = new CustomMessageListener(2001182) { // from class: com.baidu.tieba.personExtra.g.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001182 && g.this.mIsHost) {
                ap personFriendData = ((ResponsePersonFriendByUidLocalMessage) customResponsedMessage).getPersonFriendData();
                if (g.this.bjJ() != null) {
                    g.this.gmX = personFriendData;
                    g.this.a(personFriendData, true);
                }
            }
        }
    };
    private HttpMessageListener gnb = new HttpMessageListener(CmdConfigHttp.PIC_FRIEND_CMD) { // from class: com.baidu.tieba.personExtra.g.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002001) {
                g.this.gfx = false;
                if (g.this.bjJ() != null && httpResponsedMessage.getOrginalMessage().getTag() == g.this.bjJ().getUniqueId()) {
                    g.this.avh.completePullRefreshPostDelayed(2000L);
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
            this.gmV = bjJ().bjI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.gmW != null) {
            this.gmW.bjK();
            this.gmW = null;
        }
        MessageManager.getInstance().unRegisterListener(this.gnb);
        MessageManager.getInstance().unRegisterListener(this.gna);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        registerListener(this.gnb);
        registerListener(this.gna);
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
        if (this.gmW != null) {
            this.gmW.bjK();
            this.gmW = null;
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        this.mPageType = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(d.h.friend_fragment, viewGroup, false);
        this.gmW = new h(bjJ(), bjJ().aLq(), this.mPageType, new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.fxJ = ((Integer) view.getTag()).intValue();
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
                if (!g.this.gfx) {
                    g.this.pageNum = g.this.gmV.bjL().yA().yu() + 1;
                    g.this.gfx = true;
                    g.this.aXy();
                }
            }
        });
        this.avh = (BdListView) inflate.findViewById(d.g.my_friend_list);
        this.avh.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.personExtra.g.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                UserData userData;
                if (g.this.gmW != null && g.this.gmW.getItemViewType(i) == 0 && (userData = (UserData) g.this.gmW.getItem(i)) != null && userData.getUserId() != null) {
                    g.this.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(g.this.bjJ().getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show())));
                }
            }
        });
        this.avh.setAdapter((ListAdapter) this.gmW);
        this.mPullView = new com.baidu.tbadk.core.view.k(bjJ().getPageContext());
        this.mPullView.a(new j.b() { // from class: com.baidu.tieba.personExtra.g.4
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (g.this.bjJ() != null) {
                    g.this.pageNum = 0;
                    g.this.gmY = true;
                    g.this.gmV.a(g.this.mIsHost, g.this.bjJ().getUid(), g.this.pageNum, g.this.gmZ);
                }
            }
        });
        this.avh.setPullRefresh(this.mPullView);
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
        this.glI = inflate.findViewById(d.g.friend_fragment_parent);
        this.avh.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personExtra.g.5
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (!g.this.gfx) {
                    g.this.gmY = false;
                    g.this.pageNum = g.this.gmV.bjL().yA().yu() + 1;
                    g.this.gfx = true;
                    g.this.aXy();
                }
            }
        });
        if (bjJ() != null) {
            this.gmV = bjJ().bjI();
            if (this.mIsHost) {
                bju();
            }
        }
        if (this.mPageType == bjJ().aLo()) {
            this.pageNum = 0;
            this.avh.startPullRefresh();
        }
        return inflate;
    }

    public void bju() {
        if (this.gmV != null) {
            this.gmV.bju();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXy() {
        if (this.gmW != null) {
            this.gmW.lx(true);
            this.gmW.notifyDataSetChanged();
        }
        this.pageNum = this.gmV.bjL().yA().yu() + 1;
        this.gmV.a(this.mIsHost, this.gmV.getId(), this.pageNum, this.gmZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        UserData userData;
        if (this.gmW != null && this.gmW.getItemViewType(this.fxJ) == 0 && (userData = (UserData) this.gmW.getItem(this.fxJ)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(bjJ().getPageContext().getContext(), "enter_chat", "personlistclick", 1, new Object[0]);
            sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(bjJ().getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.glI != null && getBaseFragmentActivity() != null) {
                getBaseFragmentActivity().getPageContext().getLayoutMode().aM(this.glI);
            }
            if (this.mNoDataView != null) {
                aj.s(this.mNoDataView, d.C0140d.cp_bg_line_d);
            }
            if (this.mPullView != null) {
                this.mPullView.gx(i);
            }
        }
    }

    public void a(ap apVar, boolean z) {
        ap apVar2;
        if (apVar != null) {
            this.avh.completePullRefreshPostDelayed(2000L);
            if (this.gmV != null && bjJ() != null) {
                if (!z) {
                    if (this.gmY) {
                        this.gmY = false;
                        if (this.mPageType == bjJ().aLo()) {
                            this.gmV.d(apVar);
                            apVar2 = apVar;
                        }
                    } else {
                        if (this.mPageType == bjJ().aLo()) {
                            a(apVar);
                        }
                        apVar2 = this.gmV.bjL();
                    }
                    this.gmX = apVar2;
                    b(apVar2);
                    c(apVar);
                }
                apVar2 = apVar;
                this.gmX = apVar2;
                b(apVar2);
                c(apVar);
            }
        }
    }

    public void a(ap apVar) {
        if (apVar != null && this.gmV != null) {
            this.gmV.bjL().yB().addAll(apVar.yB());
            this.gmV.bjL().yC().addAll(apVar.yC());
            this.gmV.bjL().a(apVar.yA());
        }
    }

    private void b(ap apVar) {
        boolean z = true;
        if (this.gmW != null) {
            if (apVar != null) {
                al yA = apVar.yA();
                if (this.mPageType == 0) {
                    h hVar = this.gmW;
                    if (yA == null || yA.yw() != 1) {
                        z = false;
                    }
                    hVar.setHasMore(z);
                    this.gmW.setData(apVar.yB());
                } else {
                    if (apVar.yC().size() < this.gmZ) {
                        this.gmW.setHasMore(false);
                    } else {
                        this.gmW.setHasMore(true);
                    }
                    this.gmW.setData(apVar.yC());
                }
                this.gmW.lx(false);
                this.gmW.aXv();
                this.gmW.notifyDataSetChanged();
                return;
            }
            this.gmW.setHasMore(false);
            this.gmW.setData(new ArrayList<>());
            this.gmW.lx(false);
            this.gmW.aXv();
            this.gmW.notifyDataSetChanged();
        }
    }

    private void c(ap apVar) {
        if (bjJ() != null && this.gmV != null) {
            if (this.mPageType == 0) {
                if (this.gmV.bjL().yB().size() == 0) {
                    if (this.gmX != null && this.gmX.yB().size() > 0) {
                        this.mNoDataView.setVisibility(8);
                        this.avh.setVisibility(0);
                    } else {
                        this.mNoDataView.setVisibility(0);
                        this.avh.setVisibility(0);
                    }
                } else {
                    this.mNoDataView.setVisibility(8);
                    this.avh.setVisibility(0);
                }
            } else if (this.gmV.bjL().yC().size() == 0) {
                if (this.gmX != null && this.gmX.yC().size() > 0) {
                    this.mNoDataView.setVisibility(8);
                    this.avh.setVisibility(0);
                } else {
                    this.mNoDataView.setVisibility(0);
                    this.avh.setVisibility(0);
                }
            } else {
                this.mNoDataView.setVisibility(8);
                this.avh.setVisibility(0);
            }
            bjJ().ce(this.gmV.bjL().yD(), this.gmV.bjL().yE());
        }
    }
}
