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
    private g bKB;
    private boolean bKC;
    private PluginNetConfigInfos.PluginConfig bKz;
    private boolean mFinished;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bKz = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.bKz == null) {
            showToast(getPageContext().getString(z.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.bKB = new g(this, getPageContext().getPageActivity(), aa.common_alert_dialog);
        this.bKB.setCancelable(false);
        this.bKB.setOnKeyListener(new e(this));
        this.bKB.setOnDismissListener(new f(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bKB.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.bKB.findViewById(w.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bKz != null) {
            PluginPackageManager.ic().bl(this.bKz.package_name);
        }
        super.onDestroy();
    }
}
