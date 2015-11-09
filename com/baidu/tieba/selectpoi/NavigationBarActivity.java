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
    protected NavigationBar aGn;
    protected m auU;
    protected NoNetworkView cMq;
    private RelativeLayout cMr;
    private RelativeLayout cfp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(i.g.nevigationbar_layout);
        this.aGn = (NavigationBar) findViewById(i.f.navigation_bar);
        this.cfp = (RelativeLayout) findViewById(i.f.navigation_bar_root);
        this.aGn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aru()) {
            this.cMq = (NoNetworkView) ((ViewStub) findViewById(i.f.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.auU == null) {
            this.auU = NoDataViewFactory.a(getPageContext().getContext(), this.cfp, cVar, dVar, bVar);
        }
        this.auU.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.auU.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.auU != null) {
            this.auU.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aru()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cMr = new RelativeLayout(getPageContext().getContext());
        this.cMr.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cfp.addView(this.cMr, layoutParams);
    }

    protected boolean aru() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aru()) {
            layoutParams.addRule(3, i.f.no_network_view);
        } else {
            layoutParams.addRule(3, i.f.no_network_viewstub);
        }
        this.cMr = new RelativeLayout(getPageContext().getContext());
        this.cMr.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.cfp.addView(this.cMr, layoutParams);
    }

    protected View getRootView() {
        return this.cfp;
    }

    protected View Mm() {
        return this.cMr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aGn.onChangeSkinType(getPageContext(), i);
        if (this.cMq != null) {
            this.cMq.onChangeSkinType(getPageContext(), i);
        }
        if (this.auU != null) {
            this.auU.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.cfp);
    }
}
