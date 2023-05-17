package com.bytedance.pangle.plugin;

import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.e.a.e;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
/* loaded from: classes8.dex */
public final class a implements Runnable {
    public final File a;
    public final String b;

    public a(String str, File file) {
        this.a = file;
        this.b = str;
    }

    public final boolean a() {
        e a = com.bytedance.pangle.e.a.d.a(this.a);
        if (a == null) {
            String str = this.b;
            ZeusPluginStateListener.postStateChange(str, 7, " read local file package info failed !!! pluginPkg = " + this.b + " mApkFile.exists = " + this.a.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(a.a);
        if (plugin == null) {
            String str2 = this.b;
            ZeusPluginStateListener.postStateChange(str2, 7, " plugin == null !!! pluginPkg = " + this.b);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + a.a);
            return false;
        }
        boolean install = plugin.install(this.a, a);
        if (install) {
            ZeusPluginStateListener.postStateChange(a.a, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(a.a, 7, "Internal error.");
        }
        return install;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();
    }
}
