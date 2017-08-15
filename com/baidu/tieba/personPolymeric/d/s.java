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
    private BdUniqueId aBa;
    View.OnClickListener avW;
    private ImageView bFJ;
    private boolean bFm;
    private com.baidu.tieba.personPolymeric.b.c bFs;
    private CustomMessageListener bFt;
    private PbListView bes;
    private boolean blR;
    private int bzI;
    private com.baidu.tieba.personPolymeric.c.a fkR;
    private TextView fod;
    private TextView foe;
    private com.baidu.tieba.personPolymeric.a.n fof;
    private CustomMessageListener fog;
    private com.baidu.tieba.personCenter.a.a foh;
    private GridView foi;
    private l foj;
    private com.baidu.tieba.person.data.c fok;
    private p fol;
    private boolean fom;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bzI = 0;
        this.fom = false;
        this.bFm = false;
        this.avW = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fnZ = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.fgE != null) {
                    if (s.this.bFJ == view) {
                        this.fnZ.cbj = 8;
                    }
                    s.this.fgE.a(view, this.fnZ);
                }
            }
        };
        this.aBa = bdUniqueId;
        this.blR = z;
        this.bFm = z2;
        this.byk = (int) this.acr.getResources().getDimension(d.f.ds720);
        this.bFs = dVar.aYT();
        this.bes = this.bFs.bes;
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
        if (this.blR) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bFJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fod = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.foe = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bFm) {
            this.bFJ.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fkB.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.bes != null && s.this.gxV != null) {
                    if (s.this.bzI == 0) {
                        s.this.bes.wW();
                        s.this.gxV.g(false, false, false);
                    } else if (s.this.bzI == 1) {
                        s.this.bes.wW();
                        s.this.gxV.g(true, false, false);
                    }
                }
            }
        });
        this.gxQ = new q(this.acr, this.blR);
        this.fkB.addHeaderView(this.gxQ.UG());
        this.fkB.setExpandView(this.gxQ.UG());
        this.fkB.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void lj() {
                s.this.Wf();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void li() {
                s.this.gxQ.ajJ();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void G(float f) {
                s.this.gxQ.F(f);
            }
        });
        this.fof = new com.baidu.tieba.personPolymeric.a.n(this.acr, this.fkB, this.aBa);
        this.fof.setIsHost(this.blR);
        if (this.blR) {
            this.gxR = LayoutInflater.from(this.acr.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.foi = (GridView) this.gxR.findViewById(d.h.person_center_function_grid_view);
            this.gxT = this.gxR.findViewById(d.h.divider_line);
            this.foh = new com.baidu.tieba.personCenter.a.a(this.acr.getPageActivity());
            this.foi.setAdapter((ListAdapter) this.foh);
            this.fkB.addHeaderView(this.gxR);
            if (!this.bFm) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fkB.getLayoutParams();
                layoutParams.bottomMargin = this.acr.getResources().getDimensionPixelSize(d.f.ds100);
                this.fkB.setLayoutParams(layoutParams);
            }
        } else {
            this.gxS = new k(this.acr.getPageActivity());
            this.fkB.addHeaderView(this.gxS);
            this.foj = new l(this.acr.getPageActivity());
            this.fkB.addHeaderView(this.foj);
        }
        this.fol = new p(TbadkCoreApplication.getInst(), this);
        this.gfa = this.fol.Ym();
        this.fkB.addHeaderView(this.gfa);
        this.mNavigationBar.setVisibility(0);
        this.fkB.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void Wf() {
        this.fom = false;
        if (this.bzI == 0) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gxV.resetData();
                this.gxV.refreshData();
                this.gxQ.lh();
                return;
            }
            this.gxQ.ajJ();
        } else if (this.bzI == 1) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gxV.g(true, true, true);
                this.gxQ.lh();
                return;
            }
            this.gxQ.ajJ();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aZr() {
        if (this.gyb) {
            this.gxU.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fkC.setVisibility(8);
        this.fol.pk(this.bzI);
        ((RelativeLayout.LayoutParams) this.ber.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void akc() {
        if (this.gyb) {
            this.gxU.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fkC.setVisibility(0);
        pk(this.bzI);
        ((RelativeLayout.LayoutParams) this.ber.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bFJ.setOnClickListener(this.avW);
        this.gxQ.setOnViewResponseListener(gVar);
        if (this.foh != null) {
            this.foh.setOnViewResponseListener(gVar);
        }
        if (this.gxS != null) {
            this.gxS.setOnViewResponseListener(gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fof != null) {
            this.fof.N(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.blR) {
                if (this.bFm) {
                    ai.b(this.bFJ, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fod.setVisibility(8);
                    this.foe.setVisibility(0);
                    ai.b(this.foe, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                ai.b(this.bFJ, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.blR) {
            if (this.bFm) {
                ai.b(this.bFJ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fod.setVisibility(0);
                this.foe.setVisibility(8);
                ai.b(this.fod, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            ai.b(this.bFJ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bFJ.setAlpha(f2);
        }
        if (this.blR) {
            this.fod.setAlpha(1.0f - f);
            this.foe.setAlpha(f);
        }
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cK(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.mWebView.setVisibility(8);
            this.fkR = aVar;
            if (this.fom) {
                cK(aVar.aqT());
                if (this.bes != null) {
                    this.bes.wX();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gxO.Wq();
            this.gxQ.e(aVar);
            if (this.blR) {
                this.foh.setData(aVar.aZm());
                this.foh.notifyDataSetChanged();
            } else {
                if (this.gxS != null && aVar.getUserData() != null) {
                    this.gxS.setUserData(aVar.getUserData());
                }
                if (aVar.aZl() == null || aVar.aZl().fmf == null || aVar.aZl().fmf.size() <= 0) {
                    this.fkB.removeHeaderView(this.foj);
                } else {
                    this.foj.a(aVar.aZl());
                }
            }
            if (u.v(aVar.aqT())) {
                cK(null);
                this.bFs.Yc();
                com.baidu.adp.lib.util.k.showToast(this.acr.getContext(), this.acr.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.bje().bjj();
            cK(aVar.aqT());
            int size = aVar.aqT().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.aqT().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bFs.Yc();
                    return;
                }
            }
            if (z) {
                if (this.bes != null) {
                    this.bes.wX();
                    return;
                }
                return;
            }
            this.bFs.dN(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fkB.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.foi, d.e.cp_bg_line_d);
        ai.k(this.gxR, d.e.cp_bg_line_d);
        ai.k(this.gxT, d.e.cp_bg_line_b);
        if (this.foh != null) {
            this.foh.notifyDataSetChanged();
        }
        if (this.fol != null) {
            this.fol.onChangeSkinType();
        }
        if (2 == i) {
            ai.b(this.bFJ, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hr()) {
                ai.b(this.bFJ, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                ai.b(this.bFJ, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.bes.dp(i);
            ai.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.blR) {
            ai.b(this.foe, d.e.cp_cont_b, d.e.s_navbar_title_color);
            ai.b(this.fod, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.gxS != null) {
            this.gxS.onChangeSkinType();
        }
    }

    public void ajJ() {
        ((q) this.gxQ).ajJ();
    }

    private void l(TbPageContext tbPageContext) {
        this.bFt = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fMo;
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
                        if (s.this.fkR != null) {
                            if (s.this.fkR.flU != null && s.this.fkR.flU.cbk != null && aVar2 != null) {
                                s.this.fkR.flU.cbk.putBoolean("person_center_item_red_tip_show", aVar2.dVB);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fkR.flT != null && s.this.fkR.flT.cbk != null) {
                                s.this.fkR.flT.cbk.putBoolean("person_center_item_red_tip_show", aVar3.dVB);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fkR.flR != null && s.this.fkR.flR.cbk != null) {
                                s.this.fkR.flR.cbk.putBoolean("person_center_item_red_tip_show", aVar4.dVB);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fkR.flV != null && s.this.fkR.flV.cbk != null) {
                                s.this.fkR.flV.cbk.putBoolean("person_center_item_red_tip_show", aVar5.dVB);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fkR.flW != null && s.this.fkR.flW.cbk != null) {
                                s.this.fkR.flW.cbk.putBoolean("person_center_item_red_tip_show", aVar6.dVB);
                                s.this.fkR.flW.cbk.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.foh != null) {
                                s.this.foh.setData(s.this.fkR.aZm());
                                s.this.foh.notifyDataSetChanged();
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
        this.bFt.setTag(this.aBa);
        tbPageContext.registerListener(this.bFt);
        this.fog = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.gxQ.sM(jVar.pV());
                }
            }
        };
        this.fog.setTag(this.aBa);
        tbPageContext.registerListener(this.fog);
    }

    public void onDestory() {
        if (this.gxQ != null) {
            this.gxQ.onDestory();
        }
        if (this.fkC != null) {
            this.fkC.setVisibility(8);
        }
    }

    public void qq(int i) {
        this.fom = false;
        int i2 = i == 0 ? 1 : 0;
        this.gxV.a(i2, this.gxV.hp(i2));
        this.fok = this.gxV.hp(i);
        if (this.fok.aXM() == null) {
            this.fom = true;
            if (i == 0) {
                this.gxV.Py();
                return;
            } else if (i == 1) {
                this.gxV.g(true, true, false);
                return;
            } else {
                return;
            }
        }
        cK(this.fok.aXM());
        if (this.fok.aXM().size() <= 1 && this.fkC.getVisibility() == 0) {
            this.fkB.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qr(int i) {
        if (i != this.bzI && this.gxV != null) {
            this.bzI = i;
            qq(i);
        }
    }

    public com.baidu.tieba.view.f aZs() {
        return this.gxO;
    }
}
