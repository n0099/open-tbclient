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
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aOK;
    protected p azZ;
    private RelativeLayout dbk;
    protected NoNetworkView ean;
    private RelativeLayout eao;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(t.h.nevigationbar_layout);
        this.aOK = (NavigationBar) findViewById(t.g.navigation_bar);
        this.dbk = (RelativeLayout) findViewById(t.g.navigation_bar_root);
        this.aOK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aMQ()) {
            this.ean = (NoNetworkView) ((ViewStub) findViewById(t.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.azZ == null) {
            this.azZ = NoDataViewFactory.a(getPageContext().getContext(), this.dbk, cVar, dVar, bVar);
        }
        this.azZ.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.azZ.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.azZ != null) {
            this.azZ.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aMQ()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.eao = new RelativeLayout(getPageContext().getContext());
        this.eao.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.dbk.addView(this.eao, layoutParams);
    }

    protected boolean aMQ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aMQ()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.eao = new RelativeLayout(getPageContext().getContext());
        this.eao.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.dbk.addView(this.eao, layoutParams);
    }

    protected View getRootView() {
        return this.dbk;
    }

    protected View Sc() {
        return this.eao;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aOK.onChangeSkinType(getPageContext(), i);
        if (this.ean != null) {
            this.ean.onChangeSkinType(getPageContext(), i);
        }
        if (this.azZ != null) {
            this.azZ.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.dbk);
    }
}
