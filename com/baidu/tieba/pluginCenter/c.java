package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eTD;
    private final /* synthetic */ PluginConfigWrapper eTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eTD = pluginCenterActivity;
        this.eTE = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.gB()) {
            PluginPackageManager iz = PluginPackageManager.iz();
            PluginConfigWrapper pluginConfigWrapper = this.eTE;
            eVar = this.eTD.xz;
            iz.a(pluginConfigWrapper, eVar);
            this.eTE.setDownLoadPercent(0.0f);
            this.eTE.setDownLoadStatus(3);
            bVar = this.eTD.eTB;
            bVar.D(this.eTE);
        } else {
            this.eTD.showToast(r.l.neterror);
        }
        aVar.dismiss();
    }
}
