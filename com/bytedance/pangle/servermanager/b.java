package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.c;
import com.bytedance.pangle.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class b {
    public static final Object a = new Object();
    public static final Object b = new Object();
    public static final Object c = new Object();
    public static final Map<String, Boolean> d = new ConcurrentHashMap();
    public static final Map<String, d> e = new ConcurrentHashMap();
    public static c f;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0081 A[Catch: RemoteException -> 0x009a, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:15:0x0056, B:30:0x0090, B:32:0x0095, B:20:0x0077, B:23:0x0081), top: B:41:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095 A[Catch: RemoteException -> 0x009a, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x009a, blocks: (B:15:0x0056, B:30:0x0090, B:32:0x0095, B:20:0x0077, B:23:0x0081), top: B:41:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IInterface a(String str, final String str2) {
        ProviderInfo providerInfo;
        final IBinder iBinder;
        int hashCode;
        if (Zeus.hasInit()) {
            if (Zeus.getServerManagerHashMap().get(str2) != null) {
                Bundle call = Zeus.getAppApplication().getContentResolver().call(Uri.parse("content://" + providerInfo.authority), AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
                if (call != null) {
                    call.setClassLoader(AbsServerManager.class.getClassLoader());
                    a aVar = (a) call.getParcelable(AbsServerManager.BUNDLE_BINDER);
                    if (aVar != null) {
                        iBinder = aVar.a;
                        if (iBinder != null && iBinder.isBinderAlive()) {
                            try {
                                char c2 = 0;
                                iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.b.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public final void binderDied() {
                                        b.d.put(str2, Boolean.FALSE);
                                        ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                                        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinder);
                                        for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                            Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                            while (it.hasNext()) {
                                                serviceConnection.onServiceDisconnected(it.next());
                                            }
                                        }
                                    }
                                }, 0);
                                d.put(str2, Boolean.TRUE);
                                hashCode = str.hashCode();
                                if (hashCode == -807062458) {
                                    if (hashCode == 1984153269 && str.equals("service")) {
                                        c2 = 1;
                                        if (c2 == 0) {
                                            if (c2 == 1) {
                                                return d.a.a(iBinder);
                                            }
                                        } else {
                                            return c.a.a(iBinder);
                                        }
                                    }
                                    c2 = 65535;
                                    if (c2 == 0) {
                                    }
                                } else {
                                    if (str.equals("package")) {
                                        if (c2 == 0) {
                                        }
                                    }
                                    c2 = 65535;
                                    if (c2 == 0) {
                                    }
                                }
                            } catch (RemoteException e2) {
                                ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e2);
                            }
                        }
                        return null;
                    }
                }
                iBinder = null;
                if (iBinder != null) {
                    char c22 = 0;
                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.b.1
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            b.d.put(str2, Boolean.FALSE);
                            ZeusLogger.e(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                            HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinder);
                            for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                while (it.hasNext()) {
                                    serviceConnection.onServiceDisconnected(it.next());
                                }
                            }
                        }
                    }, 0);
                    d.put(str2, Boolean.TRUE);
                    hashCode = str.hashCode();
                    if (hashCode == -807062458) {
                    }
                }
                return null;
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
    }

    public static c a() {
        Boolean bool = d.get("main");
        if (bool == null || !bool.booleanValue()) {
            f = null;
        }
        if (f == null) {
            synchronized (c) {
                c cVar = (c) a("package", "main");
                if (cVar == null) {
                    ZeusLogger.e(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f = cVar;
            }
        }
        return f;
    }

    public static d a(String str) {
        Boolean bool = d.get(str);
        if (bool == null || !bool.booleanValue()) {
            e.remove(str);
        }
        if (e.get(str) == null) {
            synchronized (b) {
                d dVar = (d) a("service", str);
                if (dVar == null) {
                    ZeusLogger.e(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                e.put(str, dVar);
            }
        }
        return e.get(str);
    }
}
