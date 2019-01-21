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
    private TextView cAa;
    private HeadImageView gJq;
    private TextView gJr;
    private TextView gJs;
    private TextView gJt;
    private String gJu;
    private PluginNetConfigInfos.PluginConfig gJv;
    private boolean mFinished;
    private TextView mName;
    private NavigationBar mNavigationBar;
    private int mStatus;
    private d Ll = new d() { // from class: com.baidu.tieba.pluginCenter.PluginDetailActivity.4
        @Override // com.baidu.adp.plugin.packageManager.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJv.package_name) && !PluginDetailActivity.this.mFinished) {
                al.c(PluginDetailActivity.this.gJt, e.d.cp_cont_d, 1);
                PluginDetailActivity.this.gJt.setText(PluginDetailActivity.this.getPageContext().getResources().getString(e.j.plugin_download_percent, Long.valueOf((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize())));
                PluginDetailActivity.this.gJt.setEnabled(false);
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJv.package_name)) {
                PluginDetailActivity.this.gJt.setText(PluginDetailActivity.this.getPageContext().getString(e.j.plugin_download_finished));
                PluginDetailActivity.this.gJt.setEnabled(false);
                PluginDetailActivity.this.mFinished = true;
            }
        }

        @Override // com.baidu.adp.plugin.packageManager.d
        public void c(BdFileDownloadData bdFileDownloadData) {
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(PluginDetailActivity.this.gJv.package_name)) {
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
        this.gJq = (HeadImageView) findViewById(e.g.icon);
        this.mName = (TextView) findViewById(e.g.name);
        this.cAa = (TextView) findViewById(e.g.status);
        this.gJr = (TextView) findViewById(e.g.changelog);
        this.gJs = (TextView) findViewById(e.g.size);
        this.gJt = (TextView) findViewById(e.g.enable);
        this.gJt.setOnClickListener(this);
        this.gJu = getIntent().getStringExtra("name");
        if (com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB() != null) {
            this.gJv = com.baidu.adp.plugin.packageManager.pluginServerConfig.d.nA().nB().getPluginConfig(this.gJu);
        }
        if (PluginPackageManager.nd().cc(this.gJu)) {
            PluginPackageManager.nd().a(this.Ll);
            al.c(this.gJt, e.d.cp_cont_d, 1);
            this.gJt.setEnabled(false);
        }
        registerListener(this.mNetworkChangedMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.gJv != null) {
            this.gJq.startLoad(this.gJv.icon, 10, false);
            if (this.gJv.display_name == null) {
                this.gJv.display_name = "";
            }
            this.mName.setText(this.gJv.display_name);
            btH();
            if (this.gJv.newest != null) {
                if (TextUtils.isEmpty(this.gJv.newest.change_log)) {
                    this.gJr.setText("");
                } else {
                    this.gJr.setText(this.gJv.newest.change_log);
                }
                if (this.gJv.newest.size <= 0) {
                    this.gJs.setText("");
                } else {
                    this.gJs.setText(getPageContext().getString(e.j.plugin_size) + String.valueOf(this.gJv.newest.size / 1024) + "KB");
                }
            }
            this.gJt.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001303));
        if (PluginPackageManager.nd().ca(this.gJu) && PluginPackageManager.nd().bY(this.gJu)) {
            this.cAa.setText(e.j.plugin_enabled);
            this.gJt.setText(e.j.download_update);
            this.gJt.setEnabled(true);
            al.c(this.gJt, e.d.cp_cont_g, 1);
            this.mStatus = 1;
        } else if (PluginPackageManager.nd().bY(this.gJu)) {
            this.gJt.setEnabled(true);
            al.c(this.gJt, e.d.cp_cont_g, 1);
            if (PluginPackageManager.nd().bZ(this.gJu)) {
                this.cAa.setText(e.j.plugin_unenabled);
                this.gJt.setText(e.j.plugin_enable);
                this.mStatus = 2;
            } else {
                this.cAa.setText(e.j.plugin_enabled);
                this.gJt.setText(e.j.plugin_unenable);
                this.mStatus = 3;
            }
        } else {
            this.cAa.setText(e.j.plugin_disabled);
            this.gJt.setText(e.j.plugin_enable);
            this.gJt.setEnabled(true);
            al.c(this.gJt, e.d.cp_cont_g, 1);
            this.mStatus = 0;
        }
        if (PluginPackageManager.nd().cc(this.gJu)) {
            al.c(this.gJt, e.d.cp_cont_d, 1);
            this.gJt.setEnabled(false);
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
        if (view == this.gJt) {
            if (this.mStatus == 0 || this.mStatus == 1) {
                btI();
            } else if (this.mStatus == 3) {
                PluginPackageManager.nd().bW(this.gJu);
                btH();
            } else if (this.mStatus == 2) {
                PluginPackageManager.nd().bX(this.gJu);
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
            al.c(this.gJt, e.d.cp_cont_d, 1);
            this.gJt.setEnabled(false);
            PluginPackageManager.nd().a(this.gJv, this.Ll);
        }
    }

    private void btJ() {
        String string;
        String string2;
        if (this.gJv != null && this.gJv.newest != null) {
            a aVar = new a(getPageContext().getPageActivity());
            boolean z = this.mStatus == 1;
            float f = this.gJv.newest.size / 1048576.0f;
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
                    al.c(PluginDetailActivity.this.gJt, e.d.cp_cont_d, 1);
                    PluginDetailActivity.this.gJt.setEnabled(false);
                    PluginPackageManager.nd().a(PluginDetailActivity.this.gJv, PluginDetailActivity.this.Ll);
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
