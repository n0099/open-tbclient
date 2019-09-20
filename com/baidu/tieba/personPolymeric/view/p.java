package com.baidu.tieba.personPolymeric.view;

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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p {
    public static int iwD = 300;
    private BdUniqueId XD;
    private NoNetworkView dpy;
    private PbListView dpz;
    private ImageView eLg;
    private PluginErrorTipView eYM;
    private int ewI;
    private com.baidu.tbadk.k.a fwB;
    private CustomMessageListener imP;
    private boolean imw;
    private com.baidu.tieba.personPolymeric.b.d isD;
    private com.baidu.tieba.personPolymeric.c.a isQ;
    public BdPersonListView isp;
    private com.baidu.tieba.view.g ivT;
    private com.baidu.tieba.view.f iwE;
    public n iwF;
    private com.baidu.tieba.model.a iwG;
    private com.baidu.tieba.view.i iwH;
    private TextView iwI;
    private LikeButtonWithHeadPortrait iwJ;
    private com.baidu.tbadk.core.view.userLike.c iwK;
    private int iwL;
    private TextView iwM;
    private TextView iwN;
    private com.baidu.tieba.personPolymeric.a.n iwO;
    private CustomMessageListener iwP;
    private View iwR;
    private PersonCenterAttentionBarListView iwS;
    private boolean iwT;
    private k iwV;
    private String iwW;
    private View iwX;
    private int iwY;
    private i.a iwZ;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean elH = true;
    private int enR = 0;
    private boolean iwQ = false;
    private boolean iwU = false;
    View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b isz = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.ivT != null) {
                if (p.this.eLg == view) {
                    this.isz.feK = 8;
                }
                p.this.ivT.a(view, this.isz);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.iwH != null) {
                p.this.iwH.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.iwH != null) {
                    p.this.iwH.onScroll(absListView, i, i2, i3);
                }
                p.this.cew();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dpz != null && p.this.iwG != null) {
                p.this.isD.yU(p.this.enR);
                if (p.this.enR == 0) {
                    p.this.dpz.akR();
                    p.this.iwG.g(false, false, false);
                } else if (p.this.enR == 1) {
                    p.this.dpz.akR();
                    p.this.iwG.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a ixa = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.cdH();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nY() {
            p.this.isD.bsJ();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.isD.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.imw = false;
        this.mContext = tbPageContext;
        this.XD = bdUniqueId;
        this.mIsHost = z;
        this.imw = z2;
        this.isD = eVar.cdR();
        this.dpz = this.isD.dpz;
        this.ewI = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.iwE = new com.baidu.tieba.view.d(2);
            x(tbPageContext);
            return;
        }
        this.iwE = new com.baidu.tieba.personPolymeric.a();
    }

    public void Q(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dpy = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eYM = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.isp = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.iwE.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.isp.setOnScrollListener(this.mOnScrollListener);
        this.iwL = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eLg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eLg.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eLg.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eLg.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.iwI = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.iwJ = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.iwK = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.iwJ);
        this.iwK.setFromType("2");
        this.iwK.j(this.mContext.getUniqueId());
        this.iwK.a(new a());
        this.iwM = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.iwN = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.imw) {
            this.eLg.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.isp.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.iwF = new n(this.mContext, this.mIsHost);
        this.iwR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.isp.addHeaderView(this.iwR);
        this.isp.setExpandView(this.iwR);
        this.isp.addHeaderView(this.iwF.aXx());
        this.iwV = new k(this.mContext);
        this.isp.addHeaderView(this.iwV.aXx());
        if (!this.mIsHost) {
            this.iwI.setText(R.string.ta_homepage);
            this.iwS = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.isp.addHeaderView(this.iwS);
        } else {
            this.iwI.setText(R.string.my_homepage);
        }
        this.isp.setPersonListRefreshListener(this.ixa);
        this.iwO = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.isp, this.XD);
        this.iwO.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.iwJ.setAlpha(0.0f);
        this.iwE.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.isQ == null) {
            this.iwE.c(1.0f, true);
            SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            cew();
        }
        am.j(this.iwI, R.color.cp_cont_a);
        this.iwJ.onChangeSkinType(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        if (this.iwE != null) {
            this.iwE.onChangeSkinType(i);
        }
        this.dpy.onChangeSkinType(this.mContext, i);
        this.eYM.onChangeSkinType(this.mContext, i);
        if (this.iwF != null) {
            this.iwF.onChangeSkinType(i);
        }
        if (this.isp != null && (this.isp.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.isp.getAdapter().notifyDataSetChanged();
        }
        this.dpz.iY(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            am.e(this.iwN, R.color.cp_cont_b, R.color.s_navbar_title_color);
            am.e(this.iwM, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        if (this.iwS != null) {
            this.iwS.onChangeSkinType(i);
        }
        if (this.iwV != null) {
            this.iwV.onChangeSkinType(i);
        }
    }

    public void pW(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iwE.c(1.0f, true);
            this.iwI.setAlpha(0.0f);
            this.iwJ.setAlpha(1.0f);
            this.isp.setSelectionFromTop(this.isp.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iwE.c(0.0f, false);
        this.iwI.setAlpha(1.0f);
        this.iwJ.setAlpha(0.0f);
    }

    public void Do(String str) {
        if (this.iwF != null) {
            this.iwF.Db(str);
        }
    }

    public void Dp(String str) {
        if (this.iwF != null) {
            this.iwF.Dc(str);
        }
    }

    public void cdH() {
        this.iwQ = false;
        if (this.enR == 0) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.iwG.resetData();
                this.iwG.refreshData();
                this.isD.nX();
                return;
            }
            this.isD.bsJ();
        } else if (this.enR == 1) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.iwG.g(true, true, true);
                this.isD.nX();
                return;
            }
            this.isD.bsJ();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.ivT = gVar;
        this.iwE.setOnViewResponseListener(gVar);
        this.eLg.setOnClickListener(this.cmX);
        this.iwF.setOnViewResponseListener(gVar);
        if (this.isD != null) {
            this.isD.a(this.iwR, gVar);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.iwO != null) {
            this.iwO.V(onClickListener);
        }
    }

    public void pO(boolean z) {
        this.iwT = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.ajv().a(this.eLg, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eLg.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.iwM.setAlpha(1.0f - f);
            this.iwN.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dR(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pW(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.isQ = aVar;
            this.iwE.setUserData(this.isQ.getUserData());
            if (this.iwQ) {
                dR(aVar.bzL());
                if (this.dpz != null) {
                    this.dpz.akS();
                    return;
                }
                return;
            }
            this.iwE.cdE();
            this.iwF.e(aVar);
            if (aVar != null) {
                this.iwJ.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.iwJ.ceq();
            } else {
                this.isQ.getUserData().setIsLike(this.isQ.getUserData().getHave_attention() == 1);
                this.iwK.a(this.isQ.getUserData());
            }
            if ((aVar.cej() == null || this.mIsHost) && v.aa(aVar.cek())) {
                this.isp.removeHeaderView(this.iwV.aXx());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.iwV.a(aVar.cej(), this.mIsHost, this.isQ.getUserData(), aVar.cek());
            }
            if (!this.mIsHost) {
                if (aVar.cel() == null || aVar.cel().itW == null || aVar.cel().itW.size() <= 0) {
                    this.isp.removeHeaderView(this.iwS);
                } else {
                    this.iwS.a(aVar.cel());
                }
            }
            if (v.aa(aVar.bzL())) {
                dR(null);
                this.isD.aKQ();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cjV().qC(this.mIsHost);
            dR(aVar.bzL());
            int size = aVar.bzL().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bzL().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.isD.aKQ();
                    return;
                }
            }
            if (z) {
                if (this.dpz != null) {
                    this.dpz.akS();
                    return;
                }
                return;
            }
            this.isD.b(true, aVar.bzL());
        }
    }

    public void bsJ() {
        this.isD.bsJ();
    }

    private void x(TbPageContext tbPageContext) {
        this.iwP = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iRK;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.iwF != null && p.this.iwF.iwb != null) {
                            p.this.iwF.iwb.rX(aVar.hmj);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.isQ != null) {
                            if (p.this.isQ.itM != null && p.this.isQ.itM.azD != null && aVar2 != null) {
                                p.this.isQ.itM.azD.putBoolean("person_center_item_red_tip_show", aVar2.hmj);
                            }
                            if (aVar3 != null && p.this.isQ.itL != null && p.this.isQ.itL.azD != null) {
                                p.this.isQ.itL.azD.putBoolean("person_center_item_red_tip_show", aVar3.hmj);
                            }
                            if (aVar4 != null && p.this.isQ.itJ != null && p.this.isQ.itJ.azD != null) {
                                p.this.isQ.itJ.azD.putBoolean("person_center_item_red_tip_show", aVar4.hmj);
                            }
                            if (aVar5 != null && p.this.isQ.itN != null && p.this.isQ.itN.azD != null) {
                                p.this.isQ.itN.azD.putBoolean("person_center_item_red_tip_show", aVar5.hmj);
                            }
                            if (aVar6 != null && p.this.isQ.itO != null && p.this.isQ.itO.azD != null) {
                                p.this.isQ.itO.azD.putBoolean("person_center_item_red_tip_show", aVar6.hmj);
                                p.this.isQ.itO.azD.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.iwE instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.iwE.Q(5, aVar7.hmj);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.iwE.Q(6, aVar8.hmj);
                            }
                        }
                    }
                }
            }
        };
        this.iwP.setTag(this.XD);
        tbPageContext.registerListener(this.iwP);
        this.imP = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.iwF.Dt(lVar.acZ());
                }
            }
        };
        this.imP.setTag(this.XD);
        tbPageContext.registerListener(this.imP);
    }

    public void onDestory() {
        if (this.iwF != null) {
            this.iwF.onDestory();
        }
    }

    public com.baidu.tieba.view.f cev() {
        return this.iwE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void ez(boolean z) {
            if (z) {
                if (p.this.fwB == null) {
                    p.this.fwB = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.iwK.alw() != null && !StringUtils.isNull(p.this.iwK.alw().getUserId())) {
                    p.this.fwB.qL(p.this.iwK.alw().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).agW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cew() {
        aXk();
        aXl();
        cex();
        if (this.iwF.aXx().getTop() + this.iwL <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.iwG = aVar;
    }

    private void aXk() {
        if (Build.VERSION.SDK_INT >= 11 && this.iwF != null) {
            int top = this.iwF.aXx().getTop();
            if (top >= this.ewI) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.ewI) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.ewI));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aXl() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.elH) {
                    this.elH = true;
                }
            } else if (this.elH) {
                this.elH = false;
            }
            a(alpha, !this.elH);
            this.iwE.c(alpha, this.elH ? false : true);
        }
    }

    private void cex() {
        if (Build.VERSION.SDK_INT >= 11 && this.iwF != null) {
            int i = this.ewI / 2;
            int i2 = this.ewI - i;
            int top = this.iwF.aXx().getTop();
            if (this.iwI != null) {
                if (top < i) {
                    if (this.iwI.getAlpha() != 0.0f) {
                        this.iwI.setAlpha(0.0f);
                    }
                } else if (top < this.ewI && top >= i) {
                    if (i2 > 0) {
                        this.iwI.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.ewI && this.iwI.getAlpha() != 1.0f) {
                    this.iwI.setAlpha(1.0f);
                }
            }
            if (this.iwJ != null) {
                if (top >= i) {
                    if (this.iwJ.getAlpha() != 0.0f) {
                        this.iwJ.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.iwJ.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.iwJ.getAlpha() != 1.0f) {
                    this.iwJ.setAlpha(1.0f);
                }
            }
        }
    }

    public void dR(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.isp.getVisibility() != 0) {
            this.isp.setVisibility(0);
        }
        this.isp.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.iwT) {
                pW(true);
                this.iwT = false;
            }
        } else if (Z <= 1) {
            this.isp.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.iwH = iVar;
    }

    public NavigationBar aLN() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!aq.isEmpty(str) && this.isp != null) {
            this.iwW = str;
            this.iwZ = aVar;
            int headerViewsCount = (this.isp.getHeaderViewsCount() + i) - this.isp.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.iwX = this.isp.getChildAt(headerViewsCount);
                if (this.iwX != null) {
                    this.iwY = this.iwX.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.iwX.getLayoutParams().height = p.this.iwY - ((int) (p.this.iwY * f));
                            p.this.iwX.requestLayout();
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
                            p.this.iwX.setVisibility(8);
                            if (p.this.iwZ != null) {
                                p.this.iwZ.removeThread(p.this.iwW);
                            }
                        }
                    });
                    animation.setDuration(iwD);
                    this.iwX.startAnimation(animation);
                }
            }
        }
    }
}
