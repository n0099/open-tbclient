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
import com.baidu.adp.lib.util.i;
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
    private PluginNetConfigInfos.PluginConfig fCL;
    private a fCN;
    private boolean fCO;
    private boolean lh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCL = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fCL == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fCN = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fCN.setCancelable(false);
        this.fCN.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fCO) {
                    g.b(PluginDownloadActivity.this.fCN, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fCN.aVz.getVisibility() == 0) {
                        PluginDownloadActivity.this.fCN.aVz.setVisibility(8);
                        PluginDownloadActivity.this.fCN.fCQ.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fCN.aVz.setVisibility(0);
                    PluginDownloadActivity.this.fCN.fCQ.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fCN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fCN, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fCN.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aVz;
        private TextView aZx;
        private TextView edz;
        private LinearLayout fCQ;
        private TextView fCR;
        private TextView fCS;
        private TextView fCT;
        private TextView fCU;
        private TextView fCV;
        private TextView fCW;
        private TextView fCX;
        private TextView mDesc;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.j.update_dialog);
            findViewById(d.h.warning).setVisibility(8);
            findViewById(d.h.incremental_button).setVisibility(8);
            findViewById(d.h.incremental_size).setVisibility(8);
            this.fCQ = (LinearLayout) findViewById(d.h.down_dialog);
            this.fCW = (TextView) findViewById(d.h.update_tip);
            this.fCR = (TextView) findViewById(d.h.newversion);
            this.mDesc = (TextView) findViewById(d.h.desc);
            this.fCS = (TextView) findViewById(d.h.update_button);
            this.fCS.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aZx = (TextView) findViewById(d.h.update_cancel);
            this.edz = (TextView) findViewById(d.h.downloading);
            this.fCX = (TextView) findViewById(d.h.otherApp);
            this.fCX.setVisibility(8);
            this.fCT = (TextView) findViewById(d.h.app_size);
            this.aVz = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fCU = (TextView) findViewById(d.h.sure_cancel);
            this.fCV = (TextView) findViewById(d.h.cancel_button);
            this.fCU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fCV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aVz.setVisibility(8);
                    a.this.fCQ.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCL.display_name)) {
                this.fCW.setText(PluginDownloadActivity.this.fCL.display_name);
            } else {
                this.fCW.setText("");
            }
            if (PluginDownloadActivity.this.fCL.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCL.newest.version)) {
                    this.fCR.setText("版本：" + PluginDownloadActivity.this.fCL.newest.version);
                } else {
                    this.fCR.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCL.newest.change_log)) {
                    this.mDesc.setText(PluginDownloadActivity.this.fCL.newest.change_log);
                } else {
                    this.mDesc.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fCL.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fCT.setVisibility(0);
                    this.fCT.setText(((Object) this.fCT.getText()) + valueOf + "KB");
                } else {
                    this.fCT.setVisibility(8);
                }
            } else {
                this.fCR.setText("");
                this.mDesc.setText("");
                this.fCT.setText("");
            }
            this.fCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hr()) {
                        PluginDownloadActivity.this.fCO = true;
                        a.this.fCS.setVisibility(8);
                        a.this.aZx.setVisibility(8);
                        a.this.edz.setVisibility(0);
                        PluginPackageManager.jE().a(PluginDownloadActivity.this.fCL, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCL.package_name) && !PluginDownloadActivity.this.lh) {
                                    PluginDownloadActivity.this.fCN.edz.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fCN.edz.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCL.package_name)) {
                                    PluginDownloadActivity.this.fCN.edz.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fCN.edz.setEnabled(false);
                                    PluginDownloadActivity.this.lh = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCL.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.lh = true;
                                    g.b(PluginDownloadActivity.this.fCN, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fCL != null) {
            PluginPackageManager.jE().bu(this.fCL.package_name);
        }
        super.onDestroy();
    }
}
