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
/* loaded from: classes15.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean byZ;
    private PluginNetConfigInfos.PluginConfig lwg;
    private a lwj;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lwg = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.lwg == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.lwj = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.lwj.setCancelable(false);
        this.lwj.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.byZ) {
                    g.b(PluginDownloadActivity.this.lwj, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.lwj.fmE.getVisibility() == 0) {
                        PluginDownloadActivity.this.lwj.fmE.setVisibility(8);
                        PluginDownloadActivity.this.lwj.lwl.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.lwj.fmE.setVisibility(0);
                    PluginDownloadActivity.this.lwj.lwl.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.lwj.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.lwj, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lwj.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes15.dex */
    private class a extends Dialog {
        private TextView aic;
        private LinearLayout fmE;
        private TextView fpT;
        private LinearLayout lwl;
        private TextView lwm;
        private TextView lwn;
        private TextView lwo;
        private TextView lwp;
        private TextView lwq;
        private TextView lwr;
        private TextView lws;
        private TextView lwt;

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
            this.lwl = (LinearLayout) findViewById(R.id.down_dialog);
            this.lws = (TextView) findViewById(R.id.update_tip);
            this.lwm = (TextView) findViewById(R.id.newversion);
            this.aic = (TextView) findViewById(R.id.desc);
            this.lwn = (TextView) findViewById(R.id.update_button);
            this.lwn.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.fpT = (TextView) findViewById(R.id.update_cancel);
            this.lwo = (TextView) findViewById(R.id.downloading);
            this.lwt = (TextView) findViewById(R.id.otherApp);
            this.lwt.setVisibility(8);
            this.lwp = (TextView) findViewById(R.id.app_size);
            this.fmE = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.lwq = (TextView) findViewById(R.id.sure_cancel);
            this.lwr = (TextView) findViewById(R.id.cancel_button);
            this.lwq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.lwr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fmE.setVisibility(8);
                    a.this.lwl.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.lwg.display_name)) {
                this.lws.setText(PluginDownloadActivity.this.lwg.display_name);
            } else {
                this.lws.setText("");
            }
            if (PluginDownloadActivity.this.lwg.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lwg.newest.version)) {
                    this.lwm.setText("版本：" + PluginDownloadActivity.this.lwg.newest.version);
                } else {
                    this.lwm.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lwg.newest.change_log)) {
                    this.aic.setText(PluginDownloadActivity.this.lwg.newest.change_log);
                } else {
                    this.aic.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.lwg.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.lwp.setVisibility(0);
                    this.lwp.setText(((Object) this.lwp.getText()) + valueOf + "KB");
                } else {
                    this.lwp.setVisibility(8);
                }
            } else {
                this.lwm.setText("");
                this.aic.setText("");
                this.lwp.setText("");
            }
            this.lwn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.byZ = true;
                        a.this.lwn.setVisibility(8);
                        a.this.fpT.setVisibility(8);
                        a.this.lwo.setVisibility(0);
                        PluginPackageManager.pO().a(PluginDownloadActivity.this.lwg, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lwg.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.lwj.lwo.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.lwj.lwo.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lwg.package_name)) {
                                    PluginDownloadActivity.this.lwj.lwo.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.lwj.lwo.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lwg.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.lwj, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.fpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bik().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bik().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lwg != null) {
            PluginPackageManager.pO().cD(this.lwg.package_name);
        }
        super.onDestroy();
    }
}
