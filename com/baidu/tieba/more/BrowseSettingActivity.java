package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* loaded from: classes.dex */
public class BrowseSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private l bqz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bqz = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bqz.onChangeSkinType(i);
    }

    public static void ae(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bqz.Uj()) {
            this.bqz.Uo();
        } else if (view == this.bqz.Uk()) {
            this.bqz.Up();
        } else if (view == this.bqz.Ul()) {
            this.bqz.Uq();
        } else if (view == this.bqz.Um()) {
            this.bqz.Ur();
        } else if (view == this.bqz.Un()) {
            this.bqz.Us();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
            this.bqz.Uz().B(false);
            showToast(com.baidu.tieba.y.plugin_night_resource_init_doing);
        } else if (switchState == BdSwitchView.SwitchState.ON) {
            this.bqz.gG(1);
        } else {
            this.bqz.gG(0);
        }
    }
}
