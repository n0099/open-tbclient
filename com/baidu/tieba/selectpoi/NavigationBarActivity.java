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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NoDataView aSW;
    private RelativeLayout bPD;
    protected NavigationBar bpP;
    protected NoNetworkView gxp;
    private RelativeLayout gxq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(f.h.nevigationbar_layout);
        this.bpP = (NavigationBar) findViewById(f.g.navigation_bar);
        this.bPD = (RelativeLayout) findViewById(f.g.navigation_bar_root);
        this.bpP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (boS()) {
            this.gxp = (NoNetworkView) ((ViewStub) findViewById(f.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (boS()) {
        }
        this.gxq = new RelativeLayout(getPageContext().getContext());
        this.gxq.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bPD.addView(this.gxq, 0, layoutParams);
    }

    protected boolean boS() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (boS()) {
            layoutParams.addRule(3, f.g.no_network_view);
        } else {
            layoutParams.addRule(3, f.g.no_network_viewstub);
        }
        this.gxq = new RelativeLayout(getPageContext().getContext());
        this.gxq.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bPD.addView(this.gxq, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bpP.onChangeSkinType(getPageContext(), i);
        if (this.gxp != null) {
            this.gxp.onChangeSkinType(getPageContext(), i);
        }
        if (this.aSW != null) {
            this.aSW.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bPD);
    }
}
