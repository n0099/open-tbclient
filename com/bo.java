package com;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.sina.sso.RemoteSSO;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements ServiceConnection {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar) {
        this.a = bnVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnection serviceConnection;
        RemoteSSO a = RemoteSSO.Stub.a(iBinder);
        try {
            this.a.f = a.a();
            this.a.g = a.b();
            if (!this.a.g()) {
                this.a.f();
            }
        } catch (RemoteException e) {
            this.a.f();
        } finally {
            Context applicationContext = this.a.a.getApplicationContext();
            serviceConnection = this.a.h;
            applicationContext.unbindService(serviceConnection);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        SessionManager.Session session = SessionManager.getInstance(this.a.a).get(MediaType.SINAWEIBO.toString());
        if (session == null || session.isExpired()) {
            this.a.f();
        }
    }
}
