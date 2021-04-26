package com.baidu.tieba.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import d.a.j0.m1.e;
import d.a.j0.m1.f;
import d.a.j0.q1.a;
/* loaded from: classes5.dex */
public class NpsPluginLoadingDialogActivity extends BaseActivity implements View.OnClickListener {
    public TextView mCancel;
    public long mDialogId;
    public PluginRoundProgressBar mRoundProgressBar;
    public boolean showHideView;

    private void hideDialog() {
        a.j().n();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public long getDialogId() {
        return this.mDialogId;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        hideDialog();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.loading_cancel_text) {
            finish();
            hideDialog();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        overridePendingTransition(0, 0);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        setContentView(f.widget_loading_plugin);
        Intent intent = getIntent();
        this.showHideView = intent.getBooleanExtra("showHideView", false);
        this.mDialogId = intent.getLongExtra("dialogId", -1L);
        PluginRoundProgressBar pluginRoundProgressBar = (PluginRoundProgressBar) findViewById(e.progress_bar);
        this.mRoundProgressBar = pluginRoundProgressBar;
        pluginRoundProgressBar.setMax(100);
        this.mRoundProgressBar.setRoundColor(0);
        this.mRoundProgressBar.setTextColor(-1);
        this.mRoundProgressBar.setRoundProgressColor(-1);
        TextView textView = (TextView) findViewById(e.loading_cancel_text);
        this.mCancel = textView;
        if (this.showHideView) {
            textView.setVisibility(8);
        }
        this.mCancel.setOnClickListener(this);
        if (!a.j().m()) {
            finish();
        } else {
            a.j().o(this);
        }
    }

    public void setRoundProgress(int i2) {
        PluginRoundProgressBar pluginRoundProgressBar = this.mRoundProgressBar;
        if (pluginRoundProgressBar == null || pluginRoundProgressBar.getProgress() == i2) {
            return;
        }
        this.mRoundProgressBar.setProgress(i2);
    }
}
