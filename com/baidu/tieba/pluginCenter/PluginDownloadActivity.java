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
import com.baidu.tieba.R;
import java.util.Date;
/* loaded from: classes3.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean axK;
    private PluginNetConfigInfos.PluginConfig iBw;
    private a iBz;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iBw = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iBw == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iBz = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.iBz.setCancelable(false);
        this.iBz.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.axK) {
                    g.b(PluginDownloadActivity.this.iBz, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iBz.deN.getVisibility() == 0) {
                        PluginDownloadActivity.this.iBz.deN.setVisibility(8);
                        PluginDownloadActivity.this.iBz.iBB.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iBz.deN.setVisibility(0);
                    PluginDownloadActivity.this.iBz.iBB.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iBz.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iBz, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iBz.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private TextView aaF;
        private LinearLayout deN;
        private TextView djx;
        private LinearLayout iBB;
        private TextView iBC;
        private TextView iBD;
        private TextView iBE;
        private TextView iBF;
        private TextView iBG;
        private TextView iBH;
        private TextView iBI;
        private TextView iBJ;

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
            this.iBB = (LinearLayout) findViewById(R.id.down_dialog);
            this.iBI = (TextView) findViewById(R.id.update_tip);
            this.iBC = (TextView) findViewById(R.id.newversion);
            this.aaF = (TextView) findViewById(R.id.desc);
            this.iBD = (TextView) findViewById(R.id.update_button);
            this.iBD.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.djx = (TextView) findViewById(R.id.update_cancel);
            this.iBE = (TextView) findViewById(R.id.downloading);
            this.iBJ = (TextView) findViewById(R.id.otherApp);
            this.iBJ.setVisibility(8);
            this.iBF = (TextView) findViewById(R.id.app_size);
            this.deN = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.iBG = (TextView) findViewById(R.id.sure_cancel);
            this.iBH = (TextView) findViewById(R.id.cancel_button);
            this.iBG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.deN.setVisibility(8);
                    a.this.iBB.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iBw.display_name)) {
                this.iBI.setText(PluginDownloadActivity.this.iBw.display_name);
            } else {
                this.iBI.setText("");
            }
            if (PluginDownloadActivity.this.iBw.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iBw.newest.version)) {
                    this.iBC.setText("版本：" + PluginDownloadActivity.this.iBw.newest.version);
                } else {
                    this.iBC.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iBw.newest.change_log)) {
                    this.aaF.setText(PluginDownloadActivity.this.iBw.newest.change_log);
                } else {
                    this.aaF.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iBw.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iBF.setVisibility(0);
                    this.iBF.setText(((Object) this.iBF.getText()) + valueOf + "KB");
                } else {
                    this.iBF.setVisibility(8);
                }
            } else {
                this.iBC.setText("");
                this.aaF.setText("");
                this.iBF.setText("");
            }
            this.iBD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.axK = true;
                        a.this.iBD.setVisibility(8);
                        a.this.djx.setVisibility(8);
                        a.this.iBE.setVisibility(0);
                        PluginPackageManager.iL().a(PluginDownloadActivity.this.iBw, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iBw.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iBz.iBE.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iBz.iBE.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iBw.package_name)) {
                                    PluginDownloadActivity.this.iBz.iBE.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.iBz.iBE.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iBw.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iBz, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.djx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.alR().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.alR().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iBw != null) {
            PluginPackageManager.iL().aU(this.iBw.package_name);
        }
        super.onDestroy();
    }
}
