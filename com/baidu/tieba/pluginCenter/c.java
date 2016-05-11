package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity dUv;
    private final /* synthetic */ PluginConfigWrapper dUw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.dUv = pluginCenterActivity;
        this.dUw = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.fH()) {
            PluginPackageManager hF = PluginPackageManager.hF();
            PluginConfigWrapper pluginConfigWrapper = this.dUw;
            eVar = this.dUv.uT;
            hF.a(pluginConfigWrapper, eVar);
            this.dUw.setDownLoadPercent(0.0f);
            this.dUw.setDownLoadStatus(3);
            bVar = this.dUv.dUt;
            bVar.A((com.baidu.tbadk.mvc.g.b) this.dUw);
        } else {
            this.dUv.showToast(t.j.neterror);
        }
        aVar.dismiss();
    }
}
