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
    private boolean dve;
    private PluginNetConfigInfos.PluginConfig fRN;
    private a fRP;
    private boolean fRQ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRN = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fRN == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fRP = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.fRP.setCancelable(false);
        this.fRP.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fRQ) {
                    g.b(PluginDownloadActivity.this.fRP, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fRP.ban.getVisibility() == 0) {
                        PluginDownloadActivity.this.fRP.ban.setVisibility(8);
                        PluginDownloadActivity.this.fRP.fRS.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fRP.ban.setVisibility(0);
                    PluginDownloadActivity.this.fRP.fRS.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fRP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fRP, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.fRP.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout ban;
        private TextView beK;
        private TextView dWh;
        private TextView evK;
        private LinearLayout fRS;
        private TextView fRT;
        private TextView fRU;
        private TextView fRV;
        private TextView fRW;
        private TextView fRX;
        private TextView fRY;
        private TextView fRZ;

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
            this.fRS = (LinearLayout) findViewById(d.g.down_dialog);
            this.fRY = (TextView) findViewById(d.g.update_tip);
            this.fRT = (TextView) findViewById(d.g.newversion);
            this.dWh = (TextView) findViewById(d.g.desc);
            this.fRU = (TextView) findViewById(d.g.update_button);
            this.fRU.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.beK = (TextView) findViewById(d.g.update_cancel);
            this.evK = (TextView) findViewById(d.g.downloading);
            this.fRZ = (TextView) findViewById(d.g.otherApp);
            this.fRZ.setVisibility(8);
            this.fRV = (TextView) findViewById(d.g.app_size);
            this.ban = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fRW = (TextView) findViewById(d.g.sure_cancel);
            this.fRX = (TextView) findViewById(d.g.cancel_button);
            this.fRW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fRX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ban.setVisibility(8);
                    a.this.fRS.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRN.display_name)) {
                this.fRY.setText(PluginDownloadActivity.this.fRN.display_name);
            } else {
                this.fRY.setText("");
            }
            if (PluginDownloadActivity.this.fRN.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRN.newest.version)) {
                    this.fRT.setText("版本：" + PluginDownloadActivity.this.fRN.newest.version);
                } else {
                    this.fRT.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRN.newest.change_log)) {
                    this.dWh.setText(PluginDownloadActivity.this.fRN.newest.change_log);
                } else {
                    this.dWh.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fRN.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fRV.setVisibility(0);
                    this.fRV.setText(((Object) this.fRV.getText()) + valueOf + "KB");
                } else {
                    this.fRV.setVisibility(8);
                }
            } else {
                this.fRT.setText("");
                this.dWh.setText("");
                this.fRV.setText("");
            }
            this.fRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fRQ = true;
                        a.this.fRU.setVisibility(8);
                        a.this.beK.setVisibility(8);
                        a.this.evK.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.fRN, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRN.package_name) && !PluginDownloadActivity.this.dve) {
                                    PluginDownloadActivity.this.fRP.evK.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fRP.evK.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRN.package_name)) {
                                    PluginDownloadActivity.this.fRP.evK.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.fRP.evK.setEnabled(false);
                                    PluginDownloadActivity.this.dve = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRN.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dve = true;
                                    g.b(PluginDownloadActivity.this.fRP, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.beK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fRN != null) {
            PluginPackageManager.js().bq(this.fRN.package_name);
        }
        super.onDestroy();
    }
}
