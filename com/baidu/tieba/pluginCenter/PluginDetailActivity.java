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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView bvr;
    private boolean dia;
    private TextView fCe;
    private TextView fCf;
    private TextView fCg;
    private PluginNetConfigInfos.PluginConfig fCh;
    private HeadImageView fyQ;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d DM = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCh.package_name) && !PluginDetailActivity.this.dia) {
                aj.c(PluginDetailActivity.this.fCg, d.e.cp_cont_d, 1);
                PluginDetailActivity.this.fCg.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.l.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.fCg.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCh.package_name)) {
                PluginDetailActivity.this.fCg.setText(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_download_finished));
                PluginDetailActivity.this.fCg.setEnabled(false);
                PluginDetailActivity.this.dia = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.fCh.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bge();
                PluginDetailActivity.this.dia = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_finished));
                PluginDetailActivity.this.bge();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.l.plugin_installation_failed) + str);
            PluginDetailActivity.this.bge();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && i.hi()) {
                PluginDetailActivity.this.bge();
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
        this.fyQ = (HeadImageView) findViewById(d.h.icon);
        this.mName = (TextView) findViewById(d.h.name);
        this.bvr = (TextView) findViewById(d.h.status);
        this.fCe = (TextView) findViewById(d.h.changelog);
        this.fCf = (TextView) findViewById(d.h.size);
        this.fCg = (TextView) findViewById(d.h.enable);
        this.fCg.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT() != null) {
            this.fCh = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.jS().jT().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.jw().br(this.mPluginName)) {
            PluginPackageManager.jw().a(this.DM);
            aj.c(this.fCg, d.e.cp_cont_d, 1);
            this.fCg.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.fCh != null) {
            this.fyQ.c(this.fCh.icon, 10, false);
            if (this.fCh.display_name == null) {
                this.fCh.display_name = "";
            }
            this.mName.setText(this.fCh.display_name);
            bge();
            if (this.fCh.newest != null) {
                if (TextUtils.isEmpty(this.fCh.newest.change_log)) {
                    this.fCe.setText("");
                } else {
                    this.fCe.setText(this.fCh.newest.change_log);
                }
                if (this.fCh.newest.size <= 0) {
                    this.fCf.setText("");
                } else {
                    this.fCf.setText(getPageContext().getString(d.l.plugin_size) + String.valueOf(this.fCh.newest.size / 1024) + "KB");
                }
            }
            this.fCg.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PLUGIN_ENABLE_STATE_CHANGED));
        if (PluginPackageManager.jw().bp(this.mPluginName) && PluginPackageManager.jw().bn(this.mPluginName)) {
            this.bvr.setText(d.l.plugin_enabled);
            this.fCg.setText(d.l.download_update);
            this.fCg.setEnabled(true);
            aj.c(this.fCg, d.e.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.jw().bn(this.mPluginName)) {
            this.fCg.setEnabled(true);
            aj.c(this.fCg, d.e.cp_cont_g, 1);
            if (PluginPackageManager.jw().bo(this.mPluginName)) {
                this.bvr.setText(d.l.plugin_unenabled);
                this.fCg.setText(d.l.plugin_enable);
                this.mStatus = 2;
            } else {
                this.bvr.setText(d.l.plugin_enabled);
                this.fCg.setText(d.l.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.bvr.setText(d.l.plugin_disabled);
            this.fCg.setText(d.l.plugin_enable);
            this.fCg.setEnabled(true);
            aj.c(this.fCg, d.e.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.jw().br(this.mPluginName)) {
            aj.c(this.fCg, d.e.cp_cont_d, 1);
            this.fCg.setEnabled(false);
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
        if (view == this.fCg) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bgf();
            } else if (this.mStatus == 3) {
                PluginPackageManager.jw().bl(this.mPluginName);
                bge();
            } else if (this.mStatus == 2) {
                PluginPackageManager.jw().bm(this.mPluginName);
                bge();
            }
        }
    }

    private void bgf() {
        if (!i.hi()) {
            showToast(d.l.neterror);
        } else if (i.hk()) {
            bgg();
        } else {
            aj.c(this.fCg, d.e.cp_cont_d, 1);
            this.fCg.setEnabled(false);
            PluginPackageManager.jw().a(this.fCh, this.DM);
        }
    }

    private void bgg() {
        String string;
        String string2;
        if (this.fCh != null && this.fCh.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.fCh.newest.size / 1048576.0f;
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
                    aj.c(PluginDetailActivity.this.fCg, d.e.cp_cont_d, 1);
                    PluginDetailActivity.this.fCg.setEnabled(false);
                    PluginPackageManager.jw().a(PluginDetailActivity.this.fCh, PluginDetailActivity.this.DM);
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
            aVar.to();
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
        PluginPackageManager.jw().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
