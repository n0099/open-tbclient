package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public abstract class zh9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948360094, "Lcom/baidu/tieba/zh9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948360094, "Lcom/baidu/tieba/zh9;");
        }
    }

    public zh9(String key) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {key};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(key, "key");
        this.a = "default";
        this.a = "key_prefix_" + key;
    }

    public final T a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            Intrinsics.checkNotNullParameter(t, "default");
            return (T) b(t);
        }
        return (T) invokeL.objValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.a = str;
        }
    }

    public final Object b(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            if (t instanceof String) {
                String string = SharedPrefHelper.getInstance().getString(this.a, (String) t);
                Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(key, default as String)");
                return string;
            } else if (t instanceof Integer) {
                return Integer.valueOf(SharedPrefHelper.getInstance().getInt(this.a, ((Integer) t).intValue()));
            } else {
                if (t instanceof Long) {
                    return Long.valueOf(SharedPrefHelper.getInstance().getLong(this.a, ((Long) t).longValue()));
                }
                if (t instanceof Boolean) {
                    return Boolean.valueOf(SharedPrefHelper.getInstance().getBoolean(this.a, ((Boolean) t).booleanValue()));
                }
                if (t instanceof Float) {
                    return Float.valueOf(SharedPrefHelper.getInstance().getFloat(this.a, ((Float) t).floatValue()));
                }
                return t;
            }
        }
        return invokeL.objValue;
    }

    public final T d(T value) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, value)) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof String) {
                SharedPrefHelper.getInstance().putString(this.a, (String) value);
            } else if (value instanceof Integer) {
                SharedPrefHelper.getInstance().putInt(this.a, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                SharedPrefHelper.getInstance().putLong(this.a, ((Long) value).longValue());
            } else if (value instanceof Boolean) {
                SharedPrefHelper.getInstance().putBoolean(this.a, ((Boolean) value).booleanValue());
            } else if (value instanceof Float) {
                SharedPrefHelper.getInstance().putFloat(this.a, ((Float) value).floatValue());
            }
            return value;
        }
        return (T) invokeL.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
