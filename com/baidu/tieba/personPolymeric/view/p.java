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
    public static int gDC = 300;
    private BdUniqueId aBS;
    private NoNetworkView bOA;
    private PbListView bOB;
    private com.baidu.tbadk.i.a dLk;
    private ImageView deq;
    private PluginErrorTipView drg;
    private com.baidu.tieba.view.g gCS;
    private int gDD;
    private com.baidu.tieba.view.f gDE;
    public n gDF;
    private com.baidu.tieba.model.a gDG;
    private com.baidu.tieba.view.i gDH;
    private TextView gDI;
    private LikeButtonWithHeadPortrait gDJ;
    private com.baidu.tbadk.core.view.userLike.c gDK;
    private int gDL;
    private TextView gDM;
    private TextView gDN;
    private com.baidu.tieba.personPolymeric.a.n gDO;
    private CustomMessageListener gDP;
    private View gDR;
    private PersonCenterAttentionBarListView gDS;
    private boolean gDT;
    private k gDV;
    private String gDW;
    private View gDX;
    private int gDY;
    private i.a gDZ;
    private boolean gtW;
    private CustomMessageListener guo;
    private com.baidu.tieba.personPolymeric.b.d gzB;
    private com.baidu.tieba.personPolymeric.c.a gzO;
    public BdPersonListView gzn;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean cHf = true;
    private int cJk = 0;
    private boolean gDQ = false;
    private boolean gDU = false;
    View.OnClickListener aTa = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b gzx = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gCS != null) {
                if (p.this.deq == view) {
                    this.gzx.dtB = 8;
                }
                p.this.gCS.a(view, this.gzx);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gDH != null) {
                p.this.gDH.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gDH != null) {
                    p.this.gDH.onScroll(absListView, i, i2, i3);
                }
                p.this.brt();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bOB != null && p.this.gDG != null) {
                p.this.gzB.tt(p.this.cJk);
                if (p.this.cJk == 0) {
                    p.this.bOB.Fc();
                    p.this.gDG.g(false, false, false);
                } else if (p.this.cJk == 1) {
                    p.this.bOB.Fc();
                    p.this.gDG.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gEa = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bqF();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oC() {
            p.this.gzB.aHD();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.gzB.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gtW = false;
        this.mContext = tbPageContext;
        this.aBS = bdUniqueId;
        this.mIsHost = z;
        this.gtW = z2;
        this.gzB = eVar.bqO();
        this.bOB = this.gzB.bOB;
        this.gDD = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0210e.tbds402);
        if (z) {
            this.gDE = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gDE = new com.baidu.tieba.personPolymeric.a();
    }

    public void initView(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bOA = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.drg = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.gzn = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gDE.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.gzn.setOnScrollListener(this.mOnScrollListener);
        this.gDL = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.deq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.deq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.deq.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds14);
            this.deq.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gDI = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.gDJ = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gDK = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gDJ);
        this.gDK.setFromType("2");
        this.gDK.h(this.mContext.getUniqueId());
        this.gDK.a(new a());
        this.gDM = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.gDN = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.gtW) {
            this.deq.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.gzn.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gDF = new n(this.mContext, this.mIsHost);
        this.gDR = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.gzn.addHeaderView(this.gDR);
        this.gzn.setExpandView(this.gDR);
        this.gzn.addHeaderView(this.gDF.anC());
        this.gDV = new k(this.mContext);
        this.gzn.addHeaderView(this.gDV.anC());
        if (!this.mIsHost) {
            this.gDI.setText(e.j.ta_homepage);
            this.gDS = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.gzn.addHeaderView(this.gDS);
        } else {
            this.gDI.setText(e.j.my_homepage);
        }
        this.gzn.setPersonListRefreshListener(this.gEa);
        this.gDO = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.gzn, this.aBS);
        this.gDO.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gDJ.setAlpha(0.0f);
        this.gDE.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.gzO == null) {
            this.gDE.c(1.0f, true);
            al.c(this.deq, e.f.selector_topbar_return_black);
        } else {
            brt();
        }
        al.h(this.gDI, e.d.cp_cont_i);
        this.gDJ.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        if (this.gDE != null) {
            this.gDE.onChangeSkinType(i);
        }
        this.bOA.onChangeSkinType(this.mContext, i);
        this.drg.onChangeSkinType(this.mContext, i);
        if (this.gDF != null) {
            this.gDF.onChangeSkinType(i);
        }
        if (this.gzn != null && (this.gzn.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.gzn.getAdapter().notifyDataSetChanged();
        }
        this.bOB.ey(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.gDN, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.gDM, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gDS != null) {
            this.gDS.onChangeSkinType(i);
        }
        if (this.gDV != null) {
            this.gDV.onChangeSkinType(i);
        }
    }

    public void mr(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.deq, e.f.selector_topbar_return_black);
            this.gDE.c(1.0f, true);
            this.gDI.setAlpha(0.0f);
            this.gDJ.setAlpha(1.0f);
            this.gzn.setSelectionFromTop(this.gzn.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.deq, e.f.selector_topbar_return_white);
        this.gDE.c(0.0f, false);
        this.gDI.setAlpha(1.0f);
        this.gDJ.setAlpha(0.0f);
    }

    public void tN(String str) {
        if (this.gDF != null) {
            this.gDF.tC(str);
        }
    }

    public void tO(String str) {
        if (this.gDF != null) {
            this.gDF.tD(str);
        }
    }

    public void bqF() {
        this.gDQ = false;
        if (this.cJk == 0) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gDG.resetData();
                this.gDG.refreshData();
                this.gzB.oB();
                return;
            }
            this.gzB.aHD();
        } else if (this.cJk == 1) {
            if (com.baidu.adp.lib.util.j.kV()) {
                this.gDG.g(true, true, true);
                this.gzB.oB();
                return;
            }
            this.gzB.aHD();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gCS = gVar;
        this.gDE.setOnViewResponseListener(gVar);
        this.deq.setOnClickListener(this.aTa);
        this.gDF.setOnViewResponseListener(gVar);
        if (this.gzB != null) {
            this.gzB.a(this.gDR, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.gDO != null) {
            this.gDO.Q(onClickListener);
        }
    }

    public void mj(boolean z) {
        this.gDT = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.deq, e.f.selector_topbar_return_black);
        } else {
            al.c(this.deq, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.deq.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gDM.setAlpha(1.0f - f);
            this.gDN.setAlpha(f);
        }
    }

    public void as(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        du(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        mr(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.gzO = aVar;
            this.gDE.e(this.gzO.getUserData());
            if (this.gDQ) {
                du(aVar.aNx());
                if (this.bOB != null) {
                    this.bOB.Fd();
                    return;
                }
                return;
            }
            this.gDE.bqw();
            this.gDF.e(aVar);
            if (aVar != null) {
                this.gDJ.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.gDJ.brn();
            } else {
                this.gzO.getUserData().setIsLike(this.gzO.getUserData().getHave_attention() == 1);
                this.gDK.a(this.gzO.getUserData());
            }
            if ((aVar.brg() == null || this.mIsHost) && v.I(aVar.brh())) {
                this.gzn.removeHeaderView(this.gDV.anC());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.gDV.a(aVar.brg(), this.mIsHost, this.gzO.getUserData(), aVar.brh());
            }
            if (!this.mIsHost) {
                if (aVar.bri() == null || aVar.bri().gAU == null || aVar.bri().gAU.size() <= 0) {
                    this.gzn.removeHeaderView(this.gDS);
                } else {
                    this.gDS.a(aVar.bri());
                }
            }
            if (v.I(aVar.aNx())) {
                du(null);
                this.gzB.abd();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bww().mT(this.mIsHost);
            du(aVar.aNx());
            int size = aVar.aNx().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aNx().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.gzB.abd();
                    return;
                }
            }
            if (z) {
                if (this.bOB != null) {
                    this.bOB.Fd();
                    return;
                }
                return;
            }
            this.gzB.c(true, aVar.aNx());
        }
    }

    public void aHD() {
        this.gzB.aHD();
    }

    private void w(TbPageContext tbPageContext) {
        this.gDP = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gWy;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gDF != null && p.this.gDF.gDa != null) {
                            p.this.gDF.gDa.op(aVar.fvb);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.gzO != null) {
                            if (p.this.gzO.gAK != null && p.this.gzO.gAK.dtC != null && aVar2 != null) {
                                p.this.gzO.gAK.dtC.putBoolean("person_center_item_red_tip_show", aVar2.fvb);
                            }
                            if (aVar3 != null && p.this.gzO.gAJ != null && p.this.gzO.gAJ.dtC != null) {
                                p.this.gzO.gAJ.dtC.putBoolean("person_center_item_red_tip_show", aVar3.fvb);
                            }
                            if (aVar4 != null && p.this.gzO.gAH != null && p.this.gzO.gAH.dtC != null) {
                                p.this.gzO.gAH.dtC.putBoolean("person_center_item_red_tip_show", aVar4.fvb);
                            }
                            if (aVar5 != null && p.this.gzO.gAL != null && p.this.gzO.gAL.dtC != null) {
                                p.this.gzO.gAL.dtC.putBoolean("person_center_item_red_tip_show", aVar5.fvb);
                            }
                            if (aVar6 != null && p.this.gzO.gAM != null && p.this.gzO.gAM.dtC != null) {
                                p.this.gzO.gAM.dtC.putBoolean("person_center_item_red_tip_show", aVar6.fvb);
                                p.this.gzO.gAM.dtC.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gDE instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gDE.C(5, aVar7.fvb);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gDE.C(6, aVar8.fvb);
                            }
                        }
                    }
                }
            }
        };
        this.gDP.setTag(this.aBS);
        tbPageContext.registerListener(this.gDP);
        this.guo = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gDF.tT(jVar.ys());
                }
            }
        };
        this.guo.setTag(this.aBS);
        tbPageContext.registerListener(this.guo);
    }

    public void onDestory() {
        if (this.gDF != null) {
            this.gDF.onDestory();
        }
    }

    public com.baidu.tieba.view.f brs() {
        return this.gDE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bL(boolean z) {
            if (z) {
                if (p.this.dLk == null) {
                    p.this.dLk = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gDK.FA() != null && !StringUtils.isNull(p.this.gDK.FA().getUserId())) {
                    p.this.dLk.ia(p.this.gDK.FA().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).BN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brt() {
        ans();
        ant();
        bru();
        if (this.gDF.anC().getTop() + this.gDL <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gDG = aVar;
    }

    private void ans() {
        if (Build.VERSION.SDK_INT >= 11 && this.gDF != null) {
            int top = this.gDF.anC().getTop();
            if (top >= this.gDD) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gDD) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gDD));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void ant() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.cHf) {
                    this.cHf = true;
                }
            } else if (this.cHf) {
                this.cHf = false;
            }
            a(alpha, !this.cHf);
            this.gDE.c(alpha, this.cHf ? false : true);
        }
    }

    private void bru() {
        if (Build.VERSION.SDK_INT >= 11 && this.gDF != null) {
            int i = this.gDD / 2;
            int i2 = this.gDD - i;
            int top = this.gDF.anC().getTop();
            if (this.gDI != null) {
                if (top < i) {
                    if (this.gDI.getAlpha() != 0.0f) {
                        this.gDI.setAlpha(0.0f);
                    }
                } else if (top < this.gDD && top >= i) {
                    if (i2 > 0) {
                        this.gDI.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gDD && this.gDI.getAlpha() != 1.0f) {
                    this.gDI.setAlpha(1.0f);
                }
            }
            if (this.gDJ != null) {
                if (top >= i) {
                    if (this.gDJ.getAlpha() != 0.0f) {
                        this.gDJ.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gDJ.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gDJ.getAlpha() != 1.0f) {
                    this.gDJ.setAlpha(1.0f);
                }
            }
        }
    }

    public void du(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.I(list)) {
            list = new ArrayList<>();
        }
        if (this.gzn.getVisibility() != 0) {
            this.gzn.setVisibility(0);
        }
        this.gzn.setData(list);
        int H = v.H(list);
        if (H >= 5) {
            if (this.gDT) {
                mr(true);
                this.gDT = false;
            }
        } else if (H <= 1) {
            this.gzn.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gDH = iVar;
    }

    public NavigationBar abW() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.gzn != null) {
            this.gDW = str;
            this.gDZ = aVar;
            int headerViewsCount = (this.gzn.getHeaderViewsCount() + i) - this.gzn.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gDX = this.gzn.getChildAt(headerViewsCount);
                if (this.gDX != null) {
                    this.gDY = this.gDX.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gDX.getLayoutParams().height = p.this.gDY - ((int) (p.this.gDY * f));
                            p.this.gDX.requestLayout();
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
                            p.this.gDX.setVisibility(8);
                            if (p.this.gDZ != null) {
                                p.this.gDZ.tP(p.this.gDW);
                            }
                        }
                    });
                    animation.setDuration(gDC);
                    this.gDX.startAnimation(animation);
                }
            }
        }
    }
}
