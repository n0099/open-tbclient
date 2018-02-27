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
    public static int gsg = 300;
    private TbPageContext aRG;
    private BdUniqueId bri;
    private NoNetworkView caX;
    private PbListView caY;
    private com.baidu.tbadk.h.a dEC;
    private ImageView ddA;
    private PluginErrorTipView dpj;
    private boolean giJ;
    private CustomMessageListener giY;
    public BdPersonListView gnJ;
    private com.baidu.tieba.personPolymeric.b.d gnV;
    private com.baidu.tieba.personPolymeric.c.a gok;
    private com.baidu.tieba.view.i grx;
    private String gsA;
    private View gsB;
    private int gsC;
    private i.a gsD;
    private com.baidu.tieba.write.c gsE;
    private int gsh;
    private com.baidu.tieba.view.h gsi;
    public q gsj;
    private com.baidu.tieba.model.a gsk;
    private com.baidu.tieba.view.k gsl;
    private TextView gsm;
    private LikeButtonWithHeadPortrait gsn;
    private com.baidu.tbadk.core.view.userLike.c gso;
    private int gsp;
    private TextView gsq;
    private TextView gsr;
    private com.baidu.tieba.personPolymeric.a.n gss;
    private CustomMessageListener gst;
    private View gsv;
    private l gsw;
    private boolean gsx;
    private k gsz;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cJv = true;
    private int cLk = 0;
    private boolean gsu = false;
    private boolean gsy = false;
    View.OnClickListener blQ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.b gnR = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.grx != null) {
                if (s.this.ddA == view) {
                    this.gnR.drl = 8;
                }
                s.this.grx.a(view, this.gnR);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.gsl != null) {
                s.this.gsl.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (s.this.gsl != null) {
                    s.this.gsl.onScroll(absListView, i, i2, i3);
                }
                s.this.bkJ();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.caY != null && s.this.gsk != null) {
                s.this.gnV.tM(s.this.cLk);
                if (s.this.cLk == 0) {
                    s.this.caY.Ef();
                    s.this.gsk.i(false, false, false);
                } else if (s.this.cLk == 1) {
                    s.this.caY.Ef();
                    s.this.gsk.i(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gsF = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            s.this.bjU();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void ss() {
            s.this.gnV.azS();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void P(float f) {
            s.this.gnV.O(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.giJ = false;
        this.aRG = tbPageContext;
        this.bri = bdUniqueId;
        this.mIsHost = z;
        this.giJ = z2;
        this.gnV = eVar.bkd();
        this.caY = this.gnV.caY;
        this.gsh = com.baidu.adp.lib.util.l.t(this.aRG.getPageActivity(), d.e.tbds402);
        if (z) {
            this.gsi = new com.baidu.tieba.view.f(2);
            w(tbPageContext);
            return;
        }
        this.gsi = new com.baidu.tieba.personPolymeric.a();
    }

    public void bu(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0141d.cp_bg_line_c);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.dpj = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.gnJ = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.aRG.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gsi.a(this.aRG.getPageActivity(), this.mNavigationBar);
        this.gnJ.setOnScrollListener(this.mOnScrollListener);
        this.gsp = this.aRG.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.ddA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.ddA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ddA.getLayoutParams();
            layoutParams2.leftMargin = this.aRG.getResources().getDimensionPixelSize(d.e.ds14);
            this.ddA.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gsm = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.gsn = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.gso = new com.baidu.tbadk.core.view.userLike.c(this.aRG, this.gsn);
        this.gso.setFromType("2");
        this.gso.h(this.aRG.getUniqueId());
        this.gso.a(new a());
        this.gsq = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.gsr = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.giJ) {
            this.ddA.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gnJ.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gsj = new q(this.aRG, this.mIsHost);
        this.gsv = LayoutInflater.from(this.aRG.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.gnJ.addHeaderView(this.gsv);
        this.gnJ.setExpandView(this.gsv);
        this.gnJ.addHeaderView(this.gsj.aiw());
        this.gsz = new k(this.aRG);
        this.gnJ.addHeaderView(this.gsz.aiw());
        if (!this.mIsHost) {
            this.gsm.setText(d.j.ta_homepage);
            this.gsw = new l(this.aRG.getPageActivity());
            this.gnJ.addHeaderView(this.gsw);
        } else {
            this.gsm.setText(d.j.my_homepage);
        }
        this.gnJ.setPersonListRefreshListener(this.gsF);
        this.gss = new com.baidu.tieba.personPolymeric.a.n(this.aRG, this.gnJ, this.bri);
        this.gss.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gsn.setAlpha(0.0f);
        this.gsi.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gok == null) {
            this.gsi.c(1.0f, true);
            aj.c(this.ddA, d.f.selector_topbar_return_black);
        } else {
            bkJ();
        }
        aj.r(this.gsm, d.C0141d.cp_cont_i);
        this.gsn.onChangeSkinType(i);
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gsi != null) {
            this.gsi.onChangeSkinType(i);
        }
        this.caX.onChangeSkinType(this.aRG, i);
        this.dpj.onChangeSkinType(this.aRG, i);
        if (this.gsj != null) {
            this.gsj.onChangeSkinType(i);
        }
        if (this.gnJ != null && (this.gnJ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gnJ.getAdapter().notifyDataSetChanged();
        }
        this.caY.gx(i);
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.mIsHost) {
            aj.d(this.gsr, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            aj.d(this.gsq, d.C0141d.cp_cont_i, d.C0141d.cp_cont_i);
        }
        if (this.gsw != null) {
            this.gsw.onChangeSkinType(i);
        }
        if (this.gsz != null) {
            this.gsz.onChangeSkinType(i);
        }
    }

    public void lF(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.ddA, d.f.selector_topbar_return_black);
            this.gsi.c(1.0f, true);
            this.gsm.setAlpha(0.0f);
            this.gsn.setAlpha(1.0f);
            this.gnJ.setSelectionFromTop(this.gnJ.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.ddA, d.f.selector_topbar_return_white);
        this.gsi.c(0.0f, false);
        this.gsm.setAlpha(1.0f);
        this.gsn.setAlpha(0.0f);
    }

    public void bjU() {
        this.gsu = false;
        if (this.cLk == 0) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsk.resetData();
                this.gsk.refreshData();
                this.gnV.sr();
                return;
            }
            this.gnV.azS();
        } else if (this.cLk == 1) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsk.i(true, true, true);
                this.gnV.sr();
                return;
            }
            this.gnV.azS();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grx = iVar;
        this.gsi.setOnViewResponseListener(iVar);
        this.ddA.setOnClickListener(this.blQ);
        this.gsj.setOnViewResponseListener(iVar);
        if (this.gnV != null) {
            this.gnV.a(this.gsv, iVar);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gss != null) {
            this.gss.M(onClickListener);
        }
    }

    public void ly(boolean z) {
        this.gsx = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.ddA, d.f.selector_topbar_return_black);
        } else {
            aj.c(this.ddA, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.ddA.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gsq.setAlpha(1.0f - f);
            this.gsr.setAlpha(f);
        }
    }

    public void aq(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        dc(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lF(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gok = aVar;
            this.gsi.e(this.gok.getUserData());
            if (this.gsu) {
                dc(aVar.aEn());
                if (this.caY != null) {
                    this.caY.Eg();
                    return;
                }
                return;
            }
            this.gsi.bjM();
            this.gsj.e(aVar);
            this.gsn.setPortraitUrl(com.baidu.tbadk.core.util.o.ec(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gsn.bkC();
            } else {
                this.gok.getUserData().setIsLike(this.gok.getUserData().getHave_attention() == 1);
                this.gso.a(this.gok.getUserData());
            }
            if ((aVar.bkv() == null || this.mIsHost) && v.E(aVar.bkw())) {
                this.gnJ.removeHeaderView(this.gsz.aiw());
            } else {
                TiebaStatic.log(new ak("c12543"));
                this.gsz.a(aVar.bkv(), this.mIsHost, this.gok.getUserData(), aVar.bkw());
            }
            if (!this.mIsHost) {
                if (aVar.bkx() == null || aVar.bkx().gpx == null || aVar.bkx().gpx.size() <= 0) {
                    this.gnJ.removeHeaderView(this.gsw);
                } else {
                    this.gsw.a(aVar.bkx());
                }
            }
            if (v.E(aVar.aEn())) {
                dc(null);
                this.gnV.XP();
                com.baidu.adp.lib.util.l.showToast(this.aRG.getContext(), this.aRG.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.m.a.bpl().md(this.mIsHost);
            dc(aVar.aEn());
            int size = aVar.aEn().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.i iVar = aVar.aEn().get(i);
                if (iVar != null && (iVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gnV.XP();
                    return;
                }
            }
            if (z) {
                if (this.caY != null) {
                    this.caY.Eg();
                    return;
                }
                return;
            }
            this.gnV.b(true, aVar.aEn());
        }
    }

    public void azS() {
        this.gnV.azS();
    }

    private void w(TbPageContext tbPageContext) {
        this.gst = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.m.b) customResponsedMessage.getData()).gJE;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gsj != null && s.this.gsj.grF != null) {
                            s.this.gsj.grF.nw(aVar.ffU);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.gok != null) {
                            if (s.this.gok.gpn != null && s.this.gok.gpn.drm != null && aVar2 != null) {
                                s.this.gok.gpn.drm.putBoolean("person_center_item_red_tip_show", aVar2.ffU);
                            }
                            if (aVar3 != null && s.this.gok.gpm != null && s.this.gok.gpm.drm != null) {
                                s.this.gok.gpm.drm.putBoolean("person_center_item_red_tip_show", aVar3.ffU);
                            }
                            if (aVar4 != null && s.this.gok.gpk != null && s.this.gok.gpk.drm != null) {
                                s.this.gok.gpk.drm.putBoolean("person_center_item_red_tip_show", aVar4.ffU);
                            }
                            if (aVar5 != null && s.this.gok.gpo != null && s.this.gok.gpo.drm != null) {
                                s.this.gok.gpo.drm.putBoolean("person_center_item_red_tip_show", aVar5.ffU);
                            }
                            if (aVar6 != null && s.this.gok.gpp != null && s.this.gok.gpp.drm != null) {
                                s.this.gok.gpp.drm.putBoolean("person_center_item_red_tip_show", aVar6.ffU);
                                s.this.gok.gpp.drm.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.gsi instanceof com.baidu.tieba.view.f) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gsi.Q(5, aVar7.ffU);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gsi.Q(6, aVar8.ffU);
                            }
                        }
                    }
                }
            }
        };
        this.gst.setTag(this.bri);
        tbPageContext.registerListener(this.gst);
        this.giY = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    s.this.gsj.rf(hVar.ya());
                }
            }
        };
        this.giY.setTag(this.bri);
        tbPageContext.registerListener(this.giY);
    }

    public void onDestory() {
        if (this.gsj != null) {
            this.gsj.onDestory();
        }
    }

    public com.baidu.tieba.view.h bkI() {
        return this.gsi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bA(boolean z) {
            if (z) {
                if (s.this.dEC == null) {
                    s.this.dEC = new com.baidu.tbadk.h.a(s.this.aRG);
                }
                if (s.this.gso.ED() != null && !StringUtils.isNull(s.this.gso.ED().getUserId())) {
                    s.this.dEC.gI(s.this.gso.ED().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.aRG.getPageActivity(), s.this.aRG.getString(d.j.unlike_success)).Bc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkJ() {
        aim();
        ain();
        bkK();
        if (this.gsj.aiw().getTop() + this.gsp <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gsk = aVar;
    }

    private void aim() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsj != null) {
            int top = this.gsj.aiw().getTop();
            if (top >= this.gsh) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gsh) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gsh));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void ain() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cJv) {
                    this.cJv = true;
                }
            } else if (this.cJv) {
                this.cJv = false;
            }
            a(alpha, !this.cJv);
            this.gsi.c(alpha, this.cJv ? false : true);
        }
    }

    private void bkK() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsj != null) {
            int i = this.gsh / 2;
            int i2 = this.gsh - i;
            int top = this.gsj.aiw().getTop();
            if (this.gsm != null) {
                if (top < i) {
                    if (this.gsm.getAlpha() != 0.0f) {
                        this.gsm.setAlpha(0.0f);
                    }
                } else if (top < this.gsh && top >= i) {
                    if (i2 > 0) {
                        this.gsm.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gsh && this.gsm.getAlpha() != 1.0f) {
                    this.gsm.setAlpha(1.0f);
                }
            }
            if (this.gsn != null) {
                if (top >= i) {
                    if (this.gsn.getAlpha() != 0.0f) {
                        this.gsn.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gsn.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gsn.getAlpha() != 1.0f) {
                    this.gsn.setAlpha(1.0f);
                }
            }
        }
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnJ.getVisibility() != 0) {
            this.gnJ.setVisibility(0);
        }
        this.gnJ.setData(list);
        int D = v.D(list);
        if (D >= 5) {
            if (this.gsx) {
                lF(true);
                this.gsx = false;
            }
        } else if (D <= 1) {
            this.gnJ.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.k kVar) {
        this.gsl = kVar;
    }

    public NavigationBar avj() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!am.isEmpty(str) && this.gnJ != null) {
            this.gsA = str;
            this.gsD = aVar;
            int headerViewsCount = (this.gnJ.getHeaderViewsCount() + i) - this.gnJ.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gsB = this.gnJ.getChildAt(headerViewsCount);
                if (this.gsB != null) {
                    this.gsC = this.gsB.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.s.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            s.this.gsB.getLayoutParams().height = s.this.gsC - ((int) (s.this.gsC * f));
                            s.this.gsB.requestLayout();
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
                            s.this.gsB.setVisibility(8);
                            if (s.this.gsD != null) {
                                s.this.gsD.rc(s.this.gsA);
                            }
                        }
                    });
                    animation.setDuration(gsg);
                    this.gsB.startAnimation(animation);
                }
            }
        }
    }

    public void bkL() {
        if (this.gsE == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.gsE = new com.baidu.tieba.write.c(this.aRG, (ViewGroup) this.mRootView, "main_tab");
                this.gsE.uo("3");
            } else {
                return;
            }
        }
        this.gsE.nC(false);
    }
}
