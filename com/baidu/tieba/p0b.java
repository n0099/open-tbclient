package com.baidu.tieba;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class p0b extends UploadDataSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger a;
    public final Executor b;
    public final Executor c;
    public final UploadDataProvider d;
    public ByteBuffer e;
    public long f;
    public long g;

    public abstract void o() throws IOException;

    public abstract Runnable p(s0b s0bVar);

    public abstract Runnable q(s0b s0bVar);

    public abstract void r() throws IOException;

    public abstract void s(long j);

    public abstract int t(ByteBuffer byteBuffer) throws IOException;

    public abstract void u(Throwable th);

    /* loaded from: classes7.dex */
    public class b implements s0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ p0b b;

        /* loaded from: classes7.dex */
        public class a implements s0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.s0b
            public void run() throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UploadDataProvider uploadDataProvider = this.a.b.d;
                    p0b p0bVar = this.a.b;
                    uploadDataProvider.b(p0bVar, p0bVar.e);
                }
            }
        }

        public b(p0b p0bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.s0b
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.e.flip();
                if (this.b.f != -1 && this.b.f - this.b.g < this.b.e.remaining()) {
                    this.b.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", Long.valueOf(this.b.g + this.b.e.remaining()), Long.valueOf(this.b.f))));
                    return;
                }
                p0b p0bVar = this.b;
                p0b.i(p0bVar, p0bVar.t(p0bVar.e));
                if (this.b.g >= this.b.f && (this.b.f != -1 || this.a)) {
                    if (this.b.f == -1) {
                        this.b.o();
                        return;
                    } else if (this.b.f == this.b.g) {
                        this.b.o();
                        return;
                    } else {
                        this.b.u(new IllegalArgumentException(String.format(Locale.getDefault(), "Read upload data length %d exceeds expected length %d", Long.valueOf(this.b.g), Long.valueOf(this.b.f))));
                        return;
                    }
                }
                this.b.e.clear();
                this.b.a.set(0);
                this.b.n(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements s0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p0b a;

        /* loaded from: classes7.dex */
        public class a implements s0b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.s0b
            public void run() throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    UploadDataProvider uploadDataProvider = this.a.a.d;
                    p0b p0bVar = this.a.a;
                    uploadDataProvider.b(p0bVar, p0bVar.e);
                }
            }
        }

        public c(p0b p0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p0bVar;
        }

        @Override // com.baidu.tieba.s0b
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r();
                this.a.a.set(0);
                this.a.n(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Executor a;
        public final /* synthetic */ p0b b;

        public a(p0b p0bVar, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = executor;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
                try {
                    this.a.execute(runnable);
                } catch (RejectedExecutionException e) {
                    this.b.u(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements s0b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ p0b b;

        public d(p0b p0bVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p0bVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p0bVar;
            this.a = z;
        }

        @Override // com.baidu.tieba.s0b
        public void run() throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p0b p0bVar = this.b;
                p0bVar.f = p0bVar.d.a();
                if (this.b.f == 0) {
                    this.b.o();
                    return;
                }
                if (this.b.f > 0 && this.b.f < PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                    p0b p0bVar2 = this.b;
                    p0bVar2.e = ByteBuffer.allocateDirect(((int) p0bVar2.f) + 1);
                } else {
                    this.b.e = ByteBuffer.allocateDirect(8192);
                }
                p0b p0bVar3 = this.b;
                p0bVar3.s(p0bVar3.f);
                if (this.a) {
                    this.b.w();
                    return;
                }
                this.b.a.set(1);
                this.b.d.c(this.b);
            }
        }
    }

    public p0b(Executor executor, Executor executor2, UploadDataProvider uploadDataProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executor, executor2, uploadDataProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger(3);
        this.b = new a(this, executor);
        this.c = executor2;
        this.d = uploadDataProvider;
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            u(exc);
        }
    }

    public final void n(s0b s0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s0bVar) == null) {
            try {
                this.b.execute(q(s0bVar));
            } catch (RejectedExecutionException e) {
                u(e);
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            n(new d(this, z));
        }
    }

    public static /* synthetic */ long i(p0b p0bVar, long j) {
        long j2 = p0bVar.g + j;
        p0bVar.g = j2;
        return j2;
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (this.a.compareAndSet(0, 2)) {
                this.c.execute(p(new b(this, z)));
                return;
            }
            throw new IllegalStateException("onReadSucceeded() called when not awaiting a read result; in state: " + this.a.get());
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.a.compareAndSet(1, 2)) {
                w();
                return;
            }
            throw new IllegalStateException("onRewindSucceeded() called when not awaiting a rewind; in state: " + this.a.get());
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.execute(p(new c(this)));
        }
    }
}
