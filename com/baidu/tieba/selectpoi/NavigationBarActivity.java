package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NoNetworkView aAu;
    protected x aeW;
    protected NavigationBar aey;
    private RelativeLayout bMO;
    private RelativeLayout bMP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(com.baidu.tieba.x.nevigationbar_layout);
        this.aey = (NavigationBar) findViewById(w.navigation_bar);
        this.bMO = (RelativeLayout) findViewById(w.navigation_bar_root);
        this.aey.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (ack()) {
            this.aAu = (NoNetworkView) ((ViewStub) findViewById(w.no_network_viewstub)).inflate();
        }
    }

    protected void a(aa aaVar, ab abVar, z zVar) {
        if (this.aeW == null) {
            this.aeW = NoDataViewFactory.a(getPageContext().getContext(), this.bMO, aaVar, abVar, zVar);
        }
        this.aeW.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.aeW.setVisibility(0);
    }

    protected void HE() {
        if (this.aeW != null) {
            this.aeW.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ack()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bMP = new RelativeLayout(getPageContext().getContext());
        this.bMP.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bMO.addView(this.bMP, layoutParams);
    }

    protected boolean ack() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ack()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bMP = new RelativeLayout(getPageContext().getContext());
        this.bMP.addView(com.baidu.adp.lib.g.b.ek().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bMO.addView(this.bMP, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bMO;
    }

    protected View Ia() {
        return this.bMP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aey.onChangeSkinType(getPageContext(), i);
        if (this.aAu != null) {
            this.aAu.onChangeSkinType(getPageContext(), i);
        }
        if (this.aeW != null) {
            this.aeW.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bMO);
    }
}
