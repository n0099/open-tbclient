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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig ddC;
    private boolean ddD;
    private a ddF;
    private boolean ddG;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ddC = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.ddC == null) {
            showToast(getPageContext().getString(n.i.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.ddF = new a(getPageContext().getPageActivity(), n.j.common_alert_dialog);
        this.ddF.setCancelable(false);
        this.ddF.setOnKeyListener(new j(this));
        this.ddF.setOnDismissListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        com.baidu.adp.lib.h.j.a(this.ddF, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.ddF.findViewById(n.f.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends Dialog {
        private LinearLayout aFL;
        private TextView aHU;
        private TextView bbA;
        private LinearLayout ddI;
        private TextView ddJ;
        private TextView ddK;
        private TextView ddL;
        private TextView ddM;
        private TextView ddN;
        private TextView ddO;
        private TextView ddP;
        private TextView ddQ;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(n.g.update_dialog);
            findViewById(n.f.warning).setVisibility(8);
            findViewById(n.f.incremental_button).setVisibility(8);
            findViewById(n.f.incremental_size).setVisibility(8);
            this.ddI = (LinearLayout) findViewById(n.f.down_dialog);
            this.ddP = (TextView) findViewById(n.f.update_tip);
            this.ddJ = (TextView) findViewById(n.f.newversion);
            this.bbA = (TextView) findViewById(n.f.desc);
            this.ddK = (TextView) findViewById(n.f.update_button);
            this.ddK.setText(PluginDownloadActivity.this.getPageContext().getString(n.i.plugin_download_immediately));
            this.aHU = (TextView) findViewById(n.f.update_cancel);
            this.ddL = (TextView) findViewById(n.f.downloading);
            this.ddQ = (TextView) findViewById(n.f.otherApp);
            this.ddQ.setVisibility(8);
            this.ddM = (TextView) findViewById(n.f.app_size);
            this.aFL = (LinearLayout) findViewById(n.f.cancel_dialog);
            this.ddN = (TextView) findViewById(n.f.sure_cancel);
            this.ddO = (TextView) findViewById(n.f.cancel_button);
            this.ddN.setOnClickListener(new l(this));
            this.ddO.setOnClickListener(new m(this));
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.ddC.display_name)) {
                this.ddP.setText(PluginDownloadActivity.this.ddC.display_name);
            } else {
                this.ddP.setText("");
            }
            if (PluginDownloadActivity.this.ddC.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ddC.newest.version)) {
                    this.ddJ.setText("版本：" + PluginDownloadActivity.this.ddC.newest.version);
                } else {
                    this.ddJ.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ddC.newest.change_log)) {
                    this.bbA.setText(PluginDownloadActivity.this.ddC.newest.change_log);
                } else {
                    this.bbA.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.ddC.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.ddM.setVisibility(0);
                    this.ddM.setText(((Object) this.ddM.getText()) + valueOf + "KB");
                } else {
                    this.ddM.setVisibility(8);
                }
            } else {
                this.ddJ.setText("");
                this.bbA.setText("");
                this.ddM.setText("");
            }
            this.ddK.setOnClickListener(new n(this));
            this.aHU.setOnClickListener(new p(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ddC != null) {
            PluginPackageManager.lU().bw(this.ddC.package_name);
        }
        super.onDestroy();
    }
}
