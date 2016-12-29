package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.view.n {
    private PbListView aMJ;
    View.OnClickListener aob;
    private boolean ceV;
    private CustomMessageListener coP;
    private ImageView evL;
    private com.baidu.tieba.personPolymeric.a.s evM;
    private CustomMessageListener evN;

    public x(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.aob = new y(this);
        this.ceV = z;
        this.fuI = (int) this.Gf.getResources().getDimension(r.e.ds720);
        if (z) {
            this.fuD = new com.baidu.tieba.view.j();
            C(tbPageContext);
            return;
        }
        this.fuD = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.evL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aMJ = new PbListView(this.Gf.getPageActivity());
        this.aMJ.kk();
        this.aMJ.setTextColor(ar.getColor(r.d.cp_cont_d));
        this.aMJ.dj(r.d.cp_bg_line_c);
        this.fuF.setNextPage(this.aMJ);
        this.fuF.setOnSrollToBottomListener(new z(this));
        this.fuE = new t(this.Gf.getPageActivity(), this.ceV);
        this.fuF.addHeaderView(this.fuE.anz());
        this.fuF.e(this.fuE.anz(), this.Gf.getResources().getDimensionPixelSize(r.e.ds568));
        this.fuF.setPersonListRefreshListener(new aa(this));
        this.fuF.addHeaderView(((t) this.fuE).aPW());
        this.evM = new com.baidu.tieba.personPolymeric.a.s(this.Gf, this.fuF);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.evL.setOnClickListener(this.aob);
        this.fuE.setOnViewResponseListener(mVar);
    }

    public void J(View.OnClickListener onClickListener) {
        if (this.evM != null) {
            this.evM.J(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            ar.b(this.evL, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        } else {
            ar.b(this.evL, r.f.icon_return_bg, r.f.icon_return_bg);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.evL.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fuD.bkk();
        this.fuE.f(nVar.getUserData());
        dj(nVar.alF());
        if (this.aMJ != null) {
            this.aMJ.wq();
        }
        com.baidu.tieba.f.a.aYA().aYF();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fuF.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            ar.b(this.evL, r.f.icon_return_bg_s, r.f.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            ar.b(this.evL, r.f.icon_return_bg, r.f.icon_return_bg);
        } else {
            ar.b(this.evL, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        }
        this.aMJ.dk(i);
    }

    public void abt() {
        ((t) this.fuE).abt();
    }

    public void jg(boolean z) {
        if (this.fuF != null && this.aMJ != null) {
            this.aMJ.wq();
            if (z) {
                this.aMJ.setText(this.Gf.getString(r.j.list_no_more));
            } else {
                this.aMJ.setText("");
            }
        }
    }

    private void C(TbPageContext tbPageContext) {
        this.coP = new ab(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.coP);
        this.evN = new ac(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.evN);
    }
}
