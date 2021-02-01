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
    private boolean cgO;
    private boolean mFinished;
    private PluginNetConfigInfos.PluginConfig mKY;
    private a mLb;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mKY = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mKY == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mLb = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mLb.setCancelable(false);
        this.mLb.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.cgO) {
                    g.b(PluginDownloadActivity.this.mLb, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mLb.gfp.getVisibility() == 0) {
                        PluginDownloadActivity.this.mLb.gfp.setVisibility(8);
                        PluginDownloadActivity.this.mLb.mLd.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mLb.gfp.setVisibility(0);
                    PluginDownloadActivity.this.mLb.mLd.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mLb.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mLb, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mLb.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aju;
        private LinearLayout gfp;
        private TextView git;
        private LinearLayout mLd;
        private TextView mLe;
        private TextView mLf;
        private TextView mLg;
        private TextView mLh;
        private TextView mLi;
        private TextView mLj;
        private TextView mLk;
        private TextView mLl;

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
            this.mLd = (LinearLayout) findViewById(R.id.down_dialog);
            this.mLk = (TextView) findViewById(R.id.update_tip);
            this.mLe = (TextView) findViewById(R.id.newversion);
            this.aju = (TextView) findViewById(R.id.desc);
            this.mLf = (TextView) findViewById(R.id.update_button);
            this.mLf.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.git = (TextView) findViewById(R.id.update_cancel);
            this.mLg = (TextView) findViewById(R.id.downloading);
            this.mLl = (TextView) findViewById(R.id.otherApp);
            this.mLl.setVisibility(8);
            this.mLh = (TextView) findViewById(R.id.app_size);
            this.gfp = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mLi = (TextView) findViewById(R.id.sure_cancel);
            this.mLj = (TextView) findViewById(R.id.cancel_button);
            this.mLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mLj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gfp.setVisibility(8);
                    a.this.mLd.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mKY.display_name)) {
                this.mLk.setText(PluginDownloadActivity.this.mKY.display_name);
            } else {
                this.mLk.setText("");
            }
            if (PluginDownloadActivity.this.mKY.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mKY.newest.version)) {
                    this.mLe.setText("版本：" + PluginDownloadActivity.this.mKY.newest.version);
                } else {
                    this.mLe.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mKY.newest.change_log)) {
                    this.aju.setText(PluginDownloadActivity.this.mKY.newest.change_log);
                } else {
                    this.aju.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mKY.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mLh.setVisibility(0);
                    this.mLh.setText(((Object) this.mLh.getText()) + valueOf + "KB");
                } else {
                    this.mLh.setVisibility(8);
                }
            } else {
                this.mLe.setText("");
                this.aju.setText("");
                this.mLh.setText("");
            }
            this.mLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.cgO = true;
                        a.this.mLf.setVisibility(8);
                        a.this.git.setVisibility(8);
                        a.this.mLg.setVisibility(0);
                        PluginPackageManager.pv().a(PluginDownloadActivity.this.mKY, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mKY.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mLb.mLg.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mLb.mLg.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mKY.package_name)) {
                                    PluginDownloadActivity.this.mLb.mLg.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mLb.mLg.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mKY.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mLb, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.git.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.brQ().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.brQ().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mKY != null) {
            PluginPackageManager.pv().cD(this.mKY.package_name);
        }
        super.onDestroy();
    }
}
