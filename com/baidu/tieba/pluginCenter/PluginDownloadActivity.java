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
/* loaded from: classes21.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean bXd;
    private boolean mFinished;
    private PluginNetConfigInfos.PluginConfig mmI;
    private a mmL;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mmI = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mmI == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mmL = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mmL.setCancelable(false);
        this.mmL.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bXd) {
                    g.b(PluginDownloadActivity.this.mmL, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mmL.fQh.getVisibility() == 0) {
                        PluginDownloadActivity.this.mmL.fQh.setVisibility(8);
                        PluginDownloadActivity.this.mmL.mmN.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mmL.fQh.setVisibility(0);
                    PluginDownloadActivity.this.mmL.mmN.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mmL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mmL, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mmL.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes21.dex */
    private class a extends Dialog {
        private TextView aiQ;
        private LinearLayout fQh;
        private TextView fTB;
        private LinearLayout mmN;
        private TextView mmO;
        private TextView mmP;
        private TextView mmQ;
        private TextView mmR;
        private TextView mmS;
        private TextView mmT;
        private TextView mmU;
        private TextView mmV;

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
            this.mmN = (LinearLayout) findViewById(R.id.down_dialog);
            this.mmU = (TextView) findViewById(R.id.update_tip);
            this.mmO = (TextView) findViewById(R.id.newversion);
            this.aiQ = (TextView) findViewById(R.id.desc);
            this.mmP = (TextView) findViewById(R.id.update_button);
            this.mmP.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.fTB = (TextView) findViewById(R.id.update_cancel);
            this.mmQ = (TextView) findViewById(R.id.downloading);
            this.mmV = (TextView) findViewById(R.id.otherApp);
            this.mmV.setVisibility(8);
            this.mmR = (TextView) findViewById(R.id.app_size);
            this.fQh = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mmS = (TextView) findViewById(R.id.sure_cancel);
            this.mmT = (TextView) findViewById(R.id.cancel_button);
            this.mmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fQh.setVisibility(8);
                    a.this.mmN.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mmI.display_name)) {
                this.mmU.setText(PluginDownloadActivity.this.mmI.display_name);
            } else {
                this.mmU.setText("");
            }
            if (PluginDownloadActivity.this.mmI.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mmI.newest.version)) {
                    this.mmO.setText("版本：" + PluginDownloadActivity.this.mmI.newest.version);
                } else {
                    this.mmO.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mmI.newest.change_log)) {
                    this.aiQ.setText(PluginDownloadActivity.this.mmI.newest.change_log);
                } else {
                    this.aiQ.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mmI.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mmR.setVisibility(0);
                    this.mmR.setText(((Object) this.mmR.getText()) + valueOf + "KB");
                } else {
                    this.mmR.setVisibility(8);
                }
            } else {
                this.mmO.setText("");
                this.aiQ.setText("");
                this.mmR.setText("");
            }
            this.mmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bXd = true;
                        a.this.mmP.setVisibility(8);
                        a.this.fTB.setVisibility(8);
                        a.this.mmQ.setVisibility(0);
                        PluginPackageManager.pT().a(PluginDownloadActivity.this.mmI, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mmI.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mmL.mmQ.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mmL.mmQ.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mmI.package_name)) {
                                    PluginDownloadActivity.this.mmL.mmQ.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mmL.mmQ.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mmI.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mmL, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.fTB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bqh().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bqh().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mmI != null) {
            PluginPackageManager.pT().cF(this.mmI.package_name);
        }
        super.onDestroy();
    }
}
