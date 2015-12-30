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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aKK;
    protected o ayC;
    private RelativeLayout cBw;
    protected NoNetworkView drP;
    private RelativeLayout drQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(n.h.nevigationbar_layout);
        this.aKK = (NavigationBar) findViewById(n.g.navigation_bar);
        this.cBw = (RelativeLayout) findViewById(n.g.navigation_bar_root);
        this.aKK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (ayZ()) {
            this.drP = (NoNetworkView) ((ViewStub) findViewById(n.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.ayC == null) {
            this.ayC = NoDataViewFactory.a(getPageContext().getContext(), this.cBw, cVar, dVar, bVar);
        }
        this.ayC.onChangeSkinType(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.ayC.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.ayC != null) {
            this.ayC.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ayZ()) {
            layoutParams.addRule(3, n.g.no_network_view);
        } else {
            layoutParams.addRule(3, n.g.no_network_viewstub);
        }
        this.drQ = new RelativeLayout(getPageContext().getContext());
        this.drQ.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cBw.addView(this.drQ, layoutParams);
    }

    protected boolean ayZ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (ayZ()) {
            layoutParams.addRule(3, n.g.no_network_view);
        } else {
            layoutParams.addRule(3, n.g.no_network_viewstub);
        }
        this.drQ = new RelativeLayout(getPageContext().getContext());
        this.drQ.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.cBw.addView(this.drQ, layoutParams);
    }

    protected View getRootView() {
        return this.cBw;
    }

    protected View Og() {
        return this.drQ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aKK.onChangeSkinType(getPageContext(), i);
        if (this.drP != null) {
            this.drP.onChangeSkinType(getPageContext(), i);
        }
        if (this.ayC != null) {
            this.ayC.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.cBw);
    }
}
