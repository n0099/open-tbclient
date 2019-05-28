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
    public static int inj = 300;
    private BdUniqueId Xk;
    private NoNetworkView dlX;
    private PbListView dlY;
    private ImageView eEu;
    private PluginErrorTipView eRW;
    private int epT;
    private com.baidu.tbadk.k.a fpq;
    private boolean idb;
    private CustomMessageListener idx;
    public BdPersonListView iiT;
    private com.baidu.tieba.personPolymeric.b.d ijh;
    private com.baidu.tieba.personPolymeric.c.a iju;
    private com.baidu.tieba.view.g imz;
    private boolean inA;
    private k inC;
    private String inD;
    private View inE;
    private int inF;
    private i.a inG;
    private com.baidu.tieba.view.f ink;
    public n inl;
    private com.baidu.tieba.model.a inm;
    private com.baidu.tieba.view.i inn;
    private TextView ino;
    private LikeButtonWithHeadPortrait inp;
    private com.baidu.tbadk.core.view.userLike.c inq;
    private int inr;

    /* renamed from: int  reason: not valid java name */
    private TextView f1int;
    private TextView inu;
    private com.baidu.tieba.personPolymeric.a.n inv;
    private CustomMessageListener inw;
    private View iny;
    private PersonCenterAttentionBarListView inz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean efm = true;
    private int ehu = 0;
    private boolean inx = false;
    private boolean inB = false;
    View.OnClickListener ckH = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b ijd = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.imz != null) {
                if (p.this.eEu == view) {
                    this.ijd.eXw = 8;
                }
                p.this.imz.a(view, this.ijd);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.inn != null) {
                p.this.inn.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.inn != null) {
                    p.this.inn.onScroll(absListView, i, i2, i3);
                }
                p.this.caA();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dlY != null && p.this.inm != null) {
                p.this.ijh.yk(p.this.ehu);
                if (p.this.ehu == 0) {
                    p.this.dlY.ajy();
                    p.this.inm.g(false, false, false);
                } else if (p.this.ehu == 1) {
                    p.this.dlY.ajy();
                    p.this.inm.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a inH = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bZL();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nF() {
            p.this.ijh.bpG();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.ijh.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.idb = false;
        this.mContext = tbPageContext;
        this.Xk = bdUniqueId;
        this.mIsHost = z;
        this.idb = z2;
        this.ijh = eVar.bZV();
        this.dlY = this.ijh.dlY;
        this.epT = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.ink = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.ink = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eRW = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.iiT = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.ink.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.iiT.setOnScrollListener(this.mOnScrollListener);
        this.inr = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.mIsHost) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.eEu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.view_topbar_icon, (View.OnClickListener) null);
        if (this.eEu.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eEu.getLayoutParams();
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds14);
            this.eEu.setLayoutParams(layoutParams2);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.item_person_center_navigation_title, (View.OnClickListener) null);
        this.ino = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.inp = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.inq = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.inp);
        this.inq.setFromType("2");
        this.inq.i(this.mContext.getUniqueId());
        this.inq.a(new a());
        this.f1int = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.inu = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.idb) {
            this.eEu.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.iiT.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.inl = new n(this.mContext, this.mIsHost);
        this.iny = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.iiT.addHeaderView(this.iny);
        this.iiT.setExpandView(this.iny);
        this.iiT.addHeaderView(this.inl.aUW());
        this.inC = new k(this.mContext);
        this.iiT.addHeaderView(this.inC.aUW());
        if (!this.mIsHost) {
            this.ino.setText(R.string.ta_homepage);
            this.inz = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.iiT.addHeaderView(this.inz);
        } else {
            this.ino.setText(R.string.my_homepage);
        }
        this.iiT.setPersonListRefreshListener(this.inH);
        this.inv = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.iiT, this.Xk);
        this.inv.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.inp.setAlpha(0.0f);
        this.ink.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.iju == null) {
            this.ink.c(1.0f, true);
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_black);
        } else {
            caA();
        }
        al.j(this.ino, R.color.cp_btn_a);
        this.inp.onChangeSkinType(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        if (this.ink != null) {
            this.ink.onChangeSkinType(i);
        }
        this.dlX.onChangeSkinType(this.mContext, i);
        this.eRW.onChangeSkinType(this.mContext, i);
        if (this.inl != null) {
            this.inl.onChangeSkinType(i);
        }
        if (this.iiT != null && (this.iiT.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.iiT.getAdapter().notifyDataSetChanged();
        }
        this.dlY.iP(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            al.e(this.inu, R.color.cp_cont_b, R.color.s_navbar_title_color);
            al.e(this.f1int, R.color.cp_btn_a, R.color.cp_btn_a);
        }
        if (this.inz != null) {
            this.inz.onChangeSkinType(i);
        }
        if (this.inC != null) {
            this.inC.onChangeSkinType(i);
        }
    }

    public void pD(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_black);
            this.ink.c(1.0f, true);
            this.ino.setAlpha(0.0f);
            this.inp.setAlpha(1.0f);
            this.iiT.setSelectionFromTop(this.iiT.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eEu, (int) R.drawable.selector_topbar_return_white);
        this.ink.c(0.0f, false);
        this.ino.setAlpha(1.0f);
        this.inp.setAlpha(0.0f);
    }

    public void BZ(String str) {
        if (this.inl != null) {
            this.inl.BM(str);
        }
    }

    public void Ca(String str) {
        if (this.inl != null) {
            this.inl.BN(str);
        }
    }

    public void bZL() {
        this.inx = false;
        if (this.ehu == 0) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inm.resetData();
                this.inm.refreshData();
                this.ijh.nE();
                return;
            }
            this.ijh.bpG();
        } else if (this.ehu == 1) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inm.g(true, true, true);
                this.ijh.nE();
                return;
            }
            this.ijh.bpG();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imz = gVar;
        this.ink.setOnViewResponseListener(gVar);
        this.eEu.setOnClickListener(this.ckH);
        this.inl.setOnViewResponseListener(gVar);
        if (this.ijh != null) {
            this.ijh.a(this.iny, gVar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.inv != null) {
            this.inv.T(onClickListener);
        }
    }

    public void pv(boolean z) {
        this.inA = z;
    }

    private void a(float f, boolean z) {
        float f2;
        if (z) {
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_black);
        } else {
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_white);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eEu.setAlpha(f2);
        }
        if (this.mIsHost) {
            this.f1int.setAlpha(1.0f - f);
            this.inu.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dQ(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pD(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.iju = aVar;
            this.ink.setUserData(this.iju.getUserData());
            if (this.inx) {
                dQ(aVar.bwe());
                if (this.dlY != null) {
                    this.dlY.ajz();
                    return;
                }
                return;
            }
            this.ink.bZI();
            this.inl.e(aVar);
            if (aVar != null) {
                this.inp.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.inp.cau();
            } else {
                this.iju.getUserData().setIsLike(this.iju.getUserData().getHave_attention() == 1);
                this.inq.a(this.iju.getUserData());
            }
            if ((aVar.can() == null || this.mIsHost) && v.aa(aVar.cao())) {
                this.iiT.removeHeaderView(this.inC.aUW());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.inC.a(aVar.can(), this.mIsHost, this.iju.getUserData(), aVar.cao());
            }
            if (!this.mIsHost) {
                if (aVar.cap() == null || aVar.cap().ikA == null || aVar.cap().ikA.size() <= 0) {
                    this.iiT.removeHeaderView(this.inz);
                } else {
                    this.inz.a(aVar.cap());
                }
            }
            if (v.aa(aVar.bwe())) {
                dQ(null);
                this.ijh.aIJ();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cfZ().qi(this.mIsHost);
            dQ(aVar.bwe());
            int size = aVar.bwe().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bwe().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.ijh.aIJ();
                    return;
                }
            }
            if (z) {
                if (this.dlY != null) {
                    this.dlY.ajz();
                    return;
                }
                return;
            }
            this.ijh.c(true, aVar.bwe());
        }
    }

    public void bpG() {
        this.ijh.bpG();
    }

    private void v(TbPageContext tbPageContext) {
        this.inw = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iHO;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.inl != null && p.this.inl.imH != null) {
                            p.this.inl.imH.rF(aVar.hdj);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.iju != null) {
                            if (p.this.iju.ikq != null && p.this.iju.ikq.ayy != null && aVar2 != null) {
                                p.this.iju.ikq.ayy.putBoolean("person_center_item_red_tip_show", aVar2.hdj);
                            }
                            if (aVar3 != null && p.this.iju.ikp != null && p.this.iju.ikp.ayy != null) {
                                p.this.iju.ikp.ayy.putBoolean("person_center_item_red_tip_show", aVar3.hdj);
                            }
                            if (aVar4 != null && p.this.iju.ikn != null && p.this.iju.ikn.ayy != null) {
                                p.this.iju.ikn.ayy.putBoolean("person_center_item_red_tip_show", aVar4.hdj);
                            }
                            if (aVar5 != null && p.this.iju.ikr != null && p.this.iju.ikr.ayy != null) {
                                p.this.iju.ikr.ayy.putBoolean("person_center_item_red_tip_show", aVar5.hdj);
                            }
                            if (aVar6 != null && p.this.iju.iks != null && p.this.iju.iks.ayy != null) {
                                p.this.iju.iks.ayy.putBoolean("person_center_item_red_tip_show", aVar6.hdj);
                                p.this.iju.iks.ayy.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.ink instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.ink.N(5, aVar7.hdj);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.ink.N(6, aVar8.hdj);
                            }
                        }
                    }
                }
            }
        };
        this.inw.setTag(this.Xk);
        tbPageContext.registerListener(this.inw);
        this.idx = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.inl.Ce(lVar.abS());
                }
            }
        };
        this.idx.setTag(this.Xk);
        tbPageContext.registerListener(this.idx);
    }

    public void onDestory() {
        if (this.inl != null) {
            this.inl.onDestory();
        }
    }

    public com.baidu.tieba.view.f caz() {
        return this.ink;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements c.a {
        private a() {
        }

        @Override // com.baidu.tbadk.core.view.userLike.c.a
        public void es(boolean z) {
            if (z) {
                if (p.this.fpq == null) {
                    p.this.fpq = new com.baidu.tbadk.k.a(p.this.mContext);
                }
                if (p.this.inq.akd() != null && !StringUtils.isNull(p.this.inq.akd().getUserId())) {
                    p.this.fpq.qk(p.this.inq.akd().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).afO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        aUJ();
        aUK();
        caB();
        if (this.inl.aUW().getTop() + this.inr <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.inm = aVar;
    }

    private void aUJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.inl != null) {
            int top = this.inl.aUW().getTop();
            if (top >= this.epT) {
                if (this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
                    this.mNavigationBar.getBarBgView().setAlpha(0.0f);
                }
            } else if (top > 0 && top < this.epT) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f - ((top * 1.0f) / this.epT));
            } else if (top <= 0 && this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            }
        }
    }

    private void aUK() {
        if (2 != TbadkCoreApplication.getInst().getSkinType()) {
            float alpha = this.mNavigationBar.getBarBgView().getAlpha();
            if (alpha < 0.5f) {
                if (!this.efm) {
                    this.efm = true;
                }
            } else if (this.efm) {
                this.efm = false;
            }
            a(alpha, !this.efm);
            this.ink.c(alpha, this.efm ? false : true);
        }
    }

    private void caB() {
        if (Build.VERSION.SDK_INT >= 11 && this.inl != null) {
            int i = this.epT / 2;
            int i2 = this.epT - i;
            int top = this.inl.aUW().getTop();
            if (this.ino != null) {
                if (top < i) {
                    if (this.ino.getAlpha() != 0.0f) {
                        this.ino.setAlpha(0.0f);
                    }
                } else if (top < this.epT && top >= i) {
                    if (i2 > 0) {
                        this.ino.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.epT && this.ino.getAlpha() != 1.0f) {
                    this.ino.setAlpha(1.0f);
                }
            }
            if (this.inp != null) {
                if (top >= i) {
                    if (this.inp.getAlpha() != 0.0f) {
                        this.inp.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.inp.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.inp.getAlpha() != 1.0f) {
                    this.inp.setAlpha(1.0f);
                }
            }
        }
    }

    public void dQ(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iiT.getVisibility() != 0) {
            this.iiT.setVisibility(0);
        }
        this.iiT.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.inA) {
                pD(true);
                this.inA = false;
            }
        } else if (Z <= 1) {
            this.iiT.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.inn = iVar;
    }

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.iiT != null) {
            this.inD = str;
            this.inG = aVar;
            int headerViewsCount = (this.iiT.getHeaderViewsCount() + i) - this.iiT.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.inE = this.iiT.getChildAt(headerViewsCount);
                if (this.inE != null) {
                    this.inF = this.inE.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.inE.getLayoutParams().height = p.this.inF - ((int) (p.this.inF * f));
                            p.this.inE.requestLayout();
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
                            p.this.inE.setVisibility(8);
                            if (p.this.inG != null) {
                                p.this.inG.removeThread(p.this.inD);
                            }
                        }
                    });
                    animation.setDuration(inj);
                    this.inE.startAnimation(animation);
                }
            }
        }
    }
}
