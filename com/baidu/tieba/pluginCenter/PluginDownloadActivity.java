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
    private PluginNetConfigInfos.PluginConfig mBf;
    private a mBj;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBf = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.mBf == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.mBj = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.mBj.setCancelable(false);
        this.mBj.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.caI) {
                    g.b(PluginDownloadActivity.this.mBj, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.mBj.fXZ.getVisibility() == 0) {
                        PluginDownloadActivity.this.mBj.fXZ.setVisibility(8);
                        PluginDownloadActivity.this.mBj.mBl.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.mBj.fXZ.setVisibility(0);
                    PluginDownloadActivity.this.mBj.mBl.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.mBj.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.mBj, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.mBj.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes21.dex */
    private class a extends Dialog {
        private TextView ajU;
        private LinearLayout fXZ;
        private TextView gbs;
        private LinearLayout mBl;
        private TextView mBm;
        private TextView mBn;
        private TextView mBo;
        private TextView mBp;
        private TextView mBq;
        private TextView mBr;
        private TextView mBs;
        private TextView mBt;

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
            this.mBl = (LinearLayout) findViewById(R.id.down_dialog);
            this.mBs = (TextView) findViewById(R.id.update_tip);
            this.mBm = (TextView) findViewById(R.id.newversion);
            this.ajU = (TextView) findViewById(R.id.desc);
            this.mBn = (TextView) findViewById(R.id.update_button);
            this.mBn.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.gbs = (TextView) findViewById(R.id.update_cancel);
            this.mBo = (TextView) findViewById(R.id.downloading);
            this.mBt = (TextView) findViewById(R.id.otherApp);
            this.mBt.setVisibility(8);
            this.mBp = (TextView) findViewById(R.id.app_size);
            this.fXZ = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.mBq = (TextView) findViewById(R.id.sure_cancel);
            this.mBr = (TextView) findViewById(R.id.cancel_button);
            this.mBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.mBr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.fXZ.setVisibility(8);
                    a.this.mBl.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBf.display_name)) {
                this.mBs.setText(PluginDownloadActivity.this.mBf.display_name);
            } else {
                this.mBs.setText("");
            }
            if (PluginDownloadActivity.this.mBf.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBf.newest.version)) {
                    this.mBm.setText("版本：" + PluginDownloadActivity.this.mBf.newest.version);
                } else {
                    this.mBm.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.mBf.newest.change_log)) {
                    this.ajU.setText(PluginDownloadActivity.this.mBf.newest.change_log);
                } else {
                    this.ajU.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.mBf.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.mBp.setVisibility(0);
                    this.mBp.setText(((Object) this.mBp.getText()) + valueOf + "KB");
                } else {
                    this.mBp.setVisibility(8);
                }
            } else {
                this.mBm.setText("");
                this.ajU.setText("");
                this.mBp.setText("");
            }
            this.mBn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.caI = true;
                        a.this.mBn.setVisibility(8);
                        a.this.gbs.setVisibility(8);
                        a.this.mBo.setVisibility(0);
                        PluginPackageManager.pV().a(PluginDownloadActivity.this.mBf, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBf.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.mBj.mBo.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.mBj.mBo.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBf.package_name)) {
                                    PluginDownloadActivity.this.mBj.mBo.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.mBj.mBo.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.mBf.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.mBj, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.gbs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.mBf != null) {
            PluginPackageManager.pV().cK(this.mBf.package_name);
        }
        super.onDestroy();
    }
}
