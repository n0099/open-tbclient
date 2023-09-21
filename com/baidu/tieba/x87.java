package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.w87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class x87 implements w87, k97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final String g;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final List<ea7> k;
    public int l;
    public boolean m;
    public boolean n;
    public String o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public x87(String url, String str, int i, int i2, int i3, boolean z, String str2, Integer num, Integer num2, Integer num3) {
        this(url, str, i, i2, i3, z, str2, num, num2, num3, null, 1024, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str2, num, num2, num3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue(), (String) objArr2[6], (Integer) objArr2[7], (Integer) objArr2[8], (Integer) objArr2[9], (List) objArr2[10], ((Integer) objArr2[11]).intValue(), (DefaultConstructorMarker) objArr2[12]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof x87) {
                x87 x87Var = (x87) obj;
                return Intrinsics.areEqual(this.a, x87Var.a) && Intrinsics.areEqual(this.b, x87Var.b) && this.c == x87Var.c && this.d == x87Var.d && this.e == x87Var.e && this.f == x87Var.f && Intrinsics.areEqual(this.g, x87Var.g) && Intrinsics.areEqual(this.h, x87Var.h) && Intrinsics.areEqual(this.i, x87Var.i) && Intrinsics.areEqual(this.j, x87Var.j) && Intrinsics.areEqual(this.k, x87Var.k);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
            boolean z = this.f;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode2 + i) * 31;
            String str2 = this.g;
            int hashCode3 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num = this.h;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.i;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.j;
            return ((hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31) + this.k.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return "EnableDegradeIconData(url=" + this.a + ", schema=" + this.b + ", width=" + this.c + ", height=" + this.d + ", priority=" + this.e + ", degradeEnable=" + this.f + ", degradeUrl=" + this.g + ", degradeWidth=" + this.h + ", degradeHeight=" + this.i + ", degradePriority=" + this.j + ", clickStatDataList=" + this.k + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public x87(String url, String str, int i, int i2, int i3, boolean z, String str2, Integer num, Integer num2, Integer num3, List<ea7> clickStatDataList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {url, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), str2, num, num2, num3, clickStatDataList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(clickStatDataList, "clickStatDataList");
        this.a = url;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = z;
        this.g = str2;
        this.h = num;
        this.i = num2;
        this.j = num3;
        this.k = clickStatDataList;
        this.l = i3;
        this.m = z;
        this.n = true;
        reset();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ x87(String str, String str2, int i, int i2, int i3, boolean z, String str3, Integer num, Integer num2, Integer num3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, i3, z, str3, num, num2, num3, r12);
        List list2;
        if ((i4 & 1024) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
    }

    @Override // com.baidu.tieba.w87
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w87
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w87
    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w87
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Integer num = this.j;
            Intrinsics.checkNotNull(num);
            this.l = num.intValue();
            this.m = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k97
    public List<ea7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final Integer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.i;
        }
        return (Integer) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w87
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public final Integer h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (Integer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w87
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n = false;
        }
    }

    public final int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.w87
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.l = this.e;
            this.m = this.f;
            this.n = true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(w87 w87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, w87Var)) == null) {
            return w87.a.a(this, w87Var);
        }
        return invokeL.intValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.w87
    public int l(int i, int i2) {
        InterceptResult invokeII;
        float f;
        int i3;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            if (this.f) {
                if (this.m) {
                    f = i2 * this.c;
                    i3 = this.d;
                } else {
                    float f2 = i2;
                    Intrinsics.checkNotNull(this.h);
                    f = f2 * num.intValue();
                    Integer num2 = this.i;
                    Intrinsics.checkNotNull(num2);
                    i3 = num2.intValue();
                }
            } else {
                f = i2 * this.c;
                i3 = this.d;
            }
            return (int) (f / i3);
        }
        return invokeII.intValue;
    }
}
