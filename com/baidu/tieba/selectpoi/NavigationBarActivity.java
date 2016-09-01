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
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected q aAN;
    protected NavigationBar aUG;
    private RelativeLayout eiw;
    protected NoNetworkView fdm;
    private RelativeLayout fdn;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(t.h.nevigationbar_layout);
        this.aUG = (NavigationBar) findViewById(t.g.navigation_bar);
        this.eiw = (RelativeLayout) findViewById(t.g.navigation_bar_root);
        this.aUG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (bbX()) {
            this.fdm = (NoNetworkView) ((ViewStub) findViewById(t.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.aAN == null) {
            this.aAN = NoDataViewFactory.a(getPageContext().getContext(), this.eiw, cVar, dVar, bVar);
        }
        this.aAN.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aAN.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.aAN != null) {
            this.aAN.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        bbX();
        this.fdn = new RelativeLayout(getPageContext().getContext());
        this.fdn.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eiw.addView(this.fdn, 0, layoutParams);
    }

    protected boolean bbX() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bbX()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.fdn = new RelativeLayout(getPageContext().getContext());
        this.fdn.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eiw.addView(this.fdn, layoutParams);
    }

    protected View abK() {
        return this.fdn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aUG.onChangeSkinType(getPageContext(), i);
        if (this.fdm != null) {
            this.fdm.onChangeSkinType(getPageContext(), i);
        }
        if (this.aAN != null) {
            this.aAN.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.eiw);
    }
}
