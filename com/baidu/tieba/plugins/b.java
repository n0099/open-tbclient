package com.baidu.tieba.plugins;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.editortool.ab;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginCenterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginCenterActivity pluginCenterActivity) {
        this.a = pluginCenterActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        BdListView bdListView;
        ab abVar;
        bdListView = this.a.b;
        abVar = this.a.e;
        ag.a(bdListView, abVar, 0, 0);
    }
}
