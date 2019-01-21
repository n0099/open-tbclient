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
    public static int gEH = 300;
    private BdUniqueId aCv;
    private NoNetworkView bPm;
    private PbListView bPn;
    private com.baidu.tbadk.i.a dLU;
    private ImageView dfe;
    private PluginErrorTipView drQ;
    private com.baidu.tieba.personPolymeric.b.d gAG;
    private com.baidu.tieba.personPolymeric.c.a gAT;
    public BdPersonListView gAs;
    private com.baidu.tieba.view.g gDX;
    private int gEI;
    private com.baidu.tieba.view.f gEJ;
    public n gEK;
    private com.baidu.tieba.model.a gEL;
    private com.baidu.tieba.view.i gEM;
    private TextView gEN;
    private LikeButtonWithHeadPortrait gEO;
    private com.baidu.tbadk.core.view.userLike.c gEP;
    private int gEQ;
    private TextView gER;
    private TextView gES;
    private com.baidu.tieba.personPolymeric.a.n gET;
    private CustomMessageListener gEU;
    private View gEW;
    private PersonCenterAttentionBarListView gEX;
    private boolean gEY;
    private k gFa;
    private String gFb;
    private View gFc;
    private int gFd;
    private i.a gFe;
    private boolean gvb;
    private CustomMessageListener gvt;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cHR = true;
    private int cJW = 0;
    private boolean gEV = false;
    private boolean gEZ = false;
    View.OnClickListener aTJ = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gAC = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gDX != null) {
                if (p.this.dfe == view) {
                    this.gAC.dul = 8;
                }
                p.this.gDX.a(view, this.gAC);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gEM != null) {
                p.this.gEM.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gEM != null) {
                    p.this.gEM.onScroll(absListView, i, i2, i3);
                }
                p.this.bsc();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bPn != null && p.this.gEL != null) {
                p.this.gAG.tx(p.this.cJW);
                if (p.this.cJW == 0) {
                    p.this.bPn.Fp();
                    p.this.gEL.g(false, false, false);
                } else if (p.this.cJW == 1) {
                    p.this.bPn.Fp();
                    p.this.gEL.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gFf = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bro();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oG() {
            p.this.gAG.aIa();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gAG.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gvb = false;
        this.mContext = tbPageContext;
        this.aCv = bdUniqueId;
        this.mIsHost = z;
        this.gvb = z2;
        this.gAG = eVar.brx();
        this.bPn = this.gAG.bPn;
        this.gEI = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds402);
        if (z) {
            this.gEJ = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gEJ = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bPm = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.drQ = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gAs = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gEJ.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gAs.setOnScrollListener(this.mOnScrollListener);
        this.gEQ = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.dfe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.dfe.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dfe.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.dfe.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gEN = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gEO = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gEP = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gEO);
        this.gEP.setFromType("2");
        this.gEP.h(this.mContext.getUniqueId());
        this.gEP.a(new a());
        this.gER = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gES = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.gvb) {
            this.dfe.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gAs.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gEK = new n(this.mContext, this.mIsHost);
        this.gEW = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gAs.addHeaderView(this.gEW);
        this.gAs.setExpandView(this.gEW);
        this.gAs.addHeaderView(this.gEK.anZ());
        this.gFa = new k(this.mContext);
        this.gAs.addHeaderView(this.gFa.anZ());
        if (!this.mIsHost) {
            this.gEN.setText(e.j.ta_homepage);
            this.gEX = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gAs.addHeaderView(this.gEX);
        } else {
            this.gEN.setText(e.j.my_homepage);
        }
        this.gAs.setPersonListRefreshListener(this.gFf);
        this.gET = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gAs, this.aCv);
        this.gET.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gEO.setAlpha(0.0f);
        this.gEJ.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gAT == null) {
            this.gEJ.c(1.0f, true);
            al.c(this.dfe, e.f.selector_topbar_return_black);
        } else {
            bsc();
        }
        al.h(this.gEN, e.d.cp_cont_i);
        this.gEO.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        if (this.gEJ != null) {
            this.gEJ.onChangeSkinType(i);
        }
        this.bPm.onChangeSkinType(this.mContext, i);
        this.drQ.onChangeSkinType(this.mContext, i);
        if (this.gEK != null) {
            this.gEK.onChangeSkinType(i);
        }
        if (this.gAs != null && (this.gAs.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gAs.getAdapter().notifyDataSetChanged();
        }
        this.bPn.ey(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gES, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gER, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gEX != null) {
            this.gEX.onChangeSkinType(i);
        }
        if (this.gFa != null) {
            this.gFa.onChangeSkinType(i);
        }
    }

    public void mr(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.dfe, e.f.selector_topbar_return_black);
            this.gEJ.c(1.0f, true);
            this.gEN.setAlpha(0.0f);
            this.gEO.setAlpha(1.0f);
            this.gAs.setSelectionFromTop(this.gAs.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.dfe, e.f.selector_topbar_return_white);
        this.gEJ.c(0.0f, false);
        this.gEN.setAlpha(1.0f);
        this.gEO.setAlpha(0.0f);
    }

    public void ud(String str) {
        if (this.gEK != null) {
            this.gEK.tS(str);
        }
    }

    public void ue(String str) {
        if (this.gEK != null) {
            this.gEK.tT(str);
        }
    }

    public void bro() {
        this.gEV = false;
        if (this.cJW == 0) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gEL.resetData();
                this.gEL.refreshData();
                this.gAG.oF();
                return;
            }
            this.gAG.aIa();
        } else if (this.cJW == 1) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gEL.g(true, true, true);
                this.gAG.oF();
                return;
            }
            this.gAG.aIa();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gDX = gVar;
        this.gEJ.setOnViewResponseListener(gVar);
        this.dfe.setOnClickListener(this.aTJ);
        this.gEK.setOnViewResponseListener(gVar);
        if (this.gAG != null) {
            this.gAG.a(this.gEW, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gET != null) {
            this.gET.Q(onClickListener);
        }
    }

    public void mj(boolean z) {
        this.gEY = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.dfe, e.f.selector_topbar_return_black);
        } else {
            al.c(this.dfe, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.dfe.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gER.setAlpha(1.0f - f);
            this.gES.setAlpha(f);
        }
    }

    public void as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dv(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        mr(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gAT = aVar;
            this.gEJ.e(this.gAT.getUserData());
            if (this.gEV) {
                dv(aVar.aNX());
                if (this.bPn != null) {
                    this.bPn.Fq();
                    return;
                }
                return;
            }
            this.gEJ.brf();
            this.gEK.e(aVar);
            if (aVar != null) {
                this.gEO.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.gEO.brW();
            } else {
                this.gAT.getUserData().setIsLike(this.gAT.getUserData().getHave_attention() == 1);
                this.gEP.a(this.gAT.getUserData());
            }
            if ((aVar.brP() == null || this.mIsHost) && v.I(aVar.brQ())) {
                this.gAs.removeHeaderView(this.gFa.anZ());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gFa.a(aVar.brP(), this.mIsHost, this.gAT.getUserData(), aVar.brQ());
            }
            if (!this.mIsHost) {
                if (aVar.brR() == null || aVar.brR().gBZ == null || aVar.brR().gBZ.size() <= 0) {
                    this.gAs.removeHeaderView(this.gEX);
                } else {
                    this.gEX.a(aVar.brR());
                }
            }
            if (v.I(aVar.aNX())) {
                dv(null);
                this.gAG.abA();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bxf().mU(this.mIsHost);
            dv(aVar.aNX());
            int size = aVar.aNX().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aNX().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gAG.abA();
                    return;
                }
            }
            if (z) {
                if (this.bPn != null) {
                    this.bPn.Fq();
                    return;
                }
                return;
            }
            this.gAG.c(true, aVar.aNX());
        }
    }

    public void aIa() {
        this.gAG.aIa();
    }

    private void w(TbPageContext tbPageContext) {
        this.gEU = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gXE;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gEK != null && p.this.gEK.gEf != null) {
                            p.this.gEK.gEf.oq(aVar.fvW);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.gAT != null) {
                            if (p.this.gAT.gBP != null && p.this.gAT.gBP.dum != null && aVar2 != null) {
                                p.this.gAT.gBP.dum.putBoolean("person_center_item_red_tip_show", aVar2.fvW);
                            }
                            if (aVar3 != null && p.this.gAT.gBO != null && p.this.gAT.gBO.dum != null) {
                                p.this.gAT.gBO.dum.putBoolean("person_center_item_red_tip_show", aVar3.fvW);
                            }
                            if (aVar4 != null && p.this.gAT.gBM != null && p.this.gAT.gBM.dum != null) {
                                p.this.gAT.gBM.dum.putBoolean("person_center_item_red_tip_show", aVar4.fvW);
                            }
                            if (aVar5 != null && p.this.gAT.gBQ != null && p.this.gAT.gBQ.dum != null) {
                                p.this.gAT.gBQ.dum.putBoolean("person_center_item_red_tip_show", aVar5.fvW);
                            }
                            if (aVar6 != null && p.this.gAT.gBR != null && p.this.gAT.gBR.dum != null) {
                                p.this.gAT.gBR.dum.putBoolean("person_center_item_red_tip_show", aVar6.fvW);
                                p.this.gAT.gBR.dum.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gEJ instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gEJ.C(5, aVar7.fvW);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gEJ.C(6, aVar8.fvW);
                            }
                        }
                    }
                }
            }
        };
        this.gEU.setTag(this.aCv);
        tbPageContext.registerListener(this.gEU);
        this.gvt = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.gEK.uj(lVar.yF());
                }
            }
        };
        this.gvt.setTag(this.aCv);
        tbPageContext.registerListener(this.gvt);
    }

    public void onDestory() {
        if (this.gEK != null) {
            this.gEK.onDestory();
        }
    }

    public com.baidu.tieba.view.f bsb() {
        return this.gEJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bM(boolean z) {
            if (z) {
                if (p.this.dLU == null) {
                    p.this.dLU = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gEP.FN() != null && !StringUtils.isNull(p.this.gEP.FN().getUserId())) {
                    p.this.dLU.ip(p.this.gEP.FN().getUserId());
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
        if (this.gEK.anZ().getTop() + this.gEQ <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gEL = aVar;
    }

    private void anP() {
        if (Build.VERSION.SDK_INT >= 11 && this.gEK != null) {
            int top = this.gEK.anZ().getTop();
            if (top >= this.gEI) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gEI) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gEI));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void anQ() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cHR) {
                    this.cHR = true;
                }
            } else if (this.cHR) {
                this.cHR = false;
            }
            a(alpha, !this.cHR);
            this.gEJ.c(alpha, this.cHR ? false : true);
        }
    }

    private void bsd() {
        if (Build.VERSION.SDK_INT >= 11 && this.gEK != null) {
            int i = this.gEI / 2;
            int i2 = this.gEI - i;
            int top = this.gEK.anZ().getTop();
            if (this.gEN != null) {
                if (top < i) {
                    if (this.gEN.getAlpha() != 0.0f) {
                        this.gEN.setAlpha(0.0f);
                    }
                } else if (top < this.gEI && top >= i) {
                    if (i2 > 0) {
                        this.gEN.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gEI && this.gEN.getAlpha() != 1.0f) {
                    this.gEN.setAlpha(1.0f);
                }
            }
            if (this.gEO != null) {
                if (top >= i) {
                    if (this.gEO.getAlpha() != 0.0f) {
                        this.gEO.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gEO.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gEO.getAlpha() != 1.0f) {
                    this.gEO.setAlpha(1.0f);
                }
            }
        }
    }

    public void dv(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gAs.getVisibility() != 0) {
            this.gAs.setVisibility(0);
        }
        this.gAs.setData(list);
        int H = v.H(list);
        if (H >= 5) {
            if (this.gEY) {
                mr(true);
                this.gEY = false;
            }
        } else if (H <= 1) {
            this.gAs.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gEM = iVar;
    }

    public NavigationBar act() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gAs != null) {
            this.gFb = str;
            this.gFe = aVar;
            int headerViewsCount = (this.gAs.getHeaderViewsCount() + i) - this.gAs.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gFc = this.gAs.getChildAt(headerViewsCount);
                if (this.gFc != null) {
                    this.gFd = this.gFc.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gFc.getLayoutParams().height = p.this.gFd - ((int) (p.this.gFd * f));
                            p.this.gFc.requestLayout();
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
                            p.this.gFc.setVisibility(8);
                            if (p.this.gFe != null) {
                                p.this.gFe.uf(p.this.gFb);
                            }
                        }
                    });
                    animation.setDuration(gEH);
                    this.gFc.startAnimation(animation);
                }
            }
        }
    }
}
