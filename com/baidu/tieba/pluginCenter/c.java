package com.baidu.tieba.pluginCenter;

import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class c implements a.b {
    final /* synthetic */ PluginCenterActivity fmK;
    private final /* synthetic */ PluginConfigWrapper fmL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenterActivity pluginCenterActivity, PluginConfigWrapper pluginConfigWrapper) {
        this.fmK = pluginCenterActivity;
        this.fmL = pluginConfigWrapper;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.adp.plugin.packageManager.e eVar;
        com.baidu.tbadk.mvc.f.b bVar;
        if (com.baidu.adp.lib.util.k.hA()) {
            PluginPackageManager jw = PluginPackageManager.jw();
            PluginConfigWrapper pluginConfigWrapper = this.fmL;
            eVar = this.fmK.Er;
            jw.a(pluginConfigWrapper, eVar);
            this.fmL.setDownLoadPercent(0.0f);
            this.fmL.setDownLoadStatus(3);
            bVar = this.fmK.fmI;
            bVar.D(this.fmL);
        } else {
            this.fmK.showToast(w.l.neterror);
        }
        aVar.dismiss();
    }
}
