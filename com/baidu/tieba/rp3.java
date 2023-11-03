package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class rp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public volatile int b;
    public Integer c;
    public Integer d;
    public Integer e;
    public Integer f;
    public byte[] g;
    public byte[] h;
    public long i;
    public byte[] j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public rp3() {
        this(null, null, null, null, null, null, 0L, null, 255, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Integer) objArr[0], (Integer) objArr[1], (Integer) objArr[2], (Integer) objArr[3], (byte[]) objArr[4], (byte[]) objArr[5], ((Long) objArr[6]).longValue(), (byte[]) objArr[7], ((Integer) objArr[8]).intValue(), (DefaultConstructorMarker) objArr[9]);
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
            if (this != obj) {
                if (obj instanceof rp3) {
                    rp3 rp3Var = (rp3) obj;
                    return Intrinsics.areEqual(this.c, rp3Var.c) && Intrinsics.areEqual(this.d, rp3Var.d) && Intrinsics.areEqual(this.e, rp3Var.e) && Intrinsics.areEqual(this.f, rp3Var.f) && Intrinsics.areEqual(this.g, rp3Var.g) && Intrinsics.areEqual(this.h, rp3Var.h) && this.i == rp3Var.i && Intrinsics.areEqual(this.j, rp3Var.j);
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
            Integer num = this.c;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.d;
            int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.e;
            int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Integer num4 = this.f;
            int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31;
            byte[] bArr = this.g;
            int hashCode5 = (hashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31;
            byte[] bArr2 = this.h;
            int hashCode6 = bArr2 != null ? Arrays.hashCode(bArr2) : 0;
            long j = this.i;
            int i = (((hashCode5 + hashCode6) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            byte[] bArr3 = this.j;
            return i + (bArr3 != null ? Arrays.hashCode(bArr3) : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "SessionParams(dhGroupId=" + this.c + ", dhSecretKey=" + this.d + ", dhPublicKey=" + this.e + ", dhServerPublicKey=" + this.f + ", aesSecretKey=" + Arrays.toString(this.g) + ", sessionTicket=" + Arrays.toString(this.h) + ", expireTime=" + this.i + ", entryType=" + Arrays.toString(this.j) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public rp3(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {num, num2, num3, num4, bArr, bArr2, Long.valueOf(j), bArr3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = num;
        this.d = num2;
        this.e = num3;
        this.f = num4;
        this.g = bArr;
        this.h = bArr2;
        this.i = j;
        this.j = bArr3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ rp3(Integer num, Integer num2, Integer num3, Integer num4, byte[] bArr, byte[] bArr2, long j, byte[] bArr3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r7, r8, (i & 128) == 0 ? bArr3 : null);
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        byte[] bArr4;
        byte[] bArr5;
        long j2;
        if ((i & 1) != 0) {
            num5 = null;
        } else {
            num5 = num;
        }
        if ((i & 2) != 0) {
            num6 = null;
        } else {
            num6 = num2;
        }
        if ((i & 4) != 0) {
            num7 = null;
        } else {
            num7 = num3;
        }
        if ((i & 8) != 0) {
            num8 = null;
        } else {
            num8 = num4;
        }
        if ((i & 16) != 0) {
            bArr4 = null;
        } else {
            bArr4 = bArr;
        }
        if ((i & 32) != 0) {
            bArr5 = null;
        } else {
            bArr5 = bArr2;
        }
        if ((i & 64) != 0) {
            j2 = 0;
        } else {
            j2 = j;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (rm1.a) {
                Log.d("BDTLS", "Recovery: add recoveryCount: " + this.b);
            }
            this.b++;
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.b < 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (byte[]) invokeV.objValue;
    }

    public final Integer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (Integer) invokeV.objValue;
    }

    public final Integer g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (Integer) invokeV.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final byte[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (byte[]) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (rm1.a) {
                Log.d("BDTLS", "Downgrade: reset downgrade count " + this.b);
            }
            this.b = 0;
        }
    }

    public final synchronized boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                z = false;
                if (this.g != null && this.h != null && this.i > currentTimeMillis && this.a == 1) {
                    z = true;
                }
                if (cp3.a) {
                    Log.d("BDTLS", "isSessionEnable " + this.g + WebvttCueParser.CHAR_SPACE + this.h + WebvttCueParser.CHAR_SPACE + this.i + WebvttCueParser.CHAR_SPACE + this.a);
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) {
            this.g = bArr;
        }
    }

    public final void m(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.c = num;
        }
    }

    public final void n(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, num) == null) {
            this.e = num;
        }
    }

    public final void o(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.d = num;
        }
    }

    public final void p(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            this.f = num;
        }
    }

    public final void q(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bArr) == null) {
            this.j = bArr;
        }
    }

    public final void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.i = j;
        }
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.a = i;
        }
    }

    public final void t(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bArr) == null) {
            this.h = bArr;
        }
    }
}
