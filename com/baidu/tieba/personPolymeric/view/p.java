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
import com.baidu.tieba.f;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static int gdE = 300;
    private BdUniqueId aqw;
    private NoNetworkView bvB;
    private PbListView bvC;
    private ImageView cFz;
    private PluginErrorTipView cSw;
    private com.baidu.tbadk.i.a dmI;
    private boolean fUa;
    private CustomMessageListener fUp;
    private com.baidu.tieba.personPolymeric.b.d fZC;
    private com.baidu.tieba.personPolymeric.c.a fZP;
    public BdPersonListView fZo;
    private com.baidu.tieba.view.g gcU;
    private int gdF;
    private com.baidu.tieba.view.f gdG;
    public n gdH;
    private com.baidu.tieba.model.a gdI;
    private com.baidu.tieba.view.i gdJ;
    private TextView gdK;
    private LikeButtonWithHeadPortrait gdL;
    private com.baidu.tbadk.core.view.userLike.c gdM;
    private int gdN;
    private TextView gdO;
    private TextView gdP;
    private com.baidu.tieba.personPolymeric.a.n gdQ;
    private CustomMessageListener gdR;
    private View gdT;
    private PersonCenterAttentionBarListView gdU;
    private boolean gdV;
    private k gdX;
    private String gdY;
    private View gdZ;
    private int gea;
    private i.a geb;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cmF = true;
    private int coJ = 0;
    private boolean gdS = false;
    private boolean gdW = false;
    View.OnClickListener aGT = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fZy = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gcU != null) {
                if (p.this.cFz == view) {
                    this.fZy.cVc = 8;
                }
                p.this.gcU.a(view, this.fZy);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gdJ != null) {
                p.this.gdJ.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gdJ != null) {
                    p.this.gdJ.onScroll(absListView, i, i2, i3);
                }
                p.this.bjI();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bvC != null && p.this.gdI != null) {
                p.this.fZC.rz(p.this.coJ);
                if (p.this.coJ == 0) {
                    p.this.bvC.Av();
                    p.this.gdI.g(false, false, false);
                } else if (p.this.coJ == 1) {
                    p.this.bvC.Av();
                    p.this.gdI.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gec = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.biU();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void no() {
            p.this.fZC.aAe();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.fZC.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fUa = false;
        this.mContext = tbPageContext;
        this.aqw = bdUniqueId;
        this.mIsHost = z;
        this.fUa = z2;
        this.fZC = eVar.bjd();
        this.bvC = this.fZC.bvC;
        this.gdF = com.baidu.adp.lib.util.l.f(this.mContext.getPageActivity(), f.e.tbds402);
        if (z) {
            this.gdG = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gdG = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(f.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(f.d.cp_bg_line_c);
        this.bvB = (NoNetworkView) this.mRootView.findViewById(f.g.person_center_no_network_view);
        this.cSw = (PluginErrorTipView) this.mRootView.findViewById(f.g.person_center_plugin_error_tip_view);
        this.fZo = (BdPersonListView) this.mRootView.findViewById(f.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(f.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gdG.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.fZo.setOnScrollListener(this.mOnScrollListener);
        this.gdN = this.mContext.getResources().getDimensionPixelSize(f.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cFz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.cFz.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cFz.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(f.e.ds14);
            this.cFz.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gdK = (TextView) view.findViewById(f.g.tv_title_above_navigation_bar);
        this.gdL = (LikeButtonWithHeadPortrait) view.findViewById(f.g.like_btn_with_head_portrait);
        this.gdM = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gdL);
        this.gdM.setFromType("2");
        this.gdM.h(this.mContext.getUniqueId());
        this.gdM.a(new a());
        this.gdO = (TextView) addCustomView.findViewById(f.g.person_center_navigation_title);
        this.gdP = (TextView) addCustomView.findViewById(f.g.person_center_navigation_another_title);
        if (!this.fUa) {
            this.cFz.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fZo.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gdH = new n(this.mContext, this.mIsHost);
        this.gdT = LayoutInflater.from(this.mContext.getPageActivity()).inflate(f.h.view_header_expand, (ViewGroup) null);
        this.fZo.addHeaderView(this.gdT);
        this.fZo.setExpandView(this.gdT);
        this.fZo.addHeaderView(this.gdH.ahd());
        this.gdX = new k(this.mContext);
        this.fZo.addHeaderView(this.gdX.ahd());
        if (!this.mIsHost) {
            this.gdK.setText(f.j.ta_homepage);
            this.gdU = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.fZo.addHeaderView(this.gdU);
        } else {
            this.gdK.setText(f.j.my_homepage);
        }
        this.fZo.setPersonListRefreshListener(this.gec);
        this.gdQ = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.fZo, this.aqw);
        this.gdQ.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gdL.setAlpha(0.0f);
        this.gdG.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fZP == null) {
            this.gdG.c(1.0f, true);
            am.c(this.cFz, f.C0146f.selector_topbar_return_black);
        } else {
            bjI();
        }
        am.h(this.gdK, f.d.cp_cont_i);
        this.gdL.onChangeSkinType(i);
        am.i(this.mRootView, f.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)));
        if (this.gdG != null) {
            this.gdG.onChangeSkinType(i);
        }
        this.bvB.onChangeSkinType(this.mContext, i);
        this.cSw.onChangeSkinType(this.mContext, i);
        if (this.gdH != null) {
            this.gdH.onChangeSkinType(i);
        }
        if (this.fZo != null && (this.fZo.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fZo.getAdapter().notifyDataSetChanged();
        }
        this.bvC.dB(i);
        am.i(this.mRootView, f.d.cp_bg_line_d);
        if (this.mIsHost) {
            am.b(this.gdP, f.d.cp_cont_b, f.d.s_navbar_title_color);
            am.b(this.gdO, f.d.cp_cont_i, f.d.cp_cont_i);
        }
        if (this.gdU != null) {
            this.gdU.onChangeSkinType(i);
        }
        if (this.gdX != null) {
            this.gdX.onChangeSkinType(i);
        }
    }

    public void ln(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            am.c(this.cFz, f.C0146f.selector_topbar_return_black);
            this.gdG.c(1.0f, true);
            this.gdK.setAlpha(0.0f);
            this.gdL.setAlpha(1.0f);
            this.fZo.setSelectionFromTop(this.fZo.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        am.c(this.cFz, f.C0146f.selector_topbar_return_white);
        this.gdG.c(0.0f, false);
        this.gdK.setAlpha(1.0f);
        this.gdL.setAlpha(0.0f);
    }

    public void biU() {
        this.gdS = false;
        if (this.coJ == 0) {
            if (com.baidu.adp.lib.util.j.jE()) {
                this.gdI.resetData();
                this.gdI.refreshData();
                this.fZC.nn();
                return;
            }
            this.fZC.aAe();
        } else if (this.coJ == 1) {
            if (com.baidu.adp.lib.util.j.jE()) {
                this.gdI.g(true, true, true);
                this.fZC.nn();
                return;
            }
            this.fZC.aAe();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcU = gVar;
        this.gdG.setOnViewResponseListener(gVar);
        this.cFz.setOnClickListener(this.aGT);
        this.gdH.setOnViewResponseListener(gVar);
        if (this.fZC != null) {
            this.fZC.a(this.gdT, gVar);
        }
    }

    public void P(View.OnClickListener onClickListener) {
        if (this.gdQ != null) {
            this.gdQ.P(onClickListener);
        }
    }

    public void lf(boolean z) {
        this.gdV = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            am.c(this.cFz, f.C0146f.selector_topbar_return_black);
        } else {
            am.c(this.cFz, f.C0146f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cFz.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gdO.setAlpha(1.0f - f);
            this.gdP.setAlpha(f);
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
            this.gdG.e(this.fZP.getUserData());
            if (this.gdS) {
                dc(aVar.aFN());
                if (this.bvC != null) {
                    this.bvC.Aw();
                    return;
                }
                return;
            }
            this.gdG.biL();
            this.gdH.e(aVar);
            this.gdL.setPortraitUrl(com.baidu.tbadk.core.util.p.ev(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gdL.bjC();
            } else {
                this.fZP.getUserData().setIsLike(this.fZP.getUserData().getHave_attention() == 1);
                this.gdM.a(this.fZP.getUserData());
            }
            if ((aVar.bjv() == null || this.mIsHost) && w.z(aVar.bjw())) {
                this.fZo.removeHeaderView(this.gdX.ahd());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.gdX.a(aVar.bjv(), this.mIsHost, this.fZP.getUserData(), aVar.bjw());
            }
            if (!this.mIsHost) {
                if (aVar.bjx() == null || aVar.bjx().gaV == null || aVar.bjx().gaV.size() <= 0) {
                    this.fZo.removeHeaderView(this.gdU);
                } else {
                    this.gdU.a(aVar.bjx());
                }
            }
            if (w.z(aVar.aFN())) {
                dc(null);
                this.fZC.Uq();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(f.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.boy().lL(this.mIsHost);
            dc(aVar.aFN());
            int size = aVar.aFN().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aFN().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fZC.Uq();
                    return;
                }
            }
            if (z) {
                if (this.bvC != null) {
                    this.bvC.Aw();
                    return;
                }
                return;
            }
            this.fZC.c(true, aVar.aFN());
        }
    }

    public void aAe() {
        this.fZC.aAe();
    }

    private void w(TbPageContext tbPageContext) {
        this.gdR = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gwy;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gdH != null && p.this.gdH.gdc != null) {
                            p.this.gdH.gdc.nj(aVar.eUT);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fZP != null) {
                            if (p.this.fZP.gaL != null && p.this.fZP.gaL.cVd != null && aVar2 != null) {
                                p.this.fZP.gaL.cVd.putBoolean("person_center_item_red_tip_show", aVar2.eUT);
                            }
                            if (aVar3 != null && p.this.fZP.gaK != null && p.this.fZP.gaK.cVd != null) {
                                p.this.fZP.gaK.cVd.putBoolean("person_center_item_red_tip_show", aVar3.eUT);
                            }
                            if (aVar4 != null && p.this.fZP.gaI != null && p.this.fZP.gaI.cVd != null) {
                                p.this.fZP.gaI.cVd.putBoolean("person_center_item_red_tip_show", aVar4.eUT);
                            }
                            if (aVar5 != null && p.this.fZP.gaM != null && p.this.fZP.gaM.cVd != null) {
                                p.this.fZP.gaM.cVd.putBoolean("person_center_item_red_tip_show", aVar5.eUT);
                            }
                            if (aVar6 != null && p.this.fZP.gaN != null && p.this.fZP.gaN.cVd != null) {
                                p.this.fZP.gaN.cVd.putBoolean("person_center_item_red_tip_show", aVar6.eUT);
                                p.this.fZP.gaN.cVd.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gdG instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gdG.B(5, aVar7.eUT);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gdG.B(6, aVar8.eUT);
                            }
                        }
                    }
                }
            }
        };
        this.gdR.setTag(this.aqw);
        tbPageContext.registerListener(this.gdR);
        this.fUp = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    p.this.gdH.sc(iVar.tT());
                }
            }
        };
        this.fUp.setTag(this.aqw);
        tbPageContext.registerListener(this.fUp);
    }

    public void onDestory() {
        if (this.gdH != null) {
            this.gdH.onDestory();
        }
    }

    public com.baidu.tieba.view.f bjH() {
        return this.gdG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aX(boolean z) {
            if (z) {
                if (p.this.dmI == null) {
                    p.this.dmI = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gdM.AU() != null && !StringUtils.isNull(p.this.gdM.AU().getUserId())) {
                    p.this.dmI.gX(p.this.gdM.AU().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(f.j.unlike_success)).xm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjI() {
        agS();
        agT();
        bjJ();
        if (this.gdH.ahd().getTop() + this.gdN <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gdI = aVar;
    }

    private void agS() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdH != null) {
            int top = this.gdH.ahd().getTop();
            if (top >= this.gdF) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gdF) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gdF));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void agT() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cmF) {
                    this.cmF = true;
                }
            } else if (this.cmF) {
                this.cmF = false;
            }
            a(alpha, !this.cmF);
            this.gdG.c(alpha, this.cmF ? false : true);
        }
    }

    private void bjJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdH != null) {
            int i = this.gdF / 2;
            int i2 = this.gdF - i;
            int top = this.gdH.ahd().getTop();
            if (this.gdK != null) {
                if (top < i) {
                    if (this.gdK.getAlpha() != 0.0f) {
                        this.gdK.setAlpha(0.0f);
                    }
                } else if (top < this.gdF && top >= i) {
                    if (i2 > 0) {
                        this.gdK.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gdF && this.gdK.getAlpha() != 1.0f) {
                    this.gdK.setAlpha(1.0f);
                }
            }
            if (this.gdL != null) {
                if (top >= i) {
                    if (this.gdL.getAlpha() != 0.0f) {
                        this.gdL.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gdL.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gdL.getAlpha() != 1.0f) {
                    this.gdL.setAlpha(1.0f);
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
            if (this.gdV) {
                ln(true);
                this.gdV = false;
            }
        } else if (y <= 1) {
            this.fZo.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gdJ = iVar;
    }

    public NavigationBar Vj() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.fZo != null) {
            this.gdY = str;
            this.geb = aVar;
            int headerViewsCount = (this.fZo.getHeaderViewsCount() + i) - this.fZo.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gdZ = this.fZo.getChildAt(headerViewsCount);
                if (this.gdZ != null) {
                    this.gea = this.gdZ.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gdZ.getLayoutParams().height = p.this.gea - ((int) (p.this.gea * f));
                            p.this.gdZ.requestLayout();
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
                            p.this.gdZ.setVisibility(8);
                            if (p.this.geb != null) {
                                p.this.geb.rY(p.this.gdY);
                            }
                        }
                    });
                    animation.setDuration(gdE);
                    this.gdZ.startAnimation(animation);
                }
            }
        }
    }
}
