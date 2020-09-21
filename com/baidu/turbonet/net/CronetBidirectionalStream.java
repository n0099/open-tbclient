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
/* loaded from: classes15.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    @GuardedBy("mNativeStreamLock")
    private State nkA;
    @GuardedBy("mNativeStreamLock")
    private State nkB;
    private UrlResponseInfo nkC;
    private a nkD;
    private Runnable nkE;
    private final CronetUrlRequestContext nkq;
    private final BidirectionalStream.Callback nkr;
    private final String nks;
    private final String nkt;
    private final Object nku;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nkv;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nkw;
    @GuardedBy("mNativeStreamLock")
    private boolean nkx;
    @GuardedBy("mNativeStreamLock")
    private boolean nky;
    @GuardedBy("mNativeStreamLock")
    private long nkz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
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

    /* loaded from: classes15.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream nkG;
        boolean nkJ;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.nkG.nku) {
                    if (!this.nkG.dOh()) {
                        if (this.nkJ) {
                            this.nkG.nkA = State.READING_DONE;
                            if (this.nkG.nkB == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.nkG.nkA = State.WAITING_FOR_READ;
                        }
                        this.nkG.nkr.a(this.nkG, this.nkG.nkC, byteBuffer, this.nkJ);
                        if (z) {
                            this.nkG.dOi();
                        }
                    }
                }
            } catch (Exception e) {
                this.nkG.y(e);
            }
        }
    }

    /* loaded from: classes15.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean nkJ;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.nkJ = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.nku) {
                    if (!CronetBidirectionalStream.this.dOh()) {
                        if (this.nkJ) {
                            CronetBidirectionalStream.this.nkB = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.nkA == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.nkr.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nkC, byteBuffer, this.nkJ);
                        if (z) {
                            CronetBidirectionalStream.this.dOi();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void dOg() {
        boolean z = true;
        if (!$assertionsDisabled && this.nkB != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.nkw.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.nkw.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.nkw.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.nkB = State.WRITING;
        if (!nativeWritevData(this.nkz, byteBufferArr, iArr, iArr2, (this.nkx && this.nkv.isEmpty()) ? false : false)) {
            this.nkB = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dOh() {
        return this.nkA != State.NOT_STARTED && this.nkz == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dOi() {
        synchronized (this.nku) {
            if (!dOh()) {
                if (this.nkB == State.WRITING_DONE && this.nkA == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.nkB = state;
                    this.nkA = state;
                    xI(false);
                    try {
                        this.nkr.b(this, this.nkC);
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
                synchronized (CronetBidirectionalStream.this.nku) {
                    if (!CronetBidirectionalStream.this.dOh()) {
                        CronetBidirectionalStream.this.nky = z;
                        CronetBidirectionalStream.this.nkA = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.TE(CronetBidirectionalStream.this.nkt) && CronetBidirectionalStream.this.nky) {
                            CronetBidirectionalStream.this.nkB = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.nkB = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.nkr.a(CronetBidirectionalStream.this);
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
            this.nkC = a(i, str, strArr, j);
            y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.nku) {
                        if (!CronetBidirectionalStream.this.dOh()) {
                            CronetBidirectionalStream.this.nkA = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.nkr.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nkC);
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
        this.nkC.gt(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.nkD.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.nkD.mByteBuffer = byteBuffer;
            this.nkD.nkJ = i == 0;
            y(this.nkD);
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
        synchronized (this.nku) {
            this.nkB = State.WAITING_FOR_FLUSH;
            if (!this.nkw.isEmpty()) {
                dOg();
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
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(T(strArr));
        y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.nku) {
                    if (!CronetBidirectionalStream.this.dOh()) {
                        try {
                            CronetBidirectionalStream.this.nkr.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nkC, headerBlock);
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
        if (this.nkC != null) {
            this.nkC.gt(j);
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
                    CronetBidirectionalStream.this.nkr.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nkC);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean TE(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> T(String[] strArr) {
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
            synchronized (this.nku) {
                State state = State.ERROR;
                this.nkB = state;
                this.nkA = state;
                xI(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.nks), i, "", T(strArr), false, str, null);
        urlResponseInfo.gt(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void xI(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.nkz != 0) {
            nativeDestroy(this.nkz, z);
            this.nkz = 0L;
            this.nkq.dOx();
            if (this.nkE != null) {
                this.nkE.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.nku) {
            if (!dOh()) {
                State state = State.ERROR;
                this.nkB = state;
                this.nkA = state;
                xI(false);
                try {
                    this.nkr.a(this, this.nkC, turbonetException);
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
