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
    private boolean bJb;
    private PluginNetConfigInfos.PluginConfig dxc;
    private a dxe;
    private boolean dxf;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxc = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.dxc == null) {
            showToast(getPageContext().getString(t.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.dxe = new a(getPageContext().getPageActivity(), t.k.common_alert_dialog);
        this.dxe.setCancelable(false);
        this.dxe.setOnKeyListener(new j(this));
        this.dxe.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.dxe, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.dxe.findViewById(t.g.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aIn;
        private TextView aKx;
        private TextView bif;
        private LinearLayout dxh;
        private TextView dxi;
        private TextView dxj;
        private TextView dxk;
        private TextView dxl;
        private TextView dxm;
        private TextView dxn;
        private TextView dxo;
        private TextView dxp;

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
            this.dxh = (LinearLayout) findViewById(t.g.down_dialog);
            this.dxo = (TextView) findViewById(t.g.update_tip);
            this.dxi = (TextView) findViewById(t.g.newversion);
            this.bif = (TextView) findViewById(t.g.desc);
            this.dxj = (TextView) findViewById(t.g.update_button);
            this.dxj.setText(PluginDownloadActivity.this.getPageContext().getString(t.j.plugin_download_immediately));
            this.aKx = (TextView) findViewById(t.g.update_cancel);
            this.dxk = (TextView) findViewById(t.g.downloading);
            this.dxp = (TextView) findViewById(t.g.otherApp);
            this.dxp.setVisibility(8);
            this.dxl = (TextView) findViewById(t.g.app_size);
            this.aIn = (LinearLayout) findViewById(t.g.cancel_dialog);
            this.dxm = (TextView) findViewById(t.g.sure_cancel);
            this.dxn = (TextView) findViewById(t.g.cancel_button);
            this.dxm.setOnClickListener(new l(this));
            this.dxn.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.dxc.display_name)) {
                this.dxo.setText(PluginDownloadActivity.this.dxc.display_name);
            } else {
                this.dxo.setText("");
            }
            if (PluginDownloadActivity.this.dxc.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dxc.newest.version)) {
                    this.dxi.setText("版本：" + PluginDownloadActivity.this.dxc.newest.version);
                } else {
                    this.dxi.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.dxc.newest.change_log)) {
                    this.bif.setText(PluginDownloadActivity.this.dxc.newest.change_log);
                } else {
                    this.bif.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.dxc.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.dxl.setVisibility(0);
                    this.dxl.setText(((Object) this.dxl.getText()) + valueOf + "KB");
                } else {
                    this.dxl.setVisibility(8);
                }
            } else {
                this.dxi.setText("");
                this.bif.setText("");
                this.dxl.setText("");
            }
            this.dxj.setOnClickListener(new n(this));
            this.aKx.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dxc != null) {
            PluginPackageManager.lD().bz(this.dxc.package_name);
        }
        super.onDestroy();
    }
}
