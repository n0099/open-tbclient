package com.baidu.tieba.personPolymeric.d;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.view.h {
    private BdUniqueId aBb;
    View.OnClickListener avX;
    private ImageView bFK;
    private boolean bFn;
    private com.baidu.tieba.personPolymeric.b.c bFt;
    private CustomMessageListener bFu;
    private PbListView beu;
    private boolean blT;
    private int bzJ;
    private com.baidu.tieba.personPolymeric.c.a fkT;
    private TextView fof;
    private TextView fog;
    private com.baidu.tieba.personPolymeric.a.n foh;
    private CustomMessageListener foi;
    private com.baidu.tieba.personCenter.a.a foj;
    private GridView fok;
    private l fol;
    private com.baidu.tieba.person.data.c fom;
    private p fon;
    private boolean foo;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bzJ = 0;
        this.foo = false;
        this.bFn = false;
        this.avX = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fob = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.fgG != null) {
                    if (s.this.bFK == view) {
                        this.fob.cbk = 8;
                    }
                    s.this.fgG.a(view, this.fob);
                }
            }
        };
        this.aBb = bdUniqueId;
        this.blT = z;
        this.bFn = z2;
        this.byl = (int) this.acr.getResources().getDimension(d.f.ds720);
        this.bFt = dVar.aYO();
        this.beu = this.bFt.beu;
        if (z) {
            this.gxO = new com.baidu.tieba.view.d();
            l(tbPageContext);
            return;
        }
        this.gxO = new com.baidu.tieba.view.c();
    }

    @Override // com.baidu.tieba.view.h
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.blT) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bFK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fof = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fog = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bFn) {
            this.bFK.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fkD.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.beu != null && s.this.gxV != null) {
                    if (s.this.bzJ == 0) {
                        s.this.beu.wX();
                        s.this.gxV.g(false, false, false);
                    } else if (s.this.bzJ == 1) {
                        s.this.beu.wX();
                        s.this.gxV.g(true, false, false);
                    }
                }
            }
        });
        this.gxQ = new q(this.acr, this.blT);
        this.fkD.addHeaderView(this.gxQ.UE());
        this.fkD.setExpandView(this.gxQ.UE());
        this.fkD.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void li() {
                s.this.Wc();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void lh() {
                s.this.gxQ.ajD();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void G(float f) {
                s.this.gxQ.F(f);
            }
        });
        this.foh = new com.baidu.tieba.personPolymeric.a.n(this.acr, this.fkD, this.aBb);
        this.foh.setIsHost(this.blT);
        if (this.blT) {
            this.gxR = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.fok = (GridView) this.gxR.findViewById(d.h.person_center_function_grid_view);
            this.gxT = this.gxR.findViewById(d.h.divider_line);
            this.foj = new com.baidu.tieba.personCenter.a.a(this.acr.getPageActivity());
            this.fok.setAdapter((ListAdapter) this.foj);
            this.fkD.addHeaderView(this.gxR);
            if (!this.bFn) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fkD.getLayoutParams();
                layoutParams.bottomMargin = this.acr.getResources().getDimensionPixelSize(d.f.ds100);
                this.fkD.setLayoutParams(layoutParams);
            }
        } else {
            this.gxS = new k(this.acr.getPageActivity());
            this.fkD.addHeaderView(this.gxS);
            this.fol = new l(this.acr.getPageActivity());
            this.fkD.addHeaderView(this.fol);
        }
        this.fon = new p(TbadkCoreApplication.getInst(), this);
        this.gfa = this.fon.Yj();
        this.fkD.addHeaderView(this.gfa);
        this.mNavigationBar.setVisibility(0);
        this.fkD.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void Wc() {
        this.foo = false;
        if (this.bzJ == 0) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gxV.resetData();
                this.gxV.refreshData();
                this.gxQ.lg();
                return;
            }
            this.gxQ.ajD();
        } else if (this.bzJ == 1) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gxV.g(true, true, true);
                this.gxQ.lg();
                return;
            }
            this.gxQ.ajD();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aZm() {
        if (this.gyb) {
            this.gxU.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fkE.setVisibility(8);
        this.fon.pk(this.bzJ);
        ((RelativeLayout.LayoutParams) this.bes.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void ajW() {
        if (this.gyb) {
            this.gxU.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fkE.setVisibility(0);
        pk(this.bzJ);
        ((RelativeLayout.LayoutParams) this.bes.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bFK.setOnClickListener(this.avX);
        this.gxQ.setOnViewResponseListener(gVar);
        if (this.foj != null) {
            this.foj.setOnViewResponseListener(gVar);
        }
        if (this.gxS != null) {
            this.gxS.setOnViewResponseListener(gVar);
        }
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.foh != null) {
            this.foh.J(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.blT) {
                if (this.bFn) {
                    ai.b(this.bFK, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fof.setVisibility(8);
                    this.fog.setVisibility(0);
                    ai.b(this.fog, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                ai.b(this.bFK, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.blT) {
            if (this.bFn) {
                ai.b(this.bFK, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fof.setVisibility(0);
                this.fog.setVisibility(8);
                ai.b(this.fof, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            ai.b(this.bFK, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bFK.setAlpha(f2);
        }
        if (this.blT) {
            this.fof.setAlpha(1.0f - f);
            this.fog.setAlpha(f);
        }
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cK(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.mWebView.setVisibility(8);
            this.fkT = aVar;
            if (this.foo) {
                cK(aVar.aqN());
                if (this.beu != null) {
                    this.beu.wY();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gxO.Wn();
            this.gxQ.e(aVar);
            if (this.blT) {
                this.foj.setData(aVar.aZh());
                this.foj.notifyDataSetChanged();
            } else {
                if (this.gxS != null && aVar.getUserData() != null) {
                    this.gxS.setUserData(aVar.getUserData());
                }
                if (aVar.aZg() == null || aVar.aZg().fmh == null || aVar.aZg().fmh.size() <= 0) {
                    this.fkD.removeHeaderView(this.fol);
                } else {
                    this.fol.a(aVar.aZg());
                }
            }
            if (u.v(aVar.aqN())) {
                cK(null);
                this.bFt.XZ();
                com.baidu.adp.lib.util.k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.biZ().bje();
            cK(aVar.aqN());
            int size = aVar.aqN().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.aqN().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bFt.XZ();
                    return;
                }
            }
            if (z) {
                if (this.beu != null) {
                    this.beu.wY();
                    return;
                }
                return;
            }
            this.bFt.dN(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fkD.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.fok, d.e.cp_bg_line_d);
        ai.k(this.gxR, d.e.cp_bg_line_d);
        ai.k(this.gxT, d.e.cp_bg_line_b);
        if (this.foj != null) {
            this.foj.notifyDataSetChanged();
        }
        if (this.fon != null) {
            this.fon.onChangeSkinType();
        }
        if (2 == i) {
            ai.b(this.bFK, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hr()) {
                ai.b(this.bFK, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                ai.b(this.bFK, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.beu.dp(i);
            ai.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.blT) {
            ai.b(this.fog, d.e.cp_cont_b, d.e.s_navbar_title_color);
            ai.b(this.fof, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.gxS != null) {
            this.gxS.onChangeSkinType();
        }
    }

    public void ajD() {
        ((q) this.gxQ).ajD();
    }

    private void l(TbPageContext tbPageContext) {
        this.bFu = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fMp;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gxQ != null && s.this.gxQ.gyz != null) {
                            s.this.gxQ.gyz.mX(aVar.dVB);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.fkT != null) {
                            if (s.this.fkT.flW != null && s.this.fkT.flW.cbl != null && aVar2 != null) {
                                s.this.fkT.flW.cbl.putBoolean("person_center_item_red_tip_show", aVar2.dVB);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fkT.flV != null && s.this.fkT.flV.cbl != null) {
                                s.this.fkT.flV.cbl.putBoolean("person_center_item_red_tip_show", aVar3.dVB);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fkT.flT != null && s.this.fkT.flT.cbl != null) {
                                s.this.fkT.flT.cbl.putBoolean("person_center_item_red_tip_show", aVar4.dVB);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fkT.flX != null && s.this.fkT.flX.cbl != null) {
                                s.this.fkT.flX.cbl.putBoolean("person_center_item_red_tip_show", aVar5.dVB);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fkT.flY != null && s.this.fkT.flY.cbl != null) {
                                s.this.fkT.flY.cbl.putBoolean("person_center_item_red_tip_show", aVar6.dVB);
                                s.this.fkT.flY.cbl.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.foj != null) {
                                s.this.foj.setData(s.this.fkT.aZh());
                                s.this.foj.notifyDataSetChanged();
                            }
                        }
                        if (s.this.gxO instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gxO.m(5, aVar7.dVB);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gxO.m(6, aVar8.dVB);
                            }
                        }
                    }
                }
            }
        };
        this.bFu.setTag(this.aBb);
        tbPageContext.registerListener(this.bFu);
        this.foi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.gxQ.sR(jVar.pW());
                }
            }
        };
        this.foi.setTag(this.aBb);
        tbPageContext.registerListener(this.foi);
    }

    public void onDestory() {
        if (this.gxQ != null) {
            this.gxQ.onDestory();
        }
        if (this.fkE != null) {
            this.fkE.setVisibility(8);
        }
    }

    public void qq(int i) {
        this.foo = false;
        int i2 = i == 0 ? 1 : 0;
        this.gxV.a(i2, this.gxV.hp(i2));
        this.fom = this.gxV.hp(i);
        if (this.fom.aXH() == null) {
            this.foo = true;
            if (i == 0) {
                this.gxV.Px();
                return;
            } else if (i == 1) {
                this.gxV.g(true, true, false);
                return;
            } else {
                return;
            }
        }
        cK(this.fom.aXH());
        if (this.fom.aXH().size() <= 1 && this.fkE.getVisibility() == 0) {
            this.fkD.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qr(int i) {
        if (i != this.bzJ && this.gxV != null) {
            this.bzJ = i;
            qq(i);
        }
    }

    public com.baidu.tieba.view.f aZn() {
        return this.gxO;
    }
}
