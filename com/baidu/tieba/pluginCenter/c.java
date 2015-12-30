package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity djc;
    private final /* synthetic */ PluginConfigWrapper djd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.djc = pluginCenterActivity;
        this.djd = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.g.b bVar;
        if (com.baidu.adp.lib.util.k.jh()) {
            PluginPackageManager ls = PluginPackageManager.ls();
            PluginConfigWrapper pluginConfigWrapper = this.djd;
            eVar = this.djc.Eh;
            ls.a(pluginConfigWrapper, eVar);
            this.djd.setDownLoadPercent(0.0f);
            this.djd.setDownLoadStatus(3);
            bVar = this.djc.dja;
            bVar.A(this.djd);
        } else {
            this.djc.showToast(n.j.neterror);
        }
        aVar.dismiss();
    }
}
