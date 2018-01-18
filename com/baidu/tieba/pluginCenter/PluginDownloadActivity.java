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
    private PluginNetConfigInfos.PluginConfig guG;
    private a guI;
    private boolean guJ;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.guG = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.guG == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.guI = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.guI.setCancelable(false);
        this.guI.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.guJ) {
                    g.b(PluginDownloadActivity.this.guI, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.guI.bOg.getVisibility() == 0) {
                        PluginDownloadActivity.this.guI.bOg.setVisibility(8);
                        PluginDownloadActivity.this.guI.guL.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.guI.bOg.setVisibility(0);
                    PluginDownloadActivity.this.guI.guL.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.guI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.guI, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.guI.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bOg;
        private TextView bRY;
        private TextView eJL;
        private TextView fjl;
        private LinearLayout guL;
        private TextView guM;
        private TextView guN;
        private TextView guO;
        private TextView guP;
        private TextView guQ;
        private TextView guR;
        private TextView guS;

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
            this.guL = (LinearLayout) findViewById(d.g.down_dialog);
            this.guR = (TextView) findViewById(d.g.update_tip);
            this.guM = (TextView) findViewById(d.g.newversion);
            this.eJL = (TextView) findViewById(d.g.desc);
            this.guN = (TextView) findViewById(d.g.update_button);
            this.guN.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bRY = (TextView) findViewById(d.g.update_cancel);
            this.fjl = (TextView) findViewById(d.g.downloading);
            this.guS = (TextView) findViewById(d.g.otherApp);
            this.guS.setVisibility(8);
            this.guO = (TextView) findViewById(d.g.app_size);
            this.bOg = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.guP = (TextView) findViewById(d.g.sure_cancel);
            this.guQ = (TextView) findViewById(d.g.cancel_button);
            this.guP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.guQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOg.setVisibility(8);
                    a.this.guL.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.guG.display_name)) {
                this.guR.setText(PluginDownloadActivity.this.guG.display_name);
            } else {
                this.guR.setText("");
            }
            if (PluginDownloadActivity.this.guG.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.guG.newest.version)) {
                    this.guM.setText("版本：" + PluginDownloadActivity.this.guG.newest.version);
                } else {
                    this.guM.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.guG.newest.change_log)) {
                    this.eJL.setText(PluginDownloadActivity.this.guG.newest.change_log);
                } else {
                    this.eJL.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.guG.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.guO.setVisibility(0);
                    this.guO.setText(((Object) this.guO.getText()) + valueOf + "KB");
                } else {
                    this.guO.setVisibility(8);
                }
            } else {
                this.guM.setText("");
                this.eJL.setText("");
                this.guO.setText("");
            }
            this.guN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oI()) {
                        PluginDownloadActivity.this.guJ = true;
                        a.this.guN.setVisibility(8);
                        a.this.bRY.setVisibility(8);
                        a.this.fjl.setVisibility(0);
                        PluginPackageManager.qR().a(PluginDownloadActivity.this.guG, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.guG.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.guI.fjl.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.guI.fjl.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.guG.package_name)) {
                                    PluginDownloadActivity.this.guI.fjl.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.guI.fjl.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.guG.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.guI, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.guG != null) {
            PluginPackageManager.qR().by(this.guG.package_name);
        }
        super.onDestroy();
    }
}
