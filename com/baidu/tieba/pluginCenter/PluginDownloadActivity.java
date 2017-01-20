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
    private boolean cEL;
    private PluginNetConfigInfos.PluginConfig eTI;
    private a eTK;
    private boolean eTL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eTI = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eTI == null) {
            showToast(getPageContext().getString(r.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eTK = new a(getPageContext().getPageActivity(), r.m.common_alert_dialog);
        this.eTK.setCancelable(false);
        this.eTK.setOnKeyListener(new j(this));
        this.eTK.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.eTK, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().v(this.eTK.findViewById(r.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aNO;
        private TextView aRb;
        private TextView dHy;
        private TextView dfA;
        private LinearLayout eTN;
        private TextView eTO;
        private TextView eTP;
        private TextView eTQ;
        private TextView eTR;
        private TextView eTS;
        private TextView eTT;
        private TextView eTU;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(r.j.update_dialog);
            findViewById(r.h.warning).setVisibility(8);
            findViewById(r.h.incremental_button).setVisibility(8);
            findViewById(r.h.incremental_size).setVisibility(8);
            this.eTN = (LinearLayout) findViewById(r.h.down_dialog);
            this.eTT = (TextView) findViewById(r.h.update_tip);
            this.eTO = (TextView) findViewById(r.h.newversion);
            this.dfA = (TextView) findViewById(r.h.desc);
            this.eTP = (TextView) findViewById(r.h.update_button);
            this.eTP.setText(PluginDownloadActivity.this.getPageContext().getString(r.l.install_app));
            this.aRb = (TextView) findViewById(r.h.update_cancel);
            this.dHy = (TextView) findViewById(r.h.downloading);
            this.eTU = (TextView) findViewById(r.h.otherApp);
            this.eTU.setVisibility(8);
            this.eTQ = (TextView) findViewById(r.h.app_size);
            this.aNO = (LinearLayout) findViewById(r.h.cancel_dialog);
            this.eTR = (TextView) findViewById(r.h.sure_cancel);
            this.eTS = (TextView) findViewById(r.h.cancel_button);
            this.eTR.setOnClickListener(new l(this));
            this.eTS.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTI.display_name)) {
                this.eTT.setText(PluginDownloadActivity.this.eTI.display_name);
            } else {
                this.eTT.setText("");
            }
            if (PluginDownloadActivity.this.eTI.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTI.newest.version)) {
                    this.eTO.setText("版本：" + PluginDownloadActivity.this.eTI.newest.version);
                } else {
                    this.eTO.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eTI.newest.change_log)) {
                    this.dfA.setText(PluginDownloadActivity.this.eTI.newest.change_log);
                } else {
                    this.dfA.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eTI.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eTQ.setVisibility(0);
                    this.eTQ.setText(((Object) this.eTQ.getText()) + valueOf + "KB");
                } else {
                    this.eTQ.setVisibility(8);
                }
            } else {
                this.eTO.setText("");
                this.dfA.setText("");
                this.eTQ.setText("");
            }
            this.eTP.setOnClickListener(new n(this));
            this.aRb.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eTI != null) {
            PluginPackageManager.iz().br(this.eTI.package_name);
        }
        super.onDestroy();
    }
}
