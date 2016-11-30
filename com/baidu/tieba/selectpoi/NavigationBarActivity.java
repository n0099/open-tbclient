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
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected w aBi;
    protected NavigationBar aXB;
    private RelativeLayout eqs;
    protected NoNetworkView fnn;
    private RelativeLayout fno;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(r.h.nevigationbar_layout);
        this.aXB = (NavigationBar) findViewById(r.g.navigation_bar);
        this.eqs = (RelativeLayout) findViewById(r.g.navigation_bar_root);
        this.aXB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        if (bfh()) {
            this.fnn = (NoNetworkView) ((ViewStub) findViewById(r.g.no_network_viewstub)).inflate();
        }
    }

    protected void a(NoDataViewFactory.c cVar, NoDataViewFactory.d dVar, NoDataViewFactory.b bVar) {
        if (this.aBi == null) {
            this.aBi = NoDataViewFactory.a(getPageContext().getContext(), this.eqs, cVar, dVar, bVar);
        }
        this.aBi.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aBi.setVisibility(0);
    }

    protected void hideNoDataView() {
        if (this.aBi != null) {
            this.aBi.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        bfh();
        this.fno = new RelativeLayout(getPageContext().getContext());
        this.fno.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.eqs.addView(this.fno, 0, layoutParams);
    }

    protected boolean bfh() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (bfh()) {
            layoutParams.addRule(3, r.g.no_network_view);
        } else {
            layoutParams.addRule(3, r.g.no_network_viewstub);
        }
        this.fno = new RelativeLayout(getPageContext().getContext());
        this.fno.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.eqs.addView(this.fno, layoutParams);
    }

    protected View adg() {
        return this.fno;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aXB.onChangeSkinType(getPageContext(), i);
        if (this.fnn != null) {
            this.fnn.onChangeSkinType(getPageContext(), i);
        }
        if (this.aBi != null) {
            this.aBi.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.eqs);
    }
}
