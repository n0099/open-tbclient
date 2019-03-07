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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar cPN;
    protected NoDataView cpw;
    private RelativeLayout dxT;
    protected NoNetworkView iqj;
    private RelativeLayout iqk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.cPN = (NavigationBar) findViewById(d.g.navigation_bar);
        this.dxT = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bYn()) {
            this.iqj = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bYn()) {
        }
        this.iqk = new RelativeLayout(getPageContext().getContext());
        this.iqk.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.dxT.addView(this.iqk, 0, layoutParams);
    }

    protected boolean bYn() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bYn()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.iqk = new RelativeLayout(getPageContext().getContext());
        this.iqk.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.dxT.addView(this.iqk, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cPN.onChangeSkinType(getPageContext(), i);
        if (this.iqj != null) {
            this.iqj.onChangeSkinType(getPageContext(), i);
        }
        if (this.cpw != null) {
            this.cpw.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dxT);
    }
}
