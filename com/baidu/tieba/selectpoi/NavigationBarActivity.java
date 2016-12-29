package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected w aAC;
    protected NavigationBar aWS;
    private RelativeLayout dUZ;
    protected NoNetworkView eRi;
    private RelativeLayout eRj;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(r.h.nevigationbar_layout);
        this.aWS = (NavigationBar) findViewById(r.g.navigation_bar);
        this.dUZ = (RelativeLayout) findViewById(r.g.navigation_bar_root);
        this.aWS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aYW()) {
            this.eRi = (NoNetworkView) ((ViewStub) findViewById(r.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.aAC == null) {
            this.aAC = NoDataViewFactory.a(getPageContext().getContext(), this.dUZ, cVar, dVar, bVar);
        }
        this.aAC.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAC.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.aAC != null) {
            this.aAC.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        aYW();
        this.eRj = new RelativeLayout(getPageContext().getContext());
        this.eRj.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.dUZ.addView(this.eRj, 0, layoutParams);
    }

    protected boolean aYW() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aYW()) {
            layoutParams.addRule(3, r.g.no_network_view);
        } else {
            layoutParams.addRule(3, r.g.no_network_viewstub);
        }
        this.eRj = new RelativeLayout(getPageContext().getContext());
        this.eRj.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.dUZ.addView(this.eRj, layoutParams);
    }

    protected View Xw() {
        return this.eRj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aWS.onChangeSkinType(getPageContext(), i);
        if (this.eRi != null) {
            this.eRi.onChangeSkinType(getPageContext(), i);
        }
        if (this.aAC != null) {
            this.aAC.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.dUZ);
    }
}
