package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final long b;
    public final String c;
    public final int d;
    public final long e;
    public final int f;
    public final int g;
    public final String h;
    public final int i;
    public final int j;
    public final long k;
    public final List<p87> l;
    public final String m;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o87) {
                o87 o87Var = (o87) obj;
                return Intrinsics.areEqual(this.a, o87Var.a) && this.b == o87Var.b && Intrinsics.areEqual(this.c, o87Var.c) && this.d == o87Var.d && this.e == o87Var.e && this.f == o87Var.f && this.g == o87Var.g && Intrinsics.areEqual(this.h, o87Var.h) && this.i == o87Var.i && this.j == o87Var.j && this.k == o87Var.k && Intrinsics.areEqual(this.l, o87Var.l) && Intrinsics.areEqual(this.m, o87Var.m);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (((((((((((((((((((((((this.a.hashCode() * 31) + c.a(this.b)) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + c.a(this.e)) * 31) + this.f) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i) * 31) + this.j) * 31) + c.a(this.k)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "VoteData(tid=" + this.a + ", fid=" + this.b + ", title=" + this.c + ", optionsCount=" + this.d + ", joinCount=" + this.e + ", voteType=" + this.f + ", isPolled=" + this.g + ", polledValue=" + this.h + ", endTime=" + this.i + ", lastTime=" + this.j + ", totalPoll=" + this.k + ", voteOptionDataList=" + this.l + ", schema=" + this.m + ')';
        }
        return (String) invokeV.objValue;
    }

    public o87(String tid, long j, String title, int i, long j2, int i2, int i3, String polledValue, int i4, int i5, long j3, List<p87> voteOptionDataList, String schema) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tid, Long.valueOf(j), title, Integer.valueOf(i), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), polledValue, Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j3), voteOptionDataList, schema};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tid, "tid");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(polledValue, "polledValue");
        Intrinsics.checkNotNullParameter(voteOptionDataList, "voteOptionDataList");
        Intrinsics.checkNotNullParameter(schema, "schema");
        this.a = tid;
        this.b = j;
        this.c = title;
        this.d = i;
        this.e = j2;
        this.f = i2;
        this.g = i3;
        this.h = polledValue;
        this.i = i4;
        this.j = i5;
        this.k = j3;
        this.l = voteOptionDataList;
        this.m = schema;
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public final long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return invokeV.longValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    public final List<p87> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l;
        }
        return (List) invokeV.objValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }
}
