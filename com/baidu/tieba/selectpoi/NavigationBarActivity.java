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
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aOs;
    protected q awS;
    private RelativeLayout dKi;
    protected NoNetworkView eHZ;
    private RelativeLayout eIa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(u.h.nevigationbar_layout);
        this.aOs = (NavigationBar) findViewById(u.g.navigation_bar);
        this.dKi = (RelativeLayout) findViewById(u.g.navigation_bar_root);
        this.aOs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aVi()) {
            this.eHZ = (NoNetworkView) ((ViewStub) findViewById(u.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.awS == null) {
            this.awS = NoDataViewFactory.a(getPageContext().getContext(), this.dKi, cVar, dVar, bVar);
        }
        this.awS.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.awS.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.awS != null) {
            this.awS.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        aVi();
        this.eIa = new RelativeLayout(getPageContext().getContext());
        this.eIa.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.dKi.addView(this.eIa, 0, layoutParams);
    }

    protected boolean aVi() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aVi()) {
            layoutParams.addRule(3, u.g.no_network_view);
        } else {
            layoutParams.addRule(3, u.g.no_network_viewstub);
        }
        this.eIa = new RelativeLayout(getPageContext().getContext());
        this.eIa.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.dKi.addView(this.eIa, layoutParams);
    }

    protected View Wx() {
        return this.eIa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aOs.onChangeSkinType(getPageContext(), i);
        if (this.eHZ != null) {
            this.eHZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.awS != null) {
            this.awS.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.dKi);
    }
}
