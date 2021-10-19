package com.bytedance.sdk.component.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes9.dex */
public final class q extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f64793f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f64794g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(c cVar, int i2) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        u.a(cVar.f64752b, 0L, i2);
        o oVar = cVar.f64751a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = oVar.f64786c;
            int i9 = oVar.f64785b;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                oVar = oVar.f64789f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f64793f = new byte[i7];
        this.f64794g = new int[i7 * 2];
        o oVar2 = cVar.f64751a;
        int i10 = 0;
        while (i5 < i2) {
            this.f64793f[i10] = oVar2.f64784a;
            i5 += oVar2.f64786c - oVar2.f64785b;
            if (i5 > i2) {
                i5 = i2;
            }
            int[] iArr = this.f64794g;
            iArr[i10] = i5;
            iArr[this.f64793f.length + i10] = oVar2.f64785b;
            oVar2.f64787d = true;
            i10++;
            oVar2 = oVar2.f64789f;
        }
    }

    private f i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new f(h()) : (f) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? i().a() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? i().b() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? i().c() : (f) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? i().d() : (f) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? i().e() : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (fVar.g() == g() && a(0, fVar, 0, g())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? i().f() : (f) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f64794g[this.f64793f.length - 1] : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int[] iArr = this.f64794g;
            byte[][] bArr = this.f64793f;
            byte[] bArr2 = new byte[iArr[bArr.length - 1]];
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr2 = this.f64794g;
                int i4 = iArr2[length + i2];
                int i5 = iArr2[i2];
                System.arraycopy(this.f64793f[i2], i4, bArr2, i3, i5 - i3);
                i2++;
                i3 = i5;
            }
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.f64757d;
            if (i2 != 0) {
                return i2;
            }
            int length = this.f64793f.length;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i3 < length) {
                byte[] bArr = this.f64793f[i3];
                int[] iArr = this.f64794g;
                int i6 = iArr[length + i3];
                int i7 = iArr[i3];
                int i8 = (i7 - i4) + i6;
                while (i6 < i8) {
                    i5 = (i5 * 31) + bArr[i6];
                    i6++;
                }
                i3++;
                i4 = i7;
            }
            this.f64757d = i5;
            return i5;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? i().toString() : (String) invokeV.objValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int binarySearch = Arrays.binarySearch(this.f64794g, 0, this.f64793f.length, i2 + 1);
            return binarySearch >= 0 ? binarySearch : ~binarySearch;
        }
        return invokeI.intValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public f a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? i().a(i2, i3) : (f) invokeII.objValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public byte a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            u.a(this.f64794g[this.f64793f.length - 1], i2, 1L);
            int b2 = b(i2);
            int i3 = b2 == 0 ? 0 : this.f64794g[b2 - 1];
            int[] iArr = this.f64794g;
            byte[][] bArr = this.f64793f;
            return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
        }
        return invokeI.byteValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            int length = this.f64793f.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr = this.f64794g;
                int i4 = iArr[length + i2];
                int i5 = iArr[i2];
                o oVar = new o(this.f64793f[i2], i4, (i4 + i5) - i3, true, false);
                o oVar2 = cVar.f64751a;
                if (oVar2 == null) {
                    oVar.f64790g = oVar;
                    oVar.f64789f = oVar;
                    cVar.f64751a = oVar;
                } else {
                    oVar2.f64790g.a(oVar);
                }
                i2++;
                i3 = i5;
            }
            cVar.f64752b += i3;
        }
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), fVar, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > g() - i4) {
                return false;
            }
            int b2 = b(i2);
            while (i4 > 0) {
                int i5 = b2 == 0 ? 0 : this.f64794g[b2 - 1];
                int min = Math.min(i4, ((this.f64794g[b2] - i5) + i5) - i2);
                int[] iArr = this.f64794g;
                byte[][] bArr = this.f64793f;
                if (!fVar.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                b2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.component.b.a.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > g() - i4 || i3 < 0 || i3 > bArr.length - i4) {
                return false;
            }
            int b2 = b(i2);
            while (i4 > 0) {
                int i5 = b2 == 0 ? 0 : this.f64794g[b2 - 1];
                int min = Math.min(i4, ((this.f64794g[b2] - i5) + i5) - i2);
                int[] iArr = this.f64794g;
                byte[][] bArr2 = this.f64793f;
                if (!u.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                b2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
