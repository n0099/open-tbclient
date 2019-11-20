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
    private boolean axs;
    private PluginNetConfigInfos.PluginConfig iAF;
    private a iAI;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iAF = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iAF == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iAI = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.iAI.setCancelable(false);
        this.iAI.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.axs) {
                    g.b(PluginDownloadActivity.this.iAI, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iAI.ddV.getVisibility() == 0) {
                        PluginDownloadActivity.this.iAI.ddV.setVisibility(8);
                        PluginDownloadActivity.this.iAI.iAK.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iAI.ddV.setVisibility(0);
                    PluginDownloadActivity.this.iAI.iAK.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iAI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iAI, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iAI.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private TextView aan;
        private LinearLayout ddV;
        private TextView diG;
        private LinearLayout iAK;
        private TextView iAL;
        private TextView iAM;
        private TextView iAN;
        private TextView iAO;
        private TextView iAP;
        private TextView iAQ;
        private TextView iAR;
        private TextView iAS;

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
            this.iAK = (LinearLayout) findViewById(R.id.down_dialog);
            this.iAR = (TextView) findViewById(R.id.update_tip);
            this.iAL = (TextView) findViewById(R.id.newversion);
            this.aan = (TextView) findViewById(R.id.desc);
            this.iAM = (TextView) findViewById(R.id.update_button);
            this.iAM.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.diG = (TextView) findViewById(R.id.update_cancel);
            this.iAN = (TextView) findViewById(R.id.downloading);
            this.iAS = (TextView) findViewById(R.id.otherApp);
            this.iAS.setVisibility(8);
            this.iAO = (TextView) findViewById(R.id.app_size);
            this.ddV = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.iAP = (TextView) findViewById(R.id.sure_cancel);
            this.iAQ = (TextView) findViewById(R.id.cancel_button);
            this.iAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ddV.setVisibility(8);
                    a.this.iAK.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAF.display_name)) {
                this.iAR.setText(PluginDownloadActivity.this.iAF.display_name);
            } else {
                this.iAR.setText("");
            }
            if (PluginDownloadActivity.this.iAF.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAF.newest.version)) {
                    this.iAL.setText("版本：" + PluginDownloadActivity.this.iAF.newest.version);
                } else {
                    this.iAL.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iAF.newest.change_log)) {
                    this.aan.setText(PluginDownloadActivity.this.iAF.newest.change_log);
                } else {
                    this.aan.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iAF.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iAO.setVisibility(0);
                    this.iAO.setText(((Object) this.iAO.getText()) + valueOf + "KB");
                } else {
                    this.iAO.setVisibility(8);
                }
            } else {
                this.iAL.setText("");
                this.aan.setText("");
                this.iAO.setText("");
            }
            this.iAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.axs = true;
                        a.this.iAM.setVisibility(8);
                        a.this.diG.setVisibility(8);
                        a.this.iAN.setVisibility(0);
                        PluginPackageManager.iL().a(PluginDownloadActivity.this.iAF, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAF.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iAI.iAN.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iAI.iAN.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAF.package_name)) {
                                    PluginDownloadActivity.this.iAI.iAN.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.iAI.iAN.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iAF.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iAI, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.diG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.alP().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.alP().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iAF != null) {
            PluginPackageManager.iL().aU(this.iAF.package_name);
        }
        super.onDestroy();
    }
}
