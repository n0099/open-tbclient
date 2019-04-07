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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p {
    public static int hUs = 300;
    private BdUniqueId Zr;
    private NoNetworkView dbq;
    private PbListView dbr;
    private PluginErrorTipView eCf;
    private com.baidu.tbadk.k.a eZe;
    private ImageView eoL;
    private boolean hKY;
    private CustomMessageListener hLq;
    private com.baidu.tieba.personPolymeric.c.a hQE;
    public BdPersonListView hQd;
    private com.baidu.tieba.personPolymeric.b.d hQr;
    private com.baidu.tieba.view.g hTI;
    private com.baidu.tbadk.core.view.userLike.c hUA;
    private int hUB;
    private TextView hUC;
    private TextView hUD;
    private com.baidu.tieba.personPolymeric.a.n hUE;
    private CustomMessageListener hUF;
    private View hUH;
    private PersonCenterAttentionBarListView hUI;
    private boolean hUJ;
    private k hUL;
    private String hUM;
    private View hUN;
    private int hUO;
    private i.a hUP;
    private int hUt;
    private com.baidu.tieba.view.f hUu;
    public n hUv;
    private com.baidu.tieba.model.a hUw;
    private com.baidu.tieba.view.i hUx;
    private TextView hUy;
    private LikeButtonWithHeadPortrait hUz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean dUL = true;
    private int dWT = 0;
    private boolean hUG = false;
    private boolean hUK = false;
    View.OnClickListener ccC = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b hQn = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.hTI != null) {
                if (p.this.eoL == view) {
                    this.hQn.eHk = 8;
                }
                p.this.hTI.a(view, this.hQn);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.hUx != null) {
                p.this.hUx.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.hUx != null) {
                    p.this.hUx.onScroll(absListView, i, i2, i3);
                }
                p.this.bSw();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dbr != null && p.this.hUw != null) {
                p.this.hQr.xc(p.this.dWT);
                if (p.this.dWT == 0) {
                    p.this.dbr.aez();
                    p.this.hUw.g(false, false, false);
                } else if (p.this.dWT == 1) {
                    p.this.dbr.aez();
                    p.this.hUw.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a hUQ = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bRH();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oL() {
            p.this.hQr.bin();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.hQr.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.hKY = false;
        this.mContext = tbPageContext;
        this.Zr = bdUniqueId;
        this.mIsHost = z;
        this.hKY = z2;
        this.hQr = eVar.bRR();
        this.dbr = this.hQr.dbr;
        this.hUt = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.hUu = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.hUu = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0277d.cp_bg_line_c);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.eCf = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.hQd = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.hUu.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.hQd.setOnScrollListener(this.mOnScrollListener);
        this.hUB = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eoL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.eoL.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoL.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.eoL.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.hUy = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.hUz = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.hUA = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.hUz);
        this.hUA.setFromType("2");
        this.hUA.i(this.mContext.getUniqueId());
        this.hUA.a(new a());
        this.hUC = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.hUD = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.hKY) {
            this.eoL.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.hQd.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hUv = new n(this.mContext, this.mIsHost);
        this.hUH = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.hQd.addHeaderView(this.hUH);
        this.hQd.setExpandView(this.hUH);
        this.hQd.addHeaderView(this.hUv.aOH());
        this.hUL = new k(this.mContext);
        this.hQd.addHeaderView(this.hUL.aOH());
        if (!this.mIsHost) {
            this.hUy.setText(d.j.ta_homepage);
            this.hUI = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.hQd.addHeaderView(this.hUI);
        } else {
            this.hUy.setText(d.j.my_homepage);
        }
        this.hQd.setPersonListRefreshListener(this.hUQ);
        this.hUE = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.hQd, this.Zr);
        this.hUE.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.hUz.setAlpha(0.0f);
        this.hUu.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.hQE == null) {
            this.hUu.c(1.0f, true);
            al.c(this.eoL, d.f.selector_topbar_return_black);
        } else {
            bSw();
        }
        al.j(this.hUy, d.C0277d.cp_btn_a);
        this.hUz.onChangeSkinType(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        if (this.hUu != null) {
            this.hUu.onChangeSkinType(i);
        }
        this.dbq.onChangeSkinType(this.mContext, i);
        this.eCf.onChangeSkinType(this.mContext, i);
        if (this.hUv != null) {
            this.hUv.onChangeSkinType(i);
        }
        if (this.hQd != null && (this.hQd.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.hQd.getAdapter().notifyDataSetChanged();
        }
        this.dbr.ib(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.mIsHost) {
            al.c(this.hUD, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            al.c(this.hUC, d.C0277d.cp_btn_a, d.C0277d.cp_btn_a);
        }
        if (this.hUI != null) {
            this.hUI.onChangeSkinType(i);
        }
        if (this.hUL != null) {
            this.hUL.onChangeSkinType(i);
        }
    }

    public void oO(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eoL, d.f.selector_topbar_return_black);
            this.hUu.c(1.0f, true);
            this.hUy.setAlpha(0.0f);
            this.hUz.setAlpha(1.0f);
            this.hQd.setSelectionFromTop(this.hQd.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eoL, d.f.selector_topbar_return_white);
        this.hUu.c(0.0f, false);
        this.hUy.setAlpha(1.0f);
        this.hUz.setAlpha(0.0f);
    }

    public void AH(String str) {
        if (this.hUv != null) {
            this.hUv.Aw(str);
        }
    }

    public void AI(String str) {
        if (this.hUv != null) {
            this.hUv.Ax(str);
        }
    }

    public void bRH() {
        this.hUG = false;
        if (this.dWT == 0) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUw.resetData();
                this.hUw.refreshData();
                this.hQr.oK();
                return;
            }
            this.hQr.bin();
        } else if (this.dWT == 1) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUw.g(true, true, true);
                this.hQr.oK();
                return;
            }
            this.hQr.bin();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTI = gVar;
        this.hUu.setOnViewResponseListener(gVar);
        this.eoL.setOnClickListener(this.ccC);
        this.hUv.setOnViewResponseListener(gVar);
        if (this.hQr != null) {
            this.hQr.a(this.hUH, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hUE != null) {
            this.hUE.Q(onClickListener);
        }
    }

    public void oG(boolean z) {
        this.hUJ = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.eoL, d.f.selector_topbar_return_black);
        } else {
            al.c(this.eoL, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eoL.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.hUC.setAlpha(1.0f - f);
            this.hUD.setAlpha(f);
        }
    }

    public void aw(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dG(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        oO(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.hQE = aVar;
            this.hUu.setUserData(this.hQE.getUserData());
            if (this.hUG) {
                dG(aVar.boy());
                if (this.dbr != null) {
                    this.dbr.aeA();
                    return;
                }
                return;
            }
            this.hUu.bRy();
            this.hUv.e(aVar);
            if (aVar != null) {
                this.hUz.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.hUz.bSq();
            } else {
                this.hQE.getUserData().setIsLike(this.hQE.getUserData().getHave_attention() == 1);
                this.hUA.a(this.hQE.getUserData());
            }
            if ((aVar.bSj() == null || this.mIsHost) && v.T(aVar.bSk())) {
                this.hQd.removeHeaderView(this.hUL.aOH());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.hUL.a(aVar.bSj(), this.mIsHost, this.hQE.getUserData(), aVar.bSk());
            }
            if (!this.mIsHost) {
                if (aVar.bSl() == null || aVar.bSl().hRK == null || aVar.bSl().hRK.size() <= 0) {
                    this.hQd.removeHeaderView(this.hUI);
                } else {
                    this.hUI.a(aVar.bSl());
                }
            }
            if (v.T(aVar.boy())) {
                dG(null);
                this.hQr.aCt();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bXS().pt(this.mIsHost);
            dG(aVar.boy());
            int size = aVar.boy().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.boy().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.hQr.aCt();
                    return;
                }
            }
            if (z) {
                if (this.dbr != null) {
                    this.dbr.aeA();
                    return;
                }
                return;
            }
            this.hQr.c(true, aVar.boy());
        }
    }

    public void bin() {
        this.hQr.bin();
    }

    private void v(TbPageContext tbPageContext) {
        this.hUF = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).ioX;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.hUv != null && p.this.hUv.hTQ != null) {
                            p.this.hUv.hTQ.qQ(aVar.gLM);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.hQE != null) {
                            if (p.this.hQE.hRA != null && p.this.hQE.hRA.eHl != null && aVar2 != null) {
                                p.this.hQE.hRA.eHl.putBoolean("person_center_item_red_tip_show", aVar2.gLM);
                            }
                            if (aVar3 != null && p.this.hQE.hRz != null && p.this.hQE.hRz.eHl != null) {
                                p.this.hQE.hRz.eHl.putBoolean("person_center_item_red_tip_show", aVar3.gLM);
                            }
                            if (aVar4 != null && p.this.hQE.hRx != null && p.this.hQE.hRx.eHl != null) {
                                p.this.hQE.hRx.eHl.putBoolean("person_center_item_red_tip_show", aVar4.gLM);
                            }
                            if (aVar5 != null && p.this.hQE.hRB != null && p.this.hQE.hRB.eHl != null) {
                                p.this.hQE.hRB.eHl.putBoolean("person_center_item_red_tip_show", aVar5.gLM);
                            }
                            if (aVar6 != null && p.this.hQE.hRC != null && p.this.hQE.hRC.eHl != null) {
                                p.this.hQE.hRC.eHl.putBoolean("person_center_item_red_tip_show", aVar6.gLM);
                                p.this.hQE.hRC.eHl.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.hUu instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.hUu.I(5, aVar7.gLM);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.hUu.I(6, aVar8.gLM);
                            }
                        }
                    }
                }
            }
        };
        this.hUF.setTag(this.Zr);
        tbPageContext.registerListener(this.hUF);
        this.hLq = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.hUv.AM(lVar.Xk());
                }
            }
        };
        this.hLq.setTag(this.Zr);
        tbPageContext.registerListener(this.hLq);
    }

    public void onDestory() {
        if (this.hUv != null) {
            this.hUv.onDestory();
        }
    }

    public com.baidu.tieba.view.f bSv() {
        return this.hUu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void dV(boolean z) {
            if (z) {
                if (p.this.eZe == null) {
                    p.this.eZe = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.hUA.afe() != null && !StringUtils.isNull(p.this.hUA.afe().getUserId())) {
                    p.this.eZe.pc(p.this.hUA.afe().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.j.unlike_success)).abe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSw() {
        aOu();
        aOv();
        bSx();
        if (this.hUv.aOH().getTop() + this.hUB <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.hUw = aVar;
    }

    private void aOu() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUv != null) {
            int top = this.hUv.aOH().getTop();
            if (top >= this.hUt) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.hUt) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.hUt));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aOv() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.dUL) {
                    this.dUL = true;
                }
            } else if (this.dUL) {
                this.dUL = false;
            }
            a(alpha, !this.dUL);
            this.hUu.c(alpha, this.dUL ? false : true);
        }
    }

    private void bSx() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUv != null) {
            int i = this.hUt / 2;
            int i2 = this.hUt - i;
            int top = this.hUv.aOH().getTop();
            if (this.hUy != null) {
                if (top < i) {
                    if (this.hUy.getAlpha() != 0.0f) {
                        this.hUy.setAlpha(0.0f);
                    }
                } else if (top < this.hUt && top >= i) {
                    if (i2 > 0) {
                        this.hUy.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.hUt && this.hUy.getAlpha() != 1.0f) {
                    this.hUy.setAlpha(1.0f);
                }
            }
            if (this.hUz != null) {
                if (top >= i) {
                    if (this.hUz.getAlpha() != 0.0f) {
                        this.hUz.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.hUz.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.hUz.getAlpha() != 1.0f) {
                    this.hUz.setAlpha(1.0f);
                }
            }
        }
    }

    public void dG(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.T(list)) {
            list = new ArrayList<>();
        }
        if (this.hQd.getVisibility() != 0) {
            this.hQd.setVisibility(0);
        }
        this.hQd.setData(list);
        int S = v.S(list);
        if (S >= 5) {
            if (this.hUJ) {
                oO(true);
                this.hUJ = false;
            }
        } else if (S <= 1) {
            this.hQd.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.hUx = iVar;
    }

    public NavigationBar aDm() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.hQd != null) {
            this.hUM = str;
            this.hUP = aVar;
            int headerViewsCount = (this.hQd.getHeaderViewsCount() + i) - this.hQd.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.hUN = this.hQd.getChildAt(headerViewsCount);
                if (this.hUN != null) {
                    this.hUO = this.hUN.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.hUN.getLayoutParams().height = p.this.hUO - ((int) (p.this.hUO * f));
                            p.this.hUN.requestLayout();
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
                            p.this.hUN.setVisibility(8);
                            if (p.this.hUP != null) {
                                p.this.hUP.removeThread(p.this.hUM);
                            }
                        }
                    });
                    animation.setDuration(hUs);
                    this.hUN.startAnimation(animation);
                }
            }
        }
    }
}
