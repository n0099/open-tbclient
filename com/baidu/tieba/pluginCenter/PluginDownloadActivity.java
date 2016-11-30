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
    private boolean cSA;
    private PluginNetConfigInfos.PluginConfig fgS;
    private a fgU;
    private boolean fgV;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fgS = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fgS == null) {
            showToast(getPageContext().getString(r.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fgU = new a(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.fgU.setCancelable(false);
        this.fgU.setOnKeyListener(new j(this));
        this.fgU.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.fgU, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.fgU.findViewById(r.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aPu;
        private TextView aWk;
        private TextView dTO;
        private TextView dtr;
        private LinearLayout fgX;
        private TextView fgY;
        private TextView fgZ;
        private TextView fha;
        private TextView fhb;
        private TextView fhc;
        private TextView fhd;
        private TextView fhe;

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
            this.fgX = (LinearLayout) findViewById(r.g.down_dialog);
            this.fhd = (TextView) findViewById(r.g.update_tip);
            this.fgY = (TextView) findViewById(r.g.newversion);
            this.dtr = (TextView) findViewById(r.g.desc);
            this.fgZ = (TextView) findViewById(r.g.update_button);
            this.fgZ.setText(PluginDownloadActivity.this.getPageContext().getString(r.j.plugin_download_immediately));
            this.aWk = (TextView) findViewById(r.g.update_cancel);
            this.dTO = (TextView) findViewById(r.g.downloading);
            this.fhe = (TextView) findViewById(r.g.otherApp);
            this.fhe.setVisibility(8);
            this.fha = (TextView) findViewById(r.g.app_size);
            this.aPu = (LinearLayout) findViewById(r.g.cancel_dialog);
            this.fhb = (TextView) findViewById(r.g.sure_cancel);
            this.fhc = (TextView) findViewById(r.g.cancel_button);
            this.fhb.setOnClickListener(new l(this));
            this.fhc.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fgS.display_name)) {
                this.fhd.setText(PluginDownloadActivity.this.fgS.display_name);
            } else {
                this.fhd.setText("");
            }
            if (PluginDownloadActivity.this.fgS.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fgS.newest.version)) {
                    this.fgY.setText("版本：" + PluginDownloadActivity.this.fgS.newest.version);
                } else {
                    this.fgY.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fgS.newest.change_log)) {
                    this.dtr.setText(PluginDownloadActivity.this.fgS.newest.change_log);
                } else {
                    this.dtr.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fgS.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fha.setVisibility(0);
                    this.fha.setText(((Object) this.fha.getText()) + valueOf + "KB");
                } else {
                    this.fha.setVisibility(8);
                }
            } else {
                this.fgY.setText("");
                this.dtr.setText("");
                this.fha.setText("");
            }
            this.fgZ.setOnClickListener(new n(this));
            this.aWk.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fgS != null) {
            PluginPackageManager.iB().bs(this.fgS.package_name);
        }
        super.onDestroy();
    }
}
