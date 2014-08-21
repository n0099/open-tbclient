package com.baidu.tieba.plugins;

import android.os.Bundle;
import android.view.WindowManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bm;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tieba.u;
import com.baidu.tieba.x;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PluginDownloadActivity extends BaseActivity {
    private g a;
    private ConfigInfos.PluginConfig b;
    private boolean c;
    private boolean d;

    static {
        TbadkApplication.m252getInst().RegisterIntent(bm.class, PluginDownloadActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (ConfigInfos.PluginConfig) getIntent().getSerializableExtra("plugin_config");
        if (this.b == null) {
            showToast(getString(x.plugin_config_not_found), false);
            finish();
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = 0.0f;
        getWindow().setAttributes(attributes);
        this.a = new g(this, this, y.common_alert_dialog);
        this.a.setCancelable(false);
        this.a.setOnKeyListener(new e(this));
        this.a.setOnDismissListener(new f(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.a.findViewById(u.dialog_layout));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        com.baidu.tbadk.pluginArch.d.a().f();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }
}
