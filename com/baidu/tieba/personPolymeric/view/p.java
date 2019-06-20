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
    public static int ink = 300;
    private BdUniqueId Xj;
    private NoNetworkView dlX;
    private PbListView dlY;
    private ImageView eEu;
    private PluginErrorTipView eRW;
    private int epT;
    private com.baidu.tbadk.k.a fpq;
    private boolean idc;
    private CustomMessageListener idy;
    public BdPersonListView iiU;
    private com.baidu.tieba.personPolymeric.b.d iji;
    private com.baidu.tieba.personPolymeric.c.a ijv;
    private com.baidu.tieba.view.g imA;
    private PersonCenterAttentionBarListView inA;
    private boolean inB;
    private k inD;
    private String inE;
    private View inF;
    private int inG;
    private i.a inH;
    private com.baidu.tieba.view.f inl;
    public n inm;
    private com.baidu.tieba.model.a inn;
    private com.baidu.tieba.view.i ino;
    private TextView inp;
    private LikeButtonWithHeadPortrait inq;
    private com.baidu.tbadk.core.view.userLike.c inr;

    /* renamed from: int  reason: not valid java name */
    private int f1int;
    private TextView inu;
    private TextView inv;
    private com.baidu.tieba.personPolymeric.a.n inw;
    private CustomMessageListener inx;
    private View inz;
    private TbPageContext mContext;
    private boolean mIsHost;
    private NavigationBar mNavigationBar;
    public View mRootView;
    private boolean efm = true;
    private int ehu = 0;
    private boolean iny = false;
    private boolean inC = false;
    View.OnClickListener ckI = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.view.p.1
        com.baidu.tieba.personPolymeric.event.b ije = new com.baidu.tieba.personPolymeric.event.b();

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p.this.imA != null) {
                if (p.this.eEu == view) {
                    this.ije.eXw = 8;
                }
                p.this.imA.a(view, this.ije);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personPolymeric.view.p.4
        private int mScrollState = 0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (p.this.ino != null) {
                p.this.ino.onScrollStateChanged(absListView, i);
            }
            this.mScrollState = i;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.mScrollState == 1 || this.mScrollState == 2 || this.mScrollState == 0) {
                if (p.this.ino != null) {
                    p.this.ino.onScroll(absListView, i, i2, i3);
                }
                p.this.caB();
            }
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.view.p.7
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (p.this.dlY != null && p.this.inn != null) {
                p.this.iji.yk(p.this.ehu);
                if (p.this.ehu == 0) {
                    p.this.dlY.ajy();
                    p.this.inn.g(false, false, false);
                } else if (p.this.ehu == 1) {
                    p.this.dlY.ajy();
                    p.this.inn.g(true, false, false);
                }
            }
        }
    };
    private BdPersonListView.a inI = new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.view.p.8
        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void onRefresh() {
            p.this.bZM();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void nF() {
            p.this.iji.bpI();
        }

        @Override // com.baidu.tieba.person.listview.BdPersonListView.a
        public void N(float f) {
            p.this.iji.M(f);
        }
    };

    public p(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.e eVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        this.idc = false;
        this.mContext = tbPageContext;
        this.Xj = bdUniqueId;
        this.mIsHost = z;
        this.idc = z2;
        this.iji = eVar.bZW();
        this.dlY = this.iji.dlY;
        this.epT = com.baidu.adp.lib.util.l.g(this.mContext.getPageActivity(), R.dimen.tbds402);
        if (z) {
            this.inl = new com.baidu.tieba.view.d(2);
            v(tbPageContext);
            return;
        }
        this.inl = new com.baidu.tieba.personPolymeric.a();
    }

    public void O(View view) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.person_center_navigation_bar);
        this.mNavigationBar.setBottomLineColor(R.color.cp_bg_line_c);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.person_center_no_network_view);
        this.eRW = (PluginErrorTipView) this.mRootView.findViewById(R.id.person_center_plugin_error_tip_view);
        this.iiU = (BdPersonListView) this.mRootView.findViewById(R.id.person_center_listview);
        ViewGroup.LayoutParams layoutParams = this.mNavigationBar.getBottomLine().getLayoutParams();
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mNavigationBar.getBottomLine().setLayoutParams(layoutParams);
        this.inl.a(this.mContext.getPageActivity(), this.mNavigationBar);
        this.iiU.setOnScrollListener(this.mOnScrollListener);
        this.f1int = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds70);
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
        this.inp = (TextView) view.findViewById(R.id.tv_title_above_navigation_bar);
        this.inq = (LikeButtonWithHeadPortrait) view.findViewById(R.id.like_btn_with_head_portrait);
        this.inr = new com.baidu.tbadk.core.view.userLike.c(this.mContext, this.inq);
        this.inr.setFromType("2");
        this.inr.i(this.mContext.getUniqueId());
        this.inr.a(new a());
        this.inu = (TextView) addCustomView.findViewById(R.id.person_center_navigation_title);
        this.inv = (TextView) addCustomView.findViewById(R.id.person_center_navigation_another_title);
        if (!this.idc) {
            this.eEu.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.iiU.setOnSrollToBottomListener(this.mOnScrollToBottomListener);
        this.inm = new n(this.mContext, this.mIsHost);
        this.inz = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.view_header_expand, (ViewGroup) null);
        this.iiU.addHeaderView(this.inz);
        this.iiU.setExpandView(this.inz);
        this.iiU.addHeaderView(this.inm.aUW());
        this.inD = new k(this.mContext);
        this.iiU.addHeaderView(this.inD.aUW());
        if (!this.mIsHost) {
            this.inp.setText(R.string.ta_homepage);
            this.inA = new PersonCenterAttentionBarListView(this.mContext.getPageActivity());
            this.iiU.addHeaderView(this.inA);
        } else {
            this.inp.setText(R.string.my_homepage);
        }
        this.iiU.setPersonListRefreshListener(this.inI);
        this.inw = new com.baidu.tieba.personPolymeric.a.n(this.mContext, this.iiU, this.Xj);
        this.inw.setIsHost(this.mIsHost);
        this.mNavigationBar.setVisibility(0);
        this.mNavigationBar.getBarBgView().setAlpha(1.0f);
        this.mNavigationBar.showBottomLine();
        this.inq.setAlpha(0.0f);
        this.inl.c(1.0f, true);
    }

    public void onChangeSkinType(int i) {
        if (this.ijv == null) {
            this.inl.c(1.0f, true);
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_black);
        } else {
            caB();
        }
        al.j(this.inp, R.color.cp_btn_a);
        this.inq.onChangeSkinType(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(null, i);
        this.mNavigationBar.getBackground().mutate().setAlpha(0);
        al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        if (this.inl != null) {
            this.inl.onChangeSkinType(i);
        }
        this.dlX.onChangeSkinType(this.mContext, i);
        this.eRW.onChangeSkinType(this.mContext, i);
        if (this.inm != null) {
            this.inm.onChangeSkinType(i);
        }
        if (this.iiU != null && (this.iiU.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            this.iiU.getAdapter().notifyDataSetChanged();
        }
        this.dlY.iP(i);
        al.k(this.mRootView, R.color.cp_bg_line_d);
        if (this.mIsHost) {
            al.e(this.inv, R.color.cp_cont_b, R.color.s_navbar_title_color);
            al.e(this.inu, R.color.cp_btn_a, R.color.cp_btn_a);
        }
        if (this.inA != null) {
            this.inA.onChangeSkinType(i);
        }
        if (this.inD != null) {
            this.inD.onChangeSkinType(i);
        }
    }

    public void pE(boolean z) {
        if (z) {
            this.mNavigationBar.getBarBgView().setAlpha(1.0f);
            al.c(this.eEu, (int) R.drawable.selector_topbar_return_black);
            this.inl.c(1.0f, true);
            this.inp.setAlpha(0.0f);
            this.inq.setAlpha(1.0f);
            this.iiU.setSelectionFromTop(this.iiU.getHeaderViewsCount() - 1, this.mNavigationBar.getHeight());
            return;
        }
        this.mNavigationBar.getBarBgView().setAlpha(0.0f);
        al.c(this.eEu, (int) R.drawable.selector_topbar_return_white);
        this.inl.c(0.0f, false);
        this.inp.setAlpha(1.0f);
        this.inq.setAlpha(0.0f);
    }

    public void Cb(String str) {
        if (this.inm != null) {
            this.inm.BO(str);
        }
    }

    public void Cc(String str) {
        if (this.inm != null) {
            this.inm.BP(str);
        }
    }

    public void bZM() {
        this.iny = false;
        if (this.ehu == 0) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inn.resetData();
                this.inn.refreshData();
                this.iji.nE();
                return;
            }
            this.iji.bpI();
        } else if (this.ehu == 1) {
            if (com.baidu.adp.lib.util.j.jS()) {
                this.inn.g(true, true, true);
                this.iji.nE();
                return;
            }
            this.iji.bpI();
        }
    }

    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        this.imA = gVar;
        this.inl.setOnViewResponseListener(gVar);
        this.eEu.setOnClickListener(this.ckI);
        this.inm.setOnViewResponseListener(gVar);
        if (this.iji != null) {
            this.iji.a(this.inz, gVar);
        }
    }

    public void T(View.OnClickListener onClickListener) {
        if (this.inw != null) {
            this.inw.T(onClickListener);
        }
    }

    public void pw(boolean z) {
        this.inB = z;
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
            this.inu.setAlpha(1.0f - f);
            this.inv.setAlpha(f);
        }
    }

    public void aA(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        dQ(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        pE(false);
        if (aVar != null) {
            this.mNavigationBar.hideBottomLine();
            this.ijv = aVar;
            this.inl.setUserData(this.ijv.getUserData());
            if (this.iny) {
                dQ(aVar.bwf());
                if (this.dlY != null) {
                    this.dlY.ajz();
                    return;
                }
                return;
            }
            this.inl.bZJ();
            this.inm.e(aVar);
            if (aVar != null) {
                this.inq.e(aVar.getUserData());
            }
            if (this.mIsHost) {
                this.inq.cav();
            } else {
                this.ijv.getUserData().setIsLike(this.ijv.getUserData().getHave_attention() == 1);
                this.inr.a(this.ijv.getUserData());
            }
            if ((aVar.cao() == null || this.mIsHost) && v.aa(aVar.cap())) {
                this.iiU.removeHeaderView(this.inD.aUW());
            } else {
                TiebaStatic.log(new am("c12543"));
                this.inD.a(aVar.cao(), this.mIsHost, this.ijv.getUserData(), aVar.cap());
            }
            if (!this.mIsHost) {
                if (aVar.caq() == null || aVar.caq().ikB == null || aVar.caq().ikB.size() <= 0) {
                    this.iiU.removeHeaderView(this.inA);
                } else {
                    this.inA.a(aVar.caq());
                }
            }
            if (v.aa(aVar.bwf())) {
                dQ(null);
                this.iji.aIJ();
                com.baidu.adp.lib.util.l.showToast(this.mContext.getContext(), this.mContext.getString(R.string.data_load_error));
                return;
            }
            com.baidu.tieba.o.a.cga().qj(this.mIsHost);
            dQ(aVar.bwf());
            int size = aVar.bwf().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.m mVar = aVar.bwf().get(i);
                if (mVar != null && (mVar instanceof com.baidu.tieba.personPolymeric.c.i)) {
                    this.iji.aIJ();
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
            this.iji.c(true, aVar.bwf());
        }
    }

    public void bpI() {
        this.iji.bpI();
    }

    private void v(TbPageContext tbPageContext) {
        this.inx = new CustomMessageListener(2001435) { // from class: com.baidu.tieba.personPolymeric.view.p.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.o.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.o.b) customResponsedMessage.getData()).iHS;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && p.this.inm != null && p.this.inm.imI != null) {
                            p.this.inm.imI.rG(aVar.hdk);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (p.this.ijv != null) {
                            if (p.this.ijv.ikr != null && p.this.ijv.ikr.ayy != null && aVar2 != null) {
                                p.this.ijv.ikr.ayy.putBoolean("person_center_item_red_tip_show", aVar2.hdk);
                            }
                            if (aVar3 != null && p.this.ijv.ikq != null && p.this.ijv.ikq.ayy != null) {
                                p.this.ijv.ikq.ayy.putBoolean("person_center_item_red_tip_show", aVar3.hdk);
                            }
                            if (aVar4 != null && p.this.ijv.iko != null && p.this.ijv.iko.ayy != null) {
                                p.this.ijv.iko.ayy.putBoolean("person_center_item_red_tip_show", aVar4.hdk);
                            }
                            if (aVar5 != null && p.this.ijv.iks != null && p.this.ijv.iks.ayy != null) {
                                p.this.ijv.iks.ayy.putBoolean("person_center_item_red_tip_show", aVar5.hdk);
                            }
                            if (aVar6 != null && p.this.ijv.ikt != null && p.this.ijv.ikt.ayy != null) {
                                p.this.ijv.ikt.ayy.putBoolean("person_center_item_red_tip_show", aVar6.hdk);
                                p.this.ijv.ikt.ayy.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                            }
                        }
                        if (p.this.inl instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                p.this.inl.N(5, aVar7.hdk);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                p.this.inl.N(6, aVar8.hdk);
                            }
                        }
                    }
                }
            }
        };
        this.inx.setTag(this.Xj);
        tbPageContext.registerListener(this.inx);
        this.idy = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.personPolymeric.view.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.l lVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l) && (lVar = (com.baidu.tbadk.data.l) customResponsedMessage.getData()) != null) {
                    p.this.inm.Cg(lVar.abS());
                }
            }
        };
        this.idy.setTag(this.Xj);
        tbPageContext.registerListener(this.idy);
    }

    public void onDestory() {
        if (this.inm != null) {
            this.inm.onDestory();
        }
    }

    public com.baidu.tieba.view.f caA() {
        return this.inl;
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
                if (p.this.inr.akd() != null && !StringUtils.isNull(p.this.inr.akd().getUserId())) {
                    p.this.fpq.qj(p.this.inr.akd().getUserId());
                    return;
                }
                return;
            }
            BdToast.b(p.this.mContext.getPageActivity(), p.this.mContext.getString(R.string.unlike_success)).afO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        aUJ();
        aUK();
        caC();
        if (this.inm.aUW().getTop() + this.f1int <= this.mNavigationBar.getBottom()) {
            this.mNavigationBar.showBottomLine();
        } else {
            this.mNavigationBar.hideBottomLine();
        }
    }

    public void a(com.baidu.tieba.model.a aVar) {
        this.inn = aVar;
    }

    private void aUJ() {
        if (Build.VERSION.SDK_INT >= 11 && this.inm != null) {
            int top = this.inm.aUW().getTop();
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
            this.inl.c(alpha, this.efm ? false : true);
        }
    }

    private void caC() {
        if (Build.VERSION.SDK_INT >= 11 && this.inm != null) {
            int i = this.epT / 2;
            int i2 = this.epT - i;
            int top = this.inm.aUW().getTop();
            if (this.inp != null) {
                if (top < i) {
                    if (this.inp.getAlpha() != 0.0f) {
                        this.inp.setAlpha(0.0f);
                    }
                } else if (top < this.epT && top >= i) {
                    if (i2 > 0) {
                        this.inp.setAlpha(((top - i) * 1.0f) / i2);
                    } else {
                        return;
                    }
                } else if (top >= this.epT && this.inp.getAlpha() != 1.0f) {
                    this.inp.setAlpha(1.0f);
                }
            }
            if (this.inq != null) {
                if (top >= i) {
                    if (this.inq.getAlpha() != 0.0f) {
                        this.inq.setAlpha(0.0f);
                    }
                } else if (top > 0 && top < i) {
                    this.inq.setAlpha(1.0f - ((top * 1.0f) / i));
                } else if (top <= 0 && this.inq.getAlpha() != 1.0f) {
                    this.inq.setAlpha(1.0f);
                }
            }
        }
    }

    public void dQ(List<com.baidu.adp.widget.ListView.m> list) {
        if (v.aa(list)) {
            list = new ArrayList<>();
        }
        if (this.iiU.getVisibility() != 0) {
            this.iiU.setVisibility(0);
        }
        this.iiU.setData(list);
        int Z = v.Z(list);
        if (Z >= 5) {
            if (this.inB) {
                pE(true);
                this.inB = false;
            }
        } else if (Z <= 1) {
            this.iiU.smoothScrollToPosition(0);
        }
    }

    public void a(com.baidu.tieba.view.i iVar) {
        this.ino = iVar;
    }

    public NavigationBar aJC() {
        return this.mNavigationBar;
    }

    public void a(int i, String str, i.a aVar) {
        if (!ap.isEmpty(str) && this.iiU != null) {
            this.inE = str;
            this.inH = aVar;
            int headerViewsCount = (this.iiU.getHeaderViewsCount() + i) - this.iiU.getFirstVisiblePosition();
            if (headerViewsCount >= 0) {
                this.inF = this.iiU.getChildAt(headerViewsCount);
                if (this.inF != null) {
                    this.inG = this.inF.getMeasuredHeight();
                    Animation animation = new Animation() { // from class: com.baidu.tieba.personPolymeric.view.p.5
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f, Transformation transformation) {
                            p.this.inF.getLayoutParams().height = p.this.inG - ((int) (p.this.inG * f));
                            p.this.inF.requestLayout();
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
                            p.this.inF.setVisibility(8);
                            if (p.this.inH != null) {
                                p.this.inH.removeThread(p.this.inE);
                            }
                        }
                    });
                    animation.setDuration(ink);
                    this.inF.startAnimation(animation);
                }
            }
        }
    }
}
