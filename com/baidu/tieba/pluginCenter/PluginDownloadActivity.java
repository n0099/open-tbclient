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
import com.baidu.adp.lib.f.g;
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
/* loaded from: classes15.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean btj;
    private PluginNetConfigInfos.PluginConfig lfA;
    private a lfD;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lfA = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.lfA == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.lfD = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.lfD.setCancelable(false);
        this.lfD.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.btj) {
                    g.b(PluginDownloadActivity.this.lfD, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.lfD.fbg.getVisibility() == 0) {
                        PluginDownloadActivity.this.lfD.fbg.setVisibility(8);
                        PluginDownloadActivity.this.lfD.lfF.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.lfD.fbg.setVisibility(0);
                    PluginDownloadActivity.this.lfD.lfF.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.lfD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.lfD, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lfD.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes15.dex */
    private class a extends Dialog {
        private TextView agR;
        private LinearLayout fbg;
        private TextView few;
        private LinearLayout lfF;
        private TextView lfG;
        private TextView lfH;
        private TextView lfI;
        private TextView lfJ;
        private TextView lfK;
        private TextView lfL;
        private TextView lfM;
        private TextView lfN;

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
            this.lfF = (LinearLayout) findViewById(R.id.down_dialog);
            this.lfM = (TextView) findViewById(R.id.update_tip);
            this.lfG = (TextView) findViewById(R.id.newversion);
            this.agR = (TextView) findViewById(R.id.desc);
            this.lfH = (TextView) findViewById(R.id.update_button);
            this.lfH.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.few = (TextView) findViewById(R.id.update_cancel);
            this.lfI = (TextView) findViewById(R.id.downloading);
            this.lfN = (TextView) findViewById(R.id.otherApp);
            this.lfN.setVisibility(8);
            this.lfJ = (TextView) findViewById(R.id.app_size);
            this.fbg = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.lfK = (TextView) findViewById(R.id.sure_cancel);
            this.lfL = (TextView) findViewById(R.id.cancel_button);
            this.lfK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.lfL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fbg.setVisibility(8);
                    a.this.lfF.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfA.display_name)) {
                this.lfM.setText(PluginDownloadActivity.this.lfA.display_name);
            } else {
                this.lfM.setText("");
            }
            if (PluginDownloadActivity.this.lfA.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfA.newest.version)) {
                    this.lfG.setText("版本：" + PluginDownloadActivity.this.lfA.newest.version);
                } else {
                    this.lfG.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfA.newest.change_log)) {
                    this.agR.setText(PluginDownloadActivity.this.lfA.newest.change_log);
                } else {
                    this.agR.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.lfA.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.lfJ.setVisibility(0);
                    this.lfJ.setText(((Object) this.lfJ.getText()) + valueOf + "KB");
                } else {
                    this.lfJ.setVisibility(8);
                }
            } else {
                this.lfG.setText("");
                this.agR.setText("");
                this.lfJ.setText("");
            }
            this.lfH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.btj = true;
                        a.this.lfH.setVisibility(8);
                        a.this.few.setVisibility(8);
                        a.this.lfI.setVisibility(0);
                        PluginPackageManager.op().a(PluginDownloadActivity.this.lfA, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfA.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.lfD.lfI.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.lfD.lfI.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfA.package_name)) {
                                    PluginDownloadActivity.this.lfD.lfI.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.lfD.lfI.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfA.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.lfD, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.few.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aZP().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aZP().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lfA != null) {
            PluginPackageManager.op().cx(this.lfA.package_name);
        }
        super.onDestroy();
    }
}
