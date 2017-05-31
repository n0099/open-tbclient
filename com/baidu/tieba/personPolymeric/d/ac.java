package com.baidu.tieba.personPolymeric.d;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.view.s {
    private PbListView aZY;
    View.OnClickListener asJ;
    private BdUniqueId axG;
    private boolean beq;
    private int bpT;
    private ImageView bwV;
    private TextView bwX;
    private TextView bwY;
    private CustomMessageListener bxc;
    private CustomMessageListener bxd;
    private com.baidu.tieba.personPolymeric.c.a bxe;
    private boolean bxf;
    private com.baidu.tieba.personPolymeric.b.i bxg;
    private boolean bxh;
    private GridView bxo;
    private com.baidu.tieba.personPolymeric.a.s eOc;
    private com.baidu.tieba.personCenter.a.a eOd;
    private p eOe;
    private com.baidu.tieba.person.data.c eOf;
    private v eOg;

    public ac(TbPageContext tbPageContext, com.baidu.tieba.personPolymeric.b.n nVar, BdUniqueId bdUniqueId, boolean z, boolean z2) {
        super(tbPageContext);
        this.bpT = 0;
        this.bxf = false;
        this.bxh = false;
        this.asJ = new ad(this);
        this.axG = bdUniqueId;
        this.beq = z;
        this.bxh = z2;
        this.bos = (int) this.aas.getResources().getDimension(w.f.ds720);
        this.bxg = nVar.aRa();
        this.aZY = this.bxg.aZY;
        if (z) {
            this.fQB = new com.baidu.tieba.view.j();
            l(tbPageContext);
            return;
        }
        this.fQB = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.s
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        if (this.beq) {
            this.mNavigationBar.switchNaviBarStatus(isLogin);
        }
        this.bwV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.bwX = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.bwY = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        if (!this.bxh) {
            this.bwV.setVisibility(8);
        } else {
            addCustomView.setVisibility(8);
        }
        this.eKW.setOnSrollToBottomListener(new ae(this));
        this.fQD = new w(this.aas, this.beq);
        this.eKW.addHeaderView(this.fQD.RG());
        this.eKW.setExpandView(this.fQD.RG());
        this.eKW.setPersonListRefreshListener(new af(this));
        this.eOc = new com.baidu.tieba.personPolymeric.a.s(this.aas, this.eKW, this.axG);
        this.eOc.setIsHost(this.beq);
        if (this.beq) {
            this.fQF = LayoutInflater.from(this.aas.getPageActivity()).inflate(w.j.person_center_function_grid_view, (ViewGroup) null);
            this.bxo = (GridView) this.fQF.findViewById(w.h.person_center_function_grid_view);
            this.fQG = this.fQF.findViewById(w.h.divider_line);
            this.eOd = new com.baidu.tieba.personCenter.a.a(this.aas.getPageActivity());
            this.bxo.setAdapter((ListAdapter) this.eOd);
            this.eKW.addHeaderView(this.fQF);
            if (!this.bxh) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKW.getLayoutParams();
                layoutParams.bottomMargin = this.aas.getResources().getDimensionPixelSize(w.f.ds100);
                this.eKW.setLayoutParams(layoutParams);
            }
        } else {
            this.eOe = new p(this.aas.getPageActivity());
            this.eKW.addHeaderView(this.eOe);
        }
        this.eOg = new v(TbadkCoreApplication.m9getInst(), this);
        this.fQE = this.eOg.VN();
        this.eKW.addHeaderView(this.fQE);
    }

    public void Tu() {
        this.bxf = false;
        if (this.bpT == 0) {
            if (com.baidu.adp.lib.util.i.hk()) {
                this.fQI.resetData();
                this.fQI.NJ();
                ((w) this.fQD).lb();
                return;
            }
            ((w) this.fQD).Tx();
        } else if (this.bpT == 1) {
            if (com.baidu.adp.lib.util.i.hk()) {
                this.fQI.d(true, true, true);
                ((w) this.fQD).lb();
                return;
            }
            ((w) this.fQD).Tx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.s
    public void aRw() {
        if (this.fQO) {
            this.fQH.setVisibility(8);
        }
        this.mNavigationBar.setVisibility(0);
        if (this.mNavigationBar.getY() < 0.0f) {
            this.mNavigationBar.setY(0.0f);
        }
        this.eKX.setVisibility(8);
        this.eOg.oA(this.bpT);
        ((RelativeLayout.LayoutParams) this.aZX.getLayoutParams()).addRule(3, w.h.person_center_navigation_bar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.s
    public void adW() {
        if (this.fQO) {
            this.fQH.setVisibility(0);
        }
        this.mNavigationBar.setVisibility(4);
        this.eKX.setVisibility(0);
        oA(this.bpT);
        ((RelativeLayout.LayoutParams) this.aZX.getLayoutParams()).addRule(3, w.h.person_center_blank_view);
    }

    @Override // com.baidu.tieba.view.s
    public void setOnViewResponseListener(com.baidu.tieba.view.r rVar) {
        super.setOnViewResponseListener(rVar);
        this.bwV.setOnClickListener(this.asJ);
        this.fQD.setOnViewResponseListener(rVar);
        if (this.eOd != null) {
            this.eOd.setOnViewResponseListener(rVar);
        }
    }

    public void O(View.OnClickListener onClickListener) {
        if (this.eOc != null) {
            this.eOc.O(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.s
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            if (this.beq) {
                if (this.bxh) {
                    aq.b(this.bwV, w.g.icon_return_bg_s, w.g.icon_return_bg);
                } else {
                    this.bwX.setVisibility(8);
                    this.bwY.setVisibility(0);
                    aq.b(this.bwY, w.e.cp_cont_b, w.e.s_navbar_title_color);
                }
            } else {
                aq.b(this.bwV, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
        } else if (this.beq) {
            if (this.bxh) {
                aq.b(this.bwV, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            } else {
                this.bwX.setVisibility(0);
                this.bwY.setVisibility(8);
                aq.b(this.bwX, w.e.cp_cont_i, w.e.cp_cont_i);
            }
        } else {
            aq.b(this.bwV, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bwV.setAlpha(f2);
        }
        if (this.beq) {
            this.bwX.setAlpha(1.0f - f);
            this.bwY.setAlpha(f);
        }
    }

    public void an(ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        cb(arrayList);
    }

    public void a(com.baidu.tieba.personPolymeric.c.a aVar, boolean z) {
        if (aVar != null) {
            this.bxe = aVar;
            if (this.bxf) {
                cb(aVar.akJ());
                if (this.aZY != null) {
                    this.aZY.wm();
                    return;
                }
                return;
            }
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.fQB.TT();
            this.fQD.b(aVar);
            if (this.beq) {
                this.eOd.setData(aVar.aRq());
                this.eOd.notifyDataSetChanged();
            } else if (aVar.aRp() == null || aVar.aRp().eMq == null || aVar.aRp().eMq.size() <= 0) {
                this.eKW.removeHeaderView(this.eOe);
            } else {
                this.eOe.a(aVar.aRp());
            }
            if (com.baidu.tbadk.core.util.x.r(aVar.akJ())) {
                cb(null);
                this.bxg.VD();
                com.baidu.adp.lib.util.k.showToast(this.aas.getContext(), this.aas.getString(w.l.data_load_error));
                return;
            }
            com.baidu.tieba.j.a.baD().baI();
            cb(aVar.akJ());
            int size = aVar.akJ().size();
            for (int i = 0; i < size; i++) {
                com.baidu.adp.widget.ListView.v vVar = aVar.akJ().get(i);
                if (vVar != null && ((vVar instanceof com.baidu.tieba.personPolymeric.c.i) || (vVar instanceof com.baidu.tieba.personPolymeric.c.j))) {
                    this.bxg.VD();
                    return;
                }
            }
            if (z) {
                if (this.aZY != null) {
                    this.aZY.wm();
                    return;
                }
                return;
            }
            this.bxg.dB(true);
        }
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.eKW.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.s
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        aq.k(this.bxo, w.e.cp_bg_line_d);
        aq.k(this.fQF, w.e.cp_bg_line_d);
        aq.k(this.fQG, w.e.cp_bg_line_b);
        if (this.eOd != null) {
            this.eOd.notifyDataSetChanged();
        }
        if (this.eOg != null) {
            this.eOg.onChangeSkinType();
        }
        if (2 == i) {
            aq.b(this.bwV, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            if (com.baidu.adp.lib.util.i.hk()) {
                aq.b(this.bwV, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
            } else {
                aq.b(this.bwV, w.g.icon_return_bg_s, w.g.icon_return_bg);
            }
            this.aZY.dj(i);
            aq.j(this.mRootView, w.e.cp_bg_line_d);
        }
        if (this.beq) {
            aq.b(this.bwY, w.e.cp_cont_b, w.e.s_navbar_title_color);
            aq.b(this.bwX, w.e.cp_cont_i, w.e.cp_cont_i);
        }
    }

    public void Tx() {
        ((w) this.fQD).Tx();
    }

    private void l(TbPageContext tbPageContext) {
        this.bxc = new ag(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        this.bxc.setTag(this.axG);
        tbPageContext.registerListener(this.bxc);
        this.bxd = new ah(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        this.bxd.setTag(this.axG);
        tbPageContext.registerListener(this.bxd);
    }

    public void onDestory() {
        if (this.fQD != null) {
            this.fQD.onDestory();
        }
        if (this.eKX != null) {
            this.eKX.setVisibility(8);
        }
    }

    public void py(int i) {
        this.bxf = false;
        int i2 = i == 0 ? 1 : 0;
        this.fQI.a(i2, this.fQI.hd(i2));
        this.eOf = this.fQI.hd(i);
        if (this.eOf.aPW() == null) {
            this.bxf = true;
            if (i == 0) {
                this.fQI.NJ();
                return;
            } else if (i == 1) {
                this.fQI.d(true, true, false);
                return;
            } else {
                return;
            }
        }
        cb(this.eOf.aPW());
        if (this.eOf.aPW().size() <= 1 && this.eKX.getVisibility() == 0) {
            this.eKW.smoothScrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.view.s
    public void pz(int i) {
        if (i != this.bpT && this.fQI != null) {
            this.bpT = i;
            py(i);
        }
    }

    public com.baidu.tieba.view.q Ty() {
        return this.fQB;
    }
}
