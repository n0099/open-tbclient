package com.baidu.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.ubc.IRemoteUBCService;
import java.util.Map;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes2.dex */
public class o {
    private static l igA;
    private static volatile IRemoteUBCService igy;
    private static r igz = new r();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l bSQ() {
        return igA;
    }

    public static void a(l lVar) {
        igA = lVar;
    }

    public static final void onEvent(String str) {
        p(str, "", 0);
    }

    public static final void onEvent(String str, String str2) {
        p(str, str2, 0);
    }

    public static final void j(String str, JSONObject jSONObject) {
        b(str, jSONObject, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        a(str, map, 0);
    }

    public static final void a(String str, Map<String, String> map, int i) {
        igz.a(str, map, i);
    }

    public static void p(String str, String str2, int i) {
        igz.p(str, str2, i);
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        igz.b(str, jSONObject, i);
    }

    public static void S(String str, String str2, String str3) {
        d.bSn().d(str, str2, com.baidu.g.e.yI(str3), 8);
    }

    public static final Flow yE(String str) {
        return o(str, "", 0);
    }

    public static Flow o(String str, String str2, int i) {
        return igz.o(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bSR() throws RemoteException {
        if (igy == null) {
            synchronized (o.class) {
                if (igy == null) {
                    IBinder n = IPCServiceManager.n("remote_ubc_service", true);
                    if (n == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (n != null) {
                        igy = IRemoteUBCService.Stub.asInterface(n);
                    }
                }
            }
        }
        return igy;
    }
}
