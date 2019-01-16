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
    private PluginNetConfigInfos.PluginConfig gJu;
    private a gJw;
    private boolean gJx;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJu = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gJu == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gJw = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gJw.setCancelable(false);
        this.gJw.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gJx) {
                    g.b(PluginDownloadActivity.this.gJw, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gJw.bzC.getVisibility() == 0) {
                        PluginDownloadActivity.this.gJw.bzC.setVisibility(8);
                        PluginDownloadActivity.this.gJw.gJz.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gJw.bzC.setVisibility(0);
                    PluginDownloadActivity.this.gJw.gJz.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gJw.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gJw, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gJw.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private TextView bDp;
        private LinearLayout bzC;
        private TextView een;
        private TextView gJA;
        private TextView gJB;
        private TextView gJC;
        private TextView gJD;
        private TextView gJE;
        private TextView gJF;
        private TextView gJG;
        private TextView gJH;
        private LinearLayout gJz;

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
            this.gJz = (LinearLayout) findViewById(e.g.down_dialog);
            this.gJG = (TextView) findViewById(e.g.update_tip);
            this.gJA = (TextView) findViewById(e.g.newversion);
            this.een = (TextView) findViewById(e.g.desc);
            this.gJB = (TextView) findViewById(e.g.update_button);
            this.gJB.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.bDp = (TextView) findViewById(e.g.update_cancel);
            this.gJC = (TextView) findViewById(e.g.downloading);
            this.gJH = (TextView) findViewById(e.g.otherApp);
            this.gJH.setVisibility(8);
            this.gJD = (TextView) findViewById(e.g.app_size);
            this.bzC = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gJE = (TextView) findViewById(e.g.sure_cancel);
            this.gJF = (TextView) findViewById(e.g.cancel_button);
            this.gJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bzC.setVisibility(8);
                    a.this.gJz.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJu.display_name)) {
                this.gJG.setText(PluginDownloadActivity.this.gJu.display_name);
            } else {
                this.gJG.setText("");
            }
            if (PluginDownloadActivity.this.gJu.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJu.newest.version)) {
                    this.gJA.setText("版本：" + PluginDownloadActivity.this.gJu.newest.version);
                } else {
                    this.gJA.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gJu.newest.change_log)) {
                    this.een.setText(PluginDownloadActivity.this.gJu.newest.change_log);
                } else {
                    this.een.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gJu.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gJD.setVisibility(0);
                    this.gJD.setText(((Object) this.gJD.getText()) + valueOf + "KB");
                } else {
                    this.gJD.setVisibility(8);
                }
            } else {
                this.gJA.setText("");
                this.een.setText("");
                this.gJD.setText("");
            }
            this.gJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        PluginDownloadActivity.this.gJx = true;
                        a.this.gJB.setVisibility(8);
                        a.this.bDp.setVisibility(8);
                        a.this.gJC.setVisibility(0);
                        PluginPackageManager.nd().a(PluginDownloadActivity.this.gJu, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJu.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gJw.gJC.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gJw.gJC.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJu.package_name)) {
                                    PluginDownloadActivity.this.gJw.gJC.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gJw.gJC.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gJu.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gJw, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.bDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gJu != null) {
            PluginPackageManager.nd().cb(this.gJu.package_name);
        }
        super.onDestroy();
    }
}
