package com.bytedance.pangle.res.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final h g;
    public final byte[] h;
    public boolean i;
    public int[] j;
    public final a k;
    public boolean l;
    public int m;
    public int[] n;
    public int o;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public int b;
        public int c;

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
                    return;
                }
            }
            this.a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b();
                int i = this.b;
                int[] iArr = this.a;
                iArr[i] = 0;
                iArr[i + 1] = 0;
                this.b = i + 2;
                this.c++;
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int[] iArr = this.a;
                int length = iArr.length;
                int i = this.b;
                int i2 = length - i;
                if (i2 > 2) {
                    return;
                }
                int[] iArr2 = new int[(iArr.length + i2) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                this.a = iArr2;
            }
        }
    }

    public b(byte[] bArr, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = new a();
        this.b = 0;
        this.c = 1;
        this.d = 2;
        this.e = 3;
        this.f = 4;
        this.g = hVar;
        this.h = bArr;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.m = -1;
            this.n = null;
            this.o = -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fa, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        int readInt;
        int i;
        int[] iArr;
        int i2;
        int[] iArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int i3 = 3;
            if (!this.i) {
                int readInt2 = this.a.readInt();
                if (readInt2 != 524291 && readInt2 != 524289) {
                    throw new IOException(String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", 524291, 524289, Integer.valueOf(readInt2)));
                }
                this.a.skipBytes(4);
                l.a(this.a);
                this.k.a();
                this.i = true;
            }
            int i4 = this.m;
            if (i4 == this.c) {
                return;
            }
            c();
            while (true) {
                if (this.l) {
                    this.l = false;
                    a aVar = this.k;
                    int i5 = aVar.b;
                    if (i5 != 0) {
                        int i6 = i5 - 1;
                        int i7 = aVar.a[i6] * 2;
                        if ((i6 - 1) - i7 != 0) {
                            aVar.b = i5 - (i7 + 2);
                            aVar.c--;
                        }
                    }
                }
                if (i4 == this.e) {
                    a aVar2 = this.k;
                    if (aVar2.c == 1) {
                        int i8 = aVar2.b;
                        if ((i8 == 0 ? 0 : aVar2.a[i8 - 1]) == 0) {
                            this.m = this.c;
                            return;
                        }
                    }
                }
                readInt = i4 == this.b ? 1048834 : this.a.readInt();
                if (readInt == 524672) {
                    int readInt3 = this.a.readInt();
                    if (readInt3 < 8 || readInt3 % 4 != 0) {
                        break;
                    }
                    int a2 = k.a(this.a);
                    this.j = this.a.a((readInt3 / 4) - 2);
                    int i9 = 0;
                    while (true) {
                        int[] iArr3 = this.j;
                        if (i9 < iArr3.length) {
                            k.a(this.h, iArr3[i9], (i9 * 4) + a2, this.g);
                            i9++;
                        }
                    }
                } else if (readInt < 1048832 || readInt > 1048836) {
                    break;
                } else if (readInt == 1048834 && i4 == -1) {
                    this.m = this.b;
                    return;
                } else {
                    this.a.skipBytes(4);
                    this.a.readInt();
                    this.a.skipBytes(4);
                    if (readInt == 1048832 || readInt == 1048833) {
                        if (readInt == 1048832) {
                            int readInt4 = this.a.readInt();
                            int readInt5 = this.a.readInt();
                            a aVar3 = this.k;
                            if (aVar3.c == 0) {
                                aVar3.a();
                            }
                            aVar3.b();
                            int i10 = aVar3.b;
                            int i11 = i10 - 1;
                            int[] iArr4 = aVar3.a;
                            int i12 = iArr4[i11];
                            int i13 = i12 + 1;
                            iArr4[(i11 - 1) - (i12 * 2)] = i13;
                            iArr4[i11] = readInt4;
                            iArr4[i11 + 1] = readInt5;
                            iArr4[i11 + 2] = i13;
                            aVar3.b = i10 + 2;
                        } else {
                            this.a.skipBytes(4);
                            this.a.skipBytes(4);
                            a aVar4 = this.k;
                            int i14 = aVar4.b;
                            if (i14 != 0 && (i2 = (iArr = aVar4.a)[i14 - 1]) != 0) {
                                int i15 = i2 - 1;
                                int i16 = i - 2;
                                iArr[i16] = i15;
                                iArr[i16 - ((i15 * 2) + 1)] = i15;
                                aVar4.b = i14 - 2;
                            }
                        }
                    } else if (readInt == 1048834) {
                        this.a.readInt();
                        this.a.readInt();
                        this.a.skipBytes(4);
                        int readInt6 = this.a.readInt() & 65535;
                        int readInt7 = this.a.readInt();
                        this.o = readInt7;
                        this.o = (65535 & readInt7) - 1;
                        int a3 = k.a(this.a);
                        int i17 = readInt6 * 5;
                        this.n = this.a.a(i17);
                        while (true) {
                            iArr2 = this.n;
                            if (i3 >= iArr2.length) {
                                break;
                            }
                            iArr2[i3] = iArr2[i3] >>> 24;
                            i3 += 5;
                        }
                        if (iArr2.length == i17) {
                            for (int i18 = 0; i18 < readInt6; i18++) {
                                int[] iArr5 = this.n;
                                int i19 = i18 * 5;
                                int i20 = i19 + 3;
                                if (iArr5[i20] == 1 || iArr5[i20] == 2) {
                                    int i21 = i19 + 4;
                                    k.a(this.h, this.n[i21], (i21 * 4) + a3, this.g);
                                }
                            }
                            this.k.a();
                            this.m = this.d;
                            return;
                        }
                        throw new RuntimeException();
                    } else if (readInt == 1048835) {
                        this.a.readInt();
                        this.a.readInt();
                        this.m = this.e;
                        this.l = true;
                        return;
                    } else if (readInt == 1048836) {
                        this.a.readInt();
                        this.a.skipBytes(4);
                        this.a.skipBytes(4);
                        this.m = this.f;
                        return;
                    }
                }
            }
            throw new IOException("Invalid chunk type (" + readInt + ").");
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.i) {
            this.i = false;
            this.a = null;
            this.j = null;
            a aVar = this.k;
            aVar.b = 0;
            aVar.c = 0;
            c();
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a != null) {
                try {
                    d();
                    return this.m;
                } catch (IOException e) {
                    a();
                    throw e;
                }
            }
            throw new RuntimeException("Parser is not opened.");
        }
        return invokeV.intValue;
    }
}
