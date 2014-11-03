package com.baidu.tieba.plugins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PluginDetailActivity extends BaseActivity {
    private HeadImageView aBW;
    private TextView awi;
    private TextView bHa;
    private TextView bHb;
    private TextView bHc;
    private TextView bHd;
    private ConfigInfos.PluginConfig bHe;
    private boolean bHf;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PluginDetailActivityConfig.class, PluginDetailActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, PluginDetailActivity.class);
        intent.putExtra("name", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(v.navigation_bar);
        this.mNavigationBar.setTitleText(y.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
        this.aBW = (HeadImageView) findViewById(v.icon);
        this.awi = (TextView) findViewById(v.name);
        this.bHa = (TextView) findViewById(v.status);
        this.bHb = (TextView) findViewById(v.changelog);
        this.bHc = (TextView) findViewById(v.size);
        this.bHd = (TextView) findViewById(v.enable);
        this.bHd.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        this.bHe = PluginCenter.getInstance().getNetConfigInfo(this.mPluginName);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bHe != null) {
            this.aBW.c(this.bHe.icon, 10, false);
            this.awi.setText(this.bHe.description);
            abk();
            this.bHb.setText(this.bHe.newest.changelog);
            this.bHc.setText(String.valueOf(getString(y.plugin_size)) + String.valueOf(this.bHe.newest.size / 1024) + "KB");
            this.bHd.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        if (PluginCenter.getInstance().hasUpdate(this.mPluginName)) {
            this.bHa.setText(y.plugin_enabled);
            this.bHd.setText(y.plugin_update);
            this.bHd.setEnabled(true);
            aw.b(this.bHd, s.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginCenter.getInstance().checkPluginInstalled(this.mPluginName)) {
            this.bHd.setEnabled(true);
            aw.b(this.bHd, s.cp_cont_g, 1);
            boolean isEnabled = PluginCenter.getInstance().isEnabled(this.mPluginName);
            if (!isEnabled) {
                this.bHa.setText(y.plugin_unenabled);
                this.bHd.setText(y.plugin_enable);
                this.mStatus = 2;
            } else if (isEnabled) {
                this.bHa.setText(y.plugin_enabled);
                this.bHd.setText(y.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bHa.setText(y.plugin_disabled);
            this.bHd.setText(y.plugin_enable);
            this.bHd.setEnabled(true);
            aw.b(this.bHd, s.cp_cont_g, 1);
            this.mStatus = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bHd) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                abl();
            } else if (this.mStatus == 3) {
                PluginCenter.getInstance().setEnabled(this.mPluginName, true);
                abk();
            } else if (this.mStatus == 2) {
                PluginCenter.getInstance().setEnabled(this.mPluginName, false);
                abk();
            }
        }
    }

    private void abl() {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
            return;
        }
        aw.b(this.bHd, s.cp_cont_d, 1);
        this.bHd.setEnabled(false);
        PluginCenter.getInstance().startDownloadForeground(this.bHe, new d(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
