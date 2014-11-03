package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity {
    protected o Yn;
    protected NoNetworkView ayp;
    private RelativeLayout bIM;
    private RelativeLayout bIN;
    protected NavigationBar bhL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.nevigationbar_layout);
        this.bhL = (NavigationBar) findViewById(v.navigation_bar);
        this.bIM = (RelativeLayout) findViewById(v.navigation_bar_root);
        this.bhL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (Ic()) {
            this.ayp = (NoNetworkView) ((ViewStub) findViewById(v.no_network_viewstub)).inflate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar, s sVar, q qVar) {
        if (this.Yn == null) {
            this.Yn = NoDataViewFactory.a(this, this.bIM, rVar, sVar, qVar);
        }
        this.Yn.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        this.Yn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abR() {
        if (this.Yn != null) {
            this.Yn.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (Ic()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bIN = new RelativeLayout(this);
        this.bIN.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bIM.addView(this.bIN, layoutParams);
    }

    protected boolean Ic() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (Ic()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bIN = new RelativeLayout(this);
        this.bIN.addView(com.baidu.adp.lib.g.b.ek().inflate(this, i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bIM.addView(this.bIN, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bIM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View abS() {
        return this.bIN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bhL.onChangeSkinType(i);
        if (this.ayp != null) {
            this.ayp.onChangeSkinType(i);
        }
        if (this.Yn != null) {
            this.Yn.onChangeSkinType(i);
        }
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bIM);
    }
}
