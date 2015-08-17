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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig coh;
    private boolean coi;
    private a cok;
    private boolean col;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.coh = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.coh == null) {
            showToast(getPageContext().getString(i.C0057i.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.cok = new a(getPageContext().getPageActivity(), i.j.common_alert_dialog);
        this.cok.setCancelable(false);
        this.cok.setOnKeyListener(new i(this));
        this.cok.setOnDismissListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.cok, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.cok.findViewById(i.f.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aCW;
        private TextView aGK;
        private TextView aWb;
        private LinearLayout con;
        private TextView coo;
        private TextView cop;
        private TextView coq;
        private TextView cor;
        private TextView cos;
        private TextView cot;
        private TextView cou;
        private TextView cov;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(i.g.update_dialog);
            findViewById(i.f.warning).setVisibility(8);
            findViewById(i.f.incremental_button).setVisibility(8);
            findViewById(i.f.incremental_size).setVisibility(8);
            this.con = (LinearLayout) findViewById(i.f.down_dialog);
            this.cou = (TextView) findViewById(i.f.update_tip);
            this.coo = (TextView) findViewById(i.f.newversion);
            this.aWb = (TextView) findViewById(i.f.desc);
            this.cop = (TextView) findViewById(i.f.update_button);
            this.cop.setText(PluginDownloadActivity.this.getPageContext().getString(i.C0057i.plugin_download_immediately));
            this.aGK = (TextView) findViewById(i.f.update_cancel);
            this.coq = (TextView) findViewById(i.f.downloading);
            this.cov = (TextView) findViewById(i.f.otherApp);
            this.cov.setVisibility(8);
            this.cor = (TextView) findViewById(i.f.app_size);
            this.aCW = (LinearLayout) findViewById(i.f.cancel_dialog);
            this.cos = (TextView) findViewById(i.f.sure_cancel);
            this.cot = (TextView) findViewById(i.f.cancel_button);
            this.cos.setOnClickListener(new k(this));
            this.cot.setOnClickListener(new l(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.coh.display_name)) {
                this.cou.setText(PluginDownloadActivity.this.coh.display_name);
            } else {
                this.cou.setText("");
            }
            if (PluginDownloadActivity.this.coh.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.coh.newest.version)) {
                    this.coo.setText("版本：" + PluginDownloadActivity.this.coh.newest.version);
                } else {
                    this.coo.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.coh.newest.change_log)) {
                    this.aWb.setText(PluginDownloadActivity.this.coh.newest.change_log);
                } else {
                    this.aWb.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.coh.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.cor.setVisibility(0);
                    this.cor.setText(((Object) this.cor.getText()) + valueOf + "KB");
                } else {
                    this.cor.setVisibility(8);
                }
            } else {
                this.coo.setText("");
                this.aWb.setText("");
                this.cor.setText("");
            }
            this.cop.setOnClickListener(new m(this));
            this.aGK.setOnClickListener(new o(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.coh != null) {
            PluginPackageManager.lT().bt(this.coh.package_name);
        }
        super.onDestroy();
    }
}
