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
    private boolean bTx;
    private PluginNetConfigInfos.PluginConfig dRJ;
    private a dRL;
    private boolean dRM;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dRJ = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.dRJ == null) {
            showToast(getPageContext().getString(t.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.dRL = new a(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.dRL.setCancelable(false);
        this.dRL.setOnKeyListener(new j(this));
        this.dRL.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.dRL, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.dRL.findViewById(t.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aLj;
        private TextView aNt;
        private TextView bmR;
        private TextView cQt;
        private LinearLayout dRO;
        private TextView dRP;
        private TextView dRQ;
        private TextView dRR;
        private TextView dRS;
        private TextView dRT;
        private TextView dRU;
        private TextView dRV;

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
            this.dRO = (LinearLayout) findViewById(t.g.down_dialog);
            this.dRU = (TextView) findViewById(t.g.update_tip);
            this.dRP = (TextView) findViewById(t.g.newversion);
            this.bmR = (TextView) findViewById(t.g.desc);
            this.dRQ = (TextView) findViewById(t.g.update_button);
            this.dRQ.setText(PluginDownloadActivity.this.getPageContext().getString(t.j.plugin_download_immediately));
            this.aNt = (TextView) findViewById(t.g.update_cancel);
            this.cQt = (TextView) findViewById(t.g.downloading);
            this.dRV = (TextView) findViewById(t.g.otherApp);
            this.dRV.setVisibility(8);
            this.dRR = (TextView) findViewById(t.g.app_size);
            this.aLj = (LinearLayout) findViewById(t.g.cancel_dialog);
            this.dRS = (TextView) findViewById(t.g.sure_cancel);
            this.dRT = (TextView) findViewById(t.g.cancel_button);
            this.dRS.setOnClickListener(new l(this));
            this.dRT.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.dRJ.display_name)) {
                this.dRU.setText(PluginDownloadActivity.this.dRJ.display_name);
            } else {
                this.dRU.setText("");
            }
            if (PluginDownloadActivity.this.dRJ.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dRJ.newest.version)) {
                    this.dRP.setText("版本：" + PluginDownloadActivity.this.dRJ.newest.version);
                } else {
                    this.dRP.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dRJ.newest.change_log)) {
                    this.bmR.setText(PluginDownloadActivity.this.dRJ.newest.change_log);
                } else {
                    this.bmR.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.dRJ.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.dRR.setVisibility(0);
                    this.dRR.setText(((Object) this.dRR.getText()) + valueOf + "KB");
                } else {
                    this.dRR.setVisibility(8);
                }
            } else {
                this.dRP.setText("");
                this.bmR.setText("");
                this.dRR.setText("");
            }
            this.dRQ.setOnClickListener(new n(this));
            this.aNt.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dRJ != null) {
            PluginPackageManager.ls().bx(this.dRJ.package_name);
        }
        super.onDestroy();
    }
}
