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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cNk;
    private boolean eZA;
    private PluginNetConfigInfos.PluginConfig eZx;
    private a eZz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eZx = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eZx == null) {
            showToast(getPageContext().getString(r.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eZz = new a(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.eZz.setCancelable(false);
        this.eZz.setOnKeyListener(new j(this));
        this.eZz.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.eZz, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.eZz.findViewById(r.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aNo;
        private TextView aTZ;
        private TextView dOj;
        private TextView dnI;
        private LinearLayout eZC;
        private TextView eZD;
        private TextView eZE;
        private TextView eZF;
        private TextView eZG;
        private TextView eZH;
        private TextView eZI;
        private TextView eZJ;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(r.h.update_dialog);
            findViewById(r.g.warning).setVisibility(8);
            findViewById(r.g.incremental_button).setVisibility(8);
            findViewById(r.g.incremental_size).setVisibility(8);
            this.eZC = (LinearLayout) findViewById(r.g.down_dialog);
            this.eZI = (TextView) findViewById(r.g.update_tip);
            this.eZD = (TextView) findViewById(r.g.newversion);
            this.dnI = (TextView) findViewById(r.g.desc);
            this.eZE = (TextView) findViewById(r.g.update_button);
            this.eZE.setText(PluginDownloadActivity.this.getPageContext().getString(r.j.plugin_download_immediately));
            this.aTZ = (TextView) findViewById(r.g.update_cancel);
            this.dOj = (TextView) findViewById(r.g.downloading);
            this.eZJ = (TextView) findViewById(r.g.otherApp);
            this.eZJ.setVisibility(8);
            this.eZF = (TextView) findViewById(r.g.app_size);
            this.aNo = (LinearLayout) findViewById(r.g.cancel_dialog);
            this.eZG = (TextView) findViewById(r.g.sure_cancel);
            this.eZH = (TextView) findViewById(r.g.cancel_button);
            this.eZG.setOnClickListener(new l(this));
            this.eZH.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eZx.display_name)) {
                this.eZI.setText(PluginDownloadActivity.this.eZx.display_name);
            } else {
                this.eZI.setText("");
            }
            if (PluginDownloadActivity.this.eZx.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eZx.newest.version)) {
                    this.eZD.setText("版本：" + PluginDownloadActivity.this.eZx.newest.version);
                } else {
                    this.eZD.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eZx.newest.change_log)) {
                    this.dnI.setText(PluginDownloadActivity.this.eZx.newest.change_log);
                } else {
                    this.dnI.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eZx.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eZF.setVisibility(0);
                    this.eZF.setText(((Object) this.eZF.getText()) + valueOf + "KB");
                } else {
                    this.eZF.setVisibility(8);
                }
            } else {
                this.eZD.setText("");
                this.dnI.setText("");
                this.eZF.setText("");
            }
            this.eZE.setOnClickListener(new n(this));
            this.aTZ.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eZx != null) {
            PluginPackageManager.iB().bs(this.eZx.package_name);
        }
        super.onDestroy();
    }
}
