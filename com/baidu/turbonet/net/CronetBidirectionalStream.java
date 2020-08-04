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
    private final CronetUrlRequestContext mHa;
    private final BidirectionalStream.Callback mHb;
    private final String mHc;
    private final String mHd;
    private final Object mHe;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mHf;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mHg;
    @GuardedBy("mNativeStreamLock")
    private boolean mHh;
    @GuardedBy("mNativeStreamLock")
    private boolean mHi;
    @GuardedBy("mNativeStreamLock")
    private long mHj;
    @GuardedBy("mNativeStreamLock")
    private State mHk;
    @GuardedBy("mNativeStreamLock")
    private State mHl;
    private UrlResponseInfo mHm;
    private a mHn;
    private Runnable mHo;

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
        final /* synthetic */ CronetBidirectionalStream mHq;
        boolean mHt;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.mHq.mHe) {
                    if (!this.mHq.dyn()) {
                        if (this.mHt) {
                            this.mHq.mHk = State.READING_DONE;
                            if (this.mHq.mHl == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.mHq.mHk = State.WAITING_FOR_READ;
                        }
                        this.mHq.mHb.a(this.mHq, this.mHq.mHm, byteBuffer, this.mHt);
                        if (z) {
                            this.mHq.dyo();
                        }
                    }
                }
            } catch (Exception e) {
                this.mHq.u(e);
            }
        }
    }

    /* loaded from: classes19.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mHt;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mHt = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mHe) {
                    if (!CronetBidirectionalStream.this.dyn()) {
                        if (this.mHt) {
                            CronetBidirectionalStream.this.mHl = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.mHk == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.mHb.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHm, byteBuffer, this.mHt);
                        if (z) {
                            CronetBidirectionalStream.this.dyo();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.u(e);
            }
        }
    }

    private void dym() {
        boolean z = true;
        if (!$assertionsDisabled && this.mHl != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.mHg.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mHg.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mHg.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mHl = State.WRITING;
        if (!nativeWritevData(this.mHj, byteBufferArr, iArr, iArr2, (this.mHh && this.mHf.isEmpty()) ? false : false)) {
            this.mHl = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dyn() {
        return this.mHk != State.NOT_STARTED && this.mHj == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyo() {
        synchronized (this.mHe) {
            if (!dyn()) {
                if (this.mHl == State.WRITING_DONE && this.mHk == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mHl = state;
                    this.mHk = state;
                    wH(false);
                    try {
                        this.mHb.b(this, this.mHm);
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
                synchronized (CronetBidirectionalStream.this.mHe) {
                    if (!CronetBidirectionalStream.this.dyn()) {
                        CronetBidirectionalStream.this.mHi = z;
                        CronetBidirectionalStream.this.mHk = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Qg(CronetBidirectionalStream.this.mHd) && CronetBidirectionalStream.this.mHi) {
                            CronetBidirectionalStream.this.mHl = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.mHl = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.mHb.a(CronetBidirectionalStream.this);
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
            this.mHm = a(i, str, strArr, j);
            B(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mHe) {
                        if (!CronetBidirectionalStream.this.dyn()) {
                            CronetBidirectionalStream.this.mHk = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.mHb.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHm);
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
        this.mHm.fR(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.mHn.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.mHn.mByteBuffer = byteBuffer;
            this.mHn.mHt = i == 0;
            B(this.mHn);
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
        synchronized (this.mHe) {
            this.mHl = State.WAITING_FOR_FLUSH;
            if (!this.mHg.isEmpty()) {
                dym();
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
                synchronized (CronetBidirectionalStream.this.mHe) {
                    if (!CronetBidirectionalStream.this.dyn()) {
                        try {
                            CronetBidirectionalStream.this.mHb.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHm, headerBlock);
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
        if (this.mHm != null) {
            this.mHm.fR(j);
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
                    CronetBidirectionalStream.this.mHb.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mHm);
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
            synchronized (this.mHe) {
                State state = State.ERROR;
                this.mHl = state;
                this.mHk = state;
                wH(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.mHc), i, "", S(strArr), false, str, null);
        urlResponseInfo.fR(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void wH(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mHj != 0) {
            nativeDestroy(this.mHj, z);
            this.mHj = 0L;
            this.mHa.dyD();
            if (this.mHo != null) {
                this.mHo.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.mHe) {
            if (!dyn()) {
                State state = State.ERROR;
                this.mHl = state;
                this.mHk = state;
                wH(false);
                try {
                    this.mHb.a(this, this.mHm, turbonetException);
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
