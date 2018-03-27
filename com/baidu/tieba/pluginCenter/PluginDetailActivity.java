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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cCZ;
    private HeadImageView gwH;
    private TextView gwI;
    private TextView gwJ;
    private TextView gwK;
    private PluginNetConfigInfos.PluginConfig gwL;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d ary = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwL.package_name) && !PluginDetailActivity.this.mFinished) {
                aj.e(PluginDetailActivity.this.gwK, d.C0141d.cp_cont_d, 1);
                PluginDetailActivity.this.gwK.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gwK.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwL.package_name)) {
                PluginDetailActivity.this.gwK.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.gwK.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwL.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bmf();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bmf();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bmf();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ()) {
                PluginDetailActivity.this.bmf();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.navigation_bar);
        this.mNavigationBar.setTitleText(d.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.gwH = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.cCZ = (TextView) findViewById(d.g.status);
        this.gwI = (TextView) findViewById(d.g.changelog);
        this.gwJ = (TextView) findViewById(d.g.size);
        this.gwK = (TextView) findViewById(d.g.enable);
        this.gwK.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null) {
            this.gwL = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.qS().bz(this.mPluginName)) {
            PluginPackageManager.qS().a(this.ary);
            aj.e(this.gwK, d.C0141d.cp_cont_d, 1);
            this.gwK.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gwL != null) {
            this.gwH.startLoad(this.gwL.icon, 10, false);
            if (this.gwL.display_name == null) {
                this.gwL.display_name = "";
            }
            this.mName.setText(this.gwL.display_name);
            bmf();
            if (this.gwL.newest != null) {
                if (TextUtils.isEmpty(this.gwL.newest.change_log)) {
                    this.gwI.setText("");
                } else {
                    this.gwI.setText(this.gwL.newest.change_log);
                }
                if (this.gwL.newest.size <= 0) {
                    this.gwJ.setText("");
                } else {
                    this.gwJ.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.gwL.newest.size / 1024) + "KB");
                }
            }
            this.gwK.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.qS().bx(this.mPluginName) && PluginPackageManager.qS().bv(this.mPluginName)) {
            this.cCZ.setText(d.j.plugin_enabled);
            this.gwK.setText(d.j.download_update);
            this.gwK.setEnabled(true);
            aj.e(this.gwK, d.C0141d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.qS().bv(this.mPluginName)) {
            this.gwK.setEnabled(true);
            aj.e(this.gwK, d.C0141d.cp_cont_g, 1);
            if (PluginPackageManager.qS().bw(this.mPluginName)) {
                this.cCZ.setText(d.j.plugin_unenabled);
                this.gwK.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cCZ.setText(d.j.plugin_enabled);
                this.gwK.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cCZ.setText(d.j.plugin_disabled);
            this.gwK.setText(d.j.plugin_enable);
            this.gwK.setEnabled(true);
            aj.e(this.gwK, d.C0141d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.qS().bz(this.mPluginName)) {
            aj.e(this.gwK, d.C0141d.cp_cont_d, 1);
            this.gwK.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gwK) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bmg();
            } else if (this.mStatus == 3) {
                PluginPackageManager.qS().bt(this.mPluginName);
                bmf();
            } else if (this.mStatus == 2) {
                PluginPackageManager.qS().bu(this.mPluginName);
                bmf();
            }
        }
    }

    private void bmg() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (j.oL()) {
            bmh();
        } else {
            aj.e(this.gwK, d.C0141d.cp_cont_d, 1);
            this.gwK.setEnabled(false);
            PluginPackageManager.qS().a(this.gwL, this.ary);
        }
    }

    private void bmh() {
        String string;
        String string2;
        if (this.gwL != null && this.gwL.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gwL.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(d.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download_update);
            } else {
                string = getResources().getString(d.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(d.j.download);
            }
            aVar.dk(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aj.e(PluginDetailActivity.this.gwK, d.C0141d.cp_cont_d, 1);
                    PluginDetailActivity.this.gwK.setEnabled(false);
                    PluginPackageManager.qS().a(PluginDetailActivity.this.gwL, PluginDetailActivity.this.ary);
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.AV();
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
        PluginPackageManager.qS().a((com.baidu.adp.plugin.packageManager.d) null);
    }
}
