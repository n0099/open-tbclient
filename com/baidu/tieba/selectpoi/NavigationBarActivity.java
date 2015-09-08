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
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aIp;
    protected u axG;
    private RelativeLayout bZv;
    protected NoNetworkView cDu;
    private RelativeLayout cDv;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(i.g.nevigationbar_layout);
        this.aIp = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bZv = (RelativeLayout) findViewById(i.f.navigation_bar_root);
        this.aIp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aou()) {
            this.cDu = (NoNetworkView) ((ViewStub) findViewById(i.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.axG == null) {
            this.axG = NoDataViewFactory.a(getPageContext().getContext(), this.bZv, cVar, dVar, bVar);
        }
        this.axG.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.axG.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.axG != null) {
            this.axG.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aou()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cDv = new RelativeLayout(getPageContext().getContext());
        this.cDv.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bZv.addView(this.cDv, layoutParams);
    }

    protected boolean aou() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aou()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cDv = new RelativeLayout(getPageContext().getContext());
        this.cDv.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bZv.addView(this.cDv, layoutParams);
    }

    protected View getRootView() {
        return this.bZv;
    }

    protected View Mb() {
        return this.cDv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aIp.onChangeSkinType(getPageContext(), i);
        if (this.cDu != null) {
            this.cDu.onChangeSkinType(getPageContext(), i);
        }
        if (this.axG != null) {
            this.axG.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bZv);
    }
}
