package com.baidu.ubc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.IRemoteUBCService;
import java.util.Map;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes6.dex */
public class UBC {
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    private static final boolean DEBUG = AppConfig.isDebug();
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

    public static final q getUBCContext() {
        return com.baidu.tieba.q.r.dKy();
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
        ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).onEvent(str, map, i);
    }

    public static void onEvent(String str, String str2, int i) {
        ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).onEvent(str, str2, i);
    }

    public static void onEvent(String str, JSONObject jSONObject, int i) {
        ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).onEvent(str, jSONObject, i);
    }

    public static void onMutilProcessEvent(String str, String str2, String str3) {
        String XO = com.baidu.m.a.XO(str3);
        if (DEBUG) {
            Log.d(TAG, "on onMutilProcessEvent id:" + str + " value:" + str2 + " name: " + XO);
        }
        d.ehJ().n(str, str2, XO, 8);
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
        return ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).beginFlow(str, map, i);
    }

    public static Flow beginFlow(String str, String str2, int i) {
        return ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).beginFlow(str, str2, i);
    }

    public static Flow beginFlow(String str, JSONObject jSONObject, int i) {
        return ((af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE)).beginFlow(str, jSONObject, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void uploadLocalDatas() {
        af afVar = (af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE);
        if (afVar != null) {
            afVar.uploadLocalDatas();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getUploadType(String str) {
        af afVar = (af) com.baidu.pyramid.runtime.service.c.a(af.SERVICE_REFERENCE);
        return afVar != null ? afVar.getUploadType(str) : "";
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
                    IBinder J = IPCServiceManager.J(UBC_REMOTE_SERVICE_NAME, true);
                    if (J == null) {
                        throw new RemoteException("UBC get remote service empty !");
                    }
                    if (J != null) {
                        sProxy = IRemoteUBCService.Stub.asInterface(J);
                    }
                }
            }
        }
        return sProxy;
    }
}
