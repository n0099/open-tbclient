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
/* loaded from: classes19.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    private final CronetUrlRequestContext mGY;
    private final BidirectionalStream.Callback mGZ;
    private final String mHa;
    private final String mHb;
    private final Object mHc;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mHd;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mHe;
    @GuardedBy("mNativeStreamLock")
    private boolean mHf;
    @GuardedBy("mNativeStreamLock")
    private boolean mHg;
    @GuardedBy("mNativeStreamLock")
    private long mHh;
    @GuardedBy("mNativeStreamLock")
    private State mHi;
    @GuardedBy("mNativeStreamLock")
    private State mHj;
    private UrlResponseInfo mHk;
    private a mHl;
    private Runnable mHm;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
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

    /* loaded from: classes19.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream mHo;
        boolean mHr;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.mHo.mHc) {
                    if (!this.mHo.dym()) {
                        if (this.mHr) {
                            this.mHo.mHi = State.READING_DONE;
                            if (this.mHo.mHj == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.mHo.mHi = State.WAITING_FOR_READ;
                        }
                        this.mHo.mGZ.a(this.mHo, this.mHo.mHk, byteBuffer, this.mHr);
                        if (z) {
                            this.mHo.dyn();
                        }
                    }
                }
            } catch (Exception e) {
                this.mHo.u(e);
            }
        }
    }

    /* loaded from: classes19.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mHr;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mHr = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mHc) {
                    if (!CronetBidirectionalStream.this.dym()) {
                        if (this.mHr) {
                            CronetBidirectionalStream.this.mHj = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.mHi == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.mGZ.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHk, byteBuffer, this.mHr);
                        if (z) {
                            CronetBidirectionalStream.this.dyn();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.u(e);
            }
        }
    }

    private void dyl() {
        boolean z = true;
        if (!$assertionsDisabled && this.mHj != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.mHe.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mHe.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mHe.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mHj = State.WRITING;
        if (!nativeWritevData(this.mHh, byteBufferArr, iArr, iArr2, (this.mHf && this.mHd.isEmpty()) ? false : false)) {
            this.mHj = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dym() {
        return this.mHi != State.NOT_STARTED && this.mHh == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyn() {
        synchronized (this.mHc) {
            if (!dym()) {
                if (this.mHj == State.WRITING_DONE && this.mHi == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mHj = state;
                    this.mHi = state;
                    wH(false);
                    try {
                        this.mGZ.b(this, this.mHk);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mHc) {
                    if (!CronetBidirectionalStream.this.dym()) {
                        CronetBidirectionalStream.this.mHg = z;
                        CronetBidirectionalStream.this.mHi = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Qg(CronetBidirectionalStream.this.mHb) && CronetBidirectionalStream.this.mHg) {
                            CronetBidirectionalStream.this.mHj = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.mHj = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.mGZ.a(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.u(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.mHk = a(i, str, strArr, j);
            B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mHc) {
                        if (!CronetBidirectionalStream.this.dym()) {
                            CronetBidirectionalStream.this.mHi = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.mGZ.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHk);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.u(e);
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
        this.mHk.fR(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.mHl.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.mHl.mByteBuffer = byteBuffer;
            this.mHl.mHr = i == 0;
            B(this.mHl);
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
        synchronized (this.mHc) {
            this.mHj = State.WAITING_FOR_FLUSH;
            if (!this.mHe.isEmpty()) {
                dyl();
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
            B(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(S(strArr));
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mHc) {
                    if (!CronetBidirectionalStream.this.dym()) {
                        try {
                            CronetBidirectionalStream.this.mGZ.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHk, headerBlock);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.u(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.mHk != null) {
            this.mHk.fR(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.mGZ.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHk);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Qg(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> S(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void B(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.mHc) {
                State state = State.ERROR;
                this.mHj = state;
                this.mHi = state;
                wH(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.mHa), i, "", S(strArr), false, str, null);
        urlResponseInfo.fR(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void wH(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mHh != 0) {
            nativeDestroy(this.mHh, z);
            this.mHh = 0L;
            this.mGY.dyC();
            if (this.mHm != null) {
                this.mHm.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.mHc) {
            if (!dym()) {
                State state = State.ERROR;
                this.mHj = state;
                this.mHi = state;
                wH(false);
                try {
                    this.mGZ.a(this, this.mHk, turbonetException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in CalledByNative method", exc);
        a(turbonetException);
    }

    private void b(final TurbonetException turbonetException) {
        B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
