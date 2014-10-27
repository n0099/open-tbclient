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
    private HeadImageView aBM;
    private TextView avZ;
    private TextView bGM;
    private TextView bGN;
    private TextView bGO;
    private TextView bGP;
    private ConfigInfos.PluginConfig bGQ;
    private boolean bGR;
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
        this.aBM = (HeadImageView) findViewById(v.icon);
        this.avZ = (TextView) findViewById(v.name);
        this.bGM = (TextView) findViewById(v.status);
        this.bGN = (TextView) findViewById(v.changelog);
        this.bGO = (TextView) findViewById(v.size);
        this.bGP = (TextView) findViewById(v.enable);
        this.bGP.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        this.bGQ = PluginCenter.getInstance().getNetConfigInfo(this.mPluginName);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.bGQ != null) {
            this.aBM.c(this.bGQ.icon, 10, false);
            this.avZ.setText(this.bGQ.description);
            abh();
            this.bGN.setText(this.bGQ.newest.changelog);
            this.bGO.setText(String.valueOf(getString(y.plugin_size)) + String.valueOf(this.bGQ.newest.size / 1024) + "KB");
            this.bGP.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abh() {
        if (PluginCenter.getInstance().hasUpdate(this.mPluginName)) {
            this.bGM.setText(y.plugin_enabled);
            this.bGP.setText(y.plugin_update);
            this.bGP.setEnabled(true);
            aw.b(this.bGP, s.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginCenter.getInstance().checkPluginInstalled(this.mPluginName)) {
            this.bGP.setEnabled(true);
            aw.b(this.bGP, s.cp_cont_g, 1);
            boolean isEnabled = PluginCenter.getInstance().isEnabled(this.mPluginName);
            if (!isEnabled) {
                this.bGM.setText(y.plugin_unenabled);
                this.bGP.setText(y.plugin_enable);
                this.mStatus = 2;
            } else if (isEnabled) {
                this.bGM.setText(y.plugin_enabled);
                this.bGP.setText(y.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bGM.setText(y.plugin_disabled);
            this.bGP.setText(y.plugin_enable);
            this.bGP.setEnabled(true);
            aw.b(this.bGP, s.cp_cont_g, 1);
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
        if (view == this.bGP) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                abi();
            } else if (this.mStatus == 3) {
                PluginCenter.getInstance().setEnabled(this.mPluginName, true);
                abh();
            } else if (this.mStatus == 2) {
                PluginCenter.getInstance().setEnabled(this.mPluginName, false);
                abh();
            }
        }
    }

    private void abi() {
        if (!com.baidu.adp.lib.util.j.fh()) {
            showToast(y.neterror);
            return;
        }
        aw.b(this.bGP, s.cp_cont_d, 1);
        this.bGP.setEnabled(false);
        PluginCenter.getInstance().startDownloadForeground(this.bGQ, new d(this));
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
