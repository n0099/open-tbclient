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
    protected NoDataView baL;
    protected NavigationBar bzH;
    private RelativeLayout cdS;
    protected NoNetworkView gMf;
    private RelativeLayout gMg;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(e.h.nevigationbar_layout);
        this.bzH = (NavigationBar) findViewById(e.g.navigation_bar);
        this.cdS = (RelativeLayout) findViewById(e.g.navigation_bar_root);
        this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (buO()) {
            this.gMf = (NoNetworkView) ((ViewStub) findViewById(e.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (buO()) {
        }
        this.gMg = new RelativeLayout(getPageContext().getContext());
        this.gMg.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.cdS.addView(this.gMg, 0, layoutParams);
    }

    protected boolean buO() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (buO()) {
            layoutParams.addRule(3, e.g.no_network_view);
        } else {
            layoutParams.addRule(3, e.g.no_network_viewstub);
        }
        this.gMg = new RelativeLayout(getPageContext().getContext());
        this.gMg.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.cdS.addView(this.gMg, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bzH.onChangeSkinType(getPageContext(), i);
        if (this.gMf != null) {
            this.gMf.onChangeSkinType(getPageContext(), i);
        }
        if (this.baL != null) {
            this.baL.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.cdS);
    }
}
