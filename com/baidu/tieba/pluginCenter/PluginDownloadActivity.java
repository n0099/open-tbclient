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
import com.baidu.adp.lib.f.g;
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
/* loaded from: classes8.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean aKb;
    private PluginNetConfigInfos.PluginConfig jzl;
    private a jzo;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jzl = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.jzl == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.jzo = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.jzo.setCancelable(false);
        this.jzo.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aKb) {
                    g.b(PluginDownloadActivity.this.jzo, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.jzo.dVS.getVisibility() == 0) {
                        PluginDownloadActivity.this.jzo.dVS.setVisibility(8);
                        PluginDownloadActivity.this.jzo.jzq.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.jzo.dVS.setVisibility(0);
                    PluginDownloadActivity.this.jzo.jzq.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.jzo.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.jzo, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jzo.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView alh;
        private LinearLayout dVS;
        private TextView eaD;
        private LinearLayout jzq;
        private TextView jzr;
        private TextView jzs;
        private TextView jzt;
        private TextView jzu;
        private TextView jzv;
        private TextView jzw;
        private TextView jzx;
        private TextView jzy;

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
            this.jzq = (LinearLayout) findViewById(R.id.down_dialog);
            this.jzx = (TextView) findViewById(R.id.update_tip);
            this.jzr = (TextView) findViewById(R.id.newversion);
            this.alh = (TextView) findViewById(R.id.desc);
            this.jzs = (TextView) findViewById(R.id.update_button);
            this.jzs.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.eaD = (TextView) findViewById(R.id.update_cancel);
            this.jzt = (TextView) findViewById(R.id.downloading);
            this.jzy = (TextView) findViewById(R.id.otherApp);
            this.jzy.setVisibility(8);
            this.jzu = (TextView) findViewById(R.id.app_size);
            this.dVS = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.jzv = (TextView) findViewById(R.id.sure_cancel);
            this.jzw = (TextView) findViewById(R.id.cancel_button);
            this.jzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.jzw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dVS.setVisibility(8);
                    a.this.jzq.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzl.display_name)) {
                this.jzx.setText(PluginDownloadActivity.this.jzl.display_name);
            } else {
                this.jzx.setText("");
            }
            if (PluginDownloadActivity.this.jzl.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzl.newest.version)) {
                    this.jzr.setText("版本：" + PluginDownloadActivity.this.jzl.newest.version);
                } else {
                    this.jzr.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzl.newest.change_log)) {
                    this.alh.setText(PluginDownloadActivity.this.jzl.newest.change_log);
                } else {
                    this.alh.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.jzl.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.jzu.setVisibility(0);
                    this.jzu.setText(((Object) this.jzu.getText()) + valueOf + "KB");
                } else {
                    this.jzu.setVisibility(8);
                }
            } else {
                this.jzr.setText("");
                this.alh.setText("");
                this.jzu.setText("");
            }
            this.jzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.aKb = true;
                        a.this.jzs.setVisibility(8);
                        a.this.eaD.setVisibility(8);
                        a.this.jzt.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.jzl, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzl.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.jzo.jzt.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.jzo.jzt.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzl.package_name)) {
                                    PluginDownloadActivity.this.jzo.jzt.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.jzo.jzt.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzl.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.jzo, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.eaD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aFB().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aFB().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jzl != null) {
            PluginPackageManager.js().bi(this.jzl.package_name);
        }
        super.onDestroy();
    }
}
