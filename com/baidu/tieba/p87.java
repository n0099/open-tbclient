package com.baidu.tieba;

import android.graphics.Paint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n87;
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
/* loaded from: classes7.dex */
public final class p87 implements n87, b97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final k87 b;
    public final String c;
    public final int d;
    public final boolean e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public final List<u97> i;
    public int j;
    public boolean k;
    public boolean l;
    public String m;
    public int n;
    public String o;
    public String p;
    public k87 q;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public p87(String text, k87 k87Var, String str, int i, boolean z, Integer num, String str2, Integer num2) {
        this(text, k87Var, str, i, z, num, str2, num2, null, 256, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {text, k87Var, str, Integer.valueOf(i), Boolean.valueOf(z), num, str2, num2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (k87) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue(), (Integer) objArr2[5], (String) objArr2[6], (Integer) objArr2[7], (List) objArr2[8], ((Integer) objArr2[9]).intValue(), (DefaultConstructorMarker) objArr2[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof p87) {
                p87 p87Var = (p87) obj;
                return Intrinsics.areEqual(this.a, p87Var.a) && Intrinsics.areEqual(this.b, p87Var.b) && Intrinsics.areEqual(this.c, p87Var.c) && this.d == p87Var.d && this.e == p87Var.e && Intrinsics.areEqual(this.f, p87Var.f) && Intrinsics.areEqual(this.g, p87Var.g) && Intrinsics.areEqual(this.h, p87Var.h) && Intrinsics.areEqual(this.i, p87Var.i);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            k87 k87Var = this.b;
            int hashCode2 = (hashCode + (k87Var == null ? 0 : k87Var.hashCode())) * 31;
            String str = this.c;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode3 + i) * 31;
            Integer num = this.f;
            int hashCode4 = (i2 + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.g;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num2 = this.h;
            return ((hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.i.hashCode();
        }
        return invokeV.intValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "EnableDegradeTextData(text=" + this.a + ", textColor=" + this.b + ", schema=" + this.c + ", priority=" + this.d + ", degradeEnable=" + this.e + ", degradeLength=" + this.f + ", degradeSuffix=" + this.g + ", degradePriority=" + this.h + ", clickStatDataList=" + this.i + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public p87(String text, k87 k87Var, String str, int i, boolean z, Integer num, String str2, Integer num2, List<u97> clickStatDataList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {text, k87Var, str, Integer.valueOf(i), Boolean.valueOf(z), num, str2, num2, clickStatDataList};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(clickStatDataList, "clickStatDataList");
        this.a = text;
        this.b = k87Var;
        this.c = str;
        this.d = i;
        this.e = z;
        this.f = num;
        this.g = str2;
        this.h = num2;
        this.i = clickStatDataList;
        this.j = i;
        this.k = z;
        this.l = true;
        this.m = text;
        this.n = text.length();
        reset();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ p87(String str, k87 k87Var, String str2, int i, boolean z, Integer num, String str3, Integer num2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, k87Var, str2, i, z, num, str3, num2, r10);
        List list2;
        if ((i2 & 256) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
    }

    @Override // com.baidu.tieba.n87
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n87
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n87
    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b97
    public List<u97> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final k87 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.q;
        }
        return (k87) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n87
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public final k87 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (k87) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n87
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.l = false;
        }
    }

    @Override // com.baidu.tieba.n87
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.j = this.d;
            this.k = this.e;
            this.l = true;
            String str = this.a;
            this.m = str;
            this.n = str.length();
        }
    }

    @Override // com.baidu.tieba.n87
    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.n--;
            StringBuilder sb = new StringBuilder();
            String substring = this.a.substring(0, this.n);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(this.g);
            this.m = sb.toString();
            int i = this.n;
            Integer num = this.f;
            Intrinsics.checkNotNull(num);
            if (i > num.intValue()) {
                return false;
            }
            Integer num2 = this.h;
            Intrinsics.checkNotNull(num2);
            this.j = num2.intValue();
            this.k = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(n87 n87Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n87Var)) == null) {
            return n87.a.a(this, n87Var);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.n87
    public int o(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i, i2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(i);
            return (int) paint.measureText(this.m);
        }
        return invokeII.intValue;
    }
}
