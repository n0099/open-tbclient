package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity fcu;
    private final /* synthetic */ PluginConfigWrapper fcv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.fcu = pluginCenterActivity;
        this.fcv = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hB()) {
            PluginPackageManager jx = PluginPackageManager.jx();
            PluginConfigWrapper pluginConfigWrapper = this.fcv;
            eVar = this.fcu.Er;
            jx.a(pluginConfigWrapper, eVar);
            this.fcv.setDownLoadPercent(0.0f);
            this.fcv.setDownLoadStatus(3);
            bVar = this.fcu.fcs;
            bVar.D(this.fcv);
        } else {
            this.fcu.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
