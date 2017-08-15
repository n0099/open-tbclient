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
    protected j aIJ;
    protected NavigationBar baO;
    private RelativeLayout eEd;
    protected NoNetworkView fNk;
    private RelativeLayout fNl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.baO = (NavigationBar) findViewById(d.h.navigation_bar);
        this.eEd = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.baO.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bjF()) {
            this.fNk = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bjF()) {
        }
        this.fNl = new RelativeLayout(getPageContext().getContext());
        this.fNl.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eEd.addView(this.fNl, 0, layoutParams);
    }

    protected boolean bjF() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bjF()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fNl = new RelativeLayout(getPageContext().getContext());
        this.fNl.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eEd.addView(this.fNl, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.baO.onChangeSkinType(getPageContext(), i);
        if (this.fNk != null) {
            this.fNk.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIJ != null) {
            this.aIJ.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eEd);
    }
}
