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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    public static int iuo = 300;
    private BdUniqueId GX;
    private TbPageContext ceu;
    private NoNetworkView dvR;
    private PbListView dvS;
    private int eED;
    private ImageView eSV;
    private PluginErrorTipView faG;
    private com.baidu.tbadk.k.a fuX;
    private CustomMessageListener ikH;
    private boolean iko;
    public BdPersonListView ipY;
    private com.baidu.tieba.personPolymeric.b.d iqm;
    private com.baidu.tieba.personPolymeric.c.a iqz;
    private com.baidu.tieba.view.g itE;
    private CustomMessageListener iuA;
    private View iuC;
    private PersonCenterAttentionBarListView iuD;
    private boolean iuE;
    private k iuG;
    private String iuH;
    private View iuI;
    private int iuJ;
    private i.a iuK;
    private com.baidu.tieba.view.f iup;
    public n iuq;
    private com.baidu.tieba.model.a iur;
    private com.baidu.tieba.view.i ius;
    private TextView iut;
    private LikeButtonWithHeadPortrait iuu;
    private com.baidu.tbadk.core.view.userLike.c iuv;
    private int iuw;
    private TextView iux;
    private TextView iuy;
    private com.baidu.tieba.personPolymeric.a.n iuz;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean dQy = true;
    private int dRh = 0;
    private boolean iuB = false;
    private boolean iuF = false;
    View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b iqi = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.itE != null) {
                if (p.this.eSV == view) {
                    this.iqi.fgD = 8;
                }
                p.this.itE.a(view, this.iqi);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.ius != null) {
                p.this.ius.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.ius != null) {
                    p.this.ius.onScroll(absListView, i, i2, i3);
                }
                p.this.cbw();
            }
        }
    };
    private BdListView.e xE = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dvS != null && p.this.iur != null) {
                p.this.iqm.xy(p.this.dRh);
                if (p.this.dRh == 0) {
                    p.this.dvS.startLoadData();
                    p.this.iur.i(false, false, false);
                } else if (p.this.dRh == 1) {
                    p.this.dvS.startLoadData();
                    p.this.iur.i(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a iuL = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.caG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onNotExpanding() {
            p.this.iqm.bpL();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onExpandingDegree(float f) {
            p.this.iqm.controllTheStaticProgress(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.iko = false;
        this.ceu = tbPageContext;
        this.GX = bdUniqueId;
        this.mIsHost = z;
        this.iko = z2;
        this.iqm = eVar.caQ();
        this.dvS = this.iqm.dvS;
        this.eED = com.baidu.adp.lib.util.l.getDimens(this.ceu.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.iup = new com.baidu.tieba.view.d(2);
            x(tbPageContext);
            return;
        }
        this.iup = new com.baidu.tieba.personPolymeric.a();
    }

    public void W(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.faG = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.ipY = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.iup.a(this.ceu.getPageActivity(), this.mNavigationBar);
        this.ipY.setOnScrollListener(this.mOnScrollListener);
        this.iuw = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eSV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eSV.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eSV.getLayoutParams();
            layoutParams2.leftMargin = this.ceu.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eSV.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.iut = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.iuu = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.iuv = new com.baidu.tbadk.core.view.userLike.c(this.ceu, this.iuu);
        this.iuv.mX("2");
        this.iuv.j(this.ceu.getUniqueId());
        this.iuv.a(new a());
        this.iux = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.iuy = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.iko) {
            this.eSV.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.ipY.setOnSrollToBottomListener(this.xE);
        this.iuq = new n(this.ceu, this.mIsHost);
        this.iuC = LayoutInflater.from(this.ceu.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.ipY.addHeaderView(this.iuC);
        this.ipY.setExpandView(this.iuC);
        this.ipY.addHeaderView(this.iuq.aMv());
        this.iuG = new k(this.ceu);
        this.ipY.addHeaderView(this.iuG.aMv());
        if (!this.mIsHost) {
            this.iut.setText(R.string.ta_homepage);
            this.iuD = new PersonCenterAttentionBarListView(this.ceu.getPageActivity());
            this.ipY.addHeaderView(this.iuD);
        } else {
            this.iut.setText(R.string.my_homepage);
        }
        this.ipY.setPersonListRefreshListener(this.iuL);
        this.iuz = new com.baidu.tieba.personPolymeric.a.n(this.ceu, this.ipY, this.GX);
        this.iuz.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.iuu.setAlpha(0.0f);
        this.iup.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.iqz == null) {
            this.iup.c(1.0f, true);
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            cbw();
        }
        am.setViewTextColor(this.iut, (int) R.color.cp_cont_a);
        this.iuu.onChangeSkinType(i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        if (this.iup != null) {
            this.iup.onChangeSkinType(i);
        }
        this.dvR.onChangeSkinType(this.ceu, i);
        this.faG.onChangeSkinType(this.ceu, i);
        if (this.iuq != null) {
            this.iuq.onChangeSkinType(i);
        }
        if (this.ipY != null && (this.ipY.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ipY.getAdapter().notifyDataSetChanged();
        }
        this.dvS.changeSkin(i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            am.setNavbarTitleColor(this.iuy, R.color.cp_cont_b, R.color.s_navbar_title_color);
            am.setNavbarTitleColor(this.iux, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        if (this.iuD != null) {
            this.iuD.onChangeSkinType(i);
        }
        if (this.iuG != null) {
            this.iuG.onChangeSkinType(i);
        }
    }

    public void pE(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.iup.c(1.0f, true);
            this.iut.setAlpha(0.0f);
            this.iuu.setAlpha(1.0f);
            this.ipY.setSelectionFromTop(this.ipY.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.iup.c(0.0f, false);
        this.iut.setAlpha(1.0f);
        this.iuu.setAlpha(0.0f);
    }

    public void BH(String str) {
        if (this.iuq != null) {
            this.iuq.Bu(str);
        }
    }

    public void BI(String str) {
        if (this.iuq != null) {
            this.iuq.Bv(str);
        }
    }

    public void caG() {
        this.iuB = false;
        if (this.dRh == 0) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.iur.resetData();
                this.iur.refreshData();
                this.iqm.doRefresh();
                return;
            }
            this.iqm.bpL();
        } else if (this.dRh == 1) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.iur.i(true, true, true);
                this.iqm.doRefresh();
                return;
            }
            this.iqm.bpL();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.itE = gVar;
        this.iup.setOnViewResponseListener(gVar);
        this.eSV.setOnClickListener(this.cze);
        this.iuq.setOnViewResponseListener(gVar);
        if (this.iqm != null) {
            this.iqm.a(this.iuC, gVar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.iuz != null) {
            this.iuz.W(onClickListener);
        }
    }

    public void pw(boolean z) {
        this.iuE = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eSV.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.iux.setAlpha(1.0f - f);
            this.iuy.setAlpha(f);
        }
    }

    public void aE(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ee(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pE(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.iqz = aVar;
            this.iup.setUserData(this.iqz.getUserData());
            if (this.iuB) {
                ee(aVar.bwu());
                if (this.dvS != null) {
                    this.dvS.endLoadData();
                    return;
                }
                return;
            }
            this.iup.caD();
            this.iuq.e(aVar);
            if (aVar != null) {
                this.iuu.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.iuu.cbq();
            } else {
                this.iqz.getUserData().setIsLike(this.iqz.getUserData().getHave_attention() == 1);
                this.iuv.a(this.iqz.getUserData());
            }
            if ((aVar.cbj() == null || this.mIsHost) && v.isEmpty(aVar.cbk())) {
                this.ipY.removeHeaderView(this.iuG.aMv());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.iuG.a(aVar.cbj(), this.mIsHost, this.iqz.getUserData(), aVar.cbk());
            }
            if (!this.mIsHost) {
                if (aVar.cbl() == null || aVar.cbl().irF == null || aVar.cbl().irF.size() <= 0) {
                    this.ipY.removeHeaderView(this.iuD);
                } else {
                    this.iuD.a(aVar.cbl());
                }
            }
            if (v.isEmpty(aVar.bwu())) {
                ee(null);
                this.iqm.aKi();
                com.baidu.adp.lib.util.l.showToast(this.ceu.getContext(), this.ceu.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.chb().ql(this.mIsHost);
            ee(aVar.bwu());
            int size = aVar.bwu().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bwu().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.iqm.aKi();
                    return;
                }
            }
            if (z) {
                if (this.dvS != null) {
                    this.dvS.endLoadData();
                    return;
                }
                return;
            }
            this.iqm.e(true, aVar.bwu());
        }
    }

    public void bpL() {
        this.iqm.bpL();
    }

    private void x(TbPageContext tbPageContext) {
        this.iuA = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iPR;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.iuq != null && p.this.iuq.itM != null) {
                            p.this.iuq.itM.rG(aVar.hjx);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.iqz != null) {
                            if (p.this.iqz.irv != null && p.this.iqz.irv.aSz != null && aVar2 != null) {
                                p.this.iqz.irv.aSz.putBoolean("person_center_item_red_tip_show", aVar2.hjx);
                            }
                            if (aVar3 != null && p.this.iqz.iru != null && p.this.iqz.iru.aSz != null) {
                                p.this.iqz.iru.aSz.putBoolean("person_center_item_red_tip_show", aVar3.hjx);
                            }
                            if (aVar4 != null && p.this.iqz.irs != null && p.this.iqz.irs.aSz != null) {
                                p.this.iqz.irs.aSz.putBoolean("person_center_item_red_tip_show", aVar4.hjx);
                            }
                            if (aVar5 != null && p.this.iqz.irw != null && p.this.iqz.irw.aSz != null) {
                                p.this.iqz.irw.aSz.putBoolean("person_center_item_red_tip_show", aVar5.hjx);
                            }
                            if (aVar6 != null && p.this.iqz.irx != null && p.this.iqz.irx.aSz != null) {
                                p.this.iqz.irx.aSz.putBoolean("person_center_item_red_tip_show", aVar6.hjx);
                                p.this.iqz.irx.aSz.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.iup instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.iup.O(5, aVar7.hjx);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.iup.O(6, aVar8.hjx);
                            }
                        }
                    }
                }
            }
        };
        this.iuA.setTag(this.GX);
        tbPageContext.registerListener(this.iuA);
        this.ikH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.iuq.BM(lVar.ahd());
                }
            }
        };
        this.ikH.setTag(this.GX);
        tbPageContext.registerListener(this.ikH);
    }

    public void onDestory() {
        if (this.iuq != null) {
            this.iuq.onDestory();
        }
    }

    public com.baidu.tieba.view.f cbv() {
        return this.iup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void ex(boolean z) {
            if (z) {
                if (p.this.fuX == null) {
                    p.this.fuX = new com.baidu.tbadk.k.a(p.this.ceu);
                }
                if (p.this.iuv.aoi() != null && !StringUtils.isNull(p.this.iuv.aoi().getUserId())) {
                    p.this.fuX.pT(p.this.iuv.aoi().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.ceu.getPageActivity(), p.this.ceu.getString(R.string.unlike_success)).akR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbw() {
        aMt();
        aMu();
        cbx();
        if (this.iuq.aMv().getTop() + this.iuw <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.iur = aVar;
    }

    private void aMt() {
        if (Build.VERSION.SDK_INT >= 11 && this.iuq != null) {
            int top = this.iuq.aMv().getTop();
            if (top >= this.eED) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.eED) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.eED));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aMu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.dQy) {
                    this.dQy = true;
                }
            } else if (this.dQy) {
                this.dQy = false;
            }
            a(alpha, !this.dQy);
            this.iup.c(alpha, this.dQy ? false : true);
        }
    }

    private void cbx() {
        if (Build.VERSION.SDK_INT >= 11 && this.iuq != null) {
            int i = this.eED / 2;
            int i2 = this.eED - i;
            int top = this.iuq.aMv().getTop();
            if (this.iut != null) {
                if (top < i) {
                    if (this.iut.getAlpha() != 0.0f) {
                        this.iut.setAlpha(0.0f);
                    }
                } else if (top < this.eED && top >= i) {
                    if (i2 > 0) {
                        this.iut.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.eED && this.iut.getAlpha() != 1.0f) {
                    this.iut.setAlpha(1.0f);
                }
            }
            if (this.iuu != null) {
                if (top >= i) {
                    if (this.iuu.getAlpha() != 0.0f) {
                        this.iuu.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.iuu.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.iuu.getAlpha() != 1.0f) {
                    this.iuu.setAlpha(1.0f);
                }
            }
        }
    }

    public void ee(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.isEmpty(list)) {
            list = new ArrayList<>();
        }
        if (this.ipY.getVisibility() != 0) {
            this.ipY.setVisibility(0);
        }
        this.ipY.setData(list);
        int count = v.getCount(list);
        if (count >= 5) {
            if (this.iuE) {
                pE(true);
                this.iuE = false;
            }
        } else if (count <= 1) {
            this.ipY.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.ius = iVar;
    }

    public NavigationBar aKP() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!aq.isEmpty(str) && this.ipY != null) {
            this.iuH = str;
            this.iuK = aVar;
            int headerViewsCount = (this.ipY.getHeaderViewsCount() + i) - this.ipY.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.iuI = this.ipY.getChildAt(headerViewsCount);
                if (this.iuI != null) {
                    this.iuJ = this.iuI.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.iuI.getLayoutParams().height = p.this.iuJ - ((int) (p.this.iuJ * f));
                            p.this.iuI.requestLayout();
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
                            p.this.iuI.setVisibility(8);
                            if (p.this.iuK != null) {
                                p.this.iuK.removeThread(p.this.iuH);
                            }
                        }
                    });
                    animation.setDuration(iuo);
                    this.iuI.startAnimation(animation);
                }
            }
        }
    }
}
