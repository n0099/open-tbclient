package com.baidu.turbonet.net.impl;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.UploadDataProvider;
import com.baidu.turbonet.net.UploadDataSink;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
@JNINamespace("cronet")
@VisibleForTesting
/* loaded from: classes9.dex */
public final class CronetUploadDataStream extends UploadDataSink {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String n = "CronetUploadDataStream";
    public transient /* synthetic */ FieldHolder $fh;
    public final Executor a;
    public final VersionSafeCallbacks.g b;
    public final CronetUrlRequest c;
    public long d;
    public long e;
    public long f;
    public final Runnable g;
    public ByteBuffer h;
    public final Object i;
    @GuardedBy("mLock")
    public long j;
    @GuardedBy("mLock")
    public int k;
    @GuardedBy("mLock")
    public boolean l;
    public Runnable m;

    /* loaded from: classes9.dex */
    public interface d {
        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void a(long j, CronetUploadDataStream cronetUploadDataStream);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void b(long j, CronetUploadDataStream cronetUploadDataStream, int i, boolean z);

        long c(CronetUploadDataStream cronetUploadDataStream, long j, long j2);

        @NativeClassQualifiedName("CronetUploadDataStreamAdapter")
        void destroy(long j);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2043737896, "Lcom/baidu/turbonet/net/impl/CronetUploadDataStream;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2043737896, "Lcom/baidu/turbonet/net/impl/CronetUploadDataStream;");
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUploadDataStream a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1232082821, "Lcom/baidu/turbonet/net/impl/CronetUploadDataStream$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1232082821, "Lcom/baidu/turbonet/net/impl/CronetUploadDataStream$a;");
            }
        }

        public a(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.i) {
                    if (this.a.j == 0) {
                        return;
                    }
                    this.a.o(3);
                    if (this.a.h == null) {
                        throw new IllegalStateException("Unexpected readData call. Buffer is null");
                    }
                    this.a.k = 0;
                    try {
                        this.a.n();
                        this.a.b.b(this.a, this.a.h);
                    } catch (Exception e) {
                        this.a.s(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUploadDataStream a;

        public b(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.i) {
                    if (this.a.j == 0) {
                        return;
                    }
                    this.a.o(3);
                    this.a.k = 1;
                    try {
                        this.a.n();
                        this.a.b.c(this.a);
                    } catch (Exception e) {
                        this.a.s(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetUploadDataStream a;

        public c(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.n();
                    this.a.b.close();
                } catch (Exception e) {
                    Log.e(CronetUploadDataStream.n, "Exception thrown when closing", e);
                }
            }
        }
    }

    public CronetUploadDataStream(UploadDataProvider uploadDataProvider, Executor executor, CronetUrlRequest cronetUrlRequest) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uploadDataProvider, executor, cronetUrlRequest};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.i = new Object();
        this.k = 3;
        this.a = executor;
        this.b = new VersionSafeCallbacks.g(uploadDataProvider);
        this.c = cronetUrlRequest;
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.i) {
                o(1);
                s(exc);
            }
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            synchronized (this.i) {
                this.j = h0b.d().c(this, j, this.d);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, byteBuffer) == null) {
            this.h = byteBuffer;
            this.f = byteBuffer.limit();
            t(this.g);
        }
    }

    public void t(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, runnable) == null) {
            try {
                this.a.execute(runnable);
            } catch (Throwable th) {
                this.c.P(th);
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.F();
        }
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            p();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.i) {
                if (this.k != 0) {
                    if (this.l) {
                        p();
                    }
                } else {
                    throw new IllegalStateException("Method should not be called when read has not completed.");
                }
            }
        }
    }

    @CalledByNative
    public void rewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            t(new b(this));
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    @SuppressLint({"DefaultLocale"})
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            synchronized (this.i) {
                o(0);
                if (this.f == this.h.limit()) {
                    if (z && this.d >= 0) {
                        throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                    }
                    int position = this.h.position();
                    long j = this.e - position;
                    this.e = j;
                    if (j < 0 && this.d >= 0) {
                        throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.d - this.e), Long.valueOf(this.d)));
                    }
                    this.h.position(0);
                    this.h = null;
                    this.k = 3;
                    q();
                    if (this.j == 0) {
                        return;
                    }
                    h0b.d().b(this.j, this, position, z);
                    return;
                }
                throw new IllegalStateException("ByteBuffer limit changed");
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this.i) {
                o(1);
                this.k = 3;
                this.e = this.d;
                if (this.j == 0) {
                    return;
                }
                h0b.d().a(this.j, this);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.i) {
                if (this.k == 0) {
                    this.l = true;
                } else if (this.j == 0) {
                } else {
                    h0b.d().destroy(this.j);
                    this.j = 0L;
                    if (this.m != null) {
                        this.m.run();
                    }
                    t(new c(this));
                }
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.i) {
                this.k = 2;
            }
            try {
                this.c.F();
                long a2 = this.b.a();
                this.d = a2;
                this.e = a2;
            } catch (Throwable th) {
                s(th);
            }
            synchronized (this.i) {
                this.k = 3;
            }
        }
    }

    @GuardedBy("mLock")
    public final void o(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.k == i) {
            return;
        }
        throw new IllegalStateException("Expected " + i + ", but was " + this.k);
    }

    public final void s(Throwable th) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, th) == null) {
            synchronized (this.i) {
                if (this.k != 3) {
                    if (this.k == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.k = 3;
                    this.h = null;
                    q();
                } else {
                    throw new IllegalStateException("There is no read or rewind or length check in progress.");
                }
            }
            if (z) {
                try {
                    this.b.close();
                } catch (Exception e) {
                    Log.e(n, "Failure closing data provider", e);
                }
            }
            this.c.P(th);
        }
    }
}
