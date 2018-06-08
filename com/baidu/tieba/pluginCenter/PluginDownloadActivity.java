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
    private PluginNetConfigInfos.PluginConfig gdN;
    private a gdP;
    private boolean gdQ;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gdN = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.gdN == null) {
            showToast(getPageContext().getString(d.k.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.gdP = new a(getPageContext().getPageActivity(), d.l.common_alert_dialog);
        this.gdP.setCancelable(false);
        this.gdP.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.gdQ) {
                    g.b(PluginDownloadActivity.this.gdP, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.gdP.biv.getVisibility() == 0) {
                        PluginDownloadActivity.this.gdP.biv.setVisibility(8);
                        PluginDownloadActivity.this.gdP.gdS.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.gdP.biv.setVisibility(0);
                    PluginDownloadActivity.this.gdP.gdS.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.gdP.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.gdP, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gdP.findViewById(d.g.dialog_layout));
    }

    /* loaded from: classes2.dex */
    private class a extends Dialog {
        private LinearLayout biv;
        private TextView bmr;
        private TextView eUm;
        private TextView evA;
        private LinearLayout gdS;
        private TextView gdT;
        private TextView gdU;
        private TextView gdV;
        private TextView gdW;
        private TextView gdX;
        private TextView gdY;
        private TextView gdZ;

        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(d.i.update_dialog);
            findViewById(d.g.warning).setVisibility(8);
            findViewById(d.g.incremental_button).setVisibility(8);
            findViewById(d.g.incremental_size).setVisibility(8);
            this.gdS = (LinearLayout) findViewById(d.g.down_dialog);
            this.gdY = (TextView) findViewById(d.g.update_tip);
            this.gdT = (TextView) findViewById(d.g.newversion);
            this.evA = (TextView) findViewById(d.g.desc);
            this.gdU = (TextView) findViewById(d.g.update_button);
            this.gdU.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.install_app));
            this.bmr = (TextView) findViewById(d.g.update_cancel);
            this.eUm = (TextView) findViewById(d.g.downloading);
            this.gdZ = (TextView) findViewById(d.g.otherApp);
            this.gdZ.setVisibility(8);
            this.gdV = (TextView) findViewById(d.g.app_size);
            this.biv = (LinearLayout) findViewById(d.g.cancel_dialog);
            this.gdW = (TextView) findViewById(d.g.sure_cancel);
            this.gdX = (TextView) findViewById(d.g.cancel_button);
            this.gdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.gdX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.biv.setVisibility(8);
                    a.this.gdS.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.gdN.display_name)) {
                this.gdY.setText(PluginDownloadActivity.this.gdN.display_name);
            } else {
                this.gdY.setText("");
            }
            if (PluginDownloadActivity.this.gdN.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gdN.newest.version)) {
                    this.gdT.setText("版本：" + PluginDownloadActivity.this.gdN.newest.version);
                } else {
                    this.gdT.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.gdN.newest.change_log)) {
                    this.evA.setText(PluginDownloadActivity.this.gdN.newest.change_log);
                } else {
                    this.evA.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.gdN.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.gdV.setVisibility(0);
                    this.gdV.setText(((Object) this.gdV.getText()) + valueOf + "KB");
                } else {
                    this.gdV.setVisibility(8);
                }
            } else {
                this.gdT.setText("");
                this.evA.setText("");
                this.gdV.setText("");
            }
            this.gdU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.jD()) {
                        PluginDownloadActivity.this.gdQ = true;
                        a.this.gdU.setVisibility(8);
                        a.this.bmr.setVisibility(8);
                        a.this.eUm.setVisibility(0);
                        PluginPackageManager.lL().a(PluginDownloadActivity.this.gdN, new com.baidu.adp.plugin.packageManager.d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gdN.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.gdP.eUm.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.gdP.eUm.setEnabled(false);
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
                                if (i == 0) {
                                    PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_finished));
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.setResult(-1);
                                    PluginDownloadActivity.this.finish();
                                    return;
                                }
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.showToast(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_installation_failed), false);
                                PluginDownloadActivity.this.setResult(0);
                                PluginDownloadActivity.this.finish();
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void b(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gdN.package_name)) {
                                    PluginDownloadActivity.this.gdP.eUm.setText(PluginDownloadActivity.this.getPageContext().getString(d.k.plugin_download_finished));
                                    PluginDownloadActivity.this.gdP.eUm.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.gdN.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.gdP, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(d.k.neterror);
                }
            });
            this.bmr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
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
        if (this.gdN != null) {
            PluginPackageManager.lL().bH(this.gdN.package_name);
        }
        super.onDestroy();
    }
}
