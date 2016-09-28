package com.baidu.tieba.personCenter.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
/* loaded from: classes.dex */
public class g extends n {
    private TextView VW;
    private CustomMessageListener cEg;
    private TextView eFY;
    private com.baidu.tieba.personCenter.a.a eFZ;
    private com.baidu.tieba.personCenter.c.a eGa;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYv = (int) this.Gd.getResources().getDimension(r.e.ds600);
        this.fYq = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.Gd.getResources().getDimensionPixelSize(r.e.ds320);
            int dimensionPixelSize2 = this.Gd.getResources().getDimensionPixelSize(r.e.ds480);
            int dimensionPixelSize3 = this.Gd.getResources().getDimensionPixelSize(r.e.ds360);
            int dimensionPixelSize4 = this.Gd.getResources().getDimensionPixelSize(r.e.ds60);
            int dimensionPixelSize5 = this.Gd.getResources().getDimensionPixelSize(r.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.Gd.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Gd.getString(r.j.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fYs.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.VW = (TextView) addCustomView.findViewById(r.g.person_center_navigation_title);
        this.eFY = (TextView) addCustomView.findViewById(r.g.person_center_navigation_another_title);
        this.fYr = new a(this.Gd.getPageActivity());
        this.fYs.addHeaderView(this.fYr.ard());
        this.eFZ = new com.baidu.tieba.personCenter.a.a(this.Gd, this.fYs);
        z(this.Gd);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fYr.setOnViewResponseListener(mVar);
        this.eFZ.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.VW.setVisibility(8);
            this.eFY.setVisibility(0);
            av.b(this.eFY, r.d.cp_cont_b, r.d.s_navbar_title_color);
        } else {
            this.VW.setVisibility(0);
            this.eFY.setVisibility(8);
            av.b(this.VW, r.d.cp_cont_i, r.d.cp_cont_i);
        }
        this.VW.setAlpha(1.0f - f);
        this.eFY.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eGa = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fYq.bqQ();
        this.fYr.h(aVar.aSQ());
        du(aVar.aph());
        com.baidu.tieba.f.a.bcl().bcq();
    }

    public void pI(String str) {
        this.fYr.pI(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Gd, i);
        }
    }

    private void z(TbPageContext tbPageContext) {
        this.cEg = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cEg);
    }
}
