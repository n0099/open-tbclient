package com.bytedance.sdk.component.b.b.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.a.t;
import com.bytedance.sdk.component.b.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class h implements Closeable {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f28276a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final d.a f28277b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.e f28278c;

    /* renamed from: d  reason: collision with root package name */
    public final a f28279d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f28280e;

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z);

        void a(int i2, int i3, List<c> list) throws IOException;

        void a(int i2, long j);

        void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar);

        void a(int i2, com.bytedance.sdk.component.b.b.a.e.b bVar, com.bytedance.sdk.component.b.a.f fVar);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, int i3, List<c> list);

        void a(boolean z, int i2, com.bytedance.sdk.component.b.a.e eVar, int i3) throws IOException;

        void a(boolean z, n nVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269686, "Lcom/bytedance/sdk/component/b/b/a/e/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269686, "Lcom/bytedance/sdk/component/b/b/a/e/h;");
                return;
            }
        }
        f28276a = Logger.getLogger(e.class.getName());
    }

    public h(com.bytedance.sdk.component.b.a.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28278c = eVar;
        this.f28280e = z;
        a aVar = new a(eVar);
        this.f28279d = aVar;
        this.f28277b = new d.a(4096, aVar);
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 == 0) {
                throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            }
            boolean z = (b2 & 1) != 0;
            if (!((b2 & 32) != 0)) {
                short h2 = (b2 & 8) != 0 ? (short) (this.f28278c.h() & 255) : (short) 0;
                bVar.a(z, i3, this.f28278c, a(i2, b2, h2));
                this.f28278c.h(h2);
                return;
            }
            throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 5) {
                throw e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                a(bVar, i3);
                return;
            }
            throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                throw e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                int j = this.f28278c.j();
                com.bytedance.sdk.component.b.b.a.e.b a2 = com.bytedance.sdk.component.b.b.a.e.b.a(j);
                if (a2 == null) {
                    throw e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(j));
                }
                bVar.a(i3, a2);
                return;
            }
            throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b2 & 1) != 0) {
                if (i2 == 0) {
                    bVar.a();
                    return;
                }
                throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (i2 % 6 != 0) {
                throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            } else {
                n nVar = new n();
                for (int i4 = 0; i4 < i2; i4 += 6) {
                    short i5 = this.f28278c.i();
                    int j = this.f28278c.j();
                    if (i5 != 2) {
                        if (i5 == 3) {
                            i5 = 4;
                        } else if (i5 == 4) {
                            i5 = 7;
                            if (j < 0) {
                                throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        } else if (i5 == 5 && (j < 16384 || j > 16777215)) {
                            throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(j));
                        }
                    } else if (j != 0 && j != 1) {
                        throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    nVar.a(i5, j);
                }
                bVar.a(false, nVar);
            }
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                short h2 = (b2 & 8) != 0 ? (short) (this.f28278c.h() & 255) : (short) 0;
                bVar.a(i3, this.f28278c.j() & Integer.MAX_VALUE, a(a(i2 - 4, b2, h2), h2, b2, i3));
                return;
            }
            throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 8) {
                throw e.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                bVar.a((b2 & 1) != 0, this.f28278c.j(), this.f28278c.j());
                return;
            }
            throw e.b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 < 8) {
                throw e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                int j = this.f28278c.j();
                int j2 = this.f28278c.j();
                int i4 = i2 - 8;
                com.bytedance.sdk.component.b.b.a.e.b a2 = com.bytedance.sdk.component.b.b.a.e.b.a(j2);
                if (a2 == null) {
                    throw e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(j2));
                }
                com.bytedance.sdk.component.b.a.f fVar = com.bytedance.sdk.component.b.a.f.f27982b;
                if (i4 > 0) {
                    fVar = this.f28278c.c(i4);
                }
                bVar.a(j, a2, fVar);
                return;
            }
            throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            }
            long j = this.f28278c.j() & 2147483647L;
            if (j == 0) {
                throw e.b("windowSizeIncrement was 0", Long.valueOf(j));
            }
            bVar.a(i3, j);
        }
    }

    public void a(b bVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.f28280e) {
                if (!a(true, bVar)) {
                    throw e.b("Required SETTINGS preface not received", new Object[0]);
                }
                return;
            }
            com.bytedance.sdk.component.b.a.f c2 = this.f28278c.c(e.f28210a.g());
            if (f28276a.isLoggable(Level.FINE)) {
                f28276a.fine(com.bytedance.sdk.component.b.b.a.c.a("<< CONNECTION %s", c2.e()));
            }
            if (!e.f28210a.equals(c2)) {
                throw e.b("Expected a connection header but was %s", c2.a());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28278c.close();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f28281a;

        /* renamed from: b  reason: collision with root package name */
        public byte f28282b;

        /* renamed from: c  reason: collision with root package name */
        public int f28283c;

        /* renamed from: d  reason: collision with root package name */
        public int f28284d;

        /* renamed from: e  reason: collision with root package name */
        public short f28285e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.a.e f28286f;

        public a(com.bytedance.sdk.component.b.a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28286f = eVar;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                int i2 = this.f28283c;
                int a2 = h.a(this.f28286f);
                this.f28284d = a2;
                this.f28281a = a2;
                byte h2 = (byte) (this.f28286f.h() & 255);
                this.f28282b = (byte) (this.f28286f.h() & 255);
                if (h.f28276a.isLoggable(Level.FINE)) {
                    h.f28276a.fine(e.a(true, this.f28283c, this.f28281a, h2, this.f28282b));
                }
                int j = this.f28286f.j() & Integer.MAX_VALUE;
                this.f28283c = j;
                if (h2 != 9) {
                    throw e.b("%s != TYPE_CONTINUATION", Byte.valueOf(h2));
                }
                if (j != i2) {
                    throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) != null) {
                return invokeLJ.longValue;
            }
            while (true) {
                int i2 = this.f28284d;
                if (i2 == 0) {
                    this.f28286f.h(this.f28285e);
                    this.f28285e = (short) 0;
                    if ((this.f28282b & 4) != 0) {
                        return -1L;
                    }
                    b();
                } else {
                    long a2 = this.f28286f.a(cVar, Math.min(j, i2));
                    if (a2 == -1) {
                        return -1L;
                    }
                    this.f28284d = (int) (this.f28284d - a2);
                    return a2;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28286f.a() : (t) invokeV.objValue;
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, bVar)) == null) {
            try {
                this.f28278c.a(9L);
                int a2 = a(this.f28278c);
                if (a2 < 0 || a2 > 16384) {
                    throw e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                }
                byte h2 = (byte) (this.f28278c.h() & 255);
                if (!z || h2 == 4) {
                    byte h3 = (byte) (this.f28278c.h() & 255);
                    int j = this.f28278c.j() & Integer.MAX_VALUE;
                    if (f28276a.isLoggable(Level.FINE)) {
                        f28276a.fine(e.a(true, j, a2, h2, h3));
                    }
                    switch (h2) {
                        case 0:
                            b(bVar, a2, h3, j);
                            break;
                        case 1:
                            a(bVar, a2, h3, j);
                            break;
                        case 2:
                            c(bVar, a2, h3, j);
                            break;
                        case 3:
                            d(bVar, a2, h3, j);
                            break;
                        case 4:
                            e(bVar, a2, h3, j);
                            break;
                        case 5:
                            f(bVar, a2, h3, j);
                            break;
                        case 6:
                            g(bVar, a2, h3, j);
                            break;
                        case 7:
                            h(bVar, a2, h3, j);
                            break;
                        case 8:
                            i(bVar, a2, h3, j);
                            break;
                        default:
                            this.f28278c.h(a2);
                            break;
                    }
                    return true;
                }
                throw e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(h2));
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeZL.booleanValue;
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{bVar, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                boolean z = (b2 & 1) != 0;
                short h2 = (b2 & 8) != 0 ? (short) (this.f28278c.h() & 255) : (short) 0;
                if ((b2 & 32) != 0) {
                    a(bVar, i3);
                    i2 -= 5;
                }
                bVar.a(z, i3, -1, a(a(i2, b2, h2), h2, b2, i3));
                return;
            }
            throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
    }

    private List<c> a(int i2, short s, byte b2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, this, new Object[]{Integer.valueOf(i2), Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i3)})) == null) {
            a aVar = this.f28279d;
            aVar.f28284d = i2;
            aVar.f28281a = i2;
            aVar.f28285e = s;
            aVar.f28282b = b2;
            aVar.f28283c = i3;
            this.f28277b.a();
            return this.f28277b.b();
        }
        return (List) invokeCommon.objValue;
    }

    private void a(b bVar, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, bVar, i2) == null) {
            int j = this.f28278c.j();
            bVar.a(i2, j & Integer.MAX_VALUE, (this.f28278c.h() & 255) + 1, (Integer.MIN_VALUE & j) != 0);
        }
    }

    public static int a(com.bytedance.sdk.component.b.a.e eVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, eVar)) == null) ? (eVar.h() & 255) | ((eVar.h() & 255) << 16) | ((eVar.h() & 255) << 8) : invokeL.intValue;
    }

    public static int a(int i2, byte b2, short s) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), Short.valueOf(s)})) == null) {
            if ((b2 & 8) != 0) {
                i2--;
            }
            if (s <= i2) {
                return (short) (i2 - s);
            }
            throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        }
        return invokeCommon.intValue;
    }
}
