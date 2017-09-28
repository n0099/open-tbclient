package com.baidu.tieba.personPolymeric.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonTabView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    private TbPageContext abz;
    private BdUniqueId azD;
    private ImageView bRb;
    private NoNetworkView bga;
    private PbListView bgb;
    private PluginErrorTipView ccS;
    private com.baidu.tbadk.h.a cqL;
    private boolean eZT;
    private CustomMessageListener faj;
    private com.baidu.tieba.personPolymeric.c.a ffH;
    public BdPersonListView ffh;
    private PersonTabView ffo;
    private com.baidu.tieba.personPolymeric.b.d ffu;
    private boolean fgg;
    private com.baidu.tieba.personPolymeric.a.o fgm;
    private com.baidu.tieba.view.g fiN;
    private View fjB;
    private l fjC;
    private com.baidu.tieba.view.f fjo;
    public q fjp;
    private com.baidu.tieba.model.a fjq;
    private com.baidu.tieba.view.i fjr;
    private PersonTabView fjs;
    private LikeButtonWithHeadPortrait fjt;
    private com.baidu.tbadk.core.view.userLike.c fju;
    private int fjv;
    private TextView fjw;
    private TextView fjx;
    private CustomMessageListener fjy;
    private com.baidu.tieba.person.data.f fjz;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bBD = true;
    private int bDd = 0;
    private boolean fjA = false;
    private boolean fjD = false;
    View.OnClickListener auo = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.a ffq = new com.baidu.tieba.personPolymeric.event.a();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.fiN != null) {
                if (s.this.bRb == view) {
                    this.ffq.ceU = 8;
                }
                s.this.fiN.a(view, this.ffq);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.fjr != null) {
                s.this.fjr.onScrollStateChanged(absListView, i);
            }
            if (i == 0 && s.this.ffo.getVisibility() == 0 && s.this.fjs.getTop() > s.this.mNavigationBar.getBottom()) {
                s.this.ffo.setVisibility(8);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2) {
                if (s.this.fjr != null) {
                    s.this.fjr.onScroll(absListView, i, i2, i3);
                }
                s.this.aXm();
            }
        }
    };
    private PersonTabView.a fjE = new PersonTabView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.5
        @Override // com.baidu.tieba.personPolymeric.view.PersonTabView.a
        public void qt(int i) {
            s.this.fjs.setCurrentTab(i);
            s.this.ffo.setCurrentTab(i);
            s.this.qs(i);
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.bgb != null && s.this.fjq != null) {
                s.this.ffu.qo(s.this.bDd);
                if (s.this.bDd == 0) {
                    s.this.bgb.wt();
                    s.this.fjq.h(false, false, false);
                } else if (s.this.bDd == 1) {
                    s.this.bgb.wt();
                    s.this.fjq.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fjF = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lc() {
            s.this.aWy();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lb() {
            s.this.ffu.alC();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void w(float f) {
            s.this.ffu.v(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.eZT = false;
        this.abz = tbPageContext;
        this.azD = bdUniqueId;
        this.mIsHost = z;
        this.eZT = z2;
        this.ffu = eVar.aWJ();
        this.bgb = this.ffu.bgb;
        if (z) {
            this.fjo = new com.baidu.tieba.view.d(2);
            y(tbPageContext);
            return;
        }
        this.fjo = new com.baidu.tieba.view.c();
    }

    public void X(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.e.cp_bg_line_c);
        this.bga = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.ccS = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.ffh = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fjs = new PersonTabView(this.abz.getPageActivity());
        this.fjs.setOnTabSelectListener(this.fjE);
        this.ffo = (PersonTabView) this.mRootView.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.ffo.setOnTabSelectListener(this.fjE);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.abz.getResources().getDimensionPixelSize(d.f.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fjo.a(this.abz.getPageActivity(), this.mNavigationBar);
        this.ffh.setOnScrollListener(this.mOnScrollListener);
        this.fjv = this.abz.getResources().getDimensionPixelSize(d.f.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bRb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.view_topbar_icon, (View.OnClickListener) null);
        if (this.bRb.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bRb.getLayoutParams();
            layoutParams2.leftMargin = this.abz.getResources().getDimensionPixelSize(d.f.ds14);
            this.bRb.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fjt = (LikeButtonWithHeadPortrait) view.findViewById(d.h.like_btn_with_head_portrait);
        this.fju = new com.baidu.tbadk.core.view.userLike.c(this.abz, this.fjt);
        this.fju.setFromType("2");
        this.fju.h(this.abz.getUniqueId());
        this.fju.a(new a());
        this.fjw = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fjx = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.eZT) {
            this.bRb.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.ffh.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fjp = new q(this.abz, this.mIsHost);
        this.fjB = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.view_header_expand, (ViewGroup) null);
        this.ffh.addHeaderView(this.fjB);
        this.ffh.setExpandView(this.fjB);
        this.ffh.addHeaderView(this.fjp.VV());
        if (!this.mIsHost) {
            this.fjC = new l(this.abz.getPageActivity());
            this.ffh.addHeaderView(this.fjC);
        }
        this.ffh.addHeaderView(this.fjs);
        this.ffh.setPersonListRefreshListener(this.fjF);
        this.fgm = new com.baidu.tieba.personPolymeric.a.o(this.abz, this.ffh, this.azD);
        this.fgm.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fjt.setAlpha(0.0f);
        this.ffo.setVisibility(8);
        this.fjo.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ffH == null) {
            this.fjo.c(1.0f, true);
            aj.c(this.bRb, d.g.selector_topbar_return_black);
        } else {
            aXm();
        }
        this.fjs.onChangeSkinType();
        this.ffo.onChangeSkinType();
        this.fjt.onChangeSkinType(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cS(d.g.s_navbar_bg)));
        if (this.fjo != null) {
            this.fjo.onChangeSkinType(i);
        }
        this.bga.onChangeSkinType(this.abz, i);
        this.ccS.onChangeSkinType(this.abz, i);
        if (this.fjp != null) {
            this.fjp.onChangeSkinType(i);
        }
        if (this.ffh != null && (this.ffh.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.ffh.getAdapter()).notifyDataSetChanged();
        }
        this.bgb.dz(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        if (this.mIsHost) {
            aj.b(this.fjx, d.e.cp_cont_b, d.e.s_navbar_title_color);
            aj.b(this.fjw, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.fjC != null) {
            this.fjC.onChangeSkinType(i);
        }
    }

    public void kq(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.bRb, d.g.selector_topbar_return_black);
            this.fjo.c(1.0f, true);
            this.fjt.setAlpha(1.0f);
            this.ffo.setVisibility(0);
            this.ffh.setSelectionFromTop(this.ffh.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.bRb, d.g.selector_topbar_return_white);
        this.fjo.c(0.0f, false);
        this.fjt.setAlpha(0.0f);
        this.ffo.setVisibility(8);
    }

    public void aWy() {
        this.fjA = false;
        if (this.bDd == 0) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjq.resetData();
                this.fjq.refreshData();
                this.ffu.la();
                return;
            }
            this.ffu.alC();
        } else if (this.bDd == 1) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjq.h(true, true, true);
                this.ffu.la();
                return;
            }
            this.ffu.alC();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiN = gVar;
        this.fjo.setOnViewResponseListener(gVar);
        this.bRb.setOnClickListener(this.auo);
        this.fjp.setOnViewResponseListener(gVar);
        if (this.ffu != null) {
            this.ffu.a(this.fjB, gVar);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fgm != null) {
            this.fgm.J(onClickListener);
        }
    }

    public void setList(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
        this.fgm.cD(list);
    }

    public void kj(boolean z) {
        this.fgg = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.bRb, d.g.selector_topbar_return_black);
        } else {
            aj.c(this.bRb, d.g.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bRb.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fjw.setAlpha(1.0f - f);
            this.fjx.setAlpha(f);
        }
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cE(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        kq(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ffH = aVar;
            this.fjo.e(this.ffH.getUserData());
            if (this.fjA) {
                cE(aVar.arr());
                if (this.bgb != null) {
                    this.bgb.wu();
                    return;
                }
                return;
            }
            this.fjo.bxY();
            this.fjp.e(aVar);
            this.fjt.setPortraitUrl(com.baidu.tbadk.core.util.o.dz(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fjt.aXg();
            } else {
                this.ffH.getUserData().setIsLike(this.ffH.getUserData().getHave_attention() == 1);
                this.fju.a(this.ffH.getUserData());
            }
            if (!this.mIsHost) {
                if (aVar.aXb() == null || aVar.aXb().fgV == null || aVar.aXb().fgV.size() <= 0) {
                    this.ffh.removeHeaderView(this.fjC);
                } else {
                    this.fjC.a(aVar.aXb());
                }
            }
            if (v.u(aVar.arr())) {
                cE(null);
                this.ffu.YW();
                com.baidu.adp.lib.util.l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bgP().lJ(this.mIsHost);
            cE(aVar.arr());
            kq(this.fgg && v.t(aVar.arr()) >= 5);
            this.fgg = false;
            int size = aVar.arr().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.arr().get(i);
                if (fVar != null) {
                    if ((fVar instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                        this.ffu.YW();
                        return;
                    } else if ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j)) {
                        this.ffu.YW();
                        return;
                    }
                }
            }
            if (z) {
                if (this.bgb != null) {
                    this.bgb.wu();
                    return;
                }
                return;
            }
            this.ffu.a(true, (List<com.baidu.adp.widget.ListView.f>) aVar.arr());
        }
    }

    public void alC() {
        this.ffu.alC();
    }

    private void y(TbPageContext tbPageContext) {
        this.fjy = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fHR;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.fjp != null && s.this.fjp.fiT != null) {
                            s.this.fjp.fiT.nj(aVar.dZp);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.ffH != null) {
                            if (s.this.ffH.fgK != null && s.this.ffH.fgK.ceV != null && aVar2 != null) {
                                s.this.ffH.fgK.ceV.putBoolean("person_center_item_red_tip_show", aVar2.dZp);
                            }
                            if (aVar3 != null && s.this.ffH.fgJ != null && s.this.ffH.fgJ.ceV != null) {
                                s.this.ffH.fgJ.ceV.putBoolean("person_center_item_red_tip_show", aVar3.dZp);
                            }
                            if (aVar4 != null && s.this.ffH.fgH != null && s.this.ffH.fgH.ceV != null) {
                                s.this.ffH.fgH.ceV.putBoolean("person_center_item_red_tip_show", aVar4.dZp);
                            }
                            if (aVar5 != null && s.this.ffH.fgL != null && s.this.ffH.fgL.ceV != null) {
                                s.this.ffH.fgL.ceV.putBoolean("person_center_item_red_tip_show", aVar5.dZp);
                            }
                            if (aVar6 != null && s.this.ffH.fgM != null && s.this.ffH.fgM.ceV != null) {
                                s.this.ffH.fgM.ceV.putBoolean("person_center_item_red_tip_show", aVar6.dZp);
                                s.this.ffH.fgM.ceV.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.fjo instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.fjo.y(5, aVar7.dZp);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.fjo.y(6, aVar8.dZp);
                            }
                        }
                    }
                }
            }
        };
        this.fjy.setTag(this.azD);
        tbPageContext.registerListener(this.fjy);
        this.faj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    s.this.fjp.pD(iVar.pS());
                }
            }
        };
        this.faj.setTag(this.azD);
        tbPageContext.registerListener(this.faj);
    }

    public void onDestory() {
        if (this.fjp != null) {
            this.fjp.onDestory();
        }
    }

    public void qr(int i) {
        this.fjA = false;
        int i2 = i == 0 ? 1 : 0;
        this.fjq.a(i2, this.fjq.oI(i2));
        this.fjz = this.fjq.oI(i);
        if (this.fjz.aVl() == null) {
            this.fjA = true;
            if (i == 0) {
                this.fjq.Qj();
                return;
            } else if (i == 1) {
                this.fjq.h(true, true, false);
                return;
            } else {
                return;
            }
        }
        cE(this.fjz.aVl());
    }

    public void qs(int i) {
        if (i != this.bDd && this.fjq != null) {
            this.bDd = i;
            this.fgm.qm(this.bDd);
            qr(i);
        }
    }

    public com.baidu.tieba.view.f aXl() {
        return this.fjo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aQ(boolean z) {
            if (z) {
                if (s.this.cqL == null) {
                    s.this.cqL = new com.baidu.tbadk.h.a(s.this.abz);
                }
                if (s.this.fju.wR() != null && !StringUtils.isNull(s.this.fju.wR().getUserId())) {
                    s.this.cqL.fZ(s.this.fju.wR().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.abz.getPageActivity(), s.this.abz.getString(d.l.unlike_success)).tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        VL();
        VM();
        aXn();
        if (!this.fjD) {
            this.fjD = this.fjs.getTop() != 0;
        }
        if (this.fjD) {
            if (this.fjs.getTop() <= this.mNavigationBar.getBottom()) {
                this.ffo.setVisibility(0);
            } else {
                this.ffo.setVisibility(8);
            }
            if (this.fjp.VV().getTop() + this.fjv <= this.mNavigationBar.getBottom() && this.fjs.getTop() > this.mNavigationBar.getBottom()) {
                this.mNavigationBar.showBottomLine();
            } else {
                this.mNavigationBar.hideBottomLine();
            }
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fjq = aVar;
    }

    private void VL() {
        if (Build.VERSION.SDK_INT >= 11 && this.fjp != null) {
            int dimensionPixelSize = this.abz.getResources().getDimensionPixelSize(d.f.ds320);
            int top = this.fjp.VV().getTop();
            if (top >= dimensionPixelSize) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void VM() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bBD) {
                    this.bBD = true;
                }
            } else if (this.bBD) {
                this.bBD = false;
            }
            a(alpha, !this.bBD);
            this.fjo.c(alpha, this.bBD ? false : true);
        }
    }

    private void aXn() {
        if (Build.VERSION.SDK_INT >= 11 && this.fjp != null) {
            int dimensionPixelSize = this.abz.getResources().getDimensionPixelSize(d.f.ds160);
            int top = this.fjp.VV().getTop();
            if (top >= dimensionPixelSize) {
                if (this.fjt.getAlpha() != 0.0f) {
                    this.fjt.setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.fjt.setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.fjt.getAlpha() != 1.0f) {
                this.fjt.setAlpha(1.0f);
            }
        }
    }

    public void cE(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list)) {
            list = new ArrayList<>();
        }
        if (this.ffh.getVisibility() != 0) {
            this.ffh.setVisibility(0);
        }
        this.ffh.setData(list);
    }

    public void aXo() {
        if (this.ffo.getVisibility() == 0) {
            this.ffh.setSelectionFromTop(this.ffh.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fjr = iVar;
    }

    public NavigationBar ahj() {
        return this.mNavigationBar;
    }
}
