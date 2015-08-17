package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity cob;
    private final /* synthetic */ PluginConfigWrapper coc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.cob = pluginCenterActivity;
        this.coc = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.d dVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.jf()) {
            PluginPackageManager lT = PluginPackageManager.lT();
            PluginConfigWrapper pluginConfigWrapper = this.coc;
            dVar = this.cob.DA;
            lT.a(pluginConfigWrapper, dVar);
            this.coc.setDownLoadPercent(0.0f);
            this.coc.setDownLoadStatus(3);
            bVar = this.cob.cnZ;
            bVar.z(this.coc);
        } else {
            this.cob.showToast(i.C0057i.neterror);
        }
        aVar.dismiss();
    }
}
