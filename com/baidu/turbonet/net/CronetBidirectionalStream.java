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
import com.baidu.turbonet.net.BidirectionalStream;
import com.baidu.turbonet.net.UrlResponseInfo;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
@JNINamespace
/* loaded from: classes8.dex */
public class CronetBidirectionalStream extends BidirectionalStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CronetUrlRequestContext f59428a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f59429b;

    /* renamed from: c  reason: collision with root package name */
    public final BidirectionalStream.Callback f59430c;

    /* renamed from: d  reason: collision with root package name */
    public final String f59431d;

    /* renamed from: e  reason: collision with root package name */
    public final String f59432e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f59433f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f59434g;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: h  reason: collision with root package name */
    public LinkedList<ByteBuffer> f59435h;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: i  reason: collision with root package name */
    public LinkedList<ByteBuffer> f59436i;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: j  reason: collision with root package name */
    public boolean f59437j;
    @GuardedBy("mNativeStreamLock")
    public boolean k;
    @GuardedBy("mNativeStreamLock")
    public long l;
    @GuardedBy("mNativeStreamLock")
    public State m;
    @GuardedBy("mNativeStreamLock")
    public State n;
    public UrlResponseInfo o;
    public f p;
    public Runnable q;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State CANCELED;
        public static final State ERROR;
        public static final State NOT_STARTED;
        public static final State READING;
        public static final State READING_DONE;
        public static final State STARTED;
        public static final State SUCCESS;
        public static final State WAITING_FOR_FLUSH;
        public static final State WAITING_FOR_READ;
        public static final State WRITING;
        public static final State WRITING_DONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1913828356, "Lcom/baidu/turbonet/net/CronetBidirectionalStream$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1913828356, "Lcom/baidu/turbonet/net/CronetBidirectionalStream$State;");
                    return;
                }
            }
            NOT_STARTED = new State("NOT_STARTED", 0);
            STARTED = new State("STARTED", 1);
            WAITING_FOR_READ = new State("WAITING_FOR_READ", 2);
            READING = new State("READING", 3);
            READING_DONE = new State("READING_DONE", 4);
            CANCELED = new State("CANCELED", 5);
            ERROR = new State("ERROR", 6);
            SUCCESS = new State(com.alipay.security.mobile.module.http.model.c.p, 7);
            WAITING_FOR_FLUSH = new State("WAITING_FOR_FLUSH", 8);
            WRITING = new State("WRITING", 9);
            State state = new State("WRITING_DONE", 10);
            WRITING_DONE = state;
            $VALUES = new State[]{NOT_STARTED, STARTED, WAITING_FOR_READ, READING, READING_DONE, CANCELED, ERROR, SUCCESS, WAITING_FOR_FLUSH, WRITING, state};
        }

        public State(String str, int i2) {
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

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f59438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59439f;

        public a(CronetBidirectionalStream cronetBidirectionalStream, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59439f = cronetBidirectionalStream;
            this.f59438e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f59439f.f59434g) {
                    if (this.f59439f.x()) {
                        return;
                    }
                    this.f59439f.k = this.f59438e;
                    this.f59439f.m = State.WAITING_FOR_READ;
                    if (!CronetBidirectionalStream.s(this.f59439f.f59432e) && this.f59439f.k) {
                        this.f59439f.n = State.WRITING_DONE;
                    } else {
                        this.f59439f.n = State.WAITING_FOR_FLUSH;
                    }
                    try {
                        this.f59439f.f59430c.f(this.f59439f);
                    } catch (Exception e2) {
                        this.f59439f.z(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59440e;

        public b(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59440e = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f59440e.f59434g) {
                    if (this.f59440e.x()) {
                        return;
                    }
                    this.f59440e.m = State.WAITING_FOR_READ;
                    try {
                        this.f59440e.f59430c.d(this.f59440e, this.f59440e.o);
                    } catch (Exception e2) {
                        this.f59440e.z(e2);
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
        public final /* synthetic */ UrlResponseInfo.HeaderBlock f59441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59442f;

        public c(CronetBidirectionalStream cronetBidirectionalStream, UrlResponseInfo.HeaderBlock headerBlock) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, headerBlock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59442f = cronetBidirectionalStream;
            this.f59441e = headerBlock;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f59442f.f59434g) {
                    if (this.f59442f.x()) {
                        return;
                    }
                    try {
                        this.f59442f.f59430c.e(this.f59442f, this.f59442f.o, this.f59441e);
                    } catch (Exception e2) {
                        this.f59442f.z(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59443e;

        public d(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59443e = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f59443e.f59430c.a(this.f59443e, this.f59443e.o);
                } catch (Exception e2) {
                    c.a.s0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TurbonetException f59444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59445f;

        public e(CronetBidirectionalStream cronetBidirectionalStream, TurbonetException turbonetException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, turbonetException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59445f = cronetBidirectionalStream;
            this.f59444e = turbonetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59445f.u(this.f59444e);
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f59446e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f59447f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59448g;

        public f(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59448g = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.f59446e;
                    this.f59446e = null;
                    synchronized (this.f59448g.f59434g) {
                        if (this.f59448g.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.f59447f) {
                            this.f59448g.m = State.READING_DONE;
                            if (this.f59448g.n == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.f59448g.m = State.WAITING_FOR_READ;
                        }
                        this.f59448g.f59430c.c(this.f59448g, this.f59448g.o, byteBuffer, this.f59447f);
                        if (z) {
                            this.f59448g.y();
                        }
                    }
                } catch (Exception e2) {
                    this.f59448g.z(e2);
                }
            }
        }

        public /* synthetic */ f(CronetBidirectionalStream cronetBidirectionalStream, a aVar) {
            this(cronetBidirectionalStream);
        }
    }

    /* loaded from: classes8.dex */
    public final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f59449e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f59450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f59451g;

        public g(CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer byteBuffer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, byteBuffer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59451g = cronetBidirectionalStream;
            this.f59449e = byteBuffer;
            this.f59450f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.f59449e;
                    this.f59449e = null;
                    synchronized (this.f59451g.f59434g) {
                        if (this.f59451g.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.f59450f) {
                            this.f59451g.n = State.WRITING_DONE;
                            if (this.f59451g.m == State.READING_DONE) {
                                z = true;
                            }
                        }
                        this.f59451g.f59430c.h(this.f59451g, this.f59451g.o, byteBuffer, this.f59450f);
                        if (z) {
                            this.f59451g.y();
                        }
                    }
                } catch (Exception e2) {
                    this.f59451g.z(e2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(894306217, "Lcom/baidu/turbonet/net/CronetBidirectionalStream;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(894306217, "Lcom/baidu/turbonet/net/CronetBidirectionalStream;");
        }
    }

    private native long nativeCreateBidirectionalStream(long j2, boolean z);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j2, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j2, ByteBuffer byteBuffer, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeSendRequestHeaders(long j2);

    @NativeClassQualifiedName
    private native int nativeStart(long j2, String str, int i2, String str2, String[] strArr, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeWritevData(long j2, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            A(new d(this));
        }
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j2)}) == null) {
            UrlResponseInfo urlResponseInfo = this.o;
            if (urlResponseInfo != null) {
                urlResponseInfo.j(j2);
            }
            if (i2 == 11) {
                t(new QuicException("Exception in BidirectionalStream: " + str, i3, i4));
                return;
            }
            t(new TurbonetException("Exception in BidirectionalStream: " + str, i2, i3));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j2) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)}) == null) {
            this.o.j(j2);
            if (byteBuffer.position() != i3 || byteBuffer.limit() != i4) {
                t(new TurbonetException("ByteBuffer modified externally during read", null));
            } else if (i2 >= 0 && (i5 = i3 + i2) <= i4) {
                byteBuffer.position(i5);
                f fVar = this.p;
                fVar.f59446e = byteBuffer;
                fVar.f59447f = i2 == 0;
                A(this.p);
            } else {
                t(new TurbonetException("Invalid number of bytes read", null));
            }
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i2, String str, String[] strArr, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i2), str, strArr, Long.valueOf(j2)}) == null) {
            try {
                this.o = B(i2, str, strArr, j2);
                A(new b(this));
            } catch (Exception unused) {
                t(new TurbonetException("Cannot prepare ResponseInfo", null));
            }
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, this, strArr) == null) {
            A(new c(this, new UrlResponseInfo.HeaderBlock(w(strArr))));
        }
    }

    @CalledByNative
    private void onStreamReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65561, this, z) == null) {
            A(new a(this, z));
        }
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{byteBufferArr, iArr, iArr2, Boolean.valueOf(z)}) == null) {
            synchronized (this.f59434g) {
                this.n = State.WAITING_FOR_FLUSH;
                if (!this.f59436i.isEmpty()) {
                    C();
                }
            }
            for (int i2 = 0; i2 < byteBufferArr.length; i2++) {
                ByteBuffer byteBuffer = byteBufferArr[i2];
                if (byteBuffer.position() == iArr[i2] && byteBuffer.limit() == iArr2[i2]) {
                    byteBuffer.position(byteBuffer.limit());
                    boolean z2 = true;
                    if (!z || i2 != byteBufferArr.length - 1) {
                        z2 = false;
                    }
                    A(new g(this, byteBuffer, z2));
                } else {
                    t(new TurbonetException("ByteBuffer modified externally during write", null));
                    return;
                }
            }
        }
    }

    public static boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? (str.equals("GET") || str.equals("HEAD")) ? false : true : invokeL.booleanValue;
    }

    public static ArrayList<Map.Entry<String, String>> w(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, strArr)) == null) {
            ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
            for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i2], strArr[i2 + 1]));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void A(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.f59429b.execute(runnable);
            } catch (RejectedExecutionException e2) {
                c.a.s0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
                synchronized (this.f59434g) {
                    State state = State.ERROR;
                    this.n = state;
                    this.m = state;
                    r(false);
                }
            }
        }
    }

    public final UrlResponseInfo B(int i2, String str, String[] strArr, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, strArr, Long.valueOf(j2)})) == null) {
            UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.f59431d), i2, "", w(strArr), false, str, null);
            urlResponseInfo.j(j2);
            return urlResponseInfo;
        }
        return (UrlResponseInfo) invokeCommon.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f59436i.size();
            ByteBuffer[] byteBufferArr = new ByteBuffer[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                ByteBuffer poll = this.f59436i.poll();
                byteBufferArr[i2] = poll;
                iArr[i2] = poll.position();
                iArr2[i2] = poll.limit();
            }
            this.n = State.WRITING;
            if (nativeWritevData(this.l, byteBufferArr, iArr, iArr2, this.f59437j && this.f59435h.isEmpty())) {
                return;
            }
            this.n = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            synchronized (this.f59434g) {
                c.a.s0.b.b.b(byteBuffer);
                c.a.s0.b.b.a(byteBuffer);
                if (this.m == State.WAITING_FOR_READ) {
                    if (x()) {
                        return;
                    }
                    if (this.p == null) {
                        this.p = new f(this, null);
                    }
                    this.m = State.READING;
                    if (nativeReadData(this.l, byteBuffer, byteBuffer.position(), byteBuffer.limit())) {
                        return;
                    }
                    this.m = State.WAITING_FOR_READ;
                    throw new IllegalArgumentException("Unable to call native read");
                }
                throw new IllegalStateException("Unexpected read attempt.");
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void b(ByteBuffer byteBuffer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, byteBuffer, z) == null) {
            synchronized (this.f59434g) {
                c.a.s0.b.b.a(byteBuffer);
                if (!byteBuffer.hasRemaining() && !z) {
                    throw new IllegalArgumentException("Empty buffer before end of stream.");
                }
                if (!this.f59437j) {
                    if (x()) {
                        return;
                    }
                    this.f59435h.add(byteBuffer);
                    if (z) {
                        this.f59437j = true;
                    }
                    if (!this.f59433f) {
                        v();
                    }
                    return;
                }
                throw new IllegalArgumentException("Write after writing end of stream.");
            }
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            c.a.s0.a.a.h("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
            long j2 = this.l;
            if (j2 == 0) {
                return;
            }
            nativeDestroy(j2, z);
            this.l = 0L;
            this.f59428a.s();
            Runnable runnable = this.q;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void t(TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, turbonetException) == null) {
            A(new e(this, turbonetException));
        }
    }

    public final void u(TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, turbonetException) == null) {
            synchronized (this.f59434g) {
                if (x()) {
                    return;
                }
                State state = State.ERROR;
                this.n = state;
                this.m = state;
                r(false);
                try {
                    this.f59430c.b(this, this.o, turbonetException);
                } catch (Exception e2) {
                    c.a.s0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
                }
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || x()) {
            return;
        }
        State state = this.n;
        if (state == State.WAITING_FOR_FLUSH || state == State.WRITING) {
            if (this.f59435h.isEmpty() && this.f59436i.isEmpty()) {
                if (this.k) {
                    return;
                }
                this.k = true;
                nativeSendRequestHeaders(this.l);
                if (s(this.f59432e)) {
                    return;
                }
                this.n = State.WRITING_DONE;
                return;
            }
            if (!this.f59435h.isEmpty()) {
                this.f59436i.addAll(this.f59435h);
                this.f59435h.clear();
            }
            if (this.n == State.WRITING) {
                return;
            }
            C();
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m != State.NOT_STARTED && this.l == 0 : invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.f59434g) {
                if (x()) {
                    return;
                }
                if (this.n == State.WRITING_DONE && this.m == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.n = state;
                    this.m = state;
                    r(false);
                    try {
                        this.f59430c.g(this, this.o);
                    } catch (Exception e2) {
                        c.a.s0.a.a.c("ChromiumNetwork", "Exception in onSucceeded method", e2);
                    }
                }
            }
        }
    }

    public final void z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, exc) == null) {
            TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
            c.a.s0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
            u(turbonetException);
        }
    }
}
