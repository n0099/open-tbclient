package com.baidu.tieba;

import java.io.PrintWriter;
import java.io.StringWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements com.baidu.tbplugin.c {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.tbplugin.c
    public final void a() {
        p pVar;
        com.baidu.tbplugin.k.a();
        com.baidu.tbplugin.k.a("com.baidu.tbadk.plugins.BdBrowserDelegate");
        com.baidu.tbplugin.k.a();
        com.baidu.tbplugin.k.a("com.baidu.tbadk.plugins.BdSapiCoreLightDelegate");
        com.baidu.tbplugin.k.a();
        com.baidu.tbplugin.k.a("com.baidu.tbadk.plugins.BatSdkDelegate");
        com.baidu.tbplugin.k.a();
        com.baidu.tbplugin.k.a("com.baidu.tbadk.plugins.BdSocialShareSdkDelegate");
        com.baidu.tbplugin.k.a();
        com.baidu.tbplugin.k.a("com.baidu.tbadk.plugins.MotuPlugin");
        com.baidu.tbplugin.k.a().h();
        try {
            pVar = this.a.a;
            pVar.b.post(new s(this));
        } catch (Throwable th) {
            com.baidu.adp.lib.util.f.b("PluginManager: Sapi plugin init failed");
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            com.baidu.adp.lib.util.f.b(stringWriter.toString());
        }
    }
}
