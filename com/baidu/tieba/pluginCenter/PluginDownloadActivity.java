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
    private boolean bgk;
    private PluginNetConfigInfos.PluginConfig kld;
    private a klg;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kld = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.kld == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.klg = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.klg.setCancelable(false);
        this.klg.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bgk) {
                    g.b(PluginDownloadActivity.this.klg, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.klg.ewv.getVisibility() == 0) {
                        PluginDownloadActivity.this.klg.ewv.setVisibility(8);
                        PluginDownloadActivity.this.klg.kli.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.klg.ewv.setVisibility(0);
                    PluginDownloadActivity.this.klg.kli.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.klg.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.klg, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.klg.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aDI;
        private TextView eAU;
        private LinearLayout ewv;
        private LinearLayout kli;
        private TextView klj;
        private TextView klk;
        private TextView kll;
        private TextView klm;
        private TextView kln;
        private TextView klo;
        private TextView klp;
        private TextView klq;

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
            this.kli = (LinearLayout) findViewById(R.id.down_dialog);
            this.klp = (TextView) findViewById(R.id.update_tip);
            this.klj = (TextView) findViewById(R.id.newversion);
            this.aDI = (TextView) findViewById(R.id.desc);
            this.klk = (TextView) findViewById(R.id.update_button);
            this.klk.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.eAU = (TextView) findViewById(R.id.update_cancel);
            this.kll = (TextView) findViewById(R.id.downloading);
            this.klq = (TextView) findViewById(R.id.otherApp);
            this.klq.setVisibility(8);
            this.klm = (TextView) findViewById(R.id.app_size);
            this.ewv = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.kln = (TextView) findViewById(R.id.sure_cancel);
            this.klo = (TextView) findViewById(R.id.cancel_button);
            this.kln.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.klo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ewv.setVisibility(8);
                    a.this.kli.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.kld.display_name)) {
                this.klp.setText(PluginDownloadActivity.this.kld.display_name);
            } else {
                this.klp.setText("");
            }
            if (PluginDownloadActivity.this.kld.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kld.newest.version)) {
                    this.klj.setText("版本：" + PluginDownloadActivity.this.kld.newest.version);
                } else {
                    this.klj.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kld.newest.change_log)) {
                    this.aDI.setText(PluginDownloadActivity.this.kld.newest.change_log);
                } else {
                    this.aDI.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.kld.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.klm.setVisibility(0);
                    this.klm.setText(((Object) this.klm.getText()) + valueOf + "KB");
                } else {
                    this.klm.setVisibility(8);
                }
            } else {
                this.klj.setText("");
                this.aDI.setText("");
                this.klm.setText("");
            }
            this.klk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bgk = true;
                        a.this.klk.setVisibility(8);
                        a.this.eAU.setVisibility(8);
                        a.this.kll.setVisibility(0);
                        PluginPackageManager.nV().a(PluginDownloadActivity.this.kld, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kld.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.klg.kll.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.klg.kll.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kld.package_name)) {
                                    PluginDownloadActivity.this.klg.kll.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.klg.kll.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kld.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.klg, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.eAU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aNV().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aNV().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kld != null) {
            PluginPackageManager.nV().cx(this.kld.package_name);
        }
        super.onDestroy();
    }
}
