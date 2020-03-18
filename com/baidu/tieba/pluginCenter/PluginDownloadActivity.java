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
    private boolean aKr;
    private PluginNetConfigInfos.PluginConfig jAY;
    private a jBb;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jAY = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.jAY == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.jBb = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.jBb.setCancelable(false);
        this.jBb.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aKr) {
                    g.b(PluginDownloadActivity.this.jBb, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.jBb.dWw.getVisibility() == 0) {
                        PluginDownloadActivity.this.jBb.dWw.setVisibility(8);
                        PluginDownloadActivity.this.jBb.jBd.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.jBb.dWw.setVisibility(0);
                    PluginDownloadActivity.this.jBb.jBd.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.jBb.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.jBb, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jBb.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes8.dex */
    private class a extends Dialog {
        private TextView alt;
        private LinearLayout dWw;
        private TextView ebh;
        private LinearLayout jBd;
        private TextView jBe;
        private TextView jBf;
        private TextView jBg;
        private TextView jBh;
        private TextView jBi;
        private TextView jBj;
        private TextView jBk;
        private TextView jBl;

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
            this.jBd = (LinearLayout) findViewById(R.id.down_dialog);
            this.jBk = (TextView) findViewById(R.id.update_tip);
            this.jBe = (TextView) findViewById(R.id.newversion);
            this.alt = (TextView) findViewById(R.id.desc);
            this.jBf = (TextView) findViewById(R.id.update_button);
            this.jBf.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.ebh = (TextView) findViewById(R.id.update_cancel);
            this.jBg = (TextView) findViewById(R.id.downloading);
            this.jBl = (TextView) findViewById(R.id.otherApp);
            this.jBl.setVisibility(8);
            this.jBh = (TextView) findViewById(R.id.app_size);
            this.dWw = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.jBi = (TextView) findViewById(R.id.sure_cancel);
            this.jBj = (TextView) findViewById(R.id.cancel_button);
            this.jBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.jBj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dWw.setVisibility(8);
                    a.this.jBd.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.jAY.display_name)) {
                this.jBk.setText(PluginDownloadActivity.this.jAY.display_name);
            } else {
                this.jBk.setText("");
            }
            if (PluginDownloadActivity.this.jAY.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jAY.newest.version)) {
                    this.jBe.setText("版本：" + PluginDownloadActivity.this.jAY.newest.version);
                } else {
                    this.jBe.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jAY.newest.change_log)) {
                    this.alt.setText(PluginDownloadActivity.this.jAY.newest.change_log);
                } else {
                    this.alt.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.jAY.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.jBh.setVisibility(0);
                    this.jBh.setText(((Object) this.jBh.getText()) + valueOf + "KB");
                } else {
                    this.jBh.setVisibility(8);
                }
            } else {
                this.jBe.setText("");
                this.alt.setText("");
                this.jBh.setText("");
            }
            this.jBf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.aKr = true;
                        a.this.jBf.setVisibility(8);
                        a.this.ebh.setVisibility(8);
                        a.this.jBg.setVisibility(0);
                        PluginPackageManager.js().a(PluginDownloadActivity.this.jAY, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jAY.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.jBb.jBg.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.jBb.jBg.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jAY.package_name)) {
                                    PluginDownloadActivity.this.jBb.jBg.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.jBb.jBg.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jAY.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.jBb, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.ebh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aFH().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aFH().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jAY != null) {
            PluginPackageManager.js().bi(this.jAY.package_name);
        }
        super.onDestroy();
    }
}
