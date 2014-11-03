package com.baidu.tieba.xiuba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.XiubaPlugin;
/* loaded from: classes.dex */
public class StartupReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        XiubaPlugin xiubaPlugin;
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_XIUBA);
        if (pluginByName != null && (xiubaPlugin = (XiubaPlugin) pluginByName.getClassInstance(XiubaPlugin.class)) != null) {
            xiubaPlugin.startUpReceiver_onReceive(context, intent);
        }
    }
}
