package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.bytedance.pangle.GlobalParam;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
public class ZeusLogger {
    public static final String TAG = "Zeus";
    public static final String TAG_ACTIVITY = "Zeus/activity";
    public static final String TAG_DOWNLOAD = "Zeus/download";
    public static final String TAG_INIT = "Zeus/init";
    public static final String TAG_INSTALL = "Zeus/install";
    public static final String TAG_LOAD = "Zeus/load";
    public static final String TAG_PAM = "Zeus/pam";
    public static final String TAG_PPM = "Zeus/ppm";
    public static final String TAG_PROVIDER = "Zeus/provider";
    public static final String TAG_RECEIVER = "Zeus/receiver";
    public static final String TAG_REPORTER = "Zeus/reporter";
    public static final String TAG_RESOURCES = "Zeus/resources";
    public static final String TAG_SERVER = "Zeus/server";
    public static final String TAG_SERVICE = "Zeus/service";
    public static final String TAG_SO = "Zeus/so";
    public static boolean sDebug = true;
    public static boolean sEnableTrace;

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    public static void d(String str) {
        d(null, str);
    }

    public static void i(String str) {
        i(null, str);
    }

    public static String prefixTraceInfo(String str) {
        if (sEnableTrace) {
            return str + getTraceInfo();
        }
        return str;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void e(String str, String str2) {
        e(str, str2, null, null);
    }

    public static void i(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.i(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, prefixTraceInfo);
        }
    }

    public static void v(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.v(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, prefixTraceInfo);
        }
    }

    public static void w(String str, String str2) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo);
        }
    }

    public static void e(String str, String str2, String str3) {
        e(str, str2, str3, null);
    }

    public static void w(String str, String str2, Throwable th) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, prefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[Catch: JSONException -> 0x003f, TryCatch #0 {JSONException -> 0x003f, blocks: (B:10:0x002f, B:12:0x0037, B:16:0x0046, B:18:0x004c, B:19:0x0051, B:15:0x0041), top: B:24:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(String str, String str2, String str3, Throwable th) {
        String prefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.e(str, prefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().e(str, prefixTraceInfo, th);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (str != null) {
            try {
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (str.startsWith(TAG)) {
                jSONObject.putOpt("log_tag", c.a(str));
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.putOpt("plugin_package_name", str3);
                }
                jSONObject2.putOpt("message", c.a(prefixTraceInfo));
                jSONObject2.putOpt("throwable", c.a(th));
                c.a(com.bytedance.pangle.b.b.i, jSONObject, null, jSONObject2);
            }
        }
        jSONObject.putOpt("log_tag", ImageViewerConfig.FROM_OTHER);
        if (!TextUtils.isEmpty(str3)) {
        }
        jSONObject2.putOpt("message", c.a(prefixTraceInfo));
        jSONObject2.putOpt("throwable", c.a(th));
        c.a(com.bytedance.pangle.b.b.i, jSONObject, null, jSONObject2);
    }

    public static void e(String str, String str2, Throwable th) {
        e(str, str2, null, th);
    }

    public static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i = 1;
            while (true) {
                if (i >= stackTrace.length) {
                    break;
                } else if (!TextUtils.equals(stackTrace[i].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i];
                    break;
                } else {
                    i++;
                }
            }
            if (stackTraceElement == null) {
                return "\t\t[No Trace Info]";
            }
            return "\t\t[" + stackTraceElement.toString() + PreferencesUtil.RIGHT_MOUNT;
        } catch (Exception e) {
            e.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }
}
