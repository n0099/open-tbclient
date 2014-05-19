package com.baidu.tieba.plugins;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class h implements ServiceConnection {
    final /* synthetic */ PluginDetailActivity b;

    private h(PluginDetailActivity pluginDetailActivity) {
        this.b = pluginDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(PluginDetailActivity pluginDetailActivity, h hVar) {
        this(pluginDetailActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(PluginDetailActivity pluginDetailActivity, h hVar, h hVar2) {
        this(pluginDetailActivity);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BdLog.d("onServiceConnected");
        PluginDetailActivity.a(this.b, new Messenger(iBinder));
        Message obtain = Message.obtain(null, 1, null);
        if (obtain != null) {
            try {
                obtain.replyTo = PluginDetailActivity.e(this.b);
                PluginDetailActivity.f(this.b).send(obtain);
            } catch (RemoteException e) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        BdLog.d("onServiceDisconnected");
        PluginDetailActivity.a(this.b, (Messenger) null);
    }
}
