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
    private boolean cGG;
    private a fcB;
    private boolean fcC;
    private PluginNetConfigInfos.PluginConfig fcz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fcz = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fcz == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fcB = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.fcB.setCancelable(false);
        this.fcB.setOnKeyListener(new j(this));
        this.fcB.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.fcB, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fcB.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Dialog {
        private LinearLayout aRP;
        private TextView aVB;
        private TextView dIP;
        private TextView dif;
        private LinearLayout fcE;
        private TextView fcF;
        private TextView fcG;
        private TextView fcH;
        private TextView fcI;
        private TextView fcJ;
        private TextView fcK;
        private TextView fcL;

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
            this.fcE = (LinearLayout) findViewById(w.h.down_dialog);
            this.fcK = (TextView) findViewById(w.h.update_tip);
            this.fcF = (TextView) findViewById(w.h.newversion);
            this.dif = (TextView) findViewById(w.h.desc);
            this.fcG = (TextView) findViewById(w.h.update_button);
            this.fcG.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aVB = (TextView) findViewById(w.h.update_cancel);
            this.dIP = (TextView) findViewById(w.h.downloading);
            this.fcL = (TextView) findViewById(w.h.otherApp);
            this.fcL.setVisibility(8);
            this.fcH = (TextView) findViewById(w.h.app_size);
            this.aRP = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.fcI = (TextView) findViewById(w.h.sure_cancel);
            this.fcJ = (TextView) findViewById(w.h.cancel_button);
            this.fcI.setOnClickListener(new l(this));
            this.fcJ.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fcz.display_name)) {
                this.fcK.setText(PluginDownloadActivity.this.fcz.display_name);
            } else {
                this.fcK.setText("");
            }
            if (PluginDownloadActivity.this.fcz.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fcz.newest.version)) {
                    this.fcF.setText("版本：" + PluginDownloadActivity.this.fcz.newest.version);
                } else {
                    this.fcF.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fcz.newest.change_log)) {
                    this.dif.setText(PluginDownloadActivity.this.fcz.newest.change_log);
                } else {
                    this.dif.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fcz.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fcH.setVisibility(0);
                    this.fcH.setText(((Object) this.fcH.getText()) + valueOf + "KB");
                } else {
                    this.fcH.setVisibility(8);
                }
            } else {
                this.fcF.setText("");
                this.dif.setText("");
                this.fcH.setText("");
            }
            this.fcG.setOnClickListener(new n(this));
            this.aVB.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fcz != null) {
            PluginPackageManager.jx().bg(this.fcz.package_name);
        }
        super.onDestroy();
    }
}
