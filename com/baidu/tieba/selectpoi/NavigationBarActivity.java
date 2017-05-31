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
    protected y aEX;
    protected NavigationBar aWS;
    private RelativeLayout egQ;
    protected NoNetworkView fmG;
    private RelativeLayout fmH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(w.j.nevigationbar_layout);
        this.aWS = (NavigationBar) findViewById(w.h.navigation_bar);
        this.egQ = (RelativeLayout) findViewById(w.h.navigation_bar_root);
        this.aWS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (baZ()) {
            this.fmG = (NoNetworkView) ((ViewStub) findViewById(w.h.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baZ();
        this.fmH = new RelativeLayout(getPageContext().getContext());
        this.fmH.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.egQ.addView(this.fmH, 0, layoutParams);
    }

    protected boolean baZ() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (baZ()) {
            layoutParams.addRule(3, w.h.no_network_view);
        } else {
            layoutParams.addRule(3, w.h.no_network_viewstub);
        }
        this.fmH = new RelativeLayout(getPageContext().getContext());
        this.fmH.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.egQ.addView(this.fmH, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aWS.onChangeSkinType(getPageContext(), i);
        if (this.fmG != null) {
            this.fmG.onChangeSkinType(getPageContext(), i);
        }
        if (this.aEX != null) {
            this.aEX.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.egQ);
    }
}
