package com.baidu.tieba.personCenter.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
/* loaded from: classes.dex */
public class g extends n {
    private TextView Wu;
    private CustomMessageListener cJu;
    private TextView eMx;
    private com.baidu.tieba.personCenter.a.a eMy;
    private com.baidu.tieba.personCenter.c.a eMz;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gfQ = (int) this.Gf.getResources().getDimension(r.e.ds600);
        this.gfL = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.Gf.getResources().getDimensionPixelSize(r.e.ds320);
            int dimensionPixelSize2 = this.Gf.getResources().getDimensionPixelSize(r.e.ds480);
            int dimensionPixelSize3 = this.Gf.getResources().getDimensionPixelSize(r.e.ds360);
            int dimensionPixelSize4 = this.Gf.getResources().getDimensionPixelSize(r.e.ds60);
            int dimensionPixelSize5 = this.Gf.getResources().getDimensionPixelSize(r.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.Gf.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, r.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(r.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Gf.getString(r.j.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.gfN.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.Wu = (TextView) addCustomView.findViewById(r.g.person_center_navigation_title);
        this.eMx = (TextView) addCustomView.findViewById(r.g.person_center_navigation_another_title);
        this.gfM = new a(this.Gf.getPageActivity());
        this.gfN.addHeaderView(this.gfM.ata());
        this.eMy = new com.baidu.tieba.personCenter.a.a(this.Gf, this.gfN);
        B(this.Gf);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.gfM.setOnViewResponseListener(mVar);
        this.eMy.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.Wu.setVisibility(8);
            this.eMx.setVisibility(0);
            at.b(this.eMx, r.d.cp_cont_b, r.d.s_navbar_title_color);
        } else {
            this.Wu.setVisibility(0);
            this.eMx.setVisibility(8);
            at.b(this.Wu, r.d.cp_cont_i, r.d.cp_cont_i);
        }
        this.Wu.setAlpha(1.0f - f);
        this.eMx.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eMz = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.gfL.btj();
        this.gfM.h(aVar.aUX());
        dA(aVar.ard());
        com.baidu.tieba.f.a.beM().beR();
    }

    public void pV(String str) {
        this.gfM.pV(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Gf, i);
        }
    }

    private void B(TbPageContext tbPageContext) {
        this.cJu = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cJu);
    }
}
