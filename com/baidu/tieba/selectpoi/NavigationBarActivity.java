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
    protected y aFk;
    protected NavigationBar aZq;
    private RelativeLayout ebt;
    protected NoNetworkView feO;
    private RelativeLayout feP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.j.nevigationbar_layout);
        this.aZq = (NavigationBar) findViewById(w.h.navigation_bar);
        this.ebt = (RelativeLayout) findViewById(w.h.navigation_bar_root);
        this.aZq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (aZF()) {
            this.feO = (NoNetworkView) ((ViewStub) findViewById(w.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        aZF();
        this.feP = new RelativeLayout(getPageContext().getContext());
        this.feP.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ebt.addView(this.feP, 0, layoutParams);
    }

    protected boolean aZF() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (aZF()) {
            layoutParams.addRule(3, w.h.no_network_view);
        } else {
            layoutParams.addRule(3, w.h.no_network_viewstub);
        }
        this.feP = new RelativeLayout(getPageContext().getContext());
        this.feP.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ebt.addView(this.feP, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aZq.onChangeSkinType(getPageContext(), i);
        if (this.feO != null) {
            this.feO.onChangeSkinType(getPageContext(), i);
        }
        if (this.aFk != null) {
            this.aFk.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.ebt);
    }
}
