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
/* loaded from: classes10.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f56427a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f56428b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f56429c;

    /* renamed from: d  reason: collision with root package name */
    public long f56430d;

    /* renamed from: e  reason: collision with root package name */
    public long f56431e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f56432f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f56433g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f56434h;
    @GuardedBy("mLock")

    /* renamed from: i  reason: collision with root package name */
    public long f56435i;
    @GuardedBy("mLock")
    public UserCallback j;
    @GuardedBy("mLock")
    public boolean k;
    public Runnable l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f56436e;

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
            this.f56436e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f56436e.f56434h) {
                    if (this.f56436e.f56435i == 0) {
                        return;
                    }
                    this.f56436e.l(UserCallback.NOT_IN_CALLBACK);
                    if (this.f56436e.f56433g != null) {
                        this.f56436e.j = UserCallback.READ;
                        try {
                            this.f56436e.f56428b.b(this.f56436e, this.f56436e.f56433g);
                            return;
                        } catch (Exception e2) {
                            this.f56436e.p(e2);
                            return;
                        }
                    }
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f56437e;

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
            this.f56437e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f56437e.f56434h) {
                    if (this.f56437e.f56435i == 0) {
                        return;
                    }
                    this.f56437e.l(UserCallback.NOT_IN_CALLBACK);
                    this.f56437e.j = UserCallback.REWIND;
                    try {
                        this.f56437e.f56428b.c(this.f56437e);
                    } catch (Exception e2) {
                        this.f56437e.p(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f56438e;

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
            this.f56438e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f56438e.f56428b.close();
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
        this.f56432f = new a(this);
        this.f56433g = null;
        this.f56434h = new Object();
        this.f56435i = 0L;
        this.j = UserCallback.NOT_IN_CALLBACK;
        this.k = false;
        this.f56427a = executor;
        this.f56428b = uploadDataProvider;
        this.f56429c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j, long j2);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j, long j2);

    @NativeClassQualifiedName
    public static native void nativeDestroy(long j);

    @NativeClassQualifiedName
    private native void nativeOnReadSucceeded(long j, int i2, boolean z);

    @NativeClassQualifiedName
    private native void nativeOnRewindSucceeded(long j);

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.f56434h) {
                l(UserCallback.REWIND);
                this.j = UserCallback.NOT_IN_CALLBACK;
                this.f56431e = this.f56430d;
                if (this.f56435i == 0) {
                    return;
                }
                nativeOnRewindSucceeded(this.f56435i);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f56434h) {
                l(UserCallback.REWIND);
                p(exc);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.f56434h) {
                l(UserCallback.READ);
                if (z && this.f56430d >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.f56433g.position();
                long j = this.f56431e - position;
                this.f56431e = j;
                if (j < 0 && this.f56430d >= 0) {
                    throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f56430d - this.f56431e), Long.valueOf(this.f56430d)));
                }
                this.f56433g = null;
                this.j = UserCallback.NOT_IN_CALLBACK;
                n();
                if (this.f56435i == 0) {
                    return;
                }
                nativeOnReadSucceeded(this.f56435i, position, z);
            }
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            synchronized (this.f56434h) {
                this.f56435i = nativeAttachUploadDataToRequest(j, this.f56430d);
            }
        }
    }

    @GuardedBy("mLock")
    public final void l(UserCallback userCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, userCallback) == null) || this.j == userCallback) {
            return;
        }
        throw new IllegalStateException("Expected " + userCallback + ", but was " + this.j);
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this.f56434h) {
                if (this.j == UserCallback.READ) {
                    this.k = true;
                } else if (this.f56435i == 0) {
                } else {
                    nativeDestroy(this.f56435i);
                    this.f56435i = 0L;
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
            synchronized (this.f56434h) {
                if (this.j != UserCallback.READ) {
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
            synchronized (this.f56434h) {
                this.j = UserCallback.GET_LENGTH;
            }
            try {
                long a2 = this.f56428b.a();
                this.f56430d = a2;
                this.f56431e = a2;
            } catch (Throwable th) {
                p(th);
            }
            synchronized (this.f56434h) {
                this.j = UserCallback.NOT_IN_CALLBACK;
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
            synchronized (this.f56434h) {
                if (this.j != UserCallback.NOT_IN_CALLBACK) {
                    this.j = UserCallback.NOT_IN_CALLBACK;
                    this.f56433g = null;
                    n();
                } else {
                    throw new IllegalStateException("There is no read or rewind or length check in progress.");
                }
            }
            this.f56429c.E(th);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            try {
                this.f56427a.execute(runnable);
            } catch (Throwable th) {
                this.f56429c.E(th);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            this.f56433g = byteBuffer;
            q(this.f56432f);
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
