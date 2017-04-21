package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    private final /* synthetic */ PluginConfigWrapper eXA;
    final /* synthetic */ PluginCenterActivity eXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eXz = pluginCenterActivity;
        this.eXA = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hB()) {
            PluginPackageManager jy = PluginPackageManager.jy();
            PluginConfigWrapper pluginConfigWrapper = this.eXA;
            eVar = this.eXz.Er;
            jy.a(pluginConfigWrapper, eVar);
            this.eXA.setDownLoadPercent(0.0f);
            this.eXA.setDownLoadStatus(3);
            bVar = this.eXz.eXx;
            bVar.D(this.eXA);
        } else {
            this.eXz.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
