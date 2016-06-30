package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eDR;
    private final /* synthetic */ PluginConfigWrapper eDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eDR = pluginCenterActivity;
        this.eDS = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.fI()) {
            PluginPackageManager hH = PluginPackageManager.hH();
            PluginConfigWrapper pluginConfigWrapper = this.eDS;
            eVar = this.eDR.uV;
            hH.a(pluginConfigWrapper, eVar);
            this.eDS.setDownLoadPercent(0.0f);
            this.eDS.setDownLoadStatus(3);
            bVar = this.eDR.eDP;
            bVar.A((com.baidu.tbadk.mvc.g.b) this.eDS);
        } else {
            this.eDR.showToast(u.j.neterror);
        }
        aVar.dismiss();
    }
}
