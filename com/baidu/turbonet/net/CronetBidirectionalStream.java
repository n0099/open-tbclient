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
    private a nAa;
    private Runnable nAb;
    private final CronetUrlRequestContext nzN;
    private final BidirectionalStream.Callback nzO;
    private final String nzP;
    private final String nzQ;
    private final Object nzR;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nzS;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nzT;
    @GuardedBy("mNativeStreamLock")
    private boolean nzU;
    @GuardedBy("mNativeStreamLock")
    private boolean nzV;
    @GuardedBy("mNativeStreamLock")
    private long nzW;
    @GuardedBy("mNativeStreamLock")
    private State nzX;
    @GuardedBy("mNativeStreamLock")
    private State nzY;
    private UrlResponseInfo nzZ;

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
        final /* synthetic */ CronetBidirectionalStream nAd;
        boolean nAg;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.nAd.nzR) {
                    if (!this.nAd.dRT()) {
                        if (this.nAg) {
                            this.nAd.nzX = State.READING_DONE;
                            if (this.nAd.nzY == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.nAd.nzX = State.WAITING_FOR_READ;
                        }
                        this.nAd.nzO.a(this.nAd, this.nAd.nzZ, byteBuffer, this.nAg);
                        if (z) {
                            this.nAd.dRU();
                        }
                    }
                }
            } catch (Exception e) {
                this.nAd.y(e);
            }
        }
    }

    /* loaded from: classes17.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean nAg;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.nAg = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.nzR) {
                    if (!CronetBidirectionalStream.this.dRT()) {
                        if (this.nAg) {
                            CronetBidirectionalStream.this.nzY = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.nzX == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.nzO.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nzZ, byteBuffer, this.nAg);
                        if (z) {
                            CronetBidirectionalStream.this.dRU();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void dRS() {
        boolean z = true;
        if (!$assertionsDisabled && this.nzY != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.nzT.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.nzT.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.nzT.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.nzY = State.WRITING;
        if (!nativeWritevData(this.nzW, byteBufferArr, iArr, iArr2, (this.nzU && this.nzS.isEmpty()) ? false : false)) {
            this.nzY = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dRT() {
        return this.nzX != State.NOT_STARTED && this.nzW == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dRU() {
        synchronized (this.nzR) {
            if (!dRT()) {
                if (this.nzY == State.WRITING_DONE && this.nzX == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.nzY = state;
                    this.nzX = state;
                    yp(false);
                    try {
                        this.nzO.b(this, this.nzZ);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.nzR) {
                    if (!CronetBidirectionalStream.this.dRT()) {
                        CronetBidirectionalStream.this.nzV = z;
                        CronetBidirectionalStream.this.nzX = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Us(CronetBidirectionalStream.this.nzQ) && CronetBidirectionalStream.this.nzV) {
                            CronetBidirectionalStream.this.nzY = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.nzY = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.nzO.a(CronetBidirectionalStream.this);
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
            this.nzZ = a(i, str, strArr, j);
            y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.nzR) {
                        if (!CronetBidirectionalStream.this.dRT()) {
                            CronetBidirectionalStream.this.nzX = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.nzO.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nzZ);
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
        this.nzZ.gL(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.nAa.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.nAa.mByteBuffer = byteBuffer;
            this.nAa.nAg = i == 0;
            y(this.nAa);
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
        synchronized (this.nzR) {
            this.nzY = State.WAITING_FOR_FLUSH;
            if (!this.nzT.isEmpty()) {
                dRS();
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
            y(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(W(strArr));
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.nzR) {
                    if (!CronetBidirectionalStream.this.dRT()) {
                        try {
                            CronetBidirectionalStream.this.nzO.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nzZ, headerBlock);
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
        if (this.nzZ != null) {
            this.nzZ.gL(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.nzO.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nzZ);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Us(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> W(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void y(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.nzR) {
                State state = State.ERROR;
                this.nzY = state;
                this.nzX = state;
                yp(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.nzP), i, "", W(strArr), false, str, null);
        urlResponseInfo.gL(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void yp(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.nzW != 0) {
            nativeDestroy(this.nzW, z);
            this.nzW = 0L;
            this.nzN.dSj();
            if (this.nAb != null) {
                this.nAb.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.nzR) {
            if (!dRT()) {
                State state = State.ERROR;
                this.nzY = state;
                this.nzX = state;
                yp(false);
                try {
                    this.nzO.a(this, this.nzZ, turbonetException);
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
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
