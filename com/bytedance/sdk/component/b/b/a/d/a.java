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
/* loaded from: classes6.dex */
public final class a implements com.bytedance.sdk.component.b.b.a.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final w f28149a;

    /* renamed from: b  reason: collision with root package name */
    public final g f28150b;

    /* renamed from: c  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.e f28151c;

    /* renamed from: d  reason: collision with root package name */
    public final com.bytedance.sdk.component.b.a.d f28152d;

    /* renamed from: e  reason: collision with root package name */
    public int f28153e;

    /* renamed from: f  reason: collision with root package name */
    public long f28154f;

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.bytedance.sdk.component.b.b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public abstract class AbstractC0318a implements s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final i f28155a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28156b;

        /* renamed from: c  reason: collision with root package name */
        public long f28157c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f28158d;

        public AbstractC0318a(a aVar) {
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
            this.f28158d = aVar;
            this.f28155a = new i(this.f28158d.f28151c.a());
            this.f28157c = 0L;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28155a : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                try {
                    long a2 = this.f28158d.f28151c.a(cVar, j);
                    if (a2 > 0) {
                        this.f28157c += a2;
                    }
                    return a2;
                } catch (IOException e2) {
                    a(false, e2);
                    throw e2;
                }
            }
            return invokeLJ.longValue;
        }

        public /* synthetic */ AbstractC0318a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, iOException) == null) || (i2 = (aVar = this.f28158d).f28153e) == 6) {
                return;
            }
            if (i2 == 5) {
                aVar.a(this.f28155a);
                a aVar2 = this.f28158d;
                aVar2.f28153e = 6;
                g gVar = aVar2.f28150b;
                if (gVar != null) {
                    gVar.a(!z, aVar2, this.f28157c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + this.f28158d.f28153e);
        }
    }

    /* loaded from: classes6.dex */
    public final class b implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28159a;

        /* renamed from: b  reason: collision with root package name */
        public final i f28160b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28161c;

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
            this.f28159a = aVar;
            this.f28160b = new i(this.f28159a.f28152d.a());
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28160b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (this.f28161c) {
                    throw new IllegalStateException("closed");
                }
                if (j == 0) {
                    return;
                }
                this.f28159a.f28152d.k(j);
                this.f28159a.f28152d.b(Part.CRLF);
                this.f28159a.f28152d.a_(cVar, j);
                this.f28159a.f28152d.b(Part.CRLF);
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this) {
                    if (this.f28161c) {
                        return;
                    }
                    this.f28161c = true;
                    this.f28159a.f28152d.b("0\r\n\r\n");
                    this.f28159a.a(this.f28160b);
                    this.f28159a.f28153e = 3;
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this) {
                    if (this.f28161c) {
                        return;
                    }
                    this.f28159a.f28152d.flush();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AbstractC0318a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28162e;

        /* renamed from: f  reason: collision with root package name */
        public final com.bytedance.sdk.component.b.b.t f28163f;

        /* renamed from: g  reason: collision with root package name */
        public long f28164g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f28165h;

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
            this.f28162e = aVar;
            this.f28164g = -1L;
            this.f28165h = true;
            this.f28163f = tVar;
        }

        private void b() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                if (this.f28164g != -1) {
                    this.f28162e.f28151c.p();
                }
                try {
                    this.f28164g = this.f28162e.f28151c.m();
                    String trim = this.f28162e.f28151c.p().trim();
                    if (this.f28164g >= 0 && (trim.isEmpty() || trim.startsWith(";"))) {
                        if (this.f28164g == 0) {
                            this.f28165h = false;
                            com.bytedance.sdk.component.b.b.a.c.e.a(this.f28162e.f28149a.f(), this.f28163f, this.f28162e.d());
                            a(true, (IOException) null);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f28164g + trim + "\"");
                } catch (NumberFormatException e2) {
                    throw new ProtocolException(e2.getMessage());
                }
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0318a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28156b) {
                        if (this.f28165h) {
                            long j2 = this.f28164g;
                            if (j2 == 0 || j2 == -1) {
                                b();
                                if (!this.f28165h) {
                                    return -1L;
                                }
                            }
                            long a2 = super.a(cVar, Math.min(j, this.f28164g));
                            if (a2 != -1) {
                                this.f28164g -= a2;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28156b) {
                return;
            }
            if (this.f28165h && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f28156b = true;
        }
    }

    /* loaded from: classes6.dex */
    public final class d implements r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f28166a;

        /* renamed from: b  reason: collision with root package name */
        public final i f28167b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f28168c;

        /* renamed from: d  reason: collision with root package name */
        public long f28169d;

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
            this.f28166a = aVar;
            this.f28167b = new i(this.f28166a.f28152d.a());
            this.f28169d = j;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public t a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28167b : (t) invokeV.objValue;
        }

        @Override // com.bytedance.sdk.component.b.a.r
        public void a_(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, j) == null) {
                if (!this.f28168c) {
                    com.bytedance.sdk.component.b.b.a.c.a(cVar.b(), 0L, j);
                    if (j <= this.f28169d) {
                        this.f28166a.f28152d.a_(cVar, j);
                        this.f28169d -= j;
                        return;
                    }
                    throw new ProtocolException("expected " + this.f28169d + " bytes but received " + j);
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f28168c) {
                return;
            }
            this.f28168c = true;
            if (this.f28169d <= 0) {
                this.f28166a.a(this.f28167b);
                this.f28166a.f28153e = 3;
                return;
            }
            throw new ProtocolException("unexpected end of stream");
        }

        @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f28168c) {
                return;
            }
            this.f28166a.f28152d.flush();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends AbstractC0318a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28170e;

        /* renamed from: f  reason: collision with root package name */
        public long f28171f;

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
            this.f28170e = aVar;
            this.f28171f = j;
            if (j == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0318a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28156b) {
                        long j2 = this.f28171f;
                        if (j2 == 0) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, Math.min(j2, j));
                        if (a2 != -1) {
                            long j3 = this.f28171f - a2;
                            this.f28171f = j3;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28156b) {
                return;
            }
            if (this.f28171f != 0 && !com.bytedance.sdk.component.b.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f28156b = true;
        }
    }

    /* loaded from: classes6.dex */
    public class f extends AbstractC0318a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28172e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f28173f;

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
            this.f28172e = aVar;
        }

        @Override // com.bytedance.sdk.component.b.b.a.d.a.AbstractC0318a, com.bytedance.sdk.component.b.a.s
        public long a(com.bytedance.sdk.component.b.a.c cVar, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, cVar, j)) == null) {
                if (j >= 0) {
                    if (!this.f28156b) {
                        if (this.f28173f) {
                            return -1L;
                        }
                        long a2 = super.a(cVar, j);
                        if (a2 == -1) {
                            this.f28173f = true;
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
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f28156b) {
                return;
            }
            if (!this.f28173f) {
                a(false, (IOException) null);
            }
            this.f28156b = true;
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
        this.f28153e = 0;
        this.f28154f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        this.f28149a = wVar;
        this.f28150b = gVar;
        this.f28151c = eVar;
        this.f28152d = dVar;
    }

    private String g() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            String e2 = this.f28151c.e(this.f28154f);
            this.f28154f -= e2.length();
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
            this.f28152d.flush();
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void c() {
        com.bytedance.sdk.component.b.b.a.b.c b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (b2 = this.f28150b.b()) == null) {
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
                com.bytedance.sdk.component.b.b.a.a.f28036a.a(aVar, g2);
            } else {
                return aVar.a();
            }
        }
    }

    public r e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f28153e == 1) {
                this.f28153e = 2;
                return new b(this);
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
        return (r) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f28153e == 4) {
                g gVar = this.f28150b;
                if (gVar != null) {
                    this.f28153e = 5;
                    gVar.d();
                    return new f(this);
                }
                throw new IllegalStateException("streamAllocation == null");
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeV.objValue;
    }

    public com.bytedance.sdk.component.b.a.s b(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            if (this.f28153e == 4) {
                this.f28153e = 5;
                return new e(this, j);
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeJ.objValue;
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public void a(z zVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zVar) == null) {
            a(zVar.c(), com.bytedance.sdk.component.b.b.a.c.i.a(zVar, this.f28150b.b().a().b().type()));
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ac a(ab abVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, abVar)) == null) {
            g gVar = this.f28150b;
            gVar.f28104c.f(gVar.f28103b);
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
            this.f28152d.flush();
        }
    }

    public void a(com.bytedance.sdk.component.b.b.s sVar, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, sVar, str) == null) {
            if (this.f28153e == 0) {
                this.f28152d.b(str).b(Part.CRLF);
                int a2 = sVar.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    this.f28152d.b(sVar.a(i2)).b(": ").b(sVar.b(i2)).b(Part.CRLF);
                }
                this.f28152d.b(Part.CRLF);
                this.f28153e = 1;
                return;
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
    }

    @Override // com.bytedance.sdk.component.b.b.a.c.c
    public ab.a a(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            int i2 = this.f28153e;
            if (i2 != 1 && i2 != 3) {
                throw new IllegalStateException("state: " + this.f28153e);
            }
            try {
                k a2 = k.a(g());
                ab.a a3 = new ab.a().a(a2.f28146a).a(a2.f28147b).a(a2.f28148c).a(d());
                if (z && a2.f28147b == 100) {
                    return null;
                }
                this.f28153e = 4;
                return a3;
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.f28150b);
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
            if (this.f28153e == 1) {
                this.f28153e = 2;
                return new d(this, j);
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
        return (r) invokeJ.objValue;
    }

    public com.bytedance.sdk.component.b.a.s a(com.bytedance.sdk.component.b.b.t tVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar)) == null) {
            if (this.f28153e == 4) {
                this.f28153e = 5;
                return new c(this, tVar);
            }
            throw new IllegalStateException("state: " + this.f28153e);
        }
        return (com.bytedance.sdk.component.b.a.s) invokeL.objValue;
    }

    public void a(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iVar) == null) {
            t a2 = iVar.a();
            iVar.a(t.f28022c);
            a2.f();
            a2.e();
        }
    }
}
