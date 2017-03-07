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
    private TextView aap;
    private CustomMessageListener cxq;
    private TextView eDp;
    private com.baidu.tieba.personCenter.a.a eDq;
    private com.baidu.tieba.personCenter.c.a eDr;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bkE = (int) this.aaI.getResources().getDimension(w.f.ds600);
        this.fHZ = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.aaI.getResources().getDimensionPixelSize(w.f.ds320);
            int dimensionPixelSize2 = this.aaI.getResources().getDimensionPixelSize(w.f.ds480);
            int dimensionPixelSize3 = this.aaI.getResources().getDimensionPixelSize(w.f.ds360);
            int dimensionPixelSize4 = this.aaI.getResources().getDimensionPixelSize(w.f.ds60);
            int dimensionPixelSize5 = this.aaI.getResources().getDimensionPixelSize(w.f.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.aaI.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, w.g.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.D(w.l.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.aaI.getString(w.l.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fIb.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.item_person_center_navigation_title, (View.OnClickListener) null);
        this.aap = (TextView) addCustomView.findViewById(w.h.person_center_navigation_title);
        this.eDp = (TextView) addCustomView.findViewById(w.h.person_center_navigation_another_title);
        this.fIa = new a(this.aaI.getPageActivity());
        this.fIb.addHeaderView(this.fIa.Qz());
        this.eDq = new com.baidu.tieba.personCenter.a.a(this.aaI, this.fIb);
        C(this.aaI);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fIa.setOnViewResponseListener(mVar);
        this.eDq.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.aap.setVisibility(8);
            this.eDp.setVisibility(0);
            aq.b(this.eDp, w.e.cp_cont_b, w.e.s_navbar_title_color);
        } else {
            this.aap.setVisibility(0);
            this.eDp.setVisibility(8);
            aq.b(this.aap, w.e.cp_cont_i, w.e.cp_cont_i);
        }
        this.aap.setAlpha(1.0f - f);
        this.eDp.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eDr = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fHZ.blD();
        this.fIa.f(aVar.aQk());
        cV(aVar.alZ());
        com.baidu.tieba.g.a.baa().baf();
    }

    public void nX(String str) {
        this.fIa.nX(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.aaI, i);
        }
    }

    private void C(TbPageContext tbPageContext) {
        this.cxq = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cxq);
    }
}
