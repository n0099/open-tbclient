package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class x extends com.baidu.tieba.view.n {
    View.OnClickListener anX;
    private PbListView bvo;
    private CustomMessageListener cDC;
    private boolean cue;
    private ImageView eJL;
    private com.baidu.tieba.personPolymeric.a.s eJM;
    private CustomMessageListener eJN;

    public x(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.anX = new y(this);
        this.cue = z;
        this.fWq = (int) this.Gd.getResources().getDimension(t.e.ds720);
        if (z) {
            this.fWl = new com.baidu.tieba.view.j();
            w(tbPageContext);
            return;
        }
        this.fWl = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.eJL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.bvo = new PbListView(this.Gd.getPageActivity());
        this.bvo.kk();
        this.bvo.setTextColor(av.getColor(t.d.cp_cont_d));
        this.bvo.dg(t.d.cp_bg_line_c);
        this.fWn.setNextPage(this.bvo);
        this.fWn.setOnSrollToBottomListener(new z(this));
        this.fWm = new t(this.Gd.getPageActivity(), this.cue);
        this.fWn.addHeaderView(this.fWm.aqE());
        this.fWn.e(this.fWm.aqE(), this.Gd.getResources().getDimensionPixelSize(t.e.ds568));
        this.fWn.setPersonListRefreshListener(new aa(this));
        this.fWn.addHeaderView(((t) this.fWm).aTI());
        this.eJM = new com.baidu.tieba.personPolymeric.a.s(this.Gd, this.fWn);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.eJL.setOnClickListener(this.anX);
        this.fWm.setOnViewResponseListener(mVar);
    }

    public void M(View.OnClickListener onClickListener) {
        if (this.eJM != null) {
            this.eJM.M(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            av.b(this.eJL, t.f.icon_return_bg_s, t.f.icon_return_bg_s);
        } else {
            av.b(this.eJL, t.f.icon_return_bg, t.f.icon_return_bg);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.eJL.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fWl.bqm();
        this.fWm.h(nVar.getUserData());
        dt(nVar.aoT());
        if (this.bvo != null) {
            this.bvo.wm();
        }
        com.baidu.tieba.g.a.bbB().bbG();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fWn.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            av.b(this.eJL, t.f.icon_return_bg_s, t.f.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            av.b(this.eJL, t.f.icon_return_bg, t.f.icon_return_bg);
        } else {
            av.b(this.eJL, t.f.icon_return_bg_s, t.f.icon_return_bg_s);
        }
        this.bvo.dh(i);
    }

    public void afa() {
        ((t) this.fWm).afa();
    }

    public void iS(boolean z) {
        if (this.fWn != null && this.bvo != null) {
            this.bvo.wm();
            if (z) {
                this.bvo.setText(this.Gd.getString(t.j.list_no_more));
            } else {
                this.bvo.setText("");
            }
        }
    }

    private void w(TbPageContext tbPageContext) {
        this.cDC = new ab(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cDC);
        this.eJN = new ac(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eJN);
    }
}
