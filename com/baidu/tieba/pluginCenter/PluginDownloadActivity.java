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
    private PluginNetConfigInfos.PluginConfig gwG;
    private a gwI;
    private boolean gwJ;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwG = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gwG == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gwI = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gwI.setCancelable(false);
        this.gwI.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gwJ) {
                    g.b(PluginDownloadActivity.this.gwI, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gwI.bQw.getVisibility() == 0) {
                        PluginDownloadActivity.this.gwI.bQw.setVisibility(8);
                        PluginDownloadActivity.this.gwI.gwL.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gwI.bQw.setVisibility(0);
                    PluginDownloadActivity.this.gwI.gwL.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gwI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gwI, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.gwI.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bQw;
        private TextView bUm;
        private TextView eOv;
        private TextView fnh;
        private LinearLayout gwL;
        private TextView gwM;
        private TextView gwN;
        private TextView gwO;
        private TextView gwP;
        private TextView gwQ;
        private TextView gwR;
        private TextView gwS;

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
            this.gwL = (LinearLayout) findViewById(d.g.down_dialog);
            this.gwR = (TextView) findViewById(d.g.update_tip);
            this.gwM = (TextView) findViewById(d.g.newversion);
            this.eOv = (TextView) findViewById(d.g.desc);
            this.gwN = (TextView) findViewById(d.g.update_button);
            this.gwN.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bUm = (TextView) findViewById(d.g.update_cancel);
            this.fnh = (TextView) findViewById(d.g.downloading);
            this.gwS = (TextView) findViewById(d.g.otherApp);
            this.gwS.setVisibility(8);
            this.gwO = (TextView) findViewById(d.g.app_size);
            this.bQw = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gwP = (TextView) findViewById(d.g.sure_cancel);
            this.gwQ = (TextView) findViewById(d.g.cancel_button);
            this.gwP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQw.setVisibility(8);
                    a.this.gwL.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwG.display_name)) {
                this.gwR.setText(PluginDownloadActivity.this.gwG.display_name);
            } else {
                this.gwR.setText("");
            }
            if (PluginDownloadActivity.this.gwG.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwG.newest.version)) {
                    this.gwM.setText("版本：" + PluginDownloadActivity.this.gwG.newest.version);
                } else {
                    this.gwM.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwG.newest.change_log)) {
                    this.eOv.setText(PluginDownloadActivity.this.gwG.newest.change_log);
                } else {
                    this.eOv.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gwG.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gwO.setVisibility(0);
                    this.gwO.setText(((Object) this.gwO.getText()) + valueOf + "KB");
                } else {
                    this.gwO.setVisibility(8);
                }
            } else {
                this.gwM.setText("");
                this.eOv.setText("");
                this.gwO.setText("");
            }
            this.gwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        PluginDownloadActivity.this.gwJ = true;
                        a.this.gwN.setVisibility(8);
                        a.this.bUm.setVisibility(8);
                        a.this.fnh.setVisibility(0);
                        PluginPackageManager.qS().a(PluginDownloadActivity.this.gwG, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwG.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gwI.fnh.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gwI.fnh.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwG.package_name)) {
                                    PluginDownloadActivity.this.gwI.fnh.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gwI.fnh.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwG.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gwI, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gwG != null) {
            PluginPackageManager.qS().by(this.gwG.package_name);
        }
        super.onDestroy();
    }
}
