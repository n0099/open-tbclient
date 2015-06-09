package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PluginCenterActivity bXi;
    private final /* synthetic */ PluginConfigWrapper bXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.bXi = pluginCenterActivity;
        this.bXj = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.i iVar;
        com.baidu.tbadk.mvc.j.b bVar;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            PluginPackageManager lM = PluginPackageManager.lM();
            PluginConfigWrapper pluginConfigWrapper = this.bXj;
            iVar = this.bXi.DE;
            lM.a(pluginConfigWrapper, iVar);
            this.bXj.setDownLoadPercent(0.0f);
            this.bXj.setDownLoadStatus(3);
            bVar = this.bXi.bXg;
            bVar.y(this.bXj);
        } else {
            this.bXi.showToast(t.neterror);
        }
        aVar.dismiss();
    }
}
