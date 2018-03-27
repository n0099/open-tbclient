package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar bVs;
    protected h bzc;
    private RelativeLayout fFP;
    protected NoNetworkView gKQ;
    private RelativeLayout gKR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bVs = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fFP = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bpJ()) {
            this.gKQ = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpJ()) {
        }
        this.gKR = new RelativeLayout(getPageContext().getContext());
        this.gKR.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.fFP.addView(this.gKR, 0, layoutParams);
    }

    protected boolean bpJ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpJ()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gKR = new RelativeLayout(getPageContext().getContext());
        this.gKR.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.fFP.addView(this.gKR, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bVs.onChangeSkinType(getPageContext(), i);
        if (this.gKQ != null) {
            this.gKQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.bzc != null) {
            this.bzc.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fFP);
    }
}
