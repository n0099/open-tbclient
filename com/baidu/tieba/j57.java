package com.baidu.tieba;

import android.graphics.Paint;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h57;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j57 implements h57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final f57 b;
    public final String c;
    public final int d;
    public final boolean e;
    public final Integer f;
    public final String g;
    public final Integer h;
    public int i;
    public boolean j;
    public boolean k;
    public String l;
    public int m;
    public String n;
    public String o;
    public f57 p;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j57) {
                j57 j57Var = (j57) obj;
                return Intrinsics.areEqual(this.a, j57Var.a) && Intrinsics.areEqual(this.b, j57Var.b) && Intrinsics.areEqual(this.c, j57Var.c) && this.d == j57Var.d && this.e == j57Var.e && Intrinsics.areEqual(this.f, j57Var.f) && Intrinsics.areEqual(this.g, j57Var.g) && Intrinsics.areEqual(this.h, j57Var.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            f57 f57Var = this.b;
            int hashCode2 = (hashCode + (f57Var == null ? 0 : f57Var.hashCode())) * 31;
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
            return hashCode5 + (num2 != null ? num2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "EnableDegradeTextData(text=" + this.a + ", textColor=" + this.b + ", schema=" + this.c + ", priority=" + this.d + ", degradeEnable=" + this.e + ", degradeLength=" + this.f + ", degradeSuffix=" + this.g + ", degradePriority=" + this.h + ')';
        }
        return (String) invokeV.objValue;
    }

    public j57(String text, f57 f57Var, String str, int i, boolean z, Integer num, String str2, Integer num2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {text, f57Var, str, Integer.valueOf(i), Boolean.valueOf(z), num, str2, num2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.a = text;
        this.b = f57Var;
        this.c = str;
        this.d = i;
        this.e = z;
        this.f = num;
        this.g = str2;
        this.h = num2;
        this.i = i;
        this.j = z;
        this.k = true;
        this.l = text;
        this.m = text.length();
        reset();
    }

    @Override // com.baidu.tieba.h57
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h57
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h57
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final f57 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return (f57) invokeV.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public final f57 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (f57) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h57
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.h57
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.k = false;
        }
    }

    @Override // com.baidu.tieba.h57
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.i = this.d;
            this.j = this.e;
            this.k = true;
            String str = this.a;
            this.l = str;
            this.m = str.length();
        }
    }

    @Override // com.baidu.tieba.h57
    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.m--;
            StringBuilder sb = new StringBuilder();
            String substring = this.a.substring(0, this.m);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(this.g);
            this.l = sb.toString();
            int i = this.m;
            Integer num = this.f;
            Intrinsics.checkNotNull(num);
            if (i > num.intValue()) {
                return false;
            }
            Integer num2 = this.h;
            Intrinsics.checkNotNull(num2);
            this.i = num2.intValue();
            this.j = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h57 h57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, h57Var)) == null) {
            return h57.a.a(this, h57Var);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.h57
    public int m(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            Paint paint = new Paint();
            paint.setTextSize(i);
            return (int) paint.measureText(this.l);
        }
        return invokeII.intValue;
    }
}
