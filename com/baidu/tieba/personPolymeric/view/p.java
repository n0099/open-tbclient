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
    public static int gsu = 300;
    private BdUniqueId axF;
    private NoNetworkView bJX;
    private PbListView bJY;
    private ImageView cTJ;
    private com.baidu.tbadk.i.a dAG;
    private PluginErrorTipView dgD;
    private boolean giS;
    private CustomMessageListener gjh;
    private com.baidu.tieba.personPolymeric.c.a goH;
    public BdPersonListView gog;
    private com.baidu.tieba.personPolymeric.b.d gou;
    private com.baidu.tieba.view.g grK;
    private TextView gsA;
    private LikeButtonWithHeadPortrait gsB;
    private com.baidu.tbadk.core.view.userLike.c gsC;
    private int gsD;
    private TextView gsE;
    private TextView gsF;
    private com.baidu.tieba.personPolymeric.a.n gsG;
    private CustomMessageListener gsH;
    private View gsJ;
    private PersonCenterAttentionBarListView gsK;
    private boolean gsL;
    private k gsN;
    private String gsO;
    private View gsP;
    private int gsQ;
    private i.a gsR;
    private int gsv;
    private com.baidu.tieba.view.f gsw;
    public n gsx;
    private com.baidu.tieba.model.a gsy;
    private com.baidu.tieba.view.i gsz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cBa = true;
    private int cDd = 0;
    private boolean gsI = false;
    private boolean gsM = false;
    View.OnClickListener aOJ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b goq = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.grK != null) {
                if (p.this.cTJ == view) {
                    this.goq.djg = 8;
                }
                p.this.grK.a(view, this.goq);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gsz != null) {
                p.this.gsz.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gsz != null) {
                    p.this.gsz.onScroll(absListView, i, i2, i3);
                }
                p.this.bpu();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bJY != null && p.this.gsy != null) {
                p.this.gou.st(p.this.cDd);
                if (p.this.cDd == 0) {
                    p.this.bJY.DO();
                    p.this.gsy.g(false, false, false);
                } else if (p.this.cDd == 1) {
                    p.this.bJY.DO();
                    p.this.gsy.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gsS = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.boG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oF() {
            p.this.gou.aFG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gou.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.giS = false;
        this.mContext = tbPageContext;
        this.axF = bdUniqueId;
        this.mIsHost = z;
        this.giS = z2;
        this.gou = eVar.boP();
        this.bJY = this.gou.bJY;
        this.gsv = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0175e.tbds402);
        if (z) {
            this.gsw = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gsw = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.dgD = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gog = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gsw.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gog.setOnScrollListener(this.mOnScrollListener);
        this.gsD = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds70);
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
        this.gsA = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gsB = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gsC = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gsB);
        this.gsC.setFromType("2");
        this.gsC.h(this.mContext.getUniqueId());
        this.gsC.a(new a());
        this.gsE = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gsF = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.giS) {
            this.cTJ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gog.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gsx = new n(this.mContext, this.mIsHost);
        this.gsJ = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gog.addHeaderView(this.gsJ);
        this.gog.setExpandView(this.gsJ);
        this.gog.addHeaderView(this.gsx.amt());
        this.gsN = new k(this.mContext);
        this.gog.addHeaderView(this.gsN.amt());
        if (!this.mIsHost) {
            this.gsA.setText(e.j.ta_homepage);
            this.gsK = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gog.addHeaderView(this.gsK);
        } else {
            this.gsA.setText(e.j.my_homepage);
        }
        this.gog.setPersonListRefreshListener(this.gsS);
        this.gsG = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gog, this.axF);
        this.gsG.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gsB.setAlpha(0.0f);
        this.gsw.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.goH == null) {
            this.gsw.c(1.0f, true);
            al.c(this.cTJ, e.f.selector_topbar_return_black);
        } else {
            bpu();
        }
        al.h(this.gsA, e.d.cp_cont_i);
        this.gsB.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)));
        if (this.gsw != null) {
            this.gsw.onChangeSkinType(i);
        }
        this.bJX.onChangeSkinType(this.mContext, i);
        this.dgD.onChangeSkinType(this.mContext, i);
        if (this.gsx != null) {
            this.gsx.onChangeSkinType(i);
        }
        if (this.gog != null && (this.gog.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gog.getAdapter().notifyDataSetChanged();
        }
        this.bJY.dW(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gsF, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gsE, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gsK != null) {
            this.gsK.onChangeSkinType(i);
        }
        if (this.gsN != null) {
            this.gsN.onChangeSkinType(i);
        }
    }

    public void ma(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.cTJ, e.f.selector_topbar_return_black);
            this.gsw.c(1.0f, true);
            this.gsA.setAlpha(0.0f);
            this.gsB.setAlpha(1.0f);
            this.gog.setSelectionFromTop(this.gog.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.cTJ, e.f.selector_topbar_return_white);
        this.gsw.c(0.0f, false);
        this.gsA.setAlpha(1.0f);
        this.gsB.setAlpha(0.0f);
    }

    public void boG() {
        this.gsI = false;
        if (this.cDd == 0) {
            if (com.baidu.adp.lib.util.j.kX()) {
                this.gsy.resetData();
                this.gsy.refreshData();
                this.gou.oE();
                return;
            }
            this.gou.aFG();
        } else if (this.cDd == 1) {
            if (com.baidu.adp.lib.util.j.kX()) {
                this.gsy.g(true, true, true);
                this.gou.oE();
                return;
            }
            this.gou.aFG();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.grK = gVar;
        this.gsw.setOnViewResponseListener(gVar);
        this.cTJ.setOnClickListener(this.aOJ);
        this.gsx.setOnViewResponseListener(gVar);
        if (this.gou != null) {
            this.gou.a(this.gsJ, gVar);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.gsG != null) {
            this.gsG.O(onClickListener);
        }
    }

    public void lS(boolean z) {
        this.gsL = z;
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
            this.gsE.setAlpha(1.0f - f);
            this.gsF.setAlpha(f);
        }
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dr(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        ma(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.goH = aVar;
            this.gsw.e(this.goH.getUserData());
            if (this.gsI) {
                dr(aVar.aLu());
                if (this.bJY != null) {
                    this.bJY.DP();
                    return;
                }
                return;
            }
            this.gsw.box();
            this.gsx.e(aVar);
            this.gsB.setPortraitUrl(com.baidu.tbadk.core.util.o.fc(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gsB.bpo();
            } else {
                this.goH.getUserData().setIsLike(this.goH.getUserData().getHave_attention() == 1);
                this.gsC.a(this.goH.getUserData());
            }
            if ((aVar.bph() == null || this.mIsHost) && v.J(aVar.bpi())) {
                this.gog.removeHeaderView(this.gsN.amt());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gsN.a(aVar.bph(), this.mIsHost, this.goH.getUserData(), aVar.bpi());
            }
            if (!this.mIsHost) {
                if (aVar.bpj() == null || aVar.bpj().gpN == null || aVar.bpj().gpN.size() <= 0) {
                    this.gog.removeHeaderView(this.gsK);
                } else {
                    this.gsK.a(aVar.bpj());
                }
            }
            if (v.J(aVar.aLu())) {
                dr(null);
                this.gou.ZK();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.buu().mC(this.mIsHost);
            dr(aVar.aLu());
            int size = aVar.aLu().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aLu().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gou.ZK();
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
            this.gou.c(true, aVar.aLu());
        }
    }

    public void aFG() {
        this.gou.aFG();
    }

    private void w(TbPageContext tbPageContext) {
        this.gsH = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gLn;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gsx != null && p.this.gsx.grS != null) {
                            p.this.gsx.grS.nW(aVar.fjX);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.goH != null) {
                            if (p.this.goH.gpD != null && p.this.goH.gpD.djh != null && aVar2 != null) {
                                p.this.goH.gpD.djh.putBoolean("person_center_item_red_tip_show", aVar2.fjX);
                            }
                            if (aVar3 != null && p.this.goH.gpC != null && p.this.goH.gpC.djh != null) {
                                p.this.goH.gpC.djh.putBoolean("person_center_item_red_tip_show", aVar3.fjX);
                            }
                            if (aVar4 != null && p.this.goH.gpA != null && p.this.goH.gpA.djh != null) {
                                p.this.goH.gpA.djh.putBoolean("person_center_item_red_tip_show", aVar4.fjX);
                            }
                            if (aVar5 != null && p.this.goH.gpE != null && p.this.goH.gpE.djh != null) {
                                p.this.goH.gpE.djh.putBoolean("person_center_item_red_tip_show", aVar5.fjX);
                            }
                            if (aVar6 != null && p.this.goH.gpF != null && p.this.goH.gpF.djh != null) {
                                p.this.goH.gpF.djh.putBoolean("person_center_item_red_tip_show", aVar6.fjX);
                                p.this.goH.gpF.djh.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gsw instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gsw.C(5, aVar7.fjX);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gsw.C(6, aVar8.fjX);
                            }
                        }
                    }
                }
            }
        };
        this.gsH.setTag(this.axF);
        tbPageContext.registerListener(this.gsH);
        this.gjh = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gsx.tj(jVar.xf());
                }
            }
        };
        this.gjh.setTag(this.axF);
        tbPageContext.registerListener(this.gjh);
    }

    public void onDestory() {
        if (this.gsx != null) {
            this.gsx.onDestory();
        }
    }

    public com.baidu.tieba.view.f bpt() {
        return this.gsw;
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
                if (p.this.gsC.El() != null && !StringUtils.isNull(p.this.gsC.El().getUserId())) {
                    p.this.dAG.hH(p.this.gsC.El().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).AC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpu() {
        amj();
        amk();
        bpv();
        if (this.gsx.amt().getTop() + this.gsD <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gsy = aVar;
    }

    private void amj() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsx != null) {
            int top = this.gsx.amt().getTop();
            if (top >= this.gsv) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gsv) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gsv));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void amk() {
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
            this.gsw.c(alpha, this.cBa ? false : true);
        }
    }

    private void bpv() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsx != null) {
            int i = this.gsv / 2;
            int i2 = this.gsv - i;
            int top = this.gsx.amt().getTop();
            if (this.gsA != null) {
                if (top < i) {
                    if (this.gsA.getAlpha() != 0.0f) {
                        this.gsA.setAlpha(0.0f);
                    }
                } else if (top < this.gsv && top >= i) {
                    if (i2 > 0) {
                        this.gsA.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gsv && this.gsA.getAlpha() != 1.0f) {
                    this.gsA.setAlpha(1.0f);
                }
            }
            if (this.gsB != null) {
                if (top >= i) {
                    if (this.gsB.getAlpha() != 0.0f) {
                        this.gsB.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gsB.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gsB.getAlpha() != 1.0f) {
                    this.gsB.setAlpha(1.0f);
                }
            }
        }
    }

    public void dr(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.J(list)) {
            list = new ArrayList<>();
        }
        if (this.gog.getVisibility() != 0) {
            this.gog.setVisibility(0);
        }
        this.gog.setData(list);
        int I = v.I(list);
        if (I >= 5) {
            if (this.gsL) {
                ma(true);
                this.gsL = false;
            }
        } else if (I <= 1) {
            this.gog.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gsz = iVar;
    }

    public NavigationBar aaD() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gog != null) {
            this.gsO = str;
            this.gsR = aVar;
            int headerViewsCount = (this.gog.getHeaderViewsCount() + i) - this.gog.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gsP = this.gog.getChildAt(headerViewsCount);
                if (this.gsP != null) {
                    this.gsQ = this.gsP.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gsP.getLayoutParams().height = p.this.gsQ - ((int) (p.this.gsQ * f));
                            p.this.gsP.requestLayout();
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
                            p.this.gsP.setVisibility(8);
                            if (p.this.gsR != null) {
                                p.this.gsR.tf(p.this.gsO);
                            }
                        }
                    });
                    animation.setDuration(gsu);
                    this.gsP.startAnimation(animation);
                }
            }
        }
    }
}
