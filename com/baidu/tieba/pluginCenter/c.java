package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity dwW;
    private final /* synthetic */ PluginConfigWrapper dwX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.dwW = pluginCenterActivity;
        this.dwX = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.jq()) {
            PluginPackageManager lD = PluginPackageManager.lD();
            PluginConfigWrapper pluginConfigWrapper = this.dwX;
            eVar = this.dwW.Ev;
            lD.a(pluginConfigWrapper, eVar);
            this.dwX.setDownLoadPercent(0.0f);
            this.dwX.setDownLoadStatus(3);
            bVar = this.dwW.dwU;
            bVar.A(this.dwX);
        } else {
            this.dwW.showToast(t.j.neterror);
        }
        aVar.dismiss();
    }
}
