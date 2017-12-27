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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class NavigationBarActivity extends BaseActivity<NavigationBarActivity> {
    protected NavigationBar bTg;
    protected g bwN;
    private RelativeLayout fAm;
    protected NoNetworkView gSG;
    private RelativeLayout gSH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setContentView(d.h.nevigationbar_layout);
        this.bTg = (NavigationBar) findViewById(d.g.navigation_bar);
        this.fAm = (RelativeLayout) findViewById(d.g.navigation_bar_root);
        this.bTg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.selectpoi.NavigationBarActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NavigationBarActivity.this.finish();
            }
        });
        if (buS()) {
            this.gSG = (NoNetworkView) ((ViewStub) findViewById(d.g.no_network_viewstub)).inflate();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (buS()) {
        }
        this.gSH = new RelativeLayout(getPageContext().getContext());
        this.gSH.addView(view, new ViewGroup.LayoutParams(-1, -1));
        this.fAm.addView(this.gSH, 0, layoutParams);
    }

    protected boolean buS() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void setContentView(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (buS()) {
            layoutParams.addRule(3, d.g.no_network_view);
        } else {
            layoutParams.addRule(3, d.g.no_network_viewstub);
        }
        this.gSH = new RelativeLayout(getPageContext().getContext());
        this.gSH.addView(LayoutInflater.from(getPageContext().getContext()).inflate(i, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -1));
        this.fAm.addView(this.gSH, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bTg.onChangeSkinType(getPageContext(), i);
        if (this.gSG != null) {
            this.gSG.onChangeSkinType(getPageContext(), i);
        }
        if (this.bwN != null) {
            this.bwN.onChangeSkinType(getPageContext(), i);
        }
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.fAm);
    }
}
