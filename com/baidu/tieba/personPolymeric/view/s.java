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
    private CustomMessageListener fai;
    private com.baidu.tieba.personPolymeric.c.a ffG;
    public BdPersonListView ffg;
    private PersonTabView ffn;
    private com.baidu.tieba.personPolymeric.b.d fft;
    private boolean fgf;
    private com.baidu.tieba.personPolymeric.a.o fgl;
    private com.baidu.tieba.view.g fiM;
    private View fjA;
    private l fjB;
    private com.baidu.tieba.view.f fjn;
    public q fjo;
    private com.baidu.tieba.model.a fjp;
    private com.baidu.tieba.view.i fjq;
    private PersonTabView fjr;
    private LikeButtonWithHeadPortrait fjs;
    private com.baidu.tbadk.core.view.userLike.c fjt;
    private int fju;
    private TextView fjv;
    private TextView fjw;
    private CustomMessageListener fjx;
    private com.baidu.tieba.person.data.f fjy;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bBD = true;
    private int bDd = 0;
    private boolean fjz = false;
    private boolean fjC = false;
    View.OnClickListener auo = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.a ffp = new com.baidu.tieba.personPolymeric.event.a();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.fiM != null) {
                if (s.this.bRb == view) {
                    this.ffp.ceU = 8;
                }
                s.this.fiM.a(view, this.ffp);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.fjq != null) {
                s.this.fjq.onScrollStateChanged(absListView, i);
            }
            if (i == 0 && s.this.ffn.getVisibility() == 0 && s.this.fjr.getTop() > s.this.mNavigationBar.getBottom()) {
                s.this.ffn.setVisibility(8);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2) {
                if (s.this.fjq != null) {
                    s.this.fjq.onScroll(absListView, i, i2, i3);
                }
                s.this.aXl();
            }
        }
    };
    private PersonTabView.a fjD = new PersonTabView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.5
        @Override // com.baidu.tieba.personPolymeric.view.PersonTabView.a
        public void qt(int i) {
            s.this.fjr.setCurrentTab(i);
            s.this.ffn.setCurrentTab(i);
            s.this.qs(i);
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.bgb != null && s.this.fjp != null) {
                s.this.fft.qo(s.this.bDd);
                if (s.this.bDd == 0) {
                    s.this.bgb.wt();
                    s.this.fjp.h(false, false, false);
                } else if (s.this.bDd == 1) {
                    s.this.bgb.wt();
                    s.this.fjp.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fjE = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lc() {
            s.this.aWx();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lb() {
            s.this.fft.alC();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void w(float f) {
            s.this.fft.v(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.eZT = false;
        this.abz = tbPageContext;
        this.azD = bdUniqueId;
        this.mIsHost = z;
        this.eZT = z2;
        this.fft = eVar.aWI();
        this.bgb = this.fft.bgb;
        if (z) {
            this.fjn = new com.baidu.tieba.view.d(2);
            y(tbPageContext);
            return;
        }
        this.fjn = new com.baidu.tieba.view.c();
    }

    public void X(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.e.cp_bg_line_c);
        this.bga = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.ccS = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.ffg = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fjr = new PersonTabView(this.abz.getPageActivity());
        this.fjr.setOnTabSelectListener(this.fjD);
        this.ffn = (PersonTabView) this.mRootView.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.ffn.setOnTabSelectListener(this.fjD);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.abz.getResources().getDimensionPixelSize(d.f.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fjn.a(this.abz.getPageActivity(), this.mNavigationBar);
        this.ffg.setOnScrollListener(this.mOnScrollListener);
        this.fju = this.abz.getResources().getDimensionPixelSize(d.f.ds70);
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
        this.fjs = (LikeButtonWithHeadPortrait) view.findViewById(d.h.like_btn_with_head_portrait);
        this.fjt = new com.baidu.tbadk.core.view.userLike.c(this.abz, this.fjs);
        this.fjt.setFromType("2");
        this.fjt.h(this.abz.getUniqueId());
        this.fjt.a(new a());
        this.fjv = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fjw = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.eZT) {
            this.bRb.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.ffg.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fjo = new q(this.abz, this.mIsHost);
        this.fjA = LayoutInflater.from(this.abz.getPageActivity()).inflate(d.j.view_header_expand, (ViewGroup) null);
        this.ffg.addHeaderView(this.fjA);
        this.ffg.setExpandView(this.fjA);
        this.ffg.addHeaderView(this.fjo.VV());
        if (!this.mIsHost) {
            this.fjB = new l(this.abz.getPageActivity());
            this.ffg.addHeaderView(this.fjB);
        }
        this.ffg.addHeaderView(this.fjr);
        this.ffg.setPersonListRefreshListener(this.fjE);
        this.fgl = new com.baidu.tieba.personPolymeric.a.o(this.abz, this.ffg, this.azD);
        this.fgl.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fjs.setAlpha(0.0f);
        this.ffn.setVisibility(8);
        this.fjn.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ffG == null) {
            this.fjn.c(1.0f, true);
            aj.c(this.bRb, d.g.selector_topbar_return_black);
        } else {
            aXl();
        }
        this.fjr.onChangeSkinType();
        this.ffn.onChangeSkinType();
        this.fjs.onChangeSkinType(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cS(d.g.s_navbar_bg)));
        if (this.fjn != null) {
            this.fjn.onChangeSkinType(i);
        }
        this.bga.onChangeSkinType(this.abz, i);
        this.ccS.onChangeSkinType(this.abz, i);
        if (this.fjo != null) {
            this.fjo.onChangeSkinType(i);
        }
        if (this.ffg != null && (this.ffg.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.ffg.getAdapter()).notifyDataSetChanged();
        }
        this.bgb.dz(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        if (this.mIsHost) {
            aj.b(this.fjw, d.e.cp_cont_b, d.e.s_navbar_title_color);
            aj.b(this.fjv, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.fjB != null) {
            this.fjB.onChangeSkinType(i);
        }
    }

    public void kq(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.bRb, d.g.selector_topbar_return_black);
            this.fjn.c(1.0f, true);
            this.fjs.setAlpha(1.0f);
            this.ffn.setVisibility(0);
            this.ffg.setSelectionFromTop(this.ffg.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.bRb, d.g.selector_topbar_return_white);
        this.fjn.c(0.0f, false);
        this.fjs.setAlpha(0.0f);
        this.ffn.setVisibility(8);
    }

    public void aWx() {
        this.fjz = false;
        if (this.bDd == 0) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjp.resetData();
                this.fjp.refreshData();
                this.fft.la();
                return;
            }
            this.fft.alC();
        } else if (this.bDd == 1) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjp.h(true, true, true);
                this.fft.la();
                return;
            }
            this.fft.alC();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiM = gVar;
        this.fjn.setOnViewResponseListener(gVar);
        this.bRb.setOnClickListener(this.auo);
        this.fjo.setOnViewResponseListener(gVar);
        if (this.fft != null) {
            this.fft.a(this.fjA, gVar);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.fgl != null) {
            this.fgl.J(onClickListener);
        }
    }

    public void setList(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
        this.fgl.cD(list);
    }

    public void kj(boolean z) {
        this.fgf = z;
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
            this.fjv.setAlpha(1.0f - f);
            this.fjw.setAlpha(f);
        }
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cE(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        kq(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ffG = aVar;
            this.fjn.e(this.ffG.getUserData());
            if (this.fjz) {
                cE(aVar.arr());
                if (this.bgb != null) {
                    this.bgb.wu();
                    return;
                }
                return;
            }
            this.fjn.bxX();
            this.fjo.e(aVar);
            this.fjs.setPortraitUrl(com.baidu.tbadk.core.util.o.dz(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fjs.aXf();
            } else {
                this.ffG.getUserData().setIsLike(this.ffG.getUserData().getHave_attention() == 1);
                this.fjt.a(this.ffG.getUserData());
            }
            if (!this.mIsHost) {
                if (aVar.aXa() == null || aVar.aXa().fgU == null || aVar.aXa().fgU.size() <= 0) {
                    this.ffg.removeHeaderView(this.fjB);
                } else {
                    this.fjB.a(aVar.aXa());
                }
            }
            if (v.u(aVar.arr())) {
                cE(null);
                this.fft.YW();
                com.baidu.adp.lib.util.l.showToast(this.abz.getContext(), this.abz.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bgO().lJ(this.mIsHost);
            cE(aVar.arr());
            kq(this.fgf && v.t(aVar.arr()) >= 5);
            this.fgf = false;
            int size = aVar.arr().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.arr().get(i);
                if (fVar != null) {
                    if ((fVar instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                        this.fft.YW();
                        return;
                    } else if ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j)) {
                        this.fft.YW();
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
            this.fft.a(true, (List<com.baidu.adp.widget.ListView.f>) aVar.arr());
        }
    }

    public void alC() {
        this.fft.alC();
    }

    private void y(TbPageContext tbPageContext) {
        this.fjx = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fHQ;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.fjo != null && s.this.fjo.fiS != null) {
                            s.this.fjo.fiS.nj(aVar.dZp);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.ffG != null) {
                            if (s.this.ffG.fgJ != null && s.this.ffG.fgJ.ceV != null && aVar2 != null) {
                                s.this.ffG.fgJ.ceV.putBoolean("person_center_item_red_tip_show", aVar2.dZp);
                            }
                            if (aVar3 != null && s.this.ffG.fgI != null && s.this.ffG.fgI.ceV != null) {
                                s.this.ffG.fgI.ceV.putBoolean("person_center_item_red_tip_show", aVar3.dZp);
                            }
                            if (aVar4 != null && s.this.ffG.fgG != null && s.this.ffG.fgG.ceV != null) {
                                s.this.ffG.fgG.ceV.putBoolean("person_center_item_red_tip_show", aVar4.dZp);
                            }
                            if (aVar5 != null && s.this.ffG.fgK != null && s.this.ffG.fgK.ceV != null) {
                                s.this.ffG.fgK.ceV.putBoolean("person_center_item_red_tip_show", aVar5.dZp);
                            }
                            if (aVar6 != null && s.this.ffG.fgL != null && s.this.ffG.fgL.ceV != null) {
                                s.this.ffG.fgL.ceV.putBoolean("person_center_item_red_tip_show", aVar6.dZp);
                                s.this.ffG.fgL.ceV.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.fjn instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.fjn.y(5, aVar7.dZp);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.fjn.y(6, aVar8.dZp);
                            }
                        }
                    }
                }
            }
        };
        this.fjx.setTag(this.azD);
        tbPageContext.registerListener(this.fjx);
        this.fai = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    s.this.fjo.pD(iVar.pS());
                }
            }
        };
        this.fai.setTag(this.azD);
        tbPageContext.registerListener(this.fai);
    }

    public void onDestory() {
        if (this.fjo != null) {
            this.fjo.onDestory();
        }
    }

    public void qr(int i) {
        this.fjz = false;
        int i2 = i == 0 ? 1 : 0;
        this.fjp.a(i2, this.fjp.oI(i2));
        this.fjy = this.fjp.oI(i);
        if (this.fjy.aVl() == null) {
            this.fjz = true;
            if (i == 0) {
                this.fjp.Qj();
                return;
            } else if (i == 1) {
                this.fjp.h(true, true, false);
                return;
            } else {
                return;
            }
        }
        cE(this.fjy.aVl());
    }

    public void qs(int i) {
        if (i != this.bDd && this.fjp != null) {
            this.bDd = i;
            this.fgl.qm(this.bDd);
            qr(i);
        }
    }

    public com.baidu.tieba.view.f aXk() {
        return this.fjn;
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
                if (s.this.fjt.wR() != null && !StringUtils.isNull(s.this.fjt.wR().getUserId())) {
                    s.this.cqL.fZ(s.this.fjt.wR().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.abz.getPageActivity(), s.this.abz.getString(d.l.unlike_success)).tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXl() {
        VL();
        VM();
        aXm();
        if (!this.fjC) {
            this.fjC = this.fjr.getTop() != 0;
        }
        if (this.fjC) {
            if (this.fjr.getTop() <= this.mNavigationBar.getBottom()) {
                this.ffn.setVisibility(0);
            } else {
                this.ffn.setVisibility(8);
            }
            if (this.fjo.VV().getTop() + this.fju <= this.mNavigationBar.getBottom() && this.fjr.getTop() > this.mNavigationBar.getBottom()) {
                this.mNavigationBar.showBottomLine();
            } else {
                this.mNavigationBar.hideBottomLine();
            }
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fjp = aVar;
    }

    private void VL() {
        if (Build.VERSION.SDK_INT >= 11 && this.fjo != null) {
            int dimensionPixelSize = this.abz.getResources().getDimensionPixelSize(d.f.ds320);
            int top = this.fjo.VV().getTop();
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
            this.fjn.c(alpha, this.bBD ? false : true);
        }
    }

    private void aXm() {
        if (Build.VERSION.SDK_INT >= 11 && this.fjo != null) {
            int dimensionPixelSize = this.abz.getResources().getDimensionPixelSize(d.f.ds160);
            int top = this.fjo.VV().getTop();
            if (top >= dimensionPixelSize) {
                if (this.fjs.getAlpha() != 0.0f) {
                    this.fjs.setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.fjs.setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.fjs.getAlpha() != 1.0f) {
                this.fjs.setAlpha(1.0f);
            }
        }
    }

    public void cE(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list)) {
            list = new ArrayList<>();
        }
        if (this.ffg.getVisibility() != 0) {
            this.ffg.setVisibility(0);
        }
        this.ffg.setData(list);
    }

    public void aXn() {
        if (this.ffn.getVisibility() == 0) {
            this.ffg.setSelectionFromTop(this.ffg.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fjq = iVar;
    }

    public NavigationBar ahj() {
        return this.mNavigationBar;
    }
}
