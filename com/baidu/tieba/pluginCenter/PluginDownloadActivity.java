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
    private boolean cGX;
    private PluginNetConfigInfos.PluginConfig eXE;
    private a eXG;
    private boolean eXH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXE = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eXE == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eXG = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.eXG.setCancelable(false);
        this.eXG.setOnKeyListener(new j(this));
        this.eXG.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.eXG, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aj(i == 1);
        getLayoutMode().t(this.eXG.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aTS;
        private TextView aXD;
        private TextView dIU;
        private TextView diH;
        private LinearLayout eXJ;
        private TextView eXK;
        private TextView eXL;
        private TextView eXM;
        private TextView eXN;
        private TextView eXO;
        private TextView eXP;
        private TextView eXQ;

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
            this.eXJ = (LinearLayout) findViewById(w.h.down_dialog);
            this.eXP = (TextView) findViewById(w.h.update_tip);
            this.eXK = (TextView) findViewById(w.h.newversion);
            this.diH = (TextView) findViewById(w.h.desc);
            this.eXL = (TextView) findViewById(w.h.update_button);
            this.eXL.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aXD = (TextView) findViewById(w.h.update_cancel);
            this.dIU = (TextView) findViewById(w.h.downloading);
            this.eXQ = (TextView) findViewById(w.h.otherApp);
            this.eXQ.setVisibility(8);
            this.eXM = (TextView) findViewById(w.h.app_size);
            this.aTS = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.eXN = (TextView) findViewById(w.h.sure_cancel);
            this.eXO = (TextView) findViewById(w.h.cancel_button);
            this.eXN.setOnClickListener(new l(this));
            this.eXO.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXE.display_name)) {
                this.eXP.setText(PluginDownloadActivity.this.eXE.display_name);
            } else {
                this.eXP.setText("");
            }
            if (PluginDownloadActivity.this.eXE.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXE.newest.version)) {
                    this.eXK.setText("版本：" + PluginDownloadActivity.this.eXE.newest.version);
                } else {
                    this.eXK.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXE.newest.change_log)) {
                    this.diH.setText(PluginDownloadActivity.this.eXE.newest.change_log);
                } else {
                    this.diH.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eXE.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eXM.setVisibility(0);
                    this.eXM.setText(((Object) this.eXM.getText()) + valueOf + "KB");
                } else {
                    this.eXM.setVisibility(8);
                }
            } else {
                this.eXK.setText("");
                this.diH.setText("");
                this.eXM.setText("");
            }
            this.eXL.setOnClickListener(new n(this));
            this.aXD.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eXE != null) {
            PluginPackageManager.jy().bg(this.eXE.package_name);
        }
        super.onDestroy();
    }
}
