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
    private PluginNetConfigInfos.PluginConfig iaW;
    private a iaZ;
    private boolean iba;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iaW = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iaW == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iaZ = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.iaZ.setCancelable(false);
        this.iaZ.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.iba) {
                    g.b(PluginDownloadActivity.this.iaZ, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iaZ.cKJ.getVisibility() == 0) {
                        PluginDownloadActivity.this.iaZ.cKJ.setVisibility(8);
                        PluginDownloadActivity.this.iaZ.ibc.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iaZ.cKJ.setVisibility(0);
                    PluginDownloadActivity.this.iaZ.ibc.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iaZ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iaZ, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iaZ.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cKJ;
        private TextView cOx;
        private TextView fsE;
        private LinearLayout ibc;
        private TextView ibd;
        private TextView ibe;
        private TextView ibf;
        private TextView ibg;
        private TextView ibh;
        private TextView ibi;
        private TextView ibj;
        private TextView ibk;

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
            this.ibc = (LinearLayout) findViewById(d.g.down_dialog);
            this.ibj = (TextView) findViewById(d.g.update_tip);
            this.ibd = (TextView) findViewById(d.g.newversion);
            this.fsE = (TextView) findViewById(d.g.desc);
            this.ibe = (TextView) findViewById(d.g.update_button);
            this.ibe.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.cOx = (TextView) findViewById(d.g.update_cancel);
            this.ibf = (TextView) findViewById(d.g.downloading);
            this.ibk = (TextView) findViewById(d.g.otherApp);
            this.ibk.setVisibility(8);
            this.ibg = (TextView) findViewById(d.g.app_size);
            this.cKJ = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.ibh = (TextView) findViewById(d.g.sure_cancel);
            this.ibi = (TextView) findViewById(d.g.cancel_button);
            this.ibh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.ibi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cKJ.setVisibility(8);
                    a.this.ibc.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaW.display_name)) {
                this.ibj.setText(PluginDownloadActivity.this.iaW.display_name);
            } else {
                this.ibj.setText("");
            }
            if (PluginDownloadActivity.this.iaW.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaW.newest.version)) {
                    this.ibd.setText("版本：" + PluginDownloadActivity.this.iaW.newest.version);
                } else {
                    this.ibd.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaW.newest.change_log)) {
                    this.fsE.setText(PluginDownloadActivity.this.iaW.newest.change_log);
                } else {
                    this.fsE.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iaW.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.ibg.setVisibility(0);
                    this.ibg.setText(((Object) this.ibg.getText()) + valueOf + "KB");
                } else {
                    this.ibg.setVisibility(8);
                }
            } else {
                this.ibd.setText("");
                this.fsE.setText("");
                this.ibg.setText("");
            }
            this.ibe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kY()) {
                        PluginDownloadActivity.this.iba = true;
                        a.this.ibe.setVisibility(8);
                        a.this.cOx.setVisibility(8);
                        a.this.ibf.setVisibility(0);
                        PluginPackageManager.ni().a(PluginDownloadActivity.this.iaW, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaW.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iaZ.ibf.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iaZ.ibf.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaW.package_name)) {
                                    PluginDownloadActivity.this.iaZ.ibf.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.iaZ.ibf.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaW.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iaZ, PluginDownloadActivity.this.getPageContext());
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
        if (this.iaW != null) {
            PluginPackageManager.ni().cb(this.iaW.package_name);
        }
        super.onDestroy();
    }
}
