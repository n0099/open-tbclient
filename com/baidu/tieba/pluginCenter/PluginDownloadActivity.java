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
    private PluginNetConfigInfos.PluginConfig gxi;
    private a gxk;
    private boolean gxl;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxi = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gxi == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gxk = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gxk.setCancelable(false);
        this.gxk.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gxl) {
                    g.b(PluginDownloadActivity.this.gxk, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gxk.buD.getVisibility() == 0) {
                        PluginDownloadActivity.this.gxk.buD.setVisibility(8);
                        PluginDownloadActivity.this.gxk.gxn.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gxk.buD.setVisibility(0);
                    PluginDownloadActivity.this.gxk.gxn.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gxk.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gxk, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gxk.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private LinearLayout buD;
        private TextView byr;
        private TextView dTh;
        private LinearLayout gxn;
        private TextView gxo;
        private TextView gxp;
        private TextView gxq;
        private TextView gxr;
        private TextView gxs;
        private TextView gxt;
        private TextView gxu;
        private TextView gxv;

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
            this.gxn = (LinearLayout) findViewById(e.g.down_dialog);
            this.gxu = (TextView) findViewById(e.g.update_tip);
            this.gxo = (TextView) findViewById(e.g.newversion);
            this.dTh = (TextView) findViewById(e.g.desc);
            this.gxp = (TextView) findViewById(e.g.update_button);
            this.gxp.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.byr = (TextView) findViewById(e.g.update_cancel);
            this.gxq = (TextView) findViewById(e.g.downloading);
            this.gxv = (TextView) findViewById(e.g.otherApp);
            this.gxv.setVisibility(8);
            this.gxr = (TextView) findViewById(e.g.app_size);
            this.buD = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gxs = (TextView) findViewById(e.g.sure_cancel);
            this.gxt = (TextView) findViewById(e.g.cancel_button);
            this.gxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gxt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.buD.setVisibility(8);
                    a.this.gxn.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxi.display_name)) {
                this.gxu.setText(PluginDownloadActivity.this.gxi.display_name);
            } else {
                this.gxu.setText("");
            }
            if (PluginDownloadActivity.this.gxi.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxi.newest.version)) {
                    this.gxo.setText("版本：" + PluginDownloadActivity.this.gxi.newest.version);
                } else {
                    this.gxo.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxi.newest.change_log)) {
                    this.dTh.setText(PluginDownloadActivity.this.gxi.newest.change_log);
                } else {
                    this.dTh.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gxi.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gxr.setVisibility(0);
                    this.gxr.setText(((Object) this.gxr.getText()) + valueOf + "KB");
                } else {
                    this.gxr.setVisibility(8);
                }
            } else {
                this.gxo.setText("");
                this.dTh.setText("");
                this.gxr.setText("");
            }
            this.gxp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kX()) {
                        PluginDownloadActivity.this.gxl = true;
                        a.this.gxp.setVisibility(8);
                        a.this.byr.setVisibility(8);
                        a.this.gxq.setVisibility(0);
                        PluginPackageManager.nd().a(PluginDownloadActivity.this.gxi, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxi.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gxk.gxq.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gxk.gxq.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxi.package_name)) {
                                    PluginDownloadActivity.this.gxk.gxq.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gxk.gxq.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxi.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gxk, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.byr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gxi != null) {
            PluginPackageManager.nd().ca(this.gxi.package_name);
        }
        super.onDestroy();
    }
}
