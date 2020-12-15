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
    protected NavigationBar gcI;
    protected NoNetworkView mTf;
    private RelativeLayout mTg;
    private RelativeLayout rootView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(R.layout.nevigationbar_layout);
        this.gcI = (NavigationBar) findViewById(R.id.navigation_bar);
        this.rootView = (RelativeLayout) findViewById(R.id.navigation_bar_root);
        this.gcI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (dHL()) {
            this.mTf = (NoNetworkView) ((ViewStub) findViewById(R.id.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (dHL()) {
        }
        this.mTg = new RelativeLayout(getPageContext().getContext());
        this.mTg.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.mTg, 0, layoutParams);
    }

    protected boolean dHL() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (dHL()) {
            layoutParams.addRule(3, R.id.no_network_view);
        } else {
            layoutParams.addRule(3, R.id.no_network_viewstub);
        }
        this.mTg = new RelativeLayout(getPageContext().getContext());
        this.mTg.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.rootView.addView(this.mTg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gcI.onChangeSkinType(getPageContext(), i);
        if (this.mTf != null) {
            this.mTf.onChangeSkinType(getPageContext(), i);
        }
        if (this.fBi != null) {
            this.fBi.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.rootView);
    }
}
