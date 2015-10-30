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
import com.baidu.tbadk.core.view.m;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aHt;
    protected m awg;
    protected NoNetworkView cKU;
    private RelativeLayout cKV;
    private RelativeLayout ceO;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(i.g.nevigationbar_layout);
        this.aHt = (NavigationBar) findViewById(i.f.navigation_bar);
        this.ceO = (RelativeLayout) findViewById(i.f.navigation_bar_root);
        this.aHt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aqO()) {
            this.cKU = (NoNetworkView) ((ViewStub) findViewById(i.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.awg == null) {
            this.awg = NoDataViewFactory.a(getPageContext().getContext(), this.ceO, cVar, dVar, bVar);
        }
        this.awg.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.awg.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.awg != null) {
            this.awg.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aqO()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cKV = new RelativeLayout(getPageContext().getContext());
        this.cKV.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ceO.addView(this.cKV, layoutParams);
    }

    protected boolean aqO() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aqO()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cKV = new RelativeLayout(getPageContext().getContext());
        this.cKV.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ceO.addView(this.cKV, layoutParams);
    }

    protected View getRootView() {
        return this.ceO;
    }

    protected View LW() {
        return this.cKV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aHt.onChangeSkinType(getPageContext(), i);
        if (this.cKU != null) {
            this.cKU.onChangeSkinType(getPageContext(), i);
        }
        if (this.awg != null) {
            this.awg.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.ceO);
    }
}
