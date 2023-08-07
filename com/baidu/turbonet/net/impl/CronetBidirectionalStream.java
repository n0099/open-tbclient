package com.baidu.turbonet.net.impl;

import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b0b;
import com.baidu.tieba.b1b;
import com.baidu.tieba.f0b;
import com.baidu.tieba.w0b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.net.CronetException;
import com.baidu.turbonet.net.ExperimentalBidirectionalStream;
import com.baidu.turbonet.net.RequestFinishedInfo;
import com.baidu.turbonet.net.UrlResponseInfo;
import com.baidu.turbonet.net.impl.VersionSafeCallbacks;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeClassQualifiedName;
@JNINamespace("cronet")
@VisibleForTesting
/* loaded from: classes9.dex */
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CronetUrlRequestContext a;
    public final Executor b;
    public final VersionSafeCallbacks.a c;
    public final String d;
    public final String e;
    public final Collection<Object> f;
    public CronetException g;
    public final Object h;
    @GuardedBy("mNativeStreamLock")
    public LinkedList<ByteBuffer> i;
    @GuardedBy("mNativeStreamLock")
    public LinkedList<ByteBuffer> j;
    @GuardedBy("mNativeStreamLock")
    public boolean k;
    @GuardedBy("mNativeStreamLock")
    public boolean l;
    @GuardedBy("mNativeStreamLock")
    public RequestFinishedInfo.Metrics m;
    @GuardedBy("mNativeStreamLock")
    public long n;
    @GuardedBy("mNativeStreamLock")
    public int o;
    @GuardedBy("mNativeStreamLock")
    public int p;
    public b1b q;
    public g r;
    public Runnable s;

    /* loaded from: classes9.dex */
    public interface f {
        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void a(long j, CronetBidirectionalStream cronetBidirectionalStream, boolean z);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean b(long j, CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z);
    }

    /* loaded from: classes9.dex */
    public final class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public boolean b;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(809146640, "Lcom/baidu/turbonet/net/impl/CronetBidirectionalStream;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(809146640, "Lcom/baidu/turbonet/net/impl/CronetBidirectionalStream;");
        }
    }

    /* loaded from: classes9.dex */
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
                synchronized (this.b.h) {
                    if (this.b.t()) {
                        return;
                    }
                    this.b.l = this.a;
                    this.b.o = 2;
                    if (CronetBidirectionalStream.p(this.b.e) || !this.b.l) {
                        this.b.p = 8;
                    } else {
                        this.b.p = 10;
                    }
                    try {
                        this.b.c.e(this.b);
                    } catch (Exception e) {
                        this.b.v(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                synchronized (this.a.h) {
                    if (!this.a.t()) {
                        this.a.o = 2;
                        try {
                            this.a.c.c(this.a, this.a.q);
                        } catch (Exception e) {
                            this.a.v(e);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                synchronized (this.b.h) {
                    if (this.b.t()) {
                        return;
                    }
                    try {
                        this.b.c.d(this.b, this.b.q, this.a);
                    } catch (Exception e) {
                        this.b.v(e);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
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
                    this.a.c.a(this.a, this.a.q);
                } catch (Exception e) {
                    Log.e(CronetUrlRequestContext.s, "Exception in onCanceled method", e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetException a;
        public final /* synthetic */ CronetBidirectionalStream b;

        public e(CronetBidirectionalStream cronetBidirectionalStream, CronetException cronetException) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetBidirectionalStream, cronetException};
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
            this.a = cronetException;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.r(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public final boolean b;
        public final /* synthetic */ CronetBidirectionalStream c;

        public h(CronetBidirectionalStream cronetBidirectionalStream, ByteBuffer byteBuffer, boolean z) {
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
                    synchronized (this.c.h) {
                        if (this.c.t()) {
                            return;
                        }
                        boolean z = false;
                        if (this.b) {
                            this.c.p = 10;
                            if (this.c.o == 4) {
                                z = true;
                            }
                        }
                        this.c.c.g(this.c, this.c.q, byteBuffer, this.b);
                        if (z) {
                            this.c.u();
                        }
                    }
                } catch (Exception e) {
                    this.c.v(e);
                }
            }
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, strArr) == null) {
            w(new c(this, new b1b.a(s(strArr))));
        }
    }

    @CalledByNative
    private void onStreamReady(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, this, z) == null) {
            w(new a(this, z));
        }
    }

    public static boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (!"GET".equals(str) && !"HEAD".equals(str)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cronetException) == null) {
            w(new e(this, cronetException));
        }
    }

    public final void v(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, exc) == null) {
            CallbackExceptionImpl callbackExceptionImpl = new CallbackExceptionImpl("CalledByNative method has thrown an exception", exc);
            Log.e(CronetUrlRequestContext.s, "Exception in CalledByNative method", exc);
            r(callbackExceptionImpl);
        }
    }

    @CalledByNative
    private void onCanceled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            w(new d(this));
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.o != 0 && this.n == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(j)}) == null) {
            b1b b1bVar = this.q;
            if (b1bVar != null) {
                b1bVar.j(j);
            }
            if (i != 10 && i != 3) {
                q(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + str, i, i2));
                return;
            }
            q(new QuicExceptionImpl("Exception in BidirectionalStream: " + str, i, i2, i3));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        int i4;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65554, this, new Object[]{byteBuffer, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            this.q.j(j);
            if (byteBuffer.position() == i2 && byteBuffer.limit() == i3) {
                if (i >= 0 && (i4 = i2 + i) <= i3) {
                    byteBuffer.position(i4);
                    g gVar = this.r;
                    gVar.a = byteBuffer;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    gVar.b = z;
                    w(this.r);
                    return;
                }
                q(new CronetExceptionImpl("Invalid number of bytes read", null));
                return;
            }
            q(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        }
    }

    @CalledByNative
    private void onMetricsCollected(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, boolean z, long j14, long j15) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9), Long.valueOf(j10), Long.valueOf(j11), Long.valueOf(j12), Long.valueOf(j13), Boolean.valueOf(z), Long.valueOf(j14), Long.valueOf(j15)}) == null) {
            synchronized (this.h) {
                if (this.m == null) {
                    this.m = new f0b(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, z, j14, j15);
                    if (this.o == 7) {
                        i = 0;
                    } else if (this.o == 5) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    this.a.z(new w0b(this.d, this.f, this.m, i, this.q, this.g));
                } else {
                    throw new IllegalStateException("Metrics collection should only happen once.");
                }
            }
        }
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Integer.valueOf(i), str, strArr, Long.valueOf(j)}) == null) {
            try {
                this.q = x(i, str, strArr, j);
                w(new b(this));
            } catch (Exception e2) {
                q(new CronetExceptionImpl("Cannot prepare ResponseInfo", e2));
            }
        }
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, this, new Object[]{byteBufferArr, iArr, iArr2, Boolean.valueOf(z)}) == null) {
            synchronized (this.h) {
                if (t()) {
                    return;
                }
                this.p = 8;
                if (!this.j.isEmpty()) {
                    y();
                }
                for (int i = 0; i < byteBufferArr.length; i++) {
                    ByteBuffer byteBuffer = byteBufferArr[i];
                    if (byteBuffer.position() == iArr[i] && byteBuffer.limit() == iArr2[i]) {
                        byteBuffer.position(byteBuffer.limit());
                        boolean z2 = true;
                        if (!z || i != byteBufferArr.length - 1) {
                            z2 = false;
                        }
                        w(new h(this, byteBuffer, z2));
                    } else {
                        q(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
                        return;
                    }
                }
            }
        }
    }

    public static ArrayList<Map.Entry<String, String>> s(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, strArr)) == null) {
            ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
            for (int i = 0; i < strArr.length; i += 2) {
                arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void r(CronetException cronetException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cronetException) == null) {
            this.g = cronetException;
            synchronized (this.h) {
                if (t()) {
                    return;
                }
                this.p = 6;
                this.o = 6;
                o(false);
                try {
                    this.c.b(this, this.q, cronetException);
                } catch (Exception e2) {
                    Log.e(CronetUrlRequestContext.s, "Exception notifying of failed request", e2);
                }
            }
        }
    }

    public final void w(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, runnable) == null) {
            try {
                this.b.execute(runnable);
            } catch (RejectedExecutionException e2) {
                Log.e(CronetUrlRequestContext.s, "Exception posting task to executor", e2);
                synchronized (this.h) {
                    this.p = 6;
                    this.o = 6;
                    o(false);
                }
            }
        }
    }

    @GuardedBy("mNativeStreamLock")
    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            String str = CronetUrlRequestContext.s;
            Log.i(str, "destroyNativeStreamLocked " + toString(), new Object[0]);
            if (this.n == 0) {
                return;
            }
            b0b.c().a(this.n, this, z);
            this.a.t();
            this.n = 0L;
            Runnable runnable = this.s;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this.h) {
                if (t()) {
                    return;
                }
                if (this.p == 10 && this.o == 4) {
                    this.p = 7;
                    this.o = 7;
                    o(false);
                    try {
                        this.c.f(this, this.q);
                    } catch (Exception e2) {
                        Log.e(CronetUrlRequestContext.s, "Exception in onSucceeded method", e2);
                    }
                }
            }
        }
    }

    public final b1b x(int i, String str, String[] strArr, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), str, strArr, Long.valueOf(j)})) == null) {
            return new b1b(Arrays.asList(this.d), i, "", s(strArr), false, str, null, j);
        }
        return (b1b) invokeCommon.objValue;
    }

    public final void y() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int size = this.j.size();
            ByteBuffer[] byteBufferArr = new ByteBuffer[size];
            int[] iArr = new int[size];
            int[] iArr2 = new int[size];
            for (int i = 0; i < size; i++) {
                ByteBuffer poll = this.j.poll();
                byteBufferArr[i] = poll;
                iArr[i] = poll.position();
                iArr2[i] = poll.limit();
            }
            this.p = 9;
            this.l = true;
            f c2 = b0b.c();
            long j = this.n;
            if (this.k && this.i.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (c2.b(j, this, byteBufferArr, iArr, iArr2, z)) {
                return;
            }
            this.p = 8;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }
}
