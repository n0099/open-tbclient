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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.core.view.x;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected x aoX;
    protected NavigationBar aox;
    protected NoNetworkView cdv;
    private RelativeLayout cdw;
    private RelativeLayout cdx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(r.nevigationbar_layout);
        this.aox = (NavigationBar) findViewById(q.navigation_bar);
        this.cdw = (RelativeLayout) findViewById(q.navigation_bar_root);
        this.aox.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (ahY()) {
            this.cdv = (NoNetworkView) ((ViewStub) findViewById(q.no_network_viewstub)).inflate();
        }
    }

    protected void a(aa aaVar, ab abVar, z zVar) {
        if (this.aoX == null) {
            this.aoX = NoDataViewFactory.a(getPageContext().getContext(), this.cdw, aaVar, abVar, zVar);
        }
        this.aoX.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.aoX.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.aoX != null) {
            this.aoX.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ahY()) {
            layoutParams.addRule(3, q.no_network_view);
        } else {
            layoutParams.addRule(3, q.no_network_viewstub);
        }
        this.cdx = new RelativeLayout(getPageContext().getContext());
        this.cdx.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cdw.addView(this.cdx, layoutParams);
    }

    protected boolean ahY() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ahY()) {
            layoutParams.addRule(3, q.no_network_view);
        } else {
            layoutParams.addRule(3, q.no_network_viewstub);
        }
        this.cdx = new RelativeLayout(getPageContext().getContext());
        this.cdx.addView(b.hr().inflate(getPageContext().getContext(), i, null), new ViewGroup.LayoutParams(-1, -1));
        this.cdw.addView(this.cdx, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.cdw;
    }

    protected View Nt() {
        return this.cdx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aox.onChangeSkinType(getPageContext(), i);
        if (this.cdv != null) {
            this.cdv.onChangeSkinType(getPageContext(), i);
        }
        if (this.aoX != null) {
            this.aoX.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.cdw);
    }
}
