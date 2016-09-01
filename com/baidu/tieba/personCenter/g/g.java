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
import com.baidu.tieba.t;
import com.baidu.tieba.view.m;
import com.baidu.tieba.view.n;
/* loaded from: classes.dex */
public class g extends n {
    private TextView VM;
    private CustomMessageListener cDC;
    private TextView eDU;
    private com.baidu.tieba.personCenter.a.a eDV;
    private com.baidu.tieba.personCenter.c.a eDW;

    public g(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fWq = (int) this.Gd.getResources().getDimension(t.e.ds600);
        this.fWl = new com.baidu.tieba.view.j();
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
            int dimensionPixelSize = this.Gd.getResources().getDimensionPixelSize(t.e.ds320);
            int dimensionPixelSize2 = this.Gd.getResources().getDimensionPixelSize(t.e.ds480);
            int dimensionPixelSize3 = this.Gd.getResources().getDimensionPixelSize(t.e.ds360);
            int dimensionPixelSize4 = this.Gd.getResources().getDimensionPixelSize(t.e.ds60);
            int dimensionPixelSize5 = this.Gd.getResources().getDimensionPixelSize(t.e.ds20);
            this.mNoDataView = NoDataViewFactory.a(this.Gd.getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.LOCAL, t.f.pic_msg_unlogin, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2), NoDataViewFactory.d.w(t.j.unlogin_person_msg_text, dimensionPixelSize4), NoDataViewFactory.b.a(new NoDataViewFactory.a(this.Gd.getString(t.j.unlogin_person_button_text), new j(this)), dimensionPixelSize5));
            this.mNoDataView.setVisibility(0);
            this.fWn.setVisibility(8);
        }
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.item_person_center_navigation_title, (View.OnClickListener) null);
        this.VM = (TextView) addCustomView.findViewById(t.g.person_center_navigation_title);
        this.eDU = (TextView) addCustomView.findViewById(t.g.person_center_navigation_another_title);
        this.fWm = new a(this.Gd.getPageActivity());
        this.fWn.addHeaderView(this.fWm.aqE());
        this.eDV = new com.baidu.tieba.personCenter.a.a(this.Gd, this.fWn);
        w(this.Gd);
    }

    @Override // com.baidu.tieba.view.n
    public void setOnViewResponseListener(m mVar) {
        super.setOnViewResponseListener(mVar);
        this.fWm.setOnViewResponseListener(mVar);
        this.eDV.setOnViewResponseListener(mVar);
    }

    @Override // com.baidu.tieba.view.n
    protected void a(float f, boolean z) {
        if (z) {
            this.VM.setVisibility(8);
            this.eDU.setVisibility(0);
            av.b(this.eDU, t.d.cp_cont_b, t.d.s_navbar_title_color);
        } else {
            this.VM.setVisibility(0);
            this.eDU.setVisibility(8);
            av.b(this.VM, t.d.cp_cont_i, t.d.cp_cont_i);
        }
        this.VM.setAlpha(1.0f - f);
        this.eDU.setAlpha(f);
    }

    public void b(com.baidu.tieba.personCenter.c.a aVar) {
        this.eDW = aVar;
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.fWl.bqm();
        this.fWm.h(aVar.aSs());
        dt(aVar.aoT());
        com.baidu.tieba.g.a.bbB().bbG();
    }

    public void pw(String str) {
        this.fWm.pw(str);
    }

    @Override // com.baidu.tieba.view.n
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.Gd, i);
        }
    }

    private void w(TbPageContext tbPageContext) {
        this.cDC = new k(this, CmdConfigCustom.CMD_PERSON_RED_TIP);
        tbPageContext.registerListener(this.cDC);
    }
}
