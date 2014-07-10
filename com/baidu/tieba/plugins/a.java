package com.baidu.tieba.plugins;

import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.tbplugin.r {
    final /* synthetic */ PluginCenterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginCenterActivity pluginCenterActivity) {
        this.a = pluginCenterActivity;
    }

    @Override // com.baidu.tbadk.tbplugin.r
    public void a(PluginsConfig pluginsConfig) {
        b bVar;
        if (pluginsConfig != null) {
            bVar = this.a.a;
            bVar.notifyDataSetChanged();
        }
    }
}
