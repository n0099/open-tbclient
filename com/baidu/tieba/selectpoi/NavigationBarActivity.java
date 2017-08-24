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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected j aIK;
    protected NavigationBar baP;
    private RelativeLayout eEf;
    protected NoNetworkView fNl;
    private RelativeLayout fNm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.baP = (NavigationBar) findViewById(d.h.navigation_bar);
        this.eEf = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.baP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bjA()) {
            this.fNl = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bjA()) {
        }
        this.fNm = new RelativeLayout(getPageContext().getContext());
        this.fNm.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eEf.addView(this.fNm, 0, layoutParams);
    }

    protected boolean bjA() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bjA()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fNm = new RelativeLayout(getPageContext().getContext());
        this.fNm.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eEf.addView(this.fNm, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.baP.onChangeSkinType(getPageContext(), i);
        if (this.fNl != null) {
            this.fNl.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIK != null) {
            this.aIK.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eEf);
    }
}
