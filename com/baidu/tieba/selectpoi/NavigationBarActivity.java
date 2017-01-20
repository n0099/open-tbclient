package com.baidu.tieba.selectpoi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.x;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar aSs;
    protected x azv;
    private RelativeLayout edS;
    protected NoNetworkView faD;
    private RelativeLayout faE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(r.j.nevigationbar_layout);
        this.aSs = (NavigationBar) findViewById(r.h.navigation_bar);
        this.edS = (RelativeLayout) findViewById(r.h.navigation_bar_root);
        this.aSs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (baL()) {
            this.faD = (NoNetworkView) ((ViewStub) findViewById(r.h.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.azv == null) {
            this.azv = NoDataViewFactory.a(getPageContext().getContext(), this.edS, cVar, dVar, bVar);
        }
        this.azv.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.azv.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.azv != null) {
            this.azv.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        baL();
        this.faE = new RelativeLayout(getPageContext().getContext());
        this.faE.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.edS.addView(this.faE, 0, layoutParams);
    }

    protected boolean baL() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (baL()) {
            layoutParams.addRule(3, r.h.no_network_view);
        } else {
            layoutParams.addRule(3, r.h.no_network_viewstub);
        }
        this.faE = new RelativeLayout(getPageContext().getContext());
        this.faE.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.edS.addView(this.faE, layoutParams);
    }

    protected View YJ() {
        return this.faE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aSs.onChangeSkinType(getPageContext(), i);
        if (this.faD != null) {
            this.faD.onChangeSkinType(getPageContext(), i);
        }
        if (this.azv != null) {
            this.azv.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.edS);
    }
}
