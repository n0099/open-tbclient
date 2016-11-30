package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.view.n {
    private PbListView aNs;
    View.OnClickListener aoz;
    private CustomMessageListener cJu;
    private boolean czI;
    private ImageView eSm;
    private com.baidu.tieba.personPolymeric.a.s eSn;
    private CustomMessageListener eSo;

    public x(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.aoz = new y(this);
        this.czI = z;
        this.gfQ = (int) this.Gf.getResources().getDimension(r.e.ds720);
        if (z) {
            this.gfL = new com.baidu.tieba.view.j();
            B(tbPageContext);
            return;
        }
        this.gfL = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.eSm = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aNs = new PbListView(this.Gf.getPageActivity());
        this.aNs.kk();
        this.aNs.setTextColor(at.getColor(r.d.cp_cont_d));
        this.aNs.dh(r.d.cp_bg_line_c);
        this.gfN.setNextPage(this.aNs);
        this.gfN.setOnSrollToBottomListener(new z(this));
        this.gfM = new t(this.Gf.getPageActivity(), this.czI);
        this.gfN.addHeaderView(this.gfM.ata());
        this.gfN.e(this.gfM.ata(), this.Gf.getResources().getDimensionPixelSize(r.e.ds568));
        this.gfN.setPersonListRefreshListener(new aa(this));
        this.gfN.addHeaderView(((t) this.gfM).aWm());
        this.eSn = new com.baidu.tieba.personPolymeric.a.s(this.Gf, this.gfN);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.eSm.setOnClickListener(this.aoz);
        this.gfM.setOnViewResponseListener(mVar);
    }

    public void N(View.OnClickListener onClickListener) {
        if (this.eSn != null) {
            this.eSn.N(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            at.b(this.eSm, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        } else {
            at.b(this.eSm, r.f.icon_return_bg, r.f.icon_return_bg);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eSm.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.gfL.btj();
        this.gfM.h(nVar.getUserData());
        dA(nVar.ard());
        if (this.aNs != null) {
            this.aNs.wG();
        }
        com.baidu.tieba.f.a.beM().beR();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.gfN.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            at.b(this.eSm, r.f.icon_return_bg_s, r.f.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            at.b(this.eSm, r.f.icon_return_bg, r.f.icon_return_bg);
        } else {
            at.b(this.eSm, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        }
        this.aNs.di(i);
    }

    public void agY() {
        ((t) this.gfM).agY();
    }

    public void jv(boolean z) {
        if (this.gfN != null && this.aNs != null) {
            this.aNs.wG();
            if (z) {
                this.aNs.setText(this.Gf.getString(r.j.list_no_more));
            } else {
                this.aNs.setText("");
            }
        }
    }

    private void B(TbPageContext tbPageContext) {
        this.cJu = new ab(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cJu);
        this.eSo = new ac(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eSo);
    }
}
