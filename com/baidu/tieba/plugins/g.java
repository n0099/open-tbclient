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
class g extends h {
    final /* synthetic */ PluginDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PluginDetailActivity pluginDetailActivity, PluginDetailActivity pluginDetailActivity2) {
        super(pluginDetailActivity, null, null);
        this.a = pluginDetailActivity2;
    }

    @Override // com.baidu.tieba.plugins.h, android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        PluginsConfig.PluginConfig pluginConfig;
        DownloadData a;
        Messenger messenger;
        super.onServiceConnected(componentName, iBinder);
        Message obtain = Message.obtain((Handler) null, 3);
        Bundle bundle = new Bundle();
        PluginDetailActivity pluginDetailActivity = this.a;
        pluginConfig = this.a.l;
        a = pluginDetailActivity.a(pluginConfig);
        bundle.putSerializable("download_data", a);
        if (obtain != null) {
            obtain.setData(bundle);
            try {
                messenger = this.a.h;
                messenger.send(obtain);
            } catch (RemoteException e) {
            }
        }
    }
}
