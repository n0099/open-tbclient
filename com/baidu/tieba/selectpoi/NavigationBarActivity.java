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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NoDataView aSa;
    private RelativeLayout bMA;
    protected NavigationBar bnG;
    protected NoNetworkView gsn;
    private RelativeLayout gso;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.i.nevigationbar_layout);
        this.bnG = (NavigationBar) findViewById(d.g.navigation_bar);
        this.bMA = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bpN()) {
            this.gsn = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpN()) {
        }
        this.gso = new RelativeLayout(getPageContext().getContext());
        this.gso.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bMA.addView(this.gso, 0, layoutParams);
    }

    protected boolean bpN() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bpN()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gso = new RelativeLayout(getPageContext().getContext());
        this.gso.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bMA.addView(this.gso, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bnG.onChangeSkinType(getPageContext(), i);
        if (this.gsn != null) {
            this.gsn.onChangeSkinType(getPageContext(), i);
        }
        if (this.aSa != null) {
            this.aSa.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bMA);
    }
}
