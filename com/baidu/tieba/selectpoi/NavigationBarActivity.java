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
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NoDataView aWl;
    private RelativeLayout bVs;
    protected NavigationBar bvF;
    protected NoNetworkView gEG;
    private RelativeLayout gEH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(e.h.nevigationbar_layout);
        this.bvF = (NavigationBar) findViewById(e.g.navigation_bar);
        this.bVs = (RelativeLayout) findViewById(e.g.navigation_bar_root);
        this.bvF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (brz()) {
            this.gEG = (NoNetworkView) ((ViewStub) findViewById(e.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (brz()) {
        }
        this.gEH = new RelativeLayout(getPageContext().getContext());
        this.gEH.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bVs.addView(this.gEH, 0, layoutParams);
    }

    protected boolean brz() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (brz()) {
            layoutParams.addRule(3, e.g.no_network_view);
        } else {
            layoutParams.addRule(3, e.g.no_network_viewstub);
        }
        this.gEH = new RelativeLayout(getPageContext().getContext());
        this.gEH.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bVs.addView(this.gEH, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bvF.onChangeSkinType(getPageContext(), i);
        if (this.gEG != null) {
            this.gEG.onChangeSkinType(getPageContext(), i);
        }
        if (this.aWl != null) {
            this.aWl.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.bVs);
    }
}
