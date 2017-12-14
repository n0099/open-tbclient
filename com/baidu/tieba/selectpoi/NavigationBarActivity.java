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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected g aIW;
    protected NavigationBar bfX;
    private RelativeLayout eNL;
    protected NoNetworkView geC;
    private RelativeLayout geD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bfX = (NavigationBar) findViewById(d.g.navigation_bar);
        this.eNL = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bfX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bnk()) {
            this.geC = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bnk()) {
        }
        this.geD = new RelativeLayout(getPageContext().getContext());
        this.geD.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eNL.addView(this.geD, 0, layoutParams);
    }

    protected boolean bnk() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bnk()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.geD = new RelativeLayout(getPageContext().getContext());
        this.geD.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eNL.addView(this.geD, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bfX.onChangeSkinType(getPageContext(), i);
        if (this.geC != null) {
            this.geC.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIW != null) {
            this.aIW.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.eNL);
    }
}
