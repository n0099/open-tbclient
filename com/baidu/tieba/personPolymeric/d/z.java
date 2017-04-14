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
    private PbListView aRM;
    View.OnClickListener asT;
    private boolean bca;
    private ImageView byC;
    private CustomMessageListener cvQ;
    private com.baidu.tieba.personPolymeric.a.s eHh;
    private CustomMessageListener eHi;

    public z(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.asT = new aa(this);
        this.bca = z;
        this.bkx = (int) this.aaX.getResources().getDimension(w.f.ds720);
        if (z) {
            this.fJI = new com.baidu.tieba.view.j();
            A(tbPageContext);
            return;
        }
        this.fJI = new com.baidu.tieba.view.h();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        this.byC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_polymeric_navigation_back, (View.OnClickListener) null);
        this.aRM = new PbListView(this.aaX.getPageActivity());
        this.aRM.le();
        this.aRM.setTextColor(aq.getColor(w.e.cp_cont_d));
        this.aRM.dj(w.e.cp_bg_line_c);
        this.fJK.setNextPage(this.aRM);
        this.fJK.setOnSrollToBottomListener(new ab(this));
        this.fJJ = new t(this.aaX.getPageActivity(), this.bca);
        this.fJK.addHeaderView(this.fJJ.QX());
        this.fJK.e(this.fJJ.QX(), this.aaX.getResources().getDimensionPixelSize(w.f.ds568));
        this.fJK.setPersonListRefreshListener(new ac(this));
        this.fJK.addHeaderView(((t) this.fJJ).aRH());
        this.eHh = new com.baidu.tieba.personPolymeric.a.s(this.aaX, this.fJK);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(com.baidu.tieba.view.m mVar) {
        super.setOnViewResponseListener(mVar);
        this.byC.setOnClickListener(this.asT);
        this.fJJ.setOnViewResponseListener(mVar);
    }

    public void L(View.OnClickListener onClickListener) {
        if (this.eHh != null) {
            this.eHh.L(onClickListener);
        }
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        float f2;
        if (z) {
            aq.b(this.byC, w.g.icon_return_bg_s, w.g.icon_return_bg);
        } else {
            aq.b(this.byC, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        }
        if (f < 0.5f) {
            f2 = 1.0f - (f * 2.0f);
        } else {
            f2 = (f * 2.0f) - 1.0f;
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.byC.setAlpha(f2);
        }
    }

    public void c(com.baidu.tieba.personPolymeric.c.n nVar) {
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fJI.bmn();
        this.fJJ.f(nVar.getUserData());
        cU(nVar.alT());
        if (this.aRM != null) {
            this.aRM.xe();
        }
        com.baidu.tieba.g.a.baJ().baO();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.fJK.setOnTouchListener(onTouchListener);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (2 == i) {
            aq.b(this.byC, w.g.icon_return_bg_s, w.g.icon_return_bg);
            return;
        }
        if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            aq.b(this.byC, w.g.btn_sml_back_selector_s, w.g.btn_sml_back_selector_s);
        } else {
            aq.b(this.byC, w.g.icon_return_bg_s, w.g.icon_return_bg);
        }
        this.aRM.dk(i);
        aq.j(this.mRootView, w.e.cp_bg_line_c);
    }

    public void ads() {
        ((t) this.fJJ).ads();
    }

    public void cY(boolean z) {
        if (this.fJK != null && this.aRM != null) {
            this.aRM.xe();
            if (z) {
                this.aRM.setText(this.aaX.getString(w.l.list_no_more));
            } else {
                this.aRM.setText("");
            }
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cvQ = new ad(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cvQ);
        this.eHi = new ae(this, CmdConfigCustom.CMD_UPDATE_PENDANT);
        tbPageContext.registerListener(this.eHi);
    }

    public void onDestory() {
        if (this.fJJ != null) {
            this.fJJ.onDestory();
        }
    }
}
