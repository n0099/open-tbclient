package com.baidu.tieba.plugins;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.tbplugin.PluginsConfig;
/* loaded from: classes.dex */
class s extends m {
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, PluginDownloadActivity pluginDownloadActivity) {
        super(pluginDownloadActivity, null);
        this.b = rVar;
    }

    @Override // com.baidu.tieba.plugins.m, android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        o oVar;
        PluginDownloadActivity pluginDownloadActivity;
        o oVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginsConfig.PluginConfig pluginConfig;
        DownloadData a;
        o oVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        Messenger messenger;
        super.onServiceConnected(componentName, iBinder);
        Message obtain = Message.obtain((Handler) null, 3);
        Bundle bundle = new Bundle();
        oVar = this.b.a;
        pluginDownloadActivity = oVar.a;
        oVar2 = this.b.a;
        pluginDownloadActivity2 = oVar2.a;
        pluginConfig = pluginDownloadActivity2.b;
        a = pluginDownloadActivity.a(pluginConfig);
        bundle.putSerializable("download_data", a);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                oVar3 = this.b.a;
                pluginDownloadActivity3 = oVar3.a;
                messenger = pluginDownloadActivity3.c;
                messenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }
}
