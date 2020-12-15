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
    private boolean caI;
    private PluginNetConfigInfos.PluginConfig mBi;
    private a mBl;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBi = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mBi == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mBl = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mBl.setCancelable(false);
        this.mBl.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.caI) {
                    g.b(PluginDownloadActivity.this.mBl, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mBl.fYb.getVisibility() == 0) {
                        PluginDownloadActivity.this.mBl.fYb.setVisibility(8);
                        PluginDownloadActivity.this.mBl.mBn.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mBl.fYb.setVisibility(0);
                    PluginDownloadActivity.this.mBl.mBn.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mBl.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mBl, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mBl.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes21.dex */
    private class a extends Dialog {
        private TextView ajU;
        private LinearLayout fYb;
        private TextView gbu;
        private LinearLayout mBn;
        private TextView mBo;
        private TextView mBp;
        private TextView mBq;
        private TextView mBr;
        private TextView mBs;
        private TextView mBt;
        private TextView mBu;
        private TextView mBv;

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
            this.mBn = (LinearLayout) findViewById(R.id.down_dialog);
            this.mBu = (TextView) findViewById(R.id.update_tip);
            this.mBo = (TextView) findViewById(R.id.newversion);
            this.ajU = (TextView) findViewById(R.id.desc);
            this.mBp = (TextView) findViewById(R.id.update_button);
            this.mBp.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.gbu = (TextView) findViewById(R.id.update_cancel);
            this.mBq = (TextView) findViewById(R.id.downloading);
            this.mBv = (TextView) findViewById(R.id.otherApp);
            this.mBv.setVisibility(8);
            this.mBr = (TextView) findViewById(R.id.app_size);
            this.fYb = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mBs = (TextView) findViewById(R.id.sure_cancel);
            this.mBt = (TextView) findViewById(R.id.cancel_button);
            this.mBs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mBt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fYb.setVisibility(8);
                    a.this.mBn.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBi.display_name)) {
                this.mBu.setText(PluginDownloadActivity.this.mBi.display_name);
            } else {
                this.mBu.setText("");
            }
            if (PluginDownloadActivity.this.mBi.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBi.newest.version)) {
                    this.mBo.setText("版本：" + PluginDownloadActivity.this.mBi.newest.version);
                } else {
                    this.mBo.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBi.newest.change_log)) {
                    this.ajU.setText(PluginDownloadActivity.this.mBi.newest.change_log);
                } else {
                    this.ajU.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mBi.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mBr.setVisibility(0);
                    this.mBr.setText(((Object) this.mBr.getText()) + valueOf + "KB");
                } else {
                    this.mBr.setVisibility(8);
                }
            } else {
                this.mBo.setText("");
                this.ajU.setText("");
                this.mBr.setText("");
            }
            this.mBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.caI = true;
                        a.this.mBp.setVisibility(8);
                        a.this.gbu.setVisibility(8);
                        a.this.mBq.setVisibility(0);
                        PluginPackageManager.pV().a(PluginDownloadActivity.this.mBi, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBi.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mBl.mBq.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mBl.mBq.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBi.package_name)) {
                                    PluginDownloadActivity.this.mBl.mBq.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mBl.mBq.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBi.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mBl, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.gbu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.bsO().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.bsO().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mBi != null) {
            PluginPackageManager.pV().cK(this.mBi.package_name);
        }
        super.onDestroy();
    }
}
