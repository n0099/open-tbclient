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
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aLP;
    protected o azs;
    private RelativeLayout cIc;
    protected NoNetworkView dHT;
    private RelativeLayout dHU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(t.h.nevigationbar_layout);
        this.aLP = (NavigationBar) findViewById(t.g.navigation_bar);
        this.cIc = (RelativeLayout) findViewById(t.g.navigation_bar_root);
        this.aLP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aGg()) {
            this.dHT = (NoNetworkView) ((ViewStub) findViewById(t.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.azs == null) {
            this.azs = NoDataViewFactory.a(getPageContext().getContext(), this.cIc, cVar, dVar, bVar);
        }
        this.azs.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.azs.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.azs != null) {
            this.azs.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aGg()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.dHU = new RelativeLayout(getPageContext().getContext());
        this.dHU.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cIc.addView(this.dHU, layoutParams);
    }

    protected boolean aGg() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aGg()) {
            layoutParams.addRule(3, t.g.no_network_view);
        } else {
            layoutParams.addRule(3, t.g.no_network_viewstub);
        }
        this.dHU = new RelativeLayout(getPageContext().getContext());
        this.dHU.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.cIc.addView(this.dHU, layoutParams);
    }

    protected View getRootView() {
        return this.cIc;
    }

    protected View Qj() {
        return this.dHU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aLP.onChangeSkinType(getPageContext(), i);
        if (this.dHT != null) {
            this.dHT.onChangeSkinType(getPageContext(), i);
        }
        if (this.azs != null) {
            this.azs.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.cIc);
    }
}
