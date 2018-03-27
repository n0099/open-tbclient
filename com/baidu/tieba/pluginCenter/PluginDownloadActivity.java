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
    private PluginNetConfigInfos.PluginConfig gwL;
    private a gwN;
    private boolean gwO;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwL = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gwL == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gwN = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gwN.setCancelable(false);
        this.gwN.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gwO) {
                    g.b(PluginDownloadActivity.this.gwN, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gwN.bQm.getVisibility() == 0) {
                        PluginDownloadActivity.this.gwN.bQm.setVisibility(8);
                        PluginDownloadActivity.this.gwN.gwQ.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gwN.bQm.setVisibility(0);
                    PluginDownloadActivity.this.gwN.gwQ.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gwN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gwN, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.gwN.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bQm;
        private TextView bUd;
        private TextView eOz;
        private TextView fnl;
        private LinearLayout gwQ;
        private TextView gwR;
        private TextView gwS;
        private TextView gwT;
        private TextView gwU;
        private TextView gwV;
        private TextView gwW;
        private TextView gwX;

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
            this.gwQ = (LinearLayout) findViewById(d.g.down_dialog);
            this.gwW = (TextView) findViewById(d.g.update_tip);
            this.gwR = (TextView) findViewById(d.g.newversion);
            this.eOz = (TextView) findViewById(d.g.desc);
            this.gwS = (TextView) findViewById(d.g.update_button);
            this.gwS.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bUd = (TextView) findViewById(d.g.update_cancel);
            this.fnl = (TextView) findViewById(d.g.downloading);
            this.gwX = (TextView) findViewById(d.g.otherApp);
            this.gwX.setVisibility(8);
            this.gwT = (TextView) findViewById(d.g.app_size);
            this.bQm = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gwU = (TextView) findViewById(d.g.sure_cancel);
            this.gwV = (TextView) findViewById(d.g.cancel_button);
            this.gwU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gwV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQm.setVisibility(8);
                    a.this.gwQ.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwL.display_name)) {
                this.gwW.setText(PluginDownloadActivity.this.gwL.display_name);
            } else {
                this.gwW.setText("");
            }
            if (PluginDownloadActivity.this.gwL.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwL.newest.version)) {
                    this.gwR.setText("版本：" + PluginDownloadActivity.this.gwL.newest.version);
                } else {
                    this.gwR.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwL.newest.change_log)) {
                    this.eOz.setText(PluginDownloadActivity.this.gwL.newest.change_log);
                } else {
                    this.eOz.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gwL.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gwT.setVisibility(0);
                    this.gwT.setText(((Object) this.gwT.getText()) + valueOf + "KB");
                } else {
                    this.gwT.setVisibility(8);
                }
            } else {
                this.gwR.setText("");
                this.eOz.setText("");
                this.gwT.setText("");
            }
            this.gwS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        PluginDownloadActivity.this.gwO = true;
                        a.this.gwS.setVisibility(8);
                        a.this.bUd.setVisibility(8);
                        a.this.fnl.setVisibility(0);
                        PluginPackageManager.qS().a(PluginDownloadActivity.this.gwL, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwL.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gwN.fnl.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gwN.fnl.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwL.package_name)) {
                                    PluginDownloadActivity.this.gwN.fnl.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gwN.fnl.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwL.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gwN, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gwL != null) {
            PluginPackageManager.qS().by(this.gwL.package_name);
        }
        super.onDestroy();
    }
}
