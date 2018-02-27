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
    protected NavigationBar bVp;
    protected h byZ;
    private RelativeLayout fFz;
    protected NoNetworkView gKA;
    private RelativeLayout gKB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bVp = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fFz = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bpI()) {
            this.gKA = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpI()) {
        }
        this.gKB = new RelativeLayout(getPageContext().getContext());
        this.gKB.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.fFz.addView(this.gKB, 0, layoutParams);
    }

    protected boolean bpI() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpI()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gKB = new RelativeLayout(getPageContext().getContext());
        this.gKB.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.fFz.addView(this.gKB, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bVp.onChangeSkinType(getPageContext(), i);
        if (this.gKA != null) {
            this.gKA.onChangeSkinType(getPageContext(), i);
        }
        if (this.byZ != null) {
            this.byZ.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.fFz);
    }
}
