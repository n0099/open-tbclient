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
    private boolean cXg;
    private PluginNetConfigInfos.PluginConfig fzE;
    private a fzG;
    private boolean fzH;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fzE = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fzE == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fzG = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fzG.setCancelable(false);
        this.fzG.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fzH) {
                    g.b(PluginDownloadActivity.this.fzG, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fzG.aUl.getVisibility() == 0) {
                        PluginDownloadActivity.this.fzG.aUl.setVisibility(8);
                        PluginDownloadActivity.this.fzG.fzJ.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fzG.aUl.setVisibility(0);
                    PluginDownloadActivity.this.fzG.fzJ.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fzG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fzG, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fzG.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aUl;
        private TextView aYk;
        private TextView dyD;
        private TextView eam;
        private LinearLayout fzJ;
        private TextView fzK;
        private TextView fzL;
        private TextView fzM;
        private TextView fzN;
        private TextView fzO;
        private TextView fzP;
        private TextView fzQ;

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
            this.fzJ = (LinearLayout) findViewById(d.h.down_dialog);
            this.fzP = (TextView) findViewById(d.h.update_tip);
            this.fzK = (TextView) findViewById(d.h.newversion);
            this.dyD = (TextView) findViewById(d.h.desc);
            this.fzL = (TextView) findViewById(d.h.update_button);
            this.fzL.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aYk = (TextView) findViewById(d.h.update_cancel);
            this.eam = (TextView) findViewById(d.h.downloading);
            this.fzQ = (TextView) findViewById(d.h.otherApp);
            this.fzQ.setVisibility(8);
            this.fzM = (TextView) findViewById(d.h.app_size);
            this.aUl = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fzN = (TextView) findViewById(d.h.sure_cancel);
            this.fzO = (TextView) findViewById(d.h.cancel_button);
            this.fzN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fzO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aUl.setVisibility(8);
                    a.this.fzJ.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fzE.display_name)) {
                this.fzP.setText(PluginDownloadActivity.this.fzE.display_name);
            } else {
                this.fzP.setText("");
            }
            if (PluginDownloadActivity.this.fzE.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fzE.newest.version)) {
                    this.fzK.setText("版本：" + PluginDownloadActivity.this.fzE.newest.version);
                } else {
                    this.fzK.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fzE.newest.change_log)) {
                    this.dyD.setText(PluginDownloadActivity.this.fzE.newest.change_log);
                } else {
                    this.dyD.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fzE.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fzM.setVisibility(0);
                    this.fzM.setText(((Object) this.fzM.getText()) + valueOf + "KB");
                } else {
                    this.fzM.setVisibility(8);
                }
            } else {
                this.fzK.setText("");
                this.dyD.setText("");
                this.fzM.setText("");
            }
            this.fzL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hh()) {
                        PluginDownloadActivity.this.fzH = true;
                        a.this.fzL.setVisibility(8);
                        a.this.aYk.setVisibility(8);
                        a.this.eam.setVisibility(0);
                        PluginPackageManager.ju().a(PluginDownloadActivity.this.fzE, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fzE.package_name) && !PluginDownloadActivity.this.cXg) {
                                    PluginDownloadActivity.this.fzG.eam.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fzG.eam.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fzE.package_name)) {
                                    PluginDownloadActivity.this.fzG.eam.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fzG.eam.setEnabled(false);
                                    PluginDownloadActivity.this.cXg = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fzE.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.cXg = true;
                                    g.b(PluginDownloadActivity.this.fzG, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aYk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fzE != null) {
            PluginPackageManager.ju().bn(this.fzE.package_name);
        }
        super.onDestroy();
    }
}
