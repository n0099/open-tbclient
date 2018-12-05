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
    private static volatile IRemoteUBCService icd;
    private static r ice = new r();
    private static l icf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l bRs() {
        return icf;
    }

    public static void a(l lVar) {
        icf = lVar;
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
        ice.a(str, map, i);
    }

    public static void o(String str, String str2, int i) {
        ice.o(str, str2, i);
    }

    public static void b(String str, JSONObject jSONObject, int i) {
        ice.b(str, jSONObject, i);
    }

    public static void S(String str, String str2, String str3) {
        d.bQP().d(str, str2, com.baidu.g.e.yp(str3), 8);
    }

    public static final Flow yl(String str) {
        return n(str, "", 0);
    }

    public static Flow n(String str, String str2, int i) {
        return ice.n(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService bRt() throws RemoteException {
        if (icd == null) {
            synchronized (o.class) {
                if (icd == null) {
                    IBinder n = IPCServiceManager.n("remote_ubc_service", true);
                    if (n == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (n != null) {
                        icd = IRemoteUBCService.Stub.asInterface(n);
                    }
                }
            }
        }
        return icd;
    }
}
