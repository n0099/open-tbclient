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
/* loaded from: classes5.dex */
public final class a implements com.bytedance.sdk.component.b.b.a.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28353a;

    /* renamed from: b  reason: collision with root package name */
    public final g f28354b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.e f28355c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.d f28356d;

    /* renamed from: e  reason: collision with root package name */
    public int f28357e;

    /* renamed from: f  reason: collision with root package name */
    public long f28358f;

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public abstract class AbstractC0320a implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final i f28359a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28360b;

        /* renamed from: c  reason: collision with root package name */
        public long f28361c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f28362d;

        public AbstractC0320a(a aVar) {
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
            this.f28362d = aVar;
            this.f28359a = new i(this.f28362d.f28355c.a());
            this.f28361c = 0L;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28359a : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                try {
                    long a2 = this.f28362d.f28355c.a(cVar, j);
                    if (a2 > 0) {
                        this.f28361c += a2;
                    }
                    return a2;
                } catch (IOException e2) {
                    a(false, e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        public /* synthetic */ AbstractC0320a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, iOException) == null) || (i2 = (aVar = this.f28362d).f28357e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.a(this.f28359a);
                a aVar2 = this.f28362d;
                aVar2.f28357e = 6;
                g gVar = aVar2.f28354b;
                if (gVar != null) {
                    gVar.a(!z, aVar2, this.f28361c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f28362d.f28357e);
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28363a;

        /* renamed from: b  reason: collision with root package name */
        public final i f28364b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28365c;

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
            this.f28363a = aVar;
            this.f28364b = new i(this.f28363a.f28356d.a());
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28364b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (this.f28365c) {
                    throw new IllegalStateException("closed");
                }
                if (j == 0) {
                    return;
                }
                this.f28363a.f28356d.k(j);
                this.f28363a.f28356d.b(Part.CRLF);
                this.f28363a.f28356d.a_(cVar, j);
                this.f28363a.f28356d.b(Part.CRLF);
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.f28365c) {
                        return;
                    }
                    this.f28365c = true;
                    this.f28363a.f28356d.b("0\r\n\r\n");
                    this.f28363a.a(this.f28364b);
                    this.f28363a.f28357e = 3;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    if (this.f28365c) {
                        return;
                    }
                    this.f28363a.f28356d.flush();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends AbstractC0320a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28366e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.b.t f28367f;

        /* renamed from: g  reason: collision with root package name */
        public long f28368g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28369h;

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
            this.f28366e = aVar;
            this.f28368g = -1L;
            this.f28369h = true;
            this.f28367f = tVar;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.f28368g != -1) {
                    this.f28366e.f28355c.p();
                }
                try {
                    this.f28368g = this.f28366e.f28355c.m();
                    String trim = this.f28366e.f28355c.p().trim();
                    if (this.f28368g >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.f28368g == 0) {
                            this.f28369h = false;
                            com.bytedance.sdk.component.b.b.a.c.e.a(this.f28366e.f28353a.f(), this.f28367f, this.f28366e.d());
                            a(true, (IOException) null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f28368g + trim + "\"");
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0320a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28360b) {
                        if (this.f28369h) {
                            long j2 = this.f28368g;
                            if (j2 == 0 || j2 == -1) {
                                b();
                                if (!this.f28369h) {
                                    return -1L;
                                }
                            }
                            long a2 = super.a(cVar, Math.min(j, this.f28368g));
                            if (a2 != -1) {
                                this.f28368g -= a2;
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
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28360b) {
                return;
            }
            if (this.f28369h && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f28360b = true;
        }
    }

    /* loaded from: classes5.dex */
    public final class d implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28370a;

        /* renamed from: b  reason: collision with root package name */
        public final i f28371b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28372c;

        /* renamed from: d  reason: collision with root package name */
        public long f28373d;

        public d(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28370a = aVar;
            this.f28371b = new i(this.f28370a.f28356d.a());
            this.f28373d = j;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28371b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (!this.f28372c) {
                    com.bytedance.sdk.component.b.b.a.c.a(cVar.b(), 0L, j);
                    if (j <= this.f28373d) {
                        this.f28370a.f28356d.a_(cVar, j);
                        this.f28373d -= j;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f28373d + " bytes but received " + j);
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f28372c) {
                return;
            }
            this.f28372c = true;
            if (this.f28373d <= 0) {
                this.f28370a.a(this.f28371b);
                this.f28370a.f28357e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f28372c) {
                return;
            }
            this.f28370a.f28356d.flush();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends AbstractC0320a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28374e;

        /* renamed from: f  reason: collision with root package name */
        public long f28375f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a aVar, long j) throws IOException {
            super(aVar, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
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
            this.f28374e = aVar;
            this.f28375f = j;
            if (j == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0320a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28360b) {
                        long j2 = this.f28375f;
                        if (j2 == 0) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, Math.min(j2, j));
                        if (a2 != -1) {
                            long j3 = this.f28375f - a2;
                            this.f28375f = j3;
                            if (j3 == 0) {
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
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28360b) {
                return;
            }
            if (this.f28375f != 0 && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f28360b = true;
        }
    }

    /* loaded from: classes5.dex */
    public class f extends AbstractC0320a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28376e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28377f;

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
            this.f28376e = aVar;
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0320a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28360b) {
                        if (this.f28377f) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, j);
                        if (a2 == -1) {
                            this.f28377f = true;
                            a(true, (IOException) null);
                            return -1L;
                        }
                        return a2;
                    }
                    throw new IllegalStateException("closed");
                }
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            return invokeLJ.longValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28360b) {
                return;
            }
            if (!this.f28377f) {
                a(false, (IOException) null);
            }
            this.f28360b = true;
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
        this.f28357e = 0;
        this.f28358f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f28353a = wVar;
        this.f28354b = gVar;
        this.f28355c = eVar;
        this.f28356d = dVar;
    }

    private String g() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String e2 = this.f28355c.e(this.f28358f);
            this.f28358f -= e2.length();
            return e2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public r a(z zVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zVar, j)) == null) {
            if ("chunked".equalsIgnoreCase(zVar.a("Transfer-Encoding"))) {
                return e();
            }
            if (j != -1) {
                return a(j);
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return (r) invokeLJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void b() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f28356d.flush();
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void c() {
        com.bytedance.sdk.component.b.b.a.b.c b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (b2 = this.f28354b.b()) == null) {
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
                com.bytedance.sdk.component.b.b.a.a.f28240a.a(aVar, g2);
            } else {
                return aVar.a();
            }
        }
    }

    public r e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f28357e == 1) {
                this.f28357e = 2;
                return new b(this);
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
        return (r) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f28357e == 4) {
                g gVar = this.f28354b;
                if (gVar != null) {
                    this.f28357e = 5;
                    gVar.d();
                    return new f(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s b(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.f28357e == 4) {
                this.f28357e = 5;
                return new e(this, j);
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            a(zVar.c(), com.bytedance.sdk.component.b.b.a.c.i.a(zVar, this.f28354b.b().a().b().type()));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ac a(ab abVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, abVar)) == null) {
            g gVar = this.f28354b;
            gVar.f28308c.f(gVar.f28307b);
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
            this.f28356d.flush();
        }
    }

    public void a(com.bytedance.sdk.component.b.b.s sVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, sVar, str) == null) {
            if (this.f28357e == 0) {
                this.f28356d.b(str).b(Part.CRLF);
                int a2 = sVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    this.f28356d.b(sVar.a(i2)).b(": ").b(sVar.b(i2)).b(Part.CRLF);
                }
                this.f28356d.b(Part.CRLF);
                this.f28357e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ab.a a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            int i2 = this.f28357e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f28357e);
            }
            try {
                k a2 = k.a(g());
                ab.a a3 = new ab.a().a(a2.f28350a).a(a2.f28351b).a(a2.f28352c).a(d());
                if (z && a2.f28351b == 100) {
                    return null;
                }
                this.f28357e = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f28354b);
                iOException.initCause(e2);
                throw iOException;
            }
        }
        return (ab.a) invokeZ.objValue;
    }

    public r a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            if (this.f28357e == 1) {
                this.f28357e = 2;
                return new d(this, j);
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
        return (r) invokeJ.objValue;
    }

    public com.bytedance.sdk.component.b.a.s a(com.bytedance.sdk.component.b.b.t tVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
            if (this.f28357e == 4) {
                this.f28357e = 5;
                return new c(this, tVar);
            }
            throw new IllegalStateException("state: " + this.f28357e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeL.objValue;
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            t a2 = iVar.a();
            iVar.a(t.f28226c);
            a2.f();
            a2.e();
        }
    }
}
