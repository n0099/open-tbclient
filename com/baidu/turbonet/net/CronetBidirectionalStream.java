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
/* loaded from: classes14.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    private final CronetUrlRequestContext oBU;
    private final BidirectionalStream.Callback oBV;
    private final String oBW;
    private final String oBX;
    private final Object oBY;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> oBZ;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> oCa;
    @GuardedBy("mNativeStreamLock")
    private boolean oCb;
    @GuardedBy("mNativeStreamLock")
    private boolean oCc;
    @GuardedBy("mNativeStreamLock")
    private long oCd;
    @GuardedBy("mNativeStreamLock")
    private State oCe;
    @GuardedBy("mNativeStreamLock")
    private State oCf;
    private UrlResponseInfo oCg;
    private a oCh;
    private Runnable oCi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
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

    /* loaded from: classes14.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream oCk;
        boolean oCn;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.oCk.oBY) {
                    if (!this.oCk.egX()) {
                        if (this.oCn) {
                            this.oCk.oCe = State.READING_DONE;
                            if (this.oCk.oCf == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.oCk.oCe = State.WAITING_FOR_READ;
                        }
                        this.oCk.oBV.a(this.oCk, this.oCk.oCg, byteBuffer, this.oCn);
                        if (z) {
                            this.oCk.egY();
                        }
                    }
                }
            } catch (Exception e) {
                this.oCk.y(e);
            }
        }
    }

    /* loaded from: classes14.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean oCn;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.oCn = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.oBY) {
                    if (!CronetBidirectionalStream.this.egX()) {
                        if (this.oCn) {
                            CronetBidirectionalStream.this.oCf = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.oCe == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.oBV.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oCg, byteBuffer, this.oCn);
                        if (z) {
                            CronetBidirectionalStream.this.egY();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void egW() {
        boolean z = true;
        if (!$assertionsDisabled && this.oCf != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.oCa.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.oCa.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.oCa.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.oCf = State.WRITING;
        if (!nativeWritevData(this.oCd, byteBufferArr, iArr, iArr2, (this.oCb && this.oBZ.isEmpty()) ? false : false)) {
            this.oCf = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean egX() {
        return this.oCe != State.NOT_STARTED && this.oCd == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egY() {
        synchronized (this.oBY) {
            if (!egX()) {
                if (this.oCf == State.WRITING_DONE && this.oCe == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.oCf = state;
                    this.oCe = state;
                    Ab(false);
                    try {
                        this.oBV.b(this, this.oCg);
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
                synchronized (CronetBidirectionalStream.this.oBY) {
                    if (!CronetBidirectionalStream.this.egX()) {
                        CronetBidirectionalStream.this.oCc = z;
                        CronetBidirectionalStream.this.oCe = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Xj(CronetBidirectionalStream.this.oBX) && CronetBidirectionalStream.this.oCc) {
                            CronetBidirectionalStream.this.oCf = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.oCf = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.oBV.a(CronetBidirectionalStream.this);
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
            this.oCg = a(i, str, strArr, j);
            z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.oBY) {
                        if (!CronetBidirectionalStream.this.egX()) {
                            CronetBidirectionalStream.this.oCe = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.oBV.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oCg);
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
        this.oCg.hW(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.oCh.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.oCh.mByteBuffer = byteBuffer;
            this.oCh.oCn = i == 0;
            z(this.oCh);
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
        synchronized (this.oBY) {
            this.oCf = State.WAITING_FOR_FLUSH;
            if (!this.oCa.isEmpty()) {
                egW();
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
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(aa(strArr));
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.oBY) {
                    if (!CronetBidirectionalStream.this.egX()) {
                        try {
                            CronetBidirectionalStream.this.oBV.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oCg, headerBlock);
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
        if (this.oCg != null) {
            this.oCg.hW(j);
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
                    CronetBidirectionalStream.this.oBV.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oCg);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Xj(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> aa(String[] strArr) {
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
            synchronized (this.oBY) {
                State state = State.ERROR;
                this.oCf = state;
                this.oCe = state;
                Ab(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.oBW), i, "", aa(strArr), false, str, null);
        urlResponseInfo.hW(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void Ab(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.oCd != 0) {
            nativeDestroy(this.oCd, z);
            this.oCd = 0L;
            this.oBU.ehn();
            if (this.oCi != null) {
                this.oCi.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.oBY) {
            if (!egX()) {
                State state = State.ERROR;
                this.oCf = state;
                this.oCe = state;
                Ab(false);
                try {
                    this.oBV.a(this, this.oCg, turbonetException);
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
