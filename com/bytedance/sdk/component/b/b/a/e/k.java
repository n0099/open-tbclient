package com.bytedance.sdk.component.b.b.a.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes9.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f64374a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f64375b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f64376c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final a f64377d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269593, "Lcom/bytedance/sdk/component/b/b/a/e/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269593, "Lcom/bytedance/sdk/component/b/b/a/e/k;");
                return;
            }
        }
        f64374a = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, GDiffPatcher.DATA_INT, SpeedStatsStampTable.INIT_MSG_ONE_START_STAMP_KEY, 1018, 1019, 249, SpeedStatsStampTable.INIT_MSG_TWO_START_STAMP_KEY, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, GDiffPatcher.COPY_USHORT_INT, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, GDiffPatcher.COPY_INT_UBYTE, 115, GDiffPatcher.COPY_INT_USHORT, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, SpeedStatsStampTable.INIT_MSG_THREE_START_STAMP_KEY, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        f64375b = new byte[]{13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, StandardMessageCodec.LIST, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, StandardMessageCodec.LIST, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        f64376c = new k();
    }

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64377d = new a();
        b();
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f64376c : (k) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) != null) {
            return;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr = f64375b;
            if (i2 >= bArr.length) {
                return;
            }
            a(i2, f64374a[i2], bArr[i2]);
            i2++;
        }
    }

    public void a(com.bytedance.sdk.component.b.a.f fVar, com.bytedance.sdk.component.b.a.d dVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, dVar) == null) {
            int i2 = 0;
            long j2 = 0;
            byte b2 = 0;
            while (i2 < fVar.g()) {
                int a2 = fVar.a(i2) & 255;
                int i3 = f64374a[a2];
                byte b3 = f64375b[a2];
                j2 = (j2 << b3) | i3;
                int i4 = b2 + b3;
                while (i4 >= 8) {
                    i4 = (i4 == 1 ? 1 : 0) - 8;
                    dVar.i((int) (j2 >> i4));
                }
                i2++;
                b2 = i4;
            }
            if (b2 > 0) {
                dVar.i((int) ((255 >>> b2) | (j2 << (8 - b2))));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final a[] f64378a;

        /* renamed from: b  reason: collision with root package name */
        public final int f64379b;

        /* renamed from: c  reason: collision with root package name */
        public final int f64380c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64378a = new a[256];
            this.f64379b = 0;
            this.f64380c = 0;
        }

        public a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f64378a = null;
            this.f64379b = i2;
            int i6 = i3 & 7;
            this.f64380c = i6 == 0 ? 8 : i6;
        }
    }

    public int a(com.bytedance.sdk.component.b.a.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            long j2 = 0;
            for (int i2 = 0; i2 < fVar.g(); i2++) {
                j2 += f64375b[fVar.a(i2) & 255];
            }
            return (int) ((j2 + 7) >> 3);
        }
        return invokeL.intValue;
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a aVar = this.f64377d;
            int i2 = 0;
            int i3 = 0;
            for (byte b2 : bArr) {
                i2 = (i2 << 8) | (b2 & 255);
                i3 += 8;
                while (i3 >= 8) {
                    aVar = aVar.f64378a[(i2 >>> (i3 - 8)) & 255];
                    if (aVar.f64378a == null) {
                        byteArrayOutputStream.write(aVar.f64379b);
                        i3 -= aVar.f64380c;
                        aVar = this.f64377d;
                    } else {
                        i3 -= 8;
                    }
                }
            }
            while (i3 > 0) {
                a aVar2 = aVar.f64378a[(i2 << (8 - i3)) & 255];
                if (aVar2.f64378a != null || aVar2.f64380c > i3) {
                    break;
                }
                byteArrayOutputStream.write(aVar2.f64379b);
                i3 -= aVar2.f64380c;
                aVar = this.f64377d;
            }
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    private void a(int i2, int i3, byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Byte.valueOf(b2)}) == null) {
            a aVar = new a(i2, b2);
            a aVar2 = this.f64377d;
            while (b2 > 8) {
                b2 = (byte) (b2 - 8);
                int i4 = (i3 >>> b2) & 255;
                a[] aVarArr = aVar2.f64378a;
                if (aVarArr != null) {
                    if (aVarArr[i4] == null) {
                        aVarArr[i4] = new a();
                    }
                    aVar2 = aVar2.f64378a[i4];
                } else {
                    throw new IllegalStateException("invalid dictionary: prefix not unique");
                }
            }
            int i5 = 8 - b2;
            int i6 = (i3 << i5) & 255;
            int i7 = 1 << i5;
            for (int i8 = i6; i8 < i6 + i7; i8++) {
                aVar2.f64378a[i8] = aVar;
            }
        }
    }
}
