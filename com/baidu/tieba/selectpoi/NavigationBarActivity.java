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
    protected NavigationBar aHi;
    protected m awf;
    protected NoNetworkView cKv;
    private RelativeLayout cKw;
    private RelativeLayout ceD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(i.g.nevigationbar_layout);
        this.aHi = (NavigationBar) findViewById(i.f.navigation_bar);
        this.ceD = (RelativeLayout) findViewById(i.f.navigation_bar_root);
        this.aHi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aqM()) {
            this.cKv = (NoNetworkView) ((ViewStub) findViewById(i.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.awf == null) {
            this.awf = NoDataViewFactory.a(getPageContext().getContext(), this.ceD, cVar, dVar, bVar);
        }
        this.awf.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.awf.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.awf != null) {
            this.awf.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aqM()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cKw = new RelativeLayout(getPageContext().getContext());
        this.cKw.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ceD.addView(this.cKw, layoutParams);
    }

    protected boolean aqM() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aqM()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cKw = new RelativeLayout(getPageContext().getContext());
        this.cKw.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ceD.addView(this.cKw, layoutParams);
    }

    protected View getRootView() {
        return this.ceD;
    }

    protected View Ma() {
        return this.cKw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aHi.onChangeSkinType(getPageContext(), i);
        if (this.cKv != null) {
            this.cKv.onChangeSkinType(getPageContext(), i);
        }
        if (this.awf != null) {
            this.awf.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.ceD);
    }
}
