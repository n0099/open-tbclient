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
    protected NoNetworkView aBw;
    protected NavigationBar aeV;
    protected x aft;
    private RelativeLayout bOy;
    private RelativeLayout bOz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(com.baidu.tieba.x.nevigationbar_layout);
        this.aeV = (NavigationBar) findViewById(w.navigation_bar);
        this.bOy = (RelativeLayout) findViewById(w.navigation_bar_root);
        this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (acO()) {
            this.aBw = (NoNetworkView) ((ViewStub) findViewById(w.no_network_viewstub)).inflate();
        }
    }

    protected void a(aa aaVar, ab abVar, z zVar) {
        if (this.aft == null) {
            this.aft = NoDataViewFactory.a(getPageContext().getContext(), this.bOy, aaVar, abVar, zVar);
        }
        this.aft.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.aft.setVisibility(0);
    }

    protected void Ic() {
        if (this.aft != null) {
            this.aft.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (acO()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bOz = new RelativeLayout(getPageContext().getContext());
        this.bOz.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bOy.addView(this.bOz, layoutParams);
    }

    protected boolean acO() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (acO()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bOz = new RelativeLayout(getPageContext().getContext());
        this.bOz.addView(com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bOy.addView(this.bOz, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bOy;
    }

    protected View Iy() {
        return this.bOz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aeV.onChangeSkinType(getPageContext(), i);
        if (this.aBw != null) {
            this.aBw.onChangeSkinType(getPageContext(), i);
        }
        if (this.aft != null) {
            this.aft.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bOy);
    }
}
