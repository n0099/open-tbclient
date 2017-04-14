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
    protected y aFe;
    protected NavigationBar aYR;
    private RelativeLayout eeu;
    protected NoNetworkView fgA;
    private RelativeLayout fgB;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.j.nevigationbar_layout);
        this.aYR = (NavigationBar) findViewById(w.h.navigation_bar);
        this.eeu = (RelativeLayout) findViewById(w.h.navigation_bar_root);
        this.aYR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (bbf()) {
            this.fgA = (NoNetworkView) ((ViewStub) findViewById(w.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        bbf();
        this.fgB = new RelativeLayout(getPageContext().getContext());
        this.fgB.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eeu.addView(this.fgB, 0, layoutParams);
    }

    protected boolean bbf() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bbf()) {
            layoutParams.addRule(3, w.h.no_network_view);
        } else {
            layoutParams.addRule(3, w.h.no_network_viewstub);
        }
        this.fgB = new RelativeLayout(getPageContext().getContext());
        this.fgB.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eeu.addView(this.fgB, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aYR.onChangeSkinType(getPageContext(), i);
        if (this.fgA != null) {
            this.fgA.onChangeSkinType(getPageContext(), i);
        }
        if (this.aFe != null) {
            this.aFe.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.eeu);
    }
}
