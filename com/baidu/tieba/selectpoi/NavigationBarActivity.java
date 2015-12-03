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
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aJm;
    protected n awY;
    private RelativeLayout cxP;
    protected NoNetworkView dkH;
    private RelativeLayout dkI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(n.g.nevigationbar_layout);
        this.aJm = (NavigationBar) findViewById(n.f.navigation_bar);
        this.cxP = (RelativeLayout) findViewById(n.f.navigation_bar_root);
        this.aJm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (awS()) {
            this.dkH = (NoNetworkView) ((ViewStub) findViewById(n.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.awY == null) {
            this.awY = NoDataViewFactory.a(getPageContext().getContext(), this.cxP, cVar, dVar, bVar);
        }
        this.awY.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.awY.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.awY != null) {
            this.awY.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (awS()) {
            layoutParams.addRule(3, n.f.no_network_view);
        } else {
            layoutParams.addRule(3, n.f.no_network_viewstub);
        }
        this.dkI = new RelativeLayout(getPageContext().getContext());
        this.dkI.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cxP.addView(this.dkI, layoutParams);
    }

    protected boolean awS() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (awS()) {
            layoutParams.addRule(3, n.f.no_network_view);
        } else {
            layoutParams.addRule(3, n.f.no_network_viewstub);
        }
        this.dkI = new RelativeLayout(getPageContext().getContext());
        this.dkI.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.cxP.addView(this.dkI, layoutParams);
    }

    protected View getRootView() {
        return this.cxP;
    }

    protected View NN() {
        return this.dkI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aJm.onChangeSkinType(getPageContext(), i);
        if (this.dkH != null) {
            this.dkH.onChangeSkinType(getPageContext(), i);
        }
        if (this.awY != null) {
            this.awY.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.cxP);
    }
}
