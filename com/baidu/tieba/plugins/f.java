package com.baidu.tieba.plugins;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* loaded from: classes.dex */
class f implements ServiceConnection {
    final /* synthetic */ PluginDetailActivity b;

    private f(PluginDetailActivity pluginDetailActivity) {
        this.b = pluginDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(PluginDetailActivity pluginDetailActivity, f fVar) {
        this(pluginDetailActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(PluginDetailActivity pluginDetailActivity, f fVar, f fVar2) {
        this(pluginDetailActivity);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
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
        PluginDetailActivity.a(this.b, (Messenger) null);
    }
}
