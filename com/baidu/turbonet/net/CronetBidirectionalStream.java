package com.baidu.turbonet.net;

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
import org.apache.http.client.methods.HttpHead;
@JNINamespace
/* loaded from: classes17.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    private UrlResponseInfo ocA;
    private a ocB;
    private Runnable ocC;
    private final CronetUrlRequestContext ocn;
    private final BidirectionalStream.Callback oco;
    private final String ocp;
    private final String ocq;
    private final Object ocs;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> oct;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> ocu;
    @GuardedBy("mNativeStreamLock")
    private boolean ocv;
    @GuardedBy("mNativeStreamLock")
    private boolean ocw;
    @GuardedBy("mNativeStreamLock")
    private long ocx;
    @GuardedBy("mNativeStreamLock")
    private State ocy;
    @GuardedBy("mNativeStreamLock")
    private State ocz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public enum State {
        NOT_STARTED,
        STARTED,
        WAITING_FOR_READ,
        READING,
        READING_DONE,
        CANCELED,
        ERROR,
        SUCCESS,
        WAITING_FOR_FLUSH,
        WRITING,
        WRITING_DONE
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

    static {
        $assertionsDisabled = !CronetBidirectionalStream.class.desiredAssertionStatus();
    }

    /* loaded from: classes17.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream ocE;
        boolean ocH;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.ocE.ocs) {
                    if (!this.ocE.dXL()) {
                        if (this.ocH) {
                            this.ocE.ocy = State.READING_DONE;
                            if (this.ocE.ocz == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.ocE.ocy = State.WAITING_FOR_READ;
                        }
                        this.ocE.oco.a(this.ocE, this.ocE.ocA, byteBuffer, this.ocH);
                        if (z) {
                            this.ocE.dXM();
                        }
                    }
                }
            } catch (Exception e) {
                this.ocE.y(e);
            }
        }
    }

    /* loaded from: classes17.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean ocH;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.ocH = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.ocs) {
                    if (!CronetBidirectionalStream.this.dXL()) {
                        if (this.ocH) {
                            CronetBidirectionalStream.this.ocz = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.ocy == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.oco.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.ocA, byteBuffer, this.ocH);
                        if (z) {
                            CronetBidirectionalStream.this.dXM();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void dXK() {
        boolean z = true;
        if (!$assertionsDisabled && this.ocz != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.ocu.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.ocu.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.ocu.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.ocz = State.WRITING;
        if (!nativeWritevData(this.ocx, byteBufferArr, iArr, iArr2, (this.ocv && this.oct.isEmpty()) ? false : false)) {
            this.ocz = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dXL() {
        return this.ocy != State.NOT_STARTED && this.ocx == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXM() {
        synchronized (this.ocs) {
            if (!dXL()) {
                if (this.ocz == State.WRITING_DONE && this.ocy == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.ocz = state;
                    this.ocy = state;
                    zf(false);
                    try {
                        this.oco.b(this, this.ocA);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.ocs) {
                    if (!CronetBidirectionalStream.this.dXL()) {
                        CronetBidirectionalStream.this.ocw = z;
                        CronetBidirectionalStream.this.ocy = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.VG(CronetBidirectionalStream.this.ocq) && CronetBidirectionalStream.this.ocw) {
                            CronetBidirectionalStream.this.ocz = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.ocz = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.oco.a(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.y(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.ocA = a(i, str, strArr, j);
            z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.ocs) {
                        if (!CronetBidirectionalStream.this.dXL()) {
                            CronetBidirectionalStream.this.ocy = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.oco.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.ocA);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.y(e);
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            b(new TurbonetException("Cannot prepare ResponseInfo", null));
        }
    }

    @CalledByNative
    private void onReadCompleted(ByteBuffer byteBuffer, int i, int i2, int i3, long j) {
        this.ocA.gS(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.ocB.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.ocB.mByteBuffer = byteBuffer;
            this.ocB.ocH = i == 0;
            z(this.ocB);
        }
    }

    @CalledByNative
    private void onWritevCompleted(ByteBuffer[] byteBufferArr, int[] iArr, int[] iArr2, boolean z) {
        if (!$assertionsDisabled && byteBufferArr.length != iArr.length) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length != iArr2.length) {
            throw new AssertionError();
        }
        synchronized (this.ocs) {
            this.ocz = State.WAITING_FOR_FLUSH;
            if (!this.ocu.isEmpty()) {
                dXK();
            }
        }
        int i = 0;
        while (i < byteBufferArr.length) {
            ByteBuffer byteBuffer = byteBufferArr[i];
            if (byteBuffer.position() != iArr[i] || byteBuffer.limit() != iArr2[i]) {
                b(new TurbonetException("ByteBuffer modified externally during write", null));
                return;
            }
            byteBuffer.position(byteBuffer.limit());
            z(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(X(strArr));
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.ocs) {
                    if (!CronetBidirectionalStream.this.dXL()) {
                        try {
                            CronetBidirectionalStream.this.oco.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.ocA, headerBlock);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.y(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.ocA != null) {
            this.ocA.gS(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.oco.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.ocA);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean VG(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> X(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void z(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.ocs) {
                State state = State.ERROR;
                this.ocz = state;
                this.ocy = state;
                zf(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.ocp), i, "", X(strArr), false, str, null);
        urlResponseInfo.gS(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void zf(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.ocx != 0) {
            nativeDestroy(this.ocx, z);
            this.ocx = 0L;
            this.ocn.dYb();
            if (this.ocC != null) {
                this.ocC.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.ocs) {
            if (!dXL()) {
                State state = State.ERROR;
                this.ocz = state;
                this.ocy = state;
                zf(false);
                try {
                    this.oco.a(this, this.ocA, turbonetException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in CalledByNative method", exc);
        a(turbonetException);
    }

    private void b(final TurbonetException turbonetException) {
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
