package com.baidu.tieba.xiuba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* loaded from: classes.dex */
public class StartupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        XiubaPlugin xiubaPlugin = (XiubaPlugin) PluginCenter.getInstance().getXiubaClassInstance();
        if (xiubaPlugin != null) {
            xiubaPlugin.startUpReceiver_onReceive(context, intent);
        }
    }
}
