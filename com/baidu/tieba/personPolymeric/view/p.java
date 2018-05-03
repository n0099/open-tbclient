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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.n.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static int fMU = 300;
    private BdUniqueId aBK;
    private TbPageContext adf;
    private NoNetworkView bla;
    private PbListView blb;
    private PluginErrorTipView cHz;
    private com.baidu.tbadk.h.a cXy;
    private ImageView cvr;
    private CustomMessageListener fDH;
    private boolean fDt;
    private com.baidu.tieba.personPolymeric.b.d fIH;
    private com.baidu.tieba.personPolymeric.c.a fIV;
    public BdPersonListView fIt;
    private int fMV;
    private com.baidu.tieba.view.f fMW;
    public n fMX;
    private com.baidu.tieba.model.a fMY;
    private com.baidu.tieba.view.i fMZ;
    private com.baidu.tieba.view.g fMl;
    private TextView fNa;
    private LikeButtonWithHeadPortrait fNb;
    private com.baidu.tbadk.core.view.userLike.c fNc;
    private int fNd;
    private TextView fNe;
    private TextView fNf;
    private com.baidu.tieba.personPolymeric.a.n fNg;
    private CustomMessageListener fNh;
    private View fNj;
    private PersonCenterAttentionBarListView fNk;
    private boolean fNl;
    private k fNn;
    private String fNo;
    private View fNp;
    private int fNq;
    private i.a fNr;
    private com.baidu.tieba.write.c fNs;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bZF = true;
    private int cbu = 0;
    private boolean fNi = false;
    private boolean fNm = false;
    View.OnClickListener axG = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fID = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (p.this.fMl != null) {
                if (p.this.cvr == view2) {
                    this.fID.cKc = 8;
                }
                p.this.fMl.a(view2, this.fID);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.fMZ != null) {
                p.this.fMZ.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.fMZ != null) {
                    p.this.fMZ.onScroll(absListView, i, i2, i3);
                }
                p.this.bfO();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.blb != null && p.this.fMY != null) {
                p.this.fIH.ri(p.this.cbu);
                if (p.this.cbu == 0) {
                    p.this.blb.wR();
                    p.this.fMY.h(false, false, false);
                } else if (p.this.cbu == 1) {
                    p.this.blb.wR();
                    p.this.fMY.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fNt = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.beY();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kz() {
            p.this.fIH.auL();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void D(float f) {
            p.this.fIH.C(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fDt = false;
        this.adf = tbPageContext;
        this.aBK = bdUniqueId;
        this.mIsHost = z;
        this.fDt = z2;
        this.fIH = eVar.bfh();
        this.blb = this.fIH.blb;
        this.fMV = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds402);
        if (z) {
            this.fMW = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.fMW = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view2) {
        this.mRootView = view2;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0126d.cp_bg_line_c);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cHz = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fIt = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.adf.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fMW.a(this.adf.getPageActivity(), this.mNavigationBar);
        this.fIt.setOnScrollListener(this.mOnScrollListener);
        this.fNd = this.adf.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cvr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.cvr.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cvr.getLayoutParams();
            layoutParams2.leftMargin = this.adf.getResources().getDimensionPixelSize(d.e.ds14);
            this.cvr.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fNa = (TextView) view2.findViewById(d.g.tv_title_above_navigation_bar);
        this.fNb = (LikeButtonWithHeadPortrait) view2.findViewById(d.g.like_btn_with_head_portrait);
        this.fNc = new com.baidu.tbadk.core.view.userLike.c(this.adf, this.fNb);
        this.fNc.setFromType("2");
        this.fNc.h(this.adf.getUniqueId());
        this.fNc.a(new a());
        this.fNe = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.fNf = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fDt) {
            this.cvr.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fIt.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fMX = new n(this.adf, this.mIsHost);
        this.fNj = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.view_header_expand, (ViewGroup) null);
        this.fIt.addHeaderView(this.fNj);
        this.fIt.setExpandView(this.fNj);
        this.fIt.addHeaderView(this.fMX.acD());
        this.fNn = new k(this.adf);
        this.fIt.addHeaderView(this.fNn.acD());
        if (!this.mIsHost) {
            this.fNa.setText(d.k.ta_homepage);
            this.fNk = new PersonCenterAttentionBarListView(this.adf.getPageActivity());
            this.fIt.addHeaderView(this.fNk);
        } else {
            this.fNa.setText(d.k.my_homepage);
        }
        this.fIt.setPersonListRefreshListener(this.fNt);
        this.fNg = new com.baidu.tieba.personPolymeric.a.n(this.adf, this.fIt, this.aBK);
        this.fNg.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fNb.setAlpha(0.0f);
        this.fMW.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fIV == null) {
            this.fMW.c(1.0f, true);
            ak.c(this.cvr, d.f.selector_topbar_return_black);
        } else {
            bfO();
        }
        ak.h(this.fNa, d.C0126d.cp_cont_i);
        this.fNb.onChangeSkinType(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cO(d.f.s_navbar_bg)));
        if (this.fMW != null) {
            this.fMW.onChangeSkinType(i);
        }
        this.bla.onChangeSkinType(this.adf, i);
        this.cHz.onChangeSkinType(this.adf, i);
        if (this.fMX != null) {
            this.fMX.onChangeSkinType(i);
        }
        if (this.fIt != null && (this.fIt.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fIt.getAdapter().notifyDataSetChanged();
        }
        this.blb.dv(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.mIsHost) {
            ak.b(this.fNf, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            ak.b(this.fNe, d.C0126d.cp_cont_i, d.C0126d.cp_cont_i);
        }
        if (this.fNk != null) {
            this.fNk.onChangeSkinType(i);
        }
        if (this.fNn != null) {
            this.fNn.onChangeSkinType(i);
        }
    }

    public void lk(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            ak.c(this.cvr, d.f.selector_topbar_return_black);
            this.fMW.c(1.0f, true);
            this.fNa.setAlpha(0.0f);
            this.fNb.setAlpha(1.0f);
            this.fIt.setSelectionFromTop(this.fIt.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        ak.c(this.cvr, d.f.selector_topbar_return_white);
        this.fMW.c(0.0f, false);
        this.fNa.setAlpha(1.0f);
        this.fNb.setAlpha(0.0f);
    }

    public void beY() {
        this.fNi = false;
        if (this.cbu == 0) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fMY.resetData();
                this.fMY.refreshData();
                this.fIH.ky();
                return;
            }
            this.fIH.auL();
        } else if (this.cbu == 1) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fMY.h(true, true, true);
                this.fIH.ky();
                return;
            }
            this.fIH.auL();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMl = gVar;
        this.fMW.setOnViewResponseListener(gVar);
        this.cvr.setOnClickListener(this.axG);
        this.fMX.setOnViewResponseListener(gVar);
        if (this.fIH != null) {
            this.fIH.a(this.fNj, gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fNg != null) {
            this.fNg.N(onClickListener);
        }
    }

    public void lc(boolean z) {
        this.fNl = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            ak.c(this.cvr, d.f.selector_topbar_return_black);
        } else {
            ak.c(this.cvr, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cvr.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fNe.setAlpha(1.0f - f);
            this.fNf.setAlpha(f);
        }
    }

    public void ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        cU(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lk(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fIV = aVar;
            this.fMW.e(this.fIV.getUserData());
            if (this.fNi) {
                cU(aVar.azn());
                if (this.blb != null) {
                    this.blb.wS();
                    return;
                }
                return;
            }
            this.fMW.beP();
            this.fMX.e(aVar);
            this.fNb.setPortraitUrl(com.baidu.tbadk.core.util.o.dU(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fNb.bfH();
            } else {
                this.fIV.getUserData().setIsLike(this.fIV.getUserData().getHave_attention() == 1);
                this.fNc.a(this.fIV.getUserData());
            }
            if ((aVar.bfA() == null || this.mIsHost) && v.w(aVar.bfB())) {
                this.fIt.removeHeaderView(this.fNn.acD());
            } else {
                TiebaStatic.log(new al("c12543"));
                this.fNn.a(aVar.bfA(), this.mIsHost, this.fIV.getUserData(), aVar.bfB());
            }
            if (!this.mIsHost) {
                if (aVar.bfC() == null || aVar.bfC().fKm == null || aVar.bfC().fKm.size() <= 0) {
                    this.fIt.removeHeaderView(this.fNk);
                } else {
                    this.fNk.a(aVar.bfC());
                }
            }
            if (v.w(aVar.azn())) {
                cU(null);
                this.fIH.Qq();
                com.baidu.adp.lib.util.l.showToast(this.adf.getContext(), this.adf.getString(d.k.data_load_error));
                return;
            }
            com.baidu.tieba.n.a.bkt().lJ(this.mIsHost);
            cU(aVar.azn());
            int size = aVar.azn().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.azn().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fIH.Qq();
                    return;
                }
            }
            if (z) {
                if (this.blb != null) {
                    this.blb.wS();
                    return;
                }
                return;
            }
            this.fIH.b(true, aVar.azn());
        }
    }

    public void auL() {
        this.fIH.auL();
    }

    private void v(TbPageContext tbPageContext) {
        this.fNh = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.n.b) customResponsedMessage.getData()).geR;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.fMX != null && p.this.fMX.fMt != null) {
                            p.this.fMX.fMt.nf(aVar.eAK);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fIV != null) {
                            if (p.this.fIV.fKc != null && p.this.fIV.fKc.cKd != null && aVar2 != null) {
                                p.this.fIV.fKc.cKd.putBoolean("person_center_item_red_tip_show", aVar2.eAK);
                            }
                            if (aVar3 != null && p.this.fIV.fKb != null && p.this.fIV.fKb.cKd != null) {
                                p.this.fIV.fKb.cKd.putBoolean("person_center_item_red_tip_show", aVar3.eAK);
                            }
                            if (aVar4 != null && p.this.fIV.fJZ != null && p.this.fIV.fJZ.cKd != null) {
                                p.this.fIV.fJZ.cKd.putBoolean("person_center_item_red_tip_show", aVar4.eAK);
                            }
                            if (aVar5 != null && p.this.fIV.fKd != null && p.this.fIV.fKd.cKd != null) {
                                p.this.fIV.fKd.cKd.putBoolean("person_center_item_red_tip_show", aVar5.eAK);
                            }
                            if (aVar6 != null && p.this.fIV.fKe != null && p.this.fIV.fKe.cKd != null) {
                                p.this.fIV.fKe.cKd.putBoolean("person_center_item_red_tip_show", aVar6.eAK);
                                p.this.fIV.fKe.cKd.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.fMW instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.fMW.C(5, aVar7.eAK);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.fMW.C(6, aVar8.eAK);
                            }
                        }
                    }
                }
            }
        };
        this.fNh.setTag(this.aBK);
        tbPageContext.registerListener(this.fNh);
        this.fDH = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    p.this.fMX.rm(hVar.qG());
                }
            }
        };
        this.fDH.setTag(this.aBK);
        tbPageContext.registerListener(this.fDH);
    }

    public void onDestory() {
        if (this.fMX != null) {
            this.fMX.onDestory();
        }
    }

    public com.baidu.tieba.view.f bfN() {
        return this.fMW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aR(boolean z) {
            if (z) {
                if (p.this.cXy == null) {
                    p.this.cXy = new com.baidu.tbadk.h.a(p.this.adf);
                }
                if (p.this.fNc.xo() != null && !StringUtils.isNull(p.this.fNc.xo().getUserId())) {
                    p.this.cXy.gz(p.this.fNc.xo().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.adf.getPageActivity(), p.this.adf.getString(d.k.unlike_success)).tL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        act();
        acu();
        bfP();
        if (this.fMX.acD().getTop() + this.fNd <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fMY = aVar;
    }

    private void act() {
        if (Build.VERSION.SDK_INT >= 11 && this.fMX != null) {
            int top = this.fMX.acD().getTop();
            if (top >= this.fMV) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.fMV) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.fMV));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void acu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bZF) {
                    this.bZF = true;
                }
            } else if (this.bZF) {
                this.bZF = false;
            }
            a(alpha, !this.bZF);
            this.fMW.c(alpha, this.bZF ? false : true);
        }
    }

    private void bfP() {
        if (Build.VERSION.SDK_INT >= 11 && this.fMX != null) {
            int i = this.fMV / 2;
            int i2 = this.fMV - i;
            int top = this.fMX.acD().getTop();
            if (this.fNa != null) {
                if (top < i) {
                    if (this.fNa.getAlpha() != 0.0f) {
                        this.fNa.setAlpha(0.0f);
                    }
                } else if (top < this.fMV && top >= i) {
                    if (i2 > 0) {
                        this.fNa.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.fMV && this.fNa.getAlpha() != 1.0f) {
                    this.fNa.setAlpha(1.0f);
                }
            }
            if (this.fNb != null) {
                if (top >= i) {
                    if (this.fNb.getAlpha() != 0.0f) {
                        this.fNb.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.fNb.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.fNb.getAlpha() != 1.0f) {
                    this.fNb.setAlpha(1.0f);
                }
            }
        }
    }

    public void cU(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fIt.getVisibility() != 0) {
            this.fIt.setVisibility(0);
        }
        this.fIt.setData(list);
        int v = v.v(list);
        if (v >= 5) {
            if (this.fNl) {
                lk(true);
                this.fNl = false;
            }
        } else if (v <= 1) {
            this.fIt.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fMZ = iVar;
    }

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!an.isEmpty(str) && this.fIt != null) {
            this.fNo = str;
            this.fNr = aVar;
            int headerViewsCount = (this.fIt.getHeaderViewsCount() + i) - this.fIt.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.fNp = this.fIt.getChildAt(headerViewsCount);
                if (this.fNp != null) {
                    this.fNq = this.fNp.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.fNp.getLayoutParams().height = p.this.fNq - ((int) (p.this.fNq * f));
                            p.this.fNp.requestLayout();
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
                            p.this.fNp.setVisibility(8);
                            if (p.this.fNr != null) {
                                p.this.fNr.ri(p.this.fNo);
                            }
                        }
                    });
                    animation.setDuration(fMU);
                    this.fNp.startAnimation(animation);
                }
            }
        }
    }

    public void bfQ() {
        if (this.fNs == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.fNs = new com.baidu.tieba.write.c(this.adf, (ViewGroup) this.mRootView, "main_tab");
                this.fNs.uD("3");
            } else {
                return;
            }
        }
        this.fNs.nk(false);
    }
}
