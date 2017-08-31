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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
import com.baidu.tieba.j.b;
import com.baidu.tieba.person.listview.BdPersonListView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s extends com.baidu.tieba.view.h {
    private BdUniqueId aAm;
    View.OnClickListener avj;
    private int bAB;
    private ImageView bIE;
    private boolean bIh;
    private com.baidu.tieba.personPolymeric.b.c bIn;
    private CustomMessageListener bIo;
    private PbListView beq;
    private boolean bmo;
    private com.baidu.tieba.personPolymeric.c.a fjn;
    private TextView fmA;
    private com.baidu.tieba.personPolymeric.a.n fmB;
    private CustomMessageListener fmC;
    private com.baidu.tieba.personCenter.a.a fmD;
    private GridView fmE;
    private l fmF;
    private e fmG;
    private com.baidu.tieba.person.data.c fmH;
    private p fmI;
    private boolean fmJ;
    private TextView fmz;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bAB = 0;
        this.fmJ = false;
        this.bIh = false;
        this.avj = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fmv = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.feW != null) {
                    if (s.this.bIE == view) {
                        this.fmv.ceb = 8;
                    }
                    s.this.feW.a(view, this.fmv);
                }
            }
        };
        this.aAm = bdUniqueId;
        this.bmo = z;
        this.bIh = z2;
        this.bzd = (int) this.aby.getResources().getDimension(d.f.ds720);
        this.bIn = dVar.aYa();
        this.beq = this.bIn.beq;
        if (z) {
            this.gwo = new com.baidu.tieba.view.d();
            l(tbPageContext);
            return;
        }
        this.gwo = new com.baidu.tieba.view.c();
    }

    @Override // com.baidu.tieba.view.h
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.bmo) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bIE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fmz = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fmA = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bIh) {
            this.bIE.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fiW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.beq != null && s.this.gwv != null) {
                    if (s.this.bAB == 0) {
                        s.this.beq.wV();
                        s.this.gwv.g(false, false, false);
                    } else if (s.this.bAB == 1) {
                        s.this.beq.wV();
                        s.this.gwv.g(true, false, false);
                    }
                }
            }
        });
        this.gwq = new q(this.aby, this.bmo);
        this.fiW.addHeaderView(this.gwq.Vq());
        this.fiW.setExpandView(this.gwq.Vq());
        this.fiW.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void la() {
                s.this.Xf();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void kZ() {
                s.this.gwq.aln();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void v(float f) {
                s.this.gwq.u(f);
            }
        });
        this.fmB = new com.baidu.tieba.personPolymeric.a.n(this.aby, this.fiW, this.aAm);
        this.fmB.setIsHost(this.bmo);
        if (this.bmo) {
            this.gwr = LayoutInflater.from(this.aby.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.fmE = (GridView) this.gwr.findViewById(d.h.person_center_function_grid_view);
            this.gwt = this.gwr.findViewById(d.h.divider_line);
            this.fmD = new com.baidu.tieba.personCenter.a.a(this.aby.getPageActivity());
            this.fmE.setAdapter((ListAdapter) this.fmD);
            this.fiW.addHeaderView(this.gwr);
            if (!this.bIh) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiW.getLayoutParams();
                layoutParams.bottomMargin = this.aby.getResources().getDimensionPixelSize(d.f.ds100);
                this.fiW.setLayoutParams(layoutParams);
            }
        } else {
            this.gws = new k(this.aby.getPageActivity());
            this.fiW.addHeaderView(this.gws);
            this.fmF = new l(this.aby.getPageActivity());
            this.fiW.addHeaderView(this.fmF);
            this.fmG = new e(this.aby);
            this.fiW.addHeaderView(this.fmG.getView());
        }
        this.fmI = new p(TbadkCoreApplication.getInst(), this);
        this.gdD = this.fmI.Zm();
        this.fiW.addHeaderView(this.gdD);
        this.mNavigationBar.setVisibility(0);
        this.fiW.setVisibility(0);
        this.bYK.setVisibility(8);
    }

    public void Xf() {
        this.fmJ = false;
        if (this.bAB == 0) {
            if (com.baidu.adp.lib.util.i.hi()) {
                this.gwv.resetData();
                this.gwv.refreshData();
                this.gwq.kY();
                return;
            }
            this.gwq.aln();
        } else if (this.bAB == 1) {
            if (com.baidu.adp.lib.util.i.hi()) {
                this.gwv.g(true, true, true);
                this.gwq.kY();
                return;
            }
            this.gwq.aln();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aYy() {
        if (this.gwB) {
            this.gwu.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fiX.setVisibility(8);
        this.fmI.pr(this.bAB);
        ((RelativeLayout.LayoutParams) this.bep.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void alE() {
        if (this.gwB) {
            this.gwu.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fiX.setVisibility(0);
        pr(this.bAB);
        ((RelativeLayout.LayoutParams) this.bep.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bIE.setOnClickListener(this.avj);
        this.gwq.setOnViewResponseListener(gVar);
        if (this.fmD != null) {
            this.fmD.setOnViewResponseListener(gVar);
        }
        if (this.gws != null) {
            this.gws.setOnViewResponseListener(gVar);
        }
    }

    public void H(View.OnClickListener onClickListener) {
        if (this.fmB != null) {
            this.fmB.H(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.bmo) {
                if (this.bIh) {
                    aj.a(this.bIE, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fmz.setVisibility(8);
                    this.fmA.setVisibility(0);
                    aj.b(this.fmA, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                aj.a(this.bIE, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.bmo) {
            if (this.bIh) {
                aj.a(this.bIE, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fmz.setVisibility(0);
                this.fmA.setVisibility(8);
                aj.b(this.fmz, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            aj.a(this.bIE, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bIE.setAlpha(f2);
        }
        if (this.bmo) {
            this.fmz.setAlpha(1.0f - f);
            this.fmA.setAlpha(f);
        }
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cH(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.bYK.setVisibility(8);
            this.fjn = aVar;
            if (this.fmJ) {
                cH(aVar.asx());
                if (this.beq != null) {
                    this.beq.wW();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gwo.Xq();
            this.gwq.e(aVar);
            if (this.bmo) {
                this.fmD.setData(aVar.aYt());
                this.fmD.notifyDataSetChanged();
            } else {
                if (this.gws != null && aVar.getUserData() != null) {
                    this.gws.setUserData(aVar.getUserData());
                }
                if (aVar.aYr() == null || aVar.aYr().fkC == null || aVar.aYr().fkC.size() <= 0) {
                    this.fiW.removeHeaderView(this.fmF);
                } else {
                    this.fmF.a(aVar.aYr());
                }
                if (aVar.aYs() == null || v.v(aVar.aYs().fkK)) {
                    this.fiW.removeHeaderView(this.fmG.getView());
                } else {
                    this.fmG.a(aVar.aYs());
                }
            }
            if (v.v(aVar.asx())) {
                cH(null);
                this.bIn.Zc();
                com.baidu.adp.lib.util.k.showToast(this.aby.getContext(), this.aby.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bhY().lP(this.bmo);
            cH(aVar.asx());
            int size = aVar.asx().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.asx().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bIn.Zc();
                    return;
                }
            }
            if (z) {
                if (this.beq != null) {
                    this.beq.wW();
                    return;
                }
                return;
            }
            this.bIn.dQ(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fiW.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aj.k(this.fmE, d.e.cp_bg_line_d);
        aj.k(this.gwr, d.e.cp_bg_line_d);
        aj.k(this.gwt, d.e.cp_bg_line_b);
        if (this.fmD != null) {
            this.fmD.notifyDataSetChanged();
        }
        if (this.fmI != null) {
            this.fmI.onChangeSkinType();
        }
        if (2 == i) {
            aj.a(this.bIE, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hi()) {
                aj.a(this.bIE, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                aj.a(this.bIE, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.beq.dq(i);
            aj.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.bmo) {
            aj.b(this.fmA, d.e.cp_cont_b, d.e.s_navbar_title_color);
            aj.b(this.fmz, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.gws != null) {
            this.gws.onChangeSkinType();
        }
    }

    public void aln() {
        ((q) this.gwq).aln();
    }

    private void l(TbPageContext tbPageContext) {
        this.bIo = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fKn;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gwq != null && s.this.gwq.gwZ != null) {
                            s.this.gwq.gwZ.nd(aVar.ecm);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.fjn != null) {
                            if (s.this.fjn.fkr != null && s.this.fjn.fkr.cec != null && aVar2 != null) {
                                s.this.fjn.fkr.cec.putBoolean("person_center_item_red_tip_show", aVar2.ecm);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fjn.fkq != null && s.this.fjn.fkq.cec != null) {
                                s.this.fjn.fkq.cec.putBoolean("person_center_item_red_tip_show", aVar3.ecm);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fjn.fko != null && s.this.fjn.fko.cec != null) {
                                s.this.fjn.fko.cec.putBoolean("person_center_item_red_tip_show", aVar4.ecm);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fjn.fks != null && s.this.fjn.fks.cec != null) {
                                s.this.fjn.fks.cec.putBoolean("person_center_item_red_tip_show", aVar5.ecm);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fjn.fkt != null && s.this.fjn.fkt.cec != null) {
                                s.this.fjn.fkt.cec.putBoolean("person_center_item_red_tip_show", aVar6.ecm);
                                s.this.fjn.fkt.cec.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.fmD != null) {
                                s.this.fmD.setData(s.this.fjn.aYt());
                                s.this.fmD.notifyDataSetChanged();
                            }
                        }
                        if (s.this.gwo instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gwo.l(5, aVar7.ecm);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gwo.l(6, aVar8.ecm);
                            }
                        }
                    }
                }
            }
        };
        this.bIo.setTag(this.aAm);
        tbPageContext.registerListener(this.bIo);
        this.fmC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.gwq.sM(jVar.pR());
                }
            }
        };
        this.fmC.setTag(this.aAm);
        tbPageContext.registerListener(this.fmC);
    }

    @Override // com.baidu.tieba.view.h
    public void onDestory() {
        super.onDestory();
        if (this.gwq != null) {
            this.gwq.onDestory();
        }
        if (this.fiX != null) {
            this.fiX.setVisibility(8);
        }
    }

    public void qq(int i) {
        this.fmJ = false;
        int i2 = i == 0 ? 1 : 0;
        this.gwv.a(i2, this.gwv.hA(i2));
        this.fmH = this.gwv.hA(i);
        if (this.fmH.aWT() == null) {
            this.fmJ = true;
            if (i == 0) {
                this.gwv.PN();
                return;
            } else if (i == 1) {
                this.gwv.g(true, true, false);
                return;
            } else {
                return;
            }
        }
        cH(this.fmH.aWT());
        if (this.fmH.aWT().size() <= 1 && this.fiX.getVisibility() == 0) {
            this.fiW.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qr(int i) {
        if (i != this.bAB && this.gwv != null) {
            this.bAB = i;
            qq(i);
        }
    }

    public com.baidu.tieba.view.f aYz() {
        return this.gwo;
    }
}
