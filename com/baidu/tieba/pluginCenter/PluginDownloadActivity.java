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
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.e;
import java.util.Date;
/* loaded from: classes4.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private a gFB;
    private boolean gFC;
    private PluginNetConfigInfos.PluginConfig gFz;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gFz = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gFz == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gFB = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gFB.setCancelable(false);
        this.gFB.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gFC) {
                    g.b(PluginDownloadActivity.this.gFB, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gFB.byL.getVisibility() == 0) {
                        PluginDownloadActivity.this.gFB.byL.setVisibility(8);
                        PluginDownloadActivity.this.gFB.gFE.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gFB.byL.setVisibility(0);
                    PluginDownloadActivity.this.gFB.gFE.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gFB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gFB, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gFB.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private TextView bCz;
        private LinearLayout byL;
        private TextView eaQ;
        private LinearLayout gFE;
        private TextView gFF;
        private TextView gFG;
        private TextView gFH;
        private TextView gFI;
        private TextView gFJ;
        private TextView gFK;
        private TextView gFL;
        private TextView gFM;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(e.h.update_dialog);
            findViewById(e.g.warning).setVisibility(8);
            findViewById(e.g.incremental_button).setVisibility(8);
            findViewById(e.g.incremental_size).setVisibility(8);
            this.gFE = (LinearLayout) findViewById(e.g.down_dialog);
            this.gFL = (TextView) findViewById(e.g.update_tip);
            this.gFF = (TextView) findViewById(e.g.newversion);
            this.eaQ = (TextView) findViewById(e.g.desc);
            this.gFG = (TextView) findViewById(e.g.update_button);
            this.gFG.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.bCz = (TextView) findViewById(e.g.update_cancel);
            this.gFH = (TextView) findViewById(e.g.downloading);
            this.gFM = (TextView) findViewById(e.g.otherApp);
            this.gFM.setVisibility(8);
            this.gFI = (TextView) findViewById(e.g.app_size);
            this.byL = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gFJ = (TextView) findViewById(e.g.sure_cancel);
            this.gFK = (TextView) findViewById(e.g.cancel_button);
            this.gFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.byL.setVisibility(8);
                    a.this.gFE.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFz.display_name)) {
                this.gFL.setText(PluginDownloadActivity.this.gFz.display_name);
            } else {
                this.gFL.setText("");
            }
            if (PluginDownloadActivity.this.gFz.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFz.newest.version)) {
                    this.gFF.setText("版本：" + PluginDownloadActivity.this.gFz.newest.version);
                } else {
                    this.gFF.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gFz.newest.change_log)) {
                    this.eaQ.setText(PluginDownloadActivity.this.gFz.newest.change_log);
                } else {
                    this.eaQ.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gFz.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gFI.setVisibility(0);
                    this.gFI.setText(((Object) this.gFI.getText()) + valueOf + "KB");
                } else {
                    this.gFI.setVisibility(8);
                }
            } else {
                this.gFF.setText("");
                this.eaQ.setText("");
                this.gFI.setText("");
            }
            this.gFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        PluginDownloadActivity.this.gFC = true;
                        a.this.gFG.setVisibility(8);
                        a.this.bCz.setVisibility(8);
                        a.this.gFH.setVisibility(0);
                        PluginPackageManager.na().a(PluginDownloadActivity.this.gFz, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFz.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gFB.gFH.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gFB.gFH.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFz.package_name)) {
                                    PluginDownloadActivity.this.gFB.gFH.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gFB.gFH.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gFz.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gFB, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.bCz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gFz != null) {
            PluginPackageManager.na().ca(this.gFz.package_name);
        }
        super.onDestroy();
    }
}
