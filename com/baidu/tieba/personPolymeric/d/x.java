package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.view.n {
    private PbListView aMn;
    View.OnClickListener anF;
    private CustomMessageListener cEg;
    private boolean cuB;
    private ImageView eLO;
    private com.baidu.tieba.personPolymeric.a.s eLP;
    private CustomMessageListener eLQ;

    public x(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.anF = new y(this);
        this.cuB = z;
        this.fYv = (int) this.Gd.getResources().getDimension(r.e.ds720);
        if (z) {
            this.fYq = new com.baidu.tieba.view.j();
            z(tbPageContext);
            return;
        }
        this.fYq = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.eLO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aMn = new PbListView(this.Gd.getPageActivity());
        this.aMn.kk();
        this.aMn.setTextColor(av.getColor(r.d.cp_cont_d));
        this.aMn.dg(r.d.cp_bg_line_c);
        this.fYs.setNextPage(this.aMn);
        this.fYs.setOnSrollToBottomListener(new z(this));
        this.fYr = new t(this.Gd.getPageActivity(), this.cuB);
        this.fYs.addHeaderView(this.fYr.ard());
        this.fYs.e(this.fYr.ard(), this.Gd.getResources().getDimensionPixelSize(r.e.ds568));
        this.fYs.setPersonListRefreshListener(new aa(this));
        this.fYs.addHeaderView(((t) this.fYr).aUf());
        this.eLP = new com.baidu.tieba.personPolymeric.a.s(this.Gd, this.fYs);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.eLO.setOnClickListener(this.anF);
        this.fYr.setOnViewResponseListener(mVar);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eLP != null) {
            this.eLP.L(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            av.b(this.eLO, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        } else {
            av.b(this.eLO, r.f.icon_return_bg, r.f.icon_return_bg);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eLO.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fYq.bqQ();
        this.fYr.h(nVar.getUserData());
        du(nVar.aph());
        if (this.aMn != null) {
            this.aMn.wC();
        }
        com.baidu.tieba.f.a.bcl().bcq();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fYs.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            av.b(this.eLO, r.f.icon_return_bg_s, r.f.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            av.b(this.eLO, r.f.icon_return_bg, r.f.icon_return_bg);
        } else {
            av.b(this.eLO, r.f.icon_return_bg_s, r.f.icon_return_bg_s);
        }
        this.aMn.dh(i);
    }

    public void afo() {
        ((t) this.fYr).afo();
    }

    public void iV(boolean z) {
        if (this.fYs != null && this.aMn != null) {
            this.aMn.wC();
            if (z) {
                this.aMn.setText(this.Gd.getString(r.j.list_no_more));
            } else {
                this.aMn.setText("");
            }
        }
    }

    private void z(TbPageContext tbPageContext) {
        this.cEg = new ab(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cEg);
        this.eLQ = new ac(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eLQ);
    }
}
