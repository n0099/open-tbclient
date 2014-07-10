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
class q extends k {
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, PluginDownloadActivity pluginDownloadActivity) {
        super(pluginDownloadActivity, null);
        this.b = pVar;
    }

    @Override // com.baidu.tieba.plugins.k, android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        m mVar;
        PluginDownloadActivity pluginDownloadActivity;
        m mVar2;
        PluginDownloadActivity pluginDownloadActivity2;
        PluginsConfig.PluginConfig pluginConfig;
        DownloadData a;
        m mVar3;
        PluginDownloadActivity pluginDownloadActivity3;
        Messenger messenger;
        super.onServiceConnected(componentName, iBinder);
        Message obtain = Message.obtain((Handler) null, 3);
        Bundle bundle = new Bundle();
        mVar = this.b.a;
        pluginDownloadActivity = mVar.a;
        mVar2 = this.b.a;
        pluginDownloadActivity2 = mVar2.a;
        pluginConfig = pluginDownloadActivity2.b;
        a = pluginDownloadActivity.a(pluginConfig);
        bundle.putSerializable("download_data", a);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                mVar3 = this.b.a;
                pluginDownloadActivity3 = mVar3.a;
                messenger = pluginDownloadActivity3.c;
                messenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }
}
