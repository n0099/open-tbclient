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
    private boolean bsO;
    private PluginNetConfigInfos.PluginConfig kYg;
    private a kYj;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kYg = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.kYg == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.kYj = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.kYj.setCancelable(false);
        this.kYj.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bsO) {
                    g.b(PluginDownloadActivity.this.kYj, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.kYj.eVz.getVisibility() == 0) {
                        PluginDownloadActivity.this.kYj.eVz.setVisibility(8);
                        PluginDownloadActivity.this.kYj.kYl.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.kYj.eVz.setVisibility(0);
                    PluginDownloadActivity.this.kYj.kYl.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.kYj.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.kYj, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kYj.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aha;
        private LinearLayout eVz;
        private TextView eZU;
        private LinearLayout kYl;
        private TextView kYm;
        private TextView kYn;
        private TextView kYo;
        private TextView kYp;
        private TextView kYq;
        private TextView kYr;
        private TextView kYs;
        private TextView kYt;

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
            this.kYl = (LinearLayout) findViewById(R.id.down_dialog);
            this.kYs = (TextView) findViewById(R.id.update_tip);
            this.kYm = (TextView) findViewById(R.id.newversion);
            this.aha = (TextView) findViewById(R.id.desc);
            this.kYn = (TextView) findViewById(R.id.update_button);
            this.kYn.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.eZU = (TextView) findViewById(R.id.update_cancel);
            this.kYo = (TextView) findViewById(R.id.downloading);
            this.kYt = (TextView) findViewById(R.id.otherApp);
            this.kYt.setVisibility(8);
            this.kYp = (TextView) findViewById(R.id.app_size);
            this.eVz = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.kYq = (TextView) findViewById(R.id.sure_cancel);
            this.kYr = (TextView) findViewById(R.id.cancel_button);
            this.kYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.kYr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.eVz.setVisibility(8);
                    a.this.kYl.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.kYg.display_name)) {
                this.kYs.setText(PluginDownloadActivity.this.kYg.display_name);
            } else {
                this.kYs.setText("");
            }
            if (PluginDownloadActivity.this.kYg.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kYg.newest.version)) {
                    this.kYm.setText("版本：" + PluginDownloadActivity.this.kYg.newest.version);
                } else {
                    this.kYm.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kYg.newest.change_log)) {
                    this.aha.setText(PluginDownloadActivity.this.kYg.newest.change_log);
                } else {
                    this.aha.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.kYg.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.kYp.setVisibility(0);
                    this.kYp.setText(((Object) this.kYp.getText()) + valueOf + "KB");
                } else {
                    this.kYp.setVisibility(8);
                }
            } else {
                this.kYm.setText("");
                this.aha.setText("");
                this.kYp.setText("");
            }
            this.kYn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bsO = true;
                        a.this.kYn.setVisibility(8);
                        a.this.eZU.setVisibility(8);
                        a.this.kYo.setVisibility(0);
                        PluginPackageManager.oo().a(PluginDownloadActivity.this.kYg, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kYg.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.kYj.kYo.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.kYj.kYo.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kYg.package_name)) {
                                    PluginDownloadActivity.this.kYj.kYo.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.kYj.kYo.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kYg.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.kYj, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.eZU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aVP().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aVP().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kYg != null) {
            PluginPackageManager.oo().cz(this.kYg.package_name);
        }
        super.onDestroy();
    }
}
