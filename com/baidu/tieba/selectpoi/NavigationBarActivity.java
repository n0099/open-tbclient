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
    protected NavigationBar aIc;
    protected u avY;
    private RelativeLayout bYB;
    protected NoNetworkView cuY;
    private RelativeLayout cuZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(i.g.nevigationbar_layout);
        this.aIc = (NavigationBar) findViewById(i.f.navigation_bar);
        this.bYB = (RelativeLayout) findViewById(i.f.navigation_bar_root);
        this.aIc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (akn()) {
            this.cuY = (NoNetworkView) ((ViewStub) findViewById(i.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.avY == null) {
            this.avY = NoDataViewFactory.a(getPageContext().getContext(), this.bYB, cVar, dVar, bVar);
        }
        this.avY.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.avY.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.avY != null) {
            this.avY.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (akn()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cuZ = new RelativeLayout(getPageContext().getContext());
        this.cuZ.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bYB.addView(this.cuZ, layoutParams);
    }

    protected boolean akn() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (akn()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cuZ = new RelativeLayout(getPageContext().getContext());
        this.cuZ.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bYB.addView(this.cuZ, layoutParams);
    }

    protected View getRootView() {
        return this.bYB;
    }

    protected View Mk() {
        return this.cuZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aIc.onChangeSkinType(getPageContext(), i);
        if (this.cuY != null) {
            this.cuY.onChangeSkinType(getPageContext(), i);
        }
        if (this.avY != null) {
            this.avY.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.bYB);
    }
}
