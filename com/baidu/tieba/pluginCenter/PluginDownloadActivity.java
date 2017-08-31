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
import com.baidu.adp.lib.util.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.d;
import java.util.Date;
/* loaded from: classes2.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private boolean dhf;
    private PluginNetConfigInfos.PluginConfig fBo;
    private a fBq;
    private boolean fBr;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fBo = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.fBo == null) {
            showToast(getPageContext().getString(d.l.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.fBq = new a(getPageContext().getPageActivity(), d.m.common_alert_dialog);
        this.fBq.setCancelable(false);
        this.fBq.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.fBr) {
                    g.b(PluginDownloadActivity.this.fBq, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.fBq.aVi.getVisibility() == 0) {
                        PluginDownloadActivity.this.fBq.aVi.setVisibility(8);
                        PluginDownloadActivity.this.fBq.fBt.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.fBq.aVi.setVisibility(0);
                    PluginDownloadActivity.this.fBq.fBt.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.fBq.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.fBq, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(this.fBq.findViewById(d.h.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout aVi;
        private TextView aZj;
        private TextView dIv;
        private TextView eki;
        private TextView fBA;
        private LinearLayout fBt;
        private TextView fBu;
        private TextView fBv;
        private TextView fBw;
        private TextView fBx;
        private TextView fBy;
        private TextView fBz;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.j.update_dialog);
            findViewById(d.h.warning).setVisibility(8);
            findViewById(d.h.incremental_button).setVisibility(8);
            findViewById(d.h.incremental_size).setVisibility(8);
            this.fBt = (LinearLayout) findViewById(d.h.down_dialog);
            this.fBz = (TextView) findViewById(d.h.update_tip);
            this.fBu = (TextView) findViewById(d.h.newversion);
            this.dIv = (TextView) findViewById(d.h.desc);
            this.fBv = (TextView) findViewById(d.h.update_button);
            this.fBv.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.install_app));
            this.aZj = (TextView) findViewById(d.h.update_cancel);
            this.eki = (TextView) findViewById(d.h.downloading);
            this.fBA = (TextView) findViewById(d.h.otherApp);
            this.fBA.setVisibility(8);
            this.fBw = (TextView) findViewById(d.h.app_size);
            this.aVi = (LinearLayout) findViewById(d.h.cancel_dialog);
            this.fBx = (TextView) findViewById(d.h.sure_cancel);
            this.fBy = (TextView) findViewById(d.h.cancel_button);
            this.fBx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.fBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.aVi.setVisibility(8);
                    a.this.fBt.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.fBo.display_name)) {
                this.fBz.setText(PluginDownloadActivity.this.fBo.display_name);
            } else {
                this.fBz.setText("");
            }
            if (PluginDownloadActivity.this.fBo.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fBo.newest.version)) {
                    this.fBu.setText("版本：" + PluginDownloadActivity.this.fBo.newest.version);
                } else {
                    this.fBu.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.fBo.newest.change_log)) {
                    this.dIv.setText(PluginDownloadActivity.this.fBo.newest.change_log);
                } else {
                    this.dIv.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.fBo.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.fBw.setVisibility(0);
                    this.fBw.setText(((Object) this.fBw.getText()) + valueOf + "KB");
                } else {
                    this.fBw.setVisibility(8);
                }
            } else {
                this.fBu.setText("");
                this.dIv.setText("");
                this.fBw.setText("");
            }
            this.fBv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.hi()) {
                        PluginDownloadActivity.this.fBr = true;
                        a.this.fBv.setVisibility(8);
                        a.this.aZj.setVisibility(8);
                        a.this.eki.setVisibility(0);
                        PluginPackageManager.jw().a(PluginDownloadActivity.this.fBo, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fBo.package_name) && !PluginDownloadActivity.this.dhf) {
                                    PluginDownloadActivity.this.fBq.eki.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.fBq.eki.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fBo.package_name)) {
                                    PluginDownloadActivity.this.fBq.eki.setText(PluginDownloadActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                                    PluginDownloadActivity.this.fBq.eki.setEnabled(false);
                                    PluginDownloadActivity.this.dhf = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.fBo.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.dhf = true;
                                    g.b(PluginDownloadActivity.this.fBq, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.l.neterror);
                }
            });
            this.aZj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.fBo != null) {
            PluginPackageManager.jw().bq(this.fBo.package_name);
        }
        super.onDestroy();
    }
}
