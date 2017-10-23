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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected f aHz;
    protected NavigationBar bbV;
    private RelativeLayout eww;
    protected NoNetworkView fIy;
    private RelativeLayout fIz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.bbV = (NavigationBar) findViewById(d.h.navigation_bar);
        this.eww = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.bbV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bhg()) {
            this.fIy = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bhg()) {
        }
        this.fIz = new RelativeLayout(getPageContext().getContext());
        this.fIz.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eww.addView(this.fIz, 0, layoutParams);
    }

    protected boolean bhg() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bhg()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fIz = new RelativeLayout(getPageContext().getContext());
        this.fIz.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eww.addView(this.fIz, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bbV.onChangeSkinType(getPageContext(), i);
        if (this.fIy != null) {
            this.fIy.onChangeSkinType(getPageContext(), i);
        }
        if (this.aHz != null) {
            this.aHz.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eww);
    }
}
