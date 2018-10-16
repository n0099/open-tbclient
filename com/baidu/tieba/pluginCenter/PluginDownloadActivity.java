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
    private PluginNetConfigInfos.PluginConfig gxh;
    private a gxj;
    private boolean gxk;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gxh = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gxh == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gxj = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gxj.setCancelable(false);
        this.gxj.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gxk) {
                    g.b(PluginDownloadActivity.this.gxj, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gxj.buD.getVisibility() == 0) {
                        PluginDownloadActivity.this.gxj.buD.setVisibility(8);
                        PluginDownloadActivity.this.gxj.gxm.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gxj.buD.setVisibility(0);
                    PluginDownloadActivity.this.gxj.gxm.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gxj.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gxj, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gxj.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private LinearLayout buD;
        private TextView byr;
        private TextView dTg;
        private LinearLayout gxm;
        private TextView gxn;
        private TextView gxo;
        private TextView gxp;
        private TextView gxq;
        private TextView gxr;
        private TextView gxs;
        private TextView gxt;
        private TextView gxu;

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
            this.gxm = (LinearLayout) findViewById(e.g.down_dialog);
            this.gxt = (TextView) findViewById(e.g.update_tip);
            this.gxn = (TextView) findViewById(e.g.newversion);
            this.dTg = (TextView) findViewById(e.g.desc);
            this.gxo = (TextView) findViewById(e.g.update_button);
            this.gxo.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.byr = (TextView) findViewById(e.g.update_cancel);
            this.gxp = (TextView) findViewById(e.g.downloading);
            this.gxu = (TextView) findViewById(e.g.otherApp);
            this.gxu.setVisibility(8);
            this.gxq = (TextView) findViewById(e.g.app_size);
            this.buD = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gxr = (TextView) findViewById(e.g.sure_cancel);
            this.gxs = (TextView) findViewById(e.g.cancel_button);
            this.gxr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.buD.setVisibility(8);
                    a.this.gxm.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxh.display_name)) {
                this.gxt.setText(PluginDownloadActivity.this.gxh.display_name);
            } else {
                this.gxt.setText("");
            }
            if (PluginDownloadActivity.this.gxh.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxh.newest.version)) {
                    this.gxn.setText("版本：" + PluginDownloadActivity.this.gxh.newest.version);
                } else {
                    this.gxn.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gxh.newest.change_log)) {
                    this.dTg.setText(PluginDownloadActivity.this.gxh.newest.change_log);
                } else {
                    this.dTg.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gxh.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gxq.setVisibility(0);
                    this.gxq.setText(((Object) this.gxq.getText()) + valueOf + "KB");
                } else {
                    this.gxq.setVisibility(8);
                }
            } else {
                this.gxn.setText("");
                this.dTg.setText("");
                this.gxq.setText("");
            }
            this.gxo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kX()) {
                        PluginDownloadActivity.this.gxk = true;
                        a.this.gxo.setVisibility(8);
                        a.this.byr.setVisibility(8);
                        a.this.gxp.setVisibility(0);
                        PluginPackageManager.nd().a(PluginDownloadActivity.this.gxh, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxh.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gxj.gxp.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gxj.gxp.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxh.package_name)) {
                                    PluginDownloadActivity.this.gxj.gxp.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gxj.gxp.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gxh.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gxj, PluginDownloadActivity.this.getPageContext());
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
        if (this.gxh != null) {
            PluginPackageManager.nd().ca(this.gxh.package_name);
        }
        super.onDestroy();
    }
}
