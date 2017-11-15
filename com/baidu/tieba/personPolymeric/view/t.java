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
    private BdUniqueId aAk;
    private TbPageContext abI;
    private ImageView bYH;
    private NoNetworkView bgM;
    private PbListView bgN;
    private PluginErrorTipView ckt;
    private com.baidu.tbadk.i.a cym;
    private CustomMessageListener fiH;
    private boolean fir;
    public BdPersonListView fnF;
    private PersonTabView fnM;
    private com.baidu.tieba.personPolymeric.b.d fnS;
    private com.baidu.tieba.personPolymeric.a.o foI;
    private com.baidu.tieba.personPolymeric.c.a fog;
    private com.baidu.tieba.view.h frE;
    private com.baidu.tieba.view.g fsg;
    public r fsh;
    private com.baidu.tieba.model.a fsi;
    private com.baidu.tieba.view.j fsj;
    private PersonTabView fsk;
    private LikeButtonWithHeadPortrait fsl;
    private com.baidu.tbadk.core.view.userLike.c fsm;
    private int fsn;
    private TextView fso;
    private TextView fsp;
    private CustomMessageListener fsq;
    private com.baidu.tieba.person.data.f fsr;
    private View fst;
    private m fsu;
    private boolean fsv;
    private l fsy;
    private boolean mIsHost;
    private List<com.baidu.tieba.person.data.f> mList;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean bIB = true;
    private int bKo = 0;
    private boolean fss = false;
    private boolean fsw = false;
    private boolean fsx = false;
    View.OnClickListener auH = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.t.1
        com.baidu.tieba.personPolymeric.event.a fnO = new com.baidu.tieba.personPolymeric.event.a();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (t.this.frE != null) {
                if (t.this.bYH == view) {
                    this.fnO.cmv = 8;
                }
                t.this.frE.a(view, this.fnO);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.t.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (t.this.fsj != null) {
                t.this.fsj.onScrollStateChanged(absListView, i);
            }
            if (i == 0 && t.this.fnM.getVisibility() == 0 && t.this.fsk.getTop() > t.this.mNavigationBar.getBottom()) {
                t.this.fnM.setVisibility(8);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2) {
                if (t.this.fsj != null) {
                    t.this.fsj.onScroll(absListView, i, i2, i3);
                }
                if (t.this.fsh != null && t.this.fsh.Yn() != null) {
                    int dimensionPixelSize = t.this.abI.getResources().getDimensionPixelSize(d.e.ds320);
                    int top = t.this.fsh.Yn().getTop();
                    if (!t.this.fsx && top != dimensionPixelSize) {
                        t.this.fsx = true;
                    }
                }
                t.this.baw();
            }
        }
    };
    private PersonTabView.a fsz = new PersonTabView.a() { // from class: com.baidu.tieba.personPolymeric.view.t.5
        @Override // com.baidu.tieba.personPolymeric.view.PersonTabView.a
        public void qJ(int i) {
            t.this.fsk.setCurrentTab(i);
            t.this.fnM.setCurrentTab(i);
            t.this.qI(i);
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.t.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (t.this.bgN != null && t.this.fsi != null) {
                t.this.fnS.qE(t.this.bKo);
                if (t.this.bKo == 0) {
                    t.this.bgN.wt();
                    t.this.fsi.h(false, false, false);
                } else if (t.this.bKo == 1) {
                    t.this.bgN.wt();
                    t.this.fsi.h(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a fsA = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.t.7
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kW() {
            t.this.aZD();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void kV() {
            t.this.fnS.aox();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void v(float f) {
            t.this.fnS.u(f);
        }
    };

    public t(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.fir = false;
        this.abI = tbPageContext;
        this.aAk = bdUniqueId;
        this.mIsHost = z;
        this.fir = z2;
        this.fnS = eVar.aZO();
        this.bgN = this.fnS.bgN;
        if (z) {
            this.fsg = new com.baidu.tieba.view.e(2);
            y(tbPageContext);
            return;
        }
        this.fsg = new com.baidu.tieba.view.d();
    }

    public void Z(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(d.g.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(d.C0080d.cp_bg_line_c);
        this.bgM = (NoNetworkView) this.mRootView.findViewById(d.g.person_center_no_network_view);
        this.ckt = (PluginErrorTipView) this.mRootView.findViewById(d.g.person_center_plugin_error_tip_view);
        this.fnF = (BdPersonListView) this.mRootView.findViewById(d.g.person_center_listview);
        this.fsk = new PersonTabView(this.abI.getPageActivity());
        this.fsk.setOnTabSelectListener(this.fsz);
        this.fnM = (PersonTabView) this.mRootView.findViewById(d.g.person_center_sticky_person_buttom_header);
        this.fnM.setOnTabSelectListener(this.fsz);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.abI.getResources().getDimensionPixelSize(d.e.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.fsg.a(this.abI.getPageActivity(), this.mNavigationBar);
        this.fnF.setOnScrollListener(this.mOnScrollListener);
        this.fsn = this.abI.getResources().getDimensionPixelSize(d.e.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bYH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.view_topbar_icon, (View.OnClickListener) null);
        if (this.bYH.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.bYH.getLayoutParams();
            layoutParams2.leftMargin = this.abI.getResources().getDimensionPixelSize(d.e.ds14);
            this.bYH.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fsl = (LikeButtonWithHeadPortrait) view.findViewById(d.g.like_btn_with_head_portrait);
        this.fsm = new com.baidu.tbadk.core.view.userLike.c(this.abI, this.fsl);
        this.fsm.setFromType("2");
        this.fsm.h(this.abI.getUniqueId());
        this.fsm.a(new a());
        this.fso = (TextView) addCustomView.findViewById(d.g.person_center_navigation_title);
        this.fsp = (TextView) addCustomView.findViewById(d.g.person_center_navigation_another_title);
        if (!this.fir) {
            this.bYH.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fnF.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.fsh = new r(this.abI, this.mIsHost);
        this.fst = LayoutInflater.from(this.abI.getPageActivity()).inflate(d.h.view_header_expand, (ViewGroup) null);
        this.fnF.addHeaderView(this.fst);
        this.fnF.setExpandView(this.fst);
        this.fnF.addHeaderView(this.fsh.Yn());
        this.fsy = new l(this.abI);
        this.fnF.addHeaderView(this.fsy.Yn());
        if (!this.mIsHost) {
            this.fsu = new m(this.abI.getPageActivity());
            this.fnF.addHeaderView(this.fsu);
        }
        this.fnF.addHeaderView(this.fsk);
        this.fnF.setPersonListRefreshListener(this.fsA);
        this.foI = new com.baidu.tieba.personPolymeric.a.o(this.abI, this.fnF, this.aAk);
        this.foI.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.fsl.setAlpha(0.0f);
        this.fnM.setVisibility(8);
        this.fsg.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.fog == null) {
            this.fsg.c(1.0f, true);
            aj.c(this.bYH, d.f.selector_topbar_return_black);
        } else {
            baw();
        }
        this.fsk.onChangeSkinType();
        this.fnM.onChangeSkinType();
        this.fsl.onChangeSkinType(i);
        aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.cR(d.f.s_navbar_bg)));
        if (this.fsg != null) {
            this.fsg.onChangeSkinType(i);
        }
        this.bgM.onChangeSkinType(this.abI, i);
        this.ckt.onChangeSkinType(this.abI, i);
        if (this.fsh != null) {
            this.fsh.onChangeSkinType(i);
        }
        if (this.fnF != null && (this.fnF.getAdapter() instanceof com.baidu.adp.widget.ListView.d)) {
            ((com.baidu.adp.widget.ListView.d) this.fnF.getAdapter()).notifyDataSetChanged();
        }
        this.bgN.dy(i);
        aj.j(this.mRootView, d.C0080d.cp_bg_line_d);
        if (this.mIsHost) {
            aj.b(this.fsp, d.C0080d.cp_cont_b, d.C0080d.s_navbar_title_color);
            aj.b(this.fso, d.C0080d.cp_cont_i, d.C0080d.cp_cont_i);
        }
        if (this.fsu != null) {
            this.fsu.onChangeSkinType(i);
        }
        if (this.fsy != null) {
            this.fsy.onChangeSkinType(i);
        }
    }

    public void kp(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            aj.c(this.bYH, d.f.selector_topbar_return_black);
            this.fsg.c(1.0f, true);
            this.fsl.setAlpha(1.0f);
            this.fnM.setVisibility(0);
            this.fnF.setSelectionFromTop(this.fnF.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        aj.c(this.bYH, d.f.selector_topbar_return_white);
        this.fsg.c(0.0f, false);
        this.fsl.setAlpha(0.0f);
        this.fnM.setVisibility(8);
    }

    public void aZD() {
        this.fss = false;
        if (this.bKo == 0) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fsi.resetData();
                this.fsi.refreshData();
                this.fnS.kU();
                return;
            }
            this.fnS.aox();
        } else if (this.bKo == 1) {
            if (com.baidu.adp.lib.util.j.hh()) {
                this.fsi.h(true, true, true);
                this.fnS.kU();
                return;
            }
            this.fnS.aox();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.h hVar) {
        this.frE = hVar;
        this.fsg.setOnViewResponseListener(hVar);
        this.bYH.setOnClickListener(this.auH);
        this.fsh.setOnViewResponseListener(hVar);
        if (this.fnS != null) {
            this.fnS.a(this.fst, hVar);
        }
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.foI != null) {
            this.foI.K(onClickListener);
        }
    }

    public void setList(List<com.baidu.tieba.person.data.f> list) {
        this.mList = list;
        this.foI.cF(list);
    }

    public void ki(boolean z) {
        this.fsv = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            aj.c(this.bYH, d.f.selector_topbar_return_black);
        } else {
            aj.c(this.bYH, d.f.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bYH.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.fso.setAlpha(1.0f - f);
            this.fsp.setAlpha(f);
        }
    }

    public void am(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cG(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        kp(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.fog = aVar;
            this.fsg.f(this.fog.getUserData());
            if (this.fss) {
                cG(aVar.atZ());
                if (this.bgN != null) {
                    this.bgN.wu();
                    return;
                }
                return;
            }
            this.fsg.bBu();
            this.fsh.e(aVar);
            this.fsl.setPortraitUrl(com.baidu.tbadk.core.util.o.dE(aVar.getUserData().getPortrait()));
            if (this.mIsHost) {
                this.fsl.bap();
            } else {
                this.fog.getUserData().setIsLike(this.fog.getUserData().getHave_attention() == 1);
                this.fsm.a(this.fog.getUserData());
            }
            if ((aVar.bai() == null || this.mIsHost) && v.v(aVar.baj())) {
                this.fnF.removeHeaderView(this.fsy.Yn());
            } else {
                TiebaStatic.log(new ak("c12543"));
                this.fsy.a(aVar.bai(), this.mIsHost, this.fog.getUserData(), aVar.baj());
            }
            if (!this.mIsHost) {
                if (aVar.bak() == null || aVar.bak().fpC == null || aVar.bak().fpC.size() <= 0) {
                    this.fnF.removeHeaderView(this.fsu);
                } else {
                    this.fsu.a(aVar.bak());
                }
            }
            if (v.v(aVar.atZ())) {
                cG(null);
                this.fnS.abo();
                com.baidu.adp.lib.util.l.showToast(this.abI.getContext(), this.abI.getString(d.j.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bkh().lL(this.mIsHost);
            cG(aVar.atZ());
            int size = aVar.atZ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.atZ().get(i);
                if (fVar != null) {
                    if ((fVar instanceof com.baidu.tieba.personPolymeric.c.k) && size <= 1) {
                        this.fnS.abo();
                        return;
                    } else if ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j)) {
                        this.fnS.abo();
                        return;
                    }
                }
            }
            if (z) {
                if (this.bgN != null) {
                    this.bgN.wu();
                    return;
                }
                return;
            }
            this.fnS.a(true, (List<com.baidu.adp.widget.ListView.f>) aVar.atZ());
        }
    }

    public void aox() {
        this.fnS.aox();
    }

    private void y(TbPageContext tbPageContext) {
        this.fsq = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.view.t.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fRt;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && t.this.fsh != null && t.this.fsh.frK != null) {
                            t.this.fsh.frK.nm(aVar.egQ);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (t.this.fog != null) {
                            if (t.this.fog.fpq != null && t.this.fog.fpq.cmw != null && aVar2 != null) {
                                t.this.fog.fpq.cmw.putBoolean("person_center_item_red_tip_show", aVar2.egQ);
                            }
                            if (aVar3 != null && t.this.fog.fpp != null && t.this.fog.fpp.cmw != null) {
                                t.this.fog.fpp.cmw.putBoolean("person_center_item_red_tip_show", aVar3.egQ);
                            }
                            if (aVar4 != null && t.this.fog.fpn != null && t.this.fog.fpn.cmw != null) {
                                t.this.fog.fpn.cmw.putBoolean("person_center_item_red_tip_show", aVar4.egQ);
                            }
                            if (aVar5 != null && t.this.fog.fpr != null && t.this.fog.fpr.cmw != null) {
                                t.this.fog.fpr.cmw.putBoolean("person_center_item_red_tip_show", aVar5.egQ);
                            }
                            if (aVar6 != null && t.this.fog.fpt != null && t.this.fog.fpt.cmw != null) {
                                t.this.fog.fpt.cmw.putBoolean("person_center_item_red_tip_show", aVar6.egQ);
                                t.this.fog.fpt.cmw.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (t.this.fsg instanceof com.baidu.tieba.view.e) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                t.this.fsg.A(5, aVar7.egQ);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                t.this.fsg.A(6, aVar8.egQ);
                            }
                        }
                    }
                }
            }
        };
        this.fsq.setTag(this.aAk);
        tbPageContext.registerListener(this.fsq);
        this.fiH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.view.t.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.k kVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null) {
                    t.this.fsh.qm(kVar.pQ());
                }
            }
        };
        this.fiH.setTag(this.aAk);
        tbPageContext.registerListener(this.fiH);
    }

    public void onDestory() {
        if (this.fsh != null) {
            this.fsh.onDestory();
        }
    }

    public void qH(int i) {
        this.fss = false;
        int i2 = i == 0 ? 1 : 0;
        this.fsi.a(i2, this.fsi.oZ(i2));
        this.fsr = this.fsi.oZ(i);
        if (this.fsr.aYr() == null) {
            this.fss = true;
            if (i == 0) {
                this.fsi.RG();
                return;
            } else if (i == 1) {
                this.fsi.h(true, true, false);
                return;
            } else {
                return;
            }
        }
        cG(this.fsr.aYr());
    }

    public void qI(int i) {
        if (i != this.bKo && this.fsi != null) {
            this.bKo = i;
            this.foI.qC(this.bKo);
            qH(i);
        }
    }

    public com.baidu.tieba.view.g bav() {
        return this.fsg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void aN(boolean z) {
            if (z) {
                if (t.this.cym == null) {
                    t.this.cym = new com.baidu.tbadk.i.a(t.this.abI);
                }
                if (t.this.fsm.wR() != null && !StringUtils.isNull(t.this.fsm.wR().getUserId())) {
                    t.this.cym.gg(t.this.fsm.wR().getUserId());
                    return;
                }
                return;
            }
            BdToast.a(t.this.abI.getPageActivity(), t.this.abI.getString(d.j.unlike_success)).tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baw() {
        if (this.fsx) {
            Yd();
            Ye();
            bax();
        }
        if (!this.fsw) {
            this.fsw = this.fsk.getTop() != 0;
        }
        if (this.fsw) {
            if (this.fsk.getTop() <= this.mNavigationBar.getBottom()) {
                this.fnM.setVisibility(0);
            } else {
                this.fnM.setVisibility(8);
            }
            if (this.fsh.Yn().getTop() + this.fsn <= this.mNavigationBar.getBottom() && this.fsk.getTop() > this.mNavigationBar.getBottom()) {
                this.mNavigationBar.showBottomLine();
            } else {
                this.mNavigationBar.hideBottomLine();
            }
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.fsi = aVar;
    }

    private void Yd() {
        if (Build.VERSION.SDK_INT >= 11 && this.fsh != null) {
            int dimensionPixelSize = this.abI.getResources().getDimensionPixelSize(d.e.ds320);
            int top = this.fsh.Yn().getTop();
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

    private void Ye() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.bIB) {
                    this.bIB = true;
                }
            } else if (this.bIB) {
                this.bIB = false;
            }
            a(alpha, !this.bIB);
            this.fsg.c(alpha, this.bIB ? false : true);
        }
    }

    private void bax() {
        if (Build.VERSION.SDK_INT >= 11 && this.fsh != null) {
            int dimensionPixelSize = this.abI.getResources().getDimensionPixelSize(d.e.ds160);
            int top = this.fsh.Yn().getTop();
            if (top >= dimensionPixelSize) {
                if (this.fsl.getAlpha() != 0.0f) {
                    this.fsl.setAlpha(0.0f);
                }
            } else if (top > 0 && top < dimensionPixelSize) {
                this.fsl.setAlpha(1.0f - ((top * 1.0f) / dimensionPixelSize));
            } else if (top <= 0 && this.fsl.getAlpha() != 1.0f) {
                this.fsl.setAlpha(1.0f);
            }
        }
    }

    public void cG(List<com.baidu.adp.widget.ListView.f> list) {
        if (v.v(list)) {
            list = new ArrayList<>();
        }
        if (this.fnF.getVisibility() != 0) {
            this.fnF.setVisibility(0);
        }
        this.fnF.setData(list);
        int u = v.u(list);
        if (u >= 5) {
            if (this.fsv) {
                kp(true);
                this.fsv = false;
            }
        } else if (u <= 1) {
            this.fnF.smoothScrollToPosition(0);
        }
    }

    public void bay() {
        if (this.fnM.getVisibility() == 0) {
            this.fnF.setSelectionFromTop(this.fnF.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
        }
    }

    public void a(com.baidu.tieba.view.j jVar) {
        this.fsj = jVar;
    }

    public NavigationBar ajA() {
        return this.mNavigationBar;
    }
}
