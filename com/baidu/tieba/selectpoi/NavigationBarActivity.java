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
import com.baidu.tbadk.core.view.j;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected j aIo;
    protected NavigationBar baz;
    private RelativeLayout eCy;
    protected NoNetworkView fLj;
    private RelativeLayout fLk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.j.nevigationbar_layout);
        this.baz = (NavigationBar) findViewById(d.h.navigation_bar);
        this.eCy = (RelativeLayout) findViewById(d.h.navigation_bar_root);
        this.baz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (biz()) {
            this.fLj = (NoNetworkView) ((ViewStub) findViewById(d.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (biz()) {
        }
        this.fLk = new RelativeLayout(getPageContext().getContext());
        this.fLk.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eCy.addView(this.fLk, 0, layoutParams);
    }

    protected boolean biz() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (biz()) {
            layoutParams.addRule(3, d.h.no_network_view);
        } else {
            layoutParams.addRule(3, d.h.no_network_viewstub);
        }
        this.fLk = new RelativeLayout(getPageContext().getContext());
        this.fLk.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eCy.addView(this.fLk, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.baz.onChangeSkinType(getPageContext(), i);
        if (this.fLj != null) {
            this.fLj.onChangeSkinType(getPageContext(), i);
        }
        if (this.aIo != null) {
            this.aIo.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eCy);
    }
}
