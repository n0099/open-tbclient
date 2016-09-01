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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cMt;
    private PluginNetConfigInfos.PluginConfig eWQ;
    private a eWS;
    private boolean eWT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eWQ = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eWQ == null) {
            showToast(getPageContext().getString(t.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eWS = new a(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.eWS.setCancelable(false);
        this.eWS.setOnKeyListener(new j(this));
        this.eWS.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.eWS, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().x(this.eWS.findViewById(t.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aMe;
        private TextView aTp;
        private TextView dMn;
        private TextView dml;
        private LinearLayout eWV;
        private TextView eWW;
        private TextView eWX;
        private TextView eWY;
        private TextView eWZ;
        private TextView eXa;
        private TextView eXb;
        private TextView eXc;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(t.h.update_dialog);
            findViewById(t.g.warning).setVisibility(8);
            findViewById(t.g.incremental_button).setVisibility(8);
            findViewById(t.g.incremental_size).setVisibility(8);
            this.eWV = (LinearLayout) findViewById(t.g.down_dialog);
            this.eXb = (TextView) findViewById(t.g.update_tip);
            this.eWW = (TextView) findViewById(t.g.newversion);
            this.dml = (TextView) findViewById(t.g.desc);
            this.eWX = (TextView) findViewById(t.g.update_button);
            this.eWX.setText(PluginDownloadActivity.this.getPageContext().getString(t.j.plugin_download_immediately));
            this.aTp = (TextView) findViewById(t.g.update_cancel);
            this.dMn = (TextView) findViewById(t.g.downloading);
            this.eXc = (TextView) findViewById(t.g.otherApp);
            this.eXc.setVisibility(8);
            this.eWY = (TextView) findViewById(t.g.app_size);
            this.aMe = (LinearLayout) findViewById(t.g.cancel_dialog);
            this.eWZ = (TextView) findViewById(t.g.sure_cancel);
            this.eXa = (TextView) findViewById(t.g.cancel_button);
            this.eWZ.setOnClickListener(new l(this));
            this.eXa.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eWQ.display_name)) {
                this.eXb.setText(PluginDownloadActivity.this.eWQ.display_name);
            } else {
                this.eXb.setText("");
            }
            if (PluginDownloadActivity.this.eWQ.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eWQ.newest.version)) {
                    this.eWW.setText("版本：" + PluginDownloadActivity.this.eWQ.newest.version);
                } else {
                    this.eWW.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eWQ.newest.change_log)) {
                    this.dml.setText(PluginDownloadActivity.this.eWQ.newest.change_log);
                } else {
                    this.dml.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eWQ.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eWY.setVisibility(0);
                    this.eWY.setText(((Object) this.eWY.getText()) + valueOf + "KB");
                } else {
                    this.eWY.setVisibility(8);
                }
            } else {
                this.eWW.setText("");
                this.dml.setText("");
                this.eWY.setText("");
            }
            this.eWX.setOnClickListener(new n(this));
            this.aTp.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eWQ != null) {
            PluginPackageManager.iB().bs(this.eWQ.package_name);
        }
        super.onDestroy();
    }
}
