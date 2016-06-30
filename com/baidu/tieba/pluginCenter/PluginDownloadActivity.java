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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cxZ;
    private PluginNetConfigInfos.PluginConfig eDW;
    private a eDY;
    private boolean eDZ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eDW = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eDW == null) {
            showToast(getPageContext().getString(u.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eDY = new a(getPageContext().getPageActivity(), u.k.common_alert_dialog);
        this.eDY.setCancelable(false);
        this.eDY.setOnKeyListener(new j(this));
        this.eDY.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.eDY, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.eDY.findViewById(u.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aHW;
        private TextView aNb;
        private TextView bEd;
        private TextView dxa;
        private LinearLayout eEb;
        private TextView eEc;
        private TextView eEd;
        private TextView eEe;
        private TextView eEf;
        private TextView eEg;
        private TextView eEh;
        private TextView eEi;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(u.h.update_dialog);
            findViewById(u.g.warning).setVisibility(8);
            findViewById(u.g.incremental_button).setVisibility(8);
            findViewById(u.g.incremental_size).setVisibility(8);
            this.eEb = (LinearLayout) findViewById(u.g.down_dialog);
            this.eEh = (TextView) findViewById(u.g.update_tip);
            this.eEc = (TextView) findViewById(u.g.newversion);
            this.bEd = (TextView) findViewById(u.g.desc);
            this.eEd = (TextView) findViewById(u.g.update_button);
            this.eEd.setText(PluginDownloadActivity.this.getPageContext().getString(u.j.plugin_download_immediately));
            this.aNb = (TextView) findViewById(u.g.update_cancel);
            this.dxa = (TextView) findViewById(u.g.downloading);
            this.eEi = (TextView) findViewById(u.g.otherApp);
            this.eEi.setVisibility(8);
            this.eEe = (TextView) findViewById(u.g.app_size);
            this.aHW = (LinearLayout) findViewById(u.g.cancel_dialog);
            this.eEf = (TextView) findViewById(u.g.sure_cancel);
            this.eEg = (TextView) findViewById(u.g.cancel_button);
            this.eEf.setOnClickListener(new l(this));
            this.eEg.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eDW.display_name)) {
                this.eEh.setText(PluginDownloadActivity.this.eDW.display_name);
            } else {
                this.eEh.setText("");
            }
            if (PluginDownloadActivity.this.eDW.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eDW.newest.version)) {
                    this.eEc.setText("版本：" + PluginDownloadActivity.this.eDW.newest.version);
                } else {
                    this.eEc.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eDW.newest.change_log)) {
                    this.bEd.setText(PluginDownloadActivity.this.eDW.newest.change_log);
                } else {
                    this.bEd.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eDW.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eEe.setVisibility(0);
                    this.eEe.setText(((Object) this.eEe.getText()) + valueOf + "KB");
                } else {
                    this.eEe.setVisibility(8);
                }
            } else {
                this.eEc.setText("");
                this.bEd.setText("");
                this.eEe.setText("");
            }
            this.eEd.setOnClickListener(new n(this));
            this.aNb.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eDW != null) {
            PluginPackageManager.hH().bq(this.eDW.package_name);
        }
        super.onDestroy();
    }
}
