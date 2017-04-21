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
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected y aFg;
    protected NavigationBar aYU;
    private RelativeLayout egK;
    protected NoNetworkView fiT;
    private RelativeLayout fiU;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.j.nevigationbar_layout);
        this.aYU = (NavigationBar) findViewById(w.h.navigation_bar);
        this.egK = (RelativeLayout) findViewById(w.h.navigation_bar_root);
        this.aYU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (bcg()) {
            this.fiT = (NoNetworkView) ((ViewStub) findViewById(w.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        bcg();
        this.fiU = new RelativeLayout(getPageContext().getContext());
        this.fiU.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.egK.addView(this.fiU, 0, layoutParams);
    }

    protected boolean bcg() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bcg()) {
            layoutParams.addRule(3, w.h.no_network_view);
        } else {
            layoutParams.addRule(3, w.h.no_network_viewstub);
        }
        this.fiU = new RelativeLayout(getPageContext().getContext());
        this.fiU.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.egK.addView(this.fiU, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aYU.onChangeSkinType(getPageContext(), i);
        if (this.fiT != null) {
            this.fiT.onChangeSkinType(getPageContext(), i);
        }
        if (this.aFg != null) {
            this.aFg.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.egK);
    }
}
