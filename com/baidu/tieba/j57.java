package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.data.CardDataKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j57<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<t87<? extends Object>> a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final Function2<Context, j57<?>, Unit> f;
    public Object g;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j57) {
                j57 j57Var = (j57) obj;
                return Intrinsics.areEqual(this.a, j57Var.a) && Intrinsics.areEqual(this.b, j57Var.b) && this.c == j57Var.c && Intrinsics.areEqual(this.d, j57Var.d) && Intrinsics.areEqual(this.e, j57Var.e) && Intrinsics.areEqual(this.f, j57Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            boolean z = this.c;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            String str = this.d;
            int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.e;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return "CardData(dataList=" + this.a + ", schema=" + this.b + ", isGreyMode=" + this.c + ", threadId=" + this.d + ", userId=" + this.e + ", onCardClick=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public j57(List<t87<? extends Object>> dataList, String schema, boolean z, String str, String str2, Function2<? super Context, ? super j57<?>, Unit> onCardClick) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataList, schema, Boolean.valueOf(z), str, str2, onCardClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(onCardClick, "onCardClick");
        this.a = dataList;
        this.b = schema;
        this.c = z;
        this.d = str;
        this.e = str2;
        this.f = onCardClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ j57(List list, String str, boolean z, String str2, String str3, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, r3, str2, str3, (i & 32) != 0 ? CardDataKt.a : function2);
        boolean z2;
        if ((i & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
    }

    public final List<t87<? extends Object>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public final Object b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.objValue;
    }

    public final Function2<Context, j57<?>, Unit> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Function2) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void h(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            this.g = obj;
        }
    }
}
