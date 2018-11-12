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
    private static volatile IRemoteUBCService hUT;
    private static r hUU = new r();
    private static l hUV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l bPm() {
        return hUV;
    }

    public static void a(l lVar) {
        hUV = lVar;
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
        hUU.a(str, map, i);
    }

    public static void o(String str, String str2, int i) {
        hUU.o(str, str2, i);
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        hUU.b(str, jSONObject, i);
    }

    public static void R(String str, String str2, String str3) {
        d.bOJ().d(str, str2, com.baidu.g.e.xM(str3), 8);
    }

    public static final Flow xI(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return hUU.n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bPn() throws RemoteException {
        if (hUT == null) {
            synchronized (o.class) {
                if (hUT == null) {
                    IBinder m = IPCServiceManager.m("remote_ubc_service", true);
                    if (m == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (m != null) {
                        hUT = IRemoteUBCService.Stub.asInterface(m);
                    }
                }
            }
        }
        return hUT;
    }
}
