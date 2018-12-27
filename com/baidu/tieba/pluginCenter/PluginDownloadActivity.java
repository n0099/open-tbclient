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
import com.baidu.tieba.e;
import java.util.Date;
/* loaded from: classes4.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig gIq;
    private a gIs;
    private boolean gIt;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gIq = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gIq == null) {
            showToast(getPageContext().getString(e.j.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gIs = new a(getPageContext().getPageActivity(), e.k.common_alert_dialog);
        this.gIs.setCancelable(false);
        this.gIs.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gIt) {
                    g.b(PluginDownloadActivity.this.gIs, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gIs.byO.getVisibility() == 0) {
                        PluginDownloadActivity.this.gIs.byO.setVisibility(8);
                        PluginDownloadActivity.this.gIs.gIv.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gIs.byO.setVisibility(0);
                    PluginDownloadActivity.this.gIs.gIv.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gIs.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gIs, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gIs.findViewById(e.g.dialog_layout));
    }

    /* loaded from: classes4.dex */
    private class a extends Dialog {
        private TextView bCC;
        private LinearLayout byO;
        private TextView edH;
        private TextView gIA;
        private TextView gIB;
        private TextView gIC;
        private TextView gID;
        private LinearLayout gIv;
        private TextView gIw;
        private TextView gIx;
        private TextView gIy;
        private TextView gIz;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(e.h.update_dialog);
            findViewById(e.g.warning).setVisibility(8);
            findViewById(e.g.incremental_button).setVisibility(8);
            findViewById(e.g.incremental_size).setVisibility(8);
            this.gIv = (LinearLayout) findViewById(e.g.down_dialog);
            this.gIC = (TextView) findViewById(e.g.update_tip);
            this.gIw = (TextView) findViewById(e.g.newversion);
            this.edH = (TextView) findViewById(e.g.desc);
            this.gIx = (TextView) findViewById(e.g.update_button);
            this.gIx.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.install_app));
            this.bCC = (TextView) findViewById(e.g.update_cancel);
            this.gIy = (TextView) findViewById(e.g.downloading);
            this.gID = (TextView) findViewById(e.g.otherApp);
            this.gID.setVisibility(8);
            this.gIz = (TextView) findViewById(e.g.app_size);
            this.byO = (LinearLayout) findViewById(e.g.cancel_dialog);
            this.gIA = (TextView) findViewById(e.g.sure_cancel);
            this.gIB = (TextView) findViewById(e.g.cancel_button);
            this.gIA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gIB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.byO.setVisibility(8);
                    a.this.gIv.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gIq.display_name)) {
                this.gIC.setText(PluginDownloadActivity.this.gIq.display_name);
            } else {
                this.gIC.setText("");
            }
            if (PluginDownloadActivity.this.gIq.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gIq.newest.version)) {
                    this.gIw.setText("版本：" + PluginDownloadActivity.this.gIq.newest.version);
                } else {
                    this.gIw.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gIq.newest.change_log)) {
                    this.edH.setText(PluginDownloadActivity.this.gIq.newest.change_log);
                } else {
                    this.edH.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gIq.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gIz.setVisibility(0);
                    this.gIz.setText(((Object) this.gIz.getText()) + valueOf + "KB");
                } else {
                    this.gIz.setVisibility(8);
                }
            } else {
                this.gIw.setText("");
                this.edH.setText("");
                this.gIz.setText("");
            }
            this.gIx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kV()) {
                        PluginDownloadActivity.this.gIt = true;
                        a.this.gIx.setVisibility(8);
                        a.this.bCC.setVisibility(8);
                        a.this.gIy.setVisibility(0);
                        PluginPackageManager.na().a(PluginDownloadActivity.this.gIq, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gIq.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gIs.gIy.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gIs.gIy.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gIq.package_name)) {
                                    PluginDownloadActivity.this.gIs.gIy.setText(PluginDownloadActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                                    PluginDownloadActivity.this.gIs.gIy.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gIq.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gIs, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(e.j.neterror);
                }
            });
            this.bCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.getInstance().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.getInstance().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.gIq != null) {
            PluginPackageManager.na().ca(this.gIq.package_name);
        }
        super.onDestroy();
    }
}
