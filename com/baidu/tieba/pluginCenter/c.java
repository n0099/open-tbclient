package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eKf;
    private final /* synthetic */ PluginConfigWrapper eKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eKf = pluginCenterActivity;
        this.eKg = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.gD()) {
            PluginPackageManager iB = PluginPackageManager.iB();
            PluginConfigWrapper pluginConfigWrapper = this.eKg;
            eVar = this.eKf.xI;
            iB.a(pluginConfigWrapper, eVar);
            this.eKg.setDownLoadPercent(0.0f);
            this.eKg.setDownLoadStatus(3);
            bVar = this.eKf.eKd;
            bVar.D(this.eKg);
        } else {
            this.eKf.showToast(r.j.neterror);
        }
        aVar.dismiss();
    }
}
