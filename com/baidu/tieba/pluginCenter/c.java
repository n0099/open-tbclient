package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eZr;
    private final /* synthetic */ PluginConfigWrapper eZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eZr = pluginCenterActivity;
        this.eZs = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.gD()) {
            PluginPackageManager iB = PluginPackageManager.iB();
            PluginConfigWrapper pluginConfigWrapper = this.eZs;
            eVar = this.eZr.xI;
            iB.a(pluginConfigWrapper, eVar);
            this.eZs.setDownLoadPercent(0.0f);
            this.eZs.setDownLoadStatus(3);
            bVar = this.eZr.eZp;
            bVar.D(this.eZs);
        } else {
            this.eZr.showToast(r.j.neterror);
        }
        aVar.dismiss();
    }
}
