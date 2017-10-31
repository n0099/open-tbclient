package com.baidu.tieba.personPolymeric.view;

import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.userLike.c;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.view.PersonTabView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    private BdUniqueId aAc;
    private TbPageContext abI;
    private ImageView bYu;
    private NoNetworkView bgD;
    private PbListView bgE;
    private PluginErrorTipView ckc;
    private com.baidu.tbadk.i.a cxT;
    private boolean fhU;
    private CustomMessageListener fik;
    private com.baidu.tieba.personPolymeric.c.a fnJ;
    public BdPersonListView fni;
    private PersonTabView fnp;
    private com.baidu.tieba.personPolymeric.b.d fnv;
    private com.baidu.tieba.personPolymeric.a.o fok;
    private com.baidu.tieba.view.g frJ;
    public r frK;
    private com.baidu.tieba.model.a frL;
    private com.baidu.tieba.view.j frM;
    private PersonTabView frN;
    private LikeButtonWithHeadPortrait frO;
    private com.baidu.tbadk.core.view.userLike.c frP;
    private int frQ;
    private TextView frR;
    private TextView frS;
    private CustomMessageListener frT;
    private com.baidu.tieba.person.data.f frU;
    private View frW;
    private m frX;
    private boolean frY;
    private com.baidu.tieba.view.h frg;
    private l fsb;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bIo = true;
    private int bKb = 0;
    private boolean frV = false;
    private boolean frZ = false;
    private boolean fsa = false;
    View.OnClickListener auz = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.t.1
        com.baidu.tieba.personPolymeric.event.a fnr = new com.baidu.tieba.personPolymeric.event.a();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (t.this.frg != null) {
                if (t.this.bYu == view) {
                    this.fnr.cmb = 8;
                }
                t.this.frg.a(view, this.fnr);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.t.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (t.this.frM != null) {
                t.this.frM.onScrollStateChanged(absListView, i);
            }
            if (i == 0 && t.this.fnp.getVisibility() == 0 && t.this.frN.getTop() > t.this.mNavigationBar.getBottom()) {
                t.this.fnp.setVisibility(8);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2) {
                if (t.this.frM != null) {
                    t.this.frM.onScroll(absListView, i, i2, i3);
                }
                if (t.this.frK != null && t.this.frK.Yb() != null) {
                    int dimensionPixelSize = t.this.abI.getResources().getDimensionPixelSize(d.e.ds320);
                    int top = t.this.frK.Yb().getTop();
                    if (!t.this.fsa && top != dimensionPixelSize) {
                        t.this.fsa = true;
                    }
                }
                t.this.bao();
            }
        }
    };
    private PersonTabView.a fsc = new PersonTabView.a() { // from class: com.baidu.tieba.personPolymeric.view.t.5
        @Override // com.baidu.tieba.personPolymeric.view.PersonTabView.a
        public void qI(int i) {
            t.this.frN.setCurrentTab(i);
            t.this.fnp.setCurrentTab(i);
            t.this.qH(i);
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.t.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (t.this.bgE != null && t.this.frL != null) {
                t.this.fnv.qD(t.this.bKb);
                if (t.this.bKb == 0) {
                    t.this.bgE.wt();
                    t.this.frL.h(false, false, false);
                } else if (t.this.bKb == 1) {
                    t.this.bgE.wt();
                    t.this.frL.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fsd = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.t.7
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kW() {
            t.this.aZv();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kV() {
            t.this.fnv.aoi();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void v(float f) {
            t.this.fnv.u(f);
        }
    };

    public t(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fhU = false;
        this.abI = tbPageContext;
        this.aAc = bdUniqueId;
        this.mIsHost = z;
        this.fhU = z2;
        this.fnv = eVar.aZG();
        this.bgE = this.fnv.bgE;
        if (z) {
            this.frJ = new com.baidu.tieba.view.e(2);
            y(tbPageContext);
            return;
        }
        this.frJ = new com.baidu.tieba.view.d();
    }

    public void Z(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0080d.cp_bg_line_c);
        this.bgD = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.ckc = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fni = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        this.frN = new PersonTabView(this.abI.getPageActivity());
        this.frN.setOnTabSelectListener(this.fsc);
        this.fnp = (PersonTabView) this.mRootView.findViewById(d.g.person_center_sticky_person_buttom_header);
        this.fnp.setOnTabSelectListener(this.fsc);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.abI.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.frJ.a(this.abI.getPageActivity(), this.mNavigationBar);
        this.fni.setOnScrollListener(this.mOnScrollListener);
        this.frQ = this.abI.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bYu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.bYu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bYu.getLayoutParams();
            layoutParams2.leftMargin = this.abI.getResources().getDimensionPixelSize(d.e.ds14);
            this.bYu.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.frO = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.frP = new com.baidu.tbadk.core.view.userLike.c(this.abI, this.frO);
        this.frP.setFromType("2");
        this.frP.h(this.abI.getUniqueId());
        this.frP.a(new a());
        this.frR = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.frS = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fhU) {
            this.bYu.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fni.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.frK = new r(this.abI, this.mIsHost);
        this.frW = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.fni.addHeaderView(this.frW);
        this.fni.setExpandView(this.frW);
        this.fni.addHeaderView(this.frK.Yb());
        this.fsb = new l(this.abI);
        this.fni.addHeaderView(this.fsb.Yb());
        if (!this.mIsHost) {
            this.frX = new m(this.abI.getPageActivity());
            this.fni.addHeaderView(this.frX);
        }
        this.fni.addHeaderView(this.frN);
        this.fni.setPersonListRefreshListener(this.fsd);
        this.fok = new com.baidu.tieba.personPolymeric.a.o(this.abI, this.fni, this.aAc);
        this.fok.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.frO.setAlpha(0.0f);
        this.fnp.setVisibility(8);
        this.frJ.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fnJ == null) {
            this.frJ.c(1.0f, true);
            aj.c(this.bYu, d.f.selector_topbar_return_black);
        } else {
            bao();
        }
        this.frN.onChangeSkinType();
        this.fnp.onChangeSkinType();
        this.frO.onChangeSkinType(i);
        aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cS(d.f.s_navbar_bg)));
        if (this.frJ != null) {
            this.frJ.onChangeSkinType(i);
        }
        this.bgD.onChangeSkinType(this.abI, i);
        this.ckc.onChangeSkinType(this.abI, i);
        if (this.frK != null) {
            this.frK.onChangeSkinType(i);
        }
        if (this.fni != null && (this.fni.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fni.getAdapter()).notifyDataSetChanged();
        }
        this.bgE.dz(i);
        aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
        if (this.mIsHost) {
            aj.b(this.frS, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color);
            aj.b(this.frR, d.C0080d.cp_cont_i, d.C0080d.cp_cont_i);
        }
        if (this.frX != null) {
            this.frX.onChangeSkinType(i);
        }
        if (this.fsb != null) {
            this.fsb.onChangeSkinType(i);
        }
    }

    public void kj(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.bYu, d.f.selector_topbar_return_black);
            this.frJ.c(1.0f, true);
            this.frO.setAlpha(1.0f);
            this.fnp.setVisibility(0);
            this.fni.setSelectionFromTop(this.fni.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.bYu, d.f.selector_topbar_return_white);
        this.frJ.c(0.0f, false);
        this.frO.setAlpha(0.0f);
        this.fnp.setVisibility(8);
    }

    public void aZv() {
        this.frV = false;
        if (this.bKb == 0) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.frL.resetData();
                this.frL.refreshData();
                this.fnv.kU();
                return;
            }
            this.fnv.aoi();
        } else if (this.bKb == 1) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.frL.h(true, true, true);
                this.fnv.kU();
                return;
            }
            this.fnv.aoi();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frg = hVar;
        this.frJ.setOnViewResponseListener(hVar);
        this.bYu.setOnClickListener(this.auz);
        this.frK.setOnViewResponseListener(hVar);
        if (this.fnv != null) {
            this.fnv.a(this.frW, hVar);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.fok != null) {
            this.fok.K(onClickListener);
        }
    }

    public void setList(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
        this.fok.cE(list);
    }

    public void kc(boolean z) {
        this.frY = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.bYu, d.f.selector_topbar_return_black);
        } else {
            aj.c(this.bYu, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bYu.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.frR.setAlpha(1.0f - f);
            this.frS.setAlpha(f);
        }
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cF(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        kj(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fnJ = aVar;
            this.frJ.f(this.fnJ.getUserData());
            if (this.frV) {
                cF(aVar.atI());
                if (this.bgE != null) {
                    this.bgE.wu();
                    return;
                }
                return;
            }
            this.frJ.bBi();
            this.frK.e(aVar);
            this.frO.setPortraitUrl(com.baidu.tbadk.core.util.o.dE(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.frO.bah();
            } else {
                this.fnJ.getUserData().setIsLike(this.fnJ.getUserData().getHave_attention() == 1);
                this.frP.a(this.fnJ.getUserData());
            }
            if ((aVar.baa() == null || this.mIsHost) && v.v(aVar.bab())) {
                this.fni.removeHeaderView(this.fsb.Yb());
            } else {
                TiebaStatic.log(new ak("c12543"));
                this.fsb.a(aVar.baa(), this.mIsHost, this.fnJ.getUserData(), aVar.bab());
            }
            if (!this.mIsHost) {
                if (aVar.bac() == null || aVar.bac().fpe == null || aVar.bac().fpe.size() <= 0) {
                    this.fni.removeHeaderView(this.frX);
                } else {
                    this.frX.a(aVar.bac());
                }
            }
            if (v.v(aVar.atI())) {
                cF(null);
                this.fnv.abc();
                com.baidu.adp.lib.util.l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bjW().lD(this.mIsHost);
            cF(aVar.atI());
            int size = aVar.atI().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.atI().get(i);
                if (fVar != null) {
                    if ((fVar instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                        this.fnv.abc();
                        return;
                    } else if ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j)) {
                        this.fnv.abc();
                        return;
                    }
                }
            }
            if (z) {
                if (this.bgE != null) {
                    this.bgE.wu();
                    return;
                }
                return;
            }
            this.fnv.a(true, (List<com.baidu.adp.widget.ListView.f>) aVar.atI());
        }
    }

    public void aoi() {
        this.fnv.aoi();
    }

    private void y(TbPageContext tbPageContext) {
        this.frT = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.t.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fQr;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && t.this.frK != null && t.this.frK.frm != null) {
                            t.this.frK.frm.ne(aVar.egM);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (t.this.fnJ != null) {
                            if (t.this.fnJ.foT != null && t.this.fnJ.foT.cmc != null && aVar2 != null) {
                                t.this.fnJ.foT.cmc.putBoolean("person_center_item_red_tip_show", aVar2.egM);
                            }
                            if (aVar3 != null && t.this.fnJ.foS != null && t.this.fnJ.foS.cmc != null) {
                                t.this.fnJ.foS.cmc.putBoolean("person_center_item_red_tip_show", aVar3.egM);
                            }
                            if (aVar4 != null && t.this.fnJ.foQ != null && t.this.fnJ.foQ.cmc != null) {
                                t.this.fnJ.foQ.cmc.putBoolean("person_center_item_red_tip_show", aVar4.egM);
                            }
                            if (aVar5 != null && t.this.fnJ.foU != null && t.this.fnJ.foU.cmc != null) {
                                t.this.fnJ.foU.cmc.putBoolean("person_center_item_red_tip_show", aVar5.egM);
                            }
                            if (aVar6 != null && t.this.fnJ.foV != null && t.this.fnJ.foV.cmc != null) {
                                t.this.fnJ.foV.cmc.putBoolean("person_center_item_red_tip_show", aVar6.egM);
                                t.this.fnJ.foV.cmc.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (t.this.frJ instanceof com.baidu.tieba.view.e) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                t.this.frJ.z(5, aVar7.egM);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                t.this.frJ.z(6, aVar8.egM);
                            }
                        }
                    }
                }
            }
        };
        this.frT.setTag(this.aAc);
        tbPageContext.registerListener(this.frT);
        this.fik = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.t.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.k kVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null) {
                    t.this.frK.qi(kVar.pQ());
                }
            }
        };
        this.fik.setTag(this.aAc);
        tbPageContext.registerListener(this.fik);
    }

    public void onDestory() {
        if (this.frK != null) {
            this.frK.onDestory();
        }
    }

    public void qG(int i) {
        this.frV = false;
        int i2 = i == 0 ? 1 : 0;
        this.frL.a(i2, this.frL.oY(i2));
        this.frU = this.frL.oY(i);
        if (this.frU.aYj() == null) {
            this.frV = true;
            if (i == 0) {
                this.frL.Rx();
                return;
            } else if (i == 1) {
                this.frL.h(true, true, false);
                return;
            } else {
                return;
            }
        }
        cF(this.frU.aYj());
    }

    public void qH(int i) {
        if (i != this.bKb && this.frL != null) {
            this.bKb = i;
            this.fok.qB(this.bKb);
            qG(i);
        }
    }

    public com.baidu.tieba.view.g ban() {
        return this.frJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aN(boolean z) {
            if (z) {
                if (t.this.cxT == null) {
                    t.this.cxT = new com.baidu.tbadk.i.a(t.this.abI);
                }
                if (t.this.frP.wR() != null && !StringUtils.isNull(t.this.frP.wR().getUserId())) {
                    t.this.cxT.gf(t.this.frP.wR().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(t.this.abI.getPageActivity(), t.this.abI.getString(d.j.unlike_success)).tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bao() {
        if (this.fsa) {
            XR();
            XS();
            bap();
        }
        if (!this.frZ) {
            this.frZ = this.frN.getTop() != 0;
        }
        if (this.frZ) {
            if (this.frN.getTop() <= this.mNavigationBar.getBottom()) {
                this.fnp.setVisibility(0);
            } else {
                this.fnp.setVisibility(8);
            }
            if (this.frK.Yb().getTop() + this.frQ <= this.mNavigationBar.getBottom() && this.frN.getTop() > this.mNavigationBar.getBottom()) {
                this.mNavigationBar.showBottomLine();
            } else {
                this.mNavigationBar.hideBottomLine();
            }
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.frL = aVar;
    }

    private void XR() {
        if (Build.VERSION.SDK_INT >= 11 && this.frK != null) {
            int dimensionPixelSize = this.abI.getResources().getDimensionPixelSize(d.e.ds320);
            int top = this.frK.Yb().getTop();
            if (top >= dimensionPixelSize) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void XS() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bIo) {
                    this.bIo = true;
                }
            } else if (this.bIo) {
                this.bIo = false;
            }
            a(alpha, !this.bIo);
            this.frJ.c(alpha, this.bIo ? false : true);
        }
    }

    private void bap() {
        if (Build.VERSION.SDK_INT >= 11 && this.frK != null) {
            int dimensionPixelSize = this.abI.getResources().getDimensionPixelSize(d.e.ds160);
            int top = this.frK.Yb().getTop();
            if (top >= dimensionPixelSize) {
                if (this.frO.getAlpha() != 0.0f) {
                    this.frO.setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.frO.setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.frO.getAlpha() != 1.0f) {
                this.frO.setAlpha(1.0f);
            }
        }
    }

    public void cF(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fni.getVisibility() != 0) {
            this.fni.setVisibility(0);
        }
        this.fni.setData(list);
        int u = v.u(list);
        if (u >= 5) {
            if (this.frY) {
                kj(true);
                this.frY = false;
            }
        } else if (u <= 1) {
            this.fni.smoothScrollToPosition(0);
        }
    }

    public void baq() {
        if (this.fnp.getVisibility() == 0) {
            this.fni.setSelectionFromTop(this.fni.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
        }
    }

    public void a(com.baidu.tieba.view.j jVar) {
        this.frM = jVar;
    }

    public NavigationBar ajm() {
        return this.mNavigationBar;
    }
}
