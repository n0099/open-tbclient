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
    public static int hUG = 300;
    private BdUniqueId Zr;
    private NoNetworkView dbm;
    private PbListView dbn;
    private PluginErrorTipView eCu;
    private com.baidu.tbadk.k.a eZs;
    private ImageView eoZ;
    private CustomMessageListener hLE;
    private boolean hLm;
    private com.baidu.tieba.personPolymeric.b.d hQF;
    private com.baidu.tieba.personPolymeric.c.a hQS;
    public BdPersonListView hQr;
    private com.baidu.tieba.view.g hTW;
    private int hUH;
    private com.baidu.tieba.view.f hUI;
    public n hUJ;
    private com.baidu.tieba.model.a hUK;
    private com.baidu.tieba.view.i hUL;
    private TextView hUM;
    private LikeButtonWithHeadPortrait hUN;
    private com.baidu.tbadk.core.view.userLike.c hUO;
    private int hUP;
    private TextView hUQ;
    private TextView hUR;
    private com.baidu.tieba.personPolymeric.a.n hUS;
    private CustomMessageListener hUT;
    private View hUV;
    private PersonCenterAttentionBarListView hUW;
    private boolean hUX;
    private k hUZ;
    private String hVa;
    private View hVb;
    private int hVc;
    private i.a hVd;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean dVp = true;
    private int dXv = 0;
    private boolean hUU = false;
    private boolean hUY = false;
    View.OnClickListener ccA = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b hQB = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.hTW != null) {
                if (p.this.eoZ == view) {
                    this.hQB.eHy = 8;
                }
                p.this.hTW.a(view, this.hQB);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.hUL != null) {
                p.this.hUL.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.hUL != null) {
                    p.this.hUL.onScroll(absListView, i, i2, i3);
                }
                p.this.bSA();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dbn != null && p.this.hUK != null) {
                p.this.hQF.xg(p.this.dXv);
                if (p.this.dXv == 0) {
                    p.this.dbn.aeC();
                    p.this.hUK.g(false, false, false);
                } else if (p.this.dXv == 1) {
                    p.this.dbn.aeC();
                    p.this.hUK.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a hVe = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bRL();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oL() {
            p.this.hQF.bip();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.hQF.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.hLm = false;
        this.mContext = tbPageContext;
        this.Zr = bdUniqueId;
        this.mIsHost = z;
        this.hLm = z2;
        this.hQF = eVar.bRV();
        this.dbn = this.hQF.dbn;
        this.hUH = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.hUI = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.hUI = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0277d.cp_bg_line_c);
        this.dbm = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.eCu = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.hQr = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.hUI.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.hQr.setOnScrollListener(this.mOnScrollListener);
        this.hUP = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eoZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.eoZ.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoZ.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.eoZ.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.hUM = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.hUN = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.hUO = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.hUN);
        this.hUO.setFromType("2");
        this.hUO.i(this.mContext.getUniqueId());
        this.hUO.a(new a());
        this.hUQ = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.hUR = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.hLm) {
            this.eoZ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.hQr.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hUJ = new n(this.mContext, this.mIsHost);
        this.hUV = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.hQr.addHeaderView(this.hUV);
        this.hQr.setExpandView(this.hUV);
        this.hQr.addHeaderView(this.hUJ.aOM());
        this.hUZ = new k(this.mContext);
        this.hQr.addHeaderView(this.hUZ.aOM());
        if (!this.mIsHost) {
            this.hUM.setText(d.j.ta_homepage);
            this.hUW = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.hQr.addHeaderView(this.hUW);
        } else {
            this.hUM.setText(d.j.my_homepage);
        }
        this.hQr.setPersonListRefreshListener(this.hVe);
        this.hUS = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.hQr, this.Zr);
        this.hUS.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.hUN.setAlpha(0.0f);
        this.hUI.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.hQS == null) {
            this.hUI.c(1.0f, true);
            al.c(this.eoZ, d.f.selector_topbar_return_black);
        } else {
            bSA();
        }
        al.j(this.hUM, d.C0277d.cp_btn_a);
        this.hUN.onChangeSkinType(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        if (this.hUI != null) {
            this.hUI.onChangeSkinType(i);
        }
        this.dbm.onChangeSkinType(this.mContext, i);
        this.eCu.onChangeSkinType(this.mContext, i);
        if (this.hUJ != null) {
            this.hUJ.onChangeSkinType(i);
        }
        if (this.hQr != null && (this.hQr.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.hQr.getAdapter().notifyDataSetChanged();
        }
        this.dbn.ic(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.mIsHost) {
            al.c(this.hUR, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            al.c(this.hUQ, d.C0277d.cp_btn_a, d.C0277d.cp_btn_a);
        }
        if (this.hUW != null) {
            this.hUW.onChangeSkinType(i);
        }
        if (this.hUZ != null) {
            this.hUZ.onChangeSkinType(i);
        }
    }

    public void oO(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eoZ, d.f.selector_topbar_return_black);
            this.hUI.c(1.0f, true);
            this.hUM.setAlpha(0.0f);
            this.hUN.setAlpha(1.0f);
            this.hQr.setSelectionFromTop(this.hQr.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eoZ, d.f.selector_topbar_return_white);
        this.hUI.c(0.0f, false);
        this.hUM.setAlpha(1.0f);
        this.hUN.setAlpha(0.0f);
    }

    public void AI(String str) {
        if (this.hUJ != null) {
            this.hUJ.Ax(str);
        }
    }

    public void AJ(String str) {
        if (this.hUJ != null) {
            this.hUJ.Ay(str);
        }
    }

    public void bRL() {
        this.hUU = false;
        if (this.dXv == 0) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUK.resetData();
                this.hUK.refreshData();
                this.hQF.oK();
                return;
            }
            this.hQF.bip();
        } else if (this.dXv == 1) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUK.g(true, true, true);
                this.hQF.oK();
                return;
            }
            this.hQF.bip();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTW = gVar;
        this.hUI.setOnViewResponseListener(gVar);
        this.eoZ.setOnClickListener(this.ccA);
        this.hUJ.setOnViewResponseListener(gVar);
        if (this.hQF != null) {
            this.hQF.a(this.hUV, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hUS != null) {
            this.hUS.Q(onClickListener);
        }
    }

    public void oG(boolean z) {
        this.hUX = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.eoZ, d.f.selector_topbar_return_black);
        } else {
            al.c(this.eoZ, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eoZ.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.hUQ.setAlpha(1.0f - f);
            this.hUR.setAlpha(f);
        }
    }

    public void aw(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dJ(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        oO(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.hQS = aVar;
            this.hUI.setUserData(this.hQS.getUserData());
            if (this.hUU) {
                dJ(aVar.boB());
                if (this.dbn != null) {
                    this.dbn.aeD();
                    return;
                }
                return;
            }
            this.hUI.bRC();
            this.hUJ.e(aVar);
            if (aVar != null) {
                this.hUN.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.hUN.bSu();
            } else {
                this.hQS.getUserData().setIsLike(this.hQS.getUserData().getHave_attention() == 1);
                this.hUO.a(this.hQS.getUserData());
            }
            if ((aVar.bSn() == null || this.mIsHost) && v.T(aVar.bSo())) {
                this.hQr.removeHeaderView(this.hUZ.aOM());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.hUZ.a(aVar.bSn(), this.mIsHost, this.hQS.getUserData(), aVar.bSo());
            }
            if (!this.mIsHost) {
                if (aVar.bSp() == null || aVar.bSp().hRY == null || aVar.bSp().hRY.size() <= 0) {
                    this.hQr.removeHeaderView(this.hUW);
                } else {
                    this.hUW.a(aVar.bSp());
                }
            }
            if (v.T(aVar.boB())) {
                dJ(null);
                this.hQF.aCw();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bXW().pt(this.mIsHost);
            dJ(aVar.boB());
            int size = aVar.boB().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.boB().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.hQF.aCw();
                    return;
                }
            }
            if (z) {
                if (this.dbn != null) {
                    this.dbn.aeD();
                    return;
                }
                return;
            }
            this.hQF.c(true, aVar.boB());
        }
    }

    public void bip() {
        this.hQF.bip();
    }

    private void w(TbPageContext tbPageContext) {
        this.hUT = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).ipn;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.hUJ != null && p.this.hUJ.hUe != null) {
                            p.this.hUJ.hUe.qQ(aVar.gLZ);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.hQS != null) {
                            if (p.this.hQS.hRO != null && p.this.hQS.hRO.eHz != null && aVar2 != null) {
                                p.this.hQS.hRO.eHz.putBoolean("person_center_item_red_tip_show", aVar2.gLZ);
                            }
                            if (aVar3 != null && p.this.hQS.hRN != null && p.this.hQS.hRN.eHz != null) {
                                p.this.hQS.hRN.eHz.putBoolean("person_center_item_red_tip_show", aVar3.gLZ);
                            }
                            if (aVar4 != null && p.this.hQS.hRL != null && p.this.hQS.hRL.eHz != null) {
                                p.this.hQS.hRL.eHz.putBoolean("person_center_item_red_tip_show", aVar4.gLZ);
                            }
                            if (aVar5 != null && p.this.hQS.hRP != null && p.this.hQS.hRP.eHz != null) {
                                p.this.hQS.hRP.eHz.putBoolean("person_center_item_red_tip_show", aVar5.gLZ);
                            }
                            if (aVar6 != null && p.this.hQS.hRQ != null && p.this.hQS.hRQ.eHz != null) {
                                p.this.hQS.hRQ.eHz.putBoolean("person_center_item_red_tip_show", aVar6.gLZ);
                                p.this.hQS.hRQ.eHz.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.hUI instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.hUI.I(5, aVar7.gLZ);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.hUI.I(6, aVar8.gLZ);
                            }
                        }
                    }
                }
            }
        };
        this.hUT.setTag(this.Zr);
        tbPageContext.registerListener(this.hUT);
        this.hLE = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.hUJ.AN(lVar.Xn());
                }
            }
        };
        this.hLE.setTag(this.Zr);
        tbPageContext.registerListener(this.hLE);
    }

    public void onDestory() {
        if (this.hUJ != null) {
            this.hUJ.onDestory();
        }
    }

    public com.baidu.tieba.view.f bSz() {
        return this.hUI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void dV(boolean z) {
            if (z) {
                if (p.this.eZs == null) {
                    p.this.eZs = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.hUO.afh() != null && !StringUtils.isNull(p.this.hUO.afh().getUserId())) {
                    p.this.eZs.pb(p.this.hUO.afh().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.j.unlike_success)).abh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSA() {
        aOC();
        aOD();
        bSB();
        if (this.hUJ.aOM().getTop() + this.hUP <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.hUK = aVar;
    }

    private void aOC() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUJ != null) {
            int top = this.hUJ.aOM().getTop();
            if (top >= this.hUH) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.hUH) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.hUH));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aOD() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.dVp) {
                    this.dVp = true;
                }
            } else if (this.dVp) {
                this.dVp = false;
            }
            a(alpha, !this.dVp);
            this.hUI.c(alpha, this.dVp ? false : true);
        }
    }

    private void bSB() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUJ != null) {
            int i = this.hUH / 2;
            int i2 = this.hUH - i;
            int top = this.hUJ.aOM().getTop();
            if (this.hUM != null) {
                if (top < i) {
                    if (this.hUM.getAlpha() != 0.0f) {
                        this.hUM.setAlpha(0.0f);
                    }
                } else if (top < this.hUH && top >= i) {
                    if (i2 > 0) {
                        this.hUM.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.hUH && this.hUM.getAlpha() != 1.0f) {
                    this.hUM.setAlpha(1.0f);
                }
            }
            if (this.hUN != null) {
                if (top >= i) {
                    if (this.hUN.getAlpha() != 0.0f) {
                        this.hUN.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.hUN.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.hUN.getAlpha() != 1.0f) {
                    this.hUN.setAlpha(1.0f);
                }
            }
        }
    }

    public void dJ(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.T(list)) {
            list = new ArrayList<>();
        }
        if (this.hQr.getVisibility() != 0) {
            this.hQr.setVisibility(0);
        }
        this.hQr.setData(list);
        int S = v.S(list);
        if (S >= 5) {
            if (this.hUX) {
                oO(true);
                this.hUX = false;
            }
        } else if (S <= 1) {
            this.hQr.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.hUL = iVar;
    }

    public NavigationBar aDp() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.hQr != null) {
            this.hVa = str;
            this.hVd = aVar;
            int headerViewsCount = (this.hQr.getHeaderViewsCount() + i) - this.hQr.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.hVb = this.hQr.getChildAt(headerViewsCount);
                if (this.hVb != null) {
                    this.hVc = this.hVb.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.hVb.getLayoutParams().height = p.this.hVc - ((int) (p.this.hVc * f));
                            p.this.hVb.requestLayout();
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
                            p.this.hVb.setVisibility(8);
                            if (p.this.hVd != null) {
                                p.this.hVd.removeThread(p.this.hVa);
                            }
                        }
                    });
                    animation.setDuration(hUG);
                    this.hVb.startAnimation(animation);
                }
            }
        }
    }
}
