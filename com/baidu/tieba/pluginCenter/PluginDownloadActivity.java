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
    private PluginNetConfigInfos.PluginConfig kDc;
    private a kDf;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kDc = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.kDc == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.kDf = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.kDf.setCancelable(false);
        this.kDf.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.bnO) {
                    g.b(PluginDownloadActivity.this.kDf, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.kDf.eLc.getVisibility() == 0) {
                        PluginDownloadActivity.this.kDf.eLc.setVisibility(8);
                        PluginDownloadActivity.this.kDf.kDh.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.kDf.eLc.setVisibility(0);
                    PluginDownloadActivity.this.kDf.kDh.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.kDf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.kDf, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.kDf.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView aJn;
        private LinearLayout eLc;
        private TextView ePy;
        private LinearLayout kDh;
        private TextView kDi;
        private TextView kDj;
        private TextView kDk;
        private TextView kDl;
        private TextView kDm;
        private TextView kDn;
        private TextView kDo;
        private TextView kDp;

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
            this.kDh = (LinearLayout) findViewById(R.id.down_dialog);
            this.kDo = (TextView) findViewById(R.id.update_tip);
            this.kDi = (TextView) findViewById(R.id.newversion);
            this.aJn = (TextView) findViewById(R.id.desc);
            this.kDj = (TextView) findViewById(R.id.update_button);
            this.kDj.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.ePy = (TextView) findViewById(R.id.update_cancel);
            this.kDk = (TextView) findViewById(R.id.downloading);
            this.kDp = (TextView) findViewById(R.id.otherApp);
            this.kDp.setVisibility(8);
            this.kDl = (TextView) findViewById(R.id.app_size);
            this.eLc = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.kDm = (TextView) findViewById(R.id.sure_cancel);
            this.kDn = (TextView) findViewById(R.id.cancel_button);
            this.kDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.kDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.eLc.setVisibility(8);
                    a.this.kDh.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.kDc.display_name)) {
                this.kDo.setText(PluginDownloadActivity.this.kDc.display_name);
            } else {
                this.kDo.setText("");
            }
            if (PluginDownloadActivity.this.kDc.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kDc.newest.version)) {
                    this.kDi.setText("版本：" + PluginDownloadActivity.this.kDc.newest.version);
                } else {
                    this.kDi.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.kDc.newest.change_log)) {
                    this.aJn.setText(PluginDownloadActivity.this.kDc.newest.change_log);
                } else {
                    this.aJn.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.kDc.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.kDl.setVisibility(0);
                    this.kDl.setText(((Object) this.kDl.getText()) + valueOf + "KB");
                } else {
                    this.kDl.setVisibility(8);
                }
            } else {
                this.kDi.setText("");
                this.aJn.setText("");
                this.kDl.setText("");
            }
            this.kDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.bnO = true;
                        a.this.kDj.setVisibility(8);
                        a.this.ePy.setVisibility(8);
                        a.this.kDk.setVisibility(0);
                        PluginPackageManager.nX().a(PluginDownloadActivity.this.kDc, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kDc.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.kDf.kDk.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.kDf.kDk.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kDc.package_name)) {
                                    PluginDownloadActivity.this.kDf.kDk.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.kDf.kDk.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.kDc.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.kDf, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.ePy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.kDc != null) {
            PluginPackageManager.nX().cy(this.kDc.package_name);
        }
        super.onDestroy();
    }
}
