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
    public static int fMX = 300;
    private BdUniqueId aBK;
    private TbPageContext adf;
    private NoNetworkView bla;
    private PbListView blb;
    private PluginErrorTipView cHC;
    private com.baidu.tbadk.h.a cXB;
    private ImageView cvu;
    private CustomMessageListener fDK;
    private boolean fDw;
    private com.baidu.tieba.personPolymeric.b.d fIK;
    private com.baidu.tieba.personPolymeric.c.a fIY;
    public BdPersonListView fIw;
    private int fMY;
    private com.baidu.tieba.view.f fMZ;
    private com.baidu.tieba.view.g fMo;
    public n fNa;
    private com.baidu.tieba.model.a fNb;
    private com.baidu.tieba.view.i fNc;
    private TextView fNd;
    private LikeButtonWithHeadPortrait fNe;
    private com.baidu.tbadk.core.view.userLike.c fNf;
    private int fNg;
    private TextView fNh;
    private TextView fNi;
    private com.baidu.tieba.personPolymeric.a.n fNj;
    private CustomMessageListener fNk;
    private View fNm;
    private PersonCenterAttentionBarListView fNn;
    private boolean fNo;
    private k fNq;
    private String fNr;
    private View fNs;
    private int fNt;
    private i.a fNu;
    private com.baidu.tieba.write.c fNv;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bZI = true;
    private int cbx = 0;
    private boolean fNl = false;
    private boolean fNp = false;
    View.OnClickListener axG = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fIG = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (p.this.fMo != null) {
                if (p.this.cvu == view2) {
                    this.fIG.cKf = 8;
                }
                p.this.fMo.a(view2, this.fIG);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.fNc != null) {
                p.this.fNc.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.fNc != null) {
                    p.this.fNc.onScroll(absListView, i, i2, i3);
                }
                p.this.bfO();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.blb != null && p.this.fNb != null) {
                p.this.fIK.rj(p.this.cbx);
                if (p.this.cbx == 0) {
                    p.this.blb.wR();
                    p.this.fNb.h(false, false, false);
                } else if (p.this.cbx == 1) {
                    p.this.blb.wR();
                    p.this.fNb.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fNw = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.beY();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kz() {
            p.this.fIK.auL();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void D(float f) {
            p.this.fIK.C(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fDw = false;
        this.adf = tbPageContext;
        this.aBK = bdUniqueId;
        this.mIsHost = z;
        this.fDw = z2;
        this.fIK = eVar.bfh();
        this.blb = this.fIK.blb;
        this.fMY = com.baidu.adp.lib.util.l.e(this.adf.getPageActivity(), d.e.tbds402);
        if (z) {
            this.fMZ = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.fMZ = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view2) {
        this.mRootView = view2;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0126d.cp_bg_line_c);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cHC = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fIw = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.adf.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fMZ.a(this.adf.getPageActivity(), this.mNavigationBar);
        this.fIw.setOnScrollListener(this.mOnScrollListener);
        this.fNg = this.adf.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cvu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.cvu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cvu.getLayoutParams();
            layoutParams2.leftMargin = this.adf.getResources().getDimensionPixelSize(d.e.ds14);
            this.cvu.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fNd = (TextView) view2.findViewById(d.g.tv_title_above_navigation_bar);
        this.fNe = (LikeButtonWithHeadPortrait) view2.findViewById(d.g.like_btn_with_head_portrait);
        this.fNf = new com.baidu.tbadk.core.view.userLike.c(this.adf, this.fNe);
        this.fNf.setFromType("2");
        this.fNf.h(this.adf.getUniqueId());
        this.fNf.a(new a());
        this.fNh = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.fNi = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fDw) {
            this.cvu.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fIw.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fNa = new n(this.adf, this.mIsHost);
        this.fNm = LayoutInflater.from(this.adf.getPageActivity()).inflate(d.i.view_header_expand, (ViewGroup) null);
        this.fIw.addHeaderView(this.fNm);
        this.fIw.setExpandView(this.fNm);
        this.fIw.addHeaderView(this.fNa.acD());
        this.fNq = new k(this.adf);
        this.fIw.addHeaderView(this.fNq.acD());
        if (!this.mIsHost) {
            this.fNd.setText(d.k.ta_homepage);
            this.fNn = new PersonCenterAttentionBarListView(this.adf.getPageActivity());
            this.fIw.addHeaderView(this.fNn);
        } else {
            this.fNd.setText(d.k.my_homepage);
        }
        this.fIw.setPersonListRefreshListener(this.fNw);
        this.fNj = new com.baidu.tieba.personPolymeric.a.n(this.adf, this.fIw, this.aBK);
        this.fNj.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fNe.setAlpha(0.0f);
        this.fMZ.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fIY == null) {
            this.fMZ.c(1.0f, true);
            ak.c(this.cvu, d.f.selector_topbar_return_black);
        } else {
            bfO();
        }
        ak.h(this.fNd, d.C0126d.cp_cont_i);
        this.fNe.onChangeSkinType(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)));
        if (this.fMZ != null) {
            this.fMZ.onChangeSkinType(i);
        }
        this.bla.onChangeSkinType(this.adf, i);
        this.cHC.onChangeSkinType(this.adf, i);
        if (this.fNa != null) {
            this.fNa.onChangeSkinType(i);
        }
        if (this.fIw != null && (this.fIw.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fIw.getAdapter().notifyDataSetChanged();
        }
        this.blb.dw(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.mIsHost) {
            ak.b(this.fNi, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            ak.b(this.fNh, d.C0126d.cp_cont_i, d.C0126d.cp_cont_i);
        }
        if (this.fNn != null) {
            this.fNn.onChangeSkinType(i);
        }
        if (this.fNq != null) {
            this.fNq.onChangeSkinType(i);
        }
    }

    public void lk(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            ak.c(this.cvu, d.f.selector_topbar_return_black);
            this.fMZ.c(1.0f, true);
            this.fNd.setAlpha(0.0f);
            this.fNe.setAlpha(1.0f);
            this.fIw.setSelectionFromTop(this.fIw.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        ak.c(this.cvu, d.f.selector_topbar_return_white);
        this.fMZ.c(0.0f, false);
        this.fNd.setAlpha(1.0f);
        this.fNe.setAlpha(0.0f);
    }

    public void beY() {
        this.fNl = false;
        if (this.cbx == 0) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fNb.resetData();
                this.fNb.refreshData();
                this.fIK.ky();
                return;
            }
            this.fIK.auL();
        } else if (this.cbx == 1) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fNb.h(true, true, true);
                this.fIK.ky();
                return;
            }
            this.fIK.auL();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fMo = gVar;
        this.fMZ.setOnViewResponseListener(gVar);
        this.cvu.setOnClickListener(this.axG);
        this.fNa.setOnViewResponseListener(gVar);
        if (this.fIK != null) {
            this.fIK.a(this.fNm, gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fNj != null) {
            this.fNj.N(onClickListener);
        }
    }

    public void lc(boolean z) {
        this.fNo = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            ak.c(this.cvu, d.f.selector_topbar_return_black);
        } else {
            ak.c(this.cvu, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cvu.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fNh.setAlpha(1.0f - f);
            this.fNi.setAlpha(f);
        }
    }

    public void ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        cU(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lk(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fIY = aVar;
            this.fMZ.e(this.fIY.getUserData());
            if (this.fNl) {
                cU(aVar.azn());
                if (this.blb != null) {
                    this.blb.wS();
                    return;
                }
                return;
            }
            this.fMZ.beP();
            this.fNa.e(aVar);
            this.fNe.setPortraitUrl(com.baidu.tbadk.core.util.o.dU(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fNe.bfH();
            } else {
                this.fIY.getUserData().setIsLike(this.fIY.getUserData().getHave_attention() == 1);
                this.fNf.a(this.fIY.getUserData());
            }
            if ((aVar.bfA() == null || this.mIsHost) && v.w(aVar.bfB())) {
                this.fIw.removeHeaderView(this.fNq.acD());
            } else {
                TiebaStatic.log(new al("c12543"));
                this.fNq.a(aVar.bfA(), this.mIsHost, this.fIY.getUserData(), aVar.bfB());
            }
            if (!this.mIsHost) {
                if (aVar.bfC() == null || aVar.bfC().fKp == null || aVar.bfC().fKp.size() <= 0) {
                    this.fIw.removeHeaderView(this.fNn);
                } else {
                    this.fNn.a(aVar.bfC());
                }
            }
            if (v.w(aVar.azn())) {
                cU(null);
                this.fIK.Qq();
                com.baidu.adp.lib.util.l.showToast(this.adf.getContext(), this.adf.getString(d.k.data_load_error));
                return;
            }
            com.baidu.tieba.n.a.bkt().lJ(this.mIsHost);
            cU(aVar.azn());
            int size = aVar.azn().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.azn().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fIK.Qq();
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
            this.fIK.b(true, aVar.azn());
        }
    }

    public void auL() {
        this.fIK.auL();
    }

    private void v(TbPageContext tbPageContext) {
        this.fNk = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.n.b) customResponsedMessage.getData()).geU;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.fNa != null && p.this.fNa.fMw != null) {
                            p.this.fNa.fMw.nf(aVar.eAN);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fIY != null) {
                            if (p.this.fIY.fKf != null && p.this.fIY.fKf.cKg != null && aVar2 != null) {
                                p.this.fIY.fKf.cKg.putBoolean("person_center_item_red_tip_show", aVar2.eAN);
                            }
                            if (aVar3 != null && p.this.fIY.fKe != null && p.this.fIY.fKe.cKg != null) {
                                p.this.fIY.fKe.cKg.putBoolean("person_center_item_red_tip_show", aVar3.eAN);
                            }
                            if (aVar4 != null && p.this.fIY.fKc != null && p.this.fIY.fKc.cKg != null) {
                                p.this.fIY.fKc.cKg.putBoolean("person_center_item_red_tip_show", aVar4.eAN);
                            }
                            if (aVar5 != null && p.this.fIY.fKg != null && p.this.fIY.fKg.cKg != null) {
                                p.this.fIY.fKg.cKg.putBoolean("person_center_item_red_tip_show", aVar5.eAN);
                            }
                            if (aVar6 != null && p.this.fIY.fKh != null && p.this.fIY.fKh.cKg != null) {
                                p.this.fIY.fKh.cKg.putBoolean("person_center_item_red_tip_show", aVar6.eAN);
                                p.this.fIY.fKh.cKg.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.fMZ instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.fMZ.C(5, aVar7.eAN);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.fMZ.C(6, aVar8.eAN);
                            }
                        }
                    }
                }
            }
        };
        this.fNk.setTag(this.aBK);
        tbPageContext.registerListener(this.fNk);
        this.fDK = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    p.this.fNa.rm(hVar.qG());
                }
            }
        };
        this.fDK.setTag(this.aBK);
        tbPageContext.registerListener(this.fDK);
    }

    public void onDestory() {
        if (this.fNa != null) {
            this.fNa.onDestory();
        }
    }

    public com.baidu.tieba.view.f bfN() {
        return this.fMZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aR(boolean z) {
            if (z) {
                if (p.this.cXB == null) {
                    p.this.cXB = new com.baidu.tbadk.h.a(p.this.adf);
                }
                if (p.this.fNf.xo() != null && !StringUtils.isNull(p.this.fNf.xo().getUserId())) {
                    p.this.cXB.gz(p.this.fNf.xo().getUserId());
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
        if (this.fNa.acD().getTop() + this.fNg <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fNb = aVar;
    }

    private void act() {
        if (Build.VERSION.SDK_INT >= 11 && this.fNa != null) {
            int top = this.fNa.acD().getTop();
            if (top >= this.fMY) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.fMY) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.fMY));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void acu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bZI) {
                    this.bZI = true;
                }
            } else if (this.bZI) {
                this.bZI = false;
            }
            a(alpha, !this.bZI);
            this.fMZ.c(alpha, this.bZI ? false : true);
        }
    }

    private void bfP() {
        if (Build.VERSION.SDK_INT >= 11 && this.fNa != null) {
            int i = this.fMY / 2;
            int i2 = this.fMY - i;
            int top = this.fNa.acD().getTop();
            if (this.fNd != null) {
                if (top < i) {
                    if (this.fNd.getAlpha() != 0.0f) {
                        this.fNd.setAlpha(0.0f);
                    }
                } else if (top < this.fMY && top >= i) {
                    if (i2 > 0) {
                        this.fNd.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.fMY && this.fNd.getAlpha() != 1.0f) {
                    this.fNd.setAlpha(1.0f);
                }
            }
            if (this.fNe != null) {
                if (top >= i) {
                    if (this.fNe.getAlpha() != 0.0f) {
                        this.fNe.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.fNe.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.fNe.getAlpha() != 1.0f) {
                    this.fNe.setAlpha(1.0f);
                }
            }
        }
    }

    public void cU(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fIw.getVisibility() != 0) {
            this.fIw.setVisibility(0);
        }
        this.fIw.setData(list);
        int v = v.v(list);
        if (v >= 5) {
            if (this.fNo) {
                lk(true);
                this.fNo = false;
            }
        } else if (v <= 1) {
            this.fIw.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fNc = iVar;
    }

    public NavigationBar Rg() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!an.isEmpty(str) && this.fIw != null) {
            this.fNr = str;
            this.fNu = aVar;
            int headerViewsCount = (this.fIw.getHeaderViewsCount() + i) - this.fIw.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.fNs = this.fIw.getChildAt(headerViewsCount);
                if (this.fNs != null) {
                    this.fNt = this.fNs.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.fNs.getLayoutParams().height = p.this.fNt - ((int) (p.this.fNt * f));
                            p.this.fNs.requestLayout();
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
                            p.this.fNs.setVisibility(8);
                            if (p.this.fNu != null) {
                                p.this.fNu.ri(p.this.fNr);
                            }
                        }
                    });
                    animation.setDuration(fMX);
                    this.fNs.startAnimation(animation);
                }
            }
        }
    }

    public void bfQ() {
        if (this.fNv == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.fNv = new com.baidu.tieba.write.c(this.adf, (ViewGroup) this.mRootView, "main_tab");
                this.fNv.uD("3");
            } else {
                return;
            }
        }
        this.fNv.nk(false);
    }
}
