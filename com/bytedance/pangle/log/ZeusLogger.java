package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.GlobalParam;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes7.dex */
public class ZeusLogger {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-902906039, "Lcom/bytedance/pangle/log/ZeusLogger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-902906039, "Lcom/bytedance/pangle/log/ZeusLogger;");
        }
    }

    public ZeusLogger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return sDebug;
        }
        return invokeV.booleanValue;
    }

    public static boolean isEnableTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return sEnableTrace;
        }
        return invokeV.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            d(null, str);
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            i(null, str);
        }
    }

    public static String prefixTraceInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (sEnableTrace) {
                return str + getTraceInfo();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65550, null, z) == null) {
            sDebug = z;
        }
    }

    public static void setEnableTrace(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            sEnableTrace = z;
        }
    }

    public static void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            v(null, str);
        }
    }

    public static void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            w(null, str);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            i(str, str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            e(str, str2, null, null);
        }
    }

    public static void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            e(str, str2, str3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[Catch: JSONException -> 0x0043, TryCatch #0 {JSONException -> 0x0043, blocks: (B:12:0x0033, B:14:0x003b, B:18:0x004a, B:20:0x0050, B:21:0x0055, B:17:0x0045), top: B:29:0x0033 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(String str, String str2, String str3, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, str, str2, str3, th) == null) {
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
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) {
            e(str, str2, null, th);
        }
    }

    public static String getTraceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
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
        return (String) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            String prefixTraceInfo = prefixTraceInfo(str2);
            if (sDebug) {
                Log.i(str, prefixTraceInfo);
            } else if (GlobalParam.getInstance().getLogger() != null) {
                GlobalParam.getInstance().getLogger().i(str, prefixTraceInfo);
            }
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            String prefixTraceInfo = prefixTraceInfo(str2);
            if (sDebug) {
                Log.v(str, prefixTraceInfo);
            } else if (GlobalParam.getInstance().getLogger() != null) {
                GlobalParam.getInstance().getLogger().v(str, prefixTraceInfo);
            }
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, str, str2) == null) {
            String prefixTraceInfo = prefixTraceInfo(str2);
            if (sDebug) {
                Log.w(str, prefixTraceInfo);
            } else if (GlobalParam.getInstance().getLogger() != null) {
                GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, str, str2, th) == null) {
            String prefixTraceInfo = prefixTraceInfo(str2);
            if (sDebug) {
                Log.w(str, prefixTraceInfo, th);
            } else if (GlobalParam.getInstance().getLogger() != null) {
                GlobalParam.getInstance().getLogger().w(str, prefixTraceInfo, th);
            }
        }
    }
}
