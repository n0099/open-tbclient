package com.bytedance.pangle.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.b.b;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final OkHttpClient f54527b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f54528b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f54529c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f54530d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f54531e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f54532f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f54533g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ a[] f54534i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f54535h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2091424205, "Lcom/bytedance/pangle/download/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2091424205, "Lcom/bytedance/pangle/download/d$a;");
                    return;
                }
            }
            a = new a(RomUtils.UNKNOWN, 0, -1);
            f54528b = new a(PolyActivity.NONE_PANEL_TYPE, 1, 0);
            f54529c = new a("MOBILE", 2, 1);
            f54530d = new a("MOBILE_2G", 3, 2);
            f54531e = new a("MOBILE_3G", 4, 3);
            f54532f = new a(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 5, 4);
            a aVar = new a("MOBILE_4G", 6, 5);
            f54533g = aVar;
            f54534i = new a[]{a, f54528b, f54529c, f54530d, f54531e, f54532f, aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f54535h = i3;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f54534i.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1012231024, "Lcom/bytedance/pangle/download/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1012231024, "Lcom/bytedance/pangle/download/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54527b = new OkHttpClient.Builder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).writeTimeout(5L, TimeUnit.SECONDS).build();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (d.class) {
                    if (a == null) {
                        a = new d();
                    }
                }
            }
            return a;
        }
        return (d) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission"})
    public static a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return a.f54532f;
                    }
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return a.f54531e;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return a.f54529c;
                            case 13:
                                return a.f54533g;
                        }
                    }
                    return a.f54529c;
                }
                return a.f54528b;
            } catch (Throwable unused) {
                return a.f54529c;
            }
        }
        return (a) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            a b2 = b(context);
            return b2 == a.f54532f ? "wifi" : b2 == a.f54530d ? "2g" : b2 == a.f54531e ? "3g" : b2 == a.f54533g ? "4g" : b2 == a.f54529c ? "mobile" : "";
        }
        return (String) invokeL.objValue;
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        com.bytedance.pangle.h hVar;
        Response execute;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "executePost, url: ".concat(String.valueOf(str)));
            ZeusLogger.i(ZeusLogger.TAG_DOWNLOAD, "executePost, body: ".concat(String.valueOf(str2)));
            RequestBody create = RequestBody.create(MediaType.parse(str3), str2);
            Request.Builder url = new Request.Builder().url(str);
            com.bytedance.pangle.util.b.a(url, str2, com.bytedance.pangle.i.a().f54604b.getAppKey(), com.bytedance.pangle.i.a().f54604b.getAppSecretKey());
            url.addHeader("Content-Type", str3);
            try {
                execute = this.f54527b.newCall(url.post(create).build()).execute();
            } catch (Throwable th) {
                String concat = "Request plugin failed! ".concat(String.valueOf(th));
                hVar = new com.bytedance.pangle.h(concat, th);
                ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, concat);
                th.printStackTrace();
            }
            if (execute.isSuccessful() && execute.body() != null) {
                String string = execute.body().string();
                if (TextUtils.isEmpty(string)) {
                    a(b.a.f54472c, str2, "", null);
                } else {
                    a(b.a.a, str2, string, null);
                }
                return string;
            }
            String format = String.format("Request plugin failed! code = %s, message = %s", Integer.valueOf(execute.code()), execute.message());
            hVar = new com.bytedance.pangle.h(format, execute.code());
            ZeusLogger.e(ZeusLogger.TAG_DOWNLOAD, format);
            a(b.a.f54471b, str2, "", hVar);
            return "";
        }
        return (String) invokeLLL.objValue;
    }

    public static boolean a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void a(int i2, String str, String str2, @Nullable com.bytedance.pangle.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), str, str2, hVar}) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.putOpt("status_code", com.bytedance.pangle.log.d.a(Integer.valueOf(i2)));
                jSONObject2.putOpt("throwable", com.bytedance.pangle.log.d.a((Throwable) hVar));
                jSONObject2.putOpt("timestamp", com.bytedance.pangle.log.d.a(Long.valueOf(System.currentTimeMillis())));
                jSONObject2.putOpt("request", com.bytedance.pangle.log.d.a(str));
                jSONObject2.putOpt("response", com.bytedance.pangle.log.d.a(str2));
                jSONObject.putOpt("error_code", com.bytedance.pangle.log.d.a(Integer.valueOf(hVar != null ? hVar.a : -1)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.bytedance.pangle.b.b.a().a(com.bytedance.pangle.b.b.f54462b, jSONObject, null, jSONObject2);
        }
    }
}
