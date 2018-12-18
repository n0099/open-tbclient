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
    public static int gAL = 300;
    private BdUniqueId aBS;
    private NoNetworkView bOx;
    private PbListView bOy;
    private com.baidu.tbadk.i.a dIw;
    private ImageView dby;
    private PluginErrorTipView doq;
    private int gAM;
    private com.baidu.tieba.view.f gAN;
    public n gAO;
    private com.baidu.tieba.model.a gAP;
    private com.baidu.tieba.view.i gAQ;
    private TextView gAR;
    private LikeButtonWithHeadPortrait gAS;
    private com.baidu.tbadk.core.view.userLike.c gAT;
    private int gAU;
    private TextView gAV;
    private TextView gAW;
    private com.baidu.tieba.personPolymeric.a.n gAX;
    private CustomMessageListener gAY;
    private com.baidu.tieba.view.g gAb;
    private View gBa;
    private PersonCenterAttentionBarListView gBb;
    private boolean gBc;
    private k gBe;
    private String gBf;
    private View gBg;
    private int gBh;
    private i.a gBi;
    private boolean grf;
    private CustomMessageListener grx;
    private com.baidu.tieba.personPolymeric.b.d gwK;
    private com.baidu.tieba.personPolymeric.c.a gwX;
    public BdPersonListView gww;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cGf = true;
    private int cIk = 0;
    private boolean gAZ = false;
    private boolean gBd = false;
    View.OnClickListener aSY = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gwG = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gAb != null) {
                if (p.this.dby == view) {
                    this.gwG.dqN = 8;
                }
                p.this.gAb.a(view, this.gwG);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gAQ != null) {
                p.this.gAQ.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gAQ != null) {
                    p.this.gAQ.onScroll(absListView, i, i2, i3);
                }
                p.this.bqH();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bOy != null && p.this.gAP != null) {
                p.this.gwK.tg(p.this.cIk);
                if (p.this.cIk == 0) {
                    p.this.bOy.Fc();
                    p.this.gAP.g(false, false, false);
                } else if (p.this.cIk == 1) {
                    p.this.bOy.Fc();
                    p.this.gAP.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gBj = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bpT();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oC() {
            p.this.gwK.aGO();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gwK.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.grf = false;
        this.mContext = tbPageContext;
        this.aBS = bdUniqueId;
        this.mIsHost = z;
        this.grf = z2;
        this.gwK = eVar.bqc();
        this.bOy = this.gwK.bOy;
        this.gAM = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds402);
        if (z) {
            this.gAN = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gAN = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bOx = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.doq = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gww = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gAN.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gww.setOnScrollListener(this.mOnScrollListener);
        this.gAU = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.dby = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.dby.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dby.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.dby.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gAR = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gAS = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gAT = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gAS);
        this.gAT.setFromType("2");
        this.gAT.h(this.mContext.getUniqueId());
        this.gAT.a(new a());
        this.gAV = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gAW = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.grf) {
            this.dby.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gww.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gAO = new n(this.mContext, this.mIsHost);
        this.gBa = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gww.addHeaderView(this.gBa);
        this.gww.setExpandView(this.gBa);
        this.gww.addHeaderView(this.gAO.ana());
        this.gBe = new k(this.mContext);
        this.gww.addHeaderView(this.gBe.ana());
        if (!this.mIsHost) {
            this.gAR.setText(e.j.ta_homepage);
            this.gBb = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gww.addHeaderView(this.gBb);
        } else {
            this.gAR.setText(e.j.my_homepage);
        }
        this.gww.setPersonListRefreshListener(this.gBj);
        this.gAX = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gww, this.aBS);
        this.gAX.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gAS.setAlpha(0.0f);
        this.gAN.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gwX == null) {
            this.gAN.c(1.0f, true);
            al.c(this.dby, e.f.selector_topbar_return_black);
        } else {
            bqH();
        }
        al.h(this.gAR, e.d.cp_cont_i);
        this.gAS.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        if (this.gAN != null) {
            this.gAN.onChangeSkinType(i);
        }
        this.bOx.onChangeSkinType(this.mContext, i);
        this.doq.onChangeSkinType(this.mContext, i);
        if (this.gAO != null) {
            this.gAO.onChangeSkinType(i);
        }
        if (this.gww != null && (this.gww.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gww.getAdapter().notifyDataSetChanged();
        }
        this.bOy.ey(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gAW, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gAV, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gBb != null) {
            this.gBb.onChangeSkinType(i);
        }
        if (this.gBe != null) {
            this.gBe.onChangeSkinType(i);
        }
    }

    public void mo(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.dby, e.f.selector_topbar_return_black);
            this.gAN.c(1.0f, true);
            this.gAR.setAlpha(0.0f);
            this.gAS.setAlpha(1.0f);
            this.gww.setSelectionFromTop(this.gww.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.dby, e.f.selector_topbar_return_white);
        this.gAN.c(0.0f, false);
        this.gAR.setAlpha(1.0f);
        this.gAS.setAlpha(0.0f);
    }

    public void tK(String str) {
        if (this.gAO != null) {
            this.gAO.tz(str);
        }
    }

    public void tL(String str) {
        if (this.gAO != null) {
            this.gAO.tA(str);
        }
    }

    public void bpT() {
        this.gAZ = false;
        if (this.cIk == 0) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gAP.resetData();
                this.gAP.refreshData();
                this.gwK.oB();
                return;
            }
            this.gwK.aGO();
        } else if (this.cIk == 1) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gAP.g(true, true, true);
                this.gwK.oB();
                return;
            }
            this.gwK.aGO();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gAb = gVar;
        this.gAN.setOnViewResponseListener(gVar);
        this.dby.setOnClickListener(this.aSY);
        this.gAO.setOnViewResponseListener(gVar);
        if (this.gwK != null) {
            this.gwK.a(this.gBa, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gAX != null) {
            this.gAX.Q(onClickListener);
        }
    }

    public void mg(boolean z) {
        this.gBc = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.dby, e.f.selector_topbar_return_black);
        } else {
            al.c(this.dby, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.dby.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gAV.setAlpha(1.0f - f);
            this.gAW.setAlpha(f);
        }
    }

    public void as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dt(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        mo(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gwX = aVar;
            this.gAN.e(this.gwX.getUserData());
            if (this.gAZ) {
                dt(aVar.aMJ());
                if (this.bOy != null) {
                    this.bOy.Fd();
                    return;
                }
                return;
            }
            this.gAN.bpK();
            this.gAO.e(aVar);
            if (aVar != null) {
                this.gAS.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.gAS.bqB();
            } else {
                this.gwX.getUserData().setIsLike(this.gwX.getUserData().getHave_attention() == 1);
                this.gAT.a(this.gwX.getUserData());
            }
            if ((aVar.bqu() == null || this.mIsHost) && v.I(aVar.bqv())) {
                this.gww.removeHeaderView(this.gBe.ana());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gBe.a(aVar.bqu(), this.mIsHost, this.gwX.getUserData(), aVar.bqv());
            }
            if (!this.mIsHost) {
                if (aVar.bqw() == null || aVar.bqw().gyd == null || aVar.bqw().gyd.size() <= 0) {
                    this.gww.removeHeaderView(this.gBb);
                } else {
                    this.gBb.a(aVar.bqw());
                }
            }
            if (v.I(aVar.aMJ())) {
                dt(null);
                this.gwK.abb();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bvI().mQ(this.mIsHost);
            dt(aVar.aMJ());
            int size = aVar.aMJ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aMJ().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gwK.abb();
                    return;
                }
            }
            if (z) {
                if (this.bOy != null) {
                    this.bOy.Fd();
                    return;
                }
                return;
            }
            this.gwK.c(true, aVar.aMJ());
        }
    }

    public void aGO() {
        this.gwK.aGO();
    }

    private void w(TbPageContext tbPageContext) {
        this.gAY = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gTD;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gAO != null && p.this.gAO.gAj != null) {
                            p.this.gAO.gAj.om(aVar.fsj);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.gwX != null) {
                            if (p.this.gwX.gxT != null && p.this.gwX.gxT.dqO != null && aVar2 != null) {
                                p.this.gwX.gxT.dqO.putBoolean("person_center_item_red_tip_show", aVar2.fsj);
                            }
                            if (aVar3 != null && p.this.gwX.gxS != null && p.this.gwX.gxS.dqO != null) {
                                p.this.gwX.gxS.dqO.putBoolean("person_center_item_red_tip_show", aVar3.fsj);
                            }
                            if (aVar4 != null && p.this.gwX.gxQ != null && p.this.gwX.gxQ.dqO != null) {
                                p.this.gwX.gxQ.dqO.putBoolean("person_center_item_red_tip_show", aVar4.fsj);
                            }
                            if (aVar5 != null && p.this.gwX.gxU != null && p.this.gwX.gxU.dqO != null) {
                                p.this.gwX.gxU.dqO.putBoolean("person_center_item_red_tip_show", aVar5.fsj);
                            }
                            if (aVar6 != null && p.this.gwX.gxV != null && p.this.gwX.gxV.dqO != null) {
                                p.this.gwX.gxV.dqO.putBoolean("person_center_item_red_tip_show", aVar6.fsj);
                                p.this.gwX.gxV.dqO.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gAN instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gAN.C(5, aVar7.fsj);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gAN.C(6, aVar8.fsj);
                            }
                        }
                    }
                }
            }
        };
        this.gAY.setTag(this.aBS);
        tbPageContext.registerListener(this.gAY);
        this.grx = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gAO.tQ(jVar.ys());
                }
            }
        };
        this.grx.setTag(this.aBS);
        tbPageContext.registerListener(this.grx);
    }

    public void onDestory() {
        if (this.gAO != null) {
            this.gAO.onDestory();
        }
    }

    public com.baidu.tieba.view.f bqG() {
        return this.gAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bL(boolean z) {
            if (z) {
                if (p.this.dIw == null) {
                    p.this.dIw = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gAT.Fz() != null && !StringUtils.isNull(p.this.gAT.Fz().getUserId())) {
                    p.this.dIw.hZ(p.this.gAT.Fz().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).BN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqH() {
        amQ();
        amR();
        bqI();
        if (this.gAO.ana().getTop() + this.gAU <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gAP = aVar;
    }

    private void amQ() {
        if (Build.VERSION.SDK_INT >= 11 && this.gAO != null) {
            int top = this.gAO.ana().getTop();
            if (top >= this.gAM) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gAM) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gAM));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void amR() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cGf) {
                    this.cGf = true;
                }
            } else if (this.cGf) {
                this.cGf = false;
            }
            a(alpha, !this.cGf);
            this.gAN.c(alpha, this.cGf ? false : true);
        }
    }

    private void bqI() {
        if (Build.VERSION.SDK_INT >= 11 && this.gAO != null) {
            int i = this.gAM / 2;
            int i2 = this.gAM - i;
            int top = this.gAO.ana().getTop();
            if (this.gAR != null) {
                if (top < i) {
                    if (this.gAR.getAlpha() != 0.0f) {
                        this.gAR.setAlpha(0.0f);
                    }
                } else if (top < this.gAM && top >= i) {
                    if (i2 > 0) {
                        this.gAR.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gAM && this.gAR.getAlpha() != 1.0f) {
                    this.gAR.setAlpha(1.0f);
                }
            }
            if (this.gAS != null) {
                if (top >= i) {
                    if (this.gAS.getAlpha() != 0.0f) {
                        this.gAS.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gAS.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gAS.getAlpha() != 1.0f) {
                    this.gAS.setAlpha(1.0f);
                }
            }
        }
    }

    public void dt(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gww.getVisibility() != 0) {
            this.gww.setVisibility(0);
        }
        this.gww.setData(list);
        int H = v.H(list);
        if (H >= 5) {
            if (this.gBc) {
                mo(true);
                this.gBc = false;
            }
        } else if (H <= 1) {
            this.gww.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gAQ = iVar;
    }

    public NavigationBar abU() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gww != null) {
            this.gBf = str;
            this.gBi = aVar;
            int headerViewsCount = (this.gww.getHeaderViewsCount() + i) - this.gww.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gBg = this.gww.getChildAt(headerViewsCount);
                if (this.gBg != null) {
                    this.gBh = this.gBg.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gBg.getLayoutParams().height = p.this.gBh - ((int) (p.this.gBh * f));
                            p.this.gBg.requestLayout();
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
                            p.this.gBg.setVisibility(8);
                            if (p.this.gBi != null) {
                                p.this.gBi.tM(p.this.gBf);
                            }
                        }
                    });
                    animation.setDuration(gAL);
                    this.gBg.startAnimation(animation);
                }
            }
        }
    }
}
