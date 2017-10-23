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
    private boolean dea;
    private PluginNetConfigInfos.PluginConfig fyn;
    private a fyp;
    private boolean fyq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fyn = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fyn == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fyp = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fyp.setCancelable(false);
        this.fyp.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fyq) {
                    g.b(PluginDownloadActivity.this.fyp, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fyp.aWG.getVisibility() == 0) {
                        PluginDownloadActivity.this.fyp.aWG.setVisibility(8);
                        PluginDownloadActivity.this.fyp.fys.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fyp.aWG.setVisibility(0);
                    PluginDownloadActivity.this.fyp.fys.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fyp.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fyp, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fyp.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aWG;
        private TextView baF;
        private TextView dFr;
        private TextView egZ;
        private LinearLayout fys;
        private TextView fyt;
        private TextView fyu;
        private TextView fyv;
        private TextView fyw;
        private TextView fyx;
        private TextView fyy;
        private TextView fyz;

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
            this.fys = (LinearLayout) findViewById(d.h.down_dialog);
            this.fyy = (TextView) findViewById(d.h.update_tip);
            this.fyt = (TextView) findViewById(d.h.newversion);
            this.dFr = (TextView) findViewById(d.h.desc);
            this.fyu = (TextView) findViewById(d.h.update_button);
            this.fyu.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.baF = (TextView) findViewById(d.h.update_cancel);
            this.egZ = (TextView) findViewById(d.h.downloading);
            this.fyz = (TextView) findViewById(d.h.otherApp);
            this.fyz.setVisibility(8);
            this.fyv = (TextView) findViewById(d.h.app_size);
            this.aWG = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fyw = (TextView) findViewById(d.h.sure_cancel);
            this.fyx = (TextView) findViewById(d.h.cancel_button);
            this.fyw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aWG.setVisibility(8);
                    a.this.fys.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyn.display_name)) {
                this.fyy.setText(PluginDownloadActivity.this.fyn.display_name);
            } else {
                this.fyy.setText("");
            }
            if (PluginDownloadActivity.this.fyn.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyn.newest.version)) {
                    this.fyt.setText("版本：" + PluginDownloadActivity.this.fyn.newest.version);
                } else {
                    this.fyt.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fyn.newest.change_log)) {
                    this.dFr.setText(PluginDownloadActivity.this.fyn.newest.change_log);
                } else {
                    this.dFr.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fyn.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fyv.setVisibility(0);
                    this.fyv.setText(((Object) this.fyv.getText()) + valueOf + "KB");
                } else {
                    this.fyv.setVisibility(8);
                }
            } else {
                this.fyt.setText("");
                this.dFr.setText("");
                this.fyv.setText("");
            }
            this.fyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.hh()) {
                        PluginDownloadActivity.this.fyq = true;
                        a.this.fyu.setVisibility(8);
                        a.this.baF.setVisibility(8);
                        a.this.egZ.setVisibility(0);
                        PluginPackageManager.jv().a(PluginDownloadActivity.this.fyn, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyn.package_name) && !PluginDownloadActivity.this.dea) {
                                    PluginDownloadActivity.this.fyp.egZ.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fyp.egZ.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyn.package_name)) {
                                    PluginDownloadActivity.this.fyp.egZ.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fyp.egZ.setEnabled(false);
                                    PluginDownloadActivity.this.dea = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fyn.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dea = true;
                                    g.b(PluginDownloadActivity.this.fyp, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.baF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fyn != null) {
            PluginPackageManager.jv().bq(this.fyn.package_name);
        }
        super.onDestroy();
    }
}
