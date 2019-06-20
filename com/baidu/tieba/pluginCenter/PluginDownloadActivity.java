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
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes3.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean adP;
    private PluginNetConfigInfos.PluginConfig itn;
    private a itq;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itn = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.itn == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.itq = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.itq.setCancelable(false);
        this.itq.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.adP) {
                    g.b(PluginDownloadActivity.this.itq, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.itq.cSW.getVisibility() == 0) {
                        PluginDownloadActivity.this.itq.cSW.setVisibility(8);
                        PluginDownloadActivity.this.itq.its.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.itq.cSW.setVisibility(0);
                    PluginDownloadActivity.this.itq.its.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.itq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.itq, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.itq.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cSW;
        private TextView cWK;
        private TextView fIN;
        private TextView itA;
        private LinearLayout its;
        private TextView itt;
        private TextView itu;
        private TextView itv;
        private TextView itw;
        private TextView itx;
        private TextView ity;
        private TextView itz;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R.layout.update_dialog);
            findViewById(R.id.warning).setVisibility(8);
            findViewById(R.id.incremental_button).setVisibility(8);
            findViewById(R.id.incremental_size).setVisibility(8);
            this.its = (LinearLayout) findViewById(R.id.down_dialog);
            this.itz = (TextView) findViewById(R.id.update_tip);
            this.itt = (TextView) findViewById(R.id.newversion);
            this.fIN = (TextView) findViewById(R.id.desc);
            this.itu = (TextView) findViewById(R.id.update_button);
            this.itu.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cWK = (TextView) findViewById(R.id.update_cancel);
            this.itv = (TextView) findViewById(R.id.downloading);
            this.itA = (TextView) findViewById(R.id.otherApp);
            this.itA.setVisibility(8);
            this.itw = (TextView) findViewById(R.id.app_size);
            this.cSW = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.itx = (TextView) findViewById(R.id.sure_cancel);
            this.ity = (TextView) findViewById(R.id.cancel_button);
            this.itx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.ity.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cSW.setVisibility(8);
                    a.this.its.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.itn.display_name)) {
                this.itz.setText(PluginDownloadActivity.this.itn.display_name);
            } else {
                this.itz.setText("");
            }
            if (PluginDownloadActivity.this.itn.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itn.newest.version)) {
                    this.itt.setText("版本：" + PluginDownloadActivity.this.itn.newest.version);
                } else {
                    this.itt.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itn.newest.change_log)) {
                    this.fIN.setText(PluginDownloadActivity.this.itn.newest.change_log);
                } else {
                    this.fIN.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.itn.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.itw.setVisibility(0);
                    this.itw.setText(((Object) this.itw.getText()) + valueOf + "KB");
                } else {
                    this.itw.setVisibility(8);
                }
            } else {
                this.itt.setText("");
                this.fIN.setText("");
                this.itw.setText("");
            }
            this.itu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jS()) {
                        PluginDownloadActivity.this.adP = true;
                        a.this.itu.setVisibility(8);
                        a.this.cWK.setVisibility(8);
                        a.this.itv.setVisibility(0);
                        PluginPackageManager.mc().a(PluginDownloadActivity.this.itn, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itn.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.itq.itv.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.itq.itv.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itn.package_name)) {
                                    PluginDownloadActivity.this.itq.itv.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.itq.itv.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itn.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.itq, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cWK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.agM().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.agM().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.itn != null) {
            PluginPackageManager.mc().bL(this.itn.package_name);
        }
        super.onDestroy();
    }
}
