package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.view.n {
    private PbListView aRO;
    View.OnClickListener asV;
    private ImageView bAT;
    private boolean bcY;
    private CustomMessageListener cyh;
    private com.baidu.tieba.personPolymeric.a.s eJx;
    private CustomMessageListener eJy;

    public z(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.asV = new aa(this);
        this.bcY = z;
        this.bmO = (int) this.aaY.getResources().getDimension(w.f.ds720);
        if (z) {
            this.fMe = new com.baidu.tieba.view.j();
            A(tbPageContext);
            return;
        }
        this.fMe = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.bAT = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aRO = new PbListView(this.aaY.getPageActivity());
        this.aRO.lf();
        this.aRO.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRO.dj(w.e.cp_bg_line_c);
        this.fMg.setNextPage(this.aRO);
        this.fMg.setOnSrollToBottomListener(new ab(this));
        this.fMf = new t(this.aaY.getPageActivity(), this.bcY);
        this.fMg.addHeaderView(this.fMf.RZ());
        this.fMg.e(this.fMf.RZ(), this.aaY.getResources().getDimensionPixelSize(w.f.ds568));
        this.fMg.setPersonListRefreshListener(new ac(this));
        this.fMg.addHeaderView(((t) this.fMf).aSI());
        this.eJx = new com.baidu.tieba.personPolymeric.a.s(this.aaY, this.fMg);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.bAT.setOnClickListener(this.asV);
        this.fMf.setOnViewResponseListener(mVar);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eJx != null) {
            this.eJx.L(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            aq.b(this.bAT, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            aq.b(this.bAT, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.bAT.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fMe.bno();
        this.fMf.f(nVar.getUserData());
        cU(nVar.amU());
        if (this.aRO != null) {
            this.aRO.xe();
        }
        com.baidu.tieba.g.a.bbK().bbP();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fMg.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            aq.b(this.bAT, w.g.icon_return_bg_s, w.g.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            aq.b(this.bAT, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        } else {
            aq.b(this.bAT, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
        this.aRO.dk(i);
        aq.j(this.mRootView, w.e.cp_bg_line_c);
    }

    public void aet() {
        ((t) this.fMf).aet();
    }

    public void di(boolean z) {
        if (this.fMg != null && this.aRO != null) {
            this.aRO.xe();
            if (z) {
                this.aRO.setText(this.aaY.getString(w.l.list_no_more));
            } else {
                this.aRO.setText("");
            }
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cyh = new ad(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cyh);
        this.eJy = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eJy);
    }

    public void onDestory() {
        if (this.fMf != null) {
            this.fMf.onDestory();
        }
    }
}
