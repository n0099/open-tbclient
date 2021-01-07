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
    private boolean chs;
    private boolean mFinished;
    private a mGB;
    private PluginNetConfigInfos.PluginConfig mGy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGy = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mGy == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mGB = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mGB.setCancelable(false);
        this.mGB.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.chs) {
                    g.b(PluginDownloadActivity.this.mGB, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mGB.ghI.getVisibility() == 0) {
                        PluginDownloadActivity.this.mGB.ghI.setVisibility(8);
                        PluginDownloadActivity.this.mGB.mGD.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mGB.ghI.setVisibility(0);
                    PluginDownloadActivity.this.mGB.mGD.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mGB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mGB, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mGB.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView akw;
        private LinearLayout ghI;
        private TextView gkL;
        private LinearLayout mGD;
        private TextView mGE;
        private TextView mGF;
        private TextView mGG;
        private TextView mGH;
        private TextView mGI;
        private TextView mGJ;
        private TextView mGK;
        private TextView mGL;

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
            this.mGD = (LinearLayout) findViewById(R.id.down_dialog);
            this.mGK = (TextView) findViewById(R.id.update_tip);
            this.mGE = (TextView) findViewById(R.id.newversion);
            this.akw = (TextView) findViewById(R.id.desc);
            this.mGF = (TextView) findViewById(R.id.update_button);
            this.mGF.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.gkL = (TextView) findViewById(R.id.update_cancel);
            this.mGG = (TextView) findViewById(R.id.downloading);
            this.mGL = (TextView) findViewById(R.id.otherApp);
            this.mGL.setVisibility(8);
            this.mGH = (TextView) findViewById(R.id.app_size);
            this.ghI = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mGI = (TextView) findViewById(R.id.sure_cancel);
            this.mGJ = (TextView) findViewById(R.id.cancel_button);
            this.mGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ghI.setVisibility(8);
                    a.this.mGD.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGy.display_name)) {
                this.mGK.setText(PluginDownloadActivity.this.mGy.display_name);
            } else {
                this.mGK.setText("");
            }
            if (PluginDownloadActivity.this.mGy.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGy.newest.version)) {
                    this.mGE.setText("版本：" + PluginDownloadActivity.this.mGy.newest.version);
                } else {
                    this.mGE.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGy.newest.change_log)) {
                    this.akw.setText(PluginDownloadActivity.this.mGy.newest.change_log);
                } else {
                    this.akw.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mGy.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mGH.setVisibility(0);
                    this.mGH.setText(((Object) this.mGH.getText()) + valueOf + "KB");
                } else {
                    this.mGH.setVisibility(8);
                }
            } else {
                this.mGE.setText("");
                this.akw.setText("");
                this.mGH.setText("");
            }
            this.mGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.chs = true;
                        a.this.mGF.setVisibility(8);
                        a.this.gkL.setVisibility(8);
                        a.this.mGG.setVisibility(0);
                        PluginPackageManager.px().a(PluginDownloadActivity.this.mGy, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGy.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mGB.mGG.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mGB.mGG.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGy.package_name)) {
                                    PluginDownloadActivity.this.mGB.mGG.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mGB.mGG.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGy.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mGB, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.gkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bvr().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bvr().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mGy != null) {
            PluginPackageManager.px().cD(this.mGy.package_name);
        }
        super.onDestroy();
    }
}
