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
public class UBC {
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    private static final boolean DEBUG = false;
    public static final int FLAG_DEFAULT_CLOSE = 32;
    public static final int FLAG_DISABLE_REALTIME_UPLOAD = 64;
    public static final int FLAG_DO_NOT_ADD_TIME = 2;
    public static final int FLAG_DO_NOT_USE_CACHE = 1;
    public static final int FLAG_EVENT_FILE = 8;
    public static final int FLAG_SAMPLE = 16;
    public static final int FLAG_UPLOAD_WITHOUT_END = 4;
    public static final int NOVALUE_FOR_KEY_VALUE = -1;
    public static final String TAG = "UBC";
    public static final String UBC_REMOTE_SERVICE_NAME = "remote_ubc_service";
    private static volatile IRemoteUBCService sProxy;
    private static q sUBCManager = new q();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final l getUBCContext() {
        return com.baidu.tieba.aiapps.apps.r.g.aGm();
    }

    public static final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    public static final void onEvent(String str, int i) {
        onEvent(str, "", i);
    }

    public static final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
    }

    public static final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, 0);
    }

    public static final void onEvent(String str, Map<String, String> map, int i) {
        sUBCManager.onEvent(str, map, i);
    }

    public static void onEvent(String str, String str2, int i) {
        sUBCManager.onEvent(str, str2, i);
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        sUBCManager.onEvent(str, jSONObject, i);
    }

    public static void onMutilProcessEvent(String str, String str2, String str3) {
        d.cAc().f(str, str2, com.baidu.f.e.Gf(str3), 8);
    }

    public static final Flow beginFlow(String str) {
        return beginFlow(str, "", 0);
    }

    public static final Flow beginFlow(String str, int i) {
        return beginFlow(str, "", i);
    }

    public static final Flow beginFlow(String str, String str2) {
        return beginFlow(str, str2, 0);
    }

    public static final Flow beginFlow(String str, JSONObject jSONObject) {
        return beginFlow(str, jSONObject, 0);
    }

    public static final Flow beginFlow(String str, Map<String, String> map) {
        return beginFlow(str, map, 0);
    }

    public static final Flow beginFlow(String str, Map<String, String> map, int i) {
        return sUBCManager.beginFlow(str, map, i);
    }

    public static Flow beginFlow(String str, String str2, int i) {
        return sUBCManager.beginFlow(str, str2, i);
    }

    public static Flow beginFlow(String str, JSONObject jSONObject, int i) {
        return sUBCManager.beginFlow(str, jSONObject, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteUBCService getProxy() throws RemoteException {
        if (sProxy == null) {
            synchronized (UBC.class) {
                if (sProxy == null) {
                    IBinder h = IPCServiceManager.h(UBC_REMOTE_SERVICE_NAME, true);
                    if (h == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (h != null) {
                        sProxy = IRemoteUBCService.Stub.asInterface(h);
                    }
                }
            }
        }
        return sProxy;
    }
}
