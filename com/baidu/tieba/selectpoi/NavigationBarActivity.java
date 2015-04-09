package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.core.view.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected s anU;
    protected NavigationBar anu;
    protected NoNetworkView bZj;
    private RelativeLayout bZk;
    private RelativeLayout bZl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.nevigationbar_layout);
        this.anu = (NavigationBar) findViewById(v.navigation_bar);
        this.bZk = (RelativeLayout) findViewById(v.navigation_bar_root);
        this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (agj()) {
            this.bZj = (NoNetworkView) ((ViewStub) findViewById(v.no_network_viewstub)).inflate();
        }
    }

    protected void a(com.baidu.tbadk.core.view.v vVar, com.baidu.tbadk.core.view.w wVar, u uVar) {
        if (this.anU == null) {
            this.anU = NoDataViewFactory.a(getPageContext().getContext(), this.bZk, vVar, wVar, uVar);
        }
        this.anU.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.anU.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.anU != null) {
            this.anU.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (agj()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bZl = new RelativeLayout(getPageContext().getContext());
        this.bZl.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bZk.addView(this.bZl, layoutParams);
    }

    protected boolean agj() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (agj()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bZl = new RelativeLayout(getPageContext().getContext());
        this.bZl.addView(b.hH().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bZk.addView(this.bZl, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bZk;
    }

    protected View Ks() {
        return this.bZl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.anu.onChangeSkinType(getPageContext(), i);
        if (this.bZj != null) {
            this.bZj.onChangeSkinType(getPageContext(), i);
        }
        if (this.anU != null) {
            this.anU.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bZk);
    }
}
