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
    private PluginNetConfigInfos.PluginConfig fyC;
    private a fyE;
    private boolean fyF;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyC = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fyC == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fyE = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fyE.setCancelable(false);
        this.fyE.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fyF) {
                    g.b(PluginDownloadActivity.this.fyE, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fyE.aWT.getVisibility() == 0) {
                        PluginDownloadActivity.this.fyE.aWT.setVisibility(8);
                        PluginDownloadActivity.this.fyE.fyH.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fyE.aWT.setVisibility(0);
                    PluginDownloadActivity.this.fyE.fyH.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fyE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fyE, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(this.fyE.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aWT;
        private TextView baT;
        private TextView dFF;
        private TextView ehn;
        private LinearLayout fyH;
        private TextView fyI;
        private TextView fyJ;
        private TextView fyK;
        private TextView fyL;
        private TextView fyM;
        private TextView fyN;
        private TextView fyO;

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
            this.fyH = (LinearLayout) findViewById(d.h.down_dialog);
            this.fyN = (TextView) findViewById(d.h.update_tip);
            this.fyI = (TextView) findViewById(d.h.newversion);
            this.dFF = (TextView) findViewById(d.h.desc);
            this.fyJ = (TextView) findViewById(d.h.update_button);
            this.fyJ.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.baT = (TextView) findViewById(d.h.update_cancel);
            this.ehn = (TextView) findViewById(d.h.downloading);
            this.fyO = (TextView) findViewById(d.h.otherApp);
            this.fyO.setVisibility(8);
            this.fyK = (TextView) findViewById(d.h.app_size);
            this.aWT = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fyL = (TextView) findViewById(d.h.sure_cancel);
            this.fyM = (TextView) findViewById(d.h.cancel_button);
            this.fyL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fyM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aWT.setVisibility(8);
                    a.this.fyH.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyC.display_name)) {
                this.fyN.setText(PluginDownloadActivity.this.fyC.display_name);
            } else {
                this.fyN.setText("");
            }
            if (PluginDownloadActivity.this.fyC.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyC.newest.version)) {
                    this.fyI.setText("版本：" + PluginDownloadActivity.this.fyC.newest.version);
                } else {
                    this.fyI.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyC.newest.change_log)) {
                    this.dFF.setText(PluginDownloadActivity.this.fyC.newest.change_log);
                } else {
                    this.dFF.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fyC.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fyK.setVisibility(0);
                    this.fyK.setText(((Object) this.fyK.getText()) + valueOf + "KB");
                } else {
                    this.fyK.setVisibility(8);
                }
            } else {
                this.fyI.setText("");
                this.dFF.setText("");
                this.fyK.setText("");
            }
            this.fyJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fyF = true;
                        a.this.fyJ.setVisibility(8);
                        a.this.baT.setVisibility(8);
                        a.this.ehn.setVisibility(0);
                        PluginPackageManager.jv().a(PluginDownloadActivity.this.fyC, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyC.package_name) && !PluginDownloadActivity.this.den) {
                                    PluginDownloadActivity.this.fyE.ehn.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fyE.ehn.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyC.package_name)) {
                                    PluginDownloadActivity.this.fyE.ehn.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fyE.ehn.setEnabled(false);
                                    PluginDownloadActivity.this.den = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyC.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.den = true;
                                    g.b(PluginDownloadActivity.this.fyE, PluginDownloadActivity.this.getPageContext());
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
        if (this.fyC != null) {
            PluginPackageManager.jv().bq(this.fyC.package_name);
        }
        super.onDestroy();
    }
}
