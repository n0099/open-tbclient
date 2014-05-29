package com.baidu.tieba.plugins;

import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.tbplugin.PluginReloadReceiver;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class e implements Runnable {
    final /* synthetic */ PluginDetailActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PluginDetailActivity pluginDetailActivity, int i, String str) {
        this.a = pluginDetailActivity;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b == 0) {
            this.a.showToast(this.a.getString(y.plugin_installation_finished));
            com.baidu.tbadk.tbplugin.m.a().q();
            if (TbadkApplication.m252getInst().isMainProcess(true)) {
                this.a.sendBroadcast(new Intent(PluginReloadReceiver.ACTION_PLUGIN_RELOAD));
            }
            this.a.a();
            return;
        }
        this.a.showToast(String.valueOf(this.a.getString(y.plugin_installation_failed)) + this.c);
        this.a.a();
    }
}
