package com.bytedance.sdk.component.b.b.a.d;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.b.a.i;
import com.bytedance.sdk.component.b.a.l;
import com.bytedance.sdk.component.b.a.r;
import com.bytedance.sdk.component.b.a.s;
import com.bytedance.sdk.component.b.a.t;
import com.bytedance.sdk.component.b.b.a.b.g;
import com.bytedance.sdk.component.b.b.a.c.h;
import com.bytedance.sdk.component.b.b.a.c.k;
import com.bytedance.sdk.component.b.b.ab;
import com.bytedance.sdk.component.b.b.ac;
import com.bytedance.sdk.component.b.b.s;
import com.bytedance.sdk.component.b.b.w;
import com.bytedance.sdk.component.b.b.z;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class a implements com.bytedance.sdk.component.b.b.a.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f64894a;

    /* renamed from: b  reason: collision with root package name */
    public final g f64895b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.e f64896c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.d f64897d;

    /* renamed from: e  reason: collision with root package name */
    public int f64898e;

    /* renamed from: f  reason: collision with root package name */
    public long f64899f;

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public abstract class AbstractC1888a implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final i f64900a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64901b;

        /* renamed from: c  reason: collision with root package name */
        public long f64902c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f64903d;

        public AbstractC1888a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64903d = aVar;
            this.f64900a = new i(this.f64903d.f64896c.a());
            this.f64902c = 0L;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64900a : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                try {
                    long a2 = this.f64903d.f64896c.a(cVar, j2);
                    if (a2 > 0) {
                        this.f64902c += a2;
                    }
                    return a2;
                } catch (IOException e2) {
                    a(false, e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        public /* synthetic */ AbstractC1888a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, iOException) == null) || (i2 = (aVar = this.f64903d).f64898e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.a(this.f64900a);
                a aVar2 = this.f64903d;
                aVar2.f64898e = 6;
                g gVar = aVar2.f64895b;
                if (gVar != null) {
                    gVar.a(!z, aVar2, this.f64902c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f64903d.f64898e);
        }
    }

    /* loaded from: classes9.dex */
    public final class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64904a;

        /* renamed from: b  reason: collision with root package name */
        public final i f64905b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64906c;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64904a = aVar;
            this.f64905b = new i(this.f64904a.f64897d.a());
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64905b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) == null) {
                if (this.f64906c) {
                    throw new IllegalStateException("closed");
                }
                if (j2 == 0) {
                    return;
                }
                this.f64904a.f64897d.k(j2);
                this.f64904a.f64897d.b(Part.CRLF);
                this.f64904a.f64897d.a_(cVar, j2);
                this.f64904a.f64897d.b(Part.CRLF);
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.f64906c) {
                        return;
                    }
                    this.f64906c = true;
                    this.f64904a.f64897d.b("0\r\n\r\n");
                    this.f64904a.a(this.f64905b);
                    this.f64904a.f64898e = 3;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    if (this.f64906c) {
                        return;
                    }
                    this.f64904a.f64897d.flush();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends AbstractC1888a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64907e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.b.t f64908f;

        /* renamed from: g  reason: collision with root package name */
        public long f64909g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f64910h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, com.bytedance.sdk.component.b.b.t tVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64907e = aVar;
            this.f64909g = -1L;
            this.f64910h = true;
            this.f64908f = tVar;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.f64909g != -1) {
                    this.f64907e.f64896c.p();
                }
                try {
                    this.f64909g = this.f64907e.f64896c.m();
                    String trim = this.f64907e.f64896c.p().trim();
                    if (this.f64909g >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.f64909g == 0) {
                            this.f64910h = false;
                            com.bytedance.sdk.component.b.b.a.c.e.a(this.f64907e.f64894a.f(), this.f64908f, this.f64907e.d());
                            a(true, (IOException) null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f64909g + trim + "\"");
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC1888a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f64901b) {
                        if (this.f64910h) {
                            long j3 = this.f64909g;
                            if (j3 == 0 || j3 == -1) {
                                b();
                                if (!this.f64910h) {
                                    return -1L;
                                }
                            }
                            long a2 = super.a(cVar, Math.min(j2, this.f64909g));
                            if (a2 != -1) {
                                this.f64909g -= a2;
                                return a2;
                            }
                            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                            a(false, (IOException) protocolException);
                            throw protocolException;
                        }
                        return -1L;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64901b) {
                return;
            }
            if (this.f64910h && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f64901b = true;
        }
    }

    /* loaded from: classes9.dex */
    public final class d implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64911a;

        /* renamed from: b  reason: collision with root package name */
        public final i f64912b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64913c;

        /* renamed from: d  reason: collision with root package name */
        public long f64914d;

        public d(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64911a = aVar;
            this.f64912b = new i(this.f64911a.f64897d.a());
            this.f64914d = j2;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64912b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j2) == null) {
                if (!this.f64913c) {
                    com.bytedance.sdk.component.b.b.a.c.a(cVar.b(), 0L, j2);
                    if (j2 <= this.f64914d) {
                        this.f64911a.f64897d.a_(cVar, j2);
                        this.f64914d -= j2;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f64914d + " bytes but received " + j2);
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f64913c) {
                return;
            }
            this.f64913c = true;
            if (this.f64914d <= 0) {
                this.f64911a.a(this.f64912b);
                this.f64911a.f64898e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f64913c) {
                return;
            }
            this.f64911a.f64897d.flush();
        }
    }

    /* loaded from: classes9.dex */
    public class e extends AbstractC1888a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64915e;

        /* renamed from: f  reason: collision with root package name */
        public long f64916f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, long j2) throws IOException {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64915e = aVar;
            this.f64916f = j2;
            if (j2 == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC1888a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f64901b) {
                        long j3 = this.f64916f;
                        if (j3 == 0) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, Math.min(j3, j2));
                        if (a2 != -1) {
                            long j4 = this.f64916f - a2;
                            this.f64916f = j4;
                            if (j4 == 0) {
                                a(true, (IOException) null);
                            }
                            return a2;
                        }
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        a(false, (IOException) protocolException);
                        throw protocolException;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64901b) {
                return;
            }
            if (this.f64916f != 0 && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f64901b = true;
        }
    }

    /* loaded from: classes9.dex */
    public class f extends AbstractC1888a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64917e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64918f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar) {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((a) objArr2[0], (AnonymousClass1) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64917e = aVar;
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC1888a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j2)) == null) {
                if (j2 >= 0) {
                    if (!this.f64901b) {
                        if (this.f64918f) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, j2);
                        if (a2 == -1) {
                            this.f64918f = true;
                            a(true, (IOException) null);
                            return -1L;
                        }
                        return a2;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f64901b) {
                return;
            }
            if (!this.f64918f) {
                a(false, (IOException) null);
            }
            this.f64901b = true;
        }
    }

    public a(w wVar, g gVar, com.bytedance.sdk.component.b.a.e eVar, com.bytedance.sdk.component.b.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, gVar, eVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64898e = 0;
        this.f64899f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f64894a = wVar;
        this.f64895b = gVar;
        this.f64896c = eVar;
        this.f64897d = dVar;
    }

    private String g() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String e2 = this.f64896c.e(this.f64899f);
            this.f64899f -= e2.length();
            return e2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public r a(z zVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar, j2)) == null) {
            if ("chunked".equalsIgnoreCase(zVar.a("Transfer-Encoding"))) {
                return e();
            }
            if (j2 != -1) {
                return a(j2);
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return (r) invokeLJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f64897d.flush();
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void c() {
        com.bytedance.sdk.component.b.b.a.b.c b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (b2 = this.f64895b.b()) == null) {
            return;
        }
        b2.b();
    }

    public com.bytedance.sdk.component.b.b.s d() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048588, this)) != null) {
            return (com.bytedance.sdk.component.b.b.s) invokeV.objValue;
        }
        s.a aVar = new s.a();
        while (true) {
            String g2 = g();
            if (g2.length() != 0) {
                com.bytedance.sdk.component.b.b.a.a.f64775a.a(aVar, g2);
            } else {
                return aVar.a();
            }
        }
    }

    public r e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f64898e == 1) {
                this.f64898e = 2;
                return new b(this);
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
        return (r) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f64898e == 4) {
                g gVar = this.f64895b;
                if (gVar != null) {
                    this.f64898e = 5;
                    gVar.d();
                    return new f(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s b(long j2) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (this.f64898e == 4) {
                this.f64898e = 5;
                return new e(this, j2);
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            a(zVar.c(), com.bytedance.sdk.component.b.b.a.c.i.a(zVar, this.f64895b.b().a().b().type()));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ac a(ab abVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, abVar)) == null) {
            g gVar = this.f64895b;
            gVar.f64846c.f(gVar.f64845b);
            String a2 = abVar.a("Content-Type");
            if (!com.bytedance.sdk.component.b.b.a.c.e.b(abVar)) {
                return new h(a2, 0L, l.a(b(0L)));
            }
            if ("chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
                return new h(a2, -1L, l.a(a(abVar.a().a())));
            }
            long a3 = com.bytedance.sdk.component.b.b.a.c.e.a(abVar);
            if (a3 != -1) {
                return new h(a2, a3, l.a(b(a3)));
            }
            return new h(a2, -1L, l.a(f()));
        }
        return (ac) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64897d.flush();
        }
    }

    public void a(com.bytedance.sdk.component.b.b.s sVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, sVar, str) == null) {
            if (this.f64898e == 0) {
                this.f64897d.b(str).b(Part.CRLF);
                int a2 = sVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    this.f64897d.b(sVar.a(i2)).b(": ").b(sVar.b(i2)).b(Part.CRLF);
                }
                this.f64897d.b(Part.CRLF);
                this.f64898e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ab.a a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            int i2 = this.f64898e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f64898e);
            }
            try {
                k a2 = k.a(g());
                ab.a a3 = new ab.a().a(a2.f64891a).a(a2.f64892b).a(a2.f64893c).a(d());
                if (z && a2.f64892b == 100) {
                    return null;
                }
                this.f64898e = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f64895b);
                iOException.initCause(e2);
                throw iOException;
            }
        }
        return (ab.a) invokeZ.objValue;
    }

    public r a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            if (this.f64898e == 1) {
                this.f64898e = 2;
                return new d(this, j2);
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
        return (r) invokeJ.objValue;
    }

    public com.bytedance.sdk.component.b.a.s a(com.bytedance.sdk.component.b.b.t tVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
            if (this.f64898e == 4) {
                this.f64898e = 5;
                return new c(this, tVar);
            }
            throw new IllegalStateException("state: " + this.f64898e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeL.objValue;
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            t a2 = iVar.a();
            iVar.a(t.f64760c);
            a2.f();
            a2.e();
        }
    }
}
