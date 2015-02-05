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
    protected NoNetworkView aBt;
    protected NavigationBar aeS;
    protected x afq;
    private RelativeLayout bOx;
    private RelativeLayout bOy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(com.baidu.tieba.x.nevigationbar_layout);
        this.aeS = (NavigationBar) findViewById(w.navigation_bar);
        this.bOx = (RelativeLayout) findViewById(w.navigation_bar_root);
        this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (acJ()) {
            this.aBt = (NoNetworkView) ((ViewStub) findViewById(w.no_network_viewstub)).inflate();
        }
    }

    protected void a(aa aaVar, ab abVar, z zVar) {
        if (this.afq == null) {
            this.afq = NoDataViewFactory.a(getPageContext().getContext(), this.bOx, aaVar, abVar, zVar);
        }
        this.afq.onChangeSkinType(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.afq.setVisibility(0);
    }

    protected void HW() {
        if (this.afq != null) {
            this.afq.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (acJ()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bOy = new RelativeLayout(getPageContext().getContext());
        this.bOy.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bOx.addView(this.bOy, layoutParams);
    }

    protected boolean acJ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (acJ()) {
            layoutParams.addRule(3, w.no_network_view);
        } else {
            layoutParams.addRule(3, w.no_network_viewstub);
        }
        this.bOy = new RelativeLayout(getPageContext().getContext());
        this.bOy.addView(com.baidu.adp.lib.g.b.ei().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bOx.addView(this.bOy, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bOx;
    }

    protected View Is() {
        return this.bOy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aeS.onChangeSkinType(getPageContext(), i);
        if (this.aBt != null) {
            this.aBt.onChangeSkinType(getPageContext(), i);
        }
        if (this.afq != null) {
            this.afq.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bOx);
    }
}
