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
    protected NoDataView aJy;
    private RelativeLayout bDx;
    protected NavigationBar bfy;
    protected NoNetworkView gfQ;
    private RelativeLayout gfR;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.i.nevigationbar_layout);
        this.bfy = (NavigationBar) findViewById(d.g.navigation_bar);
        this.bDx = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bkQ()) {
            this.gfQ = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkQ()) {
        }
        this.gfR = new RelativeLayout(getPageContext().getContext());
        this.gfR.addView(view2, new ViewGroup.LayoutParams(-1, -1));
        this.bDx.addView(this.gfR, 0, layoutParams);
    }

    protected boolean bkQ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bkQ()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gfR = new RelativeLayout(getPageContext().getContext());
        this.gfR.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.bDx.addView(this.gfR, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bfy.onChangeSkinType(getPageContext(), i);
        if (this.gfQ != null) {
            this.gfQ.onChangeSkinType(getPageContext(), i);
        }
        if (this.aJy != null) {
            this.aJy.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.bDx);
    }
}
