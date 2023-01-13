package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class sn3 {
    public static /* synthetic */ Interceptable $ic;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public byte[] b;
    public byte c;
    public byte d;
    public short e;
    public int f;
    public long g;
    public byte[] h;
    public byte[] i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948157137, "Lcom/baidu/tieba/sn3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948157137, "Lcom/baidu/tieba/sn3;");
                return;
            }
        }
        j = new a(null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sn3() {
        this(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((byte[]) objArr[0], (byte[]) objArr[1], ((Byte) objArr[2]).byteValue(), ((Byte) objArr[3]).byteValue(), ((Short) objArr[4]).shortValue(), ((Integer) objArr[5]).intValue(), ((Long) objArr[6]).longValue(), (byte[]) objArr[7], (byte[]) objArr[8], ((Integer) objArr[9]).intValue(), (DefaultConstructorMarker) objArr[10]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof sn3) {
                    sn3 sn3Var = (sn3) obj;
                    return Intrinsics.areEqual(this.a, sn3Var.a) && Intrinsics.areEqual(this.b, sn3Var.b) && this.c == sn3Var.c && this.d == sn3Var.d && this.e == sn3Var.e && this.f == sn3Var.f && this.g == sn3Var.g && Intrinsics.areEqual(this.h, sn3Var.h) && Intrinsics.areEqual(this.i, sn3Var.i);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            byte[] bArr = this.a;
            int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
            byte[] bArr2 = this.b;
            int hashCode2 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j2 = this.g;
            int i = (((((((((((hashCode + hashCode2) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            byte[] bArr3 = this.h;
            int hashCode3 = (i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0)) * 31;
            byte[] bArr4 = this.i;
            return hashCode3 + (bArr4 != null ? Arrays.hashCode(bArr4) : 0);
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final sn3 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                sn3 sn3Var = new sn3(null, null, (byte) 0, (byte) 0, (short) 0, 0, 0L, null, null, 511, null);
                sn3Var.n(new byte[2]);
                byte[] e = sn3Var.e();
                if (e != null) {
                    e[0] = 0;
                }
                byte[] e2 = sn3Var.e();
                if (e2 != null) {
                    e2[1] = 3;
                }
                sn3Var.m(new byte[2]);
                byte[] d = sn3Var.d();
                if (d != null) {
                    d[0] = -27;
                }
                byte[] d2 = sn3Var.d();
                if (d2 != null) {
                    d2[1] = -89;
                }
                return sn3Var;
            }
            return (sn3) invokeV.objValue;
        }
    }

    public sn3(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, long j2, byte[] bArr3, byte[] bArr4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, bArr2, Byte.valueOf(b), Byte.valueOf(b2), Short.valueOf(s), Integer.valueOf(i), Long.valueOf(j2), bArr3, bArr4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = bArr;
        this.b = bArr2;
        this.c = b;
        this.d = b2;
        this.e = s;
        this.f = i;
        this.g = j2;
        this.h = bArr3;
        this.i = bArr4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ sn3(byte[] bArr, byte[] bArr2, byte b, byte b2, short s, int i, long j2, byte[] bArr3, byte[] bArr4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r5, r6, r4, r7, r9, (i2 & 256) == 0 ? bArr4 : null);
        byte[] bArr5;
        byte[] bArr6;
        byte b3;
        byte b4;
        short s2;
        long j3;
        byte[] bArr7;
        if ((i2 & 1) != 0) {
            bArr5 = new byte[2];
        } else {
            bArr5 = bArr;
        }
        if ((i2 & 2) != 0) {
            bArr6 = new byte[2];
        } else {
            bArr6 = bArr2;
        }
        if ((i2 & 4) != 0) {
            b3 = 0;
        } else {
            b3 = b;
        }
        if ((i2 & 8) != 0) {
            b4 = 0;
        } else {
            b4 = b2;
        }
        if ((i2 & 16) != 0) {
            s2 = 0;
        } else {
            s2 = s;
        }
        int i3 = (i2 & 32) == 0 ? i : 0;
        if ((i2 & 64) != 0) {
            j3 = 0;
        } else {
            j3 = j2;
        }
        if ((i2 & 128) != 0) {
            bArr7 = null;
        } else {
            bArr7 = bArr3;
        }
    }

    public final byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i;
        }
        return (byte[]) invokeV.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return invokeV.longValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return invokeV.byteValue;
    }

    public final short h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.shortValue;
    }

    public final byte i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return invokeV.byteValue;
    }

    public final void j(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bArr) == null) {
            this.i = bArr;
        }
    }

    public final void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = i;
        }
    }

    public final void l(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.g = j2;
        }
    }

    public final void m(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bArr) == null) {
            this.b = bArr;
        }
    }

    public final void n(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            this.a = bArr;
        }
    }

    public final void o(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            this.h = bArr;
        }
    }

    public final void p(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048593, this, b) == null) {
            this.d = b;
        }
    }

    public final void q(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Short.valueOf(s)}) == null) {
            this.e = s;
        }
    }

    public final void r(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048595, this, b) == null) {
            this.c = b;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return "RecordParams(protocolVersion=" + Arrays.toString(this.a) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeType=" + ((int) this.c) + ", schemeExtType=" + ((int) this.d) + StringUtil.ARRAY_ELEMENT_SEPARATOR + "schemeLen=" + ((int) this.e) + ", contentLen=" + this.f + StringUtil.ARRAY_ELEMENT_SEPARATOR + "identity=" + this.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + "scheme=" + Arrays.toString(this.h) + ')';
        }
        return (String) invokeV.objValue;
    }
}
