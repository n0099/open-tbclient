package com.bun.miitmdid.supplier.h.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f63634a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63635b;

    /* renamed from: c  reason: collision with root package name */
    public static b f63636c;

    /* renamed from: d  reason: collision with root package name */
    public static a f63637d;

    /* renamed from: e  reason: collision with root package name */
    public static c f63638e;

    /* renamed from: f  reason: collision with root package name */
    public static c f63639f;

    /* renamed from: g  reason: collision with root package name */
    public static c f63640g;

    /* renamed from: h  reason: collision with root package name */
    public static Object f63641h;

    /* renamed from: i  reason: collision with root package name */
    public static HandlerThread f63642i;

    /* renamed from: j  reason: collision with root package name */
    public static Handler f63643j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(102204873, "Lcom/bun/miitmdid/supplier/h/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(102204873, "Lcom/bun/miitmdid/supplier/h/a/b;");
                return;
            }
        }
        f63641h = new Object();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f63636c == null) {
                f63636c = new b();
                f63634a = context;
                f();
                f63637d = new a(f63634a);
                c();
            }
            return f63636c;
        }
        return (b) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            try {
                try {
                    Class<?> cls = Class.forName("android.os.SystemProperties");
                    return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return str2;
                }
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, int i2, String str) {
        ContentResolver contentResolver;
        Uri parse;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2, str) == null) {
            if (i2 == 0) {
                f63638e = new c(f63636c, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f63638e);
                return;
            }
            if (i2 == 1) {
                f63639f = new c(f63636c, 1, str);
                contentResolver = context.getContentResolver();
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                cVar = f63639f;
            } else if (i2 != 2) {
                return;
            } else {
                f63640g = new c(f63636c, 2, str);
                contentResolver = context.getContentResolver();
                parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                cVar = f63640g;
            }
            contentResolver.registerContentObserver(parse, false, cVar);
        }
    }

    private void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, str) == null) {
            Message obtainMessage = f63643j.obtainMessage();
            obtainMessage.what = 11;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f63643j.sendMessage(obtainMessage);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f63635b = "1".equals(a("persist.sys.identifierid.supported", "0"));
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
            f63642i = handlerThread;
            handlerThread.start();
            f63643j = new Handler(f63642i.getLooper()) { // from class: com.bun.miitmdid.supplier.h.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        if (message.what != 11) {
                            com.bun.miitmdid.utils.a.b("VMS_IDLG_SDK_Client", "message type valid");
                            return;
                        }
                        try {
                            String unused = b.k = b.f63637d.a(message.getData().getInt("type"), message.getData().getString("appid"));
                        } catch (Exception e2) {
                            String unused2 = b.k = "";
                            com.bun.miitmdid.utils.a.a("VMS_IDLG_SDK_Client", "exception", e2);
                        }
                        synchronized (b.f63641h) {
                            b.f63641h.notify();
                        }
                    }
                }
            };
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (a()) {
                String str2 = m;
                if (str2 != null) {
                    return str2;
                }
                a(1, str);
                if (f63639f == null && m != null) {
                    a(f63634a, 1, str);
                }
                return m;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void a(int i2, String str) {
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            synchronized (f63641h) {
                b(i2, str);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    f63641h.wait(2000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    if (i2 == 0) {
                        l = k;
                    } else if (i2 != 1) {
                        if (i2 == 2) {
                            if (k != null) {
                                n = k;
                            } else {
                                str2 = "VMS_IDLG_SDK_Client";
                                str3 = "get aaid failed";
                            }
                        }
                    } else if (k != null) {
                        m = k;
                    } else {
                        str2 = "VMS_IDLG_SDK_Client";
                        str3 = "get vaid failed";
                    }
                    k = null;
                } else {
                    str2 = "VMS_IDLG_SDK_Client";
                    str3 = "query timeout";
                }
                com.bun.miitmdid.utils.a.b(str2, str3);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? f63635b : invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (a()) {
                String str = l;
                if (str != null) {
                    return str;
                }
                a(0, (String) null);
                if (f63638e == null) {
                    a(f63634a, 0, null);
                }
                return l;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (a()) {
                String str2 = n;
                if (str2 != null) {
                    return str2;
                }
                a(2, str);
                if (f63640g == null && n != null) {
                    a(f63634a, 2, str);
                }
                return n;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
