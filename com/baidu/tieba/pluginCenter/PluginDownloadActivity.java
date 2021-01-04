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
    private a mGC;
    private PluginNetConfigInfos.PluginConfig mGz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGz = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mGz == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mGC = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mGC.setCancelable(false);
        this.mGC.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.chs) {
                    g.b(PluginDownloadActivity.this.mGC, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mGC.ghI.getVisibility() == 0) {
                        PluginDownloadActivity.this.mGC.ghI.setVisibility(8);
                        PluginDownloadActivity.this.mGC.mGE.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mGC.ghI.setVisibility(0);
                    PluginDownloadActivity.this.mGC.mGE.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mGC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mGC, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mGC.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView akw;
        private LinearLayout ghI;
        private TextView gkL;
        private LinearLayout mGE;
        private TextView mGF;
        private TextView mGG;
        private TextView mGH;
        private TextView mGI;
        private TextView mGJ;
        private TextView mGK;
        private TextView mGL;
        private TextView mGM;

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
            this.mGE = (LinearLayout) findViewById(R.id.down_dialog);
            this.mGL = (TextView) findViewById(R.id.update_tip);
            this.mGF = (TextView) findViewById(R.id.newversion);
            this.akw = (TextView) findViewById(R.id.desc);
            this.mGG = (TextView) findViewById(R.id.update_button);
            this.mGG.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.gkL = (TextView) findViewById(R.id.update_cancel);
            this.mGH = (TextView) findViewById(R.id.downloading);
            this.mGM = (TextView) findViewById(R.id.otherApp);
            this.mGM.setVisibility(8);
            this.mGI = (TextView) findViewById(R.id.app_size);
            this.ghI = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mGJ = (TextView) findViewById(R.id.sure_cancel);
            this.mGK = (TextView) findViewById(R.id.cancel_button);
            this.mGJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ghI.setVisibility(8);
                    a.this.mGE.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGz.display_name)) {
                this.mGL.setText(PluginDownloadActivity.this.mGz.display_name);
            } else {
                this.mGL.setText("");
            }
            if (PluginDownloadActivity.this.mGz.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGz.newest.version)) {
                    this.mGF.setText("版本：" + PluginDownloadActivity.this.mGz.newest.version);
                } else {
                    this.mGF.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mGz.newest.change_log)) {
                    this.akw.setText(PluginDownloadActivity.this.mGz.newest.change_log);
                } else {
                    this.akw.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mGz.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mGI.setVisibility(0);
                    this.mGI.setText(((Object) this.mGI.getText()) + valueOf + "KB");
                } else {
                    this.mGI.setVisibility(8);
                }
            } else {
                this.mGF.setText("");
                this.akw.setText("");
                this.mGI.setText("");
            }
            this.mGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.chs = true;
                        a.this.mGG.setVisibility(8);
                        a.this.gkL.setVisibility(8);
                        a.this.mGH.setVisibility(0);
                        PluginPackageManager.px().a(PluginDownloadActivity.this.mGz, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGz.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mGC.mGH.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mGC.mGH.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGz.package_name)) {
                                    PluginDownloadActivity.this.mGC.mGH.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mGC.mGH.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mGz.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mGC, PluginDownloadActivity.this.getPageContext());
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
                    b.bvq().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bvq().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mGz != null) {
            PluginPackageManager.px().cD(this.mGz.package_name);
        }
        super.onDestroy();
    }
}
