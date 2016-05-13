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
    protected NavigationBar aKU;
    protected q awc;
    private RelativeLayout ddG;
    protected NoNetworkView edt;
    private RelativeLayout edu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(t.h.nevigationbar_layout);
        this.aKU = (NavigationBar) findViewById(t.g.navigation_bar);
        this.ddG = (RelativeLayout) findViewById(t.g.navigation_bar_root);
        this.aKU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aNd()) {
            this.edt = (NoNetworkView) ((ViewStub) findViewById(t.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.awc == null) {
            this.awc = NoDataViewFactory.a(getPageContext().getContext(), this.ddG, cVar, dVar, bVar);
        }
        this.awc.onChangeSkinType(getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.awc.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.awc != null) {
            this.awc.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        aNd();
        this.edu = new RelativeLayout(getPageContext().getContext());
        this.edu.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ddG.addView(this.edu, 0, layoutParams);
    }

    protected boolean aNd() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aNd()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.edu = new RelativeLayout(getPageContext().getContext());
        this.edu.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ddG.addView(this.edu, layoutParams);
    }

    protected View Rb() {
        return this.edu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aKU.onChangeSkinType(getPageContext(), i);
        if (this.edt != null) {
            this.edt.onChangeSkinType(getPageContext(), i);
        }
        if (this.awc != null) {
            this.awc.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.ddG);
    }
}
