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
import com.baidu.tieba.e;
import java.util.Date;
/* loaded from: classes4.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig gJv;
    private a gJx;
    private boolean gJy;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJv = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gJv == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gJx = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gJx.setCancelable(false);
        this.gJx.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gJy) {
                    g.b(PluginDownloadActivity.this.gJx, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gJx.bzD.getVisibility() == 0) {
                        PluginDownloadActivity.this.gJx.bzD.setVisibility(8);
                        PluginDownloadActivity.this.gJx.gJA.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gJx.bzD.setVisibility(0);
                    PluginDownloadActivity.this.gJx.gJA.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gJx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gJx, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gJx.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private TextView bDq;
        private LinearLayout bzD;
        private TextView eeo;
        private LinearLayout gJA;
        private TextView gJB;
        private TextView gJC;
        private TextView gJD;
        private TextView gJE;
        private TextView gJF;
        private TextView gJG;
        private TextView gJH;
        private TextView gJI;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(e.h.update_dialog);
            findViewById(e.g.warning).setVisibility(8);
            findViewById(e.g.incremental_button).setVisibility(8);
            findViewById(e.g.incremental_size).setVisibility(8);
            this.gJA = (LinearLayout) findViewById(e.g.down_dialog);
            this.gJH = (TextView) findViewById(e.g.update_tip);
            this.gJB = (TextView) findViewById(e.g.newversion);
            this.eeo = (TextView) findViewById(e.g.desc);
            this.gJC = (TextView) findViewById(e.g.update_button);
            this.gJC.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.bDq = (TextView) findViewById(e.g.update_cancel);
            this.gJD = (TextView) findViewById(e.g.downloading);
            this.gJI = (TextView) findViewById(e.g.otherApp);
            this.gJI.setVisibility(8);
            this.gJE = (TextView) findViewById(e.g.app_size);
            this.bzD = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gJF = (TextView) findViewById(e.g.sure_cancel);
            this.gJG = (TextView) findViewById(e.g.cancel_button);
            this.gJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gJG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bzD.setVisibility(8);
                    a.this.gJA.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJv.display_name)) {
                this.gJH.setText(PluginDownloadActivity.this.gJv.display_name);
            } else {
                this.gJH.setText("");
            }
            if (PluginDownloadActivity.this.gJv.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJv.newest.version)) {
                    this.gJB.setText("版本：" + PluginDownloadActivity.this.gJv.newest.version);
                } else {
                    this.gJB.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJv.newest.change_log)) {
                    this.eeo.setText(PluginDownloadActivity.this.gJv.newest.change_log);
                } else {
                    this.eeo.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gJv.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gJE.setVisibility(0);
                    this.gJE.setText(((Object) this.gJE.getText()) + valueOf + "KB");
                } else {
                    this.gJE.setVisibility(8);
                }
            } else {
                this.gJB.setText("");
                this.eeo.setText("");
                this.gJE.setText("");
            }
            this.gJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        PluginDownloadActivity.this.gJy = true;
                        a.this.gJC.setVisibility(8);
                        a.this.bDq.setVisibility(8);
                        a.this.gJD.setVisibility(0);
                        PluginPackageManager.nd().a(PluginDownloadActivity.this.gJv, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJv.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gJx.gJD.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gJx.gJD.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJv.package_name)) {
                                    PluginDownloadActivity.this.gJx.gJD.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gJx.gJD.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJv.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gJx, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.bDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gJv != null) {
            PluginPackageManager.nd().cb(this.gJv.package_name);
        }
        super.onDestroy();
    }
}
