package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class mka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;
    public lka b;
    public volatile boolean c;
    public int d;
    public int e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ mka b;

        public a(mka mkaVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mkaVar, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mkaVar;
            this.a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.b.c) {
                        this.b.b.g(mka.l(this.a, this.b.f, this.b.e));
                        return;
                    }
                    this.b.d(this.a, this.b.d);
                    this.b.b.g(mka.h(this.a, this.b.f, this.b.e));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mka a;

        public b(mka mkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mkaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.a != null) {
                        this.a.a.shutdown();
                        this.a.a.awaitTermination(3000L, TimeUnit.MILLISECONDS);
                    }
                    if (this.a.b != null) {
                        this.a.b.c();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public mka() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new lka();
    }

    public static byte[] h(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            int i3 = i * i2;
            int i4 = (i3 * 3) / 2;
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                for (int i7 = i2 - 1; i7 >= 0; i7--) {
                    bArr2[i5] = bArr[(i7 * i) + i6];
                    i5++;
                }
            }
            int i8 = i4 - 1;
            for (int i9 = i - 1; i9 > 0; i9 -= 2) {
                for (int i10 = 0; i10 < i2 / 2; i10++) {
                    int i11 = (i10 * i) + i3;
                    bArr2[i8] = bArr[i11 + i9];
                    int i12 = i8 - 1;
                    bArr2[i12] = bArr[i11 + (i9 - 1)];
                    i8 = i12 - 1;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] l(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i, i2)) == null) {
            int i3 = i * i2;
            byte[] bArr2 = new byte[(i3 * 3) / 2];
            int i4 = i - 1;
            int i5 = 0;
            for (int i6 = i4; i6 >= 0; i6--) {
                for (int i7 = 0; i7 < i2; i7++) {
                    bArr2[i5] = bArr[(i7 * i) + i6];
                    i5++;
                }
            }
            int i8 = i3;
            while (i4 > 0) {
                for (int i9 = 0; i9 < i2 / 2; i9++) {
                    int i10 = (i9 * i) + i3;
                    bArr2[i8] = bArr[(i4 - 1) + i10];
                    int i11 = i8 + 1;
                    bArr2[i11] = bArr[i10 + i4];
                    i8 = i11 + 1;
                }
                i4 -= 2;
            }
            o(bArr2, i2, i);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] o(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i, i2)) == null) {
            for (int i3 = 0; i3 < (i2 * 3) / 2; i3++) {
                for (int i4 = 0; i4 < i / 2; i4++) {
                    int i5 = (i3 * i) + i4;
                    byte b2 = bArr[i5];
                    int i6 = (((i3 + 1) * i) - 1) - i4;
                    bArr[i5] = bArr[i6];
                    bArr[i6] = b2;
                }
            }
            return bArr;
        }
        return (byte[]) invokeLII.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c = z;
        }
    }

    public void c(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            this.a.execute(new a(this, bArr));
        }
    }

    public final void d(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i) == null) {
            if (i == 17) {
                k(bArr);
            } else if (i == 842094169) {
                n(bArr);
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public boolean f(int i, int i2, int i3, int i4, int i5, int i6, String str) {
        InterceptResult invokeCommon;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str})) != null) {
            return invokeCommon.booleanValue;
        }
        this.d = i3;
        this.e = i;
        this.f = i2;
        if (i3 != 17) {
            i7 = i3 == 842094169 ? 19 : 19;
            return false;
        }
        i7 = 21;
        try {
            this.b.d(i, i2, i7, i4, i5, i6, str);
            this.a = Executors.newSingleThreadExecutor();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Executors.newSingleThreadExecutor().execute(new b(this));
        }
    }

    public final void k(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            for (int length = (bArr.length * 2) / 3; length < bArr.length - 1; length += 2) {
                byte b2 = bArr[length];
                int i = length + 1;
                bArr[length] = bArr[i];
                bArr[i] = b2;
            }
        }
    }

    public final void n(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            int length = (bArr.length * 2) / 3;
            int i = length / 2;
            for (int i2 = length; i2 < length + i; i2++) {
                byte b2 = bArr[i2];
                int i3 = i2 + i;
                bArr[i2] = bArr[i3];
                bArr[i3] = b2;
            }
        }
    }
}
