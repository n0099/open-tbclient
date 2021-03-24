package com.baidu.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.IRemoteUBCService;
import d.b.i0.x2.r;
import d.b.k0.d;
import d.b.k0.d0;
import d.b.k0.q;
import d.b.l0.a;
import java.util.Map;
import org.json.JSONObject;
@Autowired
@Deprecated
/* loaded from: classes5.dex */
public class UBC {
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    public static final boolean DEBUG = AppConfig.isDebug();
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
    public static volatile IRemoteUBCService sProxy;

    public static final Flow beginFlow(String str) {
        return beginFlow(str, "", 0);
    }

    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static IRemoteUBCService getProxy() throws RemoteException {
        if (sProxy == null) {
            synchronized (UBC.class) {
                if (sProxy == null) {
                    IBinder f2 = IPCServiceManager.f(UBC_REMOTE_SERVICE_NAME, true);
                    if (f2 == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (f2 != null) {
                        sProxy = IRemoteUBCService.Stub.asInterface(f2);
                    }
                }
            }
        }
        return sProxy;
    }

    @Inject
    public static final q getUBCContext() {
        return r.a();
    }

    public static String getUploadType(String str) {
        d0 d0Var = (d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        return d0Var != null ? d0Var.getUploadType(str) : "";
    }

    public static final void onEvent(String str) {
        onEvent(str, "", 0);
    }

    public static void onMutilProcessEvent(String str, String str2, String str3) {
        String a2 = a.a(str3);
        if (DEBUG) {
            Log.d(TAG, "on onMutilProcessEvent id:" + str + " value:" + str2 + " name: " + a2);
        }
        d.q().t(str, str2, a2, 8);
    }

    public static void uploadLocalDatas() {
        d0 d0Var = (d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (d0Var != null) {
            d0Var.uploadLocalDatas();
        }
    }

    public static final Flow beginFlow(String str, int i) {
        return beginFlow(str, "", i);
    }

    public static final void onEvent(String str, int i) {
        onEvent(str, "", i);
    }

    public static final Flow beginFlow(String str, String str2) {
        return beginFlow(str, str2, 0);
    }

    public static final void onEvent(String str, String str2) {
        onEvent(str, str2, 0);
    }

    public static final Flow beginFlow(String str, JSONObject jSONObject) {
        return beginFlow(str, jSONObject, 0);
    }

    public static final void onEvent(String str, JSONObject jSONObject) {
        onEvent(str, jSONObject, 0);
    }

    public static final Flow beginFlow(String str, Map<String, String> map) {
        return beginFlow(str, map, 0);
    }

    public static final void onEvent(String str, Map<String, String> map) {
        onEvent(str, map, 0);
    }

    public static final Flow beginFlow(String str, Map<String, String> map, int i) {
        return ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, map, i);
    }

    public static final void onEvent(String str, Map<String, String> map, int i) {
        ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, map, i);
    }

    public static Flow beginFlow(String str, String str2, int i) {
        return ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, str2, i);
    }

    public static void onEvent(String str, String str2, int i) {
        ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2, i);
    }

    public static Flow beginFlow(String str, JSONObject jSONObject, int i) {
        return ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(str, jSONObject, i);
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        ((d0) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject, i);
    }
}
