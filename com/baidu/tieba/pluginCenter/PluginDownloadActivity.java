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
    private PluginNetConfigInfos.PluginConfig gwv;
    private a gwx;
    private boolean gwy;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwv = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gwv == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gwx = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gwx.setCancelable(false);
        this.gwx.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gwy) {
                    g.b(PluginDownloadActivity.this.gwx, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gwx.bQj.getVisibility() == 0) {
                        PluginDownloadActivity.this.gwx.bQj.setVisibility(8);
                        PluginDownloadActivity.this.gwx.gwA.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gwx.bQj.setVisibility(0);
                    PluginDownloadActivity.this.gwx.gwA.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gwx.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gwx, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.gwx.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bQj;
        private TextView bUa;
        private TextView eOj;
        private TextView fmV;
        private LinearLayout gwA;
        private TextView gwB;
        private TextView gwC;
        private TextView gwD;
        private TextView gwE;
        private TextView gwF;
        private TextView gwG;
        private TextView gwH;

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
            this.gwA = (LinearLayout) findViewById(d.g.down_dialog);
            this.gwG = (TextView) findViewById(d.g.update_tip);
            this.gwB = (TextView) findViewById(d.g.newversion);
            this.eOj = (TextView) findViewById(d.g.desc);
            this.gwC = (TextView) findViewById(d.g.update_button);
            this.gwC.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bUa = (TextView) findViewById(d.g.update_cancel);
            this.fmV = (TextView) findViewById(d.g.downloading);
            this.gwH = (TextView) findViewById(d.g.otherApp);
            this.gwH.setVisibility(8);
            this.gwD = (TextView) findViewById(d.g.app_size);
            this.bQj = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gwE = (TextView) findViewById(d.g.sure_cancel);
            this.gwF = (TextView) findViewById(d.g.cancel_button);
            this.gwE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gwF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bQj.setVisibility(8);
                    a.this.gwA.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwv.display_name)) {
                this.gwG.setText(PluginDownloadActivity.this.gwv.display_name);
            } else {
                this.gwG.setText("");
            }
            if (PluginDownloadActivity.this.gwv.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwv.newest.version)) {
                    this.gwB.setText("版本：" + PluginDownloadActivity.this.gwv.newest.version);
                } else {
                    this.gwB.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gwv.newest.change_log)) {
                    this.eOj.setText(PluginDownloadActivity.this.gwv.newest.change_log);
                } else {
                    this.eOj.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gwv.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gwD.setVisibility(0);
                    this.gwD.setText(((Object) this.gwD.getText()) + valueOf + "KB");
                } else {
                    this.gwD.setVisibility(8);
                }
            } else {
                this.gwB.setText("");
                this.eOj.setText("");
                this.gwD.setText("");
            }
            this.gwC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oJ()) {
                        PluginDownloadActivity.this.gwy = true;
                        a.this.gwC.setVisibility(8);
                        a.this.bUa.setVisibility(8);
                        a.this.fmV.setVisibility(0);
                        PluginPackageManager.qS().a(PluginDownloadActivity.this.gwv, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwv.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gwx.fmV.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gwx.fmV.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwv.package_name)) {
                                    PluginDownloadActivity.this.gwx.fmV.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gwx.fmV.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gwv.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gwx, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bUa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gwv != null) {
            PluginPackageManager.qS().by(this.gwv.package_name);
        }
        super.onDestroy();
    }
}
