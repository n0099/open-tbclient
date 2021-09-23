package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.q.n;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f66222a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66223b;

    public i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66223b = context;
        this.f66222a = TextUtils.isEmpty(str) ? "" : str;
    }

    @Nullable
    private Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            Context context = this.f66223b;
            return context == null ? o.a() : context;
        }
        return (Context) invokeV.objValue;
    }

    private String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return this.f66222a + "_adslot";
        }
        return (String) invokeV.objValue;
    }

    private String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.f66222a + "_adslot_preload";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    private SharedPreferences f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            try {
                if (b() != null) {
                    return b().getSharedPreferences(str, 0);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (SharedPreferences) invokeL.objValue;
    }

    private String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.f66222a + "_cache_" + str;
        }
        return (String) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", (String) null);
                }
                return f(g(str)).getString("material_data", null);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public AdSlot e(String str) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    string = com.bytedance.sdk.openadsdk.multipro.d.a.b(c(), str, (String) null);
                } else {
                    string = f(c()).getString(str, null);
                }
                return n.a(string);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (AdSlot) invokeL.objValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            long j2 = 0;
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    j2 = com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
                } else {
                    j2 = f(g(str)).getLong("create_time", 0L);
                }
            } catch (Throwable unused) {
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
                }
                return f(g(str)).getBoolean("has_played", true);
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
                } else {
                    f(g(str)).edit().clear().apply();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", Boolean.FALSE);
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
                    return;
                }
                f(g(str)).edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, adSlot) == null) || adSlot == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                String a2 = n.a(adSlot);
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(d(), "preload_data", a2);
                } else {
                    f(d()).edit().putString("preload_data", a2).apply();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adSlot) == null) || adSlot == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                String a2 = n.a(adSlot);
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(c(), adSlot.getCodeId(), a2);
                } else {
                    f(c()).edit().putString(adSlot.getCodeId(), a2).apply();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public AdSlot a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    str = com.bytedance.sdk.openadsdk.multipro.d.a.b(d(), "preload_data", (String) null);
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(d());
                } else {
                    SharedPreferences f2 = f(d());
                    String string = f2.getString("preload_data", null);
                    f2.edit().clear().apply();
                    str = string;
                }
                return n.a(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (AdSlot) invokeV.objValue;
    }
}
