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
    private boolean bRt;
    private boolean mFinished;
    private PluginNetConfigInfos.PluginConfig mgK;
    private a mgN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mgK = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mgK == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mgN = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mgN.setCancelable(false);
        this.mgN.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bRt) {
                    g.b(PluginDownloadActivity.this.mgN, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mgN.fKr.getVisibility() == 0) {
                        PluginDownloadActivity.this.mgN.fKr.setVisibility(8);
                        PluginDownloadActivity.this.mgN.mgP.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mgN.fKr.setVisibility(0);
                    PluginDownloadActivity.this.mgN.mgP.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mgN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mgN, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mgN.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes21.dex */
    private class a extends Dialog {
        private TextView aiQ;
        private LinearLayout fKr;
        private TextView fNL;
        private LinearLayout mgP;
        private TextView mgQ;
        private TextView mgR;
        private TextView mgS;
        private TextView mgT;
        private TextView mgU;
        private TextView mgV;
        private TextView mgW;
        private TextView mgX;

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
            this.mgP = (LinearLayout) findViewById(R.id.down_dialog);
            this.mgW = (TextView) findViewById(R.id.update_tip);
            this.mgQ = (TextView) findViewById(R.id.newversion);
            this.aiQ = (TextView) findViewById(R.id.desc);
            this.mgR = (TextView) findViewById(R.id.update_button);
            this.mgR.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.fNL = (TextView) findViewById(R.id.update_cancel);
            this.mgS = (TextView) findViewById(R.id.downloading);
            this.mgX = (TextView) findViewById(R.id.otherApp);
            this.mgX.setVisibility(8);
            this.mgT = (TextView) findViewById(R.id.app_size);
            this.fKr = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mgU = (TextView) findViewById(R.id.sure_cancel);
            this.mgV = (TextView) findViewById(R.id.cancel_button);
            this.mgU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mgV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fKr.setVisibility(8);
                    a.this.mgP.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mgK.display_name)) {
                this.mgW.setText(PluginDownloadActivity.this.mgK.display_name);
            } else {
                this.mgW.setText("");
            }
            if (PluginDownloadActivity.this.mgK.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mgK.newest.version)) {
                    this.mgQ.setText("版本：" + PluginDownloadActivity.this.mgK.newest.version);
                } else {
                    this.mgQ.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mgK.newest.change_log)) {
                    this.aiQ.setText(PluginDownloadActivity.this.mgK.newest.change_log);
                } else {
                    this.aiQ.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mgK.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mgT.setVisibility(0);
                    this.mgT.setText(((Object) this.mgT.getText()) + valueOf + "KB");
                } else {
                    this.mgT.setVisibility(8);
                }
            } else {
                this.mgQ.setText("");
                this.aiQ.setText("");
                this.mgT.setText("");
            }
            this.mgR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bRt = true;
                        a.this.mgR.setVisibility(8);
                        a.this.fNL.setVisibility(8);
                        a.this.mgS.setVisibility(0);
                        PluginPackageManager.pT().a(PluginDownloadActivity.this.mgK, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mgK.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mgN.mgS.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mgN.mgS.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mgK.package_name)) {
                                    PluginDownloadActivity.this.mgN.mgS.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mgN.mgS.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mgK.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mgN, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.fNL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bnH().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bnH().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mgK != null) {
            PluginPackageManager.pT().cF(this.mgK.package_name);
        }
        super.onDestroy();
    }
}
