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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static int gdF = 300;
    private BdUniqueId aqv;
    private PbListView bvA;
    private NoNetworkView bvz;
    private ImageView cFC;
    private PluginErrorTipView cSz;
    private com.baidu.tbadk.i.a dmK;
    private boolean fUi;
    private CustomMessageListener fUw;
    private com.baidu.tieba.personPolymeric.b.d fZC;
    private com.baidu.tieba.personPolymeric.c.a fZP;
    public BdPersonListView fZo;
    private com.baidu.tieba.view.g gcV;
    private int gdG;
    private com.baidu.tieba.view.f gdH;
    public n gdI;
    private com.baidu.tieba.model.a gdJ;
    private com.baidu.tieba.view.i gdK;
    private TextView gdL;
    private LikeButtonWithHeadPortrait gdM;
    private com.baidu.tbadk.core.view.userLike.c gdN;
    private int gdO;
    private TextView gdP;
    private TextView gdQ;
    private com.baidu.tieba.personPolymeric.a.n gdR;
    private CustomMessageListener gdS;
    private View gdU;
    private PersonCenterAttentionBarListView gdV;
    private boolean gdW;
    private k gdY;
    private String gdZ;
    private View gea;
    private int geb;
    private i.a gec;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cmI = true;
    private int coM = 0;
    private boolean gdT = false;
    private boolean gdX = false;
    View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fZy = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gcV != null) {
                if (p.this.cFC == view) {
                    this.fZy.cVg = 8;
                }
                p.this.gcV.a(view, this.fZy);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gdK != null) {
                p.this.gdK.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gdK != null) {
                    p.this.gdK.onScroll(absListView, i, i2, i3);
                }
                p.this.bjL();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bvA != null && p.this.gdJ != null) {
                p.this.fZC.rz(p.this.coM);
                if (p.this.coM == 0) {
                    p.this.bvA.Ax();
                    p.this.gdJ.g(false, false, false);
                } else if (p.this.coM == 1) {
                    p.this.bvA.Ax();
                    p.this.gdJ.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a ged = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.biX();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void no() {
            p.this.fZC.aAh();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.fZC.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fUi = false;
        this.mContext = tbPageContext;
        this.aqv = bdUniqueId;
        this.mIsHost = z;
        this.fUi = z2;
        this.fZC = eVar.bjg();
        this.bvA = this.fZC.bvA;
        this.gdG = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.gdH = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gdH = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0140d.cp_bg_line_c);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cSz = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fZo = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gdH.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.fZo.setOnScrollListener(this.mOnScrollListener);
        this.gdO = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cFC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.cFC.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cFC.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.cFC.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gdL = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.gdM = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.gdN = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gdM);
        this.gdN.setFromType("2");
        this.gdN.h(this.mContext.getUniqueId());
        this.gdN.a(new a());
        this.gdP = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.gdQ = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fUi) {
            this.cFC.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fZo.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gdI = new n(this.mContext, this.mIsHost);
        this.gdU = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.fZo.addHeaderView(this.gdU);
        this.fZo.setExpandView(this.gdU);
        this.fZo.addHeaderView(this.gdI.ahb());
        this.gdY = new k(this.mContext);
        this.fZo.addHeaderView(this.gdY.ahb());
        if (!this.mIsHost) {
            this.gdL.setText(d.j.ta_homepage);
            this.gdV = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.fZo.addHeaderView(this.gdV);
        } else {
            this.gdL.setText(d.j.my_homepage);
        }
        this.fZo.setPersonListRefreshListener(this.ged);
        this.gdR = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.fZo, this.aqv);
        this.gdR.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gdM.setAlpha(0.0f);
        this.gdH.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fZP == null) {
            this.gdH.c(1.0f, true);
            am.c(this.cFC, d.f.selector_topbar_return_black);
        } else {
            bjL();
        }
        am.h(this.gdL, d.C0140d.cp_cont_i);
        this.gdM.onChangeSkinType(i);
        am.i(this.mRootView, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)));
        if (this.gdH != null) {
            this.gdH.onChangeSkinType(i);
        }
        this.bvz.onChangeSkinType(this.mContext, i);
        this.cSz.onChangeSkinType(this.mContext, i);
        if (this.gdI != null) {
            this.gdI.onChangeSkinType(i);
        }
        if (this.fZo != null && (this.fZo.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fZo.getAdapter().notifyDataSetChanged();
        }
        this.bvA.dC(i);
        am.i(this.mRootView, d.C0140d.cp_bg_line_d);
        if (this.mIsHost) {
            am.b(this.gdQ, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            am.b(this.gdP, d.C0140d.cp_cont_i, d.C0140d.cp_cont_i);
        }
        if (this.gdV != null) {
            this.gdV.onChangeSkinType(i);
        }
        if (this.gdY != null) {
            this.gdY.onChangeSkinType(i);
        }
    }

    public void ln(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            am.c(this.cFC, d.f.selector_topbar_return_black);
            this.gdH.c(1.0f, true);
            this.gdL.setAlpha(0.0f);
            this.gdM.setAlpha(1.0f);
            this.fZo.setSelectionFromTop(this.fZo.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        am.c(this.cFC, d.f.selector_topbar_return_white);
        this.gdH.c(0.0f, false);
        this.gdL.setAlpha(1.0f);
        this.gdM.setAlpha(0.0f);
    }

    public void biX() {
        this.gdT = false;
        if (this.coM == 0) {
            if (com.baidu.adp.lib.util.j.jE()) {
                this.gdJ.resetData();
                this.gdJ.refreshData();
                this.fZC.nn();
                return;
            }
            this.fZC.aAh();
        } else if (this.coM == 1) {
            if (com.baidu.adp.lib.util.j.jE()) {
                this.gdJ.g(true, true, true);
                this.fZC.nn();
                return;
            }
            this.fZC.aAh();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcV = gVar;
        this.gdH.setOnViewResponseListener(gVar);
        this.cFC.setOnClickListener(this.aGU);
        this.gdI.setOnViewResponseListener(gVar);
        if (this.fZC != null) {
            this.fZC.a(this.gdU, gVar);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.gdR != null) {
            this.gdR.P(onClickListener);
        }
    }

    public void lf(boolean z) {
        this.gdW = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            am.c(this.cFC, d.f.selector_topbar_return_black);
        } else {
            am.c(this.cFC, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cFC.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gdP.setAlpha(1.0f - f);
            this.gdQ.setAlpha(f);
        }
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dc(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        ln(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fZP = aVar;
            this.gdH.e(this.fZP.getUserData());
            if (this.gdT) {
                dc(aVar.aFQ());
                if (this.bvA != null) {
                    this.bvA.Ay();
                    return;
                }
                return;
            }
            this.gdH.biO();
            this.gdI.e(aVar);
            this.gdM.setPortraitUrl(com.baidu.tbadk.core.util.p.ev(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gdM.bjF();
            } else {
                this.fZP.getUserData().setIsLike(this.fZP.getUserData().getHave_attention() == 1);
                this.gdN.a(this.fZP.getUserData());
            }
            if ((aVar.bjy() == null || this.mIsHost) && w.z(aVar.bjz())) {
                this.fZo.removeHeaderView(this.gdY.ahb());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.gdY.a(aVar.bjy(), this.mIsHost, this.fZP.getUserData(), aVar.bjz());
            }
            if (!this.mIsHost) {
                if (aVar.bjA() == null || aVar.bjA().gaV == null || aVar.bjA().gaV.size() <= 0) {
                    this.fZo.removeHeaderView(this.gdV);
                } else {
                    this.gdV.a(aVar.bjA());
                }
            }
            if (w.z(aVar.aFQ())) {
                dc(null);
                this.fZC.Un();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.box().lL(this.mIsHost);
            dc(aVar.aFQ());
            int size = aVar.aFQ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aFQ().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fZC.Un();
                    return;
                }
            }
            if (z) {
                if (this.bvA != null) {
                    this.bvA.Ay();
                    return;
                }
                return;
            }
            this.fZC.c(true, aVar.aFQ());
        }
    }

    public void aAh() {
        this.fZC.aAh();
    }

    private void w(TbPageContext tbPageContext) {
        this.gdS = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gwv;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gdI != null && p.this.gdI.gdd != null) {
                            p.this.gdI.gdd.nj(aVar.eUY);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fZP != null) {
                            if (p.this.fZP.gaL != null && p.this.fZP.gaL.cVh != null && aVar2 != null) {
                                p.this.fZP.gaL.cVh.putBoolean("person_center_item_red_tip_show", aVar2.eUY);
                            }
                            if (aVar3 != null && p.this.fZP.gaK != null && p.this.fZP.gaK.cVh != null) {
                                p.this.fZP.gaK.cVh.putBoolean("person_center_item_red_tip_show", aVar3.eUY);
                            }
                            if (aVar4 != null && p.this.fZP.gaI != null && p.this.fZP.gaI.cVh != null) {
                                p.this.fZP.gaI.cVh.putBoolean("person_center_item_red_tip_show", aVar4.eUY);
                            }
                            if (aVar5 != null && p.this.fZP.gaM != null && p.this.fZP.gaM.cVh != null) {
                                p.this.fZP.gaM.cVh.putBoolean("person_center_item_red_tip_show", aVar5.eUY);
                            }
                            if (aVar6 != null && p.this.fZP.gaN != null && p.this.fZP.gaN.cVh != null) {
                                p.this.fZP.gaN.cVh.putBoolean("person_center_item_red_tip_show", aVar6.eUY);
                                p.this.fZP.gaN.cVh.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gdH instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gdH.B(5, aVar7.eUY);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gdH.B(6, aVar8.eUY);
                            }
                        }
                    }
                }
            }
        };
        this.gdS.setTag(this.aqv);
        tbPageContext.registerListener(this.gdS);
        this.fUw = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    p.this.gdI.rZ(iVar.tU());
                }
            }
        };
        this.fUw.setTag(this.aqv);
        tbPageContext.registerListener(this.fUw);
    }

    public void onDestory() {
        if (this.gdI != null) {
            this.gdI.onDestory();
        }
    }

    public com.baidu.tieba.view.f bjK() {
        return this.gdH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aW(boolean z) {
            if (z) {
                if (p.this.dmK == null) {
                    p.this.dmK = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gdN.AX() != null && !StringUtils.isNull(p.this.gdN.AX().getUserId())) {
                    p.this.dmK.gX(p.this.gdN.AX().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.j.unlike_success)).xn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjL() {
        agQ();
        agR();
        bjM();
        if (this.gdI.ahb().getTop() + this.gdO <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gdJ = aVar;
    }

    private void agQ() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdI != null) {
            int top = this.gdI.ahb().getTop();
            if (top >= this.gdG) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gdG) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gdG));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void agR() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cmI) {
                    this.cmI = true;
                }
            } else if (this.cmI) {
                this.cmI = false;
            }
            a(alpha, !this.cmI);
            this.gdH.c(alpha, this.cmI ? false : true);
        }
    }

    private void bjM() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdI != null) {
            int i = this.gdG / 2;
            int i2 = this.gdG - i;
            int top = this.gdI.ahb().getTop();
            if (this.gdL != null) {
                if (top < i) {
                    if (this.gdL.getAlpha() != 0.0f) {
                        this.gdL.setAlpha(0.0f);
                    }
                } else if (top < this.gdG && top >= i) {
                    if (i2 > 0) {
                        this.gdL.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gdG && this.gdL.getAlpha() != 1.0f) {
                    this.gdL.setAlpha(1.0f);
                }
            }
            if (this.gdM != null) {
                if (top >= i) {
                    if (this.gdM.getAlpha() != 0.0f) {
                        this.gdM.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gdM.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gdM.getAlpha() != 1.0f) {
                    this.gdM.setAlpha(1.0f);
                }
            }
        }
    }

    public void dc(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.z(list)) {
            list = new ArrayList<>();
        }
        if (this.fZo.getVisibility() != 0) {
            this.fZo.setVisibility(0);
        }
        this.fZo.setData(list);
        int y = w.y(list);
        if (y >= 5) {
            if (this.gdW) {
                ln(true);
                this.gdW = false;
            }
        } else if (y <= 1) {
            this.fZo.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gdK = iVar;
    }

    public NavigationBar Vf() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.fZo != null) {
            this.gdZ = str;
            this.gec = aVar;
            int headerViewsCount = (this.fZo.getHeaderViewsCount() + i) - this.fZo.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gea = this.fZo.getChildAt(headerViewsCount);
                if (this.gea != null) {
                    this.geb = this.gea.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gea.getLayoutParams().height = p.this.geb - ((int) (p.this.geb * f));
                            p.this.gea.requestLayout();
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
                            p.this.gea.setVisibility(8);
                            if (p.this.gec != null) {
                                p.this.gec.rV(p.this.gdZ);
                            }
                        }
                    });
                    animation.setDuration(gdF);
                    this.gea.startAnimation(animation);
                }
            }
        }
    }
}
