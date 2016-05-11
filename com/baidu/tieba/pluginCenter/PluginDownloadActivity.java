package com.baidu.tieba.pluginCenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean bTZ;
    private PluginNetConfigInfos.PluginConfig dUB;
    private a dUD;
    private boolean dUE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dUB = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.dUB == null) {
            showToast(getPageContext().getString(t.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.dUD = new a(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.dUD.setCancelable(false);
        this.dUD.setOnKeyListener(new j(this));
        this.dUD.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.dUD, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.dUD.findViewById(t.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aHu;
        private TextView aJD;
        private TextView biq;
        private TextView cRq;
        private LinearLayout dUG;
        private TextView dUH;
        private TextView dUI;
        private TextView dUJ;
        private TextView dUK;
        private TextView dUL;
        private TextView dUM;
        private TextView dUN;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(t.h.update_dialog);
            findViewById(t.g.warning).setVisibility(8);
            findViewById(t.g.incremental_button).setVisibility(8);
            findViewById(t.g.incremental_size).setVisibility(8);
            this.dUG = (LinearLayout) findViewById(t.g.down_dialog);
            this.dUM = (TextView) findViewById(t.g.update_tip);
            this.dUH = (TextView) findViewById(t.g.newversion);
            this.biq = (TextView) findViewById(t.g.desc);
            this.dUI = (TextView) findViewById(t.g.update_button);
            this.dUI.setText(PluginDownloadActivity.this.getPageContext().getString(t.j.plugin_download_immediately));
            this.aJD = (TextView) findViewById(t.g.update_cancel);
            this.cRq = (TextView) findViewById(t.g.downloading);
            this.dUN = (TextView) findViewById(t.g.otherApp);
            this.dUN.setVisibility(8);
            this.dUJ = (TextView) findViewById(t.g.app_size);
            this.aHu = (LinearLayout) findViewById(t.g.cancel_dialog);
            this.dUK = (TextView) findViewById(t.g.sure_cancel);
            this.dUL = (TextView) findViewById(t.g.cancel_button);
            this.dUK.setOnClickListener(new l(this));
            this.dUL.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.dUB.display_name)) {
                this.dUM.setText(PluginDownloadActivity.this.dUB.display_name);
            } else {
                this.dUM.setText("");
            }
            if (PluginDownloadActivity.this.dUB.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dUB.newest.version)) {
                    this.dUH.setText("版本：" + PluginDownloadActivity.this.dUB.newest.version);
                } else {
                    this.dUH.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dUB.newest.change_log)) {
                    this.biq.setText(PluginDownloadActivity.this.dUB.newest.change_log);
                } else {
                    this.biq.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.dUB.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.dUJ.setVisibility(0);
                    this.dUJ.setText(((Object) this.dUJ.getText()) + valueOf + "KB");
                } else {
                    this.dUJ.setVisibility(8);
                }
            } else {
                this.dUH.setText("");
                this.biq.setText("");
                this.dUJ.setText("");
            }
            this.dUI.setOnClickListener(new n(this));
            this.aJD.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dUB != null) {
            PluginPackageManager.hF().bq(this.dUB.package_name);
        }
        super.onDestroy();
    }
}
