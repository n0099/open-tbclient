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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar bTv;
    protected h bxf;
    private RelativeLayout fCh;
    protected NoNetworkView gIk;
    private RelativeLayout gIl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bTv = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fCh = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bTv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bom()) {
            this.gIk = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bom()) {
        }
        this.gIl = new RelativeLayout(getPageContext().getContext());
        this.gIl.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.fCh.addView(this.gIl, 0, layoutParams);
    }

    protected boolean bom() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bom()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gIl = new RelativeLayout(getPageContext().getContext());
        this.gIl.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.fCh.addView(this.gIl, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bTv.onChangeSkinType(getPageContext(), i);
        if (this.gIk != null) {
            this.gIk.onChangeSkinType(getPageContext(), i);
        }
        if (this.bxf != null) {
            this.bxf.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.fCh);
    }
}
