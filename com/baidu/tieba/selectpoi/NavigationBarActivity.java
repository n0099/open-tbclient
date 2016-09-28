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
import com.baidu.tbadk.core.view.v;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected v aAq;
    protected NavigationBar aVp;
    private RelativeLayout eku;
    protected NoNetworkView ffU;
    private RelativeLayout ffV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(r.h.nevigationbar_layout);
        this.aVp = (NavigationBar) findViewById(r.g.navigation_bar);
        this.eku = (RelativeLayout) findViewById(r.g.navigation_bar_root);
        this.aVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (bcH()) {
            this.ffU = (NoNetworkView) ((ViewStub) findViewById(r.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.aAq == null) {
            this.aAq = NoDataViewFactory.a(getPageContext().getContext(), this.eku, cVar, dVar, bVar);
        }
        this.aAq.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAq.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.aAq != null) {
            this.aAq.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        bcH();
        this.ffV = new RelativeLayout(getPageContext().getContext());
        this.ffV.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eku.addView(this.ffV, 0, layoutParams);
    }

    protected boolean bcH() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bcH()) {
            layoutParams.addRule(3, r.g.no_network_view);
        } else {
            layoutParams.addRule(3, r.g.no_network_viewstub);
        }
        this.ffV = new RelativeLayout(getPageContext().getContext());
        this.ffV.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eku.addView(this.ffV, layoutParams);
    }

    protected View abX() {
        return this.ffV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aVp.onChangeSkinType(getPageContext(), i);
        if (this.ffU != null) {
            this.ffU.onChangeSkinType(getPageContext(), i);
        }
        if (this.aAq != null) {
            this.aAq.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.eku);
    }
}
