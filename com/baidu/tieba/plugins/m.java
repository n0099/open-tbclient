package com.baidu.tieba.plugins;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class m implements ServiceConnection {
    final /* synthetic */ PluginDownloadActivity a;

    private m(PluginDownloadActivity pluginDownloadActivity) {
        this.a = pluginDownloadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(PluginDownloadActivity pluginDownloadActivity, m mVar) {
        this(pluginDownloadActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(PluginDownloadActivity pluginDownloadActivity, m mVar, m mVar2) {
        this(pluginDownloadActivity);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BdLog.d("onServiceConnected");
        PluginDownloadActivity.a(this.a, new Messenger(iBinder));
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = PluginDownloadActivity.d(this.a);
                PluginDownloadActivity.e(this.a).send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        BdLog.d("onServiceDisconnected");
        PluginDownloadActivity.a(this.a, (Messenger) null);
    }
}
