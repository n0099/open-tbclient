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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.d;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bwP;
    private boolean dea;
    private HeadImageView fuL;
    private TextView fyk;
    private TextView fyl;
    private TextView fym;
    private PluginNetConfigInfos.PluginConfig fyn;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d DP = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyn.package_name) && !PluginDetailActivity.this.dea) {
                aj.c(PluginDetailActivity.this.fym, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fym.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fym.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyn.package_name)) {
                PluginDetailActivity.this.fym.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fym.setEnabled(false);
                PluginDetailActivity.this.dea = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyn.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.beE();
                PluginDetailActivity.this.dea = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.beE();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.beE();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh()) {
                PluginDetailActivity.this.beE();
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
        this.fuL = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.bwP = (TextView) findViewById(d.h.status);
        this.fyk = (TextView) findViewById(d.h.changelog);
        this.fyl = (TextView) findViewById(d.h.size);
        this.fym = (TextView) findViewById(d.h.enable);
        this.fym.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null) {
            this.fyn = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jv().br(this.mPluginName)) {
            PluginPackageManager.jv().a(this.DP);
            aj.c(this.fym, d.e.cp_cont_d, 1);
            this.fym.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fyn != null) {
            this.fuL.c(this.fyn.icon, 10, false);
            if (this.fyn.display_name == null) {
                this.fyn.display_name = "";
            }
            this.mName.setText(this.fyn.display_name);
            beE();
            if (this.fyn.newest != null) {
                if (TextUtils.isEmpty(this.fyn.newest.change_log)) {
                    this.fyk.setText("");
                } else {
                    this.fyk.setText(this.fyn.newest.change_log);
                }
                if (this.fyn.newest.size <= 0) {
                    this.fyl.setText("");
                } else {
                    this.fyl.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fyn.newest.size / 1024) + "KB");
                }
            }
            this.fym.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beE() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jv().bp(this.mPluginName) && PluginPackageManager.jv().bn(this.mPluginName)) {
            this.bwP.setText(d.l.plugin_enabled);
            this.fym.setText(d.l.download_update);
            this.fym.setEnabled(true);
            aj.c(this.fym, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jv().bn(this.mPluginName)) {
            this.fym.setEnabled(true);
            aj.c(this.fym, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jv().bo(this.mPluginName)) {
                this.bwP.setText(d.l.plugin_unenabled);
                this.fym.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bwP.setText(d.l.plugin_enabled);
                this.fym.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bwP.setText(d.l.plugin_disabled);
            this.fym.setText(d.l.plugin_enable);
            this.fym.setEnabled(true);
            aj.c(this.fym, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jv().br(this.mPluginName)) {
            aj.c(this.fym, d.e.cp_cont_d, 1);
            this.fym.setEnabled(false);
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
        if (view == this.fym) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                beF();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jv().bl(this.mPluginName);
                beE();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jv().bm(this.mPluginName);
                beE();
            }
        }
    }

    private void beF() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (j.hj()) {
            beG();
        } else {
            aj.c(this.fym, d.e.cp_cont_d, 1);
            this.fym.setEnabled(false);
            PluginPackageManager.jv().a(this.fyn, this.DP);
        }
    }

    private void beG() {
        String string;
        String string2;
        if (this.fyn != null && this.fyn.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fyn.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cL(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.c(PluginDetailActivity.this.fym, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fym.setEnabled(false);
                    PluginPackageManager.jv().a(PluginDetailActivity.this.fyn, PluginDetailActivity.this.DP);
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
            aVar.tb();
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
        PluginPackageManager.jv().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
