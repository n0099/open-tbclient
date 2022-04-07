package com.baidu.webkit.internal;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.b;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class CfgFileUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ALT_SERVICE = "alt_service";
    public static final String KEY_BACK_DNS_TIME = "back_dns_time";
    public static final String KEY_CLOUDSETTINGS_LASTMODIFY = "cloudsettings_lastmodify";
    public static final String KEY_CRONET_AB_STAT = "croent_ab_stat";
    public static final String KEY_ENGINE_BROWSING_COUNT = "engineBrowsingCount";
    public static final String KEY_ENGINE_CLOUDSETTINGS_DATA = "engineCloudSettingsData";
    public static final String KEY_ENGINE_CLOUDSETTINGS_TIME = "engineCloudSettingsTime";
    public static final String KEY_ENGINE_STAT_DATA = "engineStatData";
    public static final String KEY_ENGINE_STAT_TIME = "engineStatTime";
    public static final String KEY_ENGINE_VERSION = "engineVersion";
    public static final String KEY_FAKE_BAIDU_MODEL = "fakeBaiduModel";
    public static final String KEY_FAKE_BAIDU_MODEL_TIME = "fakeBaiduModelTime";
    public static final String KEY_FAKE_BAIDU_WHITE_LIST = "fakeBaiduWhiteList";
    public static final String KEY_FAKE_BAIDU_WHITE_LIST_TIME = "fakeBaiduWhiteListTime";
    public static final String KEY_HTTPDNS_AB_STAT = "httpdns_ab_stat";
    public static final String KEY_HTTP_DNS_CACHE = "httpdnscache_v2";
    public static final String KEY_HTTP_DNS_IPV6_ENV = "http_dns_ipv6_env";
    public static final String KEY_HTTP_DNS_NATIVE_CACHE = "http_dns_native_cache";
    public static final String KEY_HTTP_DNS_PERSISTENCE_CACHE = "http_dns_persistence_cache";
    public static final String KEY_HTTP_DNS_PREFETCH_LIST = "dns_prefetch_list";
    public static final String KEY_HTTP_WORMHOLE_IPLIST = "wormholeIpList";
    public static final String KEY_KEEP_ALIVE_TIME = "keep_alive_time";
    public static final String KEY_ML_MODEL = "MLModel";
    public static final String KEY_ML_MODEL_TIME = "MLModelTime";
    public static final String KEY_NATIVE_HTTPDNS_ENABLED = "native_httpdns_enabled";
    public static final String KEY_PAC_DATA = "pac_data";
    public static final String KEY_PAC_FREE_FLOW_DATA = "pac_free_flow_data";
    public static final String KEY_PAC_FREE_FLOW_LASTMODIFY = "pac_free_flow_lastmodify";
    public static final String KEY_PAC_LASTMODIFY = "pac_lastmodify";
    public static final String KEY_SOCKET_GROUP_NUMBER = "socket_group_number";
    public static final String KEY_URL_CHECK = "urlCheck";
    public static final String KEY_VIDEO_PROXY_DATA = "videoproxy_data";
    public static final String KEY_VIDEO_PROXY_LASTMODIFY = "videoproxy_lastmodify";
    public static final String TAG = "CfgFileUtils";
    public static SharedPreferences mPref;
    public transient /* synthetic */ FieldHolder $fh;

    public CfgFileUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static SharedPreferences gerPrefs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (CfgFileUtils.class) {
                if (mPref == null) {
                    b.b();
                    mPref = WebViewFactory.getContext().getSharedPreferences(GlobalConstants.SDK_CFG_RELATIVE_PATH_V2, 0);
                }
            }
            return mPref;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static String get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? gerPrefs().getString(str, str2) : (String) invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String get(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        ?? r6;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65539, null, str, str2, z)) != null) {
            return (String) invokeLLZ.objValue;
        }
        if (!z) {
            return get(str, str2);
        }
        b.b();
        try {
            try {
                fileInputStream = new FileInputStream(getFilePath(str));
                try {
                    byte[] bArr = new byte[10240];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    byteArrayOutputStream.flush();
                    String str3 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str3;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable unused) {
                r6 = z;
                if (r6 != 0) {
                    try {
                        r6.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable unused2) {
            r6 = 0;
            if (r6 != 0) {
            }
            return null;
        }
    }

    public static boolean get(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z)) == null) ? gerPrefs().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static String getFilePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return WebViewFactory.getContext().getFilesDir().getAbsolutePath() + File.separator + str + ".cfg";
        }
        return (String) invokeL.objValue;
    }

    public static boolean isExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            b.b();
            File file = new File(getFilePath(str));
            if (file.isFile() && file.exists()) {
                Log.d(TAG, getFilePath(str) + " is Exist");
                return true;
            }
            Log.d(TAG, getFilePath(str) + " is not Exist");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void save(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, bArr) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(getFilePath(str), false);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static void set(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            SharedPreferences.Editor edit = gerPrefs().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void set(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65545, null, str, z) == null) {
            SharedPreferences.Editor edit = gerPrefs().edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }
}
