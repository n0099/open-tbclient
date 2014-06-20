package com.baidu.tieba.plugins;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.editortool.ab;
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
        c cVar;
        BdListView bdListView;
        ab abVar;
        if (pluginsConfig != null) {
            cVar = this.a.a;
            cVar.notifyDataSetChanged();
            bdListView = this.a.b;
            abVar = this.a.e;
            ag.a(bdListView, abVar, 0, -1);
        }
    }
}
