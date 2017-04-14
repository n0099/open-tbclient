package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity eVi;
    private final /* synthetic */ PluginConfigWrapper eVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eVi = pluginCenterActivity;
        this.eVj = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hA()) {
            PluginPackageManager jx = PluginPackageManager.jx();
            PluginConfigWrapper pluginConfigWrapper = this.eVj;
            eVar = this.eVi.Eo;
            jx.a(pluginConfigWrapper, eVar);
            this.eVj.setDownLoadPercent(0.0f);
            this.eVj.setDownLoadStatus(3);
            bVar = this.eVi.eVg;
            bVar.D(this.eVj);
        } else {
            this.eVi.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
