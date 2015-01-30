package com.baidu.tieba.xiuba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* loaded from: classes.dex */
public class DealShortCutActivity extends BaseActivity<DealShortCutActivity> {
    private static final String MAINTAB_ACTIVITY_NAME = "com.baidu.tieba.tblauncher.MainTabActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isClientStart(getPageContext().getPageActivity())) {
            startXiuba(getPageContext().getPageActivity());
        } else {
            startClient(getPageContext().getPageActivity());
        }
        finish();
    }

    private boolean isClientStart(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.baseActivity.getClassName().equals(MAINTAB_ACTIVITY_NAME)) {
                return true;
            }
        }
        return false;
    }

    private void startXiuba(Context context) {
        XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.gW().hd();
        if (xiubaPlugin != null) {
            xiubaPlugin.startXiuba(context);
        }
    }

    private void startClient(Context context) {
        Intent intent = new Intent();
        intent.putExtra("class", 26);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LogoActivityConfig(context, intent)));
    }
}
