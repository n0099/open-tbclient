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
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    public RelativeLayout contentRootView;
    public NavigationBar navigationBar;
    public NoDataView noDataView;
    public NoNetworkView noNetWorkView;
    public RelativeLayout rootView;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            NavigationBarActivity.this.finish();
        }
    }

    public View getContentRootView() {
        return this.contentRootView;
    }

    public View getRootView() {
        return this.rootView;
    }

    public void hideNoDataView() {
        NoDataView noDataView = this.noDataView;
        if (noDataView != null) {
            noDataView.setVisibility(8);
        }
    }

    public boolean needNoNetWorkView() {
        return true;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.navigationBar.onChangeSkinType(getPageContext(), i2);
        NoNetworkView noNetworkView = this.noNetWorkView;
        if (noNetworkView != null) {
            noNetworkView.c(getPageContext(), i2);
        }
        NoDataView noDataView = this.noDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.rootView);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.nevigationbar_layout);
        this.navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        this.rootView = (RelativeLayout) findViewById(R.id.navigation_bar_root);
        this.navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        if (needNoNetWorkView()) {
            this.noNetWorkView = (NoNetworkView) ((ViewStub) findViewById(R.id.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        needNoNetWorkView();
        RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
        this.contentRootView = relativeLayout;
        relativeLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.contentRootView, 0, layoutParams);
    }

    public void showNoDataView(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar) {
        if (this.noDataView == null) {
            this.noDataView = NoDataViewFactory.a(getPageContext().getContext(), this.rootView, dVar, eVar, cVar);
        }
        this.noDataView.f(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.noDataView.setVisibility(0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (needNoNetWorkView()) {
            layoutParams.addRule(3, R.id.no_network_view);
        } else {
            layoutParams.addRule(3, R.id.no_network_viewstub);
        }
        RelativeLayout relativeLayout = new RelativeLayout(getPageContext().getContext());
        this.contentRootView = relativeLayout;
        relativeLayout.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i2, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.contentRootView, layoutParams);
    }
}
