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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aPm;
    protected q axG;
    private RelativeLayout dWr;
    protected NoNetworkView eVb;
    private RelativeLayout eVc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(u.h.nevigationbar_layout);
        this.aPm = (NavigationBar) findViewById(u.g.navigation_bar);
        this.dWr = (RelativeLayout) findViewById(u.g.navigation_bar_root);
        this.aPm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aYv()) {
            this.eVb = (NoNetworkView) ((ViewStub) findViewById(u.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.axG == null) {
            this.axG = NoDataViewFactory.a(getPageContext().getContext(), this.dWr, cVar, dVar, bVar);
        }
        this.axG.onChangeSkinType(getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.axG.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.axG != null) {
            this.axG.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        aYv();
        this.eVc = new RelativeLayout(getPageContext().getContext());
        this.eVc.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.dWr.addView(this.eVc, 0, layoutParams);
    }

    protected boolean aYv() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aYv()) {
            layoutParams.addRule(3, u.g.no_network_view);
        } else {
            layoutParams.addRule(3, u.g.no_network_viewstub);
        }
        this.eVc = new RelativeLayout(getPageContext().getContext());
        this.eVc.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.dWr.addView(this.eVc, layoutParams);
    }

    protected View WO() {
        return this.eVc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aPm.onChangeSkinType(getPageContext(), i);
        if (this.eVb != null) {
            this.eVb.onChangeSkinType(getPageContext(), i);
        }
        if (this.axG != null) {
            this.axG.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.dWr);
    }
}
