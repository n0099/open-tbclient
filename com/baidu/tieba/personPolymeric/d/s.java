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
    View.OnClickListener auE;
    private BdUniqueId azI;
    private CustomMessageListener bDA;
    private ImageView bDQ;
    private boolean bDt;
    private com.baidu.tieba.personPolymeric.b.c bDz;
    private PbListView bdh;
    private boolean bkz;
    private int bxP;
    private com.baidu.tieba.personPolymeric.c.a fhK;
    private TextView fkY;
    private TextView fkZ;
    private com.baidu.tieba.personPolymeric.a.n fla;
    private CustomMessageListener flb;
    private com.baidu.tieba.personCenter.a.a flc;
    private GridView fld;
    private l fle;
    private com.baidu.tieba.person.data.c flf;
    private p flg;
    private boolean flh;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bxP = 0;
        this.flh = false;
        this.bDt = false;
        this.auE = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fkU = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.fdz != null) {
                    if (s.this.bDQ == view) {
                        this.fkU.bZr = 8;
                    }
                    s.this.fdz.a(view, this.fkU);
                }
            }
        };
        this.azI = bdUniqueId;
        this.bkz = z;
        this.bDt = z2;
        this.bwr = (int) this.aaS.getResources().getDimension(d.f.ds720);
        this.bDz = dVar.aYb();
        this.bdh = this.bDz.bdh;
        if (z) {
            this.guL = new com.baidu.tieba.view.d();
            l(tbPageContext);
            return;
        }
        this.guL = new com.baidu.tieba.view.c();
    }

    @Override // com.baidu.tieba.view.h
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bkz) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bDQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fkY = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fkZ = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bDt) {
            this.bDQ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fhu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.bdh != null && s.this.guS != null) {
                    if (s.this.bxP == 0) {
                        s.this.bdh.wN();
                        s.this.guS.f(false, false, false);
                    } else if (s.this.bxP == 1) {
                        s.this.bdh.wN();
                        s.this.guS.f(true, false, false);
                    }
                }
            }
        });
        this.guN = new q(this.aaS, this.bkz);
        this.fhu.addHeaderView(this.guN.Uf());
        this.fhu.setExpandView(this.guN.Uf());
        this.fhu.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void kZ() {
                s.this.VE();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void kY() {
                s.this.guN.aiQ();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void G(float f) {
                s.this.guN.F(f);
            }
        });
        this.fla = new com.baidu.tieba.personPolymeric.a.n(this.aaS, this.fhu, this.azI);
        this.fla.setIsHost(this.bkz);
        if (this.bkz) {
            this.guO = LayoutInflater.from(this.aaS.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.fld = (GridView) this.guO.findViewById(d.h.person_center_function_grid_view);
            this.guQ = this.guO.findViewById(d.h.divider_line);
            this.flc = new com.baidu.tieba.personCenter.a.a(this.aaS.getPageActivity());
            this.fld.setAdapter((ListAdapter) this.flc);
            this.fhu.addHeaderView(this.guO);
            if (!this.bDt) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fhu.getLayoutParams();
                layoutParams.bottomMargin = this.aaS.getResources().getDimensionPixelSize(d.f.ds100);
                this.fhu.setLayoutParams(layoutParams);
            }
        } else {
            this.guP = new k(this.aaS.getPageActivity());
            this.fhu.addHeaderView(this.guP);
            this.fle = new l(this.aaS.getPageActivity());
            this.fhu.addHeaderView(this.fle);
        }
        this.flg = new p(TbadkCoreApplication.getInst(), this);
        this.gbW = this.flg.XM();
        this.fhu.addHeaderView(this.gbW);
        this.mNavigationBar.setVisibility(0);
        this.fhu.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void VE() {
        this.flh = false;
        if (this.bxP == 0) {
            if (com.baidu.adp.lib.util.i.hh()) {
                this.guS.resetData();
                this.guS.refreshData();
                this.guN.kX();
                return;
            }
            this.guN.aiQ();
        } else if (this.bxP == 1) {
            if (com.baidu.adp.lib.util.i.hh()) {
                this.guS.f(true, true, true);
                this.guN.kX();
                return;
            }
            this.guN.aiQ();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aYz() {
        if (this.guY) {
            this.guR.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fhv.setVisibility(8);
        this.flg.pa(this.bxP);
        ((RelativeLayout.LayoutParams) this.bdg.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void ajj() {
        if (this.guY) {
            this.guR.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fhv.setVisibility(0);
        pa(this.bxP);
        ((RelativeLayout.LayoutParams) this.bdg.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bDQ.setOnClickListener(this.auE);
        this.guN.setOnViewResponseListener(gVar);
        if (this.flc != null) {
            this.flc.setOnViewResponseListener(gVar);
        }
        if (this.guP != null) {
            this.guP.setOnViewResponseListener(gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fla != null) {
            this.fla.N(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.bkz) {
                if (this.bDt) {
                    ai.b(this.bDQ, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fkY.setVisibility(8);
                    this.fkZ.setVisibility(0);
                    ai.b(this.fkZ, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                ai.b(this.bDQ, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.bkz) {
            if (this.bDt) {
                ai.b(this.bDQ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fkY.setVisibility(0);
                this.fkZ.setVisibility(8);
                ai.b(this.fkY, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            ai.b(this.bDQ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bDQ.setAlpha(f2);
        }
        if (this.bkz) {
            this.fkY.setAlpha(1.0f - f);
            this.fkZ.setAlpha(f);
        }
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cH(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.mWebView.setVisibility(8);
            this.fhK = aVar;
            if (this.flh) {
                cH(aVar.aqa());
                if (this.bdh != null) {
                    this.bdh.wO();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.guL.VP();
            this.guN.e(aVar);
            if (this.bkz) {
                this.flc.setData(aVar.aYu());
                this.flc.notifyDataSetChanged();
            } else {
                if (this.guP != null && aVar.getUserData() != null) {
                    this.guP.setUserData(aVar.getUserData());
                }
                if (aVar.aYt() == null || aVar.aYt().fja == null || aVar.aYt().fja.size() <= 0) {
                    this.fhu.removeHeaderView(this.fle);
                } else {
                    this.fle.a(aVar.aYt());
                }
            }
            if (u.v(aVar.aqa())) {
                cH(null);
                this.bDz.XC();
                com.baidu.adp.lib.util.k.showToast(this.aaS.getContext(), this.aaS.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bio().bit();
            cH(aVar.aqa());
            int size = aVar.aqa().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.aqa().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bDz.XC();
                    return;
                }
            }
            if (z) {
                if (this.bdh != null) {
                    this.bdh.wO();
                    return;
                }
                return;
            }
            this.bDz.dM(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fhu.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.fld, d.e.cp_bg_line_d);
        ai.k(this.guO, d.e.cp_bg_line_d);
        ai.k(this.guQ, d.e.cp_bg_line_b);
        if (this.flc != null) {
            this.flc.notifyDataSetChanged();
        }
        if (this.flg != null) {
            this.flg.onChangeSkinType();
        }
        if (2 == i) {
            ai.b(this.bDQ, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hh()) {
                ai.b(this.bDQ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                ai.b(this.bDQ, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.bdh.dn(i);
            ai.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.bkz) {
            ai.b(this.fkZ, d.e.cp_cont_b, d.e.s_navbar_title_color);
            ai.b(this.fkY, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.guP != null) {
            this.guP.onChangeSkinType();
        }
    }

    public void aiQ() {
        ((q) this.guN).aiQ();
    }

    private void l(TbPageContext tbPageContext) {
        this.bDA = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fJi;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.guN != null && s.this.guN.gvw != null) {
                            s.this.guN.gvw.mU(aVar.dSo);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.fhK != null) {
                            if (s.this.fhK.fiP != null && s.this.fhK.fiP.bZs != null && aVar2 != null) {
                                s.this.fhK.fiP.bZs.putBoolean("person_center_item_red_tip_show", aVar2.dSo);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fhK.fiO != null && s.this.fhK.fiO.bZs != null) {
                                s.this.fhK.fiO.bZs.putBoolean("person_center_item_red_tip_show", aVar3.dSo);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fhK.fiM != null && s.this.fhK.fiM.bZs != null) {
                                s.this.fhK.fiM.bZs.putBoolean("person_center_item_red_tip_show", aVar4.dSo);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fhK.fiQ != null && s.this.fhK.fiQ.bZs != null) {
                                s.this.fhK.fiQ.bZs.putBoolean("person_center_item_red_tip_show", aVar5.dSo);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fhK.fiR != null && s.this.fhK.fiR.bZs != null) {
                                s.this.fhK.fiR.bZs.putBoolean("person_center_item_red_tip_show", aVar6.dSo);
                                s.this.fhK.fiR.bZs.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.flc != null) {
                                s.this.flc.setData(s.this.fhK.aYu());
                                s.this.flc.notifyDataSetChanged();
                            }
                        }
                        if (s.this.guL instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.guL.m(5, aVar7.dSo);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.guL.m(6, aVar8.dSo);
                            }
                        }
                    }
                }
            }
        };
        this.bDA.setTag(this.azI);
        tbPageContext.registerListener(this.bDA);
        this.flb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.guN.sF(jVar.pL());
                }
            }
        };
        this.flb.setTag(this.azI);
        tbPageContext.registerListener(this.flb);
    }

    public void onDestory() {
        if (this.guN != null) {
            this.guN.onDestory();
        }
        if (this.fhv != null) {
            this.fhv.setVisibility(8);
        }
    }

    public void qg(int i) {
        this.flh = false;
        int i2 = i == 0 ? 1 : 0;
        this.guS.a(i2, this.guS.hn(i2));
        this.flf = this.guS.hn(i);
        if (this.flf.aWU() == null) {
            this.flh = true;
            if (i == 0) {
                this.guS.Pm();
                return;
            } else if (i == 1) {
                this.guS.f(true, true, false);
                return;
            } else {
                return;
            }
        }
        cH(this.flf.aWU());
        if (this.flf.aWU().size() <= 1 && this.fhv.getVisibility() == 0) {
            this.fhu.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qh(int i) {
        if (i != this.bxP && this.guS != null) {
            this.bxP = i;
            qg(i);
        }
    }

    public com.baidu.tieba.view.f aYA() {
        return this.guL;
    }
}
