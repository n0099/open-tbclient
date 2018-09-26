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
    public static int gkV = 300;
    private BdUniqueId asU;
    private NoNetworkView bBq;
    private PbListView bBr;
    private ImageView cLq;
    private PluginErrorTipView cYn;
    private com.baidu.tbadk.i.a dsF;
    private CustomMessageListener gbF;
    private boolean gbq;
    public BdPersonListView ggF;
    private com.baidu.tieba.personPolymeric.b.d ggT;
    private com.baidu.tieba.personPolymeric.c.a ghg;
    private int gkW;
    private com.baidu.tieba.view.f gkX;
    public n gkY;
    private com.baidu.tieba.model.a gkZ;
    private com.baidu.tieba.view.g gkl;
    private com.baidu.tieba.view.i gla;
    private TextView glb;
    private LikeButtonWithHeadPortrait glc;
    private com.baidu.tbadk.core.view.userLike.c gld;
    private int gle;
    private TextView glf;
    private TextView glg;
    private com.baidu.tieba.personPolymeric.a.n glh;
    private CustomMessageListener gli;
    private View glk;
    private PersonCenterAttentionBarListView gll;
    private boolean glm;
    private k glo;
    private String glp;
    private View glq;
    private int glr;
    private i.a gls;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean csx = true;
    private int cuA = 0;
    private boolean glj = false;
    private boolean gln = false;
    View.OnClickListener aKh = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b ggP = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gkl != null) {
                if (p.this.cLq == view) {
                    this.ggP.daV = 8;
                }
                p.this.gkl.a(view, this.ggP);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gla != null) {
                p.this.gla.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gla != null) {
                    p.this.gla.onScroll(absListView, i, i2, i3);
                }
                p.this.bmj();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.bBr != null && p.this.gkZ != null) {
                p.this.ggT.rW(p.this.cuA);
                if (p.this.cuA == 0) {
                    p.this.bBr.BI();
                    p.this.gkZ.g(false, false, false);
                } else if (p.this.cuA == 1) {
                    p.this.bBr.BI();
                    p.this.gkZ.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a glt = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.blv();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void ou() {
            p.this.ggT.aCn();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.ggT.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.gbq = false;
        this.mContext = tbPageContext;
        this.asU = bdUniqueId;
        this.mIsHost = z;
        this.gbq = z2;
        this.ggT = eVar.blE();
        this.bBr = this.ggT.bBr;
        this.gkW = com.baidu.adp.lib.util.l.h(this.mContext.getPageActivity(), e.C0141e.tbds402);
        if (z) {
            this.gkX = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gkX = new com.baidu.tieba.personPolymeric.a();
    }

    public void am(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(e.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(e.d.cp_bg_line_c);
        this.bBq = (NoNetworkView) this.mRootView.findViewById(e.g.person_center_no_network_view);
        this.cYn = (PluginErrorTipView) this.mRootView.findViewById(e.g.person_center_plugin_error_tip_view);
        this.ggF = (BdPersonListView) this.mRootView.findViewById(e.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gkX.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.ggF.setOnScrollListener(this.mOnScrollListener);
        this.gle = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cLq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.cLq.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cLq.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds14);
            this.cLq.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.glb = (TextView) view.findViewById(e.g.tv_title_above_navigation_bar);
        this.glc = (LikeButtonWithHeadPortrait) view.findViewById(e.g.like_btn_with_head_portrait);
        this.gld = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.glc);
        this.gld.setFromType("2");
        this.gld.h(this.mContext.getUniqueId());
        this.gld.a(new a());
        this.glf = (TextView) addCustomView.findViewById(e.g.person_center_navigation_title);
        this.glg = (TextView) addCustomView.findViewById(e.g.person_center_navigation_another_title);
        if (!this.gbq) {
            this.cLq.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.ggF.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gkY = new n(this.mContext, this.mIsHost);
        this.glk = LayoutInflater.from(this.mContext.getPageActivity()).inflate(e.h.view_header_expand, (ViewGroup) null);
        this.ggF.addHeaderView(this.glk);
        this.ggF.setExpandView(this.glk);
        this.ggF.addHeaderView(this.gkY.aiP());
        this.glo = new k(this.mContext);
        this.ggF.addHeaderView(this.glo.aiP());
        if (!this.mIsHost) {
            this.glb.setText(e.j.ta_homepage);
            this.gll = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.ggF.addHeaderView(this.gll);
        } else {
            this.glb.setText(e.j.my_homepage);
        }
        this.ggF.setPersonListRefreshListener(this.glt);
        this.glh = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.ggF, this.asU);
        this.glh.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.glc.setAlpha(0.0f);
        this.gkX.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ghg == null) {
            this.gkX.c(1.0f, true);
            al.c(this.cLq, e.f.selector_topbar_return_black);
        } else {
            bmj();
        }
        al.h(this.glb, e.d.cp_cont_i);
        this.glc.onChangeSkinType(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)));
        if (this.gkX != null) {
            this.gkX.onChangeSkinType(i);
        }
        this.bBq.onChangeSkinType(this.mContext, i);
        this.cYn.onChangeSkinType(this.mContext, i);
        if (this.gkY != null) {
            this.gkY.onChangeSkinType(i);
        }
        if (this.ggF != null && (this.ggF.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.ggF.getAdapter().notifyDataSetChanged();
        }
        this.bBr.dM(i);
        al.i(this.mRootView, e.d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.glg, e.d.cp_cont_b, e.d.s_navbar_title_color);
            al.b(this.glf, e.d.cp_cont_i, e.d.cp_cont_i);
        }
        if (this.gll != null) {
            this.gll.onChangeSkinType(i);
        }
        if (this.glo != null) {
            this.glo.onChangeSkinType(i);
        }
    }

    public void lJ(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.cLq, e.f.selector_topbar_return_black);
            this.gkX.c(1.0f, true);
            this.glb.setAlpha(0.0f);
            this.glc.setAlpha(1.0f);
            this.ggF.setSelectionFromTop(this.ggF.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.cLq, e.f.selector_topbar_return_white);
        this.gkX.c(0.0f, false);
        this.glb.setAlpha(1.0f);
        this.glc.setAlpha(0.0f);
    }

    public void blv() {
        this.glj = false;
        if (this.cuA == 0) {
            if (com.baidu.adp.lib.util.j.kK()) {
                this.gkZ.resetData();
                this.gkZ.refreshData();
                this.ggT.ot();
                return;
            }
            this.ggT.aCn();
        } else if (this.cuA == 1) {
            if (com.baidu.adp.lib.util.j.kK()) {
                this.gkZ.g(true, true, true);
                this.ggT.ot();
                return;
            }
            this.ggT.aCn();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gkl = gVar;
        this.gkX.setOnViewResponseListener(gVar);
        this.cLq.setOnClickListener(this.aKh);
        this.gkY.setOnViewResponseListener(gVar);
        if (this.ggT != null) {
            this.ggT.a(this.glk, gVar);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.glh != null) {
            this.glh.O(onClickListener);
        }
    }

    public void lB(boolean z) {
        this.glm = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.cLq, e.f.selector_topbar_return_black);
        } else {
            al.c(this.cLq, e.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cLq.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.glf.setAlpha(1.0f - f);
            this.glg.setAlpha(f);
        }
    }

    public void at(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dd(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lJ(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ghg = aVar;
            this.gkX.e(this.ghg.getUserData());
            if (this.glj) {
                dd(aVar.aIc());
                if (this.bBr != null) {
                    this.bBr.BJ();
                    return;
                }
                return;
            }
            this.gkX.blm();
            this.gkY.e(aVar);
            this.glc.setPortraitUrl(com.baidu.tbadk.core.util.o.eN(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.glc.bmd();
            } else {
                this.ghg.getUserData().setIsLike(this.ghg.getUserData().getHave_attention() == 1);
                this.gld.a(this.ghg.getUserData());
            }
            if ((aVar.blW() == null || this.mIsHost) && v.z(aVar.blX())) {
                this.ggF.removeHeaderView(this.glo.aiP());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.glo.a(aVar.blW(), this.mIsHost, this.ghg.getUserData(), aVar.blX());
            }
            if (!this.mIsHost) {
                if (aVar.blY() == null || aVar.blY().gin == null || aVar.blY().gin.size() <= 0) {
                    this.ggF.removeHeaderView(this.gll);
                } else {
                    this.gll.a(aVar.blY());
                }
            }
            if (v.z(aVar.aIc())) {
                dd(null);
                this.ggT.Wd();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(e.j.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.brf().mk(this.mIsHost);
            dd(aVar.aIc());
            int size = aVar.aIc().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aIc().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ggT.Wd();
                    return;
                }
            }
            if (z) {
                if (this.bBr != null) {
                    this.bBr.BJ();
                    return;
                }
                return;
            }
            this.ggT.c(true, aVar.aIc());
        }
    }

    public void aCn() {
        this.ggT.aCn();
    }

    private void w(TbPageContext tbPageContext) {
        this.gli = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gDP;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gkY != null && p.this.gkY.gkt != null) {
                            p.this.gkY.gkt.nG(aVar.fco);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.ghg != null) {
                            if (p.this.ghg.gic != null && p.this.ghg.gic.daW != null && aVar2 != null) {
                                p.this.ghg.gic.daW.putBoolean("person_center_item_red_tip_show", aVar2.fco);
                            }
                            if (aVar3 != null && p.this.ghg.gib != null && p.this.ghg.gib.daW != null) {
                                p.this.ghg.gib.daW.putBoolean("person_center_item_red_tip_show", aVar3.fco);
                            }
                            if (aVar4 != null && p.this.ghg.ghZ != null && p.this.ghg.ghZ.daW != null) {
                                p.this.ghg.ghZ.daW.putBoolean("person_center_item_red_tip_show", aVar4.fco);
                            }
                            if (aVar5 != null && p.this.ghg.gie != null && p.this.ghg.gie.daW != null) {
                                p.this.ghg.gie.daW.putBoolean("person_center_item_red_tip_show", aVar5.fco);
                            }
                            if (aVar6 != null && p.this.ghg.gif != null && p.this.ghg.gif.daW != null) {
                                p.this.ghg.gif.daW.putBoolean("person_center_item_red_tip_show", aVar6.fco);
                                p.this.ghg.gif.daW.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gkX instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gkX.C(5, aVar7.fco);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gkX.C(6, aVar8.fco);
                            }
                        }
                    }
                }
            }
        };
        this.gli.setTag(this.asU);
        tbPageContext.registerListener(this.gli);
        this.gbF = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    p.this.gkY.sJ(jVar.uW());
                }
            }
        };
        this.gbF.setTag(this.asU);
        tbPageContext.registerListener(this.gbF);
    }

    public void onDestory() {
        if (this.gkY != null) {
            this.gkY.onDestory();
        }
    }

    public com.baidu.tieba.view.f bmi() {
        return this.gkX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void bj(boolean z) {
            if (z) {
                if (p.this.dsF == null) {
                    p.this.dsF = new com.baidu.tbadk.i.a(p.this.mContext);
                }
                if (p.this.gld.Cg() != null && !StringUtils.isNull(p.this.gld.Cg().getUserId())) {
                    p.this.dsF.ht(p.this.gld.Cg().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(e.j.unlike_success)).yt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        aiE();
        aiF();
        bmk();
        if (this.gkY.aiP().getTop() + this.gle <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gkZ = aVar;
    }

    private void aiE() {
        if (Build.VERSION.SDK_INT >= 11 && this.gkY != null) {
            int top = this.gkY.aiP().getTop();
            if (top >= this.gkW) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gkW) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gkW));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aiF() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.csx) {
                    this.csx = true;
                }
            } else if (this.csx) {
                this.csx = false;
            }
            a(alpha, !this.csx);
            this.gkX.c(alpha, this.csx ? false : true);
        }
    }

    private void bmk() {
        if (Build.VERSION.SDK_INT >= 11 && this.gkY != null) {
            int i = this.gkW / 2;
            int i2 = this.gkW - i;
            int top = this.gkY.aiP().getTop();
            if (this.glb != null) {
                if (top < i) {
                    if (this.glb.getAlpha() != 0.0f) {
                        this.glb.setAlpha(0.0f);
                    }
                } else if (top < this.gkW && top >= i) {
                    if (i2 > 0) {
                        this.glb.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gkW && this.glb.getAlpha() != 1.0f) {
                    this.glb.setAlpha(1.0f);
                }
            }
            if (this.glc != null) {
                if (top >= i) {
                    if (this.glc.getAlpha() != 0.0f) {
                        this.glc.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.glc.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.glc.getAlpha() != 1.0f) {
                    this.glc.setAlpha(1.0f);
                }
            }
        }
    }

    public void dd(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.z(list)) {
            list = new ArrayList<>();
        }
        if (this.ggF.getVisibility() != 0) {
            this.ggF.setVisibility(0);
        }
        this.ggF.setData(list);
        int y = v.y(list);
        if (y >= 5) {
            if (this.glm) {
                lJ(true);
                this.glm = false;
            }
        } else if (y <= 1) {
            this.ggF.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gla = iVar;
    }

    public NavigationBar WW() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.ggF != null) {
            this.glp = str;
            this.gls = aVar;
            int headerViewsCount = (this.ggF.getHeaderViewsCount() + i) - this.ggF.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.glq = this.ggF.getChildAt(headerViewsCount);
                if (this.glq != null) {
                    this.glr = this.glq.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.glq.getLayoutParams().height = p.this.glr - ((int) (p.this.glr * f));
                            p.this.glq.requestLayout();
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
                            p.this.glq.setVisibility(8);
                            if (p.this.gls != null) {
                                p.this.gls.sF(p.this.glp);
                            }
                        }
                    });
                    animation.setDuration(gkV);
                    this.glq.startAnimation(animation);
                }
            }
        }
    }
}
