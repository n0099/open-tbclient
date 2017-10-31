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
    protected f aIj;
    protected NavigationBar bcB;
    private RelativeLayout eEF;
    protected NoNetworkView fRn;
    private RelativeLayout fRo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bcB = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eEF = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bcB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bkt()) {
            this.fRn = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkt()) {
        }
        this.fRo = new RelativeLayout(getPageContext().getContext());
        this.fRo.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eEF.addView(this.fRo, 0, layoutParams);
    }

    protected boolean bkt() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkt()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.fRo = new RelativeLayout(getPageContext().getContext());
        this.fRo.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eEF.addView(this.fRo, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bcB.onChangeSkinType(getPageContext(), i);
        if (this.fRn != null) {
            this.fRn.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIj != null) {
            this.aIj.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.eEF);
    }
}
