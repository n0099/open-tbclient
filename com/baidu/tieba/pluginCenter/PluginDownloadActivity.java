package com.baidu.tieba.pluginCenter;

import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity<PluginDownloadActivity> {
    private PluginNetConfigInfos.PluginConfig bUu;
    private g bUw;
    private boolean bUx;
    private boolean mFinished;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bUu = (PluginNetConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.bUu == null) {
            showToast(getPageContext().getString(y.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.bUw = new g(this, getPageContext().getPageActivity(), z.common_alert_dialog);
        this.bUw.setCancelable(false);
        this.bUw.setOnKeyListener(new e(this));
        this.bUw.setOnDismissListener(new f(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bUw.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.bUw.findViewById(v.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bUu != null) {
            PluginPackageManager.ls().bp(this.bUu.package_name);
        }
        super.onDestroy();
    }
}
