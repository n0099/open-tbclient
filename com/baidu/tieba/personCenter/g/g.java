package com.baidu.tieba.personCenter.g;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.r;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
/* loaded from: classes.dex */
public class g extends n {
    private TextView VO;
    private CustomMessageListener coP;
    private TextView epT;
    private com.baidu.tieba.personCenter.a.a epU;
    private com.baidu.tieba.personCenter.c.a epV;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fuI = (int) this.Gf.getResources().getDimension(r.e.ds600);
        this.fuD = new com.baidu.tieba.view.j();
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
            this.fuF.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.VO = (TextView) addCustomView.findViewById(r.g.person_center_navigation_title);
        this.epT = (TextView) addCustomView.findViewById(r.g.person_center_navigation_another_title);
        this.fuE = new a(this.Gf.getPageActivity());
        this.fuF.addHeaderView(this.fuE.anz());
        this.epU = new com.baidu.tieba.personCenter.a.a(this.Gf, this.fuF);
        C(this.Gf);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fuE.setOnViewResponseListener(mVar);
        this.epU.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.VO.setVisibility(8);
            this.epT.setVisibility(0);
            ar.b(this.epT, r.d.cp_cont_b, r.d.s_navbar_title_color);
        } else {
            this.VO.setVisibility(0);
            this.epT.setVisibility(8);
            ar.b(this.VO, r.d.cp_cont_i, r.d.cp_cont_i);
        }
        this.VO.setAlpha(1.0f - f);
        this.epT.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.epV = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fuD.bkk();
        this.fuE.f(aVar.aOH());
        dj(aVar.alF());
        com.baidu.tieba.f.a.aYA().aYF();
    }

    public void ox(String str) {
        this.fuE.ox(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Gf, i);
        }
    }

    private void C(TbPageContext tbPageContext) {
        this.coP = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.coP);
    }
}
