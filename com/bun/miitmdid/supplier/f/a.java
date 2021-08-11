package com.bun.miitmdid.supplier.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Uri f63622a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-536265474, "Lcom/bun/miitmdid/supplier/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-536265474, "Lcom/bun/miitmdid/supplier/f/a;");
                return;
            }
        }
        f63622a = Uri.parse("content://cn.nubia.identity/identity");
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f63622a);
                    call = acquireUnstableContentProviderClient.call("getAAID", str, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = context.getContentResolver().call(f63622a, "getAAID", str, (Bundle) null);
                }
                if (call.getInt("code", -1) == 0) {
                    String string = call.getString("id");
                    com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                    return string;
                }
                String string2 = call.getString("message");
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean a(Context context) {
        Bundle call;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f63622a);
                    call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = context.getContentResolver().call(f63622a, "isSupport", (String) null, (Bundle) null);
                }
                if (call.getInt("code", -1) == 0) {
                    com.bun.miitmdid.utils.a.a("NubiaLog", "succeed");
                    return call.getBoolean("issupport", true);
                }
                String string = call.getString("message");
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string);
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Bundle call;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f63622a);
                    call = acquireUnstableContentProviderClient.call("getOAID", null, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    call = context.getContentResolver().call(f63622a, "getOAID", (String) null, (Bundle) null);
                }
                if (call.getInt("code", -1) == 0) {
                    String string = call.getString("id");
                    com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                    return string;
                }
                String string2 = call.getString("message");
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(f63622a);
                    bundle = acquireUnstableContentProviderClient.call("getVAID", str, null);
                    if (acquireUnstableContentProviderClient != null) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            acquireUnstableContentProviderClient.close();
                        } else {
                            acquireUnstableContentProviderClient.release();
                        }
                    }
                } else {
                    context.getContentResolver().call(f63622a, "getVAID", str, (Bundle) null);
                    bundle = null;
                }
                if (bundle.getInt("code", -1) == 0) {
                    String string = bundle.getString("id");
                    com.bun.miitmdid.utils.a.a("NubiaLog", "succeed:" + string);
                    return string;
                }
                String string2 = bundle.getString("message");
                com.bun.miitmdid.utils.a.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
