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
    private BdUniqueId aAZ;
    View.OnClickListener avV;
    private boolean bED;
    private com.baidu.tieba.personPolymeric.b.c bEJ;
    private CustomMessageListener bEK;
    private ImageView bFa;
    private PbListView ber;
    private boolean blJ;
    private int byZ;
    private com.baidu.tieba.personPolymeric.c.a fiY;
    private TextView fmk;
    private TextView fml;
    private com.baidu.tieba.personPolymeric.a.n fmm;
    private CustomMessageListener fmn;
    private com.baidu.tieba.personCenter.a.a fmo;
    private GridView fmp;
    private l fmq;
    private com.baidu.tieba.person.data.c fmr;
    private p fms;
    private boolean fmt;

    public s(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.d dVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.byZ = 0;
        this.fmt = false;
        this.bED = false;
        this.avV = new View.OnClickListener() { // from class: com.baidu.tieba.personPolymeric.d.s.3
            com.baidu.tieba.personPolymeric.event.a fmg = new com.baidu.tieba.personPolymeric.event.a();

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (s.this.feL != null) {
                    if (s.this.bFa == view) {
                        this.fmg.cax = 8;
                    }
                    s.this.feL.a(view, this.fmg);
                }
            }
        };
        this.aAZ = bdUniqueId;
        this.blJ = z;
        this.bED = z2;
        this.bxB = (int) this.acp.getResources().getDimension(d.f.ds720);
        this.bEJ = dVar.aYm();
        this.ber = this.bEJ.ber;
        if (z) {
            this.gvW = new com.baidu.tieba.view.d();
            l(tbPageContext);
            return;
        }
        this.gvW = new com.baidu.tieba.view.c();
    }

    @Override // com.baidu.tieba.view.h
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.blJ) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.mNavigationBar.removeAllViews(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
        this.bFa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.fmk = (TextView) addCustomView.findViewById(d.h.person_center_navigation_title);
        this.fml = (TextView) addCustomView.findViewById(d.h.person_center_navigation_another_title);
        if (!this.bED) {
            this.bFa.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.fiI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.personPolymeric.d.s.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (s.this.ber != null && s.this.gwd != null) {
                    if (s.this.byZ == 0) {
                        s.this.ber.wW();
                        s.this.gwd.f(false, false, false);
                    } else if (s.this.byZ == 1) {
                        s.this.ber.wW();
                        s.this.gwd.f(true, false, false);
                    }
                }
            }
        });
        this.gvY = new q(this.acp, this.blJ);
        this.fiI.addHeaderView(this.gvY.Uk());
        this.fiI.setExpandView(this.gvY.Uk());
        this.fiI.setPersonListRefreshListener(new BdPersonListView.a() { // from class: com.baidu.tieba.personPolymeric.d.s.2
            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void lj() {
                s.this.VJ();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void li() {
                s.this.gvY.ajc();
            }

            @Override // com.baidu.tieba.person.listview.BdPersonListView.a
            public void G(float f) {
                s.this.gvY.F(f);
            }
        });
        this.fmm = new com.baidu.tieba.personPolymeric.a.n(this.acp, this.fiI, this.aAZ);
        this.fmm.setIsHost(this.blJ);
        if (this.blJ) {
            this.gvZ = LayoutInflater.from(this.acp.getPageActivity()).inflate(d.j.person_center_function_grid_view, (ViewGroup) null);
            this.fmp = (GridView) this.gvZ.findViewById(d.h.person_center_function_grid_view);
            this.gwb = this.gvZ.findViewById(d.h.divider_line);
            this.fmo = new com.baidu.tieba.personCenter.a.a(this.acp.getPageActivity());
            this.fmp.setAdapter((ListAdapter) this.fmo);
            this.fiI.addHeaderView(this.gvZ);
            if (!this.bED) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fiI.getLayoutParams();
                layoutParams.bottomMargin = this.acp.getResources().getDimensionPixelSize(d.f.ds100);
                this.fiI.setLayoutParams(layoutParams);
            }
        } else {
            this.gwa = new k(this.acp.getPageActivity());
            this.fiI.addHeaderView(this.gwa);
            this.fmq = new l(this.acp.getPageActivity());
            this.fiI.addHeaderView(this.fmq);
        }
        this.fms = new p(TbadkCoreApplication.getInst(), this);
        this.gdi = this.fms.XR();
        this.fiI.addHeaderView(this.gdi);
        this.mNavigationBar.setVisibility(0);
        this.fiI.setVisibility(0);
        this.mWebView.setVisibility(8);
    }

    public void VJ() {
        this.fmt = false;
        if (this.byZ == 0) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gwd.resetData();
                this.gwd.refreshData();
                this.gvY.lh();
                return;
            }
            this.gvY.ajc();
        } else if (this.byZ == 1) {
            if (com.baidu.adp.lib.util.i.hr()) {
                this.gwd.f(true, true, true);
                this.gvY.lh();
                return;
            }
            this.gvY.ajc();
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void aYK() {
        if (this.gwj) {
            this.gwc.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.fiJ.setVisibility(8);
        this.fms.pa(this.byZ);
        ((RelativeLayout.LayoutParams) this.beq.getLayoutParams()).addRule(3, d.h.person_center_navigation_bar);
    }

    @Override // com.baidu.tieba.view.h
    protected void ajw() {
        if (this.gwj) {
            this.gwc.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.fiJ.setVisibility(0);
        pa(this.byZ);
        ((RelativeLayout.LayoutParams) this.beq.getLayoutParams()).addRule(3, d.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.h
    public void setOnViewResponseListener(com.baidu.tieba.view.g gVar) {
        super.setOnViewResponseListener(gVar);
        this.bFa.setOnClickListener(this.avV);
        this.gvY.setOnViewResponseListener(gVar);
        if (this.fmo != null) {
            this.fmo.setOnViewResponseListener(gVar);
        }
        if (this.gwa != null) {
            this.gwa.setOnViewResponseListener(gVar);
        }
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.fmm != null) {
            this.fmm.N(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.h
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.blJ) {
                if (this.bED) {
                    ai.b(this.bFa, d.g.icon_return_bg_s, d.g.icon_return_bg);
                } else {
                    this.fmk.setVisibility(8);
                    this.fml.setVisibility(0);
                    ai.b(this.fml, d.e.cp_cont_b, d.e.s_navbar_title_color);
                }
            } else {
                ai.b(this.bFa, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
        } else if (this.blJ) {
            if (this.bED) {
                ai.b(this.bFa, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                this.fmk.setVisibility(0);
                this.fml.setVisibility(8);
                ai.b(this.fmk, d.e.cp_cont_i, d.e.cp_cont_i);
            }
        } else {
            ai.b(this.bFa, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bFa.setAlpha(f2);
        }
        if (this.blJ) {
            this.fmk.setAlpha(1.0f - f);
            this.fml.setAlpha(f);
        }
    }

    public void ao(ArrayList<com.baidu.adp.widget.ListView.f> arrayList) {
        cH(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.mWebView.setVisibility(8);
            this.fiY = aVar;
            if (this.fmt) {
                cH(aVar.aqm());
                if (this.ber != null) {
                    this.ber.wX();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.gvW.VU();
            this.gvY.e(aVar);
            if (this.blJ) {
                this.fmo.setData(aVar.aYF());
                this.fmo.notifyDataSetChanged();
            } else {
                if (this.gwa != null && aVar.getUserData() != null) {
                    this.gwa.setUserData(aVar.getUserData());
                }
                if (aVar.aYE() == null || aVar.aYE().fkm == null || aVar.aYE().fkm.size() <= 0) {
                    this.fiI.removeHeaderView(this.fmq);
                } else {
                    this.fmq.a(aVar.aYE());
                }
            }
            if (u.v(aVar.aqm())) {
                cH(null);
                this.bEJ.XH();
                com.baidu.adp.lib.util.k.showToast(this.acp.getContext(), this.acp.getString(d.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.biy().biD();
            cH(aVar.aqm());
            int size = aVar.aqm().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.f fVar = aVar.aqm().get(i);
                if (fVar != null && ((fVar instanceof com.baidu.tieba.personPolymeric.c.i) || (fVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bEJ.XH();
                    return;
                }
            }
            if (z) {
                if (this.ber != null) {
                    this.ber.wX();
                    return;
                }
                return;
            }
            this.bEJ.dM(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fiI.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.h
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ai.k(this.fmp, d.e.cp_bg_line_d);
        ai.k(this.gvZ, d.e.cp_bg_line_d);
        ai.k(this.gwb, d.e.cp_bg_line_b);
        if (this.fmo != null) {
            this.fmo.notifyDataSetChanged();
        }
        if (this.fms != null) {
            this.fms.onChangeSkinType();
        }
        if (2 == i) {
            ai.b(this.bFa, d.g.icon_return_bg_s, d.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hr()) {
                ai.b(this.bFa, d.g.btn_sml_back_selector_s, d.g.btn_sml_back_selector_s);
            } else {
                ai.b(this.bFa, d.g.icon_return_bg_s, d.g.icon_return_bg);
            }
            this.ber.dp(i);
            ai.j(this.mRootView, d.e.cp_bg_line_d);
        }
        if (this.blJ) {
            ai.b(this.fml, d.e.cp_cont_b, d.e.s_navbar_title_color);
            ai.b(this.fmk, d.e.cp_cont_i, d.e.cp_cont_i);
        }
        if (this.gwa != null) {
            this.gwa.onChangeSkinType();
        }
    }

    public void ajc() {
        ((q) this.gvY).ajc();
    }

    private void l(TbPageContext tbPageContext) {
        this.bEK = new CustomMessageListener(CmdConfigCustom.CMD_PERSON_RED_TIP) { // from class: com.baidu.tieba.personPolymeric.d.s.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean z;
                if (customResponsedMessage.getCmd() == 2001435 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.j.b)) {
                    SparseArray<b.a> sparseArray = ((com.baidu.tieba.j.b) customResponsedMessage.getData()).fKu;
                    if (sparseArray.size() > 0) {
                        b.a aVar = sparseArray.get(2);
                        if (aVar != null && s.this.gvY != null && s.this.gvY.gwH != null) {
                            s.this.gvY.gwH.mU(aVar.dTF);
                        }
                        b.a aVar2 = sparseArray.get(4);
                        b.a aVar3 = sparseArray.get(3);
                        b.a aVar4 = sparseArray.get(1);
                        b.a aVar5 = sparseArray.get(7);
                        b.a aVar6 = sparseArray.get(8);
                        if (s.this.fiY != null) {
                            if (s.this.fiY.fkb != null && s.this.fiY.fkb.cay != null && aVar2 != null) {
                                s.this.fiY.fkb.cay.putBoolean("person_center_item_red_tip_show", aVar2.dTF);
                                z = true;
                            } else {
                                z = false;
                            }
                            if (aVar3 != null && s.this.fiY.fka != null && s.this.fiY.fka.cay != null) {
                                s.this.fiY.fka.cay.putBoolean("person_center_item_red_tip_show", aVar3.dTF);
                                z = true;
                            }
                            if (aVar4 != null && s.this.fiY.fjY != null && s.this.fiY.fjY.cay != null) {
                                s.this.fiY.fjY.cay.putBoolean("person_center_item_red_tip_show", aVar4.dTF);
                                z = true;
                            }
                            if (aVar5 != null && s.this.fiY.fkc != null && s.this.fiY.fkc.cay != null) {
                                s.this.fiY.fkc.cay.putBoolean("person_center_item_red_tip_show", aVar5.dTF);
                                z = true;
                            }
                            if (aVar6 != null && s.this.fiY.fkd != null && s.this.fiY.fkd.cay != null) {
                                s.this.fiY.fkd.cay.putBoolean("person_center_item_red_tip_show", aVar6.dTF);
                                s.this.fiY.fkd.cay.putString("person_center_item_txt", String.valueOf(aVar6.mNum));
                                z = true;
                            }
                            if (z && s.this.fmo != null) {
                                s.this.fmo.setData(s.this.fiY.aYF());
                                s.this.fmo.notifyDataSetChanged();
                            }
                        }
                        if (s.this.gvW instanceof com.baidu.tieba.view.d) {
                            b.a aVar7 = sparseArray.get(5);
                            if (aVar7 != null) {
                                s.this.gvW.m(5, aVar7.dTF);
                            }
                            b.a aVar8 = sparseArray.get(6);
                            if (aVar8 != null) {
                                s.this.gvW.m(6, aVar8.dTF);
                            }
                        }
                    }
                }
            }
        };
        this.bEK.setTag(this.aAZ);
        tbPageContext.registerListener(this.bEK);
        this.fmn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.personPolymeric.d.s.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.data.j jVar;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null) {
                    s.this.gvY.sK(jVar.pV());
                }
            }
        };
        this.fmn.setTag(this.aAZ);
        tbPageContext.registerListener(this.fmn);
    }

    public void onDestory() {
        if (this.gvY != null) {
            this.gvY.onDestory();
        }
        if (this.fiJ != null) {
            this.fiJ.setVisibility(8);
        }
    }

    public void qg(int i) {
        this.fmt = false;
        int i2 = i == 0 ? 1 : 0;
        this.gwd.a(i2, this.gwd.ho(i2));
        this.fmr = this.gwd.ho(i);
        if (this.fmr.aXf() == null) {
            this.fmt = true;
            if (i == 0) {
                this.gwd.Pr();
                return;
            } else if (i == 1) {
                this.gwd.f(true, true, false);
                return;
            } else {
                return;
            }
        }
        cH(this.fmr.aXf());
        if (this.fmr.aXf().size() <= 1 && this.fiJ.getVisibility() == 0) {
            this.fiI.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.h
    public void qh(int i) {
        if (i != this.byZ && this.gwd != null) {
            this.byZ = i;
            qg(i);
        }
    }

    public com.baidu.tieba.view.f aYL() {
        return this.gvW;
    }
}
