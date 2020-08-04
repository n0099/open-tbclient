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
    private PluginNetConfigInfos.PluginConfig lfC;
    private a lfF;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lfC = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.lfC == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.lfF = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.lfF.setCancelable(false);
        this.lfF.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.btj) {
                    g.b(PluginDownloadActivity.this.lfF, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.lfF.fbg.getVisibility() == 0) {
                        PluginDownloadActivity.this.lfF.fbg.setVisibility(8);
                        PluginDownloadActivity.this.lfF.lfH.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.lfF.fbg.setVisibility(0);
                    PluginDownloadActivity.this.lfF.lfH.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.lfF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.lfF, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lfF.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes15.dex */
    private class a extends Dialog {
        private TextView agR;
        private LinearLayout fbg;
        private TextView few;
        private LinearLayout lfH;
        private TextView lfI;
        private TextView lfJ;
        private TextView lfK;
        private TextView lfL;
        private TextView lfM;
        private TextView lfN;
        private TextView lfO;
        private TextView lfP;

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
            this.lfH = (LinearLayout) findViewById(R.id.down_dialog);
            this.lfO = (TextView) findViewById(R.id.update_tip);
            this.lfI = (TextView) findViewById(R.id.newversion);
            this.agR = (TextView) findViewById(R.id.desc);
            this.lfJ = (TextView) findViewById(R.id.update_button);
            this.lfJ.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.few = (TextView) findViewById(R.id.update_cancel);
            this.lfK = (TextView) findViewById(R.id.downloading);
            this.lfP = (TextView) findViewById(R.id.otherApp);
            this.lfP.setVisibility(8);
            this.lfL = (TextView) findViewById(R.id.app_size);
            this.fbg = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.lfM = (TextView) findViewById(R.id.sure_cancel);
            this.lfN = (TextView) findViewById(R.id.cancel_button);
            this.lfM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.lfN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fbg.setVisibility(8);
                    a.this.lfH.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfC.display_name)) {
                this.lfO.setText(PluginDownloadActivity.this.lfC.display_name);
            } else {
                this.lfO.setText("");
            }
            if (PluginDownloadActivity.this.lfC.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfC.newest.version)) {
                    this.lfI.setText("版本：" + PluginDownloadActivity.this.lfC.newest.version);
                } else {
                    this.lfI.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lfC.newest.change_log)) {
                    this.agR.setText(PluginDownloadActivity.this.lfC.newest.change_log);
                } else {
                    this.agR.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.lfC.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.lfL.setVisibility(0);
                    this.lfL.setText(((Object) this.lfL.getText()) + valueOf + "KB");
                } else {
                    this.lfL.setVisibility(8);
                }
            } else {
                this.lfI.setText("");
                this.agR.setText("");
                this.lfL.setText("");
            }
            this.lfJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.btj = true;
                        a.this.lfJ.setVisibility(8);
                        a.this.few.setVisibility(8);
                        a.this.lfK.setVisibility(0);
                        PluginPackageManager.op().a(PluginDownloadActivity.this.lfC, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfC.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.lfF.lfK.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.lfF.lfK.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfC.package_name)) {
                                    PluginDownloadActivity.this.lfF.lfK.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.lfF.lfK.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lfC.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.lfF, PluginDownloadActivity.this.getPageContext());
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
        if (this.lfC != null) {
            PluginPackageManager.op().cx(this.lfC.package_name);
        }
        super.onDestroy();
    }
}
