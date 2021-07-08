package com.baidu.turbonet.net;

import android.util.Log;
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
/* loaded from: classes4.dex */
public final class CronetUploadDataStream implements UploadDataSink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f23069a;

    /* renamed from: b  reason: collision with root package name */
    public final UploadDataProvider f23070b;

    /* renamed from: c  reason: collision with root package name */
    public final CronetUrlRequest f23071c;

    /* renamed from: d  reason: collision with root package name */
    public long f23072d;

    /* renamed from: e  reason: collision with root package name */
    public long f23073e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f23074f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f23075g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f23076h;
    @GuardedBy("mLock")

    /* renamed from: i  reason: collision with root package name */
    public long f23077i;
    @GuardedBy("mLock")
    public UserCallback j;
    @GuardedBy("mLock")
    public boolean k;
    public Runnable l;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f23078e;

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
            this.f23078e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f23078e.f23076h) {
                    if (this.f23078e.f23077i == 0) {
                        return;
                    }
                    this.f23078e.l(UserCallback.NOT_IN_CALLBACK);
                    if (this.f23078e.f23075g != null) {
                        this.f23078e.j = UserCallback.READ;
                        try {
                            this.f23078e.f23070b.h(this.f23078e, this.f23078e.f23075g);
                            return;
                        } catch (Exception e2) {
                            this.f23078e.p(e2);
                            return;
                        }
                    }
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f23079e;

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
            this.f23079e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f23079e.f23076h) {
                    if (this.f23079e.f23077i == 0) {
                        return;
                    }
                    this.f23079e.l(UserCallback.NOT_IN_CALLBACK);
                    this.f23079e.j = UserCallback.REWIND;
                    try {
                        this.f23079e.f23070b.i(this.f23079e);
                    } catch (Exception e2) {
                        this.f23079e.p(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetUploadDataStream f23080e;

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
            this.f23080e = cronetUploadDataStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f23080e.f23070b.close();
                } catch (IOException e2) {
                    Log.e("CronetUploadDataStream", "Exception thrown when closing", e2);
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
        this.f23074f = new a(this);
        this.f23075g = null;
        this.f23076h = new Object();
        this.f23077i = 0L;
        this.j = UserCallback.NOT_IN_CALLBACK;
        this.k = false;
        this.f23069a = executor;
        this.f23070b = uploadDataProvider;
        this.f23071c = cronetUrlRequest;
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
            synchronized (this.f23076h) {
                l(UserCallback.REWIND);
                this.j = UserCallback.NOT_IN_CALLBACK;
                this.f23073e = this.f23072d;
                if (this.f23077i == 0) {
                    return;
                }
                nativeOnRewindSucceeded(this.f23077i);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void b(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            synchronized (this.f23076h) {
                l(UserCallback.REWIND);
                p(exc);
            }
        }
    }

    @Override // com.baidu.turbonet.net.UploadDataSink
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.f23076h) {
                l(UserCallback.READ);
                if (z && this.f23072d >= 0) {
                    throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
                }
                int position = this.f23075g.position();
                long j = this.f23073e - position;
                this.f23073e = j;
                if (j < 0 && this.f23072d >= 0) {
                    throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f23072d - this.f23073e), Long.valueOf(this.f23072d)));
                }
                this.f23075g = null;
                this.j = UserCallback.NOT_IN_CALLBACK;
                n();
                if (this.f23077i == 0) {
                    return;
                }
                nativeOnReadSucceeded(this.f23077i, position, z);
            }
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            synchronized (this.f23076h) {
                this.f23077i = nativeAttachUploadDataToRequest(j, this.f23072d);
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
            synchronized (this.f23076h) {
                if (this.j == UserCallback.READ) {
                    this.k = true;
                } else if (this.f23077i == 0) {
                } else {
                    nativeDestroy(this.f23077i);
                    this.f23077i = 0L;
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
            synchronized (this.f23076h) {
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
            synchronized (this.f23076h) {
                this.j = UserCallback.GET_LENGTH;
            }
            try {
                long g2 = this.f23070b.g();
                this.f23072d = g2;
                this.f23073e = g2;
            } catch (Throwable th) {
                p(th);
            }
            synchronized (this.f23076h) {
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
            synchronized (this.f23076h) {
                if (this.j != UserCallback.NOT_IN_CALLBACK) {
                    this.j = UserCallback.NOT_IN_CALLBACK;
                    this.f23075g = null;
                    n();
                } else {
                    throw new IllegalStateException("There is no read or rewind or length check in progress.");
                }
            }
            this.f23071c.E(th);
        }
    }

    public void q(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, runnable) == null) {
            try {
                this.f23069a.execute(runnable);
            } catch (Throwable th) {
                this.f23071c.E(th);
            }
        }
    }

    @CalledByNative
    public void readData(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, byteBuffer) == null) {
            this.f23075g = byteBuffer;
            q(this.f23074f);
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
