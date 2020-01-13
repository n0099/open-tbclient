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
/* loaded from: classes6.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean aFV;
    private PluginNetConfigInfos.PluginConfig jyq;
    private a jyt;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jyq = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.jyq == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.jyt = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.jyt.setCancelable(false);
        this.jyt.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aFV) {
                    g.b(PluginDownloadActivity.this.jyt, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.jyt.dRN.getVisibility() == 0) {
                        PluginDownloadActivity.this.jyt.dRN.setVisibility(8);
                        PluginDownloadActivity.this.jyt.jyv.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.jyt.dRN.setVisibility(0);
                    PluginDownloadActivity.this.jyt.jyv.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.jyt.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.jyt, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.jyt.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes6.dex */
    private class a extends Dialog {
        private TextView aja;
        private LinearLayout dRN;
        private TextView dWz;
        private TextView jyA;
        private TextView jyB;
        private TextView jyC;
        private TextView jyD;
        private LinearLayout jyv;
        private TextView jyw;
        private TextView jyx;
        private TextView jyy;
        private TextView jyz;

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
            this.jyv = (LinearLayout) findViewById(R.id.down_dialog);
            this.jyC = (TextView) findViewById(R.id.update_tip);
            this.jyw = (TextView) findViewById(R.id.newversion);
            this.aja = (TextView) findViewById(R.id.desc);
            this.jyx = (TextView) findViewById(R.id.update_button);
            this.jyx.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.dWz = (TextView) findViewById(R.id.update_cancel);
            this.jyy = (TextView) findViewById(R.id.downloading);
            this.jyD = (TextView) findViewById(R.id.otherApp);
            this.jyD.setVisibility(8);
            this.jyz = (TextView) findViewById(R.id.app_size);
            this.dRN = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.jyA = (TextView) findViewById(R.id.sure_cancel);
            this.jyB = (TextView) findViewById(R.id.cancel_button);
            this.jyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.jyB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.dRN.setVisibility(8);
                    a.this.jyv.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.jyq.display_name)) {
                this.jyC.setText(PluginDownloadActivity.this.jyq.display_name);
            } else {
                this.jyC.setText("");
            }
            if (PluginDownloadActivity.this.jyq.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jyq.newest.version)) {
                    this.jyw.setText("版本：" + PluginDownloadActivity.this.jyq.newest.version);
                } else {
                    this.jyw.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.jyq.newest.change_log)) {
                    this.aja.setText(PluginDownloadActivity.this.jyq.newest.change_log);
                } else {
                    this.aja.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.jyq.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.jyz.setVisibility(0);
                    this.jyz.setText(((Object) this.jyz.getText()) + valueOf + "KB");
                } else {
                    this.jyz.setVisibility(8);
                }
            } else {
                this.jyw.setText("");
                this.aja.setText("");
                this.jyz.setText("");
            }
            this.jyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.isNetWorkAvailable()) {
                        PluginDownloadActivity.this.aFV = true;
                        a.this.jyx.setVisibility(8);
                        a.this.dWz.setVisibility(8);
                        a.this.jyy.setVisibility(0);
                        PluginPackageManager.jd().a(PluginDownloadActivity.this.jyq, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jyq.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.jyt.jyy.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.jyt.jyy.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jyq.package_name)) {
                                    PluginDownloadActivity.this.jyt.jyy.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.jyt.jyy.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.jyq.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.jyt, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.dWz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.aDr().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.aDr().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jyq != null) {
            PluginPackageManager.jd().bg(this.jyq.package_name);
        }
        super.onDestroy();
    }
}
