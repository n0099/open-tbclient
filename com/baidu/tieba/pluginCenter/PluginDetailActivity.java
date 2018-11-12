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
    private TextView cuo;
    private HeadImageView gyE;
    private TextView gyF;
    private TextView gyG;
    private TextView gyH;
    private String gyI;
    private PluginNetConfigInfos.PluginConfig gyJ;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gyJ.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gyH, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gyH.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gyH.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gyJ.package_name)) {
                PluginDetailActivity.this.gyH.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gyH.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gyJ.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bqu();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.bqu();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bqu();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV()) {
                PluginDetailActivity.this.bqu();
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
        this.gyE = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.cuo = (TextView) findViewById(e.g.status);
        this.gyF = (TextView) findViewById(e.g.changelog);
        this.gyG = (TextView) findViewById(e.g.size);
        this.gyH = (TextView) findViewById(e.g.enable);
        this.gyH.setOnClickListener(this);
        this.gyI = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nx().ny() != null) {
            this.gyJ = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nx().ny().getPluginConfig(this.gyI);
        }
        if (PluginPackageManager.nb().cb(this.gyI)) {
            PluginPackageManager.nb().a(this.Lg);
            al.c(this.gyH, e.d.cp_cont_d, 1);
            this.gyH.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gyJ != null) {
            this.gyE.startLoad(this.gyJ.icon, 10, false);
            if (this.gyJ.display_name == null) {
                this.gyJ.display_name = "";
            }
            this.mName.setText(this.gyJ.display_name);
            bqu();
            if (this.gyJ.newest != null) {
                if (TextUtils.isEmpty(this.gyJ.newest.change_log)) {
                    this.gyF.setText("");
                } else {
                    this.gyF.setText(this.gyJ.newest.change_log);
                }
                if (this.gyJ.newest.size <= 0) {
                    this.gyG.setText("");
                } else {
                    this.gyG.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gyJ.newest.size / 1024) + "KB");
                }
            }
            this.gyH.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.nb().bZ(this.gyI) && PluginPackageManager.nb().bX(this.gyI)) {
            this.cuo.setText(e.j.plugin_enabled);
            this.gyH.setText(e.j.download_update);
            this.gyH.setEnabled(true);
            al.c(this.gyH, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.nb().bX(this.gyI)) {
            this.gyH.setEnabled(true);
            al.c(this.gyH, e.d.cp_cont_g, 1);
            if (PluginPackageManager.nb().bY(this.gyI)) {
                this.cuo.setText(e.j.plugin_unenabled);
                this.gyH.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cuo.setText(e.j.plugin_enabled);
                this.gyH.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cuo.setText(e.j.plugin_disabled);
            this.gyH.setText(e.j.plugin_enable);
            this.gyH.setEnabled(true);
            al.c(this.gyH, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.nb().cb(this.gyI)) {
            al.c(this.gyH, e.d.cp_cont_d, 1);
            this.gyH.setEnabled(false);
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
        if (view == this.gyH) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bqv();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nb().bV(this.gyI);
                bqu();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nb().bW(this.gyI);
                bqu();
            }
        }
    }

    private void bqv() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (j.kX()) {
            bqw();
        } else {
            al.c(this.gyH, e.d.cp_cont_d, 1);
            this.gyH.setEnabled(false);
            PluginPackageManager.nb().a(this.gyJ, this.Lg);
        }
    }

    private void bqw() {
        String string;
        String string2;
        if (this.gyJ != null && this.gyJ.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gyJ.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(e.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download_update);
            } else {
                string = getResources().getString(e.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download);
            }
            aVar.ej(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.c(PluginDetailActivity.this.gyH, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gyH.setEnabled(false);
                    PluginPackageManager.nb().a(PluginDetailActivity.this.gyJ, PluginDetailActivity.this.Lg);
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
            aVar.AB();
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
        PluginPackageManager.nb().a((d) null);
    }
}
