package com.baidu.tieba;

import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l67;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o67 implements l67, e77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final e67 b;
    public final String c;
    public final int d;
    public final boolean e;
    public final int f;
    public final String g;
    public final int h;
    public final List<e87> i;
    public final Map<String, String> j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public int o;
    public String p;
    public String q;
    public e67 r;
    public final int s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public o67(String text, e67 e67Var, String str, int i, boolean z, int i2, String str2, int i3) {
        this(text, e67Var, str, i, z, i2, str2, i3, null, null, 768, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {text, e67Var, str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str2, Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (e67) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Boolean) objArr2[4]).booleanValue(), ((Integer) objArr2[5]).intValue(), (String) objArr2[6], ((Integer) objArr2[7]).intValue(), (List) objArr2[8], (Map) objArr2[9], ((Integer) objArr2[10]).intValue(), (DefaultConstructorMarker) objArr2[11]);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o67) {
                o67 o67Var = (o67) obj;
                return Intrinsics.areEqual(this.a, o67Var.a) && Intrinsics.areEqual(this.b, o67Var.b) && Intrinsics.areEqual(this.c, o67Var.c) && this.d == o67Var.d && this.e == o67Var.e && this.f == o67Var.f && Intrinsics.areEqual(this.g, o67Var.g) && this.h == o67Var.h && Intrinsics.areEqual(this.i, o67Var.i) && Intrinsics.areEqual(this.j, o67Var.j);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            e67 e67Var = this.b;
            int hashCode2 = (hashCode + (e67Var == null ? 0 : e67Var.hashCode())) * 31;
            String str = this.c;
            int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (((hashCode3 + i) * 31) + this.f) * 31;
            String str2 = this.g;
            return ((((((i2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.h) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }
        return invokeV.intValue;
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return "EnableDegradeTextData(text=" + this.a + ", textColor=" + this.b + ", schema=" + this.c + ", priority=" + this.d + ", degradeEnable=" + this.e + ", degradeLength=" + this.f + ", degradeSuffix=" + this.g + ", degradePriority=" + this.h + ", clickStatDataList=" + this.i + ", logInfoMap=" + this.j + ')';
        }
        return (String) invokeV.objValue;
    }

    @JvmOverloads
    public o67(String text, e67 e67Var, String str, int i, boolean z, int i2, String str2, int i3, List<e87> clickStatDataList, Map<String, String> logInfoMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {text, e67Var, str, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str2, Integer.valueOf(i3), clickStatDataList, logInfoMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(clickStatDataList, "clickStatDataList");
        Intrinsics.checkNotNullParameter(logInfoMap, "logInfoMap");
        this.a = text;
        this.b = e67Var;
        this.c = str;
        this.d = i;
        this.e = z;
        this.f = i2;
        this.g = str2;
        this.h = i3;
        this.i = clickStatDataList;
        this.j = logInfoMap;
        this.k = i;
        this.l = z;
        this.m = true;
        this.n = text;
        this.o = text.length();
        this.s = this.a.length();
        reset();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ o67(String str, e67 e67Var, String str2, int i, boolean z, int i2, String str3, int i3, List list, Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, e67Var, str2, i, z, i2, str3, i3, r11, r12);
        List list2;
        Map map2;
        if ((i4 & 256) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        if ((i4 & 512) != 0) {
            map2 = MapsKt__MapsKt.emptyMap();
        } else {
            map2 = map;
        }
    }

    @Override // com.baidu.tieba.l67
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l67
    public Map<String, String> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.j;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l67
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l67
    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e77
    public List<e87> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public final e67 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.r;
        }
        return (e67) invokeV.objValue;
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l67
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public final e67 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return (e67) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l67
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.m = false;
        }
    }

    @Override // com.baidu.tieba.l67
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.k = this.d;
            this.l = this.e;
            this.m = true;
            String str = this.a;
            this.n = str;
            this.o = str.length();
        }
    }

    @Override // com.baidu.tieba.l67
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.s <= this.f + 1) {
                this.k = this.h;
                this.l = false;
                return true;
            }
            this.o--;
            StringBuilder sb = new StringBuilder();
            String substring = this.a.substring(0, this.o);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(this.g);
            this.n = sb.toString();
            if (this.o > this.f) {
                return false;
            }
            this.k = this.h;
            this.l = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: b */
    public int compareTo(l67 l67Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, l67Var)) == null) {
            return l67.a.a(this, l67Var);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.l67
    public int k(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(i);
            return (int) paint.measureText(this.n);
        }
        return invokeII.intValue;
    }
}
