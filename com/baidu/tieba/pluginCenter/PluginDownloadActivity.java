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
    private PluginNetConfigInfos.PluginConfig itm;
    private a itp;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.itm = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.itm == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.itp = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.itp.setCancelable(false);
        this.itp.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.adP) {
                    g.b(PluginDownloadActivity.this.itp, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.itp.cSV.getVisibility() == 0) {
                        PluginDownloadActivity.this.itp.cSV.setVisibility(8);
                        PluginDownloadActivity.this.itp.itr.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.itp.cSV.setVisibility(0);
                    PluginDownloadActivity.this.itp.itr.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.itp.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.itp, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.itp.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cSV;
        private TextView cWJ;
        private TextView fIL;
        private LinearLayout itr;
        private TextView its;
        private TextView itt;
        private TextView itu;
        private TextView itv;
        private TextView itw;
        private TextView itx;
        private TextView ity;
        private TextView itz;

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
            this.itr = (LinearLayout) findViewById(R.id.down_dialog);
            this.ity = (TextView) findViewById(R.id.update_tip);
            this.its = (TextView) findViewById(R.id.newversion);
            this.fIL = (TextView) findViewById(R.id.desc);
            this.itt = (TextView) findViewById(R.id.update_button);
            this.itt.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cWJ = (TextView) findViewById(R.id.update_cancel);
            this.itu = (TextView) findViewById(R.id.downloading);
            this.itz = (TextView) findViewById(R.id.otherApp);
            this.itz.setVisibility(8);
            this.itv = (TextView) findViewById(R.id.app_size);
            this.cSV = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.itw = (TextView) findViewById(R.id.sure_cancel);
            this.itx = (TextView) findViewById(R.id.cancel_button);
            this.itw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.itx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cSV.setVisibility(8);
                    a.this.itr.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.itm.display_name)) {
                this.ity.setText(PluginDownloadActivity.this.itm.display_name);
            } else {
                this.ity.setText("");
            }
            if (PluginDownloadActivity.this.itm.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itm.newest.version)) {
                    this.its.setText("版本：" + PluginDownloadActivity.this.itm.newest.version);
                } else {
                    this.its.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.itm.newest.change_log)) {
                    this.fIL.setText(PluginDownloadActivity.this.itm.newest.change_log);
                } else {
                    this.fIL.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.itm.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.itv.setVisibility(0);
                    this.itv.setText(((Object) this.itv.getText()) + valueOf + "KB");
                } else {
                    this.itv.setVisibility(8);
                }
            } else {
                this.its.setText("");
                this.fIL.setText("");
                this.itv.setText("");
            }
            this.itt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jS()) {
                        PluginDownloadActivity.this.adP = true;
                        a.this.itt.setVisibility(8);
                        a.this.cWJ.setVisibility(8);
                        a.this.itu.setVisibility(0);
                        PluginPackageManager.mc().a(PluginDownloadActivity.this.itm, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itm.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.itp.itu.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.itp.itu.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itm.package_name)) {
                                    PluginDownloadActivity.this.itp.itu.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.itp.itu.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.itm.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.itp, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cWJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.itm != null) {
            PluginPackageManager.mc().bL(this.itm.package_name);
        }
        super.onDestroy();
    }
}
