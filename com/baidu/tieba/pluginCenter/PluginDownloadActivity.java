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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cAO;
    private PluginNetConfigInfos.PluginConfig ePF;
    private a ePH;
    private boolean ePI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ePF = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.ePF == null) {
            showToast(getPageContext().getString(u.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.ePH = new a(getPageContext().getPageActivity(), u.k.common_alert_dialog);
        this.ePH.setCancelable(false);
        this.ePH.setOnKeyListener(new j(this));
        this.ePH.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.ePH, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().w(this.ePH.findViewById(u.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aIN;
        private TextView aNV;
        private TextView bFn;
        private TextView dAy;
        private LinearLayout ePK;
        private TextView ePL;
        private TextView ePM;
        private TextView ePN;
        private TextView ePO;
        private TextView ePP;
        private TextView ePQ;
        private TextView ePR;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(u.h.update_dialog);
            findViewById(u.g.warning).setVisibility(8);
            findViewById(u.g.incremental_button).setVisibility(8);
            findViewById(u.g.incremental_size).setVisibility(8);
            this.ePK = (LinearLayout) findViewById(u.g.down_dialog);
            this.ePQ = (TextView) findViewById(u.g.update_tip);
            this.ePL = (TextView) findViewById(u.g.newversion);
            this.bFn = (TextView) findViewById(u.g.desc);
            this.ePM = (TextView) findViewById(u.g.update_button);
            this.ePM.setText(PluginDownloadActivity.this.getPageContext().getString(u.j.plugin_download_immediately));
            this.aNV = (TextView) findViewById(u.g.update_cancel);
            this.dAy = (TextView) findViewById(u.g.downloading);
            this.ePR = (TextView) findViewById(u.g.otherApp);
            this.ePR.setVisibility(8);
            this.ePN = (TextView) findViewById(u.g.app_size);
            this.aIN = (LinearLayout) findViewById(u.g.cancel_dialog);
            this.ePO = (TextView) findViewById(u.g.sure_cancel);
            this.ePP = (TextView) findViewById(u.g.cancel_button);
            this.ePO.setOnClickListener(new l(this));
            this.ePP.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.ePF.display_name)) {
                this.ePQ.setText(PluginDownloadActivity.this.ePF.display_name);
            } else {
                this.ePQ.setText("");
            }
            if (PluginDownloadActivity.this.ePF.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ePF.newest.version)) {
                    this.ePL.setText("版本：" + PluginDownloadActivity.this.ePF.newest.version);
                } else {
                    this.ePL.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ePF.newest.change_log)) {
                    this.bFn.setText(PluginDownloadActivity.this.ePF.newest.change_log);
                } else {
                    this.bFn.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.ePF.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.ePN.setVisibility(0);
                    this.ePN.setText(((Object) this.ePN.getText()) + valueOf + "KB");
                } else {
                    this.ePN.setVisibility(8);
                }
            } else {
                this.ePL.setText("");
                this.bFn.setText("");
                this.ePN.setText("");
            }
            this.ePM.setOnClickListener(new n(this));
            this.aNV.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ePF != null) {
            PluginPackageManager.hG().br(this.ePF.package_name);
        }
        super.onDestroy();
    }
}
