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
    private PluginNetConfigInfos.PluginConfig ghO;
    private a ghQ;
    private boolean ghR;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ghO = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.ghO == null) {
            showToast(getPageContext().getString(d.k.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.ghQ = new a(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.ghQ.setCancelable(false);
        this.ghQ.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.ghR) {
                    g.b(PluginDownloadActivity.this.ghQ, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.ghQ.bjV.getVisibility() == 0) {
                        PluginDownloadActivity.this.ghQ.bjV.setVisibility(8);
                        PluginDownloadActivity.this.ghQ.ghT.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.ghQ.bjV.setVisibility(0);
                    PluginDownloadActivity.this.ghQ.ghT.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.ghQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.ghQ, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ghQ.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout bjV;
        private TextView bnQ;
        private TextView eYe;
        private TextView ezr;
        private LinearLayout ghT;
        private TextView ghU;
        private TextView ghV;
        private TextView ghW;
        private TextView ghX;
        private TextView ghY;
        private TextView ghZ;
        private TextView gia;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.i.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.ghT = (LinearLayout) findViewById(d.g.down_dialog);
            this.ghZ = (TextView) findViewById(d.g.update_tip);
            this.ghU = (TextView) findViewById(d.g.newversion);
            this.ezr = (TextView) findViewById(d.g.desc);
            this.ghV = (TextView) findViewById(d.g.update_button);
            this.ghV.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.install_app));
            this.bnQ = (TextView) findViewById(d.g.update_cancel);
            this.eYe = (TextView) findViewById(d.g.downloading);
            this.gia = (TextView) findViewById(d.g.otherApp);
            this.gia.setVisibility(8);
            this.ghW = (TextView) findViewById(d.g.app_size);
            this.bjV = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.ghX = (TextView) findViewById(d.g.sure_cancel);
            this.ghY = (TextView) findViewById(d.g.cancel_button);
            this.ghX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.ghY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bjV.setVisibility(8);
                    a.this.ghT.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.ghO.display_name)) {
                this.ghZ.setText(PluginDownloadActivity.this.ghO.display_name);
            } else {
                this.ghZ.setText("");
            }
            if (PluginDownloadActivity.this.ghO.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ghO.newest.version)) {
                    this.ghU.setText("版本：" + PluginDownloadActivity.this.ghO.newest.version);
                } else {
                    this.ghU.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.ghO.newest.change_log)) {
                    this.ezr.setText(PluginDownloadActivity.this.ghO.newest.change_log);
                } else {
                    this.ezr.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.ghO.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.ghW.setVisibility(0);
                    this.ghW.setText(((Object) this.ghW.getText()) + valueOf + "KB");
                } else {
                    this.ghW.setVisibility(8);
                }
            } else {
                this.ghU.setText("");
                this.ezr.setText("");
                this.ghW.setText("");
            }
            this.ghV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jD()) {
                        PluginDownloadActivity.this.ghR = true;
                        a.this.ghV.setVisibility(8);
                        a.this.bnQ.setVisibility(8);
                        a.this.eYe.setVisibility(0);
                        PluginPackageManager.lL().a(PluginDownloadActivity.this.ghO, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.ghO.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.ghQ.eYe.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.ghQ.eYe.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.ghO.package_name)) {
                                    PluginDownloadActivity.this.ghQ.eYe.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                                    PluginDownloadActivity.this.ghQ.eYe.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.ghO.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.ghQ, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.k.neterror);
                }
            });
            this.bnQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.ghO != null) {
            PluginPackageManager.lL().bJ(this.ghO.package_name);
        }
        super.onDestroy();
    }
}
