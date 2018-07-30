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
    private PluginNetConfigInfos.PluginConfig gip;
    private a gir;
    private boolean gis;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gip = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gip == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gir = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gir.setCancelable(false);
        this.gir.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gis) {
                    g.b(PluginDownloadActivity.this.gir, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gir.bkA.getVisibility() == 0) {
                        PluginDownloadActivity.this.gir.bkA.setVisibility(8);
                        PluginDownloadActivity.this.gir.giu.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gir.bkA.setVisibility(0);
                    PluginDownloadActivity.this.gir.giu.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gir.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gir, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gir.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bkA;
        private TextView bow;
        private TextView eDi;
        private TextView giA;
        private TextView giB;
        private TextView giC;
        private LinearLayout giu;
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
            setContentView(d.h.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.giu = (LinearLayout) findViewById(d.g.down_dialog);
            this.giB = (TextView) findViewById(d.g.update_tip);
            this.giv = (TextView) findViewById(d.g.newversion);
            this.eDi = (TextView) findViewById(d.g.desc);
            this.giw = (TextView) findViewById(d.g.update_button);
            this.giw.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bow = (TextView) findViewById(d.g.update_cancel);
            this.gix = (TextView) findViewById(d.g.downloading);
            this.giC = (TextView) findViewById(d.g.otherApp);
            this.giC.setVisibility(8);
            this.giy = (TextView) findViewById(d.g.app_size);
            this.bkA = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.giz = (TextView) findViewById(d.g.sure_cancel);
            this.giA = (TextView) findViewById(d.g.cancel_button);
            this.giz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.giA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bkA.setVisibility(8);
                    a.this.giu.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gip.display_name)) {
                this.giB.setText(PluginDownloadActivity.this.gip.display_name);
            } else {
                this.giB.setText("");
            }
            if (PluginDownloadActivity.this.gip.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gip.newest.version)) {
                    this.giv.setText("版本：" + PluginDownloadActivity.this.gip.newest.version);
                } else {
                    this.giv.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gip.newest.change_log)) {
                    this.eDi.setText(PluginDownloadActivity.this.gip.newest.change_log);
                } else {
                    this.eDi.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gip.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.giy.setVisibility(0);
                    this.giy.setText(((Object) this.giy.getText()) + valueOf + "KB");
                } else {
                    this.giy.setVisibility(8);
                }
            } else {
                this.giv.setText("");
                this.eDi.setText("");
                this.giy.setText("");
            }
            this.giw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jE()) {
                        PluginDownloadActivity.this.gis = true;
                        a.this.giw.setVisibility(8);
                        a.this.bow.setVisibility(8);
                        a.this.gix.setVisibility(0);
                        PluginPackageManager.lN().a(PluginDownloadActivity.this.gip, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gip.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gir.gix.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gir.gix.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gip.package_name)) {
                                    PluginDownloadActivity.this.gir.gix.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gir.gix.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gip.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gir, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bow.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gip != null) {
            PluginPackageManager.lN().bK(this.gip.package_name);
        }
        super.onDestroy();
    }
}
