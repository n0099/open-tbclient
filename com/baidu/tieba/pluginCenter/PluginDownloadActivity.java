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
    private boolean fRA;
    private PluginNetConfigInfos.PluginConfig fRx;
    private a fRz;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fRx = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fRx == null) {
            showToast(getPageContext().getString(d.k.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fRz = new a(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.fRz.setCancelable(false);
        this.fRz.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fRA) {
                    g.b(PluginDownloadActivity.this.fRz, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fRz.bai.getVisibility() == 0) {
                        PluginDownloadActivity.this.fRz.bai.setVisibility(8);
                        PluginDownloadActivity.this.fRz.fRC.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fRz.bai.setVisibility(0);
                    PluginDownloadActivity.this.fRz.fRC.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fRz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fRz, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.fRz.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bai;
        private TextView beh;
        private TextView eHO;
        private TextView ejf;
        private LinearLayout fRC;
        private TextView fRD;
        private TextView fRE;
        private TextView fRF;
        private TextView fRG;
        private TextView fRH;
        private TextView fRI;
        private TextView fRJ;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.i.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.fRC = (LinearLayout) findViewById(d.g.down_dialog);
            this.fRI = (TextView) findViewById(d.g.update_tip);
            this.fRD = (TextView) findViewById(d.g.newversion);
            this.ejf = (TextView) findViewById(d.g.desc);
            this.fRE = (TextView) findViewById(d.g.update_button);
            this.fRE.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.install_app));
            this.beh = (TextView) findViewById(d.g.update_cancel);
            this.eHO = (TextView) findViewById(d.g.downloading);
            this.fRJ = (TextView) findViewById(d.g.otherApp);
            this.fRJ.setVisibility(8);
            this.fRF = (TextView) findViewById(d.g.app_size);
            this.bai = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fRG = (TextView) findViewById(d.g.sure_cancel);
            this.fRH = (TextView) findViewById(d.g.cancel_button);
            this.fRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fRH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.bai.setVisibility(8);
                    a.this.fRC.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRx.display_name)) {
                this.fRI.setText(PluginDownloadActivity.this.fRx.display_name);
            } else {
                this.fRI.setText("");
            }
            if (PluginDownloadActivity.this.fRx.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRx.newest.version)) {
                    this.fRD.setText("版本：" + PluginDownloadActivity.this.fRx.newest.version);
                } else {
                    this.fRD.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fRx.newest.change_log)) {
                    this.ejf.setText(PluginDownloadActivity.this.fRx.newest.change_log);
                } else {
                    this.ejf.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fRx.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fRF.setVisibility(0);
                    this.fRF.setText(((Object) this.fRF.getText()) + valueOf + "KB");
                } else {
                    this.fRF.setVisibility(8);
                }
            } else {
                this.fRD.setText("");
                this.ejf.setText("");
                this.fRF.setText("");
            }
            this.fRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (j.gP()) {
                        PluginDownloadActivity.this.fRA = true;
                        a.this.fRE.setVisibility(8);
                        a.this.beh.setVisibility(8);
                        a.this.eHO.setVisibility(0);
                        PluginPackageManager.iX().a(PluginDownloadActivity.this.fRx, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRx.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.fRz.eHO.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fRz.eHO.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRx.package_name)) {
                                    PluginDownloadActivity.this.fRz.eHO.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                                    PluginDownloadActivity.this.fRz.eHO.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fRx.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.fRz, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.k.neterror);
                }
            });
            this.beh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
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
        if (this.fRx != null) {
            PluginPackageManager.iX().bv(this.fRx.package_name);
        }
        super.onDestroy();
    }
}
