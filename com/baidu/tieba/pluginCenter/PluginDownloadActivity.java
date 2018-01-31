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
    private PluginNetConfigInfos.PluginConfig gvb;
    private a gvd;
    private boolean gve;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gvb = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gvb == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gvd = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gvd.setCancelable(false);
        this.gvd.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gve) {
                    g.b(PluginDownloadActivity.this.gvd, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gvd.bOo.getVisibility() == 0) {
                        PluginDownloadActivity.this.gvd.bOo.setVisibility(8);
                        PluginDownloadActivity.this.gvd.gvg.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gvd.bOo.setVisibility(0);
                    PluginDownloadActivity.this.gvd.gvg.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gvd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gvd, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aN(i == 1);
        getLayoutMode().aM(this.gvd.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bOo;
        private TextView bSg;
        private TextView eKg;
        private TextView fjG;
        private LinearLayout gvg;
        private TextView gvh;
        private TextView gvi;
        private TextView gvj;
        private TextView gvk;
        private TextView gvl;
        private TextView gvm;
        private TextView gvn;

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
            this.gvg = (LinearLayout) findViewById(d.g.down_dialog);
            this.gvm = (TextView) findViewById(d.g.update_tip);
            this.gvh = (TextView) findViewById(d.g.newversion);
            this.eKg = (TextView) findViewById(d.g.desc);
            this.gvi = (TextView) findViewById(d.g.update_button);
            this.gvi.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bSg = (TextView) findViewById(d.g.update_cancel);
            this.fjG = (TextView) findViewById(d.g.downloading);
            this.gvn = (TextView) findViewById(d.g.otherApp);
            this.gvn.setVisibility(8);
            this.gvj = (TextView) findViewById(d.g.app_size);
            this.bOo = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gvk = (TextView) findViewById(d.g.sure_cancel);
            this.gvl = (TextView) findViewById(d.g.cancel_button);
            this.gvk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gvl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bOo.setVisibility(8);
                    a.this.gvg.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gvb.display_name)) {
                this.gvm.setText(PluginDownloadActivity.this.gvb.display_name);
            } else {
                this.gvm.setText("");
            }
            if (PluginDownloadActivity.this.gvb.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gvb.newest.version)) {
                    this.gvh.setText("版本：" + PluginDownloadActivity.this.gvb.newest.version);
                } else {
                    this.gvh.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gvb.newest.change_log)) {
                    this.eKg.setText(PluginDownloadActivity.this.gvb.newest.change_log);
                } else {
                    this.eKg.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gvb.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gvj.setVisibility(0);
                    this.gvj.setText(((Object) this.gvj.getText()) + valueOf + "KB");
                } else {
                    this.gvj.setVisibility(8);
                }
            } else {
                this.gvh.setText("");
                this.eKg.setText("");
                this.gvj.setText("");
            }
            this.gvi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        PluginDownloadActivity.this.gve = true;
                        a.this.gvi.setVisibility(8);
                        a.this.bSg.setVisibility(8);
                        a.this.fjG.setVisibility(0);
                        PluginPackageManager.qS().a(PluginDownloadActivity.this.gvb, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gvb.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gvd.fjG.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gvd.fjG.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gvb.package_name)) {
                                    PluginDownloadActivity.this.gvd.fjG.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gvd.fjG.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gvb.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gvd, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gvb != null) {
            PluginPackageManager.qS().by(this.gvb.package_name);
        }
        super.onDestroy();
    }
}
