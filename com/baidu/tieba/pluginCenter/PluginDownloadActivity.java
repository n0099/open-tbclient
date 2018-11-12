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
    private PluginNetConfigInfos.PluginConfig gyJ;
    private a gyL;
    private boolean gyM;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyJ = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gyJ == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gyL = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gyL.setCancelable(false);
        this.gyL.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gyM) {
                    g.b(PluginDownloadActivity.this.gyL, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gyL.bvo.getVisibility() == 0) {
                        PluginDownloadActivity.this.gyL.bvo.setVisibility(8);
                        PluginDownloadActivity.this.gyL.gyO.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gyL.bvo.setVisibility(0);
                    PluginDownloadActivity.this.gyL.gyO.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gyL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gyL, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gyL.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private LinearLayout bvo;
        private TextView bzc;
        private TextView dUn;
        private LinearLayout gyO;
        private TextView gyP;
        private TextView gyQ;
        private TextView gyR;
        private TextView gyS;
        private TextView gyT;
        private TextView gyU;
        private TextView gyV;
        private TextView gyW;

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
            this.gyO = (LinearLayout) findViewById(e.g.down_dialog);
            this.gyV = (TextView) findViewById(e.g.update_tip);
            this.gyP = (TextView) findViewById(e.g.newversion);
            this.dUn = (TextView) findViewById(e.g.desc);
            this.gyQ = (TextView) findViewById(e.g.update_button);
            this.gyQ.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.bzc = (TextView) findViewById(e.g.update_cancel);
            this.gyR = (TextView) findViewById(e.g.downloading);
            this.gyW = (TextView) findViewById(e.g.otherApp);
            this.gyW.setVisibility(8);
            this.gyS = (TextView) findViewById(e.g.app_size);
            this.bvo = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gyT = (TextView) findViewById(e.g.sure_cancel);
            this.gyU = (TextView) findViewById(e.g.cancel_button);
            this.gyT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gyU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bvo.setVisibility(8);
                    a.this.gyO.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gyJ.display_name)) {
                this.gyV.setText(PluginDownloadActivity.this.gyJ.display_name);
            } else {
                this.gyV.setText("");
            }
            if (PluginDownloadActivity.this.gyJ.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gyJ.newest.version)) {
                    this.gyP.setText("版本：" + PluginDownloadActivity.this.gyJ.newest.version);
                } else {
                    this.gyP.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gyJ.newest.change_log)) {
                    this.dUn.setText(PluginDownloadActivity.this.gyJ.newest.change_log);
                } else {
                    this.dUn.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gyJ.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gyS.setVisibility(0);
                    this.gyS.setText(((Object) this.gyS.getText()) + valueOf + "KB");
                } else {
                    this.gyS.setVisibility(8);
                }
            } else {
                this.gyP.setText("");
                this.dUn.setText("");
                this.gyS.setText("");
            }
            this.gyQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        PluginDownloadActivity.this.gyM = true;
                        a.this.gyQ.setVisibility(8);
                        a.this.bzc.setVisibility(8);
                        a.this.gyR.setVisibility(0);
                        PluginPackageManager.nb().a(PluginDownloadActivity.this.gyJ, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gyJ.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gyL.gyR.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gyL.gyR.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gyJ.package_name)) {
                                    PluginDownloadActivity.this.gyL.gyR.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gyL.gyR.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gyJ.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gyL, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.bzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gyJ != null) {
            PluginPackageManager.nb().ca(this.gyJ.package_name);
        }
        super.onDestroy();
    }
}
