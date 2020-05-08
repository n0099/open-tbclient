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
/* loaded from: classes.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final CronetUrlRequestContext lIA;
    private final BidirectionalStream.Callback lIB;
    private final String lIC;
    private final String lID;
    private final Object lIE;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> lIF;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> lIG;
    @GuardedBy("mNativeStreamLock")
    private boolean lIH;
    @GuardedBy("mNativeStreamLock")
    private boolean lII;
    @GuardedBy("mNativeStreamLock")
    private long lIJ;
    @GuardedBy("mNativeStreamLock")
    private State lIK;
    @GuardedBy("mNativeStreamLock")
    private State lIL;
    private UrlResponseInfo lIM;
    private a lIN;
    private Runnable lIO;
    private final Executor mExecutor;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
    private final class a implements Runnable {
        final /* synthetic */ CronetBidirectionalStream lIQ;
        boolean lIT;
        ByteBuffer mByteBuffer;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.lIQ.lIE) {
                    if (!this.lIQ.diL()) {
                        if (this.lIT) {
                            this.lIQ.lIK = State.READING_DONE;
                            if (this.lIQ.lIL == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.lIQ.lIK = State.WAITING_FOR_READ;
                        }
                        this.lIQ.lIB.a(this.lIQ, this.lIQ.lIM, byteBuffer, this.lIT);
                        if (z) {
                            this.lIQ.diM();
                        }
                    }
                }
            } catch (Exception e) {
                this.lIQ.n(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private final boolean lIT;
        private ByteBuffer mByteBuffer;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.lIT = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.lIE) {
                    if (!CronetBidirectionalStream.this.diL()) {
                        if (this.lIT) {
                            CronetBidirectionalStream.this.lIL = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.lIK == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.lIB.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lIM, byteBuffer, this.lIT);
                        if (z) {
                            CronetBidirectionalStream.this.diM();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.n(e);
            }
        }
    }

    private void diK() {
        boolean z = true;
        if (!$assertionsDisabled && this.lIL != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.lIG.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.lIG.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.lIG.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.lIL = State.WRITING;
        if (!nativeWritevData(this.lIJ, byteBufferArr, iArr, iArr2, (this.lIH && this.lIF.isEmpty()) ? false : false)) {
            this.lIL = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean diL() {
        return this.lIK != State.NOT_STARTED && this.lIJ == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diM() {
        synchronized (this.lIE) {
            if (!diL()) {
                if (this.lIL == State.WRITING_DONE && this.lIK == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.lIL = state;
                    this.lIK = state;
                    vg(false);
                    try {
                        this.lIB.b(this, this.lIM);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.lIE) {
                    if (!CronetBidirectionalStream.this.diL()) {
                        CronetBidirectionalStream.this.lII = z;
                        CronetBidirectionalStream.this.lIK = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.MU(CronetBidirectionalStream.this.lID) && CronetBidirectionalStream.this.lII) {
                            CronetBidirectionalStream.this.lIL = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.lIL = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.lIB.a(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.n(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.lIM = a(i, str, strArr, j);
            A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.lIE) {
                        if (!CronetBidirectionalStream.this.diL()) {
                            CronetBidirectionalStream.this.lIK = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.lIB.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lIM);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.n(e);
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
        this.lIM.fz(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.lIN.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.lIN.mByteBuffer = byteBuffer;
            this.lIN.lIT = i == 0;
            A(this.lIN);
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
        synchronized (this.lIE) {
            this.lIL = State.WAITING_FOR_FLUSH;
            if (!this.lIG.isEmpty()) {
                diK();
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
            A(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(S(strArr));
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.lIE) {
                    if (!CronetBidirectionalStream.this.diL()) {
                        try {
                            CronetBidirectionalStream.this.lIB.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lIM, headerBlock);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.n(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.lIM != null) {
            this.lIM.fz(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.lIB.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lIM);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MU(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> S(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void A(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.lIE) {
                State state = State.ERROR;
                this.lIL = state;
                this.lIK = state;
                vg(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.lIC), i, "", S(strArr), false, str, null);
        urlResponseInfo.fz(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void vg(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.lIJ != 0) {
            nativeDestroy(this.lIJ, z);
            this.lIJ = 0L;
            this.lIA.djb();
            if (this.lIO != null) {
                this.lIO.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.lIE) {
            if (!diL()) {
                State state = State.ERROR;
                this.lIL = state;
                this.lIK = state;
                vg(false);
                try {
                    this.lIB.a(this, this.lIM, turbonetException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        a(turbonetException);
    }

    private void b(final TurbonetException turbonetException) {
        A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
