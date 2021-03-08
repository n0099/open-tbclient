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
/* loaded from: classes7.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean cip;
    private boolean mFinished;
    private PluginNetConfigInfos.PluginConfig mNp;
    private a mNs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mNp = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mNp == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mNs = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mNs.setCancelable(false);
        this.mNs.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.cip) {
                    g.b(PluginDownloadActivity.this.mNs, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mNs.ggX.getVisibility() == 0) {
                        PluginDownloadActivity.this.mNs.ggX.setVisibility(8);
                        PluginDownloadActivity.this.mNs.mNu.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mNs.ggX.setVisibility(0);
                    PluginDownloadActivity.this.mNs.mNu.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mNs.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mNs, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mNs.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes7.dex */
    private class a extends Dialog {
        private TextView akM;
        private LinearLayout ggX;
        private TextView gkk;
        private TextView mNA;
        private TextView mNB;
        private TextView mNC;
        private LinearLayout mNu;
        private TextView mNv;
        private TextView mNw;
        private TextView mNx;
        private TextView mNy;
        private TextView mNz;

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
            this.mNu = (LinearLayout) findViewById(R.id.down_dialog);
            this.mNB = (TextView) findViewById(R.id.update_tip);
            this.mNv = (TextView) findViewById(R.id.newversion);
            this.akM = (TextView) findViewById(R.id.desc);
            this.mNw = (TextView) findViewById(R.id.update_button);
            this.mNw.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.gkk = (TextView) findViewById(R.id.update_cancel);
            this.mNx = (TextView) findViewById(R.id.downloading);
            this.mNC = (TextView) findViewById(R.id.otherApp);
            this.mNC.setVisibility(8);
            this.mNy = (TextView) findViewById(R.id.app_size);
            this.ggX = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mNz = (TextView) findViewById(R.id.sure_cancel);
            this.mNA = (TextView) findViewById(R.id.cancel_button);
            this.mNz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ggX.setVisibility(8);
                    a.this.mNu.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mNp.display_name)) {
                this.mNB.setText(PluginDownloadActivity.this.mNp.display_name);
            } else {
                this.mNB.setText("");
            }
            if (PluginDownloadActivity.this.mNp.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mNp.newest.version)) {
                    this.mNv.setText("版本：" + PluginDownloadActivity.this.mNp.newest.version);
                } else {
                    this.mNv.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mNp.newest.change_log)) {
                    this.akM.setText(PluginDownloadActivity.this.mNp.newest.change_log);
                } else {
                    this.akM.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mNp.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mNy.setVisibility(0);
                    this.mNy.setText(((Object) this.mNy.getText()) + valueOf + "KB");
                } else {
                    this.mNy.setVisibility(8);
                }
            } else {
                this.mNv.setText("");
                this.akM.setText("");
                this.mNy.setText("");
            }
            this.mNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.cip = true;
                        a.this.mNw.setVisibility(8);
                        a.this.gkk.setVisibility(8);
                        a.this.mNx.setVisibility(0);
                        PluginPackageManager.pv().a(PluginDownloadActivity.this.mNp, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mNp.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mNs.mNx.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mNs.mNx.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mNp.package_name)) {
                                    PluginDownloadActivity.this.mNs.mNx.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mNs.mNx.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mNp.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mNs, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.gkk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.brR().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.brR().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mNp != null) {
            PluginPackageManager.pv().cH(this.mNp.package_name);
        }
        super.onDestroy();
    }
}
