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
    protected j aIl;
    protected NavigationBar baw;
    private RelativeLayout eDs;
    protected NoNetworkView fMc;
    private RelativeLayout fMd;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.baw = (NavigationBar) findViewById(d.h.navigation_bar);
        this.eDs = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.baw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (biK()) {
            this.fMc = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (biK()) {
        }
        this.fMd = new RelativeLayout(getPageContext().getContext());
        this.fMd.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eDs.addView(this.fMd, 0, layoutParams);
    }

    protected boolean biK() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (biK()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fMd = new RelativeLayout(getPageContext().getContext());
        this.fMd.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eDs.addView(this.fMd, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.baw.onChangeSkinType(getPageContext(), i);
        if (this.fMc != null) {
            this.fMc.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIl != null) {
            this.aIl.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eDs);
    }
}
