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
    private boolean aem;
    private PluginNetConfigInfos.PluginConfig izE;
    private a izH;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.izE = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.izE == null) {
            showToast(getPageContext().getString(R.string.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.izH = new a(getPageContext().getPageActivity(), R.style.common_alert_dialog);
        this.izH.setCancelable(false);
        this.izH.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (!PluginDownloadActivity.this.aem) {
                    g.b(PluginDownloadActivity.this.izH, PluginDownloadActivity.this.getPageContext());
                    return true;
                } else if (i == 4 && keyEvent.getAction() == 1) {
                    if (PluginDownloadActivity.this.izH.cUs.getVisibility() == 0) {
                        PluginDownloadActivity.this.izH.cUs.setVisibility(8);
                        PluginDownloadActivity.this.izH.izJ.setVisibility(0);
                        return true;
                    }
                    PluginDownloadActivity.this.izH.cUs.setVisibility(0);
                    PluginDownloadActivity.this.izH.izJ.setVisibility(8);
                    return true;
                } else {
                    return false;
                }
            }
        });
        this.izH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.2
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
        g.a(this.izH, getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.izH.findViewById(R.id.dialog_layout));
    }

    /* loaded from: classes3.dex */
    private class a extends Dialog {
        private LinearLayout cUs;
        private TextView cYg;
        private TextView fNL;
        private LinearLayout izJ;
        private TextView izK;
        private TextView izL;
        private TextView izM;
        private TextView izN;
        private TextView izO;
        private TextView izP;
        private TextView izQ;
        private TextView izR;

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
            this.izJ = (LinearLayout) findViewById(R.id.down_dialog);
            this.izQ = (TextView) findViewById(R.id.update_tip);
            this.izK = (TextView) findViewById(R.id.newversion);
            this.fNL = (TextView) findViewById(R.id.desc);
            this.izL = (TextView) findViewById(R.id.update_button);
            this.izL.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.install_app));
            this.cYg = (TextView) findViewById(R.id.update_cancel);
            this.izM = (TextView) findViewById(R.id.downloading);
            this.izR = (TextView) findViewById(R.id.otherApp);
            this.izR.setVisibility(8);
            this.izN = (TextView) findViewById(R.id.app_size);
            this.cUs = (LinearLayout) findViewById(R.id.cancel_dialog);
            this.izO = (TextView) findViewById(R.id.sure_cancel);
            this.izP = (TextView) findViewById(R.id.cancel_button);
            this.izO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                }
            });
            this.izP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cUs.setVisibility(8);
                    a.this.izJ.setVisibility(0);
                }
            });
            if (!TextUtils.isEmpty(PluginDownloadActivity.this.izE.display_name)) {
                this.izQ.setText(PluginDownloadActivity.this.izE.display_name);
            } else {
                this.izQ.setText("");
            }
            if (PluginDownloadActivity.this.izE.newest != null) {
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.izE.newest.version)) {
                    this.izK.setText("版本：" + PluginDownloadActivity.this.izE.newest.version);
                } else {
                    this.izK.setText("");
                }
                if (!TextUtils.isEmpty(PluginDownloadActivity.this.izE.newest.change_log)) {
                    this.fNL.setText(PluginDownloadActivity.this.izE.newest.change_log);
                } else {
                    this.fNL.setText("");
                }
                String valueOf = String.valueOf(PluginDownloadActivity.this.izE.newest.size / 1024);
                if (valueOf != null && !"".equals(valueOf)) {
                    this.izN.setVisibility(0);
                    this.izN.setText(((Object) this.izN.getText()) + valueOf + "KB");
                } else {
                    this.izN.setVisibility(8);
                }
            } else {
                this.izK.setText("");
                this.fNL.setText("");
                this.izN.setText("");
            }
            this.izL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (j.kc()) {
                        PluginDownloadActivity.this.aem = true;
                        a.this.izL.setVisibility(8);
                        a.this.cYg.setVisibility(8);
                        a.this.izM.setVisibility(0);
                        PluginPackageManager.ms().a(PluginDownloadActivity.this.izE, new d() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.3.1
                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void a(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.izE.package_name) && !PluginDownloadActivity.this.mFinished) {
                                    PluginDownloadActivity.this.izH.izM.setText(String.format("正在下载插件：%d%%", Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                                    PluginDownloadActivity.this.izH.izM.setEnabled(false);
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
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.izE.package_name)) {
                                    PluginDownloadActivity.this.izH.izM.setText(PluginDownloadActivity.this.getPageContext().getString(R.string.plugin_download_finished));
                                    PluginDownloadActivity.this.izH.izM.setEnabled(false);
                                    PluginDownloadActivity.this.mFinished = true;
                                }
                            }

                            @Override // com.baidu.adp.plugin.packageManager.d
                            public void c(BdFileDownloadData bdFileDownloadData) {
                                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDownloadActivity.this.izE.package_name)) {
                                    PluginDownloadActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                                    PluginDownloadActivity.this.mFinished = true;
                                    g.b(PluginDownloadActivity.this.izH, PluginDownloadActivity.this.getPageContext());
                                }
                            }
                        });
                        return;
                    }
                    PluginDownloadActivity.this.showToast(R.string.neterror);
                }
            });
            this.cYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDownloadActivity.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PluginDownloadActivity.this.setResult(0);
                    PluginDownloadActivity.this.finish();
                    b.ahO().putBoolean(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_CLOSED, true);
                    b.ahO().putLong(BaseWebViewActivity.KEY_INSTALL_PLUGIN_DIALOG_SHOWN_TIME, new Date().getTime());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.izE != null) {
            PluginPackageManager.ms().bN(this.izE.package_name);
        }
        super.onDestroy();
    }
}
