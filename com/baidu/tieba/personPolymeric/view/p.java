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
    public static int fZn = 300;
    private BdUniqueId aKh;
    private NoNetworkView btu;
    private PbListView btv;
    private ImageView cFd;
    private PluginErrorTipView cRP;
    private com.baidu.tbadk.h.a dhW;
    private boolean fPT;
    private CustomMessageListener fQh;
    public BdPersonListView fUU;
    private com.baidu.tieba.personPolymeric.b.d fVi;
    private com.baidu.tieba.personPolymeric.c.a fVw;
    private com.baidu.tieba.view.g fYD;
    private CustomMessageListener fZA;
    private View fZC;
    private PersonCenterAttentionBarListView fZD;
    private boolean fZE;
    private k fZG;
    private String fZH;
    private View fZI;
    private int fZJ;
    private i.a fZK;
    private int fZo;
    private com.baidu.tieba.view.f fZp;
    public n fZq;
    private com.baidu.tieba.model.a fZr;
    private com.baidu.tieba.view.i fZs;
    private TextView fZt;
    private LikeButtonWithHeadPortrait fZu;
    private com.baidu.tbadk.core.view.userLike.c fZv;
    private int fZw;
    private TextView fZx;
    private TextView fZy;
    private com.baidu.tieba.personPolymeric.a.n fZz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean ciE = true;
    private int cku = 0;
    private boolean fZB = false;
    private boolean fZF = false;
    View.OnClickListener aGc = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b fVe = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.fYD != null) {
                if (p.this.cFd == view) {
                    this.fVe.cUr = 8;
                }
                p.this.fYD.a(view, this.fVe);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.fZs != null) {
                p.this.fZs.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.fZs != null) {
                    p.this.fZs.onScroll(absListView, i, i2, i3);
                }
                p.this.bkN();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.btv != null && p.this.fZr != null) {
                p.this.fVi.rt(p.this.cku);
                if (p.this.cku == 0) {
                    p.this.btv.Ar();
                    p.this.fZr.h(false, false, false);
                } else if (p.this.cku == 1) {
                    p.this.btv.Ar();
                    p.this.fZr.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fZL = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bjY();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nm() {
            p.this.fVi.ayU();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.fVi.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fPT = false;
        this.mContext = tbPageContext;
        this.aKh = bdUniqueId;
        this.mIsHost = z;
        this.fPT = z2;
        this.fVi = eVar.bkh();
        this.btv = this.fVi.btv;
        this.fZo = com.baidu.adp.lib.util.l.e(this.mContext.getPageActivity(), d.e.tbds402);
        if (z) {
            this.fZp = new com.baidu.tieba.view.d(2);
            w(tbPageContext);
            return;
        }
        this.fZp = new com.baidu.tieba.personPolymeric.a();
    }

    public void Y(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0141d.cp_bg_line_c);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.cRP = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fUU = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fZp.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.fUU.setOnScrollListener(this.mOnScrollListener);
        this.fZw = this.mContext.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.cFd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.view_topbar_icon, (View.OnClickListener) null);
        if (this.cFd.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cFd.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds14);
            this.cFd.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fZt = (TextView) view.findViewById(d.g.tv_title_above_navigation_bar);
        this.fZu = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.fZv = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.fZu);
        this.fZv.setFromType("2");
        this.fZv.h(this.mContext.getUniqueId());
        this.fZv.a(new a());
        this.fZx = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.fZy = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fPT) {
            this.cFd.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fUU.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fZq = new n(this.mContext, this.mIsHost);
        this.fZC = LayoutInflater.from(this.mContext.getPageActivity()).inflate(d.i.view_header_expand, (ViewGroup) null);
        this.fUU.addHeaderView(this.fZC);
        this.fUU.setExpandView(this.fZC);
        this.fUU.addHeaderView(this.fZq.aga());
        this.fZG = new k(this.mContext);
        this.fUU.addHeaderView(this.fZG.aga());
        if (!this.mIsHost) {
            this.fZt.setText(d.k.ta_homepage);
            this.fZD = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.fUU.addHeaderView(this.fZD);
        } else {
            this.fZt.setText(d.k.my_homepage);
        }
        this.fUU.setPersonListRefreshListener(this.fZL);
        this.fZz = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.fUU, this.aKh);
        this.fZz.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fZu.setAlpha(0.0f);
        this.fZp.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fVw == null) {
            this.fZp.c(1.0f, true);
            al.c(this.cFd, d.f.selector_topbar_return_black);
        } else {
            bkN();
        }
        al.h(this.fZt, d.C0141d.cp_cont_i);
        this.fZu.onChangeSkinType(i);
        al.i(this.mRootView, d.C0141d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)));
        if (this.fZp != null) {
            this.fZp.onChangeSkinType(i);
        }
        this.btu.onChangeSkinType(this.mContext, i);
        this.cRP.onChangeSkinType(this.mContext, i);
        if (this.fZq != null) {
            this.fZq.onChangeSkinType(i);
        }
        if (this.fUU != null && (this.fUU.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.fUU.getAdapter().notifyDataSetChanged();
        }
        this.btv.dy(i);
        al.i(this.mRootView, d.C0141d.cp_bg_line_d);
        if (this.mIsHost) {
            al.b(this.fZy, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            al.b(this.fZx, d.C0141d.cp_cont_i, d.C0141d.cp_cont_i);
        }
        if (this.fZD != null) {
            this.fZD.onChangeSkinType(i);
        }
        if (this.fZG != null) {
            this.fZG.onChangeSkinType(i);
        }
    }

    public void lr(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.cFd, d.f.selector_topbar_return_black);
            this.fZp.c(1.0f, true);
            this.fZt.setAlpha(0.0f);
            this.fZu.setAlpha(1.0f);
            this.fUU.setSelectionFromTop(this.fUU.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.cFd, d.f.selector_topbar_return_white);
        this.fZp.c(0.0f, false);
        this.fZt.setAlpha(1.0f);
        this.fZu.setAlpha(0.0f);
    }

    public void bjY() {
        this.fZB = false;
        if (this.cku == 0) {
            if (com.baidu.adp.lib.util.j.jD()) {
                this.fZr.resetData();
                this.fZr.refreshData();
                this.fVi.nl();
                return;
            }
            this.fVi.ayU();
        } else if (this.cku == 1) {
            if (com.baidu.adp.lib.util.j.jD()) {
                this.fZr.h(true, true, true);
                this.fVi.nl();
                return;
            }
            this.fVi.ayU();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fYD = gVar;
        this.fZp.setOnViewResponseListener(gVar);
        this.cFd.setOnClickListener(this.aGc);
        this.fZq.setOnViewResponseListener(gVar);
        if (this.fVi != null) {
            this.fVi.a(this.fZC, gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fZz != null) {
            this.fZz.N(onClickListener);
        }
    }

    public void lj(boolean z) {
        this.fZE = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.cFd, d.f.selector_topbar_return_black);
        } else {
            al.c(this.cFd, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.cFd.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fZx.setAlpha(1.0f - f);
            this.fZy.setAlpha(f);
        }
    }

    public void ar(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        dc(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        lr(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fVw = aVar;
            this.fZp.e(this.fVw.getUserData());
            if (this.fZB) {
                dc(aVar.aEg());
                if (this.btv != null) {
                    this.btv.As();
                    return;
                }
                return;
            }
            this.fZp.bjP();
            this.fZq.e(aVar);
            this.fZu.setPortraitUrl(com.baidu.tbadk.core.util.p.eu(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fZu.bkG();
            } else {
                this.fVw.getUserData().setIsLike(this.fVw.getUserData().getHave_attention() == 1);
                this.fZv.a(this.fVw.getUserData());
            }
            if ((aVar.bkz() == null || this.mIsHost) && w.z(aVar.bkA())) {
                this.fUU.removeHeaderView(this.fZG.aga());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.fZG.a(aVar.bkz(), this.mIsHost, this.fVw.getUserData(), aVar.bkA());
            }
            if (!this.mIsHost) {
                if (aVar.bkB() == null || aVar.bkB().fWE == null || aVar.bkB().fWE.size() <= 0) {
                    this.fUU.removeHeaderView(this.fZD);
                } else {
                    this.fZD.a(aVar.bkB());
                }
            }
            if (w.z(aVar.aEg())) {
                dc(null);
                this.fVi.TL();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(d.k.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.bpq().lQ(this.mIsHost);
            dc(aVar.aEg());
            int size = aVar.aEg().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.h hVar = aVar.aEg().get(i);
                if (hVar != null && (hVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.fVi.TL();
                    return;
                }
            }
            if (z) {
                if (this.btv != null) {
                    this.btv.As();
                    return;
                }
                return;
            }
            this.fVi.b(true, aVar.aEg());
        }
    }

    public void ayU() {
        this.fVi.ayU();
    }

    private void w(TbPageContext tbPageContext) {
        this.fZA = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).grr;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.fZq != null && p.this.fZq.fYL != null) {
                            p.this.fZq.fYL.nn(aVar.eNm);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.fVw != null) {
                            if (p.this.fVw.fWu != null && p.this.fVw.fWu.cUs != null && aVar2 != null) {
                                p.this.fVw.fWu.cUs.putBoolean("person_center_item_red_tip_show", aVar2.eNm);
                            }
                            if (aVar3 != null && p.this.fVw.fWt != null && p.this.fVw.fWt.cUs != null) {
                                p.this.fVw.fWt.cUs.putBoolean("person_center_item_red_tip_show", aVar3.eNm);
                            }
                            if (aVar4 != null && p.this.fVw.fWr != null && p.this.fVw.fWr.cUs != null) {
                                p.this.fVw.fWr.cUs.putBoolean("person_center_item_red_tip_show", aVar4.eNm);
                            }
                            if (aVar5 != null && p.this.fVw.fWv != null && p.this.fVw.fWv.cUs != null) {
                                p.this.fVw.fWv.cUs.putBoolean("person_center_item_red_tip_show", aVar5.eNm);
                            }
                            if (aVar6 != null && p.this.fVw.fWw != null && p.this.fVw.fWw.cUs != null) {
                                p.this.fVw.fWw.cUs.putBoolean("person_center_item_red_tip_show", aVar6.eNm);
                                p.this.fVw.fWw.cUs.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.fZp instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.fZp.C(5, aVar7.eNm);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.fZp.C(6, aVar8.eNm);
                            }
                        }
                    }
                }
            }
        };
        this.fZA.setTag(this.aKh);
        tbPageContext.registerListener(this.fZA);
        this.fQh = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    p.this.fZq.sg(iVar.ub());
                }
            }
        };
        this.fQh.setTag(this.aKh);
        tbPageContext.registerListener(this.fQh);
    }

    public void onDestory() {
        if (this.fZq != null) {
            this.fZq.onDestory();
        }
    }

    public com.baidu.tieba.view.f bkM() {
        return this.fZp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aV(boolean z) {
            if (z) {
                if (p.this.dhW == null) {
                    p.this.dhW = new com.baidu.tbadk.h.a(p.this.mContext);
                }
                if (p.this.fZv.AO() != null && !StringUtils.isNull(p.this.fZv.AO().getUserId())) {
                    p.this.dhW.gX(p.this.fZv.AO().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(p.this.mContext.getPageActivity(), p.this.mContext.getString(d.k.unlike_success)).xi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkN() {
        afQ();
        afR();
        bkO();
        if (this.fZq.aga().getTop() + this.fZw <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fZr = aVar;
    }

    private void afQ() {
        if (Build.VERSION.SDK_INT >= 11 && this.fZq != null) {
            int top = this.fZq.aga().getTop();
            if (top >= this.fZo) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.fZo) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.fZo));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void afR() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.ciE) {
                    this.ciE = true;
                }
            } else if (this.ciE) {
                this.ciE = false;
            }
            a(alpha, !this.ciE);
            this.fZp.c(alpha, this.ciE ? false : true);
        }
    }

    private void bkO() {
        if (Build.VERSION.SDK_INT >= 11 && this.fZq != null) {
            int i = this.fZo / 2;
            int i2 = this.fZo - i;
            int top = this.fZq.aga().getTop();
            if (this.fZt != null) {
                if (top < i) {
                    if (this.fZt.getAlpha() != 0.0f) {
                        this.fZt.setAlpha(0.0f);
                    }
                } else if (top < this.fZo && top >= i) {
                    if (i2 > 0) {
                        this.fZt.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.fZo && this.fZt.getAlpha() != 1.0f) {
                    this.fZt.setAlpha(1.0f);
                }
            }
            if (this.fZu != null) {
                if (top >= i) {
                    if (this.fZu.getAlpha() != 0.0f) {
                        this.fZu.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.fZu.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.fZu.getAlpha() != 1.0f) {
                    this.fZu.setAlpha(1.0f);
                }
            }
        }
    }

    public void dc(List<com.baidu.adp.widget.ListView.h> list) {
        if (w.z(list)) {
            list = new ArrayList<>();
        }
        if (this.fUU.getVisibility() != 0) {
            this.fUU.setVisibility(0);
        }
        this.fUU.setData(list);
        int y = w.y(list);
        if (y >= 5) {
            if (this.fZE) {
                lr(true);
                this.fZE = false;
            }
        } else if (y <= 1) {
            this.fUU.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fZs = iVar;
    }

    public NavigationBar UB() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ao.isEmpty(str) && this.fUU != null) {
            this.fZH = str;
            this.fZK = aVar;
            int headerViewsCount = (this.fUU.getHeaderViewsCount() + i) - this.fUU.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.fZI = this.fUU.getChildAt(headerViewsCount);
                if (this.fZI != null) {
                    this.fZJ = this.fZI.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.fZI.getLayoutParams().height = p.this.fZJ - ((int) (p.this.fZJ * f));
                            p.this.fZI.requestLayout();
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
                            p.this.fZI.setVisibility(8);
                            if (p.this.fZK != null) {
                                p.this.fZK.sc(p.this.fZH);
                            }
                        }
                    });
                    animation.setDuration(fZn);
                    this.fZI.startAnimation(animation);
                }
            }
        }
    }
}
