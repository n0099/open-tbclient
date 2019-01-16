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
    public static int gEG = 300;
    private BdUniqueId aCu;
    private NoNetworkView bPl;
    private PbListView bPm;
    private com.baidu.tbadk.i.a dLT;
    private ImageView dfd;
    private PluginErrorTipView drP;
    private com.baidu.tieba.personPolymeric.b.d gAF;
    private com.baidu.tieba.personPolymeric.c.a gAS;
    public BdPersonListView gAr;
    private com.baidu.tieba.view.g gDW;
    private int gEH;
    private com.baidu.tieba.view.f gEI;
    public n gEJ;
    private com.baidu.tieba.model.a gEK;
    private com.baidu.tieba.view.i gEL;
    private TextView gEM;
    private LikeButtonWithHeadPortrait gEN;
    private com.baidu.tbadk.core.view.userLike.c gEO;
    private int gEP;
    private TextView gEQ;
    private TextView gER;
    private com.baidu.tieba.personPolymeric.a.n gES;
    private CustomMessageListener gET;
    private View gEV;
    private PersonCenterAttentionBarListView gEW;
    private boolean gEX;
    private k gEZ;
    private String gFa;
    private View gFb;
    private int gFc;
    private i.a gFd;
    private boolean gva;
    private CustomMessageListener gvs;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cHQ = true;
    private int cJV = 0;
    private boolean gEU = false;
    private boolean gEY = false;
    View.OnClickListener aTI = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gAB = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gDW != null) {
                if (p.this.dfd == view) {
                    this.gAB.duk = 8;
                }
                p.this.gDW.a(view, this.gAB);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gEL != null) {
                p.this.gEL.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gEL != null) {
                    p.this.gEL.onScroll(absListView, i, i2, i3);
                }
                p.this.bsc();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bPm != null && p.this.gEK != null) {
                p.this.gAF.tx(p.this.cJV);
                if (p.this.cJV == 0) {
                    p.this.bPm.Fp();
                    p.this.gEK.g(false, false, false);
                } else if (p.this.cJV == 1) {
                    p.this.bPm.Fp();
                    p.this.gEK.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gFe = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bro();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oG() {
            p.this.gAF.aIa();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gAF.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gva = false;
        this.mContext = tbPageContext;
        this.aCu = bdUniqueId;
        this.mIsHost = z;
        this.gva = z2;
        this.gAF = eVar.brx();
        this.bPm = this.gAF.bPm;
        this.gEH = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds402);
        if (z) {
            this.gEI = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gEI = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bPl = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.drP = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gAr = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gEI.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gAr.setOnScrollListener(this.mOnScrollListener);
        this.gEP = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.dfd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.dfd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dfd.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.dfd.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gEM = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gEN = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gEO = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gEN);
        this.gEO.setFromType("2");
        this.gEO.h(this.mContext.getUniqueId());
        this.gEO.a(new a());
        this.gEQ = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gER = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.gva) {
            this.dfd.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gAr.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gEJ = new n(this.mContext, this.mIsHost);
        this.gEV = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gAr.addHeaderView(this.gEV);
        this.gAr.setExpandView(this.gEV);
        this.gAr.addHeaderView(this.gEJ.anZ());
        this.gEZ = new k(this.mContext);
        this.gAr.addHeaderView(this.gEZ.anZ());
        if (!this.mIsHost) {
            this.gEM.setText(e.j.ta_homepage);
            this.gEW = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gAr.addHeaderView(this.gEW);
        } else {
            this.gEM.setText(e.j.my_homepage);
        }
        this.gAr.setPersonListRefreshListener(this.gFe);
        this.gES = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gAr, this.aCu);
        this.gES.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gEN.setAlpha(0.0f);
        this.gEI.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gAS == null) {
            this.gEI.c(1.0f, true);
            al.c(this.dfd, e.f.selector_topbar_return_black);
        } else {
            bsc();
        }
        al.h(this.gEM, e.d.cp_cont_i);
        this.gEN.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        if (this.gEI != null) {
            this.gEI.onChangeSkinType(i);
        }
        this.bPl.onChangeSkinType(this.mContext, i);
        this.drP.onChangeSkinType(this.mContext, i);
        if (this.gEJ != null) {
            this.gEJ.onChangeSkinType(i);
        }
        if (this.gAr != null && (this.gAr.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gAr.getAdapter().notifyDataSetChanged();
        }
        this.bPm.ey(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gER, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gEQ, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gEW != null) {
            this.gEW.onChangeSkinType(i);
        }
        if (this.gEZ != null) {
            this.gEZ.onChangeSkinType(i);
        }
    }

    public void mr(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.dfd, e.f.selector_topbar_return_black);
            this.gEI.c(1.0f, true);
            this.gEM.setAlpha(0.0f);
            this.gEN.setAlpha(1.0f);
            this.gAr.setSelectionFromTop(this.gAr.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.dfd, e.f.selector_topbar_return_white);
        this.gEI.c(0.0f, false);
        this.gEM.setAlpha(1.0f);
        this.gEN.setAlpha(0.0f);
    }

    public void ud(String str) {
        if (this.gEJ != null) {
            this.gEJ.tS(str);
        }
    }

    public void ue(String str) {
        if (this.gEJ != null) {
            this.gEJ.tT(str);
        }
    }

    public void bro() {
        this.gEU = false;
        if (this.cJV == 0) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gEK.resetData();
                this.gEK.refreshData();
                this.gAF.oF();
                return;
            }
            this.gAF.aIa();
        } else if (this.cJV == 1) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gEK.g(true, true, true);
                this.gAF.oF();
                return;
            }
            this.gAF.aIa();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDW = gVar;
        this.gEI.setOnViewResponseListener(gVar);
        this.dfd.setOnClickListener(this.aTI);
        this.gEJ.setOnViewResponseListener(gVar);
        if (this.gAF != null) {
            this.gAF.a(this.gEV, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gES != null) {
            this.gES.Q(onClickListener);
        }
    }

    public void mj(boolean z) {
        this.gEX = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.dfd, e.f.selector_topbar_return_black);
        } else {
            al.c(this.dfd, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.dfd.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gEQ.setAlpha(1.0f - f);
            this.gER.setAlpha(f);
        }
    }

    public void as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dv(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        mr(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gAS = aVar;
            this.gEI.e(this.gAS.getUserData());
            if (this.gEU) {
                dv(aVar.aNX());
                if (this.bPm != null) {
                    this.bPm.Fq();
                    return;
                }
                return;
            }
            this.gEI.brf();
            this.gEJ.e(aVar);
            if (aVar != null) {
                this.gEN.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.gEN.brW();
            } else {
                this.gAS.getUserData().setIsLike(this.gAS.getUserData().getHave_attention() == 1);
                this.gEO.a(this.gAS.getUserData());
            }
            if ((aVar.brP() == null || this.mIsHost) && v.I(aVar.brQ())) {
                this.gAr.removeHeaderView(this.gEZ.anZ());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gEZ.a(aVar.brP(), this.mIsHost, this.gAS.getUserData(), aVar.brQ());
            }
            if (!this.mIsHost) {
                if (aVar.brR() == null || aVar.brR().gBY == null || aVar.brR().gBY.size() <= 0) {
                    this.gAr.removeHeaderView(this.gEW);
                } else {
                    this.gEW.a(aVar.brR());
                }
            }
            if (v.I(aVar.aNX())) {
                dv(null);
                this.gAF.abA();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bxf().mU(this.mIsHost);
            dv(aVar.aNX());
            int size = aVar.aNX().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aNX().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gAF.abA();
                    return;
                }
            }
            if (z) {
                if (this.bPm != null) {
                    this.bPm.Fq();
                    return;
                }
                return;
            }
            this.gAF.c(true, aVar.aNX());
        }
    }

    public void aIa() {
        this.gAF.aIa();
    }

    private void w(TbPageContext tbPageContext) {
        this.gET = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gXD;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gEJ != null && p.this.gEJ.gEe != null) {
                            p.this.gEJ.gEe.oq(aVar.fvV);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.gAS != null) {
                            if (p.this.gAS.gBO != null && p.this.gAS.gBO.dul != null && aVar2 != null) {
                                p.this.gAS.gBO.dul.putBoolean("person_center_item_red_tip_show", aVar2.fvV);
                            }
                            if (aVar3 != null && p.this.gAS.gBN != null && p.this.gAS.gBN.dul != null) {
                                p.this.gAS.gBN.dul.putBoolean("person_center_item_red_tip_show", aVar3.fvV);
                            }
                            if (aVar4 != null && p.this.gAS.gBL != null && p.this.gAS.gBL.dul != null) {
                                p.this.gAS.gBL.dul.putBoolean("person_center_item_red_tip_show", aVar4.fvV);
                            }
                            if (aVar5 != null && p.this.gAS.gBP != null && p.this.gAS.gBP.dul != null) {
                                p.this.gAS.gBP.dul.putBoolean("person_center_item_red_tip_show", aVar5.fvV);
                            }
                            if (aVar6 != null && p.this.gAS.gBQ != null && p.this.gAS.gBQ.dul != null) {
                                p.this.gAS.gBQ.dul.putBoolean("person_center_item_red_tip_show", aVar6.fvV);
                                p.this.gAS.gBQ.dul.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gEI instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gEI.C(5, aVar7.fvV);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gEI.C(6, aVar8.fvV);
                            }
                        }
                    }
                }
            }
        };
        this.gET.setTag(this.aCu);
        tbPageContext.registerListener(this.gET);
        this.gvs = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.gEJ.uj(lVar.yF());
                }
            }
        };
        this.gvs.setTag(this.aCu);
        tbPageContext.registerListener(this.gvs);
    }

    public void onDestory() {
        if (this.gEJ != null) {
            this.gEJ.onDestory();
        }
    }

    public com.baidu.tieba.view.f bsb() {
        return this.gEI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bM(boolean z) {
            if (z) {
                if (p.this.dLT == null) {
                    p.this.dLT = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gEO.FN() != null && !StringUtils.isNull(p.this.gEO.FN().getUserId())) {
                    p.this.dLT.ip(p.this.gEO.FN().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).Ca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsc() {
        anP();
        anQ();
        bsd();
        if (this.gEJ.anZ().getTop() + this.gEP <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gEK = aVar;
    }

    private void anP() {
        if (Build.VERSION.SDK_INT >= 11 && this.gEJ != null) {
            int top = this.gEJ.anZ().getTop();
            if (top >= this.gEH) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gEH) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gEH));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void anQ() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cHQ) {
                    this.cHQ = true;
                }
            } else if (this.cHQ) {
                this.cHQ = false;
            }
            a(alpha, !this.cHQ);
            this.gEI.c(alpha, this.cHQ ? false : true);
        }
    }

    private void bsd() {
        if (Build.VERSION.SDK_INT >= 11 && this.gEJ != null) {
            int i = this.gEH / 2;
            int i2 = this.gEH - i;
            int top = this.gEJ.anZ().getTop();
            if (this.gEM != null) {
                if (top < i) {
                    if (this.gEM.getAlpha() != 0.0f) {
                        this.gEM.setAlpha(0.0f);
                    }
                } else if (top < this.gEH && top >= i) {
                    if (i2 > 0) {
                        this.gEM.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gEH && this.gEM.getAlpha() != 1.0f) {
                    this.gEM.setAlpha(1.0f);
                }
            }
            if (this.gEN != null) {
                if (top >= i) {
                    if (this.gEN.getAlpha() != 0.0f) {
                        this.gEN.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gEN.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gEN.getAlpha() != 1.0f) {
                    this.gEN.setAlpha(1.0f);
                }
            }
        }
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gAr.getVisibility() != 0) {
            this.gAr.setVisibility(0);
        }
        this.gAr.setData(list);
        int H = v.H(list);
        if (H >= 5) {
            if (this.gEX) {
                mr(true);
                this.gEX = false;
            }
        } else if (H <= 1) {
            this.gAr.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gEL = iVar;
    }

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gAr != null) {
            this.gFa = str;
            this.gFd = aVar;
            int headerViewsCount = (this.gAr.getHeaderViewsCount() + i) - this.gAr.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gFb = this.gAr.getChildAt(headerViewsCount);
                if (this.gFb != null) {
                    this.gFc = this.gFb.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gFb.getLayoutParams().height = p.this.gFc - ((int) (p.this.gFc * f));
                            p.this.gFb.requestLayout();
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
                            p.this.gFb.setVisibility(8);
                            if (p.this.gFd != null) {
                                p.this.gFd.uf(p.this.gFa);
                            }
                        }
                    });
                    animation.setDuration(gEG);
                    this.gFb.startAnimation(animation);
                }
            }
        }
    }
}
