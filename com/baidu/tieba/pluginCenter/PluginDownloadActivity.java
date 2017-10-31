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
    private boolean dlN;
    private PluginNetConfigInfos.PluginConfig fHc;
    private a fHe;
    private boolean fHf;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fHc = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fHc == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fHe = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.fHe.setCancelable(false);
        this.fHe.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fHf) {
                    g.b(PluginDownloadActivity.this.fHe, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fHe.aWW.getVisibility() == 0) {
                        PluginDownloadActivity.this.fHe.aWW.setVisibility(8);
                        PluginDownloadActivity.this.fHe.fHh.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fHe.aWW.setVisibility(0);
                    PluginDownloadActivity.this.fHe.fHh.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fHe.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fHe, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.fHe.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aWW;
        private TextView bbl;
        private TextView dNf;
        private TextView eoI;
        private LinearLayout fHh;
        private TextView fHi;
        private TextView fHj;
        private TextView fHk;
        private TextView fHl;
        private TextView fHm;
        private TextView fHn;
        private TextView fHo;

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
            this.fHh = (LinearLayout) findViewById(d.g.down_dialog);
            this.fHn = (TextView) findViewById(d.g.update_tip);
            this.fHi = (TextView) findViewById(d.g.newversion);
            this.dNf = (TextView) findViewById(d.g.desc);
            this.fHj = (TextView) findViewById(d.g.update_button);
            this.fHj.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bbl = (TextView) findViewById(d.g.update_cancel);
            this.eoI = (TextView) findViewById(d.g.downloading);
            this.fHo = (TextView) findViewById(d.g.otherApp);
            this.fHo.setVisibility(8);
            this.fHk = (TextView) findViewById(d.g.app_size);
            this.aWW = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fHl = (TextView) findViewById(d.g.sure_cancel);
            this.fHm = (TextView) findViewById(d.g.cancel_button);
            this.fHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fHm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aWW.setVisibility(8);
                    a.this.fHh.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fHc.display_name)) {
                this.fHn.setText(PluginDownloadActivity.this.fHc.display_name);
            } else {
                this.fHn.setText("");
            }
            if (PluginDownloadActivity.this.fHc.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fHc.newest.version)) {
                    this.fHi.setText("版本：" + PluginDownloadActivity.this.fHc.newest.version);
                } else {
                    this.fHi.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fHc.newest.change_log)) {
                    this.dNf.setText(PluginDownloadActivity.this.fHc.newest.change_log);
                } else {
                    this.dNf.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fHc.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fHk.setVisibility(0);
                    this.fHk.setText(((Object) this.fHk.getText()) + valueOf + "KB");
                } else {
                    this.fHk.setVisibility(8);
                }
            } else {
                this.fHi.setText("");
                this.dNf.setText("");
                this.fHk.setText("");
            }
            this.fHj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fHf = true;
                        a.this.fHj.setVisibility(8);
                        a.this.bbl.setVisibility(8);
                        a.this.eoI.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.fHc, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fHc.package_name) && !PluginDownloadActivity.this.dlN) {
                                    PluginDownloadActivity.this.fHe.eoI.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fHe.eoI.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fHc.package_name)) {
                                    PluginDownloadActivity.this.fHe.eoI.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.fHe.eoI.setEnabled(false);
                                    PluginDownloadActivity.this.dlN = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fHc.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dlN = true;
                                    g.b(PluginDownloadActivity.this.fHe, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bbl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fHc != null) {
            PluginPackageManager.js().bq(this.fHc.package_name);
        }
        super.onDestroy();
    }
}
