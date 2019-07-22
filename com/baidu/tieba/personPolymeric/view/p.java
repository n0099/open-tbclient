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
    public static int itB = 300;
    private BdUniqueId XE;
    private NoNetworkView dnF;
    private PbListView dnG;
    private ImageView eJq;
    private PluginErrorTipView eWW;
    private int euR;
    private com.baidu.tbadk.k.a fup;
    private CustomMessageListener ijN;
    private boolean iju;
    private com.baidu.tieba.personPolymeric.b.d ipA;
    private com.baidu.tieba.personPolymeric.c.a ipN;
    public BdPersonListView ipm;
    private com.baidu.tieba.view.g isR;
    private com.baidu.tieba.view.f itC;
    public n itD;
    private com.baidu.tieba.model.a itE;
    private com.baidu.tieba.view.i itF;
    private TextView itG;
    private LikeButtonWithHeadPortrait itH;
    private com.baidu.tbadk.core.view.userLike.c itI;
    private int itJ;
    private TextView itK;
    private TextView itL;
    private com.baidu.tieba.personPolymeric.a.n itM;
    private CustomMessageListener itN;
    private View itP;
    private PersonCenterAttentionBarListView itQ;
    private boolean itR;
    private k itT;
    private String itU;
    private View itV;
    private int itW;
    private i.a itX;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean ejQ = true;
    private int elY = 0;
    private boolean itO = false;
    private boolean itS = false;
    View.OnClickListener clU = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b ipw = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.isR != null) {
                if (p.this.eJq == view) {
                    this.ipw.fcx = 8;
                }
                p.this.isR.a(view, this.ipw);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.itF != null) {
                p.this.itF.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.itF != null) {
                    p.this.itF.onScroll(absListView, i, i2, i3);
                }
                p.this.cdq();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dnG != null && p.this.itE != null) {
                p.this.ipA.yP(p.this.elY);
                if (p.this.elY == 0) {
                    p.this.dnG.akD();
                    p.this.itE.g(false, false, false);
                } else if (p.this.elY == 1) {
                    p.this.dnG.akD();
                    p.this.itE.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a itY = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.ccB();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nY() {
            p.this.ipA.brJ();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.ipA.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.iju = false;
        this.mContext = tbPageContext;
        this.XE = bdUniqueId;
        this.mIsHost = z;
        this.iju = z2;
        this.ipA = eVar.ccL();
        this.dnG = this.ipA.dnG;
        this.euR = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.itC = new com.baidu.tieba.view.d(2);
            x(tbPageContext);
            return;
        }
        this.itC = new com.baidu.tieba.personPolymeric.a();
    }

    public void Q(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eWW = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.ipm = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.itC.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.ipm.setOnScrollListener(this.mOnScrollListener);
        this.itJ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eJq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eJq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJq.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eJq.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.itG = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.itH = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.itI = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.itH);
        this.itI.setFromType("2");
        this.itI.j(this.mContext.getUniqueId());
        this.itI.a(new a());
        this.itK = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.itL = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.iju) {
            this.eJq.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.ipm.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.itD = new n(this.mContext, this.mIsHost);
        this.itP = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.ipm.addHeaderView(this.itP);
        this.ipm.setExpandView(this.itP);
        this.ipm.addHeaderView(this.itD.aWR());
        this.itT = new k(this.mContext);
        this.ipm.addHeaderView(this.itT.aWR());
        if (!this.mIsHost) {
            this.itG.setText(R.string.ta_homepage);
            this.itQ = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.ipm.addHeaderView(this.itQ);
        } else {
            this.itG.setText(R.string.my_homepage);
        }
        this.ipm.setPersonListRefreshListener(this.itY);
        this.itM = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.ipm, this.XE);
        this.itM.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.itH.setAlpha(0.0f);
        this.itC.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ipN == null) {
            this.itC.c(1.0f, true);
            am.c(this.eJq, (int) R.drawable.selector_topbar_return_black);
        } else {
            cdq();
        }
        am.j(this.itG, R.color.cp_btn_a);
        this.itH.onChangeSkinType(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        if (this.itC != null) {
            this.itC.onChangeSkinType(i);
        }
        this.dnF.onChangeSkinType(this.mContext, i);
        this.eWW.onChangeSkinType(this.mContext, i);
        if (this.itD != null) {
            this.itD.onChangeSkinType(i);
        }
        if (this.ipm != null && (this.ipm.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ipm.getAdapter().notifyDataSetChanged();
        }
        this.dnG.iV(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            am.e(this.itL, R.color.cp_cont_b, R.color.s_navbar_title_color);
            am.e(this.itK, R.color.cp_btn_a, R.color.cp_btn_a);
        }
        if (this.itQ != null) {
            this.itQ.onChangeSkinType(i);
        }
        if (this.itT != null) {
            this.itT.onChangeSkinType(i);
        }
    }

    public void pS(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            am.c(this.eJq, (int) R.drawable.selector_topbar_return_black);
            this.itC.c(1.0f, true);
            this.itG.setAlpha(0.0f);
            this.itH.setAlpha(1.0f);
            this.ipm.setSelectionFromTop(this.ipm.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        am.c(this.eJq, (int) R.drawable.selector_topbar_return_white);
        this.itC.c(0.0f, false);
        this.itG.setAlpha(1.0f);
        this.itH.setAlpha(0.0f);
    }

    public void CO(String str) {
        if (this.itD != null) {
            this.itD.CB(str);
        }
    }

    public void CP(String str) {
        if (this.itD != null) {
            this.itD.CC(str);
        }
    }

    public void ccB() {
        this.itO = false;
        if (this.elY == 0) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.itE.resetData();
                this.itE.refreshData();
                this.ipA.nX();
                return;
            }
            this.ipA.brJ();
        } else if (this.elY == 1) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.itE.g(true, true, true);
                this.ipA.nX();
                return;
            }
            this.ipA.brJ();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.isR = gVar;
        this.itC.setOnViewResponseListener(gVar);
        this.eJq.setOnClickListener(this.clU);
        this.itD.setOnViewResponseListener(gVar);
        if (this.ipA != null) {
            this.ipA.a(this.itP, gVar);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.itM != null) {
            this.itM.V(onClickListener);
        }
    }

    public void pK(boolean z) {
        this.itR = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            am.c(this.eJq, (int) R.drawable.selector_topbar_return_black);
        } else {
            am.c(this.eJq, (int) R.drawable.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eJq.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.itK.setAlpha(1.0f - f);
            this.itL.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dS(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pS(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ipN = aVar;
            this.itC.setUserData(this.ipN.getUserData());
            if (this.itO) {
                dS(aVar.byJ());
                if (this.dnG != null) {
                    this.dnG.akE();
                    return;
                }
                return;
            }
            this.itC.ccy();
            this.itD.e(aVar);
            if (aVar != null) {
                this.itH.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.itH.cdk();
            } else {
                this.ipN.getUserData().setIsLike(this.ipN.getUserData().getHave_attention() == 1);
                this.itI.a(this.ipN.getUserData());
            }
            if ((aVar.cdd() == null || this.mIsHost) && v.aa(aVar.cde())) {
                this.ipm.removeHeaderView(this.itT.aWR());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.itT.a(aVar.cdd(), this.mIsHost, this.ipN.getUserData(), aVar.cde());
            }
            if (!this.mIsHost) {
                if (aVar.cdf() == null || aVar.cdf().iqT == null || aVar.cdf().iqT.size() <= 0) {
                    this.ipm.removeHeaderView(this.itQ);
                } else {
                    this.itQ.a(aVar.cdf());
                }
            }
            if (v.aa(aVar.byJ())) {
                dS(null);
                this.ipA.aKk();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.ciR().qy(this.mIsHost);
            dS(aVar.byJ());
            int size = aVar.byJ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.byJ().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ipA.aKk();
                    return;
                }
            }
            if (z) {
                if (this.dnG != null) {
                    this.dnG.akE();
                    return;
                }
                return;
            }
            this.ipA.b(true, aVar.byJ());
        }
    }

    public void brJ() {
        this.ipA.brJ();
    }

    private void x(TbPageContext tbPageContext) {
        this.itN = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iOk;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.itD != null && p.this.itD.isZ != null) {
                            p.this.itD.isZ.rT(aVar.hjx);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.ipN != null) {
                            if (p.this.ipN.iqJ != null && p.this.ipN.iqJ.azf != null && aVar2 != null) {
                                p.this.ipN.iqJ.azf.putBoolean("person_center_item_red_tip_show", aVar2.hjx);
                            }
                            if (aVar3 != null && p.this.ipN.iqI != null && p.this.ipN.iqI.azf != null) {
                                p.this.ipN.iqI.azf.putBoolean("person_center_item_red_tip_show", aVar3.hjx);
                            }
                            if (aVar4 != null && p.this.ipN.iqG != null && p.this.ipN.iqG.azf != null) {
                                p.this.ipN.iqG.azf.putBoolean("person_center_item_red_tip_show", aVar4.hjx);
                            }
                            if (aVar5 != null && p.this.ipN.iqK != null && p.this.ipN.iqK.azf != null) {
                                p.this.ipN.iqK.azf.putBoolean("person_center_item_red_tip_show", aVar5.hjx);
                            }
                            if (aVar6 != null && p.this.ipN.iqL != null && p.this.ipN.iqL.azf != null) {
                                p.this.ipN.iqL.azf.putBoolean("person_center_item_red_tip_show", aVar6.hjx);
                                p.this.ipN.iqL.azf.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.itC instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.itC.P(5, aVar7.hjx);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.itC.P(6, aVar8.hjx);
                            }
                        }
                    }
                }
            }
        };
        this.itN.setTag(this.XE);
        tbPageContext.registerListener(this.itN);
        this.ijN = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.itD.CT(lVar.acU());
                }
            }
        };
        this.ijN.setTag(this.XE);
        tbPageContext.registerListener(this.ijN);
    }

    public void onDestory() {
        if (this.itD != null) {
            this.itD.onDestory();
        }
    }

    public com.baidu.tieba.view.f cdp() {
        return this.itC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void ew(boolean z) {
            if (z) {
                if (p.this.fup == null) {
                    p.this.fup = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.itI.ali() != null && !StringUtils.isNull(p.this.itI.ali().getUserId())) {
                    p.this.fup.qA(p.this.itI.ali().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).agQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdq() {
        aWE();
        aWF();
        cdr();
        if (this.itD.aWR().getTop() + this.itJ <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.itE = aVar;
    }

    private void aWE() {
        if (Build.VERSION.SDK_INT >= 11 && this.itD != null) {
            int top = this.itD.aWR().getTop();
            if (top >= this.euR) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.euR) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.euR));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aWF() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.ejQ) {
                    this.ejQ = true;
                }
            } else if (this.ejQ) {
                this.ejQ = false;
            }
            a(alpha, !this.ejQ);
            this.itC.c(alpha, this.ejQ ? false : true);
        }
    }

    private void cdr() {
        if (Build.VERSION.SDK_INT >= 11 && this.itD != null) {
            int i = this.euR / 2;
            int i2 = this.euR - i;
            int top = this.itD.aWR().getTop();
            if (this.itG != null) {
                if (top < i) {
                    if (this.itG.getAlpha() != 0.0f) {
                        this.itG.setAlpha(0.0f);
                    }
                } else if (top < this.euR && top >= i) {
                    if (i2 > 0) {
                        this.itG.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.euR && this.itG.getAlpha() != 1.0f) {
                    this.itG.setAlpha(1.0f);
                }
            }
            if (this.itH != null) {
                if (top >= i) {
                    if (this.itH.getAlpha() != 0.0f) {
                        this.itH.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.itH.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.itH.getAlpha() != 1.0f) {
                    this.itH.setAlpha(1.0f);
                }
            }
        }
    }

    public void dS(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.ipm.getVisibility() != 0) {
            this.ipm.setVisibility(0);
        }
        this.ipm.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.itR) {
                pS(true);
                this.itR = false;
            }
        } else if (Z <= 1) {
            this.ipm.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.itF = iVar;
    }

    public NavigationBar aLh() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!aq.isEmpty(str) && this.ipm != null) {
            this.itU = str;
            this.itX = aVar;
            int headerViewsCount = (this.ipm.getHeaderViewsCount() + i) - this.ipm.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.itV = this.ipm.getChildAt(headerViewsCount);
                if (this.itV != null) {
                    this.itW = this.itV.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.itV.getLayoutParams().height = p.this.itW - ((int) (p.this.itW * f));
                            p.this.itV.requestLayout();
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
                            p.this.itV.setVisibility(8);
                            if (p.this.itX != null) {
                                p.this.itX.removeThread(p.this.itU);
                            }
                        }
                    });
                    animation.setDuration(itB);
                    this.itV.startAnimation(animation);
                }
            }
        }
    }
}
