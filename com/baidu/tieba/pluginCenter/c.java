package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eXj;
    private final /* synthetic */ PluginConfigWrapper eXk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eXj = pluginCenterActivity;
        this.eXk = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hv()) {
            PluginPackageManager jt = PluginPackageManager.jt();
            PluginConfigWrapper pluginConfigWrapper = this.eXk;
            eVar = this.eXj.EN;
            jt.a(pluginConfigWrapper, eVar);
            this.eXk.setDownLoadPercent(0.0f);
            this.eXk.setDownLoadStatus(3);
            bVar = this.eXj.eXh;
            bVar.D(this.eXk);
        } else {
            this.eXj.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
