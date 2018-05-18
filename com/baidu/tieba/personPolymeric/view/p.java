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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.n.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class p {
    public static int fOa = 300;
    private BdUniqueId aBL;
    private NoNetworkView blp;
    private PbListView blq;
    private PluginErrorTipView cII;
    private com.baidu.tbadk.h.a cYF;
    private ImageView cwA;
    private CustomMessageListener fEN;
    private boolean fEz;
    private com.baidu.tieba.personPolymeric.b.d fJN;
    public BdPersonListView fJz;
    private com.baidu.tieba.personPolymeric.c.a fKb;
    private com.baidu.tieba.view.g fNr;
    private int fOb;
    private com.baidu.tieba.view.f fOc;
    public n fOd;
    private com.baidu.tieba.model.a fOe;
    private com.baidu.tieba.view.i fOf;
    private TextView fOg;
    private LikeButtonWithHeadPortrait fOh;
    private com.baidu.tbadk.core.view.userLike.c fOi;
    private int fOj;
    private TextView fOk;
    private TextView fOl;
    private com.baidu.tieba.personPolymeric.a.n fOm;
    private CustomMessageListener fOn;
    private View fOp;
    private PersonCenterAttentionBarListView fOq;
    private boolean fOr;
    private k fOt;
    private String fOu;
    private View fOv;
    private int fOw;
    private i.a fOx;
    private com.baidu.tieba.write.c fOy;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean caA = true;
    private int ccq = 0;
    private boolean fOo = false;
    private boolean fOs = false;
    View.OnClickListener axH = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fJJ = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (p.this.fNr != null) {
                if (p.this.cwA == view2) {
                    this.fJJ.cLl = 8;
                }
                p.this.fNr.a(view2, this.fJJ);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.fOf != null) {
                p.this.fOf.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.fOf != null) {
                    p.this.fOf.onScroll(absListView, i, i2, i3);
                }
                p.this.bfO();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.blq != null && p.this.fOe != null) {
                p.this.fJN.rh(p.this.ccq);
                if (p.this.ccq == 0) {
                    p.this.blq.wQ();
                    p.this.fOe.h(false, false, false);
                } else if (p.this.ccq == 1) {
                    p.this.blq.wQ();
                    p.this.fOe.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fOz = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.beY();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void ky() {
            p.this.fJN.auK();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void D(float f) {
            p.this.fJN.C(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fEz = false;
        this.mContext = tbPageContext;
        this.aBL = bdUniqueId;
        this.mIsHost = z;
        this.fEz = z2;
        this.fJN = eVar.bfh();
        this.blq = this.fJN.blq;
        this.fOb = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.fOc = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.fOc = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view2) {
        this.mRootView = view2;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0126d.cp_bg_line_c);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cII = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fJz = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fOc.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.fJz.setOnScrollListener(this.mOnScrollListener);
        this.fOj = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cwA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.cwA.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cwA.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.cwA.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fOg = (TextView) view2.findViewById(d.g.tv_title_above_navigation_bar);
        this.fOh = (LikeButtonWithHeadPortrait) view2.findViewById(d.g.like_btn_with_head_portrait);
        this.fOi = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.fOh);
        this.fOi.setFromType("2");
        this.fOi.h(this.mContext.getUniqueId());
        this.fOi.a(new a());
        this.fOk = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.fOl = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fEz) {
            this.cwA.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fJz.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fOd = new n(this.mContext, this.mIsHost);
        this.fOp = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.view_header_expand, (ViewGroup) null);
        this.fJz.addHeaderView(this.fOp);
        this.fJz.setExpandView(this.fOp);
        this.fJz.addHeaderView(this.fOd.acD());
        this.fOt = new k(this.mContext);
        this.fJz.addHeaderView(this.fOt.acD());
        if (!this.mIsHost) {
            this.fOg.setText(d.k.ta_homepage);
            this.fOq = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.fJz.addHeaderView(this.fOq);
        } else {
            this.fOg.setText(d.k.my_homepage);
        }
        this.fJz.setPersonListRefreshListener(this.fOz);
        this.fOm = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.fJz, this.aBL);
        this.fOm.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fOh.setAlpha(0.0f);
        this.fOc.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fKb == null) {
            this.fOc.c(1.0f, true);
            ak.c(this.cwA, d.f.selector_topbar_return_black);
        } else {
            bfO();
        }
        ak.h(this.fOg, d.C0126d.cp_cont_i);
        this.fOh.onChangeSkinType(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)));
        if (this.fOc != null) {
            this.fOc.onChangeSkinType(i);
        }
        this.blp.onChangeSkinType(this.mContext, i);
        this.cII.onChangeSkinType(this.mContext, i);
        if (this.fOd != null) {
            this.fOd.onChangeSkinType(i);
        }
        if (this.fJz != null && (this.fJz.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fJz.getAdapter().notifyDataSetChanged();
        }
        this.blq.dw(i);
        ak.i(this.mRootView, d.C0126d.cp_bg_line_d);
        if (this.mIsHost) {
            ak.b(this.fOl, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            ak.b(this.fOk, d.C0126d.cp_cont_i, d.C0126d.cp_cont_i);
        }
        if (this.fOq != null) {
            this.fOq.onChangeSkinType(i);
        }
        if (this.fOt != null) {
            this.fOt.onChangeSkinType(i);
        }
    }

    public void ll(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            ak.c(this.cwA, d.f.selector_topbar_return_black);
            this.fOc.c(1.0f, true);
            this.fOg.setAlpha(0.0f);
            this.fOh.setAlpha(1.0f);
            this.fJz.setSelectionFromTop(this.fJz.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        ak.c(this.cwA, d.f.selector_topbar_return_white);
        this.fOc.c(0.0f, false);
        this.fOg.setAlpha(1.0f);
        this.fOh.setAlpha(0.0f);
    }

    public void beY() {
        this.fOo = false;
        if (this.ccq == 0) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fOe.resetData();
                this.fOe.refreshData();
                this.fJN.kx();
                return;
            }
            this.fJN.auK();
        } else if (this.ccq == 1) {
            if (com.baidu.adp.lib.util.j.gP()) {
                this.fOe.h(true, true, true);
                this.fJN.kx();
                return;
            }
            this.fJN.auK();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fNr = gVar;
        this.fOc.setOnViewResponseListener(gVar);
        this.cwA.setOnClickListener(this.axH);
        this.fOd.setOnViewResponseListener(gVar);
        if (this.fJN != null) {
            this.fJN.a(this.fOp, gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fOm != null) {
            this.fOm.N(onClickListener);
        }
    }

    public void ld(boolean z) {
        this.fOr = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            ak.c(this.cwA, d.f.selector_topbar_return_black);
        } else {
            ak.c(this.cwA, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cwA.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fOk.setAlpha(1.0f - f);
            this.fOl.setAlpha(f);
        }
    }

    public void ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        cX(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        ll(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fKb = aVar;
            this.fOc.e(this.fKb.getUserData());
            if (this.fOo) {
                cX(aVar.azl());
                if (this.blq != null) {
                    this.blq.wR();
                    return;
                }
                return;
            }
            this.fOc.beP();
            this.fOd.e(aVar);
            this.fOh.setPortraitUrl(com.baidu.tbadk.core.util.o.dU(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fOh.bfH();
            } else {
                this.fKb.getUserData().setIsLike(this.fKb.getUserData().getHave_attention() == 1);
                this.fOi.a(this.fKb.getUserData());
            }
            if ((aVar.bfA() == null || this.mIsHost) && v.w(aVar.bfB())) {
                this.fJz.removeHeaderView(this.fOt.acD());
            } else {
                TiebaStatic.log(new al("c12543"));
                this.fOt.a(aVar.bfA(), this.mIsHost, this.fKb.getUserData(), aVar.bfB());
            }
            if (!this.mIsHost) {
                if (aVar.bfC() == null || aVar.bfC().fLs == null || aVar.bfC().fLs.size() <= 0) {
                    this.fJz.removeHeaderView(this.fOq);
                } else {
                    this.fOq.a(aVar.bfC());
                }
            }
            if (v.w(aVar.azl())) {
                cX(null);
                this.fJN.Qn();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
                return;
            }
            com.baidu.tieba.n.a.bks().lK(this.mIsHost);
            cX(aVar.azl());
            int size = aVar.azl().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.azl().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fJN.Qn();
                    return;
                }
            }
            if (z) {
                if (this.blq != null) {
                    this.blq.wR();
                    return;
                }
                return;
            }
            this.fJN.b(true, aVar.azl());
        }
    }

    public void auK() {
        this.fJN.auK();
    }

    private void w(TbPageContext tbPageContext) {
        this.fOn = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.n.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.n.b) customResponsedMessage.getData()).gfX;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.fOd != null && p.this.fOd.fNz != null) {
                            p.this.fOd.fNz.ng(aVar.eBS);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fKb != null) {
                            if (p.this.fKb.fLi != null && p.this.fKb.fLi.cLm != null && aVar2 != null) {
                                p.this.fKb.fLi.cLm.putBoolean("person_center_item_red_tip_show", aVar2.eBS);
                            }
                            if (aVar3 != null && p.this.fKb.fLh != null && p.this.fKb.fLh.cLm != null) {
                                p.this.fKb.fLh.cLm.putBoolean("person_center_item_red_tip_show", aVar3.eBS);
                            }
                            if (aVar4 != null && p.this.fKb.fLf != null && p.this.fKb.fLf.cLm != null) {
                                p.this.fKb.fLf.cLm.putBoolean("person_center_item_red_tip_show", aVar4.eBS);
                            }
                            if (aVar5 != null && p.this.fKb.fLj != null && p.this.fKb.fLj.cLm != null) {
                                p.this.fKb.fLj.cLm.putBoolean("person_center_item_red_tip_show", aVar5.eBS);
                            }
                            if (aVar6 != null && p.this.fKb.fLk != null && p.this.fKb.fLk.cLm != null) {
                                p.this.fKb.fLk.cLm.putBoolean("person_center_item_red_tip_show", aVar6.eBS);
                                p.this.fKb.fLk.cLm.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.fOc instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.fOc.C(5, aVar7.eBS);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.fOc.C(6, aVar8.eBS);
                            }
                        }
                    }
                }
            }
        };
        this.fOn.setTag(this.aBL);
        tbPageContext.registerListener(this.fOn);
        this.fEN = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.h hVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.h) && (hVar = (com.baidu.tbadk.data.h) customResponsedMessage.getData()) != null) {
                    p.this.fOd.rp(hVar.qF());
                }
            }
        };
        this.fEN.setTag(this.aBL);
        tbPageContext.registerListener(this.fEN);
    }

    public void onDestory() {
        if (this.fOd != null) {
            this.fOd.onDestory();
        }
    }

    public com.baidu.tieba.view.f bfN() {
        return this.fOc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aR(boolean z) {
            if (z) {
                if (p.this.cYF == null) {
                    p.this.cYF = new com.baidu.tbadk.h.a(p.this.mContext);
                }
                if (p.this.fOi.xn() != null && !StringUtils.isNull(p.this.fOi.xn().getUserId())) {
                    p.this.cYF.gz(p.this.fOi.xn().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.k.unlike_success)).tK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfO() {
        act();
        acu();
        bfP();
        if (this.fOd.acD().getTop() + this.fOj <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fOe = aVar;
    }

    private void act() {
        if (Build.VERSION.SDK_INT >= 11 && this.fOd != null) {
            int top = this.fOd.acD().getTop();
            if (top >= this.fOb) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.fOb) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.fOb));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void acu() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.caA) {
                    this.caA = true;
                }
            } else if (this.caA) {
                this.caA = false;
            }
            a(alpha, !this.caA);
            this.fOc.c(alpha, this.caA ? false : true);
        }
    }

    private void bfP() {
        if (Build.VERSION.SDK_INT >= 11 && this.fOd != null) {
            int i = this.fOb / 2;
            int i2 = this.fOb - i;
            int top = this.fOd.acD().getTop();
            if (this.fOg != null) {
                if (top < i) {
                    if (this.fOg.getAlpha() != 0.0f) {
                        this.fOg.setAlpha(0.0f);
                    }
                } else if (top < this.fOb && top >= i) {
                    if (i2 > 0) {
                        this.fOg.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.fOb && this.fOg.getAlpha() != 1.0f) {
                    this.fOg.setAlpha(1.0f);
                }
            }
            if (this.fOh != null) {
                if (top >= i) {
                    if (this.fOh.getAlpha() != 0.0f) {
                        this.fOh.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.fOh.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.fOh.getAlpha() != 1.0f) {
                    this.fOh.setAlpha(1.0f);
                }
            }
        }
    }

    public void cX(List<com.baidu.adp.widget.ListView.h> list) {
        if (v.w(list)) {
            list = new ArrayList<>();
        }
        if (this.fJz.getVisibility() != 0) {
            this.fJz.setVisibility(0);
        }
        this.fJz.setData(list);
        int v = v.v(list);
        if (v >= 5) {
            if (this.fOr) {
                ll(true);
                this.fOr = false;
            }
        } else if (v <= 1) {
            this.fJz.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fOf = iVar;
    }

    public NavigationBar Rd() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!an.isEmpty(str) && this.fJz != null) {
            this.fOu = str;
            this.fOx = aVar;
            int headerViewsCount = (this.fJz.getHeaderViewsCount() + i) - this.fJz.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.fOv = this.fJz.getChildAt(headerViewsCount);
                if (this.fOv != null) {
                    this.fOw = this.fOv.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.fOv.getLayoutParams().height = p.this.fOw - ((int) (p.this.fOw * f));
                            p.this.fOv.requestLayout();
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
                            p.this.fOv.setVisibility(8);
                            if (p.this.fOx != null) {
                                p.this.fOx.rl(p.this.fOu);
                            }
                        }
                    });
                    animation.setDuration(fOa);
                    this.fOv.startAnimation(animation);
                }
            }
        }
    }

    public void bfQ() {
        if (this.fOy == null) {
            if (this.mRootView instanceof ViewGroup) {
                this.fOy = new com.baidu.tieba.write.c(this.mContext, (ViewGroup) this.mRootView, "main_tab");
                this.fOy.uG("3");
            } else {
                return;
            }
        }
        this.fOy.nl(false);
    }
}
