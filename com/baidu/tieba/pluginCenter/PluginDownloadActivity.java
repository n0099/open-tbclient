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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean bFR;
    private PluginNetConfigInfos.PluginConfig dji;
    private a djk;
    private boolean djl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dji = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.dji == null) {
            showToast(getPageContext().getString(n.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.djk = new a(getPageContext().getPageActivity(), n.k.common_alert_dialog);
        this.djk.setCancelable(false);
        this.djk.setOnKeyListener(new j(this));
        this.djk.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.djk, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.djk.findViewById(n.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aHl;
        private TextView aJs;
        private TextView bfz;
        private LinearLayout djn;
        private TextView djo;
        private TextView djp;
        private TextView djq;
        private TextView djr;
        private TextView djs;
        private TextView djt;
        private TextView dju;
        private TextView djv;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(n.h.update_dialog);
            findViewById(n.g.warning).setVisibility(8);
            findViewById(n.g.incremental_button).setVisibility(8);
            findViewById(n.g.incremental_size).setVisibility(8);
            this.djn = (LinearLayout) findViewById(n.g.down_dialog);
            this.dju = (TextView) findViewById(n.g.update_tip);
            this.djo = (TextView) findViewById(n.g.newversion);
            this.bfz = (TextView) findViewById(n.g.desc);
            this.djp = (TextView) findViewById(n.g.update_button);
            this.djp.setText(PluginDownloadActivity.this.getPageContext().getString(n.j.plugin_download_immediately));
            this.aJs = (TextView) findViewById(n.g.update_cancel);
            this.djq = (TextView) findViewById(n.g.downloading);
            this.djv = (TextView) findViewById(n.g.otherApp);
            this.djv.setVisibility(8);
            this.djr = (TextView) findViewById(n.g.app_size);
            this.aHl = (LinearLayout) findViewById(n.g.cancel_dialog);
            this.djs = (TextView) findViewById(n.g.sure_cancel);
            this.djt = (TextView) findViewById(n.g.cancel_button);
            this.djs.setOnClickListener(new l(this));
            this.djt.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.dji.display_name)) {
                this.dju.setText(PluginDownloadActivity.this.dji.display_name);
            } else {
                this.dju.setText("");
            }
            if (PluginDownloadActivity.this.dji.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dji.newest.version)) {
                    this.djo.setText("版本：" + PluginDownloadActivity.this.dji.newest.version);
                } else {
                    this.djo.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dji.newest.change_log)) {
                    this.bfz.setText(PluginDownloadActivity.this.dji.newest.change_log);
                } else {
                    this.bfz.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.dji.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.djr.setVisibility(0);
                    this.djr.setText(((Object) this.djr.getText()) + valueOf + "KB");
                } else {
                    this.djr.setVisibility(8);
                }
            } else {
                this.djo.setText("");
                this.bfz.setText("");
                this.djr.setText("");
            }
            this.djp.setOnClickListener(new n(this));
            this.aJs.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dji != null) {
            PluginPackageManager.ls().bz(this.dji.package_name);
        }
        super.onDestroy();
    }
}
