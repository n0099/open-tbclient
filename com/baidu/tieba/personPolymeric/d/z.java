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
    private PbListView aRw;
    View.OnClickListener asD;
    private boolean bch;
    private ImageView byJ;
    private CustomMessageListener cxq;
    private com.baidu.tieba.personPolymeric.a.s eJm;
    private CustomMessageListener eJn;

    public z(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.asD = new aa(this);
        this.bch = z;
        this.bkE = (int) this.aaI.getResources().getDimension(w.f.ds720);
        if (z) {
            this.fHZ = new com.baidu.tieba.view.j();
            C(tbPageContext);
            return;
        }
        this.fHZ = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.byJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aRw = new PbListView(this.aaI.getPageActivity());
        this.aRw.la();
        this.aRw.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRw.dg(w.e.cp_bg_line_c);
        this.fIb.setNextPage(this.aRw);
        this.fIb.setOnSrollToBottomListener(new ab(this));
        this.fIa = new t(this.aaI.getPageActivity(), this.bch);
        this.fIb.addHeaderView(this.fIa.Qz());
        this.fIb.e(this.fIa.Qz(), this.aaI.getResources().getDimensionPixelSize(w.f.ds568));
        this.fIb.setPersonListRefreshListener(new ac(this));
        this.fIb.addHeaderView(((t) this.fIa).aRy());
        this.eJm = new com.baidu.tieba.personPolymeric.a.s(this.aaI, this.fIb);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.byJ.setOnClickListener(this.asD);
        this.fIa.setOnViewResponseListener(mVar);
    }

    public void K(View.OnClickListener onClickListener) {
        if (this.eJm != null) {
            this.eJm.K(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            aq.b(this.byJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            aq.b(this.byJ, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.byJ.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fHZ.blD();
        this.fIa.f(nVar.getUserData());
        cV(nVar.alZ());
        if (this.aRw != null) {
            this.aRw.wI();
        }
        com.baidu.tieba.g.a.baa().baf();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fIb.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            aq.b(this.byJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            aq.b(this.byJ, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        } else {
            aq.b(this.byJ, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
        this.aRw.dh(i);
        aq.j(this.mRootView, w.e.cp_bg_line_c);
    }

    public void ady() {
        ((t) this.fIa).ady();
    }

    public void cW(boolean z) {
        if (this.fIb != null && this.aRw != null) {
            this.aRw.wI();
            if (z) {
                this.aRw.setText(this.aaI.getString(w.l.list_no_more));
            } else {
                this.aRw.setText("");
            }
        }
    }

    private void C(TbPageContext tbPageContext) {
        this.cxq = new ad(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cxq);
        this.eJn = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eJn);
    }

    public void onDestory() {
        if (this.fIa != null) {
            this.fIa.onDestory();
        }
    }
}
