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
    public static int gsw = 300;
    private TbPageContext aRI;
    private BdUniqueId brl;
    private NoNetworkView cba;
    private PbListView cbb;
    private com.baidu.tbadk.h.a dEF;
    private ImageView ddD;
    private PluginErrorTipView dpm;
    private boolean giZ;
    private CustomMessageListener gjo;
    public BdPersonListView gnZ;
    private com.baidu.tieba.personPolymeric.c.a goA;
    private com.baidu.tieba.personPolymeric.b.d gom;
    private com.baidu.tieba.view.i grN;
    private com.baidu.tieba.model.a gsA;
    private com.baidu.tieba.view.k gsB;
    private TextView gsC;
    private LikeButtonWithHeadPortrait gsD;
    private com.baidu.tbadk.core.view.userLike.c gsE;
    private int gsF;
    private TextView gsG;
    private TextView gsH;
    private com.baidu.tieba.personPolymeric.a.n gsI;
    private CustomMessageListener gsJ;
    private View gsL;
    private l gsM;
    private boolean gsN;
    private k gsP;
    private String gsQ;
    private View gsR;
    private int gsS;
    private i.a gsT;
    private com.baidu.tieba.write.c gsU;
    private int gsx;
    private com.baidu.tieba.view.h gsy;
    public q gsz;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cJy = true;
    private int cLn = 0;
    private boolean gsK = false;
    private boolean gsO = false;
    View.OnClickListener blT = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.b goi = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.grN != null) {
                if (s.this.ddD == view) {
                    this.goi.dro = 8;
                }
                s.this.grN.a(view, this.goi);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.gsB != null) {
                s.this.gsB.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (s.this.gsB != null) {
                    s.this.gsB.onScroll(absListView, i, i2, i3);
                }
                s.this.bkK();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.cbb != null && s.this.gsA != null) {
                s.this.gom.tM(s.this.cLn);
                if (s.this.cLn == 0) {
                    s.this.cbb.Eg();
                    s.this.gsA.i(false, false, false);
                } else if (s.this.cLn == 1) {
                    s.this.cbb.Eg();
                    s.this.gsA.i(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gsV = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            s.this.bjV();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void ss() {
            s.this.gom.azU();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void P(float f) {
            s.this.gom.O(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.giZ = false;
        this.aRI = tbPageContext;
        this.brl = bdUniqueId;
        this.mIsHost = z;
        this.giZ = z2;
        this.gom = eVar.bke();
        this.cbb = this.gom.cbb;
        this.gsx = com.baidu.adp.lib.util.l.t(this.aRI.getPageActivity(), d.e.tbds402);
        if (z) {
            this.gsy = new com.baidu.tieba.view.f(2);
            w(tbPageContext);
            return;
        }
        this.gsy = new com.baidu.tieba.personPolymeric.a();
    }

    public void bu(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0141d.cp_bg_line_c);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.dpm = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.gnZ = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.aRI.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gsy.a(this.aRI.getPageActivity(), this.mNavigationBar);
        this.gnZ.setOnScrollListener(this.mOnScrollListener);
        this.gsF = this.aRI.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.ddD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.ddD.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ddD.getLayoutParams();
            layoutParams2.leftMargin = this.aRI.getResources().getDimensionPixelSize(d.e.ds14);
            this.ddD.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gsC = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.gsD = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.gsE = new com.baidu.tbadk.core.view.userLike.c(this.aRI, this.gsD);
        this.gsE.setFromType("2");
        this.gsE.h(this.aRI.getUniqueId());
        this.gsE.a(new a());
        this.gsG = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.gsH = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.giZ) {
            this.ddD.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gnZ.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gsz = new q(this.aRI, this.mIsHost);
        this.gsL = LayoutInflater.from(this.aRI.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.gnZ.addHeaderView(this.gsL);
        this.gnZ.setExpandView(this.gsL);
        this.gnZ.addHeaderView(this.gsz.aix());
        this.gsP = new k(this.aRI);
        this.gnZ.addHeaderView(this.gsP.aix());
        if (!this.mIsHost) {
            this.gsC.setText(d.j.ta_homepage);
            this.gsM = new l(this.aRI.getPageActivity());
            this.gnZ.addHeaderView(this.gsM);
        } else {
            this.gsC.setText(d.j.my_homepage);
        }
        this.gnZ.setPersonListRefreshListener(this.gsV);
        this.gsI = new com.baidu.tieba.personPolymeric.a.n(this.aRI, this.gnZ, this.brl);
        this.gsI.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gsD.setAlpha(0.0f);
        this.gsy.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.goA == null) {
            this.gsy.c(1.0f, true);
            aj.c(this.ddD, d.f.selector_topbar_return_black);
        } else {
            bkK();
        }
        aj.r(this.gsC, d.C0141d.cp_cont_i);
        this.gsD.onChangeSkinType(i);
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        if (this.gsy != null) {
            this.gsy.onChangeSkinType(i);
        }
        this.cba.onChangeSkinType(this.aRI, i);
        this.dpm.onChangeSkinType(this.aRI, i);
        if (this.gsz != null) {
            this.gsz.onChangeSkinType(i);
        }
        if (this.gnZ != null && (this.gnZ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gnZ.getAdapter().notifyDataSetChanged();
        }
        this.cbb.gx(i);
        aj.s(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.mIsHost) {
            aj.d(this.gsH, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            aj.d(this.gsG, d.C0141d.cp_cont_i, d.C0141d.cp_cont_i);
        }
        if (this.gsM != null) {
            this.gsM.onChangeSkinType(i);
        }
        if (this.gsP != null) {
            this.gsP.onChangeSkinType(i);
        }
    }

    public void lK(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.ddD, d.f.selector_topbar_return_black);
            this.gsy.c(1.0f, true);
            this.gsC.setAlpha(0.0f);
            this.gsD.setAlpha(1.0f);
            this.gnZ.setSelectionFromTop(this.gnZ.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.ddD, d.f.selector_topbar_return_white);
        this.gsy.c(0.0f, false);
        this.gsC.setAlpha(1.0f);
        this.gsD.setAlpha(0.0f);
    }

    public void bjV() {
        this.gsK = false;
        if (this.cLn == 0) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsA.resetData();
                this.gsA.refreshData();
                this.gom.sr();
                return;
            }
            this.gom.azU();
        } else if (this.cLn == 1) {
            if (com.baidu.adp.lib.util.j.oJ()) {
                this.gsA.i(true, true, true);
                this.gom.sr();
                return;
            }
            this.gom.azU();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.i iVar) {
        this.grN = iVar;
        this.gsy.setOnViewResponseListener(iVar);
        this.ddD.setOnClickListener(this.blT);
        this.gsz.setOnViewResponseListener(iVar);
        if (this.gom != null) {
            this.gom.a(this.gsL, iVar);
        }
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.gsI != null) {
            this.gsI.M(onClickListener);
        }
    }

    public void lD(boolean z) {
        this.gsN = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.ddD, d.f.selector_topbar_return_black);
        } else {
            aj.c(this.ddD, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.ddD.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gsG.setAlpha(1.0f - f);
            this.gsH.setAlpha(f);
        }
    }

    public void aq(ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        dc(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lK(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.goA = aVar;
            this.gsy.e(this.goA.getUserData());
            if (this.gsK) {
                dc(aVar.aEo());
                if (this.cbb != null) {
                    this.cbb.Eh();
                    return;
                }
                return;
            }
            this.gsy.bjN();
            this.gsz.e(aVar);
            this.gsD.setPortraitUrl(com.baidu.tbadk.core.util.o.ec(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gsD.bkD();
            } else {
                this.goA.getUserData().setIsLike(this.goA.getUserData().getHave_attention() == 1);
                this.gsE.a(this.goA.getUserData());
            }
            if ((aVar.bkw() == null || this.mIsHost) && v.E(aVar.bkx())) {
                this.gnZ.removeHeaderView(this.gsP.aix());
            } else {
                TiebaStatic.log(new ak("c12543"));
                this.gsP.a(aVar.bkw(), this.mIsHost, this.goA.getUserData(), aVar.bkx());
            }
            if (!this.mIsHost) {
                if (aVar.bky() == null || aVar.bky().gpN == null || aVar.bky().gpN.size() <= 0) {
                    this.gnZ.removeHeaderView(this.gsM);
                } else {
                    this.gsM.a(aVar.bky());
                }
            }
            if (v.E(aVar.aEo())) {
                dc(null);
                this.gom.XQ();
                com.baidu.adp.lib.util.l.showToast(this.aRI.getContext(), this.aRI.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.m.a.bpm().mi(this.mIsHost);
            dc(aVar.aEo());
            int size = aVar.aEo().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.i iVar = aVar.aEo().get(i);
                if (iVar != null && (iVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gom.XQ();
                    return;
                }
            }
            if (z) {
                if (this.cbb != null) {
                    this.cbb.Eh();
                    return;
                }
                return;
            }
            this.gom.b(true, aVar.aEo());
        }
    }

    public void azU() {
        this.gom.azU();
    }

    private void w(TbPageContext tbPageContext) {
        this.gsJ = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.m.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.m.b) customResponsedMessage.getData()).gJU;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gsz != null && s.this.gsz.grV != null) {
                            s.this.gsz.grV.nB(aVar.fgi);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.goA != null) {
                            if (s.this.goA.gpD != null && s.this.goA.gpD.drp != null && aVar2 != null) {
                                s.this.goA.gpD.drp.putBoolean("person_center_item_red_tip_show", aVar2.fgi);
                            }
                            if (aVar3 != null && s.this.goA.gpC != null && s.this.goA.gpC.drp != null) {
                                s.this.goA.gpC.drp.putBoolean("person_center_item_red_tip_show", aVar3.fgi);
                            }
                            if (aVar4 != null && s.this.goA.gpA != null && s.this.goA.gpA.drp != null) {
                                s.this.goA.gpA.drp.putBoolean("person_center_item_red_tip_show", aVar4.fgi);
                            }
                            if (aVar5 != null && s.this.goA.gpE != null && s.this.goA.gpE.drp != null) {
                                s.this.goA.gpE.drp.putBoolean("person_center_item_red_tip_show", aVar5.fgi);
                            }
                            if (aVar6 != null && s.this.goA.gpF != null && s.this.goA.gpF.drp != null) {
                                s.this.goA.gpF.drp.putBoolean("person_center_item_red_tip_show", aVar6.fgi);
                                s.this.goA.gpF.drp.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.gsy instanceof com.baidu.tieba.view.f) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gsy.Q(5, aVar7.fgi);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gsy.Q(6, aVar8.fgi);
                            }
                        }
                    }
                }
            }
        };
        this.gsJ.setTag(this.brl);
        tbPageContext.registerListener(this.gsJ);
        this.gjo = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    s.this.gsz.rf(hVar.ya());
                }
            }
        };
        this.gjo.setTag(this.brl);
        tbPageContext.registerListener(this.gjo);
    }

    public void onDestory() {
        if (this.gsz != null) {
            this.gsz.onDestory();
        }
    }

    public com.baidu.tieba.view.h bkJ() {
        return this.gsy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bA(boolean z) {
            if (z) {
                if (s.this.dEF == null) {
                    s.this.dEF = new com.baidu.tbadk.h.a(s.this.aRI);
                }
                if (s.this.gsE.EE() != null && !StringUtils.isNull(s.this.gsE.EE().getUserId())) {
                    s.this.dEF.gI(s.this.gsE.EE().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.aRI.getPageActivity(), s.this.aRI.getString(d.j.unlike_success)).Bd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkK() {
        ain();
        aio();
        bkL();
        if (this.gsz.aix().getTop() + this.gsF <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gsA = aVar;
    }

    private void ain() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsz != null) {
            int top = this.gsz.aix().getTop();
            if (top >= this.gsx) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gsx) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gsx));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aio() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cJy) {
                    this.cJy = true;
                }
            } else if (this.cJy) {
                this.cJy = false;
            }
            a(alpha, !this.cJy);
            this.gsy.c(alpha, this.cJy ? false : true);
        }
    }

    private void bkL() {
        if (Build.VERSION.SDK_INT >= 11 && this.gsz != null) {
            int i = this.gsx / 2;
            int i2 = this.gsx - i;
            int top = this.gsz.aix().getTop();
            if (this.gsC != null) {
                if (top < i) {
                    if (this.gsC.getAlpha() != 0.0f) {
                        this.gsC.setAlpha(0.0f);
                    }
                } else if (top < this.gsx && top >= i) {
                    if (i2 > 0) {
                        this.gsC.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gsx && this.gsC.getAlpha() != 1.0f) {
                    this.gsC.setAlpha(1.0f);
                }
            }
            if (this.gsD != null) {
                if (top >= i) {
                    if (this.gsD.getAlpha() != 0.0f) {
                        this.gsD.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gsD.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gsD.getAlpha() != 1.0f) {
                    this.gsD.setAlpha(1.0f);
                }
            }
        }
    }

    public void dc(List<com.baidu.adp.widget.ListView.i> list) {
        if (v.E(list)) {
            list = new ArrayList<>();
        }
        if (this.gnZ.getVisibility() != 0) {
            this.gnZ.setVisibility(0);
        }
        this.gnZ.setData(list);
        int D = v.D(list);
        if (D >= 5) {
            if (this.gsN) {
                lK(true);
                this.gsN = false;
            }
        } else if (D <= 1) {
            this.gnZ.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.k kVar) {
        this.gsB = kVar;
    }

    public NavigationBar avk() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!am.isEmpty(str) && this.gnZ != null) {
            this.gsQ = str;
            this.gsT = aVar;
            int headerViewsCount = (this.gnZ.getHeaderViewsCount() + i) - this.gnZ.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gsR = this.gnZ.getChildAt(headerViewsCount);
                if (this.gsR != null) {
                    this.gsS = this.gsR.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.s.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            s.this.gsR.getLayoutParams().height = s.this.gsS - ((int) (s.this.gsS * f));
                            s.this.gsR.requestLayout();
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
                            s.this.gsR.setVisibility(8);
                            if (s.this.gsT != null) {
                                s.this.gsT.rc(s.this.gsQ);
                            }
                        }
                    });
                    animation.setDuration(gsw);
                    this.gsR.startAnimation(animation);
                }
            }
        }
    }

    public void bkM() {
        if (this.gsU == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.gsU = new com.baidu.tieba.write.c(this.aRI, (ViewGroup) this.mRootView, "main_tab");
                this.gsU.uo("3");
            } else {
                return;
            }
        }
        this.gsU.nH(false);
    }
}
