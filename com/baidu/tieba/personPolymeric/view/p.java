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
    public static int gsv = 300;
    private BdUniqueId axF;
    private NoNetworkView bJX;
    private PbListView bJY;
    private ImageView cTJ;
    private com.baidu.tbadk.i.a dAG;
    private PluginErrorTipView dgD;
    private boolean giT;
    private CustomMessageListener gji;
    private com.baidu.tieba.personPolymeric.c.a goI;
    public BdPersonListView goh;
    private com.baidu.tieba.personPolymeric.b.d gov;
    private com.baidu.tieba.view.g grL;
    private com.baidu.tieba.view.i gsA;
    private TextView gsB;
    private LikeButtonWithHeadPortrait gsC;
    private com.baidu.tbadk.core.view.userLike.c gsD;
    private int gsE;
    private TextView gsF;
    private TextView gsG;
    private com.baidu.tieba.personPolymeric.a.n gsH;
    private CustomMessageListener gsI;
    private View gsK;
    private PersonCenterAttentionBarListView gsL;
    private boolean gsM;
    private k gsO;
    private String gsP;
    private View gsQ;
    private int gsR;
    private i.a gsS;
    private int gsw;
    private com.baidu.tieba.view.f gsx;
    public n gsy;
    private com.baidu.tieba.model.a gsz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cBa = true;
    private int cDd = 0;
    private boolean gsJ = false;
    private boolean gsN = false;
    View.OnClickListener aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gor = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.grL != null) {
                if (p.this.cTJ == view) {
                    this.gor.djg = 8;
                }
                p.this.grL.a(view, this.gor);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gsA != null) {
                p.this.gsA.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gsA != null) {
                    p.this.gsA.onScroll(absListView, i, i2, i3);
                }
                p.this.bpu();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bJY != null && p.this.gsz != null) {
                p.this.gov.st(p.this.cDd);
                if (p.this.cDd == 0) {
                    p.this.bJY.DO();
                    p.this.gsz.g(false, false, false);
                } else if (p.this.cDd == 1) {
                    p.this.bJY.DO();
                    p.this.gsz.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gsT = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.boG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oF() {
            p.this.gov.aFG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gov.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.giT = false;
        this.mContext = tbPageContext;
        this.axF = bdUniqueId;
        this.mIsHost = z;
        this.giT = z2;
        this.gov = eVar.boP();
        this.bJY = this.gov.bJY;
        this.gsw = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.tbds402);
        if (z) {
            this.gsx = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gsx = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.dgD = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.goh = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gsx.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.goh.setOnScrollListener(this.mOnScrollListener);
        this.gsE = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cTJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.cTJ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cTJ.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds14);
            this.cTJ.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gsB = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gsC = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gsD = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gsC);
        this.gsD.setFromType("2");
        this.gsD.h(this.mContext.getUniqueId());
        this.gsD.a(new a());
        this.gsF = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gsG = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.giT) {
            this.cTJ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.goh.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gsy = new n(this.mContext, this.mIsHost);
        this.gsK = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.goh.addHeaderView(this.gsK);
        this.goh.setExpandView(this.gsK);
        this.goh.addHeaderView(this.gsy.amu());
        this.gsO = new k(this.mContext);
        this.goh.addHeaderView(this.gsO.amu());
        if (!this.mIsHost) {
            this.gsB.setText(e.j.ta_homepage);
            this.gsL = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.goh.addHeaderView(this.gsL);
        } else {
            this.gsB.setText(e.j.my_homepage);
        }
        this.goh.setPersonListRefreshListener(this.gsT);
        this.gsH = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.goh, this.axF);
        this.gsH.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gsC.setAlpha(0.0f);
        this.gsx.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.goI == null) {
            this.gsx.c(1.0f, true);
            al.c(this.cTJ, e.f.selector_topbar_return_black);
        } else {
            bpu();
        }
        al.h(this.gsB, e.d.cp_cont_i);
        this.gsC.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)));
        if (this.gsx != null) {
            this.gsx.onChangeSkinType(i);
        }
        this.bJX.onChangeSkinType(this.mContext, i);
        this.dgD.onChangeSkinType(this.mContext, i);
        if (this.gsy != null) {
            this.gsy.onChangeSkinType(i);
        }
        if (this.goh != null && (this.goh.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.goh.getAdapter().notifyDataSetChanged();
        }
        this.bJY.dW(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gsG, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gsF, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gsL != null) {
            this.gsL.onChangeSkinType(i);
        }
        if (this.gsO != null) {
            this.gsO.onChangeSkinType(i);
        }
    }

    public void ma(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.cTJ, e.f.selector_topbar_return_black);
            this.gsx.c(1.0f, true);
            this.gsB.setAlpha(0.0f);
            this.gsC.setAlpha(1.0f);
            this.goh.setSelectionFromTop(this.goh.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.cTJ, e.f.selector_topbar_return_white);
        this.gsx.c(0.0f, false);
        this.gsB.setAlpha(1.0f);
        this.gsC.setAlpha(0.0f);
    }

    public void boG() {
        this.gsJ = false;
        if (this.cDd == 0) {
            if (com.baidu.adp.lib.util.j.kX()) {
                this.gsz.resetData();
                this.gsz.refreshData();
                this.gov.oE();
                return;
            }
            this.gov.aFG();
        } else if (this.cDd == 1) {
            if (com.baidu.adp.lib.util.j.kX()) {
                this.gsz.g(true, true, true);
                this.gov.oE();
                return;
            }
            this.gov.aFG();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.grL = gVar;
        this.gsx.setOnViewResponseListener(gVar);
        this.cTJ.setOnClickListener(this.aOJ);
        this.gsy.setOnViewResponseListener(gVar);
        if (this.gov != null) {
            this.gov.a(this.gsK, gVar);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.gsH != null) {
            this.gsH.O(onClickListener);
        }
    }

    public void lS(boolean z) {
        this.gsM = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.cTJ, e.f.selector_topbar_return_black);
        } else {
            al.c(this.cTJ, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cTJ.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gsF.setAlpha(1.0f - f);
            this.gsG.setAlpha(f);
        }
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dr(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        ma(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.goI = aVar;
            this.gsx.e(this.goI.getUserData());
            if (this.gsJ) {
                dr(aVar.aLu());
                if (this.bJY != null) {
                    this.bJY.DP();
                    return;
                }
                return;
            }
            this.gsx.box();
            this.gsy.e(aVar);
            this.gsC.setPortraitUrl(com.baidu.tbadk.core.util.o.fc(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gsC.bpo();
            } else {
                this.goI.getUserData().setIsLike(this.goI.getUserData().getHave_attention() == 1);
                this.gsD.a(this.goI.getUserData());
            }
            if ((aVar.bph() == null || this.mIsHost) && v.J(aVar.bpi())) {
                this.goh.removeHeaderView(this.gsO.amu());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gsO.a(aVar.bph(), this.mIsHost, this.goI.getUserData(), aVar.bpi());
            }
            if (!this.mIsHost) {
                if (aVar.bpj() == null || aVar.bpj().gpO == null || aVar.bpj().gpO.size() <= 0) {
                    this.goh.removeHeaderView(this.gsL);
                } else {
                    this.gsL.a(aVar.bpj());
                }
            }
            if (v.J(aVar.aLu())) {
                dr(null);
                this.gov.ZL();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.buu().mC(this.mIsHost);
            dr(aVar.aLu());
            int size = aVar.aLu().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aLu().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gov.ZL();
                    return;
                }
            }
            if (z) {
                if (this.bJY != null) {
                    this.bJY.DP();
                    return;
                }
                return;
            }
            this.gov.c(true, aVar.aLu());
        }
    }

    public void aFG() {
        this.gov.aFG();
    }

    private void w(TbPageContext tbPageContext) {
        this.gsI = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gLo;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gsy != null && p.this.gsy.grT != null) {
                            p.this.gsy.grT.nW(aVar.fjY);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.goI != null) {
                            if (p.this.goI.gpE != null && p.this.goI.gpE.djh != null && aVar2 != null) {
                                p.this.goI.gpE.djh.putBoolean("person_center_item_red_tip_show", aVar2.fjY);
                            }
                            if (aVar3 != null && p.this.goI.gpD != null && p.this.goI.gpD.djh != null) {
                                p.this.goI.gpD.djh.putBoolean("person_center_item_red_tip_show", aVar3.fjY);
                            }
                            if (aVar4 != null && p.this.goI.gpB != null && p.this.goI.gpB.djh != null) {
                                p.this.goI.gpB.djh.putBoolean("person_center_item_red_tip_show", aVar4.fjY);
                            }
                            if (aVar5 != null && p.this.goI.gpF != null && p.this.goI.gpF.djh != null) {
                                p.this.goI.gpF.djh.putBoolean("person_center_item_red_tip_show", aVar5.fjY);
                            }
                            if (aVar6 != null && p.this.goI.gpG != null && p.this.goI.gpG.djh != null) {
                                p.this.goI.gpG.djh.putBoolean("person_center_item_red_tip_show", aVar6.fjY);
                                p.this.goI.gpG.djh.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gsx instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gsx.C(5, aVar7.fjY);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gsx.C(6, aVar8.fjY);
                            }
                        }
                    }
                }
            }
        };
        this.gsI.setTag(this.axF);
        tbPageContext.registerListener(this.gsI);
        this.gji = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gsy.tj(jVar.xf());
                }
            }
        };
        this.gji.setTag(this.axF);
        tbPageContext.registerListener(this.gji);
    }

    public void onDestory() {
        if (this.gsy != null) {
            this.gsy.onDestory();
        }
    }

    public com.baidu.tieba.view.f bpt() {
        return this.gsx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bt(boolean z) {
            if (z) {
                if (p.this.dAG == null) {
                    p.this.dAG = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gsD.El() != null && !StringUtils.isNull(p.this.gsD.El().getUserId())) {
                    p.this.dAG.hH(p.this.gsD.El().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).AC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpu() {
        amk();
        aml();
        bpv();
        if (this.gsy.amu().getTop() + this.gsE <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gsz = aVar;
    }

    private void amk() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsy != null) {
            int top = this.gsy.amu().getTop();
            if (top >= this.gsw) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gsw) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gsw));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aml() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cBa) {
                    this.cBa = true;
                }
            } else if (this.cBa) {
                this.cBa = false;
            }
            a(alpha, !this.cBa);
            this.gsx.c(alpha, this.cBa ? false : true);
        }
    }

    private void bpv() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsy != null) {
            int i = this.gsw / 2;
            int i2 = this.gsw - i;
            int top = this.gsy.amu().getTop();
            if (this.gsB != null) {
                if (top < i) {
                    if (this.gsB.getAlpha() != 0.0f) {
                        this.gsB.setAlpha(0.0f);
                    }
                } else if (top < this.gsw && top >= i) {
                    if (i2 > 0) {
                        this.gsB.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gsw && this.gsB.getAlpha() != 1.0f) {
                    this.gsB.setAlpha(1.0f);
                }
            }
            if (this.gsC != null) {
                if (top >= i) {
                    if (this.gsC.getAlpha() != 0.0f) {
                        this.gsC.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gsC.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gsC.getAlpha() != 1.0f) {
                    this.gsC.setAlpha(1.0f);
                }
            }
        }
    }

    public void dr(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.J(list)) {
            list = new ArrayList<>();
        }
        if (this.goh.getVisibility() != 0) {
            this.goh.setVisibility(0);
        }
        this.goh.setData(list);
        int I = v.I(list);
        if (I >= 5) {
            if (this.gsM) {
                ma(true);
                this.gsM = false;
            }
        } else if (I <= 1) {
            this.goh.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gsA = iVar;
    }

    public NavigationBar aaE() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.goh != null) {
            this.gsP = str;
            this.gsS = aVar;
            int headerViewsCount = (this.goh.getHeaderViewsCount() + i) - this.goh.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gsQ = this.goh.getChildAt(headerViewsCount);
                if (this.gsQ != null) {
                    this.gsR = this.gsQ.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gsQ.getLayoutParams().height = p.this.gsR - ((int) (p.this.gsR * f));
                            p.this.gsQ.requestLayout();
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
                            p.this.gsQ.setVisibility(8);
                            if (p.this.gsS != null) {
                                p.this.gsS.tf(p.this.gsP);
                            }
                        }
                    });
                    animation.setDuration(gsv);
                    this.gsQ.startAnimation(animation);
                }
            }
        }
    }
}
