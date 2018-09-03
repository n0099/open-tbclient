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
import com.baidu.tieba.f;
import java.util.Date;
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig gio;
    private a giq;
    private boolean gir;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gio = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gio == null) {
            showToast(getPageContext().getString(f.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.giq = new a(getPageContext().getPageActivity(), f.k.common_alert_dialog);
        this.giq.setCancelable(false);
        this.giq.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gir) {
                    g.b(PluginDownloadActivity.this.giq, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.giq.bkF.getVisibility() == 0) {
                        PluginDownloadActivity.this.giq.bkF.setVisibility(8);
                        PluginDownloadActivity.this.giq.git.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.giq.bkF.setVisibility(0);
                    PluginDownloadActivity.this.giq.git.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.giq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.giq, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.giq.findViewById(f.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bkF;
        private TextView boy;
        private TextView eDe;
        private TextView giA;
        private TextView giB;
        private LinearLayout git;
        private TextView giu;
        private TextView giv;
        private TextView giw;
        private TextView gix;
        private TextView giy;
        private TextView giz;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(f.h.update_dialog);
            findViewById(f.g.warning).setVisibility(8);
            findViewById(f.g.incremental_button).setVisibility(8);
            findViewById(f.g.incremental_size).setVisibility(8);
            this.git = (LinearLayout) findViewById(f.g.down_dialog);
            this.giA = (TextView) findViewById(f.g.update_tip);
            this.giu = (TextView) findViewById(f.g.newversion);
            this.eDe = (TextView) findViewById(f.g.desc);
            this.giv = (TextView) findViewById(f.g.update_button);
            this.giv.setText(PluginDownloadActivity.this.getPageContext().getString(f.j.install_app));
            this.boy = (TextView) findViewById(f.g.update_cancel);
            this.giw = (TextView) findViewById(f.g.downloading);
            this.giB = (TextView) findViewById(f.g.otherApp);
            this.giB.setVisibility(8);
            this.gix = (TextView) findViewById(f.g.app_size);
            this.bkF = (LinearLayout) findViewById(f.g.cancel_dialog);
            this.giy = (TextView) findViewById(f.g.sure_cancel);
            this.giz = (TextView) findViewById(f.g.cancel_button);
            this.giy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.giz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkF.setVisibility(8);
                    a.this.git.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gio.display_name)) {
                this.giA.setText(PluginDownloadActivity.this.gio.display_name);
            } else {
                this.giA.setText("");
            }
            if (PluginDownloadActivity.this.gio.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gio.newest.version)) {
                    this.giu.setText("版本：" + PluginDownloadActivity.this.gio.newest.version);
                } else {
                    this.giu.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gio.newest.change_log)) {
                    this.eDe.setText(PluginDownloadActivity.this.gio.newest.change_log);
                } else {
                    this.eDe.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gio.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gix.setVisibility(0);
                    this.gix.setText(((Object) this.gix.getText()) + valueOf + "KB");
                } else {
                    this.gix.setVisibility(8);
                }
            } else {
                this.giu.setText("");
                this.eDe.setText("");
                this.gix.setText("");
            }
            this.giv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jE()) {
                        PluginDownloadActivity.this.gir = true;
                        a.this.giv.setVisibility(8);
                        a.this.boy.setVisibility(8);
                        a.this.giw.setVisibility(0);
                        PluginPackageManager.lN().a(PluginDownloadActivity.this.gio, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gio.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.giq.giw.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.giq.giw.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(f.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(f.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gio.package_name)) {
                                    PluginDownloadActivity.this.giq.giw.setText(PluginDownloadActivity.this.getPageContext().getString(f.j.plugin_download_finished));
                                    PluginDownloadActivity.this.giq.giw.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gio.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.giq, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(f.j.neterror);
                }
            });
            this.boy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gio != null) {
            PluginPackageManager.lN().bK(this.gio.package_name);
        }
        super.onDestroy();
    }
}
