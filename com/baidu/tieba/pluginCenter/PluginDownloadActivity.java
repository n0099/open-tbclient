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
    private boolean adP;
    private PluginNetConfigInfos.PluginConfig itj;
    private a itm;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itj = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.itj == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.itm = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.itm.setCancelable(false);
        this.itm.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.adP) {
                    g.b(PluginDownloadActivity.this.itm, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.itm.cSU.getVisibility() == 0) {
                        PluginDownloadActivity.this.itm.cSU.setVisibility(8);
                        PluginDownloadActivity.this.itm.ito.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.itm.cSU.setVisibility(0);
                    PluginDownloadActivity.this.itm.ito.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.itm.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.itm, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.itm.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cSU;
        private TextView cWI;
        private TextView fIK;
        private LinearLayout ito;
        private TextView itp;
        private TextView itq;
        private TextView itr;
        private TextView its;
        private TextView itt;
        private TextView itu;
        private TextView itv;
        private TextView itw;

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
            this.ito = (LinearLayout) findViewById(R.id.down_dialog);
            this.itv = (TextView) findViewById(R.id.update_tip);
            this.itp = (TextView) findViewById(R.id.newversion);
            this.fIK = (TextView) findViewById(R.id.desc);
            this.itq = (TextView) findViewById(R.id.update_button);
            this.itq.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cWI = (TextView) findViewById(R.id.update_cancel);
            this.itr = (TextView) findViewById(R.id.downloading);
            this.itw = (TextView) findViewById(R.id.otherApp);
            this.itw.setVisibility(8);
            this.its = (TextView) findViewById(R.id.app_size);
            this.cSU = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.itt = (TextView) findViewById(R.id.sure_cancel);
            this.itu = (TextView) findViewById(R.id.cancel_button);
            this.itt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.itu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cSU.setVisibility(8);
                    a.this.ito.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.itj.display_name)) {
                this.itv.setText(PluginDownloadActivity.this.itj.display_name);
            } else {
                this.itv.setText("");
            }
            if (PluginDownloadActivity.this.itj.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itj.newest.version)) {
                    this.itp.setText("版本：" + PluginDownloadActivity.this.itj.newest.version);
                } else {
                    this.itp.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itj.newest.change_log)) {
                    this.fIK.setText(PluginDownloadActivity.this.itj.newest.change_log);
                } else {
                    this.fIK.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.itj.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.its.setVisibility(0);
                    this.its.setText(((Object) this.its.getText()) + valueOf + "KB");
                } else {
                    this.its.setVisibility(8);
                }
            } else {
                this.itp.setText("");
                this.fIK.setText("");
                this.its.setText("");
            }
            this.itq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jS()) {
                        PluginDownloadActivity.this.adP = true;
                        a.this.itq.setVisibility(8);
                        a.this.cWI.setVisibility(8);
                        a.this.itr.setVisibility(0);
                        PluginPackageManager.mc().a(PluginDownloadActivity.this.itj, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itj.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.itm.itr.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.itm.itr.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itj.package_name)) {
                                    PluginDownloadActivity.this.itm.itr.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.itm.itr.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itj.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.itm, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.agM().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.agM().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.itj != null) {
            PluginPackageManager.mc().bL(this.itj.package_name);
        }
        super.onDestroy();
    }
}
