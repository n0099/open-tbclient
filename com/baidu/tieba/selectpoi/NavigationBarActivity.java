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
    protected y aEO;
    protected NavigationBar aYD;
    private RelativeLayout egn;
    protected NoNetworkView feZ;
    private RelativeLayout ffa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.j.nevigationbar_layout);
        this.aYD = (NavigationBar) findViewById(w.h.navigation_bar);
        this.egn = (RelativeLayout) findViewById(w.h.navigation_bar_root);
        this.aYD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (baw()) {
            this.feZ = (NoNetworkView) ((ViewStub) findViewById(w.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baw();
        this.ffa = new RelativeLayout(getPageContext().getContext());
        this.ffa.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.egn.addView(this.ffa, 0, layoutParams);
    }

    protected boolean baw() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (baw()) {
            layoutParams.addRule(3, w.h.no_network_view);
        } else {
            layoutParams.addRule(3, w.h.no_network_viewstub);
        }
        this.ffa = new RelativeLayout(getPageContext().getContext());
        this.ffa.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.egn.addView(this.ffa, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aYD.onChangeSkinType(getPageContext(), i);
        if (this.feZ != null) {
            this.feZ.onChangeSkinType(getPageContext(), i);
        }
        if (this.aEO != null) {
            this.aEO.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.egn);
    }
}
