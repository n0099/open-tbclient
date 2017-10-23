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
import com.baidu.tbadk.core.util.aj;
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
public class s {
    private TbPageContext abm;
    private BdUniqueId azr;
    private ImageView bQP;
    private NoNetworkView bfM;
    private PbListView bfN;
    private PluginErrorTipView ccG;
    private com.baidu.tbadk.h.a cqz;
    private boolean eZF;
    private CustomMessageListener eZU;
    public BdPersonListView feS;
    private PersonTabView feZ;
    private boolean ffR;
    private com.baidu.tieba.personPolymeric.a.o ffX;
    private com.baidu.tieba.personPolymeric.b.d fff;
    private com.baidu.tieba.personPolymeric.c.a ffs;
    private com.baidu.tieba.view.f fiZ;
    private com.baidu.tieba.view.g fiy;
    public q fja;
    private com.baidu.tieba.model.a fjb;
    private com.baidu.tieba.view.i fjc;
    private PersonTabView fjd;
    private LikeButtonWithHeadPortrait fje;
    private com.baidu.tbadk.core.view.userLike.c fjf;
    private int fjg;
    private TextView fjh;
    private TextView fji;
    private CustomMessageListener fjj;
    private com.baidu.tieba.person.data.f fjk;
    private View fjm;
    private l fjn;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bBr = true;
    private int bCR = 0;
    private boolean fjl = false;
    private boolean fjo = false;
    View.OnClickListener auc = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.s.1
        com.baidu.tieba.personPolymeric.event.a ffb = new com.baidu.tieba.personPolymeric.event.a();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s.this.fiy != null) {
                if (s.this.bQP == view) {
                    this.ffb.ceI = 8;
                }
                s.this.fiy.a(view, this.ffb);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.s.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (s.this.fjc != null) {
                s.this.fjc.onScrollStateChanged(absListView, i);
            }
            if (i == 0 && s.this.feZ.getVisibility() == 0 && s.this.fjd.getTop() > s.this.mNavigationBar.getBottom()) {
                s.this.feZ.setVisibility(8);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2) {
                if (s.this.fjc != null) {
                    s.this.fjc.onScroll(absListView, i, i2, i3);
                }
                s.this.aXg();
            }
        }
    };
    private PersonTabView.a fjp = new PersonTabView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.5
        @Override // com.baidu.tieba.personPolymeric.view.PersonTabView.a
        public void qs(int i) {
            s.this.fjd.setCurrentTab(i);
            s.this.feZ.setCurrentTab(i);
            s.this.qr(i);
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.s.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (s.this.bfN != null && s.this.fjb != null) {
                s.this.fff.qn(s.this.bCR);
                if (s.this.bCR == 0) {
                    s.this.bfN.wm();
                    s.this.fjb.h(false, false, false);
                } else if (s.this.bCR == 1) {
                    s.this.bfN.wm();
                    s.this.fjb.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fjq = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.s.7
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lc() {
            s.this.aWs();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void lb() {
            s.this.fff.alx();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void w(float f) {
            s.this.fff.v(f);
        }
    };

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.eZF = false;
        this.abm = tbPageContext;
        this.azr = bdUniqueId;
        this.mIsHost = z;
        this.eZF = z2;
        this.fff = eVar.aWD();
        this.bfN = this.fff.bfN;
        if (z) {
            this.fiZ = new com.baidu.tieba.view.d(2);
            y(tbPageContext);
            return;
        }
        this.fiZ = new com.baidu.tieba.view.c();
    }

    public void X(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.h.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.e.cp_bg_line_c);
        this.bfM = (NoNetworkView) this.mRootView.findViewById(d.h.person_center_no_network_view);
        this.ccG = (PluginErrorTipView) this.mRootView.findViewById(d.h.person_center_plugin_error_tip_view);
        this.feS = (BdPersonListView) this.mRootView.findViewById(d.h.person_center_listview);
        this.fjd = new PersonTabView(this.abm.getPageActivity());
        this.fjd.setOnTabSelectListener(this.fjp);
        this.feZ = (PersonTabView) this.mRootView.findViewById(d.h.person_center_sticky_person_buttom_header);
        this.feZ.setOnTabSelectListener(this.fjp);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.abm.getResources().getDimensionPixelSize(d.f.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fiZ.a(this.abm.getPageActivity(), this.mNavigationBar);
        this.feS.setOnScrollListener(this.mOnScrollListener);
        this.fjg = this.abm.getResources().getDimensionPixelSize(d.f.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bQP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.view_topbar_icon, (View.OnClickListener) null);
        if (this.bQP.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bQP.getLayoutParams();
            layoutParams2.leftMargin = this.abm.getResources().getDimensionPixelSize(d.f.ds14);
            this.bQP.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fje = (LikeButtonWithHeadPortrait) view.findViewById(d.h.like_btn_with_head_portrait);
        this.fjf = new com.baidu.tbadk.core.view.userLike.c(this.abm, this.fje);
        this.fjf.setFromType("2");
        this.fjf.h(this.abm.getUniqueId());
        this.fjf.a(new a());
        this.fjh = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fji = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.eZF) {
            this.bQP.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.feS.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fja = new q(this.abm, this.mIsHost);
        this.fjm = LayoutInflater.from(this.abm.getPageActivity()).inflate(d.j.view_header_expand, (ViewGroup) null);
        this.feS.addHeaderView(this.fjm);
        this.feS.setExpandView(this.fjm);
        this.feS.addHeaderView(this.fja.VR());
        if (!this.mIsHost) {
            this.fjn = new l(this.abm.getPageActivity());
            this.feS.addHeaderView(this.fjn);
        }
        this.feS.addHeaderView(this.fjd);
        this.feS.setPersonListRefreshListener(this.fjq);
        this.ffX = new com.baidu.tieba.personPolymeric.a.o(this.abm, this.feS, this.azr);
        this.ffX.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fje.setAlpha(0.0f);
        this.feZ.setVisibility(8);
        this.fiZ.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ffs == null) {
            this.fiZ.c(1.0f, true);
            aj.c(this.bQP, d.g.selector_topbar_return_black);
        } else {
            aXg();
        }
        this.fjd.onChangeSkinType();
        this.feZ.onChangeSkinType();
        this.fje.onChangeSkinType(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cR(d.g.s_navbar_bg)));
        if (this.fiZ != null) {
            this.fiZ.onChangeSkinType(i);
        }
        this.bfM.onChangeSkinType(this.abm, i);
        this.ccG.onChangeSkinType(this.abm, i);
        if (this.fja != null) {
            this.fja.onChangeSkinType(i);
        }
        if (this.feS != null && (this.feS.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.feS.getAdapter()).notifyDataSetChanged();
        }
        this.bfN.dy(i);
        aj.j(this.mRootView, d.e.cp_bg_line_d);
        if (this.mIsHost) {
            aj.b(this.fji, d.e.cp_cont_b, d.e.s_navbar_title_color);
            aj.b(this.fjh, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.fjn != null) {
            this.fjn.onChangeSkinType(i);
        }
    }

    public void kp(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.bQP, d.g.selector_topbar_return_black);
            this.fiZ.c(1.0f, true);
            this.fje.setAlpha(1.0f);
            this.feZ.setVisibility(0);
            this.feS.setSelectionFromTop(this.feS.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.bQP, d.g.selector_topbar_return_white);
        this.fiZ.c(0.0f, false);
        this.fje.setAlpha(0.0f);
        this.feZ.setVisibility(8);
    }

    public void aWs() {
        this.fjl = false;
        if (this.bCR == 0) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjb.resetData();
                this.fjb.refreshData();
                this.fff.la();
                return;
            }
            this.fff.alx();
        } else if (this.bCR == 1) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fjb.h(true, true, true);
                this.fff.la();
                return;
            }
            this.fff.alx();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.fiy = gVar;
        this.fiZ.setOnViewResponseListener(gVar);
        this.bQP.setOnClickListener(this.auc);
        this.fja.setOnViewResponseListener(gVar);
        if (this.fff != null) {
            this.fff.a(this.fjm, gVar);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.ffX != null) {
            this.ffX.J(onClickListener);
        }
    }

    public void setList(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
        this.ffX.cD(list);
    }

    public void ki(boolean z) {
        this.ffR = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.bQP, d.g.selector_topbar_return_black);
        } else {
            aj.c(this.bQP, d.g.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bQP.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fjh.setAlpha(1.0f - f);
            this.fji.setAlpha(f);
        }
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cE(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        kp(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ffs = aVar;
            this.fiZ.e(this.ffs.getUserData());
            if (this.fjl) {
                cE(aVar.arm());
                if (this.bfN != null) {
                    this.bfN.wn();
                    return;
                }
                return;
            }
            this.fiZ.bxP();
            this.fja.e(aVar);
            this.fje.setPortraitUrl(com.baidu.tbadk.core.util.o.dy(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fje.aXa();
            } else {
                this.ffs.getUserData().setIsLike(this.ffs.getUserData().getHave_attention() == 1);
                this.fjf.a(this.ffs.getUserData());
            }
            if (!this.mIsHost) {
                if (aVar.aWV() == null || aVar.aWV().fgG == null || aVar.aWV().fgG.size() <= 0) {
                    this.feS.removeHeaderView(this.fjn);
                } else {
                    this.fjn.a(aVar.aWV());
                }
            }
            if (v.u(aVar.arm())) {
                cE(null);
                this.fff.YS();
                com.baidu.adp.lib.util.l.showToast(this.abm.getContext(), this.abm.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bgJ().lI(this.mIsHost);
            cE(aVar.arm());
            kp(this.ffR && v.t(aVar.arm()) >= 5);
            this.ffR = false;
            int size = aVar.arm().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.arm().get(i);
                if (fVar != null) {
                    if ((fVar instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                        this.fff.YS();
                        return;
                    } else if ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j)) {
                        this.fff.YS();
                        return;
                    }
                }
            }
            if (z) {
                if (this.bfN != null) {
                    this.bfN.wn();
                    return;
                }
                return;
            }
            this.fff.a(true, (List<com.baidu.adp.widget.ListView.f>) aVar.arm());
        }
    }

    public void alx() {
        this.fff.alx();
    }

    private void y(TbPageContext tbPageContext) {
        this.fjj = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.s.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fHC;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.fja != null && s.this.fja.fiE != null) {
                            s.this.fja.fiE.ni(aVar.dZb);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.ffs != null) {
                            if (s.this.ffs.fgv != null && s.this.ffs.fgv.ceJ != null && aVar2 != null) {
                                s.this.ffs.fgv.ceJ.putBoolean("person_center_item_red_tip_show", aVar2.dZb);
                            }
                            if (aVar3 != null && s.this.ffs.fgu != null && s.this.ffs.fgu.ceJ != null) {
                                s.this.ffs.fgu.ceJ.putBoolean("person_center_item_red_tip_show", aVar3.dZb);
                            }
                            if (aVar4 != null && s.this.ffs.fgs != null && s.this.ffs.fgs.ceJ != null) {
                                s.this.ffs.fgs.ceJ.putBoolean("person_center_item_red_tip_show", aVar4.dZb);
                            }
                            if (aVar5 != null && s.this.ffs.fgw != null && s.this.ffs.fgw.ceJ != null) {
                                s.this.ffs.fgw.ceJ.putBoolean("person_center_item_red_tip_show", aVar5.dZb);
                            }
                            if (aVar6 != null && s.this.ffs.fgx != null && s.this.ffs.fgx.ceJ != null) {
                                s.this.ffs.fgx.ceJ.putBoolean("person_center_item_red_tip_show", aVar6.dZb);
                                s.this.ffs.fgx.ceJ.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (s.this.fiZ instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.fiZ.y(5, aVar7.dZb);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.fiZ.y(6, aVar8.dZb);
                            }
                        }
                    }
                }
            }
        };
        this.fjj.setTag(this.azr);
        tbPageContext.registerListener(this.fjj);
        this.eZU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.s.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.i iVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.i) && (iVar = (com.baidu.tbadk.data.i) customResponsedMessage.getData()) != null) {
                    s.this.fja.pC(iVar.pL());
                }
            }
        };
        this.eZU.setTag(this.azr);
        tbPageContext.registerListener(this.eZU);
    }

    public void onDestory() {
        if (this.fja != null) {
            this.fja.onDestory();
        }
    }

    public void qq(int i) {
        this.fjl = false;
        int i2 = i == 0 ? 1 : 0;
        this.fjb.a(i2, this.fjb.oH(i2));
        this.fjk = this.fjb.oH(i);
        if (this.fjk.aVg() == null) {
            this.fjl = true;
            if (i == 0) {
                this.fjb.Qf();
                return;
            } else if (i == 1) {
                this.fjb.h(true, true, false);
                return;
            } else {
                return;
            }
        }
        cE(this.fjk.aVg());
    }

    public void qr(int i) {
        if (i != this.bCR && this.fjb != null) {
            this.bCR = i;
            this.ffX.ql(this.bCR);
            qq(i);
        }
    }

    public com.baidu.tieba.view.f aXf() {
        return this.fiZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aP(boolean z) {
            if (z) {
                if (s.this.cqz == null) {
                    s.this.cqz = new com.baidu.tbadk.h.a(s.this.abm);
                }
                if (s.this.fjf.wK() != null && !StringUtils.isNull(s.this.fjf.wK().getUserId())) {
                    s.this.cqz.fY(s.this.fjf.wK().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(s.this.abm.getPageActivity(), s.this.abm.getString(d.l.unlike_success)).tj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXg() {
        VH();
        VI();
        aXh();
        if (!this.fjo) {
            this.fjo = this.fjd.getTop() != 0;
        }
        if (this.fjo) {
            if (this.fjd.getTop() <= this.mNavigationBar.getBottom()) {
                this.feZ.setVisibility(0);
            } else {
                this.feZ.setVisibility(8);
            }
            if (this.fja.VR().getTop() + this.fjg <= this.mNavigationBar.getBottom() && this.fjd.getTop() > this.mNavigationBar.getBottom()) {
                this.mNavigationBar.showBottomLine();
            } else {
                this.mNavigationBar.hideBottomLine();
            }
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fjb = aVar;
    }

    private void VH() {
        if (Build.VERSION.SDK_INT >= 11 && this.fja != null) {
            int dimensionPixelSize = this.abm.getResources().getDimensionPixelSize(d.f.ds320);
            int top = this.fja.VR().getTop();
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

    private void VI() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bBr) {
                    this.bBr = true;
                }
            } else if (this.bBr) {
                this.bBr = false;
            }
            a(alpha, !this.bBr);
            this.fiZ.c(alpha, this.bBr ? false : true);
        }
    }

    private void aXh() {
        if (Build.VERSION.SDK_INT >= 11 && this.fja != null) {
            int dimensionPixelSize = this.abm.getResources().getDimensionPixelSize(d.f.ds160);
            int top = this.fja.VR().getTop();
            if (top >= dimensionPixelSize) {
                if (this.fje.getAlpha() != 0.0f) {
                    this.fje.setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.fje.setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.fje.getAlpha() != 1.0f) {
                this.fje.setAlpha(1.0f);
            }
        }
    }

    public void cE(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.u(list)) {
            list = new ArrayList<>();
        }
        if (this.feS.getVisibility() != 0) {
            this.feS.setVisibility(0);
        }
        this.feS.setData(list);
    }

    public void aXi() {
        if (this.feZ.getVisibility() == 0) {
            this.feS.setSelectionFromTop(this.feS.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.fjc = iVar;
    }

    public NavigationBar ahe() {
        return this.mNavigationBar;
    }
}
