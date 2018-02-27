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
    private TextView cCW;
    private HeadImageView gwr;
    private TextView gws;
    private TextView gwt;
    private TextView gwu;
    private PluginNetConfigInfos.PluginConfig gwv;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private String mPluginName;
    private int mStatus;
    private d arx = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwv.package_name) && !PluginDetailActivity.this.mFinished) {
                aj.e(PluginDetailActivity.this.gwu, d.C0141d.cp_cont_d, 1);
                PluginDetailActivity.this.gwu.setText(PluginDetailActivity.this.getPageContext().getResources().getString(d.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gwu.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwv.package_name)) {
                PluginDetailActivity.this.gwu.setText(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_download_finished));
                PluginDetailActivity.this.gwu.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gwv.package_name)) {
                PluginDetailActivity.this.showToast(bdFileDownloadData.getStatusMsg());
                PluginDetailActivity.this.bme();
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData, int i, String str) {
            if (i == 0) {
                PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_finished));
                PluginDetailActivity.this.bme();
                return;
            }
            PluginDetailActivity.this.showToast(PluginDetailActivity.this.getPageContext().getString(d.j.plugin_installation_failed) + str);
            PluginDetailActivity.this.bme();
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.oJ()) {
                PluginDetailActivity.this.bme();
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
        this.gwr = (HeadImageView) findViewById(d.g.icon);
        this.mName = (TextView) findViewById(d.g.name);
        this.cCW = (TextView) findViewById(d.g.status);
        this.gws = (TextView) findViewById(d.g.changelog);
        this.gwt = (TextView) findViewById(d.g.size);
        this.gwu = (TextView) findViewById(d.g.enable);
        this.gwu.setOnClickListener(this);
        this.mPluginName = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp() != null) {
            this.gwv = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.ro().rp().getPluginConfig(this.mPluginName);
        }
        if (PluginPackageManager.qS().bz(this.mPluginName)) {
            PluginPackageManager.qS().a(this.arx);
            aj.e(this.gwu, d.C0141d.cp_cont_d, 1);
            this.gwu.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gwv != null) {
            this.gwr.startLoad(this.gwv.icon, 10, false);
            if (this.gwv.display_name == null) {
                this.gwv.display_name = "";
            }
            this.mName.setText(this.gwv.display_name);
            bme();
            if (this.gwv.newest != null) {
                if (TextUtils.isEmpty(this.gwv.newest.change_log)) {
                    this.gws.setText("");
                } else {
                    this.gws.setText(this.gwv.newest.change_log);
                }
                if (this.gwv.newest.size <= 0) {
                    this.gwt.setText("");
                } else {
                    this.gwt.setText(getPageContext().getString(d.j.plugin_size) + String.valueOf(this.gwv.newest.size / 1024) + "KB");
                }
            }
            this.gwu.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bme() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.qS().bx(this.mPluginName) && PluginPackageManager.qS().bv(this.mPluginName)) {
            this.cCW.setText(d.j.plugin_enabled);
            this.gwu.setText(d.j.download_update);
            this.gwu.setEnabled(true);
            aj.e(this.gwu, d.C0141d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.qS().bv(this.mPluginName)) {
            this.gwu.setEnabled(true);
            aj.e(this.gwu, d.C0141d.cp_cont_g, 1);
            if (PluginPackageManager.qS().bw(this.mPluginName)) {
                this.cCW.setText(d.j.plugin_unenabled);
                this.gwu.setText(d.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cCW.setText(d.j.plugin_enabled);
                this.gwu.setText(d.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cCW.setText(d.j.plugin_disabled);
            this.gwu.setText(d.j.plugin_enable);
            this.gwu.setEnabled(true);
            aj.e(this.gwu, d.C0141d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.qS().bz(this.mPluginName)) {
            aj.e(this.gwu, d.C0141d.cp_cont_d, 1);
            this.gwu.setEnabled(false);
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
        if (view == this.gwu) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                bmf();
            } else if (this.mStatus == 3) {
                PluginPackageManager.qS().bt(this.mPluginName);
                bme();
            } else if (this.mStatus == 2) {
                PluginPackageManager.qS().bu(this.mPluginName);
                bme();
            }
        }
    }

    private void bmf() {
        if (!j.oJ()) {
            showToast(d.j.neterror);
        } else if (j.oL()) {
            bmg();
        } else {
            aj.e(this.gwu, d.C0141d.cp_cont_d, 1);
            this.gwu.setEnabled(false);
            PluginPackageManager.qS().a(this.gwv, this.arx);
        }
    }

    private void bmg() {
        String string;
        String string2;
        if (this.gwv != null && this.gwv.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gwv.newest.size / 1048576.0f;
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
                    aj.e(PluginDetailActivity.this.gwu, d.C0141d.cp_cont_d, 1);
                    PluginDetailActivity.this.gwu.setEnabled(false);
                    PluginPackageManager.qS().a(PluginDetailActivity.this.gwv, PluginDetailActivity.this.arx);
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
            aVar.AU();
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
