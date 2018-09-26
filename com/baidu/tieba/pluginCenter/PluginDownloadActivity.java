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
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig gpG;
    private a gpI;
    private boolean gpJ;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gpG = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gpG == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gpI = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gpI.setCancelable(false);
        this.gpI.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gpJ) {
                    g.b(PluginDownloadActivity.this.gpI, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gpI.bqu.getVisibility() == 0) {
                        PluginDownloadActivity.this.gpI.bqu.setVisibility(8);
                        PluginDownloadActivity.this.gpI.gpL.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gpI.bqu.setVisibility(0);
                    PluginDownloadActivity.this.gpI.gpL.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gpI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gpI, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gpI.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bqu;
        private TextView buo;
        private TextView dLk;
        private LinearLayout gpL;
        private TextView gpM;
        private TextView gpN;
        private TextView gpO;
        private TextView gpP;
        private TextView gpQ;
        private TextView gpR;
        private TextView gpS;
        private TextView gpT;

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
            this.gpL = (LinearLayout) findViewById(e.g.down_dialog);
            this.gpS = (TextView) findViewById(e.g.update_tip);
            this.gpM = (TextView) findViewById(e.g.newversion);
            this.dLk = (TextView) findViewById(e.g.desc);
            this.gpN = (TextView) findViewById(e.g.update_button);
            this.gpN.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.buo = (TextView) findViewById(e.g.update_cancel);
            this.gpO = (TextView) findViewById(e.g.downloading);
            this.gpT = (TextView) findViewById(e.g.otherApp);
            this.gpT.setVisibility(8);
            this.gpP = (TextView) findViewById(e.g.app_size);
            this.bqu = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gpQ = (TextView) findViewById(e.g.sure_cancel);
            this.gpR = (TextView) findViewById(e.g.cancel_button);
            this.gpQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gpR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bqu.setVisibility(8);
                    a.this.gpL.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gpG.display_name)) {
                this.gpS.setText(PluginDownloadActivity.this.gpG.display_name);
            } else {
                this.gpS.setText("");
            }
            if (PluginDownloadActivity.this.gpG.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gpG.newest.version)) {
                    this.gpM.setText("版本：" + PluginDownloadActivity.this.gpG.newest.version);
                } else {
                    this.gpM.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gpG.newest.change_log)) {
                    this.dLk.setText(PluginDownloadActivity.this.gpG.newest.change_log);
                } else {
                    this.dLk.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gpG.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gpP.setVisibility(0);
                    this.gpP.setText(((Object) this.gpP.getText()) + valueOf + "KB");
                } else {
                    this.gpP.setVisibility(8);
                }
            } else {
                this.gpM.setText("");
                this.dLk.setText("");
                this.gpP.setText("");
            }
            this.gpN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kK()) {
                        PluginDownloadActivity.this.gpJ = true;
                        a.this.gpN.setVisibility(8);
                        a.this.buo.setVisibility(8);
                        a.this.gpO.setVisibility(0);
                        PluginPackageManager.mT().a(PluginDownloadActivity.this.gpG, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gpG.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gpI.gpO.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gpI.gpO.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gpG.package_name)) {
                                    PluginDownloadActivity.this.gpI.gpO.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gpI.gpO.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gpG.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gpI, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.buo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gpG != null) {
            PluginPackageManager.mT().cb(this.gpG.package_name);
        }
        super.onDestroy();
    }
}
