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
    public static int iuE = 300;
    private BdUniqueId XE;
    private NoNetworkView dnM;
    private PbListView dnN;
    private ImageView eJx;
    private PluginErrorTipView eXg;
    private int euY;
    private com.baidu.tbadk.k.a fuO;
    private CustomMessageListener ikP;
    private boolean ikw;
    private com.baidu.tieba.personPolymeric.b.d iqE;
    private com.baidu.tieba.personPolymeric.c.a iqR;
    public BdPersonListView iqq;
    private com.baidu.tieba.view.g itU;
    private com.baidu.tieba.view.f iuF;
    public n iuG;
    private com.baidu.tieba.model.a iuH;
    private com.baidu.tieba.view.i iuI;
    private TextView iuJ;
    private LikeButtonWithHeadPortrait iuK;
    private com.baidu.tbadk.core.view.userLike.c iuL;
    private int iuM;
    private TextView iuN;
    private TextView iuO;
    private com.baidu.tieba.personPolymeric.a.n iuP;
    private CustomMessageListener iuQ;
    private View iuS;
    private PersonCenterAttentionBarListView iuT;
    private boolean iuU;
    private k iuW;
    private String iuX;
    private View iuY;
    private int iuZ;
    private i.a iva;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean ejX = true;
    private int emf = 0;
    private boolean iuR = false;
    private boolean iuV = false;
    View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b iqA = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.itU != null) {
                if (p.this.eJx == view) {
                    this.iqA.fcX = 8;
                }
                p.this.itU.a(view, this.iqA);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.iuI != null) {
                p.this.iuI.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.iuI != null) {
                    p.this.iuI.onScroll(absListView, i, i2, i3);
                }
                p.this.cdI();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dnN != null && p.this.iuH != null) {
                p.this.iqE.yR(p.this.emf);
                if (p.this.emf == 0) {
                    p.this.dnN.akF();
                    p.this.iuH.g(false, false, false);
                } else if (p.this.emf == 1) {
                    p.this.dnN.akF();
                    p.this.iuH.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a ivb = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.ccT();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nY() {
            p.this.iqE.brW();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.iqE.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.ikw = false;
        this.mContext = tbPageContext;
        this.XE = bdUniqueId;
        this.mIsHost = z;
        this.ikw = z2;
        this.iqE = eVar.cdd();
        this.dnN = this.iqE.dnN;
        this.euY = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.iuF = new com.baidu.tieba.view.d(2);
            x(tbPageContext);
            return;
        }
        this.iuF = new com.baidu.tieba.personPolymeric.a();
    }

    public void Q(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eXg = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.iqq = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.iuF.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.iqq.setOnScrollListener(this.mOnScrollListener);
        this.iuM = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eJx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eJx.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eJx.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eJx.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.iuJ = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.iuK = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.iuL = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.iuK);
        this.iuL.setFromType("2");
        this.iuL.j(this.mContext.getUniqueId());
        this.iuL.a(new a());
        this.iuN = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.iuO = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.ikw) {
            this.eJx.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.iqq.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.iuG = new n(this.mContext, this.mIsHost);
        this.iuS = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.iqq.addHeaderView(this.iuS);
        this.iqq.setExpandView(this.iuS);
        this.iqq.addHeaderView(this.iuG.aWT());
        this.iuW = new k(this.mContext);
        this.iqq.addHeaderView(this.iuW.aWT());
        if (!this.mIsHost) {
            this.iuJ.setText(R.string.ta_homepage);
            this.iuT = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.iqq.addHeaderView(this.iuT);
        } else {
            this.iuJ.setText(R.string.my_homepage);
        }
        this.iqq.setPersonListRefreshListener(this.ivb);
        this.iuP = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.iqq, this.XE);
        this.iuP.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.iuK.setAlpha(0.0f);
        this.iuF.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.iqR == null) {
            this.iuF.c(1.0f, true);
            am.c(this.eJx, (int) R.drawable.selector_topbar_return_black);
        } else {
            cdI();
        }
        am.j(this.iuJ, R.color.cp_btn_a);
        this.iuK.onChangeSkinType(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        if (this.iuF != null) {
            this.iuF.onChangeSkinType(i);
        }
        this.dnM.onChangeSkinType(this.mContext, i);
        this.eXg.onChangeSkinType(this.mContext, i);
        if (this.iuG != null) {
            this.iuG.onChangeSkinType(i);
        }
        if (this.iqq != null && (this.iqq.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.iqq.getAdapter().notifyDataSetChanged();
        }
        this.dnN.iV(i);
        am.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            am.e(this.iuO, R.color.cp_cont_b, R.color.s_navbar_title_color);
            am.e(this.iuN, R.color.cp_btn_a, R.color.cp_btn_a);
        }
        if (this.iuT != null) {
            this.iuT.onChangeSkinType(i);
        }
        if (this.iuW != null) {
            this.iuW.onChangeSkinType(i);
        }
    }

    public void pT(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            am.c(this.eJx, (int) R.drawable.selector_topbar_return_black);
            this.iuF.c(1.0f, true);
            this.iuJ.setAlpha(0.0f);
            this.iuK.setAlpha(1.0f);
            this.iqq.setSelectionFromTop(this.iqq.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        am.c(this.eJx, (int) R.drawable.selector_topbar_return_white);
        this.iuF.c(0.0f, false);
        this.iuJ.setAlpha(1.0f);
        this.iuK.setAlpha(0.0f);
    }

    public void CP(String str) {
        if (this.iuG != null) {
            this.iuG.CC(str);
        }
    }

    public void CQ(String str) {
        if (this.iuG != null) {
            this.iuG.CD(str);
        }
    }

    public void ccT() {
        this.iuR = false;
        if (this.emf == 0) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.iuH.resetData();
                this.iuH.refreshData();
                this.iqE.nX();
                return;
            }
            this.iqE.brW();
        } else if (this.emf == 1) {
            if (com.baidu.adp.lib.util.j.kc()) {
                this.iuH.g(true, true, true);
                this.iqE.nX();
                return;
            }
            this.iqE.brW();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.itU = gVar;
        this.iuF.setOnViewResponseListener(gVar);
        this.eJx.setOnClickListener(this.cmb);
        this.iuG.setOnViewResponseListener(gVar);
        if (this.iqE != null) {
            this.iqE.a(this.iuS, gVar);
        }
    }

    public void V(View.OnClickListener onClickListener) {
        if (this.iuP != null) {
            this.iuP.V(onClickListener);
        }
    }

    public void pL(boolean z) {
        this.iuU = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            am.c(this.eJx, (int) R.drawable.selector_topbar_return_black);
        } else {
            am.c(this.eJx, (int) R.drawable.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eJx.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.iuN.setAlpha(1.0f - f);
            this.iuO.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dR(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pT(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.iqR = aVar;
            this.iuF.setUserData(this.iqR.getUserData());
            if (this.iuR) {
                dR(aVar.byX());
                if (this.dnN != null) {
                    this.dnN.akG();
                    return;
                }
                return;
            }
            this.iuF.ccQ();
            this.iuG.e(aVar);
            if (aVar != null) {
                this.iuK.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.iuK.cdC();
            } else {
                this.iqR.getUserData().setIsLike(this.iqR.getUserData().getHave_attention() == 1);
                this.iuL.a(this.iqR.getUserData());
            }
            if ((aVar.cdv() == null || this.mIsHost) && v.aa(aVar.cdw())) {
                this.iqq.removeHeaderView(this.iuW.aWT());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.iuW.a(aVar.cdv(), this.mIsHost, this.iqR.getUserData(), aVar.cdw());
            }
            if (!this.mIsHost) {
                if (aVar.cdx() == null || aVar.cdx().irX == null || aVar.cdx().irX.size() <= 0) {
                    this.iqq.removeHeaderView(this.iuT);
                } else {
                    this.iuT.a(aVar.cdx());
                }
            }
            if (v.aa(aVar.byX())) {
                dR(null);
                this.iqE.aKm();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cjj().qz(this.mIsHost);
            dR(aVar.byX());
            int size = aVar.byX().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.byX().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.iqE.aKm();
                    return;
                }
            }
            if (z) {
                if (this.dnN != null) {
                    this.dnN.akG();
                    return;
                }
                return;
            }
            this.iqE.b(true, aVar.byX());
        }
    }

    public void brW() {
        this.iqE.brW();
    }

    private void x(TbPageContext tbPageContext) {
        this.iuQ = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iPo;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.iuG != null && p.this.iuG.iuc != null) {
                            p.this.iuG.iuc.rU(aVar.hkp);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.iqR != null) {
                            if (p.this.iqR.irN != null && p.this.iqR.irN.azf != null && aVar2 != null) {
                                p.this.iqR.irN.azf.putBoolean("person_center_item_red_tip_show", aVar2.hkp);
                            }
                            if (aVar3 != null && p.this.iqR.irM != null && p.this.iqR.irM.azf != null) {
                                p.this.iqR.irM.azf.putBoolean("person_center_item_red_tip_show", aVar3.hkp);
                            }
                            if (aVar4 != null && p.this.iqR.irK != null && p.this.iqR.irK.azf != null) {
                                p.this.iqR.irK.azf.putBoolean("person_center_item_red_tip_show", aVar4.hkp);
                            }
                            if (aVar5 != null && p.this.iqR.irO != null && p.this.iqR.irO.azf != null) {
                                p.this.iqR.irO.azf.putBoolean("person_center_item_red_tip_show", aVar5.hkp);
                            }
                            if (aVar6 != null && p.this.iqR.irP != null && p.this.iqR.irP.azf != null) {
                                p.this.iqR.irP.azf.putBoolean("person_center_item_red_tip_show", aVar6.hkp);
                                p.this.iqR.irP.azf.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.iuF instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.iuF.P(5, aVar7.hkp);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.iuF.P(6, aVar8.hkp);
                            }
                        }
                    }
                }
            }
        };
        this.iuQ.setTag(this.XE);
        tbPageContext.registerListener(this.iuQ);
        this.ikP = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.iuG.CU(lVar.acV());
                }
            }
        };
        this.ikP.setTag(this.XE);
        tbPageContext.registerListener(this.ikP);
    }

    public void onDestory() {
        if (this.iuG != null) {
            this.iuG.onDestory();
        }
    }

    public com.baidu.tieba.view.f cdH() {
        return this.iuF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void ew(boolean z) {
            if (z) {
                if (p.this.fuO == null) {
                    p.this.fuO = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.iuL.alk() != null && !StringUtils.isNull(p.this.iuL.alk().getUserId())) {
                    p.this.fuO.qA(p.this.iuL.alk().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).agS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdI() {
        aWG();
        aWH();
        cdJ();
        if (this.iuG.aWT().getTop() + this.iuM <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.iuH = aVar;
    }

    private void aWG() {
        if (Build.VERSION.SDK_INT >= 11 && this.iuG != null) {
            int top = this.iuG.aWT().getTop();
            if (top >= this.euY) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.euY) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.euY));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aWH() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.ejX) {
                    this.ejX = true;
                }
            } else if (this.ejX) {
                this.ejX = false;
            }
            a(alpha, !this.ejX);
            this.iuF.c(alpha, this.ejX ? false : true);
        }
    }

    private void cdJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.iuG != null) {
            int i = this.euY / 2;
            int i2 = this.euY - i;
            int top = this.iuG.aWT().getTop();
            if (this.iuJ != null) {
                if (top < i) {
                    if (this.iuJ.getAlpha() != 0.0f) {
                        this.iuJ.setAlpha(0.0f);
                    }
                } else if (top < this.euY && top >= i) {
                    if (i2 > 0) {
                        this.iuJ.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.euY && this.iuJ.getAlpha() != 1.0f) {
                    this.iuJ.setAlpha(1.0f);
                }
            }
            if (this.iuK != null) {
                if (top >= i) {
                    if (this.iuK.getAlpha() != 0.0f) {
                        this.iuK.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.iuK.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.iuK.getAlpha() != 1.0f) {
                    this.iuK.setAlpha(1.0f);
                }
            }
        }
    }

    public void dR(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iqq.getVisibility() != 0) {
            this.iqq.setVisibility(0);
        }
        this.iqq.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.iuU) {
                pT(true);
                this.iuU = false;
            }
        } else if (Z <= 1) {
            this.iqq.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.iuI = iVar;
    }

    public NavigationBar aLj() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!aq.isEmpty(str) && this.iqq != null) {
            this.iuX = str;
            this.iva = aVar;
            int headerViewsCount = (this.iqq.getHeaderViewsCount() + i) - this.iqq.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.iuY = this.iqq.getChildAt(headerViewsCount);
                if (this.iuY != null) {
                    this.iuZ = this.iuY.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.iuY.getLayoutParams().height = p.this.iuZ - ((int) (p.this.iuZ * f));
                            p.this.iuY.requestLayout();
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
                            p.this.iuY.setVisibility(8);
                            if (p.this.iva != null) {
                                p.this.iva.removeThread(p.this.iuX);
                            }
                        }
                    });
                    animation.setDuration(iuE);
                    this.iuY.startAnimation(animation);
                }
            }
        }
    }
}
