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
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean den;
    private PluginNetConfigInfos.PluginConfig fyB;
    private a fyD;
    private boolean fyE;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyB = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fyB == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fyD = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fyD.setCancelable(false);
        this.fyD.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fyE) {
                    g.b(PluginDownloadActivity.this.fyD, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fyD.aWT.getVisibility() == 0) {
                        PluginDownloadActivity.this.fyD.aWT.setVisibility(8);
                        PluginDownloadActivity.this.fyD.fyG.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fyD.aWT.setVisibility(0);
                    PluginDownloadActivity.this.fyD.fyG.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fyD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fyD, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.fyD.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aWT;
        private TextView baT;
        private TextView dFF;
        private TextView ehn;
        private LinearLayout fyG;
        private TextView fyH;
        private TextView fyI;
        private TextView fyJ;
        private TextView fyK;
        private TextView fyL;
        private TextView fyM;
        private TextView fyN;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.j.update_dialog);
            findViewById(d.h.warning).setVisibility(8);
            findViewById(d.h.incremental_button).setVisibility(8);
            findViewById(d.h.incremental_size).setVisibility(8);
            this.fyG = (LinearLayout) findViewById(d.h.down_dialog);
            this.fyM = (TextView) findViewById(d.h.update_tip);
            this.fyH = (TextView) findViewById(d.h.newversion);
            this.dFF = (TextView) findViewById(d.h.desc);
            this.fyI = (TextView) findViewById(d.h.update_button);
            this.fyI.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.baT = (TextView) findViewById(d.h.update_cancel);
            this.ehn = (TextView) findViewById(d.h.downloading);
            this.fyN = (TextView) findViewById(d.h.otherApp);
            this.fyN.setVisibility(8);
            this.fyJ = (TextView) findViewById(d.h.app_size);
            this.aWT = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fyK = (TextView) findViewById(d.h.sure_cancel);
            this.fyL = (TextView) findViewById(d.h.cancel_button);
            this.fyK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aWT.setVisibility(8);
                    a.this.fyG.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyB.display_name)) {
                this.fyM.setText(PluginDownloadActivity.this.fyB.display_name);
            } else {
                this.fyM.setText("");
            }
            if (PluginDownloadActivity.this.fyB.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyB.newest.version)) {
                    this.fyH.setText("版本：" + PluginDownloadActivity.this.fyB.newest.version);
                } else {
                    this.fyH.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyB.newest.change_log)) {
                    this.dFF.setText(PluginDownloadActivity.this.fyB.newest.change_log);
                } else {
                    this.dFF.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fyB.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fyJ.setVisibility(0);
                    this.fyJ.setText(((Object) this.fyJ.getText()) + valueOf + "KB");
                } else {
                    this.fyJ.setVisibility(8);
                }
            } else {
                this.fyH.setText("");
                this.dFF.setText("");
                this.fyJ.setText("");
            }
            this.fyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fyE = true;
                        a.this.fyI.setVisibility(8);
                        a.this.baT.setVisibility(8);
                        a.this.ehn.setVisibility(0);
                        PluginPackageManager.jv().a(PluginDownloadActivity.this.fyB, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyB.package_name) && !PluginDownloadActivity.this.den) {
                                    PluginDownloadActivity.this.fyD.ehn.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fyD.ehn.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyB.package_name)) {
                                    PluginDownloadActivity.this.fyD.ehn.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fyD.ehn.setEnabled(false);
                                    PluginDownloadActivity.this.den = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyB.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.den = true;
                                    g.b(PluginDownloadActivity.this.fyD, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.baT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fyB != null) {
            PluginPackageManager.jv().bq(this.fyB.package_name);
        }
        super.onDestroy();
    }
}
