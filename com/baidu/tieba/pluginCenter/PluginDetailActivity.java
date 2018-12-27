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
    private TextView czo;
    private HeadImageView gIl;
    private TextView gIm;
    private TextView gIn;
    private TextView gIo;
    private String gIp;
    private PluginNetConfigInfos.PluginConfig gIq;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Lg = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gIq.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gIo, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gIo.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gIo.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gIq.package_name)) {
                PluginDetailActivity.this.gIo.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gIo.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gIq.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bsY();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_finished));
                PluginDetailActivity.this.bsY();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bsY();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.kV()) {
                PluginDetailActivity.this.bsY();
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
        this.gIl = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.czo = (TextView) findViewById(e.g.status);
        this.gIm = (TextView) findViewById(e.g.changelog);
        this.gIn = (TextView) findViewById(e.g.size);
        this.gIo = (TextView) findViewById(e.g.enable);
        this.gIo.setOnClickListener(this);
        this.gIp = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nw().nx() != null) {
            this.gIq = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nw().nx().getPluginConfig(this.gIp);
        }
        if (PluginPackageManager.na().cb(this.gIp)) {
            PluginPackageManager.na().a(this.Lg);
            al.c(this.gIo, e.d.cp_cont_d, 1);
            this.gIo.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gIq != null) {
            this.gIl.startLoad(this.gIq.icon, 10, false);
            if (this.gIq.display_name == null) {
                this.gIq.display_name = "";
            }
            this.mName.setText(this.gIq.display_name);
            bsY();
            if (this.gIq.newest != null) {
                if (TextUtils.isEmpty(this.gIq.newest.change_log)) {
                    this.gIm.setText("");
                } else {
                    this.gIm.setText(this.gIq.newest.change_log);
                }
                if (this.gIq.newest.size <= 0) {
                    this.gIn.setText("");
                } else {
                    this.gIn.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gIq.newest.size / 1024) + "KB");
                }
            }
            this.gIo.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsY() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.na().bZ(this.gIp) && PluginPackageManager.na().bX(this.gIp)) {
            this.czo.setText(e.j.plugin_enabled);
            this.gIo.setText(e.j.download_update);
            this.gIo.setEnabled(true);
            al.c(this.gIo, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.na().bX(this.gIp)) {
            this.gIo.setEnabled(true);
            al.c(this.gIo, e.d.cp_cont_g, 1);
            if (PluginPackageManager.na().bY(this.gIp)) {
                this.czo.setText(e.j.plugin_unenabled);
                this.gIo.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.czo.setText(e.j.plugin_enabled);
                this.gIo.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.czo.setText(e.j.plugin_disabled);
            this.gIo.setText(e.j.plugin_enable);
            this.gIo.setEnabled(true);
            al.c(this.gIo, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.na().cb(this.gIp)) {
            al.c(this.gIo, e.d.cp_cont_d, 1);
            this.gIo.setEnabled(false);
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
        if (view == this.gIo) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bsZ();
            } else if (this.mStatus == 3) {
                PluginPackageManager.na().bV(this.gIp);
                bsY();
            } else if (this.mStatus == 2) {
                PluginPackageManager.na().bW(this.gIp);
                bsY();
            }
        }
    }

    private void bsZ() {
        if (!j.kV()) {
            showToast(e.j.neterror);
        } else if (j.kX()) {
            bta();
        } else {
            al.c(this.gIo, e.d.cp_cont_d, 1);
            this.gIo.setEnabled(false);
            PluginPackageManager.na().a(this.gIq, this.Lg);
        }
    }

    private void bta() {
        String string;
        String string2;
        if (this.gIq != null && this.gIq.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gIq.newest.size / 1048576.0f;
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
                    al.c(PluginDetailActivity.this.gIo, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gIo.setEnabled(false);
                    PluginPackageManager.na().a(PluginDetailActivity.this.gIq, PluginDetailActivity.this.Lg);
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
