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
/* loaded from: classes7.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f58947a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f58948b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f58949c;

    /* renamed from: d  reason: collision with root package name */
    public long f58950d;

    /* renamed from: e  reason: collision with root package name */
    public long f58951e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f58952f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f58953g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f58954h;
    @GuardedBy("mLock")

    /* renamed from: i  reason: collision with root package name */
    public long f58955i;
    @GuardedBy("mLock")

    /* renamed from: j  reason: collision with root package name */
    public UserCallback f58956j;
    @GuardedBy("mLock")
    public boolean k;
    public Runnable l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f58957e;

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
            this.f58957e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f58957e.f58954h) {
                    if (this.f58957e.f58955i == 0) {
                        return;
                    }
                    this.f58957e.l(UserCallback.NOT_IN_CALLBACK);
                    if (this.f58957e.f58953g != null) {
                        this.f58957e.f58956j = UserCallback.READ;
                        try {
                            this.f58957e.f58948b.h(this.f58957e, this.f58957e.f58953g);
                            return;
                        } catch (Exception e2) {
                            this.f58957e.p(e2);
                            return;
                        }
                    }
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f58958e;

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
            this.f58958e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f58958e.f58954h) {
                    if (this.f58958e.f58955i == 0) {
                        return;
                    }
                    this.f58958e.l(UserCallback.NOT_IN_CALLBACK);
                    this.f58958e.f58956j = UserCallback.REWIND;
                    try {
                        this.f58958e.f58948b.i(this.f58958e);
                    } catch (Exception e2) {
                        this.f58958e.p(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f58959e;

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
            this.f58959e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f58959e.f58948b.close();
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
        this.f58952f = new a(this);
        this.f58953g = null;
        this.f58954h = new Object();
        this.f58955i = 0L;
        this.f58956j = UserCallback.NOT_IN_CALLBACK;
        this.k = false;
        this.f58947a = executor;
        this.f58948b = uploadDataProvider;
        this.f58949c = cronetUrlRequest;
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
            synchronized (this.f58954h) {
                l(UserCallback.REWIND);
                this.f58956j = UserCallback.NOT_IN_CALLBACK;
                this.f58951e = this.f58950d;
                if (this.f58955i == 0) {
                    return;
                }
                nativeOnRewindSucceeded(this.f58955i);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f58954h) {
                l(UserCallback.REWIND);
                p(exc);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.f58954h) {
                l(UserCallback.READ);
                if (z && this.f58950d >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.f58953g.position();
                long j2 = this.f58951e - position;
                this.f58951e = j2;
                if (j2 < 0 && this.f58950d >= 0) {
                    throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f58950d - this.f58951e), Long.valueOf(this.f58950d)));
                }
                this.f58953g = null;
                this.f58956j = UserCallback.NOT_IN_CALLBACK;
                n();
                if (this.f58955i == 0) {
                    return;
                }
                nativeOnReadSucceeded(this.f58955i, position, z);
            }
        }
    }

    public void k(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            synchronized (this.f58954h) {
                this.f58955i = nativeAttachUploadDataToRequest(j2, this.f58950d);
            }
        }
    }

    @GuardedBy("mLock")
    public final void l(UserCallback userCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, userCallback) == null) || this.f58956j == userCallback) {
            return;
        }
        throw new IllegalStateException("Expected " + userCallback + ", but was " + this.f58956j);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f58954h) {
                if (this.f58956j == UserCallback.READ) {
                    this.k = true;
                } else if (this.f58955i == 0) {
                } else {
                    nativeDestroy(this.f58955i);
                    this.f58955i = 0L;
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
            synchronized (this.f58954h) {
                if (this.f58956j != UserCallback.READ) {
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
            synchronized (this.f58954h) {
                this.f58956j = UserCallback.GET_LENGTH;
            }
            try {
                long g2 = this.f58948b.g();
                this.f58950d = g2;
                this.f58951e = g2;
            } catch (Throwable th) {
                p(th);
            }
            synchronized (this.f58954h) {
                this.f58956j = UserCallback.NOT_IN_CALLBACK;
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
            synchronized (this.f58954h) {
                if (this.f58956j != UserCallback.NOT_IN_CALLBACK) {
                    this.f58956j = UserCallback.NOT_IN_CALLBACK;
                    this.f58953g = null;
                    n();
                } else {
                    throw new IllegalStateException("There is no read or rewind or length check in progress.");
                }
            }
            this.f58949c.E(th);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            try {
                this.f58947a.execute(runnable);
            } catch (Throwable th) {
                this.f58949c.E(th);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            this.f58953g = byteBuffer;
            q(this.f58952f);
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
