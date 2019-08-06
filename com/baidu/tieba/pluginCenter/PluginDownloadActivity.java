package com.baidu.tieba.pluginCenter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes3.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean aem;
    private PluginNetConfigInfos.PluginConfig iAI;
    private a iAL;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iAI = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iAI == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iAL = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.iAL.setCancelable(false);
        this.iAL.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aem) {
                    g.b(PluginDownloadActivity.this.iAL, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iAL.cUz.getVisibility() == 0) {
                        PluginDownloadActivity.this.iAL.cUz.setVisibility(8);
                        PluginDownloadActivity.this.iAL.iAN.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iAL.cUz.setVisibility(0);
                    PluginDownloadActivity.this.iAL.iAN.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iAL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                PluginDownloadActivity.this.setResult(0);
                PluginDownloadActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        g.a(this.iAL, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iAL.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cUz;
        private TextView cYn;
        private TextView fOz;
        private LinearLayout iAN;
        private TextView iAO;
        private TextView iAP;
        private TextView iAQ;
        private TextView iAR;
        private TextView iAS;
        private TextView iAT;
        private TextView iAU;
        private TextView iAV;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R.layout.update_dialog);
            findViewById(R.id.warning).setVisibility(8);
            findViewById(R.id.incremental_button).setVisibility(8);
            findViewById(R.id.incremental_size).setVisibility(8);
            this.iAN = (LinearLayout) findViewById(R.id.down_dialog);
            this.iAU = (TextView) findViewById(R.id.update_tip);
            this.iAO = (TextView) findViewById(R.id.newversion);
            this.fOz = (TextView) findViewById(R.id.desc);
            this.iAP = (TextView) findViewById(R.id.update_button);
            this.iAP.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cYn = (TextView) findViewById(R.id.update_cancel);
            this.iAQ = (TextView) findViewById(R.id.downloading);
            this.iAV = (TextView) findViewById(R.id.otherApp);
            this.iAV.setVisibility(8);
            this.iAR = (TextView) findViewById(R.id.app_size);
            this.cUz = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.iAS = (TextView) findViewById(R.id.sure_cancel);
            this.iAT = (TextView) findViewById(R.id.cancel_button);
            this.iAS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cUz.setVisibility(8);
                    a.this.iAN.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAI.display_name)) {
                this.iAU.setText(PluginDownloadActivity.this.iAI.display_name);
            } else {
                this.iAU.setText("");
            }
            if (PluginDownloadActivity.this.iAI.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAI.newest.version)) {
                    this.iAO.setText("版本：" + PluginDownloadActivity.this.iAI.newest.version);
                } else {
                    this.iAO.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAI.newest.change_log)) {
                    this.fOz.setText(PluginDownloadActivity.this.iAI.newest.change_log);
                } else {
                    this.fOz.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iAI.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iAR.setVisibility(0);
                    this.iAR.setText(((Object) this.iAR.getText()) + valueOf + "KB");
                } else {
                    this.iAR.setVisibility(8);
                }
            } else {
                this.iAO.setText("");
                this.fOz.setText("");
                this.iAR.setText("");
            }
            this.iAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        PluginDownloadActivity.this.aem = true;
                        a.this.iAP.setVisibility(8);
                        a.this.cYn.setVisibility(8);
                        a.this.iAQ.setVisibility(0);
                        PluginPackageManager.ms().a(PluginDownloadActivity.this.iAI, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAI.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iAL.iAQ.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iAL.iAQ.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAI.package_name)) {
                                    PluginDownloadActivity.this.iAL.iAQ.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.iAL.iAQ.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAI.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iAL, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cYn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.ahQ().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.ahQ().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iAI != null) {
            PluginPackageManager.ms().bN(this.iAI.package_name);
        }
        super.onDestroy();
    }
}
