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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class PluginDetailActivity extends BaseActivity<PluginDetailActivity> {
    private TextView cyh;
    private HeadImageView gFu;
    private TextView gFv;
    private TextView gFw;
    private TextView gFx;
    private String gFy;
    private PluginNetConfigInfos.PluginConfig gFz;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFz.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gFx, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gFx.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gFx.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFz.package_name)) {
                PluginDetailActivity.this.gFx.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gFx.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gFz.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bsm();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.bsm();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bsm();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV()) {
                PluginDetailActivity.this.bsm();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.plugin_detail_activity);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.navigation_bar);
        this.mNavigationBar.setTitleText(e.j.plugin_center);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PluginDetailActivity.this.closeActivity();
            }
        });
        this.gFu = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.cyh = (TextView) findViewById(e.g.status);
        this.gFv = (TextView) findViewById(e.g.changelog);
        this.gFw = (TextView) findViewById(e.g.size);
        this.gFx = (TextView) findViewById(e.g.enable);
        this.gFx.setOnClickListener(this);
        this.gFy = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nw().nx() != null) {
            this.gFz = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nw().nx().getPluginConfig(this.gFy);
        }
        if (PluginPackageManager.na().cb(this.gFy)) {
            PluginPackageManager.na().a(this.Lg);
            al.c(this.gFx, e.d.cp_cont_d, 1);
            this.gFx.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gFz != null) {
            this.gFu.startLoad(this.gFz.icon, 10, false);
            if (this.gFz.display_name == null) {
                this.gFz.display_name = "";
            }
            this.mName.setText(this.gFz.display_name);
            bsm();
            if (this.gFz.newest != null) {
                if (TextUtils.isEmpty(this.gFz.newest.change_log)) {
                    this.gFv.setText("");
                } else {
                    this.gFv.setText(this.gFz.newest.change_log);
                }
                if (this.gFz.newest.size <= 0) {
                    this.gFw.setText("");
                } else {
                    this.gFw.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gFz.newest.size / 1024) + "KB");
                }
            }
            this.gFx.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.na().bZ(this.gFy) && PluginPackageManager.na().bX(this.gFy)) {
            this.cyh.setText(e.j.plugin_enabled);
            this.gFx.setText(e.j.download_update);
            this.gFx.setEnabled(true);
            al.c(this.gFx, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.na().bX(this.gFy)) {
            this.gFx.setEnabled(true);
            al.c(this.gFx, e.d.cp_cont_g, 1);
            if (PluginPackageManager.na().bY(this.gFy)) {
                this.cyh.setText(e.j.plugin_unenabled);
                this.gFx.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cyh.setText(e.j.plugin_enabled);
                this.gFx.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cyh.setText(e.j.plugin_disabled);
            this.gFx.setText(e.j.plugin_enable);
            this.gFx.setEnabled(true);
            al.c(this.gFx, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.na().cb(this.gFy)) {
            al.c(this.gFx, e.d.cp_cont_d, 1);
            this.gFx.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(findViewById(16908290));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFx) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bsn();
            } else if (this.mStatus == 3) {
                PluginPackageManager.na().bV(this.gFy);
                bsm();
            } else if (this.mStatus == 2) {
                PluginPackageManager.na().bW(this.gFy);
                bsm();
            }
        }
    }

    private void bsn() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (j.kX()) {
            bso();
        } else {
            al.c(this.gFx, e.d.cp_cont_d, 1);
            this.gFx.setEnabled(false);
            PluginPackageManager.na().a(this.gFz, this.Lg);
        }
    }

    private void bso() {
        String string;
        String string2;
        if (this.gFz != null && this.gFz.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gFz.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(e.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download_update);
            } else {
                string = getResources().getString(e.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download);
            }
            aVar.eB(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.c(PluginDetailActivity.this.gFx, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gFx.setEnabled(false);
                    PluginPackageManager.na().a(PluginDetailActivity.this.gFz, PluginDetailActivity.this.Lg);
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(getPageContext());
            aVar.BF();
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
        PluginPackageManager.na().a((d) null);
    }
}
