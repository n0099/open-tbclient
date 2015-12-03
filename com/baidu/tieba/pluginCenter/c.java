package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity ddw;
    private final /* synthetic */ PluginConfigWrapper ddx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.ddw = pluginCenterActivity;
        this.ddx = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.jg()) {
            PluginPackageManager lU = PluginPackageManager.lU();
            PluginConfigWrapper pluginConfigWrapper = this.ddx;
            eVar = this.ddw.DO;
            lU.a(pluginConfigWrapper, eVar);
            this.ddx.setDownLoadPercent(0.0f);
            this.ddx.setDownLoadStatus(3);
            bVar = this.ddw.ddt;
            bVar.A(this.ddx);
        } else {
            this.ddw.showToast(n.i.neterror);
        }
        aVar.dismiss();
    }
}
