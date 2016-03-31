package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity dRD;
    private final /* synthetic */ PluginConfigWrapper dRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.dRD = pluginCenterActivity;
        this.dRE = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.jw()) {
            PluginPackageManager ls = PluginPackageManager.ls();
            PluginConfigWrapper pluginConfigWrapper = this.dRE;
            eVar = this.dRD.EA;
            ls.a(pluginConfigWrapper, eVar);
            this.dRE.setDownLoadPercent(0.0f);
            this.dRE.setDownLoadStatus(3);
            bVar = this.dRD.dRB;
            bVar.A(this.dRE);
        } else {
            this.dRD.showToast(t.j.neterror);
        }
        aVar.dismiss();
    }
}
