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
    private TextView czZ;
    private HeadImageView gJp;
    private TextView gJq;
    private TextView gJr;
    private TextView gJs;
    private String gJt;
    private PluginNetConfigInfos.PluginConfig gJu;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ll = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJu.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gJs, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gJs.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gJs.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJu.package_name)) {
                PluginDetailActivity.this.gJs.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gJs.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJu.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.btH();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.btH();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.btH();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV()) {
                PluginDetailActivity.this.btH();
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
        this.gJp = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.czZ = (TextView) findViewById(e.g.status);
        this.gJq = (TextView) findViewById(e.g.changelog);
        this.gJr = (TextView) findViewById(e.g.size);
        this.gJs = (TextView) findViewById(e.g.enable);
        this.gJs.setOnClickListener(this);
        this.gJt = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB() != null) {
            this.gJu = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB().getPluginConfig(this.gJt);
        }
        if (PluginPackageManager.nd().cc(this.gJt)) {
            PluginPackageManager.nd().a(this.Ll);
            al.c(this.gJs, e.d.cp_cont_d, 1);
            this.gJs.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gJu != null) {
            this.gJp.startLoad(this.gJu.icon, 10, false);
            if (this.gJu.display_name == null) {
                this.gJu.display_name = "";
            }
            this.mName.setText(this.gJu.display_name);
            btH();
            if (this.gJu.newest != null) {
                if (TextUtils.isEmpty(this.gJu.newest.change_log)) {
                    this.gJq.setText("");
                } else {
                    this.gJq.setText(this.gJu.newest.change_log);
                }
                if (this.gJu.newest.size <= 0) {
                    this.gJr.setText("");
                } else {
                    this.gJr.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gJu.newest.size / 1024) + "KB");
                }
            }
            this.gJs.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.nd().ca(this.gJt) && PluginPackageManager.nd().bY(this.gJt)) {
            this.czZ.setText(e.j.plugin_enabled);
            this.gJs.setText(e.j.download_update);
            this.gJs.setEnabled(true);
            al.c(this.gJs, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.nd().bY(this.gJt)) {
            this.gJs.setEnabled(true);
            al.c(this.gJs, e.d.cp_cont_g, 1);
            if (PluginPackageManager.nd().bZ(this.gJt)) {
                this.czZ.setText(e.j.plugin_unenabled);
                this.gJs.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.czZ.setText(e.j.plugin_enabled);
                this.gJs.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.czZ.setText(e.j.plugin_disabled);
            this.gJs.setText(e.j.plugin_enable);
            this.gJs.setEnabled(true);
            al.c(this.gJs, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.nd().cc(this.gJt)) {
            al.c(this.gJs, e.d.cp_cont_d, 1);
            this.gJs.setEnabled(false);
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
        if (view == this.gJs) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                btI();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nd().bW(this.gJt);
                btH();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nd().bX(this.gJt);
                btH();
            }
        }
    }

    private void btI() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (j.kX()) {
            btJ();
        } else {
            al.c(this.gJs, e.d.cp_cont_d, 1);
            this.gJs.setEnabled(false);
            PluginPackageManager.nd().a(this.gJu, this.Ll);
        }
    }

    private void btJ() {
        String string;
        String string2;
        if (this.gJu != null && this.gJu.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gJu.newest.size / 1048576.0f;
            if (z) {
                string = getResources().getString(e.j.plugin_update_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download_update);
            } else {
                string = getResources().getString(e.j.plugin_download_size_prompt, Float.valueOf(f));
                string2 = getResources().getString(e.j.download);
            }
            aVar.eK(string);
            aVar.a(string2, new a.b() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(a aVar2) {
                    al.c(PluginDetailActivity.this.gJs, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gJs.setEnabled(false);
                    PluginPackageManager.nd().a(PluginDetailActivity.this.gJu, PluginDetailActivity.this.Ll);
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
            aVar.BS();
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
        PluginPackageManager.nd().a((d) null);
    }
}
