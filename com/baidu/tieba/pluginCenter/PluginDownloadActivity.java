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
    private boolean cOC;
    private PluginNetConfigInfos.PluginConfig fmP;
    private a fmR;
    private boolean fmS;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fmP = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fmP == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fmR = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.fmR.setCancelable(false);
        this.fmR.setOnKeyListener(new j(this));
        this.fmR.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.fmR, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fmR.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Dialog {
        private LinearLayout aTi;
        private TextView aWU;
        private TextView dRo;
        private TextView dqb;
        private LinearLayout fmU;
        private TextView fmV;
        private TextView fmW;
        private TextView fmX;
        private TextView fmY;
        private TextView fmZ;
        private TextView fna;
        private TextView fnb;

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
            this.fmU = (LinearLayout) findViewById(w.h.down_dialog);
            this.fna = (TextView) findViewById(w.h.update_tip);
            this.fmV = (TextView) findViewById(w.h.newversion);
            this.dqb = (TextView) findViewById(w.h.desc);
            this.fmW = (TextView) findViewById(w.h.update_button);
            this.fmW.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aWU = (TextView) findViewById(w.h.update_cancel);
            this.dRo = (TextView) findViewById(w.h.downloading);
            this.fnb = (TextView) findViewById(w.h.otherApp);
            this.fnb.setVisibility(8);
            this.fmX = (TextView) findViewById(w.h.app_size);
            this.aTi = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.fmY = (TextView) findViewById(w.h.sure_cancel);
            this.fmZ = (TextView) findViewById(w.h.cancel_button);
            this.fmY.setOnClickListener(new l(this));
            this.fmZ.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fmP.display_name)) {
                this.fna.setText(PluginDownloadActivity.this.fmP.display_name);
            } else {
                this.fna.setText("");
            }
            if (PluginDownloadActivity.this.fmP.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fmP.newest.version)) {
                    this.fmV.setText("版本：" + PluginDownloadActivity.this.fmP.newest.version);
                } else {
                    this.fmV.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fmP.newest.change_log)) {
                    this.dqb.setText(PluginDownloadActivity.this.fmP.newest.change_log);
                } else {
                    this.dqb.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fmP.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fmX.setVisibility(0);
                    this.fmX.setText(((Object) this.fmX.getText()) + valueOf + "KB");
                } else {
                    this.fmX.setVisibility(8);
                }
            } else {
                this.fmV.setText("");
                this.dqb.setText("");
                this.fmX.setText("");
            }
            this.fmW.setOnClickListener(new n(this));
            this.aWU.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.fmP != null) {
            PluginPackageManager.jw().bl(this.fmP.package_name);
        }
        super.onDestroy();
    }
}
