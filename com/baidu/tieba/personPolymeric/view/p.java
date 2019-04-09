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
    public static int hUt = 300;
    private BdUniqueId Zs;
    private NoNetworkView dbr;
    private PbListView dbs;
    private PluginErrorTipView eCg;
    private com.baidu.tbadk.k.a eZf;
    private ImageView eoM;
    private boolean hKZ;
    private CustomMessageListener hLr;
    private com.baidu.tieba.personPolymeric.c.a hQF;
    public BdPersonListView hQe;
    private com.baidu.tieba.personPolymeric.b.d hQs;
    private com.baidu.tieba.view.g hTJ;
    private LikeButtonWithHeadPortrait hUA;
    private com.baidu.tbadk.core.view.userLike.c hUB;
    private int hUC;
    private TextView hUD;
    private TextView hUE;
    private com.baidu.tieba.personPolymeric.a.n hUF;
    private CustomMessageListener hUG;
    private View hUI;
    private PersonCenterAttentionBarListView hUJ;
    private boolean hUK;
    private k hUM;
    private String hUN;
    private View hUO;
    private int hUP;
    private i.a hUQ;
    private int hUu;
    private com.baidu.tieba.view.f hUv;
    public n hUw;
    private com.baidu.tieba.model.a hUx;
    private com.baidu.tieba.view.i hUy;
    private TextView hUz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean dUM = true;
    private int dWU = 0;
    private boolean hUH = false;
    private boolean hUL = false;
    View.OnClickListener ccD = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b hQo = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.hTJ != null) {
                if (p.this.eoM == view) {
                    this.hQo.eHl = 8;
                }
                p.this.hTJ.a(view, this.hQo);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.hUy != null) {
                p.this.hUy.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.hUy != null) {
                    p.this.hUy.onScroll(absListView, i, i2, i3);
                }
                p.this.bSw();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dbs != null && p.this.hUx != null) {
                p.this.hQs.xc(p.this.dWU);
                if (p.this.dWU == 0) {
                    p.this.dbs.aez();
                    p.this.hUx.g(false, false, false);
                } else if (p.this.dWU == 1) {
                    p.this.dbs.aez();
                    p.this.hUx.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a hUR = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bRH();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void oL() {
            p.this.hQs.bin();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.hQs.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.hKZ = false;
        this.mContext = tbPageContext;
        this.Zs = bdUniqueId;
        this.mIsHost = z;
        this.hKZ = z2;
        this.hQs = eVar.bRR();
        this.dbs = this.hQs.dbs;
        this.hUu = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.hUv = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.hUv = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0277d.cp_bg_line_c);
        this.dbr = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.eCg = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.hQe = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.hUv.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.hQe.setOnScrollListener(this.mOnScrollListener);
        this.hUC = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eoM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.eoM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eoM.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.eoM.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.hUz = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.hUA = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.hUB = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.hUA);
        this.hUB.setFromType("2");
        this.hUB.i(this.mContext.getUniqueId());
        this.hUB.a(new a());
        this.hUD = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.hUE = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.hKZ) {
            this.eoM.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.hQe.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.hUw = new n(this.mContext, this.mIsHost);
        this.hUI = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.hQe.addHeaderView(this.hUI);
        this.hQe.setExpandView(this.hUI);
        this.hQe.addHeaderView(this.hUw.aOH());
        this.hUM = new k(this.mContext);
        this.hQe.addHeaderView(this.hUM.aOH());
        if (!this.mIsHost) {
            this.hUz.setText(d.j.ta_homepage);
            this.hUJ = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.hQe.addHeaderView(this.hUJ);
        } else {
            this.hUz.setText(d.j.my_homepage);
        }
        this.hQe.setPersonListRefreshListener(this.hUR);
        this.hUF = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.hQe, this.Zs);
        this.hUF.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.hUA.setAlpha(0.0f);
        this.hUv.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.hQF == null) {
            this.hUv.c(1.0f, true);
            al.c(this.eoM, d.f.selector_topbar_return_black);
        } else {
            bSw();
        }
        al.j(this.hUz, d.C0277d.cp_btn_a);
        this.hUA.onChangeSkinType(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        if (this.hUv != null) {
            this.hUv.onChangeSkinType(i);
        }
        this.dbr.onChangeSkinType(this.mContext, i);
        this.eCg.onChangeSkinType(this.mContext, i);
        if (this.hUw != null) {
            this.hUw.onChangeSkinType(i);
        }
        if (this.hQe != null && (this.hQe.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.hQe.getAdapter().notifyDataSetChanged();
        }
        this.dbs.ib(i);
        al.k(this.mRootView, d.C0277d.cp_bg_line_d);
        if (this.mIsHost) {
            al.c(this.hUE, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            al.c(this.hUD, d.C0277d.cp_btn_a, d.C0277d.cp_btn_a);
        }
        if (this.hUJ != null) {
            this.hUJ.onChangeSkinType(i);
        }
        if (this.hUM != null) {
            this.hUM.onChangeSkinType(i);
        }
    }

    public void oO(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eoM, d.f.selector_topbar_return_black);
            this.hUv.c(1.0f, true);
            this.hUz.setAlpha(0.0f);
            this.hUA.setAlpha(1.0f);
            this.hQe.setSelectionFromTop(this.hQe.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eoM, d.f.selector_topbar_return_white);
        this.hUv.c(0.0f, false);
        this.hUz.setAlpha(1.0f);
        this.hUA.setAlpha(0.0f);
    }

    public void AH(String str) {
        if (this.hUw != null) {
            this.hUw.Aw(str);
        }
    }

    public void AI(String str) {
        if (this.hUw != null) {
            this.hUw.Ax(str);
        }
    }

    public void bRH() {
        this.hUH = false;
        if (this.dWU == 0) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUx.resetData();
                this.hUx.refreshData();
                this.hQs.oK();
                return;
            }
            this.hQs.bin();
        } else if (this.dWU == 1) {
            if (com.baidu.adp.lib.util.j.kY()) {
                this.hUx.g(true, true, true);
                this.hQs.oK();
                return;
            }
            this.hQs.bin();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.hTJ = gVar;
        this.hUv.setOnViewResponseListener(gVar);
        this.eoM.setOnClickListener(this.ccD);
        this.hUw.setOnViewResponseListener(gVar);
        if (this.hQs != null) {
            this.hQs.a(this.hUI, gVar);
        }
    }

    public void Q(View.OnClickListener onClickListener) {
        if (this.hUF != null) {
            this.hUF.Q(onClickListener);
        }
    }

    public void oG(boolean z) {
        this.hUK = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.eoM, d.f.selector_topbar_return_black);
        } else {
            al.c(this.eoM, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eoM.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.hUD.setAlpha(1.0f - f);
            this.hUE.setAlpha(f);
        }
    }

    public void aw(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dG(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        oO(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.hQF = aVar;
            this.hUv.setUserData(this.hQF.getUserData());
            if (this.hUH) {
                dG(aVar.boy());
                if (this.dbs != null) {
                    this.dbs.aeA();
                    return;
                }
                return;
            }
            this.hUv.bRy();
            this.hUw.e(aVar);
            if (aVar != null) {
                this.hUA.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.hUA.bSq();
            } else {
                this.hQF.getUserData().setIsLike(this.hQF.getUserData().getHave_attention() == 1);
                this.hUB.a(this.hQF.getUserData());
            }
            if ((aVar.bSj() == null || this.mIsHost) && v.T(aVar.bSk())) {
                this.hQe.removeHeaderView(this.hUM.aOH());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.hUM.a(aVar.bSj(), this.mIsHost, this.hQF.getUserData(), aVar.bSk());
            }
            if (!this.mIsHost) {
                if (aVar.bSl() == null || aVar.bSl().hRL == null || aVar.bSl().hRL.size() <= 0) {
                    this.hQe.removeHeaderView(this.hUJ);
                } else {
                    this.hUJ.a(aVar.bSl());
                }
            }
            if (v.T(aVar.boy())) {
                dG(null);
                this.hQs.aCt();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bXS().pt(this.mIsHost);
            dG(aVar.boy());
            int size = aVar.boy().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.boy().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.hQs.aCt();
                    return;
                }
            }
            if (z) {
                if (this.dbs != null) {
                    this.dbs.aeA();
                    return;
                }
                return;
            }
            this.hQs.c(true, aVar.boy());
        }
    }

    public void bin() {
        this.hQs.bin();
    }

    private void v(TbPageContext tbPageContext) {
        this.hUG = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).ioY;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.hUw != null && p.this.hUw.hTR != null) {
                            p.this.hUw.hTR.qQ(aVar.gLN);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.hQF != null) {
                            if (p.this.hQF.hRB != null && p.this.hQF.hRB.eHm != null && aVar2 != null) {
                                p.this.hQF.hRB.eHm.putBoolean("person_center_item_red_tip_show", aVar2.gLN);
                            }
                            if (aVar3 != null && p.this.hQF.hRA != null && p.this.hQF.hRA.eHm != null) {
                                p.this.hQF.hRA.eHm.putBoolean("person_center_item_red_tip_show", aVar3.gLN);
                            }
                            if (aVar4 != null && p.this.hQF.hRy != null && p.this.hQF.hRy.eHm != null) {
                                p.this.hQF.hRy.eHm.putBoolean("person_center_item_red_tip_show", aVar4.gLN);
                            }
                            if (aVar5 != null && p.this.hQF.hRC != null && p.this.hQF.hRC.eHm != null) {
                                p.this.hQF.hRC.eHm.putBoolean("person_center_item_red_tip_show", aVar5.gLN);
                            }
                            if (aVar6 != null && p.this.hQF.hRD != null && p.this.hQF.hRD.eHm != null) {
                                p.this.hQF.hRD.eHm.putBoolean("person_center_item_red_tip_show", aVar6.gLN);
                                p.this.hQF.hRD.eHm.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.hUv instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.hUv.I(5, aVar7.gLN);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.hUv.I(6, aVar8.gLN);
                            }
                        }
                    }
                }
            }
        };
        this.hUG.setTag(this.Zs);
        tbPageContext.registerListener(this.hUG);
        this.hLr = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.hUw.AM(lVar.Xk());
                }
            }
        };
        this.hLr.setTag(this.Zs);
        tbPageContext.registerListener(this.hLr);
    }

    public void onDestory() {
        if (this.hUw != null) {
            this.hUw.onDestory();
        }
    }

    public com.baidu.tieba.view.f bSv() {
        return this.hUv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void dV(boolean z) {
            if (z) {
                if (p.this.eZf == null) {
                    p.this.eZf = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.hUB.afe() != null && !StringUtils.isNull(p.this.hUB.afe().getUserId())) {
                    p.this.eZf.pc(p.this.hUB.afe().getUserId());
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
        if (this.hUw.aOH().getTop() + this.hUC <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.hUx = aVar;
    }

    private void aOu() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUw != null) {
            int top = this.hUw.aOH().getTop();
            if (top >= this.hUu) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.hUu) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.hUu));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aOv() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.dUM) {
                    this.dUM = true;
                }
            } else if (this.dUM) {
                this.dUM = false;
            }
            a(alpha, !this.dUM);
            this.hUv.c(alpha, this.dUM ? false : true);
        }
    }

    private void bSx() {
        if (Build.VERSION.SDK_INT >= 11 && this.hUw != null) {
            int i = this.hUu / 2;
            int i2 = this.hUu - i;
            int top = this.hUw.aOH().getTop();
            if (this.hUz != null) {
                if (top < i) {
                    if (this.hUz.getAlpha() != 0.0f) {
                        this.hUz.setAlpha(0.0f);
                    }
                } else if (top < this.hUu && top >= i) {
                    if (i2 > 0) {
                        this.hUz.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.hUu && this.hUz.getAlpha() != 1.0f) {
                    this.hUz.setAlpha(1.0f);
                }
            }
            if (this.hUA != null) {
                if (top >= i) {
                    if (this.hUA.getAlpha() != 0.0f) {
                        this.hUA.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.hUA.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.hUA.getAlpha() != 1.0f) {
                    this.hUA.setAlpha(1.0f);
                }
            }
        }
    }

    public void dG(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.T(list)) {
            list = new ArrayList<>();
        }
        if (this.hQe.getVisibility() != 0) {
            this.hQe.setVisibility(0);
        }
        this.hQe.setData(list);
        int S = v.S(list);
        if (S >= 5) {
            if (this.hUK) {
                oO(true);
                this.hUK = false;
            }
        } else if (S <= 1) {
            this.hQe.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.hUy = iVar;
    }

    public NavigationBar aDm() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.hQe != null) {
            this.hUN = str;
            this.hUQ = aVar;
            int headerViewsCount = (this.hQe.getHeaderViewsCount() + i) - this.hQe.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.hUO = this.hQe.getChildAt(headerViewsCount);
                if (this.hUO != null) {
                    this.hUP = this.hUO.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.hUO.getLayoutParams().height = p.this.hUP - ((int) (p.this.hUP * f));
                            p.this.hUO.requestLayout();
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
                            p.this.hUO.setVisibility(8);
                            if (p.this.hUQ != null) {
                                p.this.hUQ.removeThread(p.this.hUN);
                            }
                        }
                    });
                    animation.setDuration(hUt);
                    this.hUO.startAnimation(animation);
                }
            }
        }
    }
}
