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
    private boolean dva;
    private PluginNetConfigInfos.PluginConfig fRI;
    private a fRK;
    private boolean fRL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRI = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fRI == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fRK = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.fRK.setCancelable(false);
        this.fRK.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fRL) {
                    g.b(PluginDownloadActivity.this.fRK, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fRK.baj.getVisibility() == 0) {
                        PluginDownloadActivity.this.fRK.baj.setVisibility(8);
                        PluginDownloadActivity.this.fRK.fRN.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fRK.baj.setVisibility(0);
                    PluginDownloadActivity.this.fRK.fRN.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fRK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fRK, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.fRK.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout baj;
        private TextView beG;
        private TextView dWd;
        private TextView evG;
        private LinearLayout fRN;
        private TextView fRO;
        private TextView fRP;
        private TextView fRQ;
        private TextView fRR;
        private TextView fRS;
        private TextView fRT;
        private TextView fRU;

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
            this.fRN = (LinearLayout) findViewById(d.g.down_dialog);
            this.fRT = (TextView) findViewById(d.g.update_tip);
            this.fRO = (TextView) findViewById(d.g.newversion);
            this.dWd = (TextView) findViewById(d.g.desc);
            this.fRP = (TextView) findViewById(d.g.update_button);
            this.fRP.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.beG = (TextView) findViewById(d.g.update_cancel);
            this.evG = (TextView) findViewById(d.g.downloading);
            this.fRU = (TextView) findViewById(d.g.otherApp);
            this.fRU.setVisibility(8);
            this.fRQ = (TextView) findViewById(d.g.app_size);
            this.baj = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fRR = (TextView) findViewById(d.g.sure_cancel);
            this.fRS = (TextView) findViewById(d.g.cancel_button);
            this.fRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.baj.setVisibility(8);
                    a.this.fRN.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRI.display_name)) {
                this.fRT.setText(PluginDownloadActivity.this.fRI.display_name);
            } else {
                this.fRT.setText("");
            }
            if (PluginDownloadActivity.this.fRI.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRI.newest.version)) {
                    this.fRO.setText("版本：" + PluginDownloadActivity.this.fRI.newest.version);
                } else {
                    this.fRO.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRI.newest.change_log)) {
                    this.dWd.setText(PluginDownloadActivity.this.fRI.newest.change_log);
                } else {
                    this.dWd.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fRI.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fRQ.setVisibility(0);
                    this.fRQ.setText(((Object) this.fRQ.getText()) + valueOf + "KB");
                } else {
                    this.fRQ.setVisibility(8);
                }
            } else {
                this.fRO.setText("");
                this.dWd.setText("");
                this.fRQ.setText("");
            }
            this.fRP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fRL = true;
                        a.this.fRP.setVisibility(8);
                        a.this.beG.setVisibility(8);
                        a.this.evG.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.fRI, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRI.package_name) && !PluginDownloadActivity.this.dva) {
                                    PluginDownloadActivity.this.fRK.evG.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fRK.evG.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRI.package_name)) {
                                    PluginDownloadActivity.this.fRK.evG.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.fRK.evG.setEnabled(false);
                                    PluginDownloadActivity.this.dva = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRI.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dva = true;
                                    g.b(PluginDownloadActivity.this.fRK, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.beG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fRI != null) {
            PluginPackageManager.js().bq(this.fRI.package_name);
        }
        super.onDestroy();
    }
}
