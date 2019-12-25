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
/* loaded from: classes5.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean aFd;
    private PluginNetConfigInfos.PluginConfig juO;
    private a juR;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.juO = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.juO == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.juR = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.juR.setCancelable(false);
        this.juR.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aFd) {
                    g.b(PluginDownloadActivity.this.juR, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.juR.dRE.getVisibility() == 0) {
                        PluginDownloadActivity.this.juR.dRE.setVisibility(8);
                        PluginDownloadActivity.this.juR.juT.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.juR.dRE.setVisibility(0);
                    PluginDownloadActivity.this.juR.juT.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.juR.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.juR, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.juR.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes5.dex */
    private class a extends Dialog {
        private TextView ais;
        private LinearLayout dRE;
        private TextView dWq;
        private LinearLayout juT;
        private TextView juU;
        private TextView juV;
        private TextView juW;
        private TextView juX;
        private TextView juY;
        private TextView juZ;
        private TextView jva;
        private TextView jvb;

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
            this.juT = (LinearLayout) findViewById(R.id.down_dialog);
            this.jva = (TextView) findViewById(R.id.update_tip);
            this.juU = (TextView) findViewById(R.id.newversion);
            this.ais = (TextView) findViewById(R.id.desc);
            this.juV = (TextView) findViewById(R.id.update_button);
            this.juV.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.dWq = (TextView) findViewById(R.id.update_cancel);
            this.juW = (TextView) findViewById(R.id.downloading);
            this.jvb = (TextView) findViewById(R.id.otherApp);
            this.jvb.setVisibility(8);
            this.juX = (TextView) findViewById(R.id.app_size);
            this.dRE = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.juY = (TextView) findViewById(R.id.sure_cancel);
            this.juZ = (TextView) findViewById(R.id.cancel_button);
            this.juY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.juZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dRE.setVisibility(8);
                    a.this.juT.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.juO.display_name)) {
                this.jva.setText(PluginDownloadActivity.this.juO.display_name);
            } else {
                this.jva.setText("");
            }
            if (PluginDownloadActivity.this.juO.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.juO.newest.version)) {
                    this.juU.setText("版本：" + PluginDownloadActivity.this.juO.newest.version);
                } else {
                    this.juU.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.juO.newest.change_log)) {
                    this.ais.setText(PluginDownloadActivity.this.juO.newest.change_log);
                } else {
                    this.ais.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.juO.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.juX.setVisibility(0);
                    this.juX.setText(((Object) this.juX.getText()) + valueOf + "KB");
                } else {
                    this.juX.setVisibility(8);
                }
            } else {
                this.juU.setText("");
                this.ais.setText("");
                this.juX.setText("");
            }
            this.juV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.aFd = true;
                        a.this.juV.setVisibility(8);
                        a.this.dWq.setVisibility(8);
                        a.this.juW.setVisibility(0);
                        PluginPackageManager.je().a(PluginDownloadActivity.this.juO, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.juO.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.juR.juW.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.juR.juW.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.juO.package_name)) {
                                    PluginDownloadActivity.this.juR.juW.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.juR.juW.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.juO.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.juR, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.dWq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aCY().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aCY().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.juO != null) {
            PluginPackageManager.je().bg(this.juO.package_name);
        }
        super.onDestroy();
    }
}
