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
    private boolean aem;
    private PluginNetConfigInfos.PluginConfig iDa;
    private a iDd;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iDa = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.iDa == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.iDd = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.iDd.setCancelable(false);
        this.iDd.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aem) {
                    g.b(PluginDownloadActivity.this.iDd, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.iDd.cVs.getVisibility() == 0) {
                        PluginDownloadActivity.this.iDd.cVs.setVisibility(8);
                        PluginDownloadActivity.this.iDd.iDf.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.iDd.cVs.setVisibility(0);
                    PluginDownloadActivity.this.iDd.iDf.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.iDd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.iDd, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iDd.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cVs;
        private TextView cZY;
        private TextView fQp;
        private LinearLayout iDf;
        private TextView iDg;
        private TextView iDh;
        private TextView iDi;
        private TextView iDj;
        private TextView iDk;
        private TextView iDl;
        private TextView iDm;
        private TextView iDn;

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
            this.iDf = (LinearLayout) findViewById(R.id.down_dialog);
            this.iDm = (TextView) findViewById(R.id.update_tip);
            this.iDg = (TextView) findViewById(R.id.newversion);
            this.fQp = (TextView) findViewById(R.id.desc);
            this.iDh = (TextView) findViewById(R.id.update_button);
            this.iDh.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cZY = (TextView) findViewById(R.id.update_cancel);
            this.iDi = (TextView) findViewById(R.id.downloading);
            this.iDn = (TextView) findViewById(R.id.otherApp);
            this.iDn.setVisibility(8);
            this.iDj = (TextView) findViewById(R.id.app_size);
            this.cVs = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.iDk = (TextView) findViewById(R.id.sure_cancel);
            this.iDl = (TextView) findViewById(R.id.cancel_button);
            this.iDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.iDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cVs.setVisibility(8);
                    a.this.iDf.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.iDa.display_name)) {
                this.iDm.setText(PluginDownloadActivity.this.iDa.display_name);
            } else {
                this.iDm.setText("");
            }
            if (PluginDownloadActivity.this.iDa.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iDa.newest.version)) {
                    this.iDg.setText("版本：" + PluginDownloadActivity.this.iDa.newest.version);
                } else {
                    this.iDg.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.iDa.newest.change_log)) {
                    this.fQp.setText(PluginDownloadActivity.this.iDa.newest.change_log);
                } else {
                    this.fQp.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.iDa.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.iDj.setVisibility(0);
                    this.iDj.setText(((Object) this.iDj.getText()) + valueOf + "KB");
                } else {
                    this.iDj.setVisibility(8);
                }
            } else {
                this.iDg.setText("");
                this.fQp.setText("");
                this.iDj.setText("");
            }
            this.iDh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        PluginDownloadActivity.this.aem = true;
                        a.this.iDh.setVisibility(8);
                        a.this.cZY.setVisibility(8);
                        a.this.iDi.setVisibility(0);
                        PluginPackageManager.ms().a(PluginDownloadActivity.this.iDa, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iDa.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.iDd.iDi.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.iDd.iDi.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iDa.package_name)) {
                                    PluginDownloadActivity.this.iDd.iDi.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.iDd.iDi.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.iDa.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.iDd, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cZY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.ahU().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.ahU().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.iDa != null) {
            PluginPackageManager.ms().bN(this.iDa.package_name);
        }
        super.onDestroy();
    }
}
