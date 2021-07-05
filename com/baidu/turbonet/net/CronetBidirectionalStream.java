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
/* loaded from: classes5.dex */
public class CronetBidirectionalStream extends BidirectionalStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CronetUrlRequestContext f22930a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f22931b;

    /* renamed from: c  reason: collision with root package name */
    public final BidirectionalStream.Callback f22932c;

    /* renamed from: d  reason: collision with root package name */
    public final String f22933d;

    /* renamed from: e  reason: collision with root package name */
    public final String f22934e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f22935f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f22936g;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: h  reason: collision with root package name */
    public LinkedList<ByteBuffer> f22937h;
    @GuardedBy("mNativeStreamLock")

    /* renamed from: i  reason: collision with root package name */
    public LinkedList<ByteBuffer> f22938i;
    @GuardedBy("mNativeStreamLock")
    public boolean j;
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
    /* loaded from: classes5.dex */
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
            SUCCESS = new State(com.alipay.security.mobile.module.http.model.c.f2102g, 7);
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

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f22939e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22940f;

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
            this.f22940f = cronetBidirectionalStream;
            this.f22939e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f22940f.f22936g) {
                    if (this.f22940f.x()) {
                        return;
                    }
                    this.f22940f.k = this.f22939e;
                    this.f22940f.m = State.WAITING_FOR_READ;
                    if (!CronetBidirectionalStream.s(this.f22940f.f22934e) && this.f22940f.k) {
                        this.f22940f.n = State.WRITING_DONE;
                    } else {
                        this.f22940f.n = State.WAITING_FOR_FLUSH;
                    }
                    try {
                        this.f22940f.f22932c.f(this.f22940f);
                    } catch (Exception e2) {
                        this.f22940f.z(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22941e;

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
            this.f22941e = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f22941e.f22936g) {
                    if (this.f22941e.x()) {
                        return;
                    }
                    this.f22941e.m = State.WAITING_FOR_READ;
                    try {
                        this.f22941e.f22932c.d(this.f22941e, this.f22941e.o);
                    } catch (Exception e2) {
                        this.f22941e.z(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlResponseInfo.HeaderBlock f22942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22943f;

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
            this.f22943f = cronetBidirectionalStream;
            this.f22942e = headerBlock;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.f22943f.f22936g) {
                    if (this.f22943f.x()) {
                        return;
                    }
                    try {
                        this.f22943f.f22932c.e(this.f22943f, this.f22943f.o, this.f22942e);
                    } catch (Exception e2) {
                        this.f22943f.z(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22944e;

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
            this.f22944e = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f22944e.f22932c.a(this.f22944e, this.f22944e.o);
                } catch (Exception e2) {
                    d.a.t0.a.a.c("ChromiumNetwork", "Exception in onCanceled method", e2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TurbonetException f22945e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22946f;

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
            this.f22946f = cronetBidirectionalStream;
            this.f22945e = turbonetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22946f.u(this.f22945e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f22947e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f22948f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22949g;

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
            this.f22949g = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.f22947e;
                    this.f22947e = null;
                    synchronized (this.f22949g.f22936g) {
                        if (this.f22949g.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.f22948f) {
                            this.f22949g.m = State.READING_DONE;
                            if (this.f22949g.n == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.f22949g.m = State.WAITING_FOR_READ;
                        }
                        this.f22949g.f22932c.c(this.f22949g, this.f22949g.o, byteBuffer, this.f22948f);
                        if (z) {
                            this.f22949g.y();
                        }
                    }
                } catch (Exception e2) {
                    this.f22949g.z(e2);
                }
            }
        }

        public /* synthetic */ f(CronetBidirectionalStream cronetBidirectionalStream, a aVar) {
            this(cronetBidirectionalStream);
        }
    }

    /* loaded from: classes5.dex */
    public final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public ByteBuffer f22950e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f22951f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CronetBidirectionalStream f22952g;

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
            this.f22952g = cronetBidirectionalStream;
            this.f22950e = byteBuffer;
            this.f22951f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.f22950e;
                    this.f22950e = null;
                    synchronized (this.f22952g.f22936g) {
                        if (this.f22952g.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.f22951f) {
                            this.f22952g.n = State.WRITING_DONE;
                            if (this.f22952g.m == State.READING_DONE) {
                                z = true;
                            }
                        }
                        this.f22952g.f22932c.h(this.f22952g, this.f22952g.o, byteBuffer, this.f22951f);
                        if (z) {
                            this.f22952g.y();
                        }
                    }
                } catch (Exception e2) {
                    this.f22952g.z(e2);
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

    private native long nativeCreateBidirectionalStream(long j, boolean z);

    @NativeClassQualifiedName
    private native void nativeDestroy(long j, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i2, int i3);

    @NativeClassQualifiedName
    private native void nativeSendRequestHeaders(long j);

    @NativeClassQualifiedName
    private native int nativeStart(long j, String str, int i2, String str2, String[] strArr, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            A(new d(this));
        }
    }

    @CalledByNative
    private void onError(int i2, int i3, int i4, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(j)}) == null) {
            UrlResponseInfo urlResponseInfo = this.o;
            if (urlResponseInfo != null) {
                urlResponseInfo.j(j);
            }
            if (i2 == 11) {
                t(new QuicException("Exception in BidirectionalStream: " + str, i3, i4));
                return;
            }
            t(new TurbonetException("Exception in BidirectionalStream: " + str, i2, i3));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i2, int i3, int i4, long j) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            this.o.j(j);
            if (byteBuffer.position() != i3 || byteBuffer.limit() != i4) {
                t(new TurbonetException("ByteBuffer modified externally during read", null));
            } else if (i2 >= 0 && (i5 = i3 + i2) <= i4) {
                byteBuffer.position(i5);
                f fVar = this.p;
                fVar.f22947e = byteBuffer;
                fVar.f22948f = i2 == 0;
                A(this.p);
            } else {
                t(new TurbonetException("Invalid number of bytes read", null));
            }
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i2, String str, String[] strArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i2), str, strArr, Long.valueOf(j)}) == null) {
            try {
                this.o = B(i2, str, strArr, j);
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
            synchronized (this.f22936g) {
                this.n = State.WAITING_FOR_FLUSH;
                if (!this.f22938i.isEmpty()) {
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
                this.f22931b.execute(runnable);
            } catch (RejectedExecutionException e2) {
                d.a.t0.a.a.c("ChromiumNetwork", "Exception posting task to executor", e2);
                synchronized (this.f22936g) {
                    State state = State.ERROR;
                    this.n = state;
                    this.m = state;
                    r(false);
                }
            }
        }
    }

    public final UrlResponseInfo B(int i2, String str, String[] strArr, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, strArr, Long.valueOf(j)})) == null) {
            UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.f22933d), i2, "", w(strArr), false, str, null);
            urlResponseInfo.j(j);
            return urlResponseInfo;
        }
        return (UrlResponseInfo) invokeCommon.objValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.f22938i.size();
            ByteBuffer[] byteBufferArr = new ByteBuffer[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                ByteBuffer poll = this.f22938i.poll();
                byteBufferArr[i2] = poll;
                iArr[i2] = poll.position();
                iArr2[i2] = poll.limit();
            }
            this.n = State.WRITING;
            if (nativeWritevData(this.l, byteBufferArr, iArr, iArr2, this.j && this.f22937h.isEmpty())) {
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
            synchronized (this.f22936g) {
                d.a.t0.b.b.b(byteBuffer);
                d.a.t0.b.b.a(byteBuffer);
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
            synchronized (this.f22936g) {
                d.a.t0.b.b.a(byteBuffer);
                if (!byteBuffer.hasRemaining() && !z) {
                    throw new IllegalArgumentException("Empty buffer before end of stream.");
                }
                if (!this.j) {
                    if (x()) {
                        return;
                    }
                    this.f22937h.add(byteBuffer);
                    if (z) {
                        this.j = true;
                    }
                    if (!this.f22935f) {
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
            d.a.t0.a.a.h("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
            long j = this.l;
            if (j == 0) {
                return;
            }
            nativeDestroy(j, z);
            this.l = 0L;
            this.f22930a.s();
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
            synchronized (this.f22936g) {
                if (x()) {
                    return;
                }
                State state = State.ERROR;
                this.n = state;
                this.m = state;
                r(false);
                try {
                    this.f22932c.b(this, this.o, turbonetException);
                } catch (Exception e2) {
                    d.a.t0.a.a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
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
            if (this.f22937h.isEmpty() && this.f22938i.isEmpty()) {
                if (this.k) {
                    return;
                }
                this.k = true;
                nativeSendRequestHeaders(this.l);
                if (s(this.f22934e)) {
                    return;
                }
                this.n = State.WRITING_DONE;
                return;
            }
            if (!this.f22937h.isEmpty()) {
                this.f22938i.addAll(this.f22937h);
                this.f22937h.clear();
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
            synchronized (this.f22936g) {
                if (x()) {
                    return;
                }
                if (this.n == State.WRITING_DONE && this.m == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.n = state;
                    this.m = state;
                    r(false);
                    try {
                        this.f22932c.g(this, this.o);
                    } catch (Exception e2) {
                        d.a.t0.a.a.c("ChromiumNetwork", "Exception in onSucceeded method", e2);
                    }
                }
            }
        }
    }

    public final void z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, exc) == null) {
            TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
            d.a.t0.a.a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
            u(turbonetException);
        }
    }
}
