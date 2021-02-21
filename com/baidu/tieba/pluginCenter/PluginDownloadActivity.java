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
    private PluginNetConfigInfos.PluginConfig mLn;
    private a mLq;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLn = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mLn == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mLq = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mLq.setCancelable(false);
        this.mLq.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.cgO) {
                    g.b(PluginDownloadActivity.this.mLq, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mLq.gfu.getVisibility() == 0) {
                        PluginDownloadActivity.this.mLq.gfu.setVisibility(8);
                        PluginDownloadActivity.this.mLq.mLs.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mLq.gfu.setVisibility(0);
                    PluginDownloadActivity.this.mLq.mLs.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mLq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mLq, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mLq.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aju;
        private LinearLayout gfu;
        private TextView giH;
        private TextView mLA;
        private LinearLayout mLs;
        private TextView mLt;
        private TextView mLu;
        private TextView mLv;
        private TextView mLw;
        private TextView mLx;
        private TextView mLy;
        private TextView mLz;

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
            this.mLs = (LinearLayout) findViewById(R.id.down_dialog);
            this.mLz = (TextView) findViewById(R.id.update_tip);
            this.mLt = (TextView) findViewById(R.id.newversion);
            this.aju = (TextView) findViewById(R.id.desc);
            this.mLu = (TextView) findViewById(R.id.update_button);
            this.mLu.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.giH = (TextView) findViewById(R.id.update_cancel);
            this.mLv = (TextView) findViewById(R.id.downloading);
            this.mLA = (TextView) findViewById(R.id.otherApp);
            this.mLA.setVisibility(8);
            this.mLw = (TextView) findViewById(R.id.app_size);
            this.gfu = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mLx = (TextView) findViewById(R.id.sure_cancel);
            this.mLy = (TextView) findViewById(R.id.cancel_button);
            this.mLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mLy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.gfu.setVisibility(8);
                    a.this.mLs.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mLn.display_name)) {
                this.mLz.setText(PluginDownloadActivity.this.mLn.display_name);
            } else {
                this.mLz.setText("");
            }
            if (PluginDownloadActivity.this.mLn.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mLn.newest.version)) {
                    this.mLt.setText("版本：" + PluginDownloadActivity.this.mLn.newest.version);
                } else {
                    this.mLt.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mLn.newest.change_log)) {
                    this.aju.setText(PluginDownloadActivity.this.mLn.newest.change_log);
                } else {
                    this.aju.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mLn.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mLw.setVisibility(0);
                    this.mLw.setText(((Object) this.mLw.getText()) + valueOf + "KB");
                } else {
                    this.mLw.setVisibility(8);
                }
            } else {
                this.mLt.setText("");
                this.aju.setText("");
                this.mLw.setText("");
            }
            this.mLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.cgO = true;
                        a.this.mLu.setVisibility(8);
                        a.this.giH.setVisibility(8);
                        a.this.mLv.setVisibility(0);
                        PluginPackageManager.pv().a(PluginDownloadActivity.this.mLn, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mLn.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mLq.mLv.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mLq.mLv.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mLn.package_name)) {
                                    PluginDownloadActivity.this.mLq.mLv.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mLq.mLv.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mLn.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mLq, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.giH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.mLn != null) {
            PluginPackageManager.pv().cD(this.mLn.package_name);
        }
        super.onDestroy();
    }
}
