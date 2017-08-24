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
    private TextView btR;
    private TextView fCI;
    private TextView fCJ;
    private TextView fCK;
    private PluginNetConfigInfos.PluginConfig fCL;
    private HeadImageView fzA;
    private boolean lh;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d FS = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCL.package_name) && !PluginDetailActivity.this.lh) {
                ai.c(PluginDetailActivity.this.fCK, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fCK.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fCK.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCL.package_name)) {
                PluginDetailActivity.this.fCK.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fCK.setEnabled(false);
                PluginDetailActivity.this.lh = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCL.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bgD();
                PluginDetailActivity.this.lh = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.bgD();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.bgD();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hr()) {
                PluginDetailActivity.this.bgD();
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
        this.fzA = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.btR = (TextView) findViewById(d.h.status);
        this.fCI = (TextView) findViewById(d.h.changelog);
        this.fCJ = (TextView) findViewById(d.h.size);
        this.fCK = (TextView) findViewById(d.h.enable);
        this.fCK.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ka().kb() != null) {
            this.fCL = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ka().kb().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jE().bv(this.mPluginName)) {
            PluginPackageManager.jE().a(this.FS);
            ai.c(this.fCK, d.e.cp_cont_d, 1);
            this.fCK.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fCL != null) {
            this.fzA.c(this.fCL.icon, 10, false);
            if (this.fCL.display_name == null) {
                this.fCL.display_name = "";
            }
            this.mName.setText(this.fCL.display_name);
            bgD();
            if (this.fCL.newest != null) {
                if (TextUtils.isEmpty(this.fCL.newest.change_log)) {
                    this.fCI.setText("");
                } else {
                    this.fCI.setText(this.fCL.newest.change_log);
                }
                if (this.fCL.newest.size <= 0) {
                    this.fCJ.setText("");
                } else {
                    this.fCJ.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fCL.newest.size / 1024) + "KB");
                }
            }
            this.fCK.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jE().bt(this.mPluginName) && PluginPackageManager.jE().br(this.mPluginName)) {
            this.btR.setText(d.l.plugin_enabled);
            this.fCK.setText(d.l.download_update);
            this.fCK.setEnabled(true);
            ai.c(this.fCK, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jE().br(this.mPluginName)) {
            this.fCK.setEnabled(true);
            ai.c(this.fCK, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jE().bs(this.mPluginName)) {
                this.btR.setText(d.l.plugin_unenabled);
                this.fCK.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.btR.setText(d.l.plugin_enabled);
                this.fCK.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.btR.setText(d.l.plugin_disabled);
            this.fCK.setText(d.l.plugin_enable);
            this.fCK.setEnabled(true);
            ai.c(this.fCK, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jE().bv(this.mPluginName)) {
            ai.c(this.fCK, d.e.cp_cont_d, 1);
            this.fCK.setEnabled(false);
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
        if (view == this.fCK) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bgE();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jE().bp(this.mPluginName);
                bgD();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jE().bq(this.mPluginName);
                bgD();
            }
        }
    }

    private void bgE() {
        if (!i.hr()) {
            showToast(d.l.neterror);
        } else if (i.ht()) {
            bgF();
        } else {
            ai.c(this.fCK, d.e.cp_cont_d, 1);
            this.fCK.setEnabled(false);
            PluginPackageManager.jE().a(this.fCL, this.FS);
        }
    }

    private void bgF() {
        String string;
        String string2;
        if (this.fCL != null && this.fCL.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fCL.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cW(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    ai.c(PluginDetailActivity.this.fCK, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fCK.setEnabled(false);
                    PluginPackageManager.jE().a(PluginDetailActivity.this.fCL, PluginDetailActivity.this.FS);
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
            aVar.ts();
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
