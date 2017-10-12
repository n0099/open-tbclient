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
    private TextView bxb;
    private boolean den;
    private HeadImageView fuZ;
    private TextView fyA;
    private PluginNetConfigInfos.PluginConfig fyB;
    private TextView fyy;
    private TextView fyz;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d DO = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyB.package_name) && !PluginDetailActivity.this.den) {
                aj.c(PluginDetailActivity.this.fyA, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fyA.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fyA.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyB.package_name)) {
                PluginDetailActivity.this.fyA.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fyA.setEnabled(false);
                PluginDetailActivity.this.den = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fyB.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.beJ();
                PluginDetailActivity.this.den = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.beJ();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.beJ();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.hh()) {
                PluginDetailActivity.this.beJ();
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
        this.fuZ = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.bxb = (TextView) findViewById(d.h.status);
        this.fyy = (TextView) findViewById(d.h.changelog);
        this.fyz = (TextView) findViewById(d.h.size);
        this.fyA = (TextView) findViewById(d.h.enable);
        this.fyA.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS() != null) {
            this.fyB = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jR().jS().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jv().br(this.mPluginName)) {
            PluginPackageManager.jv().a(this.DO);
            aj.c(this.fyA, d.e.cp_cont_d, 1);
            this.fyA.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fyB != null) {
            this.fuZ.c(this.fyB.icon, 10, false);
            if (this.fyB.display_name == null) {
                this.fyB.display_name = "";
            }
            this.mName.setText(this.fyB.display_name);
            beJ();
            if (this.fyB.newest != null) {
                if (TextUtils.isEmpty(this.fyB.newest.change_log)) {
                    this.fyy.setText("");
                } else {
                    this.fyy.setText(this.fyB.newest.change_log);
                }
                if (this.fyB.newest.size <= 0) {
                    this.fyz.setText("");
                } else {
                    this.fyz.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fyB.newest.size / 1024) + "KB");
                }
            }
            this.fyA.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jv().bp(this.mPluginName) && PluginPackageManager.jv().bn(this.mPluginName)) {
            this.bxb.setText(d.l.plugin_enabled);
            this.fyA.setText(d.l.download_update);
            this.fyA.setEnabled(true);
            aj.c(this.fyA, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jv().bn(this.mPluginName)) {
            this.fyA.setEnabled(true);
            aj.c(this.fyA, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jv().bo(this.mPluginName)) {
                this.bxb.setText(d.l.plugin_unenabled);
                this.fyA.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bxb.setText(d.l.plugin_enabled);
                this.fyA.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bxb.setText(d.l.plugin_disabled);
            this.fyA.setText(d.l.plugin_enable);
            this.fyA.setEnabled(true);
            aj.c(this.fyA, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jv().br(this.mPluginName)) {
            aj.c(this.fyA, d.e.cp_cont_d, 1);
            this.fyA.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ai(i == 1);
        getLayoutMode().t(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fyA) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                beK();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jv().bl(this.mPluginName);
                beJ();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jv().bm(this.mPluginName);
                beJ();
            }
        }
    }

    private void beK() {
        if (!j.hh()) {
            showToast(d.l.neterror);
        } else if (j.hj()) {
            beL();
        } else {
            aj.c(this.fyA, d.e.cp_cont_d, 1);
            this.fyA.setEnabled(false);
            PluginPackageManager.jv().a(this.fyB, this.DO);
        }
    }

    private void beL() {
        String string;
        String string2;
        if (this.fyB != null && this.fyB.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fyB.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.l.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download_update);
            } else {
                string = getResources().getString(d.l.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.l.download);
            }
            aVar.cM(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.c(PluginDetailActivity.this.fyA, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fyA.setEnabled(false);
                    PluginPackageManager.jv().a(PluginDetailActivity.this.fyB, PluginDetailActivity.this.DO);
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
            aVar.ti();
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
