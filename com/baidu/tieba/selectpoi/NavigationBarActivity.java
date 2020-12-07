package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NoDataView fBi;
    protected NavigationBar gcG;
    protected NoNetworkView mTd;
    private RelativeLayout mTe;
    private RelativeLayout rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.nevigationbar_layout);
        this.gcG = (NavigationBar) findViewById(R.id.navigation_bar);
        this.rootView = (RelativeLayout) findViewById(R.id.navigation_bar_root);
        this.gcG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (dHK()) {
            this.mTd = (NoNetworkView) ((ViewStub) findViewById(R.id.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (dHK()) {
        }
        this.mTe = new RelativeLayout(getPageContext().getContext());
        this.mTe.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.mTe, 0, layoutParams);
    }

    protected boolean dHK() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (dHK()) {
            layoutParams.addRule(3, R.id.no_network_view);
        } else {
            layoutParams.addRule(3, R.id.no_network_viewstub);
        }
        this.mTe = new RelativeLayout(getPageContext().getContext());
        this.mTe.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.mTe, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gcG.onChangeSkinType(getPageContext(), i);
        if (this.mTd != null) {
            this.mTd.onChangeSkinType(getPageContext(), i);
        }
        if (this.fBi != null) {
            this.fBi.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.rootView);
    }
}
