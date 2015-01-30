package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.aa;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig bMk;
    private g bMm;
    private boolean bMn;
    private boolean mFinished;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bMk = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.bMk == null) {
            showToast(getPageContext().getString(z.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.bMm = new g(this, getPageContext().getPageActivity(), aa.common_alert_dialog);
        this.bMm.setCancelable(false);
        this.bMm.setOnKeyListener(new e(this));
        this.bMm.setOnDismissListener(new f(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bMm.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bMm.findViewById(w.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bMk != null) {
            PluginPackageManager.ic().bl(this.bMk.package_name);
        }
        super.onDestroy();
    }
}
