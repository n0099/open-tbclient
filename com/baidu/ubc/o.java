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
    private static volatile IRemoteUBCService hTi;
    private static r hTj = new r();
    private static l hTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l bPN() {
        return hTk;
    }

    public static void a(l lVar) {
        hTk = lVar;
    }

    public static final void onEvent(String str) {
        o(str, "", 0);
    }

    public static final void onEvent(String str, String str2) {
        o(str, str2, 0);
    }

    public static final void i(String str, JSONObject jSONObject) {
        b(str, jSONObject, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        a(str, map, 0);
    }

    public static final void a(String str, Map<String, String> map, int i) {
        hTj.a(str, map, i);
    }

    public static void o(String str, String str2, int i) {
        hTj.o(str, str2, i);
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        hTj.b(str, jSONObject, i);
    }

    public static void R(String str, String str2, String str3) {
        d.bPk().d(str, str2, com.baidu.g.e.xH(str3), 8);
    }

    public static final Flow xD(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return hTj.n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bPO() throws RemoteException {
        if (hTi == null) {
            synchronized (o.class) {
                if (hTi == null) {
                    IBinder m = IPCServiceManager.m("remote_ubc_service", true);
                    if (m == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (m != null) {
                        hTi = IRemoteUBCService.Stub.asInterface(m);
                    }
                }
            }
        }
        return hTi;
    }
}
