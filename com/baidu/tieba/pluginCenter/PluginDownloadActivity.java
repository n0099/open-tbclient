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
    private boolean dmh;
    private PluginNetConfigInfos.PluginConfig fIb;
    private a fId;
    private boolean fIe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fIb = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fIb == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fId = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.fId.setCancelable(false);
        this.fId.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fIe) {
                    g.b(PluginDownloadActivity.this.fId, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fId.aXf.getVisibility() == 0) {
                        PluginDownloadActivity.this.fId.aXf.setVisibility(8);
                        PluginDownloadActivity.this.fId.fIg.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fId.aXf.setVisibility(0);
                    PluginDownloadActivity.this.fId.fIg.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fId.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fId, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ag(i == 1);
        getLayoutMode().t(this.fId.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aXf;
        private TextView bbu;
        private TextView dNk;
        private TextView eoM;
        private LinearLayout fIg;
        private TextView fIh;
        private TextView fIi;
        private TextView fIj;
        private TextView fIk;
        private TextView fIl;
        private TextView fIm;
        private TextView fIn;

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
            this.fIg = (LinearLayout) findViewById(d.g.down_dialog);
            this.fIm = (TextView) findViewById(d.g.update_tip);
            this.fIh = (TextView) findViewById(d.g.newversion);
            this.dNk = (TextView) findViewById(d.g.desc);
            this.fIi = (TextView) findViewById(d.g.update_button);
            this.fIi.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bbu = (TextView) findViewById(d.g.update_cancel);
            this.eoM = (TextView) findViewById(d.g.downloading);
            this.fIn = (TextView) findViewById(d.g.otherApp);
            this.fIn.setVisibility(8);
            this.fIj = (TextView) findViewById(d.g.app_size);
            this.aXf = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.fIk = (TextView) findViewById(d.g.sure_cancel);
            this.fIl = (TextView) findViewById(d.g.cancel_button);
            this.fIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aXf.setVisibility(8);
                    a.this.fIg.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fIb.display_name)) {
                this.fIm.setText(PluginDownloadActivity.this.fIb.display_name);
            } else {
                this.fIm.setText("");
            }
            if (PluginDownloadActivity.this.fIb.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fIb.newest.version)) {
                    this.fIh.setText("版本：" + PluginDownloadActivity.this.fIb.newest.version);
                } else {
                    this.fIh.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fIb.newest.change_log)) {
                    this.dNk.setText(PluginDownloadActivity.this.fIb.newest.change_log);
                } else {
                    this.dNk.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fIb.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fIj.setVisibility(0);
                    this.fIj.setText(((Object) this.fIj.getText()) + valueOf + "KB");
                } else {
                    this.fIj.setVisibility(8);
                }
            } else {
                this.fIh.setText("");
                this.dNk.setText("");
                this.fIj.setText("");
            }
            this.fIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fIe = true;
                        a.this.fIi.setVisibility(8);
                        a.this.bbu.setVisibility(8);
                        a.this.eoM.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.fIb, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fIb.package_name) && !PluginDownloadActivity.this.dmh) {
                                    PluginDownloadActivity.this.fId.eoM.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fId.eoM.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fIb.package_name)) {
                                    PluginDownloadActivity.this.fId.eoM.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.fId.eoM.setEnabled(false);
                                    PluginDownloadActivity.this.dmh = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fIb.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dmh = true;
                                    g.b(PluginDownloadActivity.this.fId, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fIb != null) {
            PluginPackageManager.js().bq(this.fIb.package_name);
        }
        super.onDestroy();
    }
}
