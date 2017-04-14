package com.baidu.tieba.personCenter.f;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends n {
    private TextView aaF;
    private CustomMessageListener cvQ;
    private TextView eBm;
    private com.baidu.tieba.personCenter.a.a eBn;
    private com.baidu.tieba.personCenter.c.a eBo;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bkx = (int) this.aaX.getResources().getDimension(w.f.ds600);
        this.fJI = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.aaX.getResources().getDimensionPixelSize(w.f.ds320);
            int dimensionPixelSize2 = this.aaX.getResources().getDimensionPixelSize(w.f.ds480);
            int dimensionPixelSize3 = this.aaX.getResources().getDimensionPixelSize(w.f.ds360);
            int dimensionPixelSize4 = this.aaX.getResources().getDimensionPixelSize(w.f.ds60);
            int dimensionPixelSize5 = this.aaX.getResources().getDimensionPixelSize(w.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aaX.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaX.getString(w.l.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fJK.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.aaF = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.eBm = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        this.fJJ = new a(this.aaX.getPageActivity());
        this.fJK.addHeaderView(this.fJJ.QX());
        this.eBn = new com.baidu.tieba.personCenter.a.a(this.aaX, this.fJK);
        A(this.aaX);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fJJ.setOnViewResponseListener(mVar);
        this.eBn.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.aaF.setVisibility(8);
            this.eBm.setVisibility(0);
            aq.b(this.eBm, w.e.cp_cont_b, w.e.s_navbar_title_color);
        } else {
            this.aaF.setVisibility(0);
            this.eBm.setVisibility(8);
            aq.b(this.aaF, w.e.cp_cont_i, w.e.cp_cont_i);
        }
        this.aaF.setAlpha(1.0f - f);
        this.eBm.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eBo = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fJI.bmn();
        this.fJJ.f(aVar.aQt());
        cU(aVar.alT());
        com.baidu.tieba.g.a.baJ().baO();
    }

    public void ob(String str) {
        this.fJJ.ob(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaX, i);
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cvQ = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cvQ);
    }
}
