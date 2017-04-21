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
    private TextView aaG;
    private CustomMessageListener cyh;
    private TextView eDC;
    private com.baidu.tieba.personCenter.a.a eDD;
    private com.baidu.tieba.personCenter.c.a eDE;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bmO = (int) this.aaY.getResources().getDimension(w.f.ds600);
        this.fMe = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.aaY.getResources().getDimensionPixelSize(w.f.ds320);
            int dimensionPixelSize2 = this.aaY.getResources().getDimensionPixelSize(w.f.ds480);
            int dimensionPixelSize3 = this.aaY.getResources().getDimensionPixelSize(w.f.ds360);
            int dimensionPixelSize4 = this.aaY.getResources().getDimensionPixelSize(w.f.ds60);
            int dimensionPixelSize5 = this.aaY.getResources().getDimensionPixelSize(w.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aaY.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaY.getString(w.l.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fMg.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.aaG = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.eDC = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        this.fMf = new a(this.aaY.getPageActivity());
        this.fMg.addHeaderView(this.fMf.RZ());
        this.eDD = new com.baidu.tieba.personCenter.a.a(this.aaY, this.fMg);
        A(this.aaY);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fMf.setOnViewResponseListener(mVar);
        this.eDD.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.aaG.setVisibility(8);
            this.eDC.setVisibility(0);
            aq.b(this.eDC, w.e.cp_cont_b, w.e.s_navbar_title_color);
        } else {
            this.aaG.setVisibility(0);
            this.eDC.setVisibility(8);
            aq.b(this.aaG, w.e.cp_cont_i, w.e.cp_cont_i);
        }
        this.aaG.setAlpha(1.0f - f);
        this.eDC.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eDE = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fMe.bno();
        this.fMf.f(aVar.aRu());
        cU(aVar.amU());
        com.baidu.tieba.g.a.bbK().bbP();
    }

    public void oc(String str) {
        this.fMf.oc(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaY, i);
        }
    }

    private void A(TbPageContext tbPageContext) {
        this.cyh = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cyh);
    }
}
