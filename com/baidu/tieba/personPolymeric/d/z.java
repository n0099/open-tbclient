package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.view.n {
    private PbListView aLK;
    private boolean aVU;
    View.OnClickListener ani;
    private ImageView brH;
    private CustomMessageListener cvR;
    private com.baidu.tieba.personPolymeric.a.s eFK;
    private CustomMessageListener eFL;

    public z(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.ani = new aa(this);
        this.aVU = z;
        this.bdR = (int) this.Fp.getResources().getDimension(r.f.ds720);
        if (z) {
            this.fDy = new com.baidu.tieba.view.j();
            A(tbPageContext);
            return;
        }
        this.fDy = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.brH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aLK = new PbListView(this.Fp.getPageActivity());
        this.aLK.kg();
        this.aLK.setTextColor(ap.getColor(r.e.cp_cont_d));
        this.aLK.dk(r.e.cp_bg_line_c);
        this.fDA.setNextPage(this.aLK);
        this.fDA.setOnSrollToBottomListener(new ab(this));
        this.fDz = new t(this.Fp.getPageActivity(), this.aVU);
        this.fDA.addHeaderView(this.fDz.PG());
        this.fDA.e(this.fDz.PG(), this.Fp.getResources().getDimensionPixelSize(r.f.ds568));
        this.fDA.setPersonListRefreshListener(new ac(this));
        this.fDA.addHeaderView(((t) this.fDz).aRV());
        this.eFK = new com.baidu.tieba.personPolymeric.a.s(this.Fp, this.fDA);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.brH.setOnClickListener(this.ani);
        this.fDz.setOnViewResponseListener(mVar);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eFK != null) {
            this.eFK.M(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            ap.b(this.brH, r.g.icon_return_bg_s, r.g.icon_return_bg);
        } else {
            ap.b(this.brH, r.g.btn_sml_back_selector_s, r.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.brH.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fDy.blO();
        this.fDz.f(nVar.getUserData());
        m17do(nVar.amM());
        if (this.aLK != null) {
            this.aLK.wl();
        }
        com.baidu.tieba.h.a.bap().bau();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fDA.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            ap.b(this.brH, r.g.icon_return_bg_s, r.g.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            ap.b(this.brH, r.g.btn_sml_back_selector_s, r.g.btn_sml_back_selector_s);
        } else {
            ap.b(this.brH, r.g.icon_return_bg_s, r.g.icon_return_bg);
        }
        this.aLK.dl(i);
        ap.j(this.mRootView, r.e.cp_bg_line_c);
    }

    public void acA() {
        ((t) this.fDz).acA();
    }

    public void cW(boolean z) {
        if (this.fDA != null && this.aLK != null) {
            this.aLK.wl();
            if (z) {
                this.aLK.setText(this.Fp.getString(r.l.list_no_more));
            } else {
                this.aLK.setText("");
            }
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cvR = new ad(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cvR);
        this.eFL = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eFL);
    }

    public void onDestory() {
        if (this.fDz != null) {
            this.fDz.onDestory();
        }
    }
}
