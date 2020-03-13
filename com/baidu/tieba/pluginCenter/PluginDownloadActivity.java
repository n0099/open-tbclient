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
    private boolean aKd;
    private a jzC;
    private PluginNetConfigInfos.PluginConfig jzz;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jzz = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.jzz == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.jzC = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.jzC.setCancelable(false);
        this.jzC.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aKd) {
                    g.b(PluginDownloadActivity.this.jzC, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.jzC.dWg.getVisibility() == 0) {
                        PluginDownloadActivity.this.jzC.dWg.setVisibility(8);
                        PluginDownloadActivity.this.jzC.jzE.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.jzC.dWg.setVisibility(0);
                    PluginDownloadActivity.this.jzC.jzE.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.jzC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.jzC, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jzC.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView ali;
        private LinearLayout dWg;
        private TextView eaR;
        private LinearLayout jzE;
        private TextView jzF;
        private TextView jzG;
        private TextView jzH;
        private TextView jzI;
        private TextView jzJ;
        private TextView jzK;
        private TextView jzL;
        private TextView jzM;

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
            this.jzE = (LinearLayout) findViewById(R.id.down_dialog);
            this.jzL = (TextView) findViewById(R.id.update_tip);
            this.jzF = (TextView) findViewById(R.id.newversion);
            this.ali = (TextView) findViewById(R.id.desc);
            this.jzG = (TextView) findViewById(R.id.update_button);
            this.jzG.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.eaR = (TextView) findViewById(R.id.update_cancel);
            this.jzH = (TextView) findViewById(R.id.downloading);
            this.jzM = (TextView) findViewById(R.id.otherApp);
            this.jzM.setVisibility(8);
            this.jzI = (TextView) findViewById(R.id.app_size);
            this.dWg = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.jzJ = (TextView) findViewById(R.id.sure_cancel);
            this.jzK = (TextView) findViewById(R.id.cancel_button);
            this.jzJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.jzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dWg.setVisibility(8);
                    a.this.jzE.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzz.display_name)) {
                this.jzL.setText(PluginDownloadActivity.this.jzz.display_name);
            } else {
                this.jzL.setText("");
            }
            if (PluginDownloadActivity.this.jzz.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzz.newest.version)) {
                    this.jzF.setText("版本：" + PluginDownloadActivity.this.jzz.newest.version);
                } else {
                    this.jzF.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jzz.newest.change_log)) {
                    this.ali.setText(PluginDownloadActivity.this.jzz.newest.change_log);
                } else {
                    this.ali.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.jzz.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.jzI.setVisibility(0);
                    this.jzI.setText(((Object) this.jzI.getText()) + valueOf + "KB");
                } else {
                    this.jzI.setVisibility(8);
                }
            } else {
                this.jzF.setText("");
                this.ali.setText("");
                this.jzI.setText("");
            }
            this.jzG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.aKd = true;
                        a.this.jzG.setVisibility(8);
                        a.this.eaR.setVisibility(8);
                        a.this.jzH.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.jzz, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzz.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.jzC.jzH.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.jzC.jzH.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzz.package_name)) {
                                    PluginDownloadActivity.this.jzC.jzH.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.jzC.jzH.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jzz.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.jzC, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.eaR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aFD().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aFD().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jzz != null) {
            PluginPackageManager.js().bi(this.jzz.package_name);
        }
        super.onDestroy();
    }
}
