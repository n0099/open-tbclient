package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar bEF;
    protected NoDataView bfL;
    private RelativeLayout ciR;
    protected NoNetworkView gYt;
    private RelativeLayout gYu;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(e.h.nevigationbar_layout);
        this.bEF = (NavigationBar) findViewById(e.g.navigation_bar);
        this.ciR = (RelativeLayout) findViewById(e.g.navigation_bar_root);
        this.bEF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (bxz()) {
            this.gYt = (NoNetworkView) ((ViewStub) findViewById(e.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bxz()) {
        }
        this.gYu = new RelativeLayout(getPageContext().getContext());
        this.gYu.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.ciR.addView(this.gYu, 0, layoutParams);
    }

    protected boolean bxz() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bxz()) {
            layoutParams.addRule(3, e.g.no_network_view);
        } else {
            layoutParams.addRule(3, e.g.no_network_viewstub);
        }
        this.gYu = new RelativeLayout(getPageContext().getContext());
        this.gYu.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.ciR.addView(this.gYu, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bEF.onChangeSkinType(getPageContext(), i);
        if (this.gYt != null) {
            this.gYt.onChangeSkinType(getPageContext(), i);
        }
        if (this.bfL != null) {
            this.bfL.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ciR);
    }
}
