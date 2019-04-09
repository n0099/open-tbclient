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
    private PluginNetConfigInfos.PluginConfig iaE;
    private a iaH;
    private boolean iaI;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iaE = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iaE == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iaH = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.iaH.setCancelable(false);
        this.iaH.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.iaI) {
                    g.b(PluginDownloadActivity.this.iaH, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iaH.cKJ.getVisibility() == 0) {
                        PluginDownloadActivity.this.iaH.cKJ.setVisibility(8);
                        PluginDownloadActivity.this.iaH.iaK.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iaH.cKJ.setVisibility(0);
                    PluginDownloadActivity.this.iaH.iaK.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iaH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iaH, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iaH.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cKJ;
        private TextView cOx;
        private TextView fsp;
        private LinearLayout iaK;
        private TextView iaL;
        private TextView iaM;
        private TextView iaN;
        private TextView iaO;
        private TextView iaP;
        private TextView iaQ;
        private TextView iaR;
        private TextView iaS;

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
            this.iaK = (LinearLayout) findViewById(d.g.down_dialog);
            this.iaR = (TextView) findViewById(d.g.update_tip);
            this.iaL = (TextView) findViewById(d.g.newversion);
            this.fsp = (TextView) findViewById(d.g.desc);
            this.iaM = (TextView) findViewById(d.g.update_button);
            this.iaM.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.cOx = (TextView) findViewById(d.g.update_cancel);
            this.iaN = (TextView) findViewById(d.g.downloading);
            this.iaS = (TextView) findViewById(d.g.otherApp);
            this.iaS.setVisibility(8);
            this.iaO = (TextView) findViewById(d.g.app_size);
            this.cKJ = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.iaP = (TextView) findViewById(d.g.sure_cancel);
            this.iaQ = (TextView) findViewById(d.g.cancel_button);
            this.iaP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iaQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cKJ.setVisibility(8);
                    a.this.iaK.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaE.display_name)) {
                this.iaR.setText(PluginDownloadActivity.this.iaE.display_name);
            } else {
                this.iaR.setText("");
            }
            if (PluginDownloadActivity.this.iaE.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaE.newest.version)) {
                    this.iaL.setText("版本：" + PluginDownloadActivity.this.iaE.newest.version);
                } else {
                    this.iaL.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaE.newest.change_log)) {
                    this.fsp.setText(PluginDownloadActivity.this.iaE.newest.change_log);
                } else {
                    this.fsp.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iaE.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iaO.setVisibility(0);
                    this.iaO.setText(((Object) this.iaO.getText()) + valueOf + "KB");
                } else {
                    this.iaO.setVisibility(8);
                }
            } else {
                this.iaL.setText("");
                this.fsp.setText("");
                this.iaO.setText("");
            }
            this.iaM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kY()) {
                        PluginDownloadActivity.this.iaI = true;
                        a.this.iaM.setVisibility(8);
                        a.this.cOx.setVisibility(8);
                        a.this.iaN.setVisibility(0);
                        PluginPackageManager.ni().a(PluginDownloadActivity.this.iaE, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaE.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iaH.iaN.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iaH.iaN.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaE.package_name)) {
                                    PluginDownloadActivity.this.iaH.iaN.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.iaH.iaN.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaE.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iaH, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.cOx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.iaE != null) {
            PluginPackageManager.ni().cb(this.iaE.package_name);
        }
        super.onDestroy();
    }
}
