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
/* loaded from: classes15.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean byW;
    private PluginNetConfigInfos.PluginConfig lvV;
    private a lvY;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lvV = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.lvV == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.lvY = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.lvY.setCancelable(false);
        this.lvY.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.byW) {
                    g.b(PluginDownloadActivity.this.lvY, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.lvY.fmA.getVisibility() == 0) {
                        PluginDownloadActivity.this.lvY.fmA.setVisibility(8);
                        PluginDownloadActivity.this.lvY.lwa.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.lvY.fmA.setVisibility(0);
                    PluginDownloadActivity.this.lvY.lwa.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.lvY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.lvY, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.lvY.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes15.dex */
    private class a extends Dialog {
        private TextView aia;
        private LinearLayout fmA;
        private TextView fpP;
        private LinearLayout lwa;
        private TextView lwb;
        private TextView lwc;
        private TextView lwd;
        private TextView lwe;
        private TextView lwf;
        private TextView lwg;
        private TextView lwh;
        private TextView lwi;

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
            this.lwa = (LinearLayout) findViewById(R.id.down_dialog);
            this.lwh = (TextView) findViewById(R.id.update_tip);
            this.lwb = (TextView) findViewById(R.id.newversion);
            this.aia = (TextView) findViewById(R.id.desc);
            this.lwc = (TextView) findViewById(R.id.update_button);
            this.lwc.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.fpP = (TextView) findViewById(R.id.update_cancel);
            this.lwd = (TextView) findViewById(R.id.downloading);
            this.lwi = (TextView) findViewById(R.id.otherApp);
            this.lwi.setVisibility(8);
            this.lwe = (TextView) findViewById(R.id.app_size);
            this.fmA = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.lwf = (TextView) findViewById(R.id.sure_cancel);
            this.lwg = (TextView) findViewById(R.id.cancel_button);
            this.lwf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.lwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fmA.setVisibility(8);
                    a.this.lwa.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.lvV.display_name)) {
                this.lwh.setText(PluginDownloadActivity.this.lvV.display_name);
            } else {
                this.lwh.setText("");
            }
            if (PluginDownloadActivity.this.lvV.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lvV.newest.version)) {
                    this.lwb.setText("版本：" + PluginDownloadActivity.this.lvV.newest.version);
                } else {
                    this.lwb.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.lvV.newest.change_log)) {
                    this.aia.setText(PluginDownloadActivity.this.lvV.newest.change_log);
                } else {
                    this.aia.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.lvV.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.lwe.setVisibility(0);
                    this.lwe.setText(((Object) this.lwe.getText()) + valueOf + "KB");
                } else {
                    this.lwe.setVisibility(8);
                }
            } else {
                this.lwb.setText("");
                this.aia.setText("");
                this.lwe.setText("");
            }
            this.lwc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.byW = true;
                        a.this.lwc.setVisibility(8);
                        a.this.fpP.setVisibility(8);
                        a.this.lwd.setVisibility(0);
                        PluginPackageManager.pO().a(PluginDownloadActivity.this.lvV, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lvV.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.lvY.lwd.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.lvY.lwd.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lvV.package_name)) {
                                    PluginDownloadActivity.this.lvY.lwd.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.lvY.lwd.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.lvV.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.lvY, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.fpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bik().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bik().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lvV != null) {
            PluginPackageManager.pO().cC(this.lvV.package_name);
        }
        super.onDestroy();
    }
}
