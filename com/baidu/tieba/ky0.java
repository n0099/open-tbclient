package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class ky0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public float d;
    public boolean e;
    public int f;
    public float g;
    public int h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ky0() {
        this(0, 0, 0, 0.0f, false, 0, 0.0f, 0, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Float) objArr[3]).floatValue(), ((Boolean) objArr[4]).booleanValue(), ((Integer) objArr[5]).intValue(), ((Float) objArr[6]).floatValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof ky0) {
                    ky0 ky0Var = (ky0) obj;
                    return this.a == ky0Var.a && this.b == ky0Var.b && this.c == ky0Var.c && Float.compare(this.d, ky0Var.d) == 0 && this.e == ky0Var.e && this.f == ky0Var.f && Float.compare(this.g, ky0Var.g) == 0 && this.h == ky0Var.h;
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int floatToIntBits = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31;
            boolean z = this.e;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((((floatToIntBits + i) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + this.h;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "NadSensorHelperParams(planeType=" + this.a + ", leftThreshold=" + this.b + ", rightThreshold=" + this.c + ", thirdAxisLimit=" + this.d + ", isSaveStartAngle=" + this.e + ", updateInterval=" + this.f + ", shakeSensitivity=" + this.g + ", shakeCounts=" + this.h + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public ky0(int i, int i2, int i3, float f, boolean z, int i4, float f2, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z), Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
        this.e = z;
        this.f = i4;
        this.g = f2;
        this.h = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ky0(int i, int i2, int i3, float f, boolean z, int i4, float f2, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r4, r5, r6, r7, r0);
        int i7;
        int i8;
        float f3;
        boolean z2;
        int i9;
        float f4;
        int i10;
        if ((i6 & 1) != 0) {
            i7 = 0;
        } else {
            i7 = i;
        }
        if ((i6 & 2) != 0) {
            i8 = 90;
        } else {
            i8 = i2;
        }
        int i11 = (i6 & 4) == 0 ? i3 : 90;
        if ((i6 & 8) != 0) {
            f3 = 0.5f;
        } else {
            f3 = f;
        }
        if ((i6 & 16) != 0) {
            z2 = true;
        } else {
            z2 = z;
        }
        if ((i6 & 32) != 0) {
            i9 = 67;
        } else {
            i9 = i4;
        }
        if ((i6 & 64) != 0) {
            f4 = 12.0f;
        } else {
            f4 = f2;
        }
        if ((i6 & 128) != 0) {
            i10 = 2;
        } else {
            i10 = i5;
        }
    }

    public final int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public final float b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.floatValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }
}
