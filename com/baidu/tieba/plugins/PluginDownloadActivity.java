package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity {
    private ConfigInfos.PluginConfig bHe;
    private boolean bHf;
    private g bHh;
    private boolean bHi;

    static {
        TbadkApplication.m251getInst().RegisterIntent(PluginDownloadActivityConfig.class, PluginDownloadActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bHe = (ConfigInfos.PluginConfig) getIntent().getSerializableExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG);
        if (this.bHe == null) {
            showToast(getString(y.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.bHh = new g(this, this, z.common_alert_dialog);
        this.bHh.setCancelable(false);
        this.bHh.setOnKeyListener(new e(this));
        this.bHh.setOnDismissListener(new f(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.bHh.show();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.bHh.findViewById(v.dialog_layout));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        PluginCenter.getInstance().cancelDownloadForeground();
        super.onDestroy();
    }
}
