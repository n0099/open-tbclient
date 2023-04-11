package com.baidu.turbonet.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u8a;
import com.baidu.tieba.y8a;
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
/* loaded from: classes7.dex */
public class CronetBidirectionalStream extends BidirectionalStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CronetUrlRequestContext a;
    public final Executor b;
    public final BidirectionalStream.Callback c;
    public final String d;
    public final String e;
    public final boolean f;
    public final Object g;
    @GuardedBy("mNativeStreamLock")
    public LinkedList<ByteBuffer> h;
    @GuardedBy("mNativeStreamLock")
    public LinkedList<ByteBuffer> i;
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
    private native boolean nativeReadData(long j, ByteBuffer byteBuffer, int i, int i2);

    @NativeClassQualifiedName
    private native void nativeSendRequestHeaders(long j);

    @NativeClassQualifiedName
    private native int nativeStart(long j, String str, int i, String str2, String[] strArr, boolean z);

    @NativeClassQualifiedName
    private native boolean nativeWritevData(long j, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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
            SUCCESS = new State("SUCCESS", 7);
            WAITING_FOR_FLUSH = new State("WAITING_FOR_FLUSH", 8);
            WRITING = new State("WRITING", 9);
            State state = new State("WRITING_DONE", 10);
            WRITING_DONE = state;
            $VALUES = new State[]{NOT_STARTED, STARTED, WAITING_FOR_READ, READING, READING_DONE, CANCELED, ERROR, SUCCESS, WAITING_FOR_FLUSH, WRITING, state};
        }

        public State(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (State) Enum.valueOf(State.class, str);
            }
            return (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (State[]) $VALUES.clone();
            }
            return (State[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CronetBidirectionalStream b;

        public a(CronetBidirectionalStream cronetBidirectionalStream, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetBidirectionalStream;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b.g) {
                    if (this.b.x()) {
                        return;
                    }
                    this.b.k = this.a;
                    this.b.m = State.WAITING_FOR_READ;
                    if (!CronetBidirectionalStream.s(this.b.e) && this.b.k) {
                        this.b.n = State.WRITING_DONE;
                    } else {
                        this.b.n = State.WAITING_FOR_FLUSH;
                    }
                    try {
                        this.b.c.f(this.b);
                    } catch (Exception e) {
                        this.b.z(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetBidirectionalStream a;

        public b(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.g) {
                    if (this.a.x()) {
                        return;
                    }
                    this.a.m = State.WAITING_FOR_READ;
                    try {
                        this.a.c.d(this.a, this.a.o);
                    } catch (Exception e) {
                        this.a.z(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlResponseInfo.HeaderBlock a;
        public final /* synthetic */ CronetBidirectionalStream b;

        public c(CronetBidirectionalStream cronetBidirectionalStream, UrlResponseInfo.HeaderBlock headerBlock) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, headerBlock};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetBidirectionalStream;
            this.a = headerBlock;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b.g) {
                    if (this.b.x()) {
                        return;
                    }
                    try {
                        this.b.c.e(this.b, this.b.o, this.a);
                    } catch (Exception e) {
                        this.b.z(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetBidirectionalStream a;

        public d(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetBidirectionalStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.c.a(this.a, this.a.o);
                } catch (Exception e) {
                    u8a.c("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TurbonetException a;
        public final /* synthetic */ CronetBidirectionalStream b;

        public e(CronetBidirectionalStream cronetBidirectionalStream, TurbonetException turbonetException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, turbonetException};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cronetBidirectionalStream;
            this.a = turbonetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.u(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public boolean b;
        public final /* synthetic */ CronetBidirectionalStream c;

        public f(CronetBidirectionalStream cronetBidirectionalStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cronetBidirectionalStream;
        }

        public /* synthetic */ f(CronetBidirectionalStream cronetBidirectionalStream, a aVar) {
            this(cronetBidirectionalStream);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.a;
                    this.a = null;
                    synchronized (this.c.g) {
                        if (this.c.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.b) {
                            this.c.m = State.READING_DONE;
                            if (this.c.n == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.c.m = State.WAITING_FOR_READ;
                        }
                        this.c.c.c(this.c, this.c.o, byteBuffer, this.b);
                        if (z) {
                            this.c.y();
                        }
                    }
                } catch (Exception e) {
                    this.c.z(e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public final boolean b;
        public final /* synthetic */ CronetBidirectionalStream c;

        public g(CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer byteBuffer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, byteBuffer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cronetBidirectionalStream;
            this.a = byteBuffer;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ByteBuffer byteBuffer = this.a;
                    this.a = null;
                    synchronized (this.c.g) {
                        if (this.c.x()) {
                            return;
                        }
                        boolean z = false;
                        if (this.b) {
                            this.c.n = State.WRITING_DONE;
                            if (this.c.m == State.READING_DONE) {
                                z = true;
                            }
                        }
                        this.c.c.h(this.c, this.c.o, byteBuffer, this.b);
                        if (z) {
                            this.c.y();
                        }
                    }
                } catch (Exception e) {
                    this.c.z(e);
                }
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

    public static boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            if (!str.equals("GET") && !str.equals("HEAD")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void t(TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, turbonetException) == null) {
            A(new e(this, turbonetException));
        }
    }

    public final void z(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, exc) == null) {
            TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
            u8a.c("ChromiumNetwork", "Exception in CalledByNative method", exc);
            u(turbonetException);
        }
    }

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            A(new d(this));
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.m != State.NOT_STARTED && this.l == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65557, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(j)}) == null) {
            UrlResponseInfo urlResponseInfo = this.o;
            if (urlResponseInfo != null) {
                urlResponseInfo.j(j);
            }
            if (i == 11) {
                t(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
                return;
            }
            t(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            this.o.j(j);
            if (byteBuffer.position() == i2 && byteBuffer.limit() == i3) {
                if (i >= 0 && (i4 = i2 + i) <= i3) {
                    byteBuffer.position(i4);
                    f fVar = this.p;
                    fVar.a = byteBuffer;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar.b = z;
                    A(this.p);
                    return;
                }
                t(new TurbonetException("Invalid number of bytes read", null));
                return;
            }
            t(new TurbonetException("ByteBuffer modified externally during read", null));
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, this, new Object[]{Integer.valueOf(i), str, strArr, Long.valueOf(j)}) == null) {
            try {
                this.o = B(i, str, strArr, j);
                A(new b(this));
            } catch (Exception unused) {
                t(new TurbonetException("Cannot prepare ResponseInfo", null));
            }
        }
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, this, new Object[]{byteBufferArr, iArr, iArr2, Boolean.valueOf(z)}) == null) {
            synchronized (this.g) {
                this.n = State.WAITING_FOR_FLUSH;
                if (!this.i.isEmpty()) {
                    C();
                }
            }
            for (int i = 0; i < byteBufferArr.length; i++) {
                ByteBuffer byteBuffer = byteBufferArr[i];
                if (byteBuffer.position() == iArr[i] && byteBuffer.limit() == iArr2[i]) {
                    byteBuffer.position(byteBuffer.limit());
                    boolean z2 = true;
                    if (!z || i != byteBufferArr.length - 1) {
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

    public static ArrayList<Map.Entry<String, String>> w(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, strArr)) == null) {
            ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
            for (int i = 0; i < strArr.length; i += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void A(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            try {
                this.b.execute(runnable);
            } catch (RejectedExecutionException e2) {
                u8a.c("ChromiumNetwork", "Exception posting task to executor", e2);
                synchronized (this.g) {
                    State state = State.ERROR;
                    this.n = state;
                    this.m = state;
                    r(false);
                }
            }
        }
    }

    public final void u(TurbonetException turbonetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, turbonetException) == null) {
            synchronized (this.g) {
                if (x()) {
                    return;
                }
                State state = State.ERROR;
                this.n = state;
                this.m = state;
                r(false);
                try {
                    this.c.b(this, this.o, turbonetException);
                } catch (Exception e2) {
                    u8a.c("ChromiumNetwork", "Exception notifying of failed request", e2);
                }
            }
        }
    }

    public final UrlResponseInfo B(int i, String str, String[] strArr, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, strArr, Long.valueOf(j)})) == null) {
            UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.d), i, "", w(strArr), false, str, null);
            urlResponseInfo.j(j);
            return urlResponseInfo;
        }
        return (UrlResponseInfo) invokeCommon.objValue;
    }

    public final void C() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int size = this.i.size();
            ByteBuffer[] byteBufferArr = new ByteBuffer[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                ByteBuffer poll = this.i.poll();
                byteBufferArr[i] = poll;
                iArr[i] = poll.position();
                iArr2[i] = poll.limit();
            }
            this.n = State.WRITING;
            long j = this.l;
            if (this.j && this.h.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (nativeWritevData(j, byteBufferArr, iArr, iArr2, z)) {
                return;
            }
            this.n = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this.g) {
                if (x()) {
                    return;
                }
                if (this.n == State.WRITING_DONE && this.m == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.n = state;
                    this.m = state;
                    r(false);
                    try {
                        this.c.g(this, this.o);
                    } catch (Exception e2) {
                        u8a.c("ChromiumNetwork", "Exception in onSucceeded method", e2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            synchronized (this.g) {
                y8a.b(byteBuffer);
                y8a.a(byteBuffer);
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

    @GuardedBy("mNativeStreamLock")
    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            u8a.h("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
            long j = this.l;
            if (j == 0) {
                return;
            }
            nativeDestroy(j, z);
            this.l = 0L;
            this.a.s();
            Runnable runnable = this.q;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override // com.baidu.turbonet.net.BidirectionalStream
    public void b(ByteBuffer byteBuffer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, byteBuffer, z) == null) {
            synchronized (this.g) {
                y8a.a(byteBuffer);
                if (!byteBuffer.hasRemaining() && !z) {
                    throw new IllegalArgumentException("Empty buffer before end of stream.");
                }
                if (!this.j) {
                    if (x()) {
                        return;
                    }
                    this.h.add(byteBuffer);
                    if (z) {
                        this.j = true;
                    }
                    if (!this.f) {
                        v();
                    }
                    return;
                }
                throw new IllegalArgumentException("Write after writing end of stream.");
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !x()) {
            State state = this.n;
            if (state == State.WAITING_FOR_FLUSH || state == State.WRITING) {
                if (this.h.isEmpty() && this.i.isEmpty()) {
                    if (!this.k) {
                        this.k = true;
                        nativeSendRequestHeaders(this.l);
                        if (!s(this.e)) {
                            this.n = State.WRITING_DONE;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (!this.h.isEmpty()) {
                    this.i.addAll(this.h);
                    this.h.clear();
                }
                if (this.n == State.WRITING) {
                    return;
                }
                C();
            }
        }
    }
}
