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
    private boolean dia;
    private PluginNetConfigInfos.PluginConfig fCh;
    private a fCj;
    private boolean fCk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fCh = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fCh == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fCj = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fCj.setCancelable(false);
        this.fCj.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fCk) {
                    g.b(PluginDownloadActivity.this.fCj, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fCj.aVf.getVisibility() == 0) {
                        PluginDownloadActivity.this.fCj.aVf.setVisibility(8);
                        PluginDownloadActivity.this.fCj.fCm.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fCj.aVf.setVisibility(0);
                    PluginDownloadActivity.this.fCj.fCm.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fCj.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fCj, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fCj.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aVf;
        private TextView aZg;
        private TextView dJq;
        private TextView elc;
        private LinearLayout fCm;
        private TextView fCn;
        private TextView fCo;
        private TextView fCp;
        private TextView fCq;
        private TextView fCr;
        private TextView fCs;
        private TextView fCt;

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
            this.fCm = (LinearLayout) findViewById(d.h.down_dialog);
            this.fCs = (TextView) findViewById(d.h.update_tip);
            this.fCn = (TextView) findViewById(d.h.newversion);
            this.dJq = (TextView) findViewById(d.h.desc);
            this.fCo = (TextView) findViewById(d.h.update_button);
            this.fCo.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aZg = (TextView) findViewById(d.h.update_cancel);
            this.elc = (TextView) findViewById(d.h.downloading);
            this.fCt = (TextView) findViewById(d.h.otherApp);
            this.fCt.setVisibility(8);
            this.fCp = (TextView) findViewById(d.h.app_size);
            this.aVf = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fCq = (TextView) findViewById(d.h.sure_cancel);
            this.fCr = (TextView) findViewById(d.h.cancel_button);
            this.fCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aVf.setVisibility(8);
                    a.this.fCm.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCh.display_name)) {
                this.fCs.setText(PluginDownloadActivity.this.fCh.display_name);
            } else {
                this.fCs.setText("");
            }
            if (PluginDownloadActivity.this.fCh.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCh.newest.version)) {
                    this.fCn.setText("版本：" + PluginDownloadActivity.this.fCh.newest.version);
                } else {
                    this.fCn.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fCh.newest.change_log)) {
                    this.dJq.setText(PluginDownloadActivity.this.fCh.newest.change_log);
                } else {
                    this.dJq.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fCh.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fCp.setVisibility(0);
                    this.fCp.setText(((Object) this.fCp.getText()) + valueOf + "KB");
                } else {
                    this.fCp.setVisibility(8);
                }
            } else {
                this.fCn.setText("");
                this.dJq.setText("");
                this.fCp.setText("");
            }
            this.fCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hi()) {
                        PluginDownloadActivity.this.fCk = true;
                        a.this.fCo.setVisibility(8);
                        a.this.aZg.setVisibility(8);
                        a.this.elc.setVisibility(0);
                        PluginPackageManager.jw().a(PluginDownloadActivity.this.fCh, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCh.package_name) && !PluginDownloadActivity.this.dia) {
                                    PluginDownloadActivity.this.fCj.elc.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fCj.elc.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCh.package_name)) {
                                    PluginDownloadActivity.this.fCj.elc.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fCj.elc.setEnabled(false);
                                    PluginDownloadActivity.this.dia = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fCh.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dia = true;
                                    g.b(PluginDownloadActivity.this.fCj, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aZg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fCh != null) {
            PluginPackageManager.jw().bq(this.fCh.package_name);
        }
        super.onDestroy();
    }
}
