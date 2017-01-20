package com.baidu.tieba.personCenter.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
/* loaded from: classes.dex */
public class g extends n {
    private TextView Ve;
    private CustomMessageListener cvR;
    private TextView ezQ;
    private com.baidu.tieba.personCenter.a.a ezR;
    private com.baidu.tieba.personCenter.c.a ezS;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bdR = (int) this.Fp.getResources().getDimension(r.f.ds600);
        this.fDy = new com.baidu.tieba.view.j();
    }

    @Override // com.baidu.tieba.view.n
    public void initUI() {
        super.initUI();
        boolean isLogin = TbadkCoreApplication.isLogin();
        this.mNavigationBar.switchNaviBarStatus(isLogin);
        if (!isLogin) {
            this.mNavigationBar.setRegisterClickListener(new h(this));
            this.mNavigationBar.setLoginClickListener(new i(this));
            this.mNavigationBar.showBottomLine(true);
            int dimensionPixelSize = this.Fp.getResources().getDimensionPixelSize(r.f.ds320);
            int dimensionPixelSize2 = this.Fp.getResources().getDimensionPixelSize(r.f.ds480);
            int dimensionPixelSize3 = this.Fp.getResources().getDimensionPixelSize(r.f.ds360);
            int dimensionPixelSize4 = this.Fp.getResources().getDimensionPixelSize(r.f.ds60);
            int dimensionPixelSize5 = this.Fp.getResources().getDimensionPixelSize(r.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.Fp.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.x(r.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Fp.getString(r.l.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fDA.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.Ve = (TextView) addCustomView.findViewById(r.h.person_center_navigation_title);
        this.ezQ = (TextView) addCustomView.findViewById(r.h.person_center_navigation_another_title);
        this.fDz = new a(this.Fp.getPageActivity());
        this.fDA.addHeaderView(this.fDz.PG());
        this.ezR = new com.baidu.tieba.personCenter.a.a(this.Fp, this.fDA);
        A(this.Fp);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fDz.setOnViewResponseListener(mVar);
        this.ezR.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.Ve.setVisibility(8);
            this.ezQ.setVisibility(0);
            ap.b(this.ezQ, r.e.cp_cont_b, r.e.s_navbar_title_color);
        } else {
            this.Ve.setVisibility(0);
            this.ezQ.setVisibility(8);
            ap.b(this.Ve, r.e.cp_cont_i, r.e.cp_cont_i);
        }
        this.Ve.setAlpha(1.0f - f);
        this.ezQ.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.ezS = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fDy.blO();
        this.fDz.f(aVar.aQH());
        m17do(aVar.amM());
        com.baidu.tieba.h.a.bap().bau();
    }

    public void oP(String str) {
        this.fDz.oP(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Fp, i);
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cvR = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cvR);
    }
}
