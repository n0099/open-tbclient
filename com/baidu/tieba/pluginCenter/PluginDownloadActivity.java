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
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes3.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig iaR;
    private a iaU;
    private boolean iaV;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iaR = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iaR == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iaU = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.iaU.setCancelable(false);
        this.iaU.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.iaV) {
                    g.b(PluginDownloadActivity.this.iaU, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iaU.cKG.getVisibility() == 0) {
                        PluginDownloadActivity.this.iaU.cKG.setVisibility(8);
                        PluginDownloadActivity.this.iaU.iaX.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iaU.cKG.setVisibility(0);
                    PluginDownloadActivity.this.iaU.iaX.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iaU.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iaU, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iaU.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cKG;
        private TextView cOu;
        private TextView fsD;
        private LinearLayout iaX;
        private TextView iaY;
        private TextView iaZ;
        private TextView iba;
        private TextView ibb;
        private TextView ibc;
        private TextView ibd;
        private TextView ibe;
        private TextView ibf;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.h.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.iaX = (LinearLayout) findViewById(d.g.down_dialog);
            this.ibe = (TextView) findViewById(d.g.update_tip);
            this.iaY = (TextView) findViewById(d.g.newversion);
            this.fsD = (TextView) findViewById(d.g.desc);
            this.iaZ = (TextView) findViewById(d.g.update_button);
            this.iaZ.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.cOu = (TextView) findViewById(d.g.update_cancel);
            this.iba = (TextView) findViewById(d.g.downloading);
            this.ibf = (TextView) findViewById(d.g.otherApp);
            this.ibf.setVisibility(8);
            this.ibb = (TextView) findViewById(d.g.app_size);
            this.cKG = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.ibc = (TextView) findViewById(d.g.sure_cancel);
            this.ibd = (TextView) findViewById(d.g.cancel_button);
            this.ibc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.ibd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cKG.setVisibility(8);
                    a.this.iaX.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaR.display_name)) {
                this.ibe.setText(PluginDownloadActivity.this.iaR.display_name);
            } else {
                this.ibe.setText("");
            }
            if (PluginDownloadActivity.this.iaR.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaR.newest.version)) {
                    this.iaY.setText("版本：" + PluginDownloadActivity.this.iaR.newest.version);
                } else {
                    this.iaY.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iaR.newest.change_log)) {
                    this.fsD.setText(PluginDownloadActivity.this.iaR.newest.change_log);
                } else {
                    this.fsD.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iaR.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.ibb.setVisibility(0);
                    this.ibb.setText(((Object) this.ibb.getText()) + valueOf + "KB");
                } else {
                    this.ibb.setVisibility(8);
                }
            } else {
                this.iaY.setText("");
                this.fsD.setText("");
                this.ibb.setText("");
            }
            this.iaZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kY()) {
                        PluginDownloadActivity.this.iaV = true;
                        a.this.iaZ.setVisibility(8);
                        a.this.cOu.setVisibility(8);
                        a.this.iba.setVisibility(0);
                        PluginPackageManager.ni().a(PluginDownloadActivity.this.iaR, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaR.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iaU.iba.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iaU.iba.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaR.package_name)) {
                                    PluginDownloadActivity.this.iaU.iba.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.iaU.iba.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iaR.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iaU, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.cOu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.iaR != null) {
            PluginPackageManager.ni().cb(this.iaR.package_name);
        }
        super.onDestroy();
    }
}
