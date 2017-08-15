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
    private PluginNetConfigInfos.PluginConfig fCJ;
    private a fCL;
    private boolean fCM;
    private boolean lh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCJ = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fCJ == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fCL = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fCL.setCancelable(false);
        this.fCL.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fCM) {
                    g.b(PluginDownloadActivity.this.fCL, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fCL.aVy.getVisibility() == 0) {
                        PluginDownloadActivity.this.fCL.aVy.setVisibility(8);
                        PluginDownloadActivity.this.fCL.fCO.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fCL.aVy.setVisibility(0);
                    PluginDownloadActivity.this.fCL.fCO.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fCL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fCL, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fCL.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aVy;
        private TextView aZw;
        private TextView edz;
        private LinearLayout fCO;
        private TextView fCP;
        private TextView fCQ;
        private TextView fCR;
        private TextView fCS;
        private TextView fCT;
        private TextView fCU;
        private TextView fCV;
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
            this.fCO = (LinearLayout) findViewById(d.h.down_dialog);
            this.fCU = (TextView) findViewById(d.h.update_tip);
            this.fCP = (TextView) findViewById(d.h.newversion);
            this.mDesc = (TextView) findViewById(d.h.desc);
            this.fCQ = (TextView) findViewById(d.h.update_button);
            this.fCQ.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aZw = (TextView) findViewById(d.h.update_cancel);
            this.edz = (TextView) findViewById(d.h.downloading);
            this.fCV = (TextView) findViewById(d.h.otherApp);
            this.fCV.setVisibility(8);
            this.fCR = (TextView) findViewById(d.h.app_size);
            this.aVy = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fCS = (TextView) findViewById(d.h.sure_cancel);
            this.fCT = (TextView) findViewById(d.h.cancel_button);
            this.fCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fCT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aVy.setVisibility(8);
                    a.this.fCO.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCJ.display_name)) {
                this.fCU.setText(PluginDownloadActivity.this.fCJ.display_name);
            } else {
                this.fCU.setText("");
            }
            if (PluginDownloadActivity.this.fCJ.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCJ.newest.version)) {
                    this.fCP.setText("版本：" + PluginDownloadActivity.this.fCJ.newest.version);
                } else {
                    this.fCP.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCJ.newest.change_log)) {
                    this.mDesc.setText(PluginDownloadActivity.this.fCJ.newest.change_log);
                } else {
                    this.mDesc.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fCJ.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fCR.setVisibility(0);
                    this.fCR.setText(((Object) this.fCR.getText()) + valueOf + "KB");
                } else {
                    this.fCR.setVisibility(8);
                }
            } else {
                this.fCP.setText("");
                this.mDesc.setText("");
                this.fCR.setText("");
            }
            this.fCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hr()) {
                        PluginDownloadActivity.this.fCM = true;
                        a.this.fCQ.setVisibility(8);
                        a.this.aZw.setVisibility(8);
                        a.this.edz.setVisibility(0);
                        PluginPackageManager.jE().a(PluginDownloadActivity.this.fCJ, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCJ.package_name) && !PluginDownloadActivity.this.lh) {
                                    PluginDownloadActivity.this.fCL.edz.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fCL.edz.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCJ.package_name)) {
                                    PluginDownloadActivity.this.fCL.edz.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fCL.edz.setEnabled(false);
                                    PluginDownloadActivity.this.lh = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCJ.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.lh = true;
                                    g.b(PluginDownloadActivity.this.fCL, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aZw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fCJ != null) {
            PluginPackageManager.jE().bt(this.fCJ.package_name);
        }
        super.onDestroy();
    }
}
