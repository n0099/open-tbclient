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
import com.baidu.tieba.R;
import com.baidu.tieba.o.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import com.baidu.tieba.personPolymeric.b.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p {
    public static int ing = 300;
    private BdUniqueId Xk;
    private NoNetworkView dlW;
    private PbListView dlX;
    private ImageView eEt;
    private PluginErrorTipView eRV;
    private int epS;
    private com.baidu.tbadk.k.a fpp;
    private boolean icY;
    private CustomMessageListener idu;
    public BdPersonListView iiQ;
    private com.baidu.tieba.personPolymeric.b.d ije;
    private com.baidu.tieba.personPolymeric.c.a ijr;
    private com.baidu.tieba.view.g imw;
    private String inA;
    private View inB;
    private int inC;
    private i.a inD;
    private com.baidu.tieba.view.f inh;
    public n ini;
    private com.baidu.tieba.model.a inj;
    private com.baidu.tieba.view.i ink;
    private TextView inl;
    private LikeButtonWithHeadPortrait inm;
    private com.baidu.tbadk.core.view.userLike.c inn;
    private int ino;
    private TextView inp;
    private TextView inq;
    private com.baidu.tieba.personPolymeric.a.n inr;

    /* renamed from: int  reason: not valid java name */
    private CustomMessageListener f1int;
    private View inv;
    private PersonCenterAttentionBarListView inw;
    private boolean inx;
    private k inz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean efl = true;
    private int eht = 0;
    private boolean inu = false;
    private boolean iny = false;
    View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b ija = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.imw != null) {
                if (p.this.eEt == view) {
                    this.ija.eXv = 8;
                }
                p.this.imw.a(view, this.ija);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.ink != null) {
                p.this.ink.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.ink != null) {
                    p.this.ink.onScroll(absListView, i, i2, i3);
                }
                p.this.cax();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dlX != null && p.this.inj != null) {
                p.this.ije.yk(p.this.eht);
                if (p.this.eht == 0) {
                    p.this.dlX.ajy();
                    p.this.inj.g(false, false, false);
                } else if (p.this.eht == 1) {
                    p.this.dlX.ajy();
                    p.this.inj.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a inE = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bZI();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nF() {
            p.this.ije.bpD();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.ije.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.icY = false;
        this.mContext = tbPageContext;
        this.Xk = bdUniqueId;
        this.mIsHost = z;
        this.icY = z2;
        this.ije = eVar.bZS();
        this.dlX = this.ije.dlX;
        this.epS = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.inh = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.inh = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eRV = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.iiQ = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.inh.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.iiQ.setOnScrollListener(this.mOnScrollListener);
        this.ino = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eEt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eEt.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEt.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eEt.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.inl = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.inm = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.inn = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.inm);
        this.inn.setFromType("2");
        this.inn.i(this.mContext.getUniqueId());
        this.inn.a(new a());
        this.inp = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.inq = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.icY) {
            this.eEt.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.iiQ.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.ini = new n(this.mContext, this.mIsHost);
        this.inv = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.iiQ.addHeaderView(this.inv);
        this.iiQ.setExpandView(this.inv);
        this.iiQ.addHeaderView(this.ini.aUT());
        this.inz = new k(this.mContext);
        this.iiQ.addHeaderView(this.inz.aUT());
        if (!this.mIsHost) {
            this.inl.setText(R.string.ta_homepage);
            this.inw = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.iiQ.addHeaderView(this.inw);
        } else {
            this.inl.setText(R.string.my_homepage);
        }
        this.iiQ.setPersonListRefreshListener(this.inE);
        this.inr = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.iiQ, this.Xk);
        this.inr.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.inm.setAlpha(0.0f);
        this.inh.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ijr == null) {
            this.inh.c(1.0f, true);
            al.c(this.eEt, (int) R.drawable.selector_topbar_return_black);
        } else {
            cax();
        }
        al.j(this.inl, R.color.cp_btn_a);
        this.inm.onChangeSkinType(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        if (this.inh != null) {
            this.inh.onChangeSkinType(i);
        }
        this.dlW.onChangeSkinType(this.mContext, i);
        this.eRV.onChangeSkinType(this.mContext, i);
        if (this.ini != null) {
            this.ini.onChangeSkinType(i);
        }
        if (this.iiQ != null && (this.iiQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.iiQ.getAdapter().notifyDataSetChanged();
        }
        this.dlX.iP(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            al.e(this.inq, R.color.cp_cont_b, R.color.s_navbar_title_color);
            al.e(this.inp, R.color.cp_btn_a, R.color.cp_btn_a);
        }
        if (this.inw != null) {
            this.inw.onChangeSkinType(i);
        }
        if (this.inz != null) {
            this.inz.onChangeSkinType(i);
        }
    }

    public void pD(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eEt, (int) R.drawable.selector_topbar_return_black);
            this.inh.c(1.0f, true);
            this.inl.setAlpha(0.0f);
            this.inm.setAlpha(1.0f);
            this.iiQ.setSelectionFromTop(this.iiQ.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eEt, (int) R.drawable.selector_topbar_return_white);
        this.inh.c(0.0f, false);
        this.inl.setAlpha(1.0f);
        this.inm.setAlpha(0.0f);
    }

    public void BZ(String str) {
        if (this.ini != null) {
            this.ini.BM(str);
        }
    }

    public void Ca(String str) {
        if (this.ini != null) {
            this.ini.BN(str);
        }
    }

    public void bZI() {
        this.inu = false;
        if (this.eht == 0) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inj.resetData();
                this.inj.refreshData();
                this.ije.nE();
                return;
            }
            this.ije.bpD();
        } else if (this.eht == 1) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inj.g(true, true, true);
                this.ije.nE();
                return;
            }
            this.ije.bpD();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imw = gVar;
        this.inh.setOnViewResponseListener(gVar);
        this.eEt.setOnClickListener(this.ckH);
        this.ini.setOnViewResponseListener(gVar);
        if (this.ije != null) {
            this.ije.a(this.inv, gVar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.inr != null) {
            this.inr.T(onClickListener);
        }
    }

    public void pv(boolean z) {
        this.inx = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.eEt, (int) R.drawable.selector_topbar_return_black);
        } else {
            al.c(this.eEt, (int) R.drawable.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eEt.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.inp.setAlpha(1.0f - f);
            this.inq.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dQ(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pD(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ijr = aVar;
            this.inh.setUserData(this.ijr.getUserData());
            if (this.inu) {
                dQ(aVar.bwb());
                if (this.dlX != null) {
                    this.dlX.ajz();
                    return;
                }
                return;
            }
            this.inh.bZF();
            this.ini.e(aVar);
            if (aVar != null) {
                this.inm.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.inm.car();
            } else {
                this.ijr.getUserData().setIsLike(this.ijr.getUserData().getHave_attention() == 1);
                this.inn.a(this.ijr.getUserData());
            }
            if ((aVar.cak() == null || this.mIsHost) && v.aa(aVar.cal())) {
                this.iiQ.removeHeaderView(this.inz.aUT());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.inz.a(aVar.cak(), this.mIsHost, this.ijr.getUserData(), aVar.cal());
            }
            if (!this.mIsHost) {
                if (aVar.cam() == null || aVar.cam().ikx == null || aVar.cam().ikx.size() <= 0) {
                    this.iiQ.removeHeaderView(this.inw);
                } else {
                    this.inw.a(aVar.cam());
                }
            }
            if (v.aa(aVar.bwb())) {
                dQ(null);
                this.ije.aIG();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cfX().qi(this.mIsHost);
            dQ(aVar.bwb());
            int size = aVar.bwb().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bwb().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ije.aIG();
                    return;
                }
            }
            if (z) {
                if (this.dlX != null) {
                    this.dlX.ajz();
                    return;
                }
                return;
            }
            this.ije.c(true, aVar.bwb());
        }
    }

    public void bpD() {
        this.ije.bpD();
    }

    private void v(TbPageContext tbPageContext) {
        this.f1int = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iHM;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.ini != null && p.this.ini.imE != null) {
                            p.this.ini.imE.rF(aVar.hdg);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.ijr != null) {
                            if (p.this.ijr.ikn != null && p.this.ijr.ikn.ayy != null && aVar2 != null) {
                                p.this.ijr.ikn.ayy.putBoolean("person_center_item_red_tip_show", aVar2.hdg);
                            }
                            if (aVar3 != null && p.this.ijr.ikm != null && p.this.ijr.ikm.ayy != null) {
                                p.this.ijr.ikm.ayy.putBoolean("person_center_item_red_tip_show", aVar3.hdg);
                            }
                            if (aVar4 != null && p.this.ijr.ikk != null && p.this.ijr.ikk.ayy != null) {
                                p.this.ijr.ikk.ayy.putBoolean("person_center_item_red_tip_show", aVar4.hdg);
                            }
                            if (aVar5 != null && p.this.ijr.iko != null && p.this.ijr.iko.ayy != null) {
                                p.this.ijr.iko.ayy.putBoolean("person_center_item_red_tip_show", aVar5.hdg);
                            }
                            if (aVar6 != null && p.this.ijr.ikp != null && p.this.ijr.ikp.ayy != null) {
                                p.this.ijr.ikp.ayy.putBoolean("person_center_item_red_tip_show", aVar6.hdg);
                                p.this.ijr.ikp.ayy.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.inh instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.inh.N(5, aVar7.hdg);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.inh.N(6, aVar8.hdg);
                            }
                        }
                    }
                }
            }
        };
        this.f1int.setTag(this.Xk);
        tbPageContext.registerListener(this.f1int);
        this.idu = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.ini.Ce(lVar.abS());
                }
            }
        };
        this.idu.setTag(this.Xk);
        tbPageContext.registerListener(this.idu);
    }

    public void onDestory() {
        if (this.ini != null) {
            this.ini.onDestory();
        }
    }

    public com.baidu.tieba.view.f caw() {
        return this.inh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void es(boolean z) {
            if (z) {
                if (p.this.fpp == null) {
                    p.this.fpp = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.inn.akd() != null && !StringUtils.isNull(p.this.inn.akd().getUserId())) {
                    p.this.fpp.qk(p.this.inn.akd().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).afO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cax() {
        aUG();
        aUH();
        cay();
        if (this.ini.aUT().getTop() + this.ino <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.inj = aVar;
    }

    private void aUG() {
        if (Build.VERSION.SDK_INT >= 11 && this.ini != null) {
            int top = this.ini.aUT().getTop();
            if (top >= this.epS) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.epS) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.epS));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aUH() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.efl) {
                    this.efl = true;
                }
            } else if (this.efl) {
                this.efl = false;
            }
            a(alpha, !this.efl);
            this.inh.c(alpha, this.efl ? false : true);
        }
    }

    private void cay() {
        if (Build.VERSION.SDK_INT >= 11 && this.ini != null) {
            int i = this.epS / 2;
            int i2 = this.epS - i;
            int top = this.ini.aUT().getTop();
            if (this.inl != null) {
                if (top < i) {
                    if (this.inl.getAlpha() != 0.0f) {
                        this.inl.setAlpha(0.0f);
                    }
                } else if (top < this.epS && top >= i) {
                    if (i2 > 0) {
                        this.inl.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.epS && this.inl.getAlpha() != 1.0f) {
                    this.inl.setAlpha(1.0f);
                }
            }
            if (this.inm != null) {
                if (top >= i) {
                    if (this.inm.getAlpha() != 0.0f) {
                        this.inm.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.inm.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.inm.getAlpha() != 1.0f) {
                    this.inm.setAlpha(1.0f);
                }
            }
        }
    }

    public void dQ(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iiQ.getVisibility() != 0) {
            this.iiQ.setVisibility(0);
        }
        this.iiQ.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.inx) {
                pD(true);
                this.inx = false;
            }
        } else if (Z <= 1) {
            this.iiQ.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.ink = iVar;
    }

    public NavigationBar aJz() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.iiQ != null) {
            this.inA = str;
            this.inD = aVar;
            int headerViewsCount = (this.iiQ.getHeaderViewsCount() + i) - this.iiQ.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.inB = this.iiQ.getChildAt(headerViewsCount);
                if (this.inB != null) {
                    this.inC = this.inB.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.inB.getLayoutParams().height = p.this.inC - ((int) (p.this.inC * f));
                            p.this.inB.requestLayout();
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
                            p.this.inB.setVisibility(8);
                            if (p.this.inD != null) {
                                p.this.inD.removeThread(p.this.inA);
                            }
                        }
                    });
                    animation.setDuration(ing);
                    this.inB.startAnimation(animation);
                }
            }
        }
    }
}
