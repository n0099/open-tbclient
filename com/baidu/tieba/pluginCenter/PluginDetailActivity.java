package com.baidu.tieba.pluginCenter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView btB;
    private TextView fAN;
    private TextView fAO;
    private TextView fAP;
    private PluginNetConfigInfos.PluginConfig fAQ;
    private HeadImageView fxF;
    private boolean lh;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d FQ = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fAQ.package_name) && !PluginDetailActivity.this.lh) {
                ai.c(PluginDetailActivity.this.fAP, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fAP.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fAP.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fAQ.package_name)) {
                PluginDetailActivity.this.fAP.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fAP.setEnabled(false);
                PluginDetailActivity.this.lh = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fAQ.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bgc();
                PluginDetailActivity.this.lh = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.bgc();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.bgc();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hr()) {
                PluginDetailActivity.this.bgc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.j.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.h.navigation_bar);
        this.mNavigationBar.setTitleText(d.l.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.fxF = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.btB = (TextView) findViewById(d.h.status);
        this.fAN = (TextView) findViewById(d.h.changelog);
        this.fAO = (TextView) findViewById(d.h.size);
        this.fAP = (TextView) findViewById(d.h.enable);
        this.fAP.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc() != null) {
            this.fAQ = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.kb().kc().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jE().bu(this.mPluginName)) {
            PluginPackageManager.jE().a(this.FQ);
            ai.c(this.fAP, d.e.cp_cont_d, 1);
            this.fAP.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fAQ != null) {
            this.fxF.c(this.fAQ.icon, 10, false);
            if (this.fAQ.display_name == null) {
                this.fAQ.display_name = "";
            }
            this.mName.setText(this.fAQ.display_name);
            bgc();
            if (this.fAQ.newest != null) {
                if (TextUtils.isEmpty(this.fAQ.newest.change_log)) {
                    this.fAN.setText("");
                } else {
                    this.fAN.setText(this.fAQ.newest.change_log);
                }
                if (this.fAQ.newest.size <= 0) {
                    this.fAO.setText("");
                } else {
                    this.fAO.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fAQ.newest.size / 1024) + "KB");
                }
            }
            this.fAP.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jE().bs(this.mPluginName) && PluginPackageManager.jE().bq(this.mPluginName)) {
            this.btB.setText(d.l.plugin_enabled);
            this.fAP.setText(d.l.download_update);
            this.fAP.setEnabled(true);
            ai.c(this.fAP, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jE().bq(this.mPluginName)) {
            this.fAP.setEnabled(true);
            ai.c(this.fAP, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jE().br(this.mPluginName)) {
                this.btB.setText(d.l.plugin_unenabled);
                this.fAP.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.btB.setText(d.l.plugin_enabled);
                this.fAP.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.btB.setText(d.l.plugin_disabled);
            this.fAP.setText(d.l.plugin_enable);
            this.fAP.setEnabled(true);
            ai.c(this.fAP, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jE().bu(this.mPluginName)) {
            ai.c(this.fAP, d.e.cp_cont_d, 1);
            this.fAP.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ah(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fAP) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bgd();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jE().bo(this.mPluginName);
                bgc();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jE().bp(this.mPluginName);
                bgc();
            }
        }
    }

    private void bgd() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (i.ht()) {
            bge();
        } else {
            ai.c(this.fAP, d.e.cp_cont_d, 1);
            this.fAP.setEnabled(false);
            PluginPackageManager.jE().a(this.fAQ, this.FQ);
        }
    }

    private void bge() {
        String string;
        String string2;
        if (this.fAQ != null && this.fAQ.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fAQ.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cT(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ai.c(PluginDetailActivity.this.fAP, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fAP.setEnabled(false);
                    PluginPackageManager.jE().a(PluginDetailActivity.this.fAQ, PluginDetailActivity.this.FQ);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PluginPackageManager.jE().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
