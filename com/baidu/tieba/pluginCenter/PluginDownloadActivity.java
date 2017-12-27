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
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean gFA;
    private PluginNetConfigInfos.PluginConfig gFx;
    private a gFz;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gFx = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gFx == null) {
            showToast(getPageContext().getString(d.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gFz = new a(getPageContext().getPageActivity(), d.k.common_alert_dialog);
        this.gFz.setCancelable(false);
        this.gFz.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gFA) {
                    g.b(PluginDownloadActivity.this.gFz, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gFz.bNY.getVisibility() == 0) {
                        PluginDownloadActivity.this.gFz.bNY.setVisibility(8);
                        PluginDownloadActivity.this.gFz.gFC.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gFz.bNY.setVisibility(0);
                    PluginDownloadActivity.this.gFz.gFC.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gFz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gFz, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aM(i == 1);
        getLayoutMode().aM(this.gFz.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bNY;
        private TextView bRR;
        private TextView eIl;
        private TextView fhK;
        private LinearLayout gFC;
        private TextView gFD;
        private TextView gFE;
        private TextView gFF;
        private TextView gFG;
        private TextView gFH;
        private TextView gFI;
        private TextView gFJ;

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
            this.gFC = (LinearLayout) findViewById(d.g.down_dialog);
            this.gFI = (TextView) findViewById(d.g.update_tip);
            this.gFD = (TextView) findViewById(d.g.newversion);
            this.eIl = (TextView) findViewById(d.g.desc);
            this.gFE = (TextView) findViewById(d.g.update_button);
            this.gFE.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.install_app));
            this.bRR = (TextView) findViewById(d.g.update_cancel);
            this.fhK = (TextView) findViewById(d.g.downloading);
            this.gFJ = (TextView) findViewById(d.g.otherApp);
            this.gFJ.setVisibility(8);
            this.gFF = (TextView) findViewById(d.g.app_size);
            this.bNY = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gFG = (TextView) findViewById(d.g.sure_cancel);
            this.gFH = (TextView) findViewById(d.g.cancel_button);
            this.gFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bNY.setVisibility(8);
                    a.this.gFC.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFx.display_name)) {
                this.gFI.setText(PluginDownloadActivity.this.gFx.display_name);
            } else {
                this.gFI.setText("");
            }
            if (PluginDownloadActivity.this.gFx.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFx.newest.version)) {
                    this.gFD.setText("版本：" + PluginDownloadActivity.this.gFx.newest.version);
                } else {
                    this.gFD.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFx.newest.change_log)) {
                    this.eIl.setText(PluginDownloadActivity.this.gFx.newest.change_log);
                } else {
                    this.eIl.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gFx.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gFF.setVisibility(0);
                    this.gFF.setText(((Object) this.gFF.getText()) + valueOf + "KB");
                } else {
                    this.gFF.setVisibility(8);
                }
            } else {
                this.gFD.setText("");
                this.eIl.setText("");
                this.gFF.setText("");
            }
            this.gFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.oI()) {
                        PluginDownloadActivity.this.gFA = true;
                        a.this.gFE.setVisibility(8);
                        a.this.bRR.setVisibility(8);
                        a.this.fhK.setVisibility(0);
                        PluginPackageManager.qR().a(PluginDownloadActivity.this.gFx, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFx.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gFz.fhK.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gFz.fhK.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFx.package_name)) {
                                    PluginDownloadActivity.this.gFz.fhK.setText(PluginDownloadActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gFz.fhK.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFx.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gFz, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.j.neterror);
                }
            });
            this.bRR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gFx != null) {
            PluginPackageManager.qR().by(this.gFx.package_name);
        }
        super.onDestroy();
    }
}
