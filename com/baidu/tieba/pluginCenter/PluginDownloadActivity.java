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
    private PluginNetConfigInfos.PluginConfig fSA;
    private a fSC;
    private boolean fSD;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSA = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fSA == null) {
            showToast(getPageContext().getString(d.k.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fSC = new a(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.fSC.setCancelable(false);
        this.fSC.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fSD) {
                    g.b(PluginDownloadActivity.this.fSC, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fSC.baj.getVisibility() == 0) {
                        PluginDownloadActivity.this.fSC.baj.setVisibility(8);
                        PluginDownloadActivity.this.fSC.fSF.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fSC.baj.setVisibility(0);
                    PluginDownloadActivity.this.fSC.fSF.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fSC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fSC, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.fSC.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout baj;
        private TextView bei;
        private TextView eIT;
        private TextView ekj;
        private LinearLayout fSF;
        private TextView fSG;
        private TextView fSH;
        private TextView fSI;
        private TextView fSJ;
        private TextView fSK;
        private TextView fSL;
        private TextView fSM;

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
            this.fSF = (LinearLayout) findViewById(d.g.down_dialog);
            this.fSL = (TextView) findViewById(d.g.update_tip);
            this.fSG = (TextView) findViewById(d.g.newversion);
            this.ekj = (TextView) findViewById(d.g.desc);
            this.fSH = (TextView) findViewById(d.g.update_button);
            this.fSH.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.install_app));
            this.bei = (TextView) findViewById(d.g.update_cancel);
            this.eIT = (TextView) findViewById(d.g.downloading);
            this.fSM = (TextView) findViewById(d.g.otherApp);
            this.fSM.setVisibility(8);
            this.fSI = (TextView) findViewById(d.g.app_size);
            this.baj = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fSJ = (TextView) findViewById(d.g.sure_cancel);
            this.fSK = (TextView) findViewById(d.g.cancel_button);
            this.fSJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fSK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.baj.setVisibility(8);
                    a.this.fSF.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fSA.display_name)) {
                this.fSL.setText(PluginDownloadActivity.this.fSA.display_name);
            } else {
                this.fSL.setText("");
            }
            if (PluginDownloadActivity.this.fSA.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fSA.newest.version)) {
                    this.fSG.setText("版本：" + PluginDownloadActivity.this.fSA.newest.version);
                } else {
                    this.fSG.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fSA.newest.change_log)) {
                    this.ekj.setText(PluginDownloadActivity.this.fSA.newest.change_log);
                } else {
                    this.ekj.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fSA.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fSI.setVisibility(0);
                    this.fSI.setText(((Object) this.fSI.getText()) + valueOf + "KB");
                } else {
                    this.fSI.setVisibility(8);
                }
            } else {
                this.fSG.setText("");
                this.ekj.setText("");
                this.fSI.setText("");
            }
            this.fSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (j.gP()) {
                        PluginDownloadActivity.this.fSD = true;
                        a.this.fSH.setVisibility(8);
                        a.this.bei.setVisibility(8);
                        a.this.eIT.setVisibility(0);
                        PluginPackageManager.iX().a(PluginDownloadActivity.this.fSA, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fSA.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.fSC.eIT.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fSC.eIT.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fSA.package_name)) {
                                    PluginDownloadActivity.this.fSC.eIT.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                                    PluginDownloadActivity.this.fSC.eIT.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fSA.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.fSC, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.k.neterror);
                }
            });
            this.bei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fSA != null) {
            PluginPackageManager.iX().bv(this.fSA.package_name);
        }
        super.onDestroy();
    }
}
