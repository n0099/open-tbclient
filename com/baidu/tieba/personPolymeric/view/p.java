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
    public static int ivf = 300;
    private BdUniqueId Hx;
    private TbPageContext cfl;
    private NoNetworkView dwI;
    private PbListView dwJ;
    private int eFu;
    private ImageView eTM;
    private PluginErrorTipView fbx;
    private com.baidu.tbadk.k.a fvO;
    private boolean ilf;
    private CustomMessageListener ily;
    public BdPersonListView iqP;
    private com.baidu.tieba.personPolymeric.b.d ird;
    private com.baidu.tieba.personPolymeric.c.a irq;
    private com.baidu.tieba.view.g iuv;
    private int ivA;
    private i.a ivB;
    private com.baidu.tieba.view.f ivg;
    public n ivh;
    private com.baidu.tieba.model.a ivi;
    private com.baidu.tieba.view.i ivj;
    private TextView ivk;
    private LikeButtonWithHeadPortrait ivl;
    private com.baidu.tbadk.core.view.userLike.c ivm;
    private int ivn;
    private TextView ivo;
    private TextView ivp;
    private com.baidu.tieba.personPolymeric.a.n ivq;
    private CustomMessageListener ivr;
    private View ivt;
    private PersonCenterAttentionBarListView ivu;
    private boolean ivv;
    private k ivx;
    private String ivy;
    private View ivz;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean dRp = true;
    private int dRY = 0;
    private boolean ivs = false;
    private boolean ivw = false;
    View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b iqZ = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.iuv != null) {
                if (p.this.eTM == view) {
                    this.iqZ.fhu = 8;
                }
                p.this.iuv.a(view, this.iqZ);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.ivj != null) {
                p.this.ivj.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.ivj != null) {
                    p.this.ivj.onScroll(absListView, i, i2, i3);
                }
                p.this.cby();
            }
        }
    };
    private BdListView.e ye = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dwJ != null && p.this.ivi != null) {
                p.this.ird.xz(p.this.dRY);
                if (p.this.dRY == 0) {
                    p.this.dwJ.startLoadData();
                    p.this.ivi.i(false, false, false);
                } else if (p.this.dRY == 1) {
                    p.this.dwJ.startLoadData();
                    p.this.ivi.i(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a ivC = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.caI();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onNotExpanding() {
            p.this.ird.bpN();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onExpandingDegree(float f) {
            p.this.ird.controllTheStaticProgress(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.ilf = false;
        this.cfl = tbPageContext;
        this.Hx = bdUniqueId;
        this.mIsHost = z;
        this.ilf = z2;
        this.ird = eVar.caS();
        this.dwJ = this.ird.dwJ;
        this.eFu = com.baidu.adp.lib.util.l.getDimens(this.cfl.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.ivg = new com.baidu.tieba.view.d(2);
            x(tbPageContext);
            return;
        }
        this.ivg = new com.baidu.tieba.personPolymeric.a();
    }

    public void W(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.fbx = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.iqP = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.ivg.a(this.cfl.getPageActivity(), this.mNavigationBar);
        this.iqP.setOnScrollListener(this.mOnScrollListener);
        this.ivn = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eTM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eTM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eTM.getLayoutParams();
            layoutParams2.leftMargin = this.cfl.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eTM.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.ivk = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.ivl = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.ivm = new com.baidu.tbadk.core.view.userLike.c(this.cfl, this.ivl);
        this.ivm.mX("2");
        this.ivm.j(this.cfl.getUniqueId());
        this.ivm.a(new a());
        this.ivo = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.ivp = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.ilf) {
            this.eTM.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.iqP.setOnSrollToBottomListener(this.ye);
        this.ivh = new n(this.cfl, this.mIsHost);
        this.ivt = LayoutInflater.from(this.cfl.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.iqP.addHeaderView(this.ivt);
        this.iqP.setExpandView(this.ivt);
        this.iqP.addHeaderView(this.ivh.aMx());
        this.ivx = new k(this.cfl);
        this.iqP.addHeaderView(this.ivx.aMx());
        if (!this.mIsHost) {
            this.ivk.setText(R.string.ta_homepage);
            this.ivu = new PersonCenterAttentionBarListView(this.cfl.getPageActivity());
            this.iqP.addHeaderView(this.ivu);
        } else {
            this.ivk.setText(R.string.my_homepage);
        }
        this.iqP.setPersonListRefreshListener(this.ivC);
        this.ivq = new com.baidu.tieba.personPolymeric.a.n(this.cfl, this.iqP, this.Hx);
        this.ivq.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.ivl.setAlpha(0.0f);
        this.ivg.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.irq == null) {
            this.ivg.c(1.0f, true);
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            cby();
        }
        am.setViewTextColor(this.ivk, (int) R.color.cp_cont_a);
        this.ivl.onChangeSkinType(i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        if (this.ivg != null) {
            this.ivg.onChangeSkinType(i);
        }
        this.dwI.onChangeSkinType(this.cfl, i);
        this.fbx.onChangeSkinType(this.cfl, i);
        if (this.ivh != null) {
            this.ivh.onChangeSkinType(i);
        }
        if (this.iqP != null && (this.iqP.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.iqP.getAdapter().notifyDataSetChanged();
        }
        this.dwJ.changeSkin(i);
        am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            am.setNavbarTitleColor(this.ivp, R.color.cp_cont_b, R.color.s_navbar_title_color);
            am.setNavbarTitleColor(this.ivo, R.color.cp_cont_a, R.color.cp_cont_a);
        }
        if (this.ivu != null) {
            this.ivu.onChangeSkinType(i);
        }
        if (this.ivx != null) {
            this.ivx.onChangeSkinType(i);
        }
    }

    public void pE(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.ivg.c(1.0f, true);
            this.ivk.setAlpha(0.0f);
            this.ivl.setAlpha(1.0f);
            this.iqP.setSelectionFromTop(this.iqP.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.ivg.c(0.0f, false);
        this.ivk.setAlpha(1.0f);
        this.ivl.setAlpha(0.0f);
    }

    public void BH(String str) {
        if (this.ivh != null) {
            this.ivh.Bu(str);
        }
    }

    public void BI(String str) {
        if (this.ivh != null) {
            this.ivh.Bv(str);
        }
    }

    public void caI() {
        this.ivs = false;
        if (this.dRY == 0) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.ivi.resetData();
                this.ivi.refreshData();
                this.ird.doRefresh();
                return;
            }
            this.ird.bpN();
        } else if (this.dRY == 1) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                this.ivi.i(true, true, true);
                this.ird.doRefresh();
                return;
            }
            this.ird.bpN();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.iuv = gVar;
        this.ivg.setOnViewResponseListener(gVar);
        this.eTM.setOnClickListener(this.czV);
        this.ivh.setOnViewResponseListener(gVar);
        if (this.ird != null) {
            this.ird.a(this.ivt, gVar);
        }
    }

    public void W(View.OnClickListener onClickListener) {
        if (this.ivq != null) {
            this.ivq.W(onClickListener);
        }
    }

    public void pw(boolean z) {
        this.ivv = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_a, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eTM.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.ivo.setAlpha(1.0f - f);
            this.ivp.setAlpha(f);
        }
    }

    public void aE(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        ee(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pE(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.irq = aVar;
            this.ivg.setUserData(this.irq.getUserData());
            if (this.ivs) {
                ee(aVar.bww());
                if (this.dwJ != null) {
                    this.dwJ.endLoadData();
                    return;
                }
                return;
            }
            this.ivg.caF();
            this.ivh.e(aVar);
            if (aVar != null) {
                this.ivl.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.ivl.cbs();
            } else {
                this.irq.getUserData().setIsLike(this.irq.getUserData().getHave_attention() == 1);
                this.ivm.a(this.irq.getUserData());
            }
            if ((aVar.cbl() == null || this.mIsHost) && v.isEmpty(aVar.cbm())) {
                this.iqP.removeHeaderView(this.ivx.aMx());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.ivx.a(aVar.cbl(), this.mIsHost, this.irq.getUserData(), aVar.cbm());
            }
            if (!this.mIsHost) {
                if (aVar.cbn() == null || aVar.cbn().isw == null || aVar.cbn().isw.size() <= 0) {
                    this.iqP.removeHeaderView(this.ivu);
                } else {
                    this.ivu.a(aVar.cbn());
                }
            }
            if (v.isEmpty(aVar.bww())) {
                ee(null);
                this.ird.aKk();
                com.baidu.adp.lib.util.l.showToast(this.cfl.getContext(), this.cfl.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.chd().ql(this.mIsHost);
            ee(aVar.bww());
            int size = aVar.bww().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bww().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ird.aKk();
                    return;
                }
            }
            if (z) {
                if (this.dwJ != null) {
                    this.dwJ.endLoadData();
                    return;
                }
                return;
            }
            this.ird.e(true, aVar.bww());
        }
    }

    public void bpN() {
        this.ird.bpN();
    }

    private void x(TbPageContext tbPageContext) {
        this.ivr = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iQI;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.ivh != null && p.this.ivh.iuD != null) {
                            p.this.ivh.iuD.rG(aVar.hko);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.irq != null) {
                            if (p.this.irq.ism != null && p.this.irq.ism.aSR != null && aVar2 != null) {
                                p.this.irq.ism.aSR.putBoolean("person_center_item_red_tip_show", aVar2.hko);
                            }
                            if (aVar3 != null && p.this.irq.isl != null && p.this.irq.isl.aSR != null) {
                                p.this.irq.isl.aSR.putBoolean("person_center_item_red_tip_show", aVar3.hko);
                            }
                            if (aVar4 != null && p.this.irq.isj != null && p.this.irq.isj.aSR != null) {
                                p.this.irq.isj.aSR.putBoolean("person_center_item_red_tip_show", aVar4.hko);
                            }
                            if (aVar5 != null && p.this.irq.isn != null && p.this.irq.isn.aSR != null) {
                                p.this.irq.isn.aSR.putBoolean("person_center_item_red_tip_show", aVar5.hko);
                            }
                            if (aVar6 != null && p.this.irq.iso != null && p.this.irq.iso.aSR != null) {
                                p.this.irq.iso.aSR.putBoolean("person_center_item_red_tip_show", aVar6.hko);
                                p.this.irq.iso.aSR.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.ivg instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.ivg.O(5, aVar7.hko);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.ivg.O(6, aVar8.hko);
                            }
                        }
                    }
                }
            }
        };
        this.ivr.setTag(this.Hx);
        tbPageContext.registerListener(this.ivr);
        this.ily = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.ivh.BM(lVar.ahf());
                }
            }
        };
        this.ily.setTag(this.Hx);
        tbPageContext.registerListener(this.ily);
    }

    public void onDestory() {
        if (this.ivh != null) {
            this.ivh.onDestory();
        }
    }

    public com.baidu.tieba.view.f cbx() {
        return this.ivg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void ex(boolean z) {
            if (z) {
                if (p.this.fvO == null) {
                    p.this.fvO = new com.baidu.tbadk.k.a(p.this.cfl);
                }
                if (p.this.ivm.aok() != null && !StringUtils.isNull(p.this.ivm.aok().getUserId())) {
                    p.this.fvO.pT(p.this.ivm.aok().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.cfl.getPageActivity(), p.this.cfl.getString(R.string.unlike_success)).akT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cby() {
        aMv();
        aMw();
        cbz();
        if (this.ivh.aMx().getTop() + this.ivn <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.ivi = aVar;
    }

    private void aMv() {
        if (Build.VERSION.SDK_INT >= 11 && this.ivh != null) {
            int top = this.ivh.aMx().getTop();
            if (top >= this.eFu) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.eFu) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.eFu));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aMw() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.dRp) {
                    this.dRp = true;
                }
            } else if (this.dRp) {
                this.dRp = false;
            }
            a(alpha, !this.dRp);
            this.ivg.c(alpha, this.dRp ? false : true);
        }
    }

    private void cbz() {
        if (Build.VERSION.SDK_INT >= 11 && this.ivh != null) {
            int i = this.eFu / 2;
            int i2 = this.eFu - i;
            int top = this.ivh.aMx().getTop();
            if (this.ivk != null) {
                if (top < i) {
                    if (this.ivk.getAlpha() != 0.0f) {
                        this.ivk.setAlpha(0.0f);
                    }
                } else if (top < this.eFu && top >= i) {
                    if (i2 > 0) {
                        this.ivk.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.eFu && this.ivk.getAlpha() != 1.0f) {
                    this.ivk.setAlpha(1.0f);
                }
            }
            if (this.ivl != null) {
                if (top >= i) {
                    if (this.ivl.getAlpha() != 0.0f) {
                        this.ivl.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.ivl.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.ivl.getAlpha() != 1.0f) {
                    this.ivl.setAlpha(1.0f);
                }
            }
        }
    }

    public void ee(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.isEmpty(list)) {
            list = new ArrayList<>();
        }
        if (this.iqP.getVisibility() != 0) {
            this.iqP.setVisibility(0);
        }
        this.iqP.setData(list);
        int count = v.getCount(list);
        if (count >= 5) {
            if (this.ivv) {
                pE(true);
                this.ivv = false;
            }
        } else if (count <= 1) {
            this.iqP.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.ivj = iVar;
    }

    public NavigationBar aKR() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!aq.isEmpty(str) && this.iqP != null) {
            this.ivy = str;
            this.ivB = aVar;
            int headerViewsCount = (this.iqP.getHeaderViewsCount() + i) - this.iqP.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.ivz = this.iqP.getChildAt(headerViewsCount);
                if (this.ivz != null) {
                    this.ivA = this.ivz.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.ivz.getLayoutParams().height = p.this.ivA - ((int) (p.this.ivA * f));
                            p.this.ivz.requestLayout();
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
                            p.this.ivz.setVisibility(8);
                            if (p.this.ivB != null) {
                                p.this.ivB.removeThread(p.this.ivy);
                            }
                        }
                    });
                    animation.setDuration(ivf);
                    this.ivz.startAnimation(animation);
                }
            }
        }
    }
}
