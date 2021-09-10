package com.baidu.turbonet.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import com.baidu.turbonet.base.annotations.NativeClassQualifiedName;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
@JNINamespace
/* loaded from: classes8.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f59327a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f59328b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f59329c;

    /* renamed from: d  reason: collision with root package name */
    public long f59330d;

    /* renamed from: e  reason: collision with root package name */
    public long f59331e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f59332f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f59333g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f59334h;
    @GuardedBy("mLock")

    /* renamed from: i  reason: collision with root package name */
    public long f59335i;
    @GuardedBy("mLock")

    /* renamed from: j  reason: collision with root package name */
    public UserCallback f59336j;
    @GuardedBy("mLock")
    public boolean k;
    public Runnable l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class UserCallback {
        public static final /* synthetic */ UserCallback[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UserCallback GET_LENGTH;
        public static final UserCallback NOT_IN_CALLBACK;
        public static final UserCallback READ;
        public static final UserCallback REWIND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(637213987, "Lcom/baidu/turbonet/net/CronetUploadDataStream$UserCallback;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(637213987, "Lcom/baidu/turbonet/net/CronetUploadDataStream$UserCallback;");
                    return;
                }
            }
            READ = new UserCallback("READ", 0);
            REWIND = new UserCallback("REWIND", 1);
            GET_LENGTH = new UserCallback("GET_LENGTH", 2);
            UserCallback userCallback = new UserCallback("NOT_IN_CALLBACK", 3);
            NOT_IN_CALLBACK = userCallback;
            $VALUES = new UserCallback[]{READ, REWIND, GET_LENGTH, userCallback};
        }

        public UserCallback(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static UserCallback valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UserCallback) Enum.valueOf(UserCallback.class, str) : (UserCallback) invokeL.objValue;
        }

        public static UserCallback[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UserCallback[]) $VALUES.clone() : (UserCallback[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f59337e;

        public a(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59337e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f59337e.f59334h) {
                    if (this.f59337e.f59335i == 0) {
                        return;
                    }
                    this.f59337e.l(UserCallback.NOT_IN_CALLBACK);
                    if (this.f59337e.f59333g != null) {
                        this.f59337e.f59336j = UserCallback.READ;
                        try {
                            this.f59337e.f59328b.h(this.f59337e, this.f59337e.f59333g);
                            return;
                        } catch (Exception e2) {
                            this.f59337e.p(e2);
                            return;
                        }
                    }
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f59338e;

        public b(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59338e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f59338e.f59334h) {
                    if (this.f59338e.f59335i == 0) {
                        return;
                    }
                    this.f59338e.l(UserCallback.NOT_IN_CALLBACK);
                    this.f59338e.f59336j = UserCallback.REWIND;
                    try {
                        this.f59338e.f59328b.i(this.f59338e);
                    } catch (Exception e2) {
                        this.f59338e.p(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f59339e;

        public c(CronetUploadDataStream cronetUploadDataStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetUploadDataStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59339e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f59339e.f59328b.close();
                } catch (IOException unused) {
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59332f = new a(this);
        this.f59333g = null;
        this.f59334h = new Object();
        this.f59335i = 0L;
        this.f59336j = UserCallback.NOT_IN_CALLBACK;
        this.k = false;
        this.f59327a = executor;
        this.f59328b = uploadDataProvider;
        this.f59329c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j2, long j3);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j2, long j3);

    @NativeClassQualifiedName
    public static native void nativeDestroy(long j2);

    @NativeClassQualifiedName
    private native void nativeOnReadSucceeded(long j2, int i2, boolean z);

    @NativeClassQualifiedName
    private native void nativeOnRewindSucceeded(long j2);

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f59334h) {
                l(UserCallback.REWIND);
                this.f59336j = UserCallback.NOT_IN_CALLBACK;
                this.f59331e = this.f59330d;
                if (this.f59335i == 0) {
                    return;
                }
                nativeOnRewindSucceeded(this.f59335i);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f59334h) {
                l(UserCallback.REWIND);
                p(exc);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.f59334h) {
                l(UserCallback.READ);
                if (z && this.f59330d >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.f59333g.position();
                long j2 = this.f59331e - position;
                this.f59331e = j2;
                if (j2 < 0 && this.f59330d >= 0) {
                    throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f59330d - this.f59331e), Long.valueOf(this.f59330d)));
                }
                this.f59333g = null;
                this.f59336j = UserCallback.NOT_IN_CALLBACK;
                n();
                if (this.f59335i == 0) {
                    return;
                }
                nativeOnReadSucceeded(this.f59335i, position, z);
            }
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            synchronized (this.f59334h) {
                this.f59335i = nativeAttachUploadDataToRequest(j2, this.f59330d);
            }
        }
    }

    @GuardedBy("mLock")
    public final void l(UserCallback userCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, userCallback) == null) || this.f59336j == userCallback) {
            return;
        }
        throw new IllegalStateException("Expected " + userCallback + ", but was " + this.f59336j);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f59334h) {
                if (this.f59336j == UserCallback.READ) {
                    this.k = true;
                } else if (this.f59335i == 0) {
                } else {
                    nativeDestroy(this.f59335i);
                    this.f59335i = 0L;
                    if (this.l != null) {
                        this.l.run();
                    }
                    q(new c(this));
                }
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this.f59334h) {
                if (this.f59336j != UserCallback.READ) {
                    if (this.k) {
                        m();
                    }
                } else {
                    throw new IllegalStateException("Method should not be called when read has not completed.");
                }
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.f59334h) {
                this.f59336j = UserCallback.GET_LENGTH;
            }
            try {
                long g2 = this.f59328b.g();
                this.f59330d = g2;
                this.f59331e = g2;
            } catch (Throwable th) {
                p(th);
            }
            synchronized (this.f59334h) {
                this.f59336j = UserCallback.NOT_IN_CALLBACK;
            }
        }
    }

    @CalledByNative
    public void onUploadDataStreamDestroyed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            m();
        }
    }

    public final void p(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, th) == null) {
            synchronized (this.f59334h) {
                if (this.f59336j != UserCallback.NOT_IN_CALLBACK) {
                    this.f59336j = UserCallback.NOT_IN_CALLBACK;
                    this.f59333g = null;
                    n();
                } else {
                    throw new IllegalStateException("There is no read or rewind or length check in progress.");
                }
            }
            this.f59329c.E(th);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            try {
                this.f59327a.execute(runnable);
            } catch (Throwable th) {
                this.f59329c.E(th);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            this.f59333g = byteBuffer;
            q(this.f59332f);
        }
    }

    @CalledByNative
    public void rewind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            q(new b(this));
        }
    }
}
