package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity fgN;
    private final /* synthetic */ PluginConfigWrapper fgO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.fgN = pluginCenterActivity;
        this.fgO = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.gD()) {
            PluginPackageManager iB = PluginPackageManager.iB();
            PluginConfigWrapper pluginConfigWrapper = this.fgO;
            eVar = this.fgN.xI;
            iB.a(pluginConfigWrapper, eVar);
            this.fgO.setDownLoadPercent(0.0f);
            this.fgO.setDownLoadStatus(3);
            bVar = this.fgN.fgL;
            bVar.D(this.fgO);
        } else {
            this.fgN.showToast(r.j.neterror);
        }
        aVar.dismiss();
    }
}
