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
    private boolean cxH;
    private PluginNetConfigInfos.PluginConfig eKl;
    private a eKn;
    private boolean eKo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eKl = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eKl == null) {
            showToast(getPageContext().getString(r.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eKn = new a(getPageContext().getPageActivity(), r.k.common_alert_dialog);
        this.eKn.setCancelable(false);
        this.eKn.setOnKeyListener(new j(this));
        this.eKn.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.eKn, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().x(this.eKn.findViewById(r.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aOL;
        private TextView aVB;
        private TextView cYl;
        private TextView dyq;
        private LinearLayout eKq;
        private TextView eKr;
        private TextView eKs;
        private TextView eKt;
        private TextView eKu;
        private TextView eKv;
        private TextView eKw;
        private TextView eKx;

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
            this.eKq = (LinearLayout) findViewById(r.g.down_dialog);
            this.eKw = (TextView) findViewById(r.g.update_tip);
            this.eKr = (TextView) findViewById(r.g.newversion);
            this.cYl = (TextView) findViewById(r.g.desc);
            this.eKs = (TextView) findViewById(r.g.update_button);
            this.eKs.setText(PluginDownloadActivity.this.getPageContext().getString(r.j.plugin_download_immediately));
            this.aVB = (TextView) findViewById(r.g.update_cancel);
            this.dyq = (TextView) findViewById(r.g.downloading);
            this.eKx = (TextView) findViewById(r.g.otherApp);
            this.eKx.setVisibility(8);
            this.eKt = (TextView) findViewById(r.g.app_size);
            this.aOL = (LinearLayout) findViewById(r.g.cancel_dialog);
            this.eKu = (TextView) findViewById(r.g.sure_cancel);
            this.eKv = (TextView) findViewById(r.g.cancel_button);
            this.eKu.setOnClickListener(new l(this));
            this.eKv.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eKl.display_name)) {
                this.eKw.setText(PluginDownloadActivity.this.eKl.display_name);
            } else {
                this.eKw.setText("");
            }
            if (PluginDownloadActivity.this.eKl.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eKl.newest.version)) {
                    this.eKr.setText("版本：" + PluginDownloadActivity.this.eKl.newest.version);
                } else {
                    this.eKr.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eKl.newest.change_log)) {
                    this.cYl.setText(PluginDownloadActivity.this.eKl.newest.change_log);
                } else {
                    this.cYl.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eKl.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eKt.setVisibility(0);
                    this.eKt.setText(((Object) this.eKt.getText()) + valueOf + "KB");
                } else {
                    this.eKt.setVisibility(8);
                }
            } else {
                this.eKr.setText("");
                this.cYl.setText("");
                this.eKt.setText("");
            }
            this.eKs.setOnClickListener(new n(this));
            this.aVB.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eKl != null) {
            PluginPackageManager.iB().bs(this.eKl.package_name);
        }
        super.onDestroy();
    }
}
