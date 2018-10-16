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
    private TextView cuc;
    private HeadImageView gxc;
    private TextView gxd;
    private TextView gxe;
    private TextView gxf;
    private String gxg;
    private PluginNetConfigInfos.PluginConfig gxh;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ld = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gxh.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gxf, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gxf.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gxf.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gxh.package_name)) {
                PluginDetailActivity.this.gxf.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gxf.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gxh.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bqY();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.bqY();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bqY();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kX()) {
                PluginDetailActivity.this.bqY();
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
        this.gxc = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.cuc = (TextView) findViewById(e.g.status);
        this.gxd = (TextView) findViewById(e.g.changelog);
        this.gxe = (TextView) findViewById(e.g.size);
        this.gxf = (TextView) findViewById(e.g.enable);
        this.gxf.setOnClickListener(this);
        this.gxg = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nz().nA() != null) {
            this.gxh = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nz().nA().getPluginConfig(this.gxg);
        }
        if (PluginPackageManager.nd().cb(this.gxg)) {
            PluginPackageManager.nd().a(this.Ld);
            al.c(this.gxf, e.d.cp_cont_d, 1);
            this.gxf.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gxh != null) {
            this.gxc.startLoad(this.gxh.icon, 10, false);
            if (this.gxh.display_name == null) {
                this.gxh.display_name = "";
            }
            this.mName.setText(this.gxh.display_name);
            bqY();
            if (this.gxh.newest != null) {
                if (TextUtils.isEmpty(this.gxh.newest.change_log)) {
                    this.gxd.setText("");
                } else {
                    this.gxd.setText(this.gxh.newest.change_log);
                }
                if (this.gxh.newest.size <= 0) {
                    this.gxe.setText("");
                } else {
                    this.gxe.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gxh.newest.size / 1024) + "KB");
                }
            }
            this.gxf.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.nd().bZ(this.gxg) && PluginPackageManager.nd().bX(this.gxg)) {
            this.cuc.setText(e.j.plugin_enabled);
            this.gxf.setText(e.j.download_update);
            this.gxf.setEnabled(true);
            al.c(this.gxf, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.nd().bX(this.gxg)) {
            this.gxf.setEnabled(true);
            al.c(this.gxf, e.d.cp_cont_g, 1);
            if (PluginPackageManager.nd().bY(this.gxg)) {
                this.cuc.setText(e.j.plugin_unenabled);
                this.gxf.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cuc.setText(e.j.plugin_enabled);
                this.gxf.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cuc.setText(e.j.plugin_disabled);
            this.gxf.setText(e.j.plugin_enable);
            this.gxf.setEnabled(true);
            al.c(this.gxf, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.nd().cb(this.gxg)) {
            al.c(this.gxf, e.d.cp_cont_d, 1);
            this.gxf.setEnabled(false);
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
        if (view == this.gxf) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bqZ();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nd().bV(this.gxg);
                bqY();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nd().bW(this.gxg);
                bqY();
            }
        }
    }

    private void bqZ() {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (j.kZ()) {
            bra();
        } else {
            al.c(this.gxf, e.d.cp_cont_d, 1);
            this.gxf.setEnabled(false);
            PluginPackageManager.nd().a(this.gxh, this.Ld);
        }
    }

    private void bra() {
        String string;
        String string2;
        if (this.gxh != null && this.gxh.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gxh.newest.size / 1048576.0f;
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
                    al.c(PluginDetailActivity.this.gxf, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gxf.setEnabled(false);
                    PluginPackageManager.nd().a(PluginDetailActivity.this.gxh, PluginDetailActivity.this.Ld);
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
            aVar.Au();
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
