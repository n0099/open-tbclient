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
    protected s anM;
    protected NavigationBar anm;
    protected NoNetworkView bYU;
    private RelativeLayout bYV;
    private RelativeLayout bYW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.nevigationbar_layout);
        this.anm = (NavigationBar) findViewById(v.navigation_bar);
        this.bYV = (RelativeLayout) findViewById(v.navigation_bar_root);
        this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (afU()) {
            this.bYU = (NoNetworkView) ((ViewStub) findViewById(v.no_network_viewstub)).inflate();
        }
    }

    protected void a(com.baidu.tbadk.core.view.v vVar, com.baidu.tbadk.core.view.w wVar, u uVar) {
        if (this.anM == null) {
            this.anM = NoDataViewFactory.a(getPageContext().getContext(), this.bYV, vVar, wVar, uVar);
        }
        this.anM.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.anM.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.anM != null) {
            this.anM.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (afU()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bYW = new RelativeLayout(getPageContext().getContext());
        this.bYW.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bYV.addView(this.bYW, layoutParams);
    }

    protected boolean afU() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (afU()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bYW = new RelativeLayout(getPageContext().getContext());
        this.bYW.addView(b.hH().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bYV.addView(this.bYW, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bYV;
    }

    protected View Kl() {
        return this.bYW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.anm.onChangeSkinType(getPageContext(), i);
        if (this.bYU != null) {
            this.bYU.onChangeSkinType(getPageContext(), i);
        }
        if (this.anM != null) {
            this.anM.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bYV);
    }
}
