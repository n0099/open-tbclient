package com.baidu.tieba.personPolymeric.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.e;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static int gtV = 300;
    private BdUniqueId ays;
    private NoNetworkView bKI;
    private PbListView bKJ;
    private ImageView cUP;
    private com.baidu.tbadk.i.a dBX;
    private PluginErrorTipView dhI;
    private CustomMessageListener gkH;
    private boolean gkp;
    public BdPersonListView gpG;
    private com.baidu.tieba.personPolymeric.b.d gpU;
    private com.baidu.tieba.personPolymeric.c.a gqh;
    private int gtW;
    private com.baidu.tieba.view.f gtX;
    public n gtY;
    private com.baidu.tieba.model.a gtZ;
    private com.baidu.tieba.view.g gtl;
    private com.baidu.tieba.view.i gua;
    private TextView gub;
    private LikeButtonWithHeadPortrait guc;
    private com.baidu.tbadk.core.view.userLike.c gud;
    private int gue;
    private TextView guf;
    private TextView gug;
    private com.baidu.tieba.personPolymeric.a.n guh;
    private CustomMessageListener gui;
    private View guk;
    private PersonCenterAttentionBarListView gul;
    private boolean gum;
    private k guo;
    private String gup;
    private View guq;
    private int gur;
    private i.a gus;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cCi = true;
    private int cEl = 0;
    private boolean guj = false;
    private boolean gun = false;
    View.OnClickListener aPz = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gpQ = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gtl != null) {
                if (p.this.cUP == view) {
                    this.gpQ.dkl = 8;
                }
                p.this.gtl.a(view, this.gpQ);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gua != null) {
                p.this.gua.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gua != null) {
                    p.this.gua.onScroll(absListView, i, i2, i3);
                }
                p.this.boP();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bKJ != null && p.this.gtZ != null) {
                p.this.gpU.sM(p.this.cEl);
                if (p.this.cEl == 0) {
                    p.this.bKJ.DY();
                    p.this.gtZ.g(false, false, false);
                } else if (p.this.cEl == 1) {
                    p.this.bKJ.DY();
                    p.this.gtZ.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gut = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bob();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oD() {
            p.this.gpU.aFc();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gpU.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gkp = false;
        this.mContext = tbPageContext;
        this.ays = bdUniqueId;
        this.mIsHost = z;
        this.gkp = z2;
        this.gpU = eVar.bok();
        this.bKJ = this.gpU.bKJ;
        this.gtW = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0200e.tbds402);
        if (z) {
            this.gtX = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gtX = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.dhI = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gpG = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gtX.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gpG.setOnScrollListener(this.mOnScrollListener);
        this.gue = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cUP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.cUP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cUP.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds14);
            this.cUP.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gub = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.guc = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gud = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.guc);
        this.gud.setFromType("2");
        this.gud.h(this.mContext.getUniqueId());
        this.gud.a(new a());
        this.guf = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gug = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.gkp) {
            this.cUP.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gpG.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gtY = new n(this.mContext, this.mIsHost);
        this.guk = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gpG.addHeaderView(this.guk);
        this.gpG.setExpandView(this.guk);
        this.gpG.addHeaderView(this.gtY.alT());
        this.guo = new k(this.mContext);
        this.gpG.addHeaderView(this.guo.alT());
        if (!this.mIsHost) {
            this.gub.setText(e.j.ta_homepage);
            this.gul = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gpG.addHeaderView(this.gul);
        } else {
            this.gub.setText(e.j.my_homepage);
        }
        this.gpG.setPersonListRefreshListener(this.gut);
        this.guh = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gpG, this.ays);
        this.guh.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.guc.setAlpha(0.0f);
        this.gtX.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gqh == null) {
            this.gtX.c(1.0f, true);
            al.c(this.cUP, e.f.selector_topbar_return_black);
        } else {
            boP();
        }
        al.h(this.gub, e.d.cp_cont_i);
        this.guc.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dB(e.f.s_navbar_bg)));
        if (this.gtX != null) {
            this.gtX.onChangeSkinType(i);
        }
        this.bKI.onChangeSkinType(this.mContext, i);
        this.dhI.onChangeSkinType(this.mContext, i);
        if (this.gtY != null) {
            this.gtY.onChangeSkinType(i);
        }
        if (this.gpG != null && (this.gpG.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gpG.getAdapter().notifyDataSetChanged();
        }
        this.bKJ.ek(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gug, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.guf, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gul != null) {
            this.gul.onChangeSkinType(i);
        }
        if (this.guo != null) {
            this.guo.onChangeSkinType(i);
        }
    }

    public void ml(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.cUP, e.f.selector_topbar_return_black);
            this.gtX.c(1.0f, true);
            this.gub.setAlpha(0.0f);
            this.guc.setAlpha(1.0f);
            this.gpG.setSelectionFromTop(this.gpG.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.cUP, e.f.selector_topbar_return_white);
        this.gtX.c(0.0f, false);
        this.gub.setAlpha(1.0f);
        this.guc.setAlpha(0.0f);
    }

    public void ti(String str) {
        if (this.gtY != null) {
            this.gtY.sX(str);
        }
    }

    public void tj(String str) {
        if (this.gtY != null) {
            this.gtY.sY(str);
        }
    }

    public void bob() {
        this.guj = false;
        if (this.cEl == 0) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gtZ.resetData();
                this.gtZ.refreshData();
                this.gpU.oC();
                return;
            }
            this.gpU.aFc();
        } else if (this.cEl == 1) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gtZ.g(true, true, true);
                this.gpU.oC();
                return;
            }
            this.gpU.aFc();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gtl = gVar;
        this.gtX.setOnViewResponseListener(gVar);
        this.cUP.setOnClickListener(this.aPz);
        this.gtY.setOnViewResponseListener(gVar);
        if (this.gpU != null) {
            this.gpU.a(this.guk, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.guh != null) {
            this.guh.Q(onClickListener);
        }
    }

    public void md(boolean z) {
        this.gum = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.cUP, e.f.selector_topbar_return_black);
        } else {
            al.c(this.cUP, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cUP.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.guf.setAlpha(1.0f - f);
            this.gug.setAlpha(f);
        }
    }

    public void as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dp(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        ml(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gqh = aVar;
            this.gtX.e(this.gqh.getUserData());
            if (this.guj) {
                dp(aVar.aKS());
                if (this.bKJ != null) {
                    this.bKJ.DZ();
                    return;
                }
                return;
            }
            this.gtX.bnS();
            this.gtY.e(aVar);
            if (aVar != null) {
                this.guc.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.guc.boJ();
            } else {
                this.gqh.getUserData().setIsLike(this.gqh.getUserData().getHave_attention() == 1);
                this.gud.a(this.gqh.getUserData());
            }
            if ((aVar.boC() == null || this.mIsHost) && v.I(aVar.boD())) {
                this.gpG.removeHeaderView(this.guo.alT());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.guo.a(aVar.boC(), this.mIsHost, this.gqh.getUserData(), aVar.boD());
            }
            if (!this.mIsHost) {
                if (aVar.boE() == null || aVar.boE().grn == null || aVar.boE().grn.size() <= 0) {
                    this.gpG.removeHeaderView(this.gul);
                } else {
                    this.gul.a(aVar.boE());
                }
            }
            if (v.I(aVar.aKS())) {
                dp(null);
                this.gpU.ZV();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.btQ().mN(this.mIsHost);
            dp(aVar.aKS());
            int size = aVar.aKS().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aKS().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gpU.ZV();
                    return;
                }
            }
            if (z) {
                if (this.bKJ != null) {
                    this.bKJ.DZ();
                    return;
                }
                return;
            }
            this.gpU.c(true, aVar.aKS());
        }
    }

    public void aFc() {
        this.gpU.aFc();
    }

    private void w(TbPageContext tbPageContext) {
        this.gui = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gMN;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gtY != null && p.this.gtY.gtt != null) {
                            p.this.gtY.gtt.ok(aVar.flr);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.gqh != null) {
                            if (p.this.gqh.grd != null && p.this.gqh.grd.dkm != null && aVar2 != null) {
                                p.this.gqh.grd.dkm.putBoolean("person_center_item_red_tip_show", aVar2.flr);
                            }
                            if (aVar3 != null && p.this.gqh.grc != null && p.this.gqh.grc.dkm != null) {
                                p.this.gqh.grc.dkm.putBoolean("person_center_item_red_tip_show", aVar3.flr);
                            }
                            if (aVar4 != null && p.this.gqh.gra != null && p.this.gqh.gra.dkm != null) {
                                p.this.gqh.gra.dkm.putBoolean("person_center_item_red_tip_show", aVar4.flr);
                            }
                            if (aVar5 != null && p.this.gqh.gre != null && p.this.gqh.gre.dkm != null) {
                                p.this.gqh.gre.dkm.putBoolean("person_center_item_red_tip_show", aVar5.flr);
                            }
                            if (aVar6 != null && p.this.gqh.grf != null && p.this.gqh.grf.dkm != null) {
                                p.this.gqh.grf.dkm.putBoolean("person_center_item_red_tip_show", aVar6.flr);
                                p.this.gqh.grf.dkm.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gtX instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gtX.C(5, aVar7.flr);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gtX.C(6, aVar8.flr);
                            }
                        }
                    }
                }
            }
        };
        this.gui.setTag(this.ays);
        tbPageContext.registerListener(this.gui);
        this.gkH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gtY.to(jVar.xn());
                }
            }
        };
        this.gkH.setTag(this.ays);
        tbPageContext.registerListener(this.gkH);
    }

    public void onDestory() {
        if (this.gtY != null) {
            this.gtY.onDestory();
        }
    }

    public com.baidu.tieba.view.f boO() {
        return this.gtX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bK(boolean z) {
            if (z) {
                if (p.this.dBX == null) {
                    p.this.dBX = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gud.Ev() != null && !StringUtils.isNull(p.this.gud.Ev().getUserId())) {
                    p.this.dBX.hI(p.this.gud.Ev().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).AJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boP() {
        alJ();
        alK();
        boQ();
        if (this.gtY.alT().getTop() + this.gue <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gtZ = aVar;
    }

    private void alJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.gtY != null) {
            int top = this.gtY.alT().getTop();
            if (top >= this.gtW) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gtW) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gtW));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void alK() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cCi) {
                    this.cCi = true;
                }
            } else if (this.cCi) {
                this.cCi = false;
            }
            a(alpha, !this.cCi);
            this.gtX.c(alpha, this.cCi ? false : true);
        }
    }

    private void boQ() {
        if (Build.VERSION.SDK_INT >= 11 && this.gtY != null) {
            int i = this.gtW / 2;
            int i2 = this.gtW - i;
            int top = this.gtY.alT().getTop();
            if (this.gub != null) {
                if (top < i) {
                    if (this.gub.getAlpha() != 0.0f) {
                        this.gub.setAlpha(0.0f);
                    }
                } else if (top < this.gtW && top >= i) {
                    if (i2 > 0) {
                        this.gub.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gtW && this.gub.getAlpha() != 1.0f) {
                    this.gub.setAlpha(1.0f);
                }
            }
            if (this.guc != null) {
                if (top >= i) {
                    if (this.guc.getAlpha() != 0.0f) {
                        this.guc.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.guc.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.guc.getAlpha() != 1.0f) {
                    this.guc.setAlpha(1.0f);
                }
            }
        }
    }

    public void dp(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gpG.getVisibility() != 0) {
            this.gpG.setVisibility(0);
        }
        this.gpG.setData(list);
        int H = v.H(list);
        if (H >= 5) {
            if (this.gum) {
                ml(true);
                this.gum = false;
            }
        } else if (H <= 1) {
            this.gpG.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gua = iVar;
    }

    public NavigationBar aaO() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gpG != null) {
            this.gup = str;
            this.gus = aVar;
            int headerViewsCount = (this.gpG.getHeaderViewsCount() + i) - this.gpG.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.guq = this.gpG.getChildAt(headerViewsCount);
                if (this.guq != null) {
                    this.gur = this.guq.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.guq.getLayoutParams().height = p.this.gur - ((int) (p.this.gur * f));
                            p.this.guq.requestLayout();
                        }

                        @Override // android.view.animation.Animation
                        public boolean willChangeBounds() {
                            return true;
                        }
                    };
                    animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.p.6
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            p.this.guq.setVisibility(8);
                            if (p.this.gus != null) {
                                p.this.gus.tk(p.this.gup);
                            }
                        }
                    });
                    animation.setDuration(gtV);
                    this.guq.startAnimation(animation);
                }
            }
        }
    }
}
