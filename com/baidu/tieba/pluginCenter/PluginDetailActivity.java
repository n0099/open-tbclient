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
    private TextView bsq;
    private boolean cXg;
    private HeadImageView fws;
    private TextView fzB;
    private TextView fzC;
    private TextView fzD;
    private PluginNetConfigInfos.PluginConfig fzE;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d Er = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fzE.package_name) && !PluginDetailActivity.this.cXg) {
                ai.c(PluginDetailActivity.this.fzD, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fzD.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fzD.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fzE.package_name)) {
                PluginDetailActivity.this.fzD.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fzD.setEnabled(false);
                PluginDetailActivity.this.cXg = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fzE.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bfS();
                PluginDetailActivity.this.cXg = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.bfS();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.bfS();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hh()) {
                PluginDetailActivity.this.bfS();
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
        this.fws = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.bsq = (TextView) findViewById(d.h.status);
        this.fzB = (TextView) findViewById(d.h.changelog);
        this.fzC = (TextView) findViewById(d.h.size);
        this.fzD = (TextView) findViewById(d.h.enable);
        this.fzD.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null) {
            this.fzE = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.ju().bo(this.mPluginName)) {
            PluginPackageManager.ju().a(this.Er);
            ai.c(this.fzD, d.e.cp_cont_d, 1);
            this.fzD.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fzE != null) {
            this.fws.c(this.fzE.icon, 10, false);
            if (this.fzE.display_name == null) {
                this.fzE.display_name = "";
            }
            this.mName.setText(this.fzE.display_name);
            bfS();
            if (this.fzE.newest != null) {
                if (TextUtils.isEmpty(this.fzE.newest.change_log)) {
                    this.fzB.setText("");
                } else {
                    this.fzB.setText(this.fzE.newest.change_log);
                }
                if (this.fzE.newest.size <= 0) {
                    this.fzC.setText("");
                } else {
                    this.fzC.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fzE.newest.size / 1024) + "KB");
                }
            }
            this.fzD.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.ju().bm(this.mPluginName) && PluginPackageManager.ju().bk(this.mPluginName)) {
            this.bsq.setText(d.l.plugin_enabled);
            this.fzD.setText(d.l.download_update);
            this.fzD.setEnabled(true);
            ai.c(this.fzD, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.ju().bk(this.mPluginName)) {
            this.fzD.setEnabled(true);
            ai.c(this.fzD, d.e.cp_cont_g, 1);
            if (PluginPackageManager.ju().bl(this.mPluginName)) {
                this.bsq.setText(d.l.plugin_unenabled);
                this.fzD.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bsq.setText(d.l.plugin_enabled);
                this.fzD.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bsq.setText(d.l.plugin_disabled);
            this.fzD.setText(d.l.plugin_enable);
            this.fzD.setEnabled(true);
            ai.c(this.fzD, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.ju().bo(this.mPluginName)) {
            ai.c(this.fzD, d.e.cp_cont_d, 1);
            this.fzD.setEnabled(false);
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
        if (view == this.fzD) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bfT();
            } else if (this.mStatus == 3) {
                PluginPackageManager.ju().bi(this.mPluginName);
                bfS();
            } else if (this.mStatus == 2) {
                PluginPackageManager.ju().bj(this.mPluginName);
                bfS();
            }
        }
    }

    private void bfT() {
        if (!i.hh()) {
            showToast(d.l.neterror);
        } else if (i.hj()) {
            bfU();
        } else {
            ai.c(this.fzD, d.e.cp_cont_d, 1);
            this.fzD.setEnabled(false);
            PluginPackageManager.ju().a(this.fzE, this.Er);
        }
    }

    private void bfU() {
        String string;
        String string2;
        if (this.fzE != null && this.fzE.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fzE.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cN(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ai.c(PluginDetailActivity.this.fzD, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fzD.setEnabled(false);
                    PluginPackageManager.ju().a(PluginDetailActivity.this.fzE, PluginDetailActivity.this.Er);
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
            aVar.th();
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
        PluginPackageManager.ju().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
