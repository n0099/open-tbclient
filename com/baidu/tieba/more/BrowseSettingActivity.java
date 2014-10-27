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
    private l bql = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bql = new l(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bql.onChangeSkinType(i);
    }

    public static void ae(Context context) {
        context.startActivity(new Intent(context, BrowseSettingActivity.class));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bql.Ug()) {
            this.bql.Ul();
        } else if (view == this.bql.Uh()) {
            this.bql.Um();
        } else if (view == this.bql.Ui()) {
            this.bql.Un();
        } else if (view == this.bql.Uj()) {
            this.bql.Uo();
        } else if (view == this.bql.Uk()) {
            this.bql.Up();
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (!PluginCenter.getInstance().checkPluginInstalled(PluginNameList.NAME_NIGHT_RESOURCE)) {
            this.bql.Uw().B(false);
            showToast(com.baidu.tieba.y.plugin_night_resource_init_doing);
        } else if (switchState == BdSwitchView.SwitchState.ON) {
            this.bql.gG(1);
        } else {
            this.bql.gG(0);
        }
    }
}
