package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PluginCenterActivity bXh;
    private final /* synthetic */ PluginConfigWrapper bXi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.bXh = pluginCenterActivity;
        this.bXi = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.i iVar;
        com.baidu.tbadk.mvc.j.b bVar;
        if (com.baidu.adp.lib.util.n.isNetOk()) {
            PluginPackageManager lM = PluginPackageManager.lM();
            PluginConfigWrapper pluginConfigWrapper = this.bXi;
            iVar = this.bXh.DE;
            lM.a(pluginConfigWrapper, iVar);
            this.bXi.setDownLoadPercent(0.0f);
            this.bXi.setDownLoadStatus(3);
            bVar = this.bXh.bXf;
            bVar.y(this.bXi);
        } else {
            this.bXh.showToast(t.neterror);
        }
        aVar.dismiss();
    }
}
