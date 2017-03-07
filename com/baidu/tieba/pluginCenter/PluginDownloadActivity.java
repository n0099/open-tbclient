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
    private boolean cGh;
    private PluginNetConfigInfos.PluginConfig eXo;
    private a eXq;
    private boolean eXr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eXo = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.eXo == null) {
            showToast(getPageContext().getString(w.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.eXq = new a(getPageContext().getPageActivity(), w.m.common_alert_dialog);
        this.eXq.setCancelable(false);
        this.eXq.setOnKeyListener(new j(this));
        this.eXq.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.g.j.a(this.eXq, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.eXq.findViewById(w.h.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aTB;
        private TextView aXm;
        private TextView dKf;
        private TextView dhR;
        private TextView eXA;
        private LinearLayout eXt;
        private TextView eXu;
        private TextView eXv;
        private TextView eXw;
        private TextView eXx;
        private TextView eXy;
        private TextView eXz;

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
            this.eXt = (LinearLayout) findViewById(w.h.down_dialog);
            this.eXz = (TextView) findViewById(w.h.update_tip);
            this.eXu = (TextView) findViewById(w.h.newversion);
            this.dhR = (TextView) findViewById(w.h.desc);
            this.eXv = (TextView) findViewById(w.h.update_button);
            this.eXv.setText(PluginDownloadActivity.this.getPageContext().getString(w.l.install_app));
            this.aXm = (TextView) findViewById(w.h.update_cancel);
            this.dKf = (TextView) findViewById(w.h.downloading);
            this.eXA = (TextView) findViewById(w.h.otherApp);
            this.eXA.setVisibility(8);
            this.eXw = (TextView) findViewById(w.h.app_size);
            this.aTB = (LinearLayout) findViewById(w.h.cancel_dialog);
            this.eXx = (TextView) findViewById(w.h.sure_cancel);
            this.eXy = (TextView) findViewById(w.h.cancel_button);
            this.eXx.setOnClickListener(new l(this));
            this.eXy.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXo.display_name)) {
                this.eXz.setText(PluginDownloadActivity.this.eXo.display_name);
            } else {
                this.eXz.setText("");
            }
            if (PluginDownloadActivity.this.eXo.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXo.newest.version)) {
                    this.eXu.setText("版本：" + PluginDownloadActivity.this.eXo.newest.version);
                } else {
                    this.eXu.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.eXo.newest.change_log)) {
                    this.dhR.setText(PluginDownloadActivity.this.eXo.newest.change_log);
                } else {
                    this.dhR.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.eXo.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.eXw.setVisibility(0);
                    this.eXw.setText(((Object) this.eXw.getText()) + valueOf + "KB");
                } else {
                    this.eXw.setVisibility(8);
                }
            } else {
                this.eXu.setText("");
                this.dhR.setText("");
                this.eXw.setText("");
            }
            this.eXv.setOnClickListener(new n(this));
            this.aXm.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eXo != null) {
            PluginPackageManager.jt().bl(this.eXo.package_name);
        }
        super.onDestroy();
    }
}
