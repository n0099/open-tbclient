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
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes3.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig iaD;
    private a iaG;
    private boolean iaH;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iaD = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iaD == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iaG = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.iaG.setCancelable(false);
        this.iaG.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.iaH) {
                    g.b(PluginDownloadActivity.this.iaG, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iaG.cKI.getVisibility() == 0) {
                        PluginDownloadActivity.this.iaG.cKI.setVisibility(8);
                        PluginDownloadActivity.this.iaG.iaJ.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iaG.cKI.setVisibility(0);
                    PluginDownloadActivity.this.iaG.iaJ.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iaG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iaG, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iaG.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cKI;
        private TextView cOw;
        private TextView fsp;
        private LinearLayout iaJ;
        private TextView iaK;
        private TextView iaL;
        private TextView iaM;
        private TextView iaN;
        private TextView iaO;
        private TextView iaP;
        private TextView iaQ;
        private TextView iaR;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.h.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.iaJ = (LinearLayout) findViewById(d.g.down_dialog);
            this.iaQ = (TextView) findViewById(d.g.update_tip);
            this.iaK = (TextView) findViewById(d.g.newversion);
            this.fsp = (TextView) findViewById(d.g.desc);
            this.iaL = (TextView) findViewById(d.g.update_button);
            this.iaL.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.cOw = (TextView) findViewById(d.g.update_cancel);
            this.iaM = (TextView) findViewById(d.g.downloading);
            this.iaR = (TextView) findViewById(d.g.otherApp);
            this.iaR.setVisibility(8);
            this.iaN = (TextView) findViewById(d.g.app_size);
            this.cKI = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.iaO = (TextView) findViewById(d.g.sure_cancel);
            this.iaP = (TextView) findViewById(d.g.cancel_button);
            this.iaO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iaP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cKI.setVisibility(8);
                    a.this.iaJ.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaD.display_name)) {
                this.iaQ.setText(PluginDownloadActivity.this.iaD.display_name);
            } else {
                this.iaQ.setText("");
            }
            if (PluginDownloadActivity.this.iaD.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaD.newest.version)) {
                    this.iaK.setText("版本：" + PluginDownloadActivity.this.iaD.newest.version);
                } else {
                    this.iaK.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaD.newest.change_log)) {
                    this.fsp.setText(PluginDownloadActivity.this.iaD.newest.change_log);
                } else {
                    this.fsp.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iaD.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iaN.setVisibility(0);
                    this.iaN.setText(((Object) this.iaN.getText()) + valueOf + "KB");
                } else {
                    this.iaN.setVisibility(8);
                }
            } else {
                this.iaK.setText("");
                this.fsp.setText("");
                this.iaN.setText("");
            }
            this.iaL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kY()) {
                        PluginDownloadActivity.this.iaH = true;
                        a.this.iaL.setVisibility(8);
                        a.this.cOw.setVisibility(8);
                        a.this.iaM.setVisibility(0);
                        PluginPackageManager.ni().a(PluginDownloadActivity.this.iaD, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaD.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iaG.iaM.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iaG.iaM.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaD.package_name)) {
                                    PluginDownloadActivity.this.iaG.iaM.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.iaG.iaM.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaD.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iaG, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.cOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.getInstance().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.getInstance().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iaD != null) {
            PluginPackageManager.ni().cb(this.iaD.package_name);
        }
        super.onDestroy();
    }
}
