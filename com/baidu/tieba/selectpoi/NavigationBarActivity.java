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
    protected NavigationBar bVB;
    protected h bzm;
    private RelativeLayout fFK;
    protected NoNetworkView gKP;
    private RelativeLayout gKQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bVB = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fFK = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bVB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bpJ()) {
            this.gKP = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpJ()) {
        }
        this.gKQ = new RelativeLayout(getPageContext().getContext());
        this.gKQ.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.fFK.addView(this.gKQ, 0, layoutParams);
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
        this.gKQ = new RelativeLayout(getPageContext().getContext());
        this.gKQ.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.fFK.addView(this.gKQ, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bVB.onChangeSkinType(getPageContext(), i);
        if (this.gKP != null) {
            this.gKP.onChangeSkinType(getPageContext(), i);
        }
        if (this.bzm != null) {
            this.bzm.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fFK);
    }
}
