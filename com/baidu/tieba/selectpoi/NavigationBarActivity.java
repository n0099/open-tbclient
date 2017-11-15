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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected f aIr;
    protected NavigationBar bcK;
    private RelativeLayout eEZ;
    protected NoNetworkView fSp;
    private RelativeLayout fSq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bcK = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eEZ = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bcK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bkE()) {
            this.fSp = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkE()) {
        }
        this.fSq = new RelativeLayout(getPageContext().getContext());
        this.fSq.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eEZ.addView(this.fSq, 0, layoutParams);
    }

    protected boolean bkE() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkE()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.fSq = new RelativeLayout(getPageContext().getContext());
        this.fSq.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eEZ.addView(this.fSq, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bcK.onChangeSkinType(getPageContext(), i);
        if (this.fSp != null) {
            this.fSp.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIr != null) {
            this.aIr.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.eEZ);
    }
}
