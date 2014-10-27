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
    protected o Yj;
    protected NoNetworkView ayg;
    private RelativeLayout bIy;
    private RelativeLayout bIz;
    protected NavigationBar bhx;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.nevigationbar_layout);
        this.bhx = (NavigationBar) findViewById(v.navigation_bar);
        this.bIy = (RelativeLayout) findViewById(v.navigation_bar_root);
        this.bhx.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (HY()) {
            this.ayg = (NoNetworkView) ((ViewStub) findViewById(v.no_network_viewstub)).inflate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar, s sVar, q qVar) {
        if (this.Yj == null) {
            this.Yj = NoDataViewFactory.a(this, this.bIy, rVar, sVar, qVar);
        }
        this.Yj.onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
        this.Yj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abO() {
        if (this.Yj != null) {
            this.Yj.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (HY()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bIz = new RelativeLayout(this);
        this.bIz.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.bIy.addView(this.bIz, layoutParams);
    }

    protected boolean HY() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (HY()) {
            layoutParams.addRule(3, v.no_network_view);
        } else {
            layoutParams.addRule(3, v.no_network_viewstub);
        }
        this.bIz = new RelativeLayout(this);
        this.bIz.addView(com.baidu.adp.lib.g.b.ek().inflate(this, i, null), new ViewGroup.LayoutParams(-1, -1));
        this.bIy.addView(this.bIz, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getRootView() {
        return this.bIy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View abP() {
        return this.bIz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bhx.onChangeSkinType(i);
        if (this.ayg != null) {
            this.ayg.onChangeSkinType(i);
        }
        if (this.Yj != null) {
            this.Yj.onChangeSkinType(i);
        }
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bIy);
    }
}
