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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.m.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class s {
    public static int gsr = 300;
    private TbPageContext aRR;
    private BdUniqueId brv;
    private NoNetworkView cbj;
    private PbListView cbk;
    private com.baidu.tbadk.h.a dEO;
    private ImageView ddM;
    private PluginErrorTipView dpv;
    private boolean giU;
    private CustomMessageListener gjj;
    public BdPersonListView gnU;
    private com.baidu.tieba.personPolymeric.b.d goh;
    private com.baidu.tieba.personPolymeric.c.a gov;
    private com.baidu.tieba.view.i grI;
    private int gsA;
    private TextView gsB;
    private TextView gsC;
    private com.baidu.tieba.personPolymeric.a.n gsD;
    private CustomMessageListener gsE;
    private View gsG;
    private l gsH;
    private boolean gsI;
    private k gsK;
    private String gsL;
    private View gsM;
    private int gsN;
    private i.a gsO;
    private com.baidu.tieba.write.c gsP;
    private int gss;
    private com.baidu.tieba.view.h gst;
    public q gsu;
    private com.baidu.tieba.model.a gsv;
    private com.baidu.tieba.view.k gsw;
    private TextView gsx;
    private LikeButtonWithHeadPortrait gsy;
    private com.baidu.tbadk.core.view.userLike.c gsz;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cJH = true;
    private int cLw = 0;
    private boolean gsF = false;
    private boolean gsJ = false;
    View.OnClickListener bmd = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.b goc = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.grI != null) {
                if (s.this.ddM == view) {
                    this.goc.drx = 8;
                }
                s.this.grI.a(view, this.goc);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.gsw != null) {
                s.this.gsw.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (s.this.gsw != null) {
                    s.this.gsw.onScroll(absListView, i, i2, i3);
                }
                s.this.bkK();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.cbk != null && s.this.gsv != null) {
                s.this.goh.tL(s.this.cLw);
                if (s.this.cLw == 0) {
                    s.this.cbk.Eg();
                    s.this.gsv.i(false, false, false);
                } else if (s.this.cLw == 1) {
                    s.this.cbk.Eg();
                    s.this.gsv.i(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gsQ = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            s.this.bjV();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void ss() {
            s.this.goh.azT();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void P(float f) {
            s.this.goh.O(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.giU = false;
        this.aRR = tbPageContext;
        this.brv = bdUniqueId;
        this.mIsHost = z;
        this.giU = z2;
        this.goh = eVar.bke();
        this.cbk = this.goh.cbk;
        this.gss = com.baidu.adp.lib.util.l.t(this.aRR.getPageActivity(), d.e.tbds402);
        if (z) {
            this.gst = new com.baidu.tieba.view.f(2);
            w(tbPageContext);
            return;
        }
        this.gst = new com.baidu.tieba.personPolymeric.a();
    }

    public void bu(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0140d.cp_bg_line_c);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.dpv = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.gnU = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.aRR.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gst.a(this.aRR.getPageActivity(), this.mNavigationBar);
        this.gnU.setOnScrollListener(this.mOnScrollListener);
        this.gsA = this.aRR.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.ddM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.ddM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ddM.getLayoutParams();
            layoutParams2.leftMargin = this.aRR.getResources().getDimensionPixelSize(d.e.ds14);
            this.ddM.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gsx = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.gsy = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.gsz = new com.baidu.tbadk.core.view.userLike.c(this.aRR, this.gsy);
        this.gsz.setFromType("2");
        this.gsz.h(this.aRR.getUniqueId());
        this.gsz.a(new a());
        this.gsB = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.gsC = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.giU) {
            this.ddM.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gnU.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gsu = new q(this.aRR, this.mIsHost);
        this.gsG = LayoutInflater.from(this.aRR.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.gnU.addHeaderView(this.gsG);
        this.gnU.setExpandView(this.gsG);
        this.gnU.addHeaderView(this.gsu.aix());
        this.gsK = new k(this.aRR);
        this.gnU.addHeaderView(this.gsK.aix());
        if (!this.mIsHost) {
            this.gsx.setText(d.j.ta_homepage);
            this.gsH = new l(this.aRR.getPageActivity());
            this.gnU.addHeaderView(this.gsH);
        } else {
            this.gsx.setText(d.j.my_homepage);
        }
        this.gnU.setPersonListRefreshListener(this.gsQ);
        this.gsD = new com.baidu.tieba.personPolymeric.a.n(this.aRR, this.gnU, this.brv);
        this.gsD.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gsy.setAlpha(0.0f);
        this.gst.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gov == null) {
            this.gst.c(1.0f, true);
            aj.c(this.ddM, d.f.selector_topbar_return_black);
        } else {
            bkK();
        }
        aj.r(this.gsx, d.C0140d.cp_cont_i);
        this.gsy.onChangeSkinType(i);
        aj.s(this.mRootView, d.C0140d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gst != null) {
            this.gst.onChangeSkinType(i);
        }
        this.cbj.onChangeSkinType(this.aRR, i);
        this.dpv.onChangeSkinType(this.aRR, i);
        if (this.gsu != null) {
            this.gsu.onChangeSkinType(i);
        }
        if (this.gnU != null && (this.gnU.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gnU.getAdapter().notifyDataSetChanged();
        }
        this.cbk.gx(i);
        aj.s(this.mRootView, d.C0140d.cp_bg_line_d);
        if (this.mIsHost) {
            aj.d(this.gsC, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            aj.d(this.gsB, d.C0140d.cp_cont_i, d.C0140d.cp_cont_i);
        }
        if (this.gsH != null) {
            this.gsH.onChangeSkinType(i);
        }
        if (this.gsK != null) {
            this.gsK.onChangeSkinType(i);
        }
    }

    public void lF(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.ddM, d.f.selector_topbar_return_black);
            this.gst.c(1.0f, true);
            this.gsx.setAlpha(0.0f);
            this.gsy.setAlpha(1.0f);
            this.gnU.setSelectionFromTop(this.gnU.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.ddM, d.f.selector_topbar_return_white);
        this.gst.c(0.0f, false);
        this.gsx.setAlpha(1.0f);
        this.gsy.setAlpha(0.0f);
    }

    public void bjV() {
        this.gsF = false;
        if (this.cLw == 0) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsv.resetData();
                this.gsv.refreshData();
                this.goh.sr();
                return;
            }
            this.goh.azT();
        } else if (this.cLw == 1) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsv.i(true, true, true);
                this.goh.sr();
                return;
            }
            this.goh.azT();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grI = iVar;
        this.gst.setOnViewResponseListener(iVar);
        this.ddM.setOnClickListener(this.bmd);
        this.gsu.setOnViewResponseListener(iVar);
        if (this.goh != null) {
            this.goh.a(this.gsG, iVar);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gsD != null) {
            this.gsD.M(onClickListener);
        }
    }

    public void ly(boolean z) {
        this.gsI = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.ddM, d.f.selector_topbar_return_black);
        } else {
            aj.c(this.ddM, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.ddM.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gsB.setAlpha(1.0f - f);
            this.gsC.setAlpha(f);
        }
    }

    public void aq(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        dc(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lF(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gov = aVar;
            this.gst.e(this.gov.getUserData());
            if (this.gsF) {
                dc(aVar.aEo());
                if (this.cbk != null) {
                    this.cbk.Eh();
                    return;
                }
                return;
            }
            this.gst.bjN();
            this.gsu.e(aVar);
            this.gsy.setPortraitUrl(com.baidu.tbadk.core.util.o.ec(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gsy.bkD();
            } else {
                this.gov.getUserData().setIsLike(this.gov.getUserData().getHave_attention() == 1);
                this.gsz.a(this.gov.getUserData());
            }
            if ((aVar.bkw() == null || this.mIsHost) && v.E(aVar.bkx())) {
                this.gnU.removeHeaderView(this.gsK.aix());
            } else {
                TiebaStatic.log(new ak("c12543"));
                this.gsK.a(aVar.bkw(), this.mIsHost, this.gov.getUserData(), aVar.bkx());
            }
            if (!this.mIsHost) {
                if (aVar.bky() == null || aVar.bky().gpI == null || aVar.bky().gpI.size() <= 0) {
                    this.gnU.removeHeaderView(this.gsH);
                } else {
                    this.gsH.a(aVar.bky());
                }
            }
            if (v.E(aVar.aEo())) {
                dc(null);
                this.goh.XQ();
                com.baidu.adp.lib.util.l.showToast(this.aRR.getContext(), this.aRR.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.m.a.bpm().md(this.mIsHost);
            dc(aVar.aEo());
            int size = aVar.aEo().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.i iVar = aVar.aEo().get(i);
                if (iVar != null && (iVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.goh.XQ();
                    return;
                }
            }
            if (z) {
                if (this.cbk != null) {
                    this.cbk.Eh();
                    return;
                }
                return;
            }
            this.goh.b(true, aVar.aEo());
        }
    }

    public void azT() {
        this.goh.azT();
    }

    private void w(TbPageContext tbPageContext) {
        this.gsE = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.m.b) customResponsedMessage.getData()).gJT;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gsu != null && s.this.gsu.grQ != null) {
                            s.this.gsu.grQ.nw(aVar.fgg);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.gov != null) {
                            if (s.this.gov.gpy != null && s.this.gov.gpy.dry != null && aVar2 != null) {
                                s.this.gov.gpy.dry.putBoolean("person_center_item_red_tip_show", aVar2.fgg);
                            }
                            if (aVar3 != null && s.this.gov.gpx != null && s.this.gov.gpx.dry != null) {
                                s.this.gov.gpx.dry.putBoolean("person_center_item_red_tip_show", aVar3.fgg);
                            }
                            if (aVar4 != null && s.this.gov.gpv != null && s.this.gov.gpv.dry != null) {
                                s.this.gov.gpv.dry.putBoolean("person_center_item_red_tip_show", aVar4.fgg);
                            }
                            if (aVar5 != null && s.this.gov.gpz != null && s.this.gov.gpz.dry != null) {
                                s.this.gov.gpz.dry.putBoolean("person_center_item_red_tip_show", aVar5.fgg);
                            }
                            if (aVar6 != null && s.this.gov.gpA != null && s.this.gov.gpA.dry != null) {
                                s.this.gov.gpA.dry.putBoolean("person_center_item_red_tip_show", aVar6.fgg);
                                s.this.gov.gpA.dry.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.gst instanceof com.baidu.tieba.view.f) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gst.Q(5, aVar7.fgg);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gst.Q(6, aVar8.fgg);
                            }
                        }
                    }
                }
            }
        };
        this.gsE.setTag(this.brv);
        tbPageContext.registerListener(this.gsE);
        this.gjj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    s.this.gsu.rf(hVar.ya());
                }
            }
        };
        this.gjj.setTag(this.brv);
        tbPageContext.registerListener(this.gjj);
    }

    public void onDestory() {
        if (this.gsu != null) {
            this.gsu.onDestory();
        }
    }

    public com.baidu.tieba.view.h bkJ() {
        return this.gst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bA(boolean z) {
            if (z) {
                if (s.this.dEO == null) {
                    s.this.dEO = new com.baidu.tbadk.h.a(s.this.aRR);
                }
                if (s.this.gsz.EE() != null && !StringUtils.isNull(s.this.gsz.EE().getUserId())) {
                    s.this.dEO.gI(s.this.gsz.EE().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.aRR.getPageActivity(), s.this.aRR.getString(d.j.unlike_success)).Bc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkK() {
        ain();
        aio();
        bkL();
        if (this.gsu.aix().getTop() + this.gsA <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gsv = aVar;
    }

    private void ain() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsu != null) {
            int top = this.gsu.aix().getTop();
            if (top >= this.gss) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gss) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gss));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aio() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cJH) {
                    this.cJH = true;
                }
            } else if (this.cJH) {
                this.cJH = false;
            }
            a(alpha, !this.cJH);
            this.gst.c(alpha, this.cJH ? false : true);
        }
    }

    private void bkL() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsu != null) {
            int i = this.gss / 2;
            int i2 = this.gss - i;
            int top = this.gsu.aix().getTop();
            if (this.gsx != null) {
                if (top < i) {
                    if (this.gsx.getAlpha() != 0.0f) {
                        this.gsx.setAlpha(0.0f);
                    }
                } else if (top < this.gss && top >= i) {
                    if (i2 > 0) {
                        this.gsx.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gss && this.gsx.getAlpha() != 1.0f) {
                    this.gsx.setAlpha(1.0f);
                }
            }
            if (this.gsy != null) {
                if (top >= i) {
                    if (this.gsy.getAlpha() != 0.0f) {
                        this.gsy.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gsy.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gsy.getAlpha() != 1.0f) {
                    this.gsy.setAlpha(1.0f);
                }
            }
        }
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnU.getVisibility() != 0) {
            this.gnU.setVisibility(0);
        }
        this.gnU.setData(list);
        int D = v.D(list);
        if (D >= 5) {
            if (this.gsI) {
                lF(true);
                this.gsI = false;
            }
        } else if (D <= 1) {
            this.gnU.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.k kVar) {
        this.gsw = kVar;
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!am.isEmpty(str) && this.gnU != null) {
            this.gsL = str;
            this.gsO = aVar;
            int headerViewsCount = (this.gnU.getHeaderViewsCount() + i) - this.gnU.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gsM = this.gnU.getChildAt(headerViewsCount);
                if (this.gsM != null) {
                    this.gsN = this.gsM.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.s.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            s.this.gsM.getLayoutParams().height = s.this.gsN - ((int) (s.this.gsN * f));
                            s.this.gsM.requestLayout();
                        }

                        @Override // android.view.animation.Animation
                        public boolean willChangeBounds() {
                            return true;
                        }
                    };
                    animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.personPolymeric.view.s.6
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation2) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation2) {
                            s.this.gsM.setVisibility(8);
                            if (s.this.gsO != null) {
                                s.this.gsO.rc(s.this.gsL);
                            }
                        }
                    });
                    animation.setDuration(gsr);
                    this.gsM.startAnimation(animation);
                }
            }
        }
    }

    public void bkM() {
        if (this.gsP == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.gsP = new com.baidu.tieba.write.c(this.aRR, (ViewGroup) this.mRootView, "main_tab");
                this.gsP.uo("3");
            } else {
                return;
            }
        }
        this.gsP.nC(false);
    }
}
