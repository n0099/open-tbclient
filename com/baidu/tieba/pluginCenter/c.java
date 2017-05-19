package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements a.b {
    private final /* synthetic */ PluginConfigWrapper eTA;
    final /* synthetic */ PluginCenterActivity eTz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.eTz = pluginCenterActivity;
        this.eTA = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hB()) {
            PluginPackageManager jx = PluginPackageManager.jx();
            PluginConfigWrapper pluginConfigWrapper = this.eTA;
            eVar = this.eTz.Er;
            jx.a(pluginConfigWrapper, eVar);
            this.eTA.setDownLoadPercent(0.0f);
            this.eTA.setDownLoadStatus(3);
            bVar = this.eTz.eTx;
            bVar.D(this.eTA);
        } else {
            this.eTz.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
