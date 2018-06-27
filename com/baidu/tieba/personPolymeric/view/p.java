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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes3.dex */
public class p {
    public static int gdn = 300;
    private BdUniqueId aqU;
    private NoNetworkView buT;
    private PbListView buU;
    private ImageView cCW;
    private PluginErrorTipView cPN;
    private com.baidu.tbadk.h.a djU;
    private boolean fTV;
    private CustomMessageListener fUj;
    public BdPersonListView fYW;
    private com.baidu.tieba.personPolymeric.b.d fZk;
    private com.baidu.tieba.personPolymeric.c.a fZy;
    private com.baidu.tieba.view.g gcD;
    private CustomMessageListener gdA;
    private View gdC;
    private PersonCenterAttentionBarListView gdD;
    private boolean gdE;
    private k gdG;
    private String gdH;
    private View gdI;
    private int gdJ;
    private i.a gdK;
    private int gdo;
    private com.baidu.tieba.view.f gdp;
    public n gdq;
    private com.baidu.tieba.model.a gdr;
    private com.baidu.tieba.view.i gds;
    private TextView gdt;
    private LikeButtonWithHeadPortrait gdu;
    private com.baidu.tbadk.core.view.userLike.c gdv;
    private int gdw;
    private TextView gdx;
    private TextView gdy;
    private com.baidu.tieba.personPolymeric.a.n gdz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean ckU = true;
    private int cmY = 0;
    private boolean gdB = false;
    private boolean gdF = false;
    View.OnClickListener aGU = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fZg = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.gcD != null) {
                if (p.this.cCW == view) {
                    this.fZg.cSt = 8;
                }
                p.this.gcD.a(view, this.fZg);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.gds != null) {
                p.this.gds.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.gds != null) {
                    p.this.gds.onScroll(absListView, i, i2, i3);
                }
                p.this.blr();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.buU != null && p.this.gdr != null) {
                p.this.fZk.rC(p.this.cmY);
                if (p.this.cmY == 0) {
                    p.this.buU.AH();
                    p.this.gdr.h(false, false, false);
                } else if (p.this.cmY == 1) {
                    p.this.buU.AH();
                    p.this.gdr.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a gdL = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bkD();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nm() {
            p.this.fZk.azA();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.fZk.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fTV = false;
        this.mContext = tbPageContext;
        this.aqU = bdUniqueId;
        this.mIsHost = z;
        this.fTV = z2;
        this.fZk = eVar.bkM();
        this.buU = this.fZk.buU;
        this.gdo = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.gdp = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.gdp = new com.baidu.tieba.personPolymeric.a();
    }

    public void W(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0142d.cp_bg_line_c);
        this.buT = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cPN = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fYW = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.gdp.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.fYW.setOnScrollListener(this.mOnScrollListener);
        this.gdw = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cCW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.cCW.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cCW.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.cCW.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.item_person_center_navigation_title, (View.OnClickListener) null);
        this.gdt = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.gdu = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.gdv = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.gdu);
        this.gdv.setFromType("2");
        this.gdv.h(this.mContext.getUniqueId());
        this.gdv.a(new a());
        this.gdx = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.gdy = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fTV) {
            this.cCW.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fYW.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.gdq = new n(this.mContext, this.mIsHost);
        this.gdC = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.view_header_expand, (ViewGroup) null);
        this.fYW.addHeaderView(this.gdC);
        this.fYW.setExpandView(this.gdC);
        this.fYW.addHeaderView(this.gdq.agG());
        this.gdG = new k(this.mContext);
        this.fYW.addHeaderView(this.gdG.agG());
        if (!this.mIsHost) {
            this.gdt.setText(d.k.ta_homepage);
            this.gdD = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.fYW.addHeaderView(this.gdD);
        } else {
            this.gdt.setText(d.k.my_homepage);
        }
        this.fYW.setPersonListRefreshListener(this.gdL);
        this.gdz = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.fYW, this.aqU);
        this.gdz.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.gdu.setAlpha(0.0f);
        this.gdp.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fZy == null) {
            this.gdp.c(1.0f, true);
            am.c(this.cCW, d.f.selector_topbar_return_black);
        } else {
            blr();
        }
        am.h(this.gdt, d.C0142d.cp_cont_i);
        this.gdu.onChangeSkinType(i);
        am.i(this.mRootView, d.C0142d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)));
        if (this.gdp != null) {
            this.gdp.onChangeSkinType(i);
        }
        this.buT.onChangeSkinType(this.mContext, i);
        this.cPN.onChangeSkinType(this.mContext, i);
        if (this.gdq != null) {
            this.gdq.onChangeSkinType(i);
        }
        if (this.fYW != null && (this.fYW.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fYW.getAdapter().notifyDataSetChanged();
        }
        this.buU.dz(i);
        am.i(this.mRootView, d.C0142d.cp_bg_line_d);
        if (this.mIsHost) {
            am.b(this.gdy, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
            am.b(this.gdx, d.C0142d.cp_cont_i, d.C0142d.cp_cont_i);
        }
        if (this.gdD != null) {
            this.gdD.onChangeSkinType(i);
        }
        if (this.gdG != null) {
            this.gdG.onChangeSkinType(i);
        }
    }

    public void lB(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            am.c(this.cCW, d.f.selector_topbar_return_black);
            this.gdp.c(1.0f, true);
            this.gdt.setAlpha(0.0f);
            this.gdu.setAlpha(1.0f);
            this.fYW.setSelectionFromTop(this.fYW.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        am.c(this.cCW, d.f.selector_topbar_return_white);
        this.gdp.c(0.0f, false);
        this.gdt.setAlpha(1.0f);
        this.gdu.setAlpha(0.0f);
    }

    public void bkD() {
        this.gdB = false;
        if (this.cmY == 0) {
            if (com.baidu.adp.lib.util.j.jD()) {
                this.gdr.resetData();
                this.gdr.refreshData();
                this.fZk.nl();
                return;
            }
            this.fZk.azA();
        } else if (this.cmY == 1) {
            if (com.baidu.adp.lib.util.j.jD()) {
                this.gdr.h(true, true, true);
                this.fZk.nl();
                return;
            }
            this.fZk.azA();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.gcD = gVar;
        this.gdp.setOnViewResponseListener(gVar);
        this.cCW.setOnClickListener(this.aGU);
        this.gdq.setOnViewResponseListener(gVar);
        if (this.fZk != null) {
            this.fZk.a(this.gdC, gVar);
        }
    }

    public void R(View.OnClickListener onClickListener) {
        if (this.gdz != null) {
            this.gdz.R(onClickListener);
        }
    }

    public void lt(boolean z) {
        this.gdE = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            am.c(this.cCW, d.f.selector_topbar_return_black);
        } else {
            am.c(this.cCW, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cCW.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.gdx.setAlpha(1.0f - f);
            this.gdy.setAlpha(f);
        }
    }

    public void av(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dg(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lB(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fZy = aVar;
            this.gdp.e(this.fZy.getUserData());
            if (this.gdB) {
                dg(aVar.aEQ());
                if (this.buU != null) {
                    this.buU.AI();
                    return;
                }
                return;
            }
            this.gdp.bkv();
            this.gdq.e(aVar);
            this.gdu.setPortraitUrl(com.baidu.tbadk.core.util.p.ex(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.gdu.bll();
            } else {
                this.fZy.getUserData().setIsLike(this.fZy.getUserData().getHave_attention() == 1);
                this.gdv.a(this.fZy.getUserData());
            }
            if ((aVar.ble() == null || this.mIsHost) && w.A(aVar.blf())) {
                this.fYW.removeHeaderView(this.gdG.agG());
            } else {
                TiebaStatic.log(new an("c12543"));
                this.gdG.a(aVar.ble(), this.mIsHost, this.fZy.getUserData(), aVar.blf());
            }
            if (!this.mIsHost) {
                if (aVar.blg() == null || aVar.blg().gaE == null || aVar.blg().gaE.size() <= 0) {
                    this.fYW.removeHeaderView(this.gdD);
                } else {
                    this.gdD.a(aVar.blg());
                }
            }
            if (w.A(aVar.aEQ())) {
                dg(null);
                this.fZk.Uf();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bpR().ma(this.mIsHost);
            dg(aVar.aEQ());
            int size = aVar.aEQ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aEQ().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fZk.Uf();
                    return;
                }
            }
            if (z) {
                if (this.buU != null) {
                    this.buU.AI();
                    return;
                }
                return;
            }
            this.fZk.c(true, aVar.aEQ());
        }
    }

    public void azA() {
        this.fZk.azA();
    }

    private void w(TbPageContext tbPageContext) {
        this.gdA = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).gvi;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.gdq != null && p.this.gdq.gcL != null) {
                            p.this.gdq.gcL.nv(aVar.eRd);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fZy != null) {
                            if (p.this.fZy.gau != null && p.this.fZy.gau.cSu != null && aVar2 != null) {
                                p.this.fZy.gau.cSu.putBoolean("person_center_item_red_tip_show", aVar2.eRd);
                            }
                            if (aVar3 != null && p.this.fZy.gat != null && p.this.fZy.gat.cSu != null) {
                                p.this.fZy.gat.cSu.putBoolean("person_center_item_red_tip_show", aVar3.eRd);
                            }
                            if (aVar4 != null && p.this.fZy.gar != null && p.this.fZy.gar.cSu != null) {
                                p.this.fZy.gar.cSu.putBoolean("person_center_item_red_tip_show", aVar4.eRd);
                            }
                            if (aVar5 != null && p.this.fZy.gav != null && p.this.fZy.gav.cSu != null) {
                                p.this.fZy.gav.cSu.putBoolean("person_center_item_red_tip_show", aVar5.eRd);
                            }
                            if (aVar6 != null && p.this.fZy.gaw != null && p.this.fZy.gaw.cSu != null) {
                                p.this.fZy.gaw.cSu.putBoolean("person_center_item_red_tip_show", aVar6.eRd);
                                p.this.fZy.gaw.cSu.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.gdp instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.gdp.C(5, aVar7.eRd);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.gdp.C(6, aVar8.eRd);
                            }
                        }
                    }
                }
            }
        };
        this.gdA.setTag(this.aqU);
        tbPageContext.registerListener(this.gdA);
        this.fUj = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    p.this.gdq.sf(iVar.uh());
                }
            }
        };
        this.fUj.setTag(this.aqU);
        tbPageContext.registerListener(this.fUj);
    }

    public void onDestory() {
        if (this.gdq != null) {
            this.gdq.onDestory();
        }
    }

    public com.baidu.tieba.view.f blq() {
        return this.gdp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aY(boolean z) {
            if (z) {
                if (p.this.djU == null) {
                    p.this.djU = new com.baidu.tbadk.h.a(p.this.mContext);
                }
                if (p.this.gdv.Bg() != null && !StringUtils.isNull(p.this.gdv.Bg().getUserId())) {
                    p.this.djU.hb(p.this.gdv.Bg().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.k.unlike_success)).xv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blr() {
        agv();
        agw();
        bls();
        if (this.gdq.agG().getTop() + this.gdw <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.gdr = aVar;
    }

    private void agv() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdq != null) {
            int top = this.gdq.agG().getTop();
            if (top >= this.gdo) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.gdo) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.gdo));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void agw() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.ckU) {
                    this.ckU = true;
                }
            } else if (this.ckU) {
                this.ckU = false;
            }
            a(alpha, !this.ckU);
            this.gdp.c(alpha, this.ckU ? false : true);
        }
    }

    private void bls() {
        if (Build.VERSION.SDK_INT >= 11 && this.gdq != null) {
            int i = this.gdo / 2;
            int i2 = this.gdo - i;
            int top = this.gdq.agG().getTop();
            if (this.gdt != null) {
                if (top < i) {
                    if (this.gdt.getAlpha() != 0.0f) {
                        this.gdt.setAlpha(0.0f);
                    }
                } else if (top < this.gdo && top >= i) {
                    if (i2 > 0) {
                        this.gdt.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.gdo && this.gdt.getAlpha() != 1.0f) {
                    this.gdt.setAlpha(1.0f);
                }
            }
            if (this.gdu != null) {
                if (top >= i) {
                    if (this.gdu.getAlpha() != 0.0f) {
                        this.gdu.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.gdu.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.gdu.getAlpha() != 1.0f) {
                    this.gdu.setAlpha(1.0f);
                }
            }
        }
    }

    public void dg(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.A(list)) {
            list = new ArrayList<>();
        }
        if (this.fYW.getVisibility() != 0) {
            this.fYW.setVisibility(0);
        }
        this.fYW.setData(list);
        int z = w.z(list);
        if (z >= 5) {
            if (this.gdE) {
                lB(true);
                this.gdE = false;
            }
        } else if (z <= 1) {
            this.fYW.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.gds = iVar;
    }

    public NavigationBar UW() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.fYW != null) {
            this.gdH = str;
            this.gdK = aVar;
            int headerViewsCount = (this.fYW.getHeaderViewsCount() + i) - this.fYW.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.gdI = this.fYW.getChildAt(headerViewsCount);
                if (this.gdI != null) {
                    this.gdJ = this.gdI.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.gdI.getLayoutParams().height = p.this.gdJ - ((int) (p.this.gdJ * f));
                            p.this.gdI.requestLayout();
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
                            p.this.gdI.setVisibility(8);
                            if (p.this.gdK != null) {
                                p.this.gdK.sb(p.this.gdH);
                            }
                        }
                    });
                    animation.setDuration(gdn);
                    this.gdI.startAnimation(animation);
                }
            }
        }
    }
}
