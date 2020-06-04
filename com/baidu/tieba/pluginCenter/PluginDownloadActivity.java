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
    private boolean bnO;
    private PluginNetConfigInfos.PluginConfig kEk;
    private a kEn;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEk = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.kEk == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.kEn = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.kEn.setCancelable(false);
        this.kEn.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bnO) {
                    g.b(PluginDownloadActivity.this.kEn, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.kEn.eLn.getVisibility() == 0) {
                        PluginDownloadActivity.this.kEn.eLn.setVisibility(8);
                        PluginDownloadActivity.this.kEn.kEp.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.kEn.eLn.setVisibility(0);
                    PluginDownloadActivity.this.kEn.kEp.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.kEn.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.kEn, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kEn.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aJn;
        private LinearLayout eLn;
        private TextView ePJ;
        private LinearLayout kEp;
        private TextView kEq;
        private TextView kEr;
        private TextView kEs;
        private TextView kEt;
        private TextView kEu;
        private TextView kEv;
        private TextView kEw;
        private TextView kEx;

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
            this.kEp = (LinearLayout) findViewById(R.id.down_dialog);
            this.kEw = (TextView) findViewById(R.id.update_tip);
            this.kEq = (TextView) findViewById(R.id.newversion);
            this.aJn = (TextView) findViewById(R.id.desc);
            this.kEr = (TextView) findViewById(R.id.update_button);
            this.kEr.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.ePJ = (TextView) findViewById(R.id.update_cancel);
            this.kEs = (TextView) findViewById(R.id.downloading);
            this.kEx = (TextView) findViewById(R.id.otherApp);
            this.kEx.setVisibility(8);
            this.kEt = (TextView) findViewById(R.id.app_size);
            this.eLn = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.kEu = (TextView) findViewById(R.id.sure_cancel);
            this.kEv = (TextView) findViewById(R.id.cancel_button);
            this.kEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.kEv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.eLn.setVisibility(8);
                    a.this.kEp.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.kEk.display_name)) {
                this.kEw.setText(PluginDownloadActivity.this.kEk.display_name);
            } else {
                this.kEw.setText("");
            }
            if (PluginDownloadActivity.this.kEk.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kEk.newest.version)) {
                    this.kEq.setText("版本：" + PluginDownloadActivity.this.kEk.newest.version);
                } else {
                    this.kEq.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kEk.newest.change_log)) {
                    this.aJn.setText(PluginDownloadActivity.this.kEk.newest.change_log);
                } else {
                    this.aJn.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.kEk.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.kEt.setVisibility(0);
                    this.kEt.setText(((Object) this.kEt.getText()) + valueOf + "KB");
                } else {
                    this.kEt.setVisibility(8);
                }
            } else {
                this.kEq.setText("");
                this.aJn.setText("");
                this.kEt.setText("");
            }
            this.kEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bnO = true;
                        a.this.kEr.setVisibility(8);
                        a.this.ePJ.setVisibility(8);
                        a.this.kEs.setVisibility(0);
                        PluginPackageManager.nX().a(PluginDownloadActivity.this.kEk, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kEk.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.kEn.kEs.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.kEn.kEs.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kEk.package_name)) {
                                    PluginDownloadActivity.this.kEn.kEs.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.kEn.kEs.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kEk.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.kEn, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.ePJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aTX().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aTX().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kEk != null) {
            PluginPackageManager.nX().cy(this.kEk.package_name);
        }
        super.onDestroy();
    }
}
