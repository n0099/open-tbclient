package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eWK;
    private final /* synthetic */ PluginConfigWrapper eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eWK = pluginCenterActivity;
        this.eWL = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.gD()) {
            PluginPackageManager iB = PluginPackageManager.iB();
            PluginConfigWrapper pluginConfigWrapper = this.eWL;
            eVar = this.eWK.xI;
            iB.a(pluginConfigWrapper, eVar);
            this.eWL.setDownLoadPercent(0.0f);
            this.eWL.setDownLoadStatus(3);
            bVar = this.eWK.eWI;
            bVar.D(this.eWL);
        } else {
            this.eWK.showToast(t.j.neterror);
        }
        aVar.dismiss();
    }
}
