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
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cEG;
    private PluginNetConfigInfos.PluginConfig eVn;
    private a eVp;
    private boolean eVq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eVn = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eVn == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eVp = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.eVp.setCancelable(false);
        this.eVp.setOnKeyListener(new j(this));
        this.eVp.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.eVp, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.eVp.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aTQ;
        private TextView aXA;
        private TextView dGE;
        private TextView dgq;
        private LinearLayout eVs;
        private TextView eVt;
        private TextView eVu;
        private TextView eVv;
        private TextView eVw;
        private TextView eVx;
        private TextView eVy;
        private TextView eVz;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(w.j.update_dialog);
            findViewById(w.h.warning).setVisibility(8);
            findViewById(w.h.incremental_button).setVisibility(8);
            findViewById(w.h.incremental_size).setVisibility(8);
            this.eVs = (LinearLayout) findViewById(w.h.down_dialog);
            this.eVy = (TextView) findViewById(w.h.update_tip);
            this.eVt = (TextView) findViewById(w.h.newversion);
            this.dgq = (TextView) findViewById(w.h.desc);
            this.eVu = (TextView) findViewById(w.h.update_button);
            this.eVu.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aXA = (TextView) findViewById(w.h.update_cancel);
            this.dGE = (TextView) findViewById(w.h.downloading);
            this.eVz = (TextView) findViewById(w.h.otherApp);
            this.eVz.setVisibility(8);
            this.eVv = (TextView) findViewById(w.h.app_size);
            this.aTQ = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.eVw = (TextView) findViewById(w.h.sure_cancel);
            this.eVx = (TextView) findViewById(w.h.cancel_button);
            this.eVw.setOnClickListener(new l(this));
            this.eVx.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eVn.display_name)) {
                this.eVy.setText(PluginDownloadActivity.this.eVn.display_name);
            } else {
                this.eVy.setText("");
            }
            if (PluginDownloadActivity.this.eVn.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eVn.newest.version)) {
                    this.eVt.setText("版本：" + PluginDownloadActivity.this.eVn.newest.version);
                } else {
                    this.eVt.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eVn.newest.change_log)) {
                    this.dgq.setText(PluginDownloadActivity.this.eVn.newest.change_log);
                } else {
                    this.dgq.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eVn.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eVv.setVisibility(0);
                    this.eVv.setText(((Object) this.eVv.getText()) + valueOf + "KB");
                } else {
                    this.eVv.setVisibility(8);
                }
            } else {
                this.eVt.setText("");
                this.dgq.setText("");
                this.eVv.setText("");
            }
            this.eVu.setOnClickListener(new n(this));
            this.aXA.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eVn != null) {
            PluginPackageManager.jx().bg(this.eVn.package_name);
        }
        super.onDestroy();
    }
}
