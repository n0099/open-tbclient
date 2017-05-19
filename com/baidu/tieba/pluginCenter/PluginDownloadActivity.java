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
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cBh;
    private PluginNetConfigInfos.PluginConfig eTE;
    private a eTG;
    private boolean eTH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTE = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eTE == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eTG = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.eTG.setCancelable(false);
        this.eTG.setOnKeyListener(new j(this));
        this.eTG.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.eTG, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.eTG.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Dialog {
        private LinearLayout aUn;
        private TextView aXZ;
        private TextView dDr;
        private TextView dcJ;
        private LinearLayout eTJ;
        private TextView eTK;
        private TextView eTL;
        private TextView eTM;
        private TextView eTN;
        private TextView eTO;
        private TextView eTP;
        private TextView eTQ;

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
            this.eTJ = (LinearLayout) findViewById(w.h.down_dialog);
            this.eTP = (TextView) findViewById(w.h.update_tip);
            this.eTK = (TextView) findViewById(w.h.newversion);
            this.dcJ = (TextView) findViewById(w.h.desc);
            this.eTL = (TextView) findViewById(w.h.update_button);
            this.eTL.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aXZ = (TextView) findViewById(w.h.update_cancel);
            this.dDr = (TextView) findViewById(w.h.downloading);
            this.eTQ = (TextView) findViewById(w.h.otherApp);
            this.eTQ.setVisibility(8);
            this.eTM = (TextView) findViewById(w.h.app_size);
            this.aUn = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.eTN = (TextView) findViewById(w.h.sure_cancel);
            this.eTO = (TextView) findViewById(w.h.cancel_button);
            this.eTN.setOnClickListener(new l(this));
            this.eTO.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTE.display_name)) {
                this.eTP.setText(PluginDownloadActivity.this.eTE.display_name);
            } else {
                this.eTP.setText("");
            }
            if (PluginDownloadActivity.this.eTE.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTE.newest.version)) {
                    this.eTK.setText("版本：" + PluginDownloadActivity.this.eTE.newest.version);
                } else {
                    this.eTK.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTE.newest.change_log)) {
                    this.dcJ.setText(PluginDownloadActivity.this.eTE.newest.change_log);
                } else {
                    this.dcJ.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eTE.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eTM.setVisibility(0);
                    this.eTM.setText(((Object) this.eTM.getText()) + valueOf + "KB");
                } else {
                    this.eTM.setVisibility(8);
                }
            } else {
                this.eTK.setText("");
                this.dcJ.setText("");
                this.eTM.setText("");
            }
            this.eTL.setOnClickListener(new n(this));
            this.aXZ.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eTE != null) {
            PluginPackageManager.jx().bg(this.eTE.package_name);
        }
        super.onDestroy();
    }
}
