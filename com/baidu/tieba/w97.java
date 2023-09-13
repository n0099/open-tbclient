package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class w97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final Map<String, String> b;
    public final Map<String, String> c;
    public String d;
    public v97 e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w97() {
        this(null, null, null, null, null, 31, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (Map) objArr[1], (Map) objArr[2], (String) objArr[3], (v97) objArr[4], ((Integer) objArr[5]).intValue(), (DefaultConstructorMarker) objArr[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof w97) {
                w97 w97Var = (w97) obj;
                return Intrinsics.areEqual(this.a, w97Var.a) && Intrinsics.areEqual(this.b, w97Var.b) && Intrinsics.areEqual(this.c, w97Var.c) && Intrinsics.areEqual(this.d, w97Var.d) && Intrinsics.areEqual(this.e, w97Var.e);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "StatData(key=" + this.a + ", customMap=" + this.b + ", passthroughMap=" + this.c + ", positionName=" + this.d + ", callback=" + this.e + ')';
        }
        return (String) invokeV.objValue;
    }

    public w97(String key, Map<String, String> customMap, Map<String, String> passthroughMap, String positionName, v97 callback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {key, customMap, passthroughMap, positionName, callback};
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
        Intrinsics.checkNotNullParameter(customMap, "customMap");
        Intrinsics.checkNotNullParameter(passthroughMap, "passthroughMap");
        Intrinsics.checkNotNullParameter(positionName, "positionName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.a = key;
        this.b = customMap;
        this.c = passthroughMap;
        this.d = positionName;
        this.e = callback;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ w97(String str, Map map, Map map2, String str2, v97 v97Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r10, (i & 2) != 0 ? new HashMap() : map, (i & 4) != 0 ? new HashMap() : map2, (i & 8) == 0 ? str2 : "", (i & 16) != 0 ? x97.a() : v97Var);
        String str3;
        if ((i & 1) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
    }

    public final v97 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (v97) invokeV.objValue;
    }

    public final Map<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (Map) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (Map) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final void f(v97 v97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, v97Var) == null) {
            Intrinsics.checkNotNullParameter(v97Var, "<set-?>");
            this.e = v97Var;
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
        }
    }
}
