package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, u> f65605a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f65606b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1410335415, "Lcom/bytedance/sdk/component/utils/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1410335415, "Lcom/bytedance/sdk/component/utils/u;");
                return;
            }
        }
        f65605a = new HashMap();
    }

    public u(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (context != null) {
            this.f65606b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static u a(String str, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, context)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_sp";
            }
            u uVar = f65605a.get(str);
            if (uVar == null) {
                u uVar2 = new u(str, context);
                f65605a.put(str, uVar2);
                return uVar2;
            }
            return uVar;
        }
        return (u) invokeLL.objValue;
    }

    public String b(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, str2)) == null) {
            try {
                return this.f65606b.getString(str, str2);
            } catch (Throwable unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public int b(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            try {
                return this.f65606b.getInt(str, i2);
            } catch (Throwable unused) {
                return i2;
            }
        }
        return invokeLI.intValue;
    }

    public long b(@NonNull String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j2)) == null) {
            try {
                return this.f65606b.getLong(str, j2);
            } catch (Throwable unused) {
                return j2;
            }
        }
        return invokeLJ.longValue;
    }

    public float b(@NonNull String str, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048583, this, str, f2)) == null) {
            try {
                return this.f65606b.getFloat(str, f2);
            } catch (Throwable unused) {
                return f2;
            }
        }
        return invokeLF.floatValue;
    }

    public void a(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            try {
                this.f65606b.edit().putString(str, str2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public boolean b(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, str, z)) == null) {
            try {
                return this.f65606b.getBoolean(str, z);
            } catch (Throwable unused) {
                return z;
            }
        }
        return invokeLZ.booleanValue;
    }

    public String a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return b(str, "");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public Set<String> b(@NonNull String str, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, set)) == null) {
            try {
                return this.f65606b.getStringSet(str, set);
            } catch (Throwable unused) {
                return set;
            }
        }
        return (Set) invokeLL.objValue;
    }

    public void a(@NonNull String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            try {
                this.f65606b.edit().putInt(str, i2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            try {
                this.f65606b.edit().remove(str).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(@NonNull String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j2) == null) {
            try {
                this.f65606b.edit().putLong(str, j2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(@NonNull String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f2) == null) {
            try {
                this.f65606b.edit().putFloat(str, f2).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, str, z) == null) {
            try {
                this.f65606b.edit().putBoolean(str, z).apply();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(@NonNull String str, @NonNull Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, set) == null) {
            try {
                this.f65606b.edit().putStringSet(str, set).apply();
            } catch (Throwable unused) {
            }
        }
    }
}
