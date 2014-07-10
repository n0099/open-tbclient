package com.baidu.tieba.plugins;

import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.tbplugin.PluginReloadReceiver;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ PluginDownloadActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PluginDownloadActivity pluginDownloadActivity, int i) {
        this.a = pluginDownloadActivity;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        m mVar2;
        if (this.b == 0) {
            this.a.showToast(this.a.getString(y.plugin_installation_finished));
            com.baidu.tbadk.tbplugin.m.a().q();
            if (TbadkApplication.m252getInst().isMainProcess(true)) {
                this.a.sendBroadcast(new Intent(PluginReloadReceiver.ACTION_PLUGIN_RELOAD));
            }
            this.a.setResult(-1);
            mVar2 = this.a.a;
            mVar2.dismiss();
            return;
        }
        this.a.setResult(0);
        this.a.showToast(this.a.getString(y.plugin_installation_failed));
        mVar = this.a.a;
        mVar.dismiss();
    }
}
