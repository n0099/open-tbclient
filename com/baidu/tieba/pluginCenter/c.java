package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity ePA;
    private final /* synthetic */ PluginConfigWrapper ePB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.ePA = pluginCenterActivity;
        this.ePB = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.fH()) {
            PluginPackageManager hG = PluginPackageManager.hG();
            PluginConfigWrapper pluginConfigWrapper = this.ePB;
            eVar = this.ePA.vw;
            hG.a(pluginConfigWrapper, eVar);
            this.ePB.setDownLoadPercent(0.0f);
            this.ePB.setDownLoadStatus(3);
            bVar = this.ePA.ePy;
            bVar.D(this.ePB);
        } else {
            this.ePA.showToast(u.j.neterror);
        }
        aVar.dismiss();
    }
}
