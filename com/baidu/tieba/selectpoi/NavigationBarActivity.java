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
    protected f aHM;
    protected NavigationBar bcj;
    private RelativeLayout ewK;
    protected NoNetworkView fIM;
    private RelativeLayout fIN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.bcj = (NavigationBar) findViewById(d.h.navigation_bar);
        this.ewK = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.bcj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bhl()) {
            this.fIM = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bhl()) {
        }
        this.fIN = new RelativeLayout(getPageContext().getContext());
        this.fIN.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ewK.addView(this.fIN, 0, layoutParams);
    }

    protected boolean bhl() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bhl()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fIN = new RelativeLayout(getPageContext().getContext());
        this.fIN.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ewK.addView(this.fIN, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bcj.onChangeSkinType(getPageContext(), i);
        if (this.fIM != null) {
            this.fIM.onChangeSkinType(getPageContext(), i);
        }
        if (this.aHM != null) {
            this.aHM.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.ewK);
    }
}
