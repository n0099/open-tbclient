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
    private PluginNetConfigInfos.PluginConfig fAQ;
    private a fAS;
    private boolean fAT;
    private boolean lh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fAQ = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fAQ == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fAS = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fAS.setCancelable(false);
        this.fAS.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fAT) {
                    g.b(PluginDownloadActivity.this.fAS, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fAS.aVx.getVisibility() == 0) {
                        PluginDownloadActivity.this.fAS.aVx.setVisibility(8);
                        PluginDownloadActivity.this.fAS.fAV.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fAS.aVx.setVisibility(0);
                    PluginDownloadActivity.this.fAS.fAV.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fAS.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fAS, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fAS.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aVx;
        private TextView aZv;
        private TextView ebD;
        private LinearLayout fAV;
        private TextView fAW;
        private TextView fAX;
        private TextView fAY;
        private TextView fAZ;
        private TextView fBa;
        private TextView fBb;
        private TextView fBc;
        private TextView mDesc;

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
            this.fAV = (LinearLayout) findViewById(d.h.down_dialog);
            this.fBb = (TextView) findViewById(d.h.update_tip);
            this.fAW = (TextView) findViewById(d.h.newversion);
            this.mDesc = (TextView) findViewById(d.h.desc);
            this.fAX = (TextView) findViewById(d.h.update_button);
            this.fAX.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aZv = (TextView) findViewById(d.h.update_cancel);
            this.ebD = (TextView) findViewById(d.h.downloading);
            this.fBc = (TextView) findViewById(d.h.otherApp);
            this.fBc.setVisibility(8);
            this.fAY = (TextView) findViewById(d.h.app_size);
            this.aVx = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fAZ = (TextView) findViewById(d.h.sure_cancel);
            this.fBa = (TextView) findViewById(d.h.cancel_button);
            this.fAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fBa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aVx.setVisibility(8);
                    a.this.fAV.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fAQ.display_name)) {
                this.fBb.setText(PluginDownloadActivity.this.fAQ.display_name);
            } else {
                this.fBb.setText("");
            }
            if (PluginDownloadActivity.this.fAQ.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fAQ.newest.version)) {
                    this.fAW.setText("版本：" + PluginDownloadActivity.this.fAQ.newest.version);
                } else {
                    this.fAW.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fAQ.newest.change_log)) {
                    this.mDesc.setText(PluginDownloadActivity.this.fAQ.newest.change_log);
                } else {
                    this.mDesc.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fAQ.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fAY.setVisibility(0);
                    this.fAY.setText(((Object) this.fAY.getText()) + valueOf + "KB");
                } else {
                    this.fAY.setVisibility(8);
                }
            } else {
                this.fAW.setText("");
                this.mDesc.setText("");
                this.fAY.setText("");
            }
            this.fAX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hr()) {
                        PluginDownloadActivity.this.fAT = true;
                        a.this.fAX.setVisibility(8);
                        a.this.aZv.setVisibility(8);
                        a.this.ebD.setVisibility(0);
                        PluginPackageManager.jE().a(PluginDownloadActivity.this.fAQ, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fAQ.package_name) && !PluginDownloadActivity.this.lh) {
                                    PluginDownloadActivity.this.fAS.ebD.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fAS.ebD.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fAQ.package_name)) {
                                    PluginDownloadActivity.this.fAS.ebD.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fAS.ebD.setEnabled(false);
                                    PluginDownloadActivity.this.lh = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fAQ.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.lh = true;
                                    g.b(PluginDownloadActivity.this.fAS, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aZv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fAQ != null) {
            PluginPackageManager.jE().bt(this.fAQ.package_name);
        }
        super.onDestroy();
    }
}
