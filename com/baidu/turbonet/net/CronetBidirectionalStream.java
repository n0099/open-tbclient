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
    private final Object lIA;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> lIB;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> lIC;
    @GuardedBy("mNativeStreamLock")
    private boolean lID;
    @GuardedBy("mNativeStreamLock")
    private boolean lIE;
    @GuardedBy("mNativeStreamLock")
    private long lIF;
    @GuardedBy("mNativeStreamLock")
    private State lIG;
    @GuardedBy("mNativeStreamLock")
    private State lIH;
    private UrlResponseInfo lII;
    private a lIJ;
    private Runnable lIK;
    private final CronetUrlRequestContext lIw;
    private final BidirectionalStream.Callback lIx;
    private final String lIy;
    private final String lIz;
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
        final /* synthetic */ CronetBidirectionalStream lIM;
        boolean lIP;
        ByteBuffer mByteBuffer;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.lIM.lIA) {
                    if (!this.lIM.diO()) {
                        if (this.lIP) {
                            this.lIM.lIG = State.READING_DONE;
                            if (this.lIM.lIH == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.lIM.lIG = State.WAITING_FOR_READ;
                        }
                        this.lIM.lIx.a(this.lIM, this.lIM.lII, byteBuffer, this.lIP);
                        if (z) {
                            this.lIM.diP();
                        }
                    }
                }
            } catch (Exception e) {
                this.lIM.m(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private final boolean lIP;
        private ByteBuffer mByteBuffer;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.lIP = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.lIA) {
                    if (!CronetBidirectionalStream.this.diO()) {
                        if (this.lIP) {
                            CronetBidirectionalStream.this.lIH = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.lIG == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.lIx.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lII, byteBuffer, this.lIP);
                        if (z) {
                            CronetBidirectionalStream.this.diP();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.m(e);
            }
        }
    }

    private void diN() {
        boolean z = true;
        if (!$assertionsDisabled && this.lIH != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.lIC.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.lIC.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.lIC.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.lIH = State.WRITING;
        if (!nativeWritevData(this.lIF, byteBufferArr, iArr, iArr2, (this.lID && this.lIB.isEmpty()) ? false : false)) {
            this.lIH = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean diO() {
        return this.lIG != State.NOT_STARTED && this.lIF == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diP() {
        synchronized (this.lIA) {
            if (!diO()) {
                if (this.lIH == State.WRITING_DONE && this.lIG == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.lIH = state;
                    this.lIG = state;
                    vg(false);
                    try {
                        this.lIx.b(this, this.lII);
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
                synchronized (CronetBidirectionalStream.this.lIA) {
                    if (!CronetBidirectionalStream.this.diO()) {
                        CronetBidirectionalStream.this.lIE = z;
                        CronetBidirectionalStream.this.lIG = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.MR(CronetBidirectionalStream.this.lIz) && CronetBidirectionalStream.this.lIE) {
                            CronetBidirectionalStream.this.lIH = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.lIH = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.lIx.a(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.m(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.lII = a(i, str, strArr, j);
            A(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.lIA) {
                        if (!CronetBidirectionalStream.this.diO()) {
                            CronetBidirectionalStream.this.lIG = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.lIx.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lII);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.m(e);
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
        this.lII.fz(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.lIJ.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.lIJ.mByteBuffer = byteBuffer;
            this.lIJ.lIP = i == 0;
            A(this.lIJ);
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
        synchronized (this.lIA) {
            this.lIH = State.WAITING_FOR_FLUSH;
            if (!this.lIC.isEmpty()) {
                diN();
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
                synchronized (CronetBidirectionalStream.this.lIA) {
                    if (!CronetBidirectionalStream.this.diO()) {
                        try {
                            CronetBidirectionalStream.this.lIx.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lII, headerBlock);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.m(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.lII != null) {
            this.lII.fz(j);
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
                    CronetBidirectionalStream.this.lIx.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.lII);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MR(String str) {
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
            synchronized (this.lIA) {
                State state = State.ERROR;
                this.lIH = state;
                this.lIG = state;
                vg(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.lIy), i, "", S(strArr), false, str, null);
        urlResponseInfo.fz(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void vg(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.lIF != 0) {
            nativeDestroy(this.lIF, z);
            this.lIF = 0L;
            this.lIw.dje();
            if (this.lIK != null) {
                this.lIK.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.lIA) {
            if (!diO()) {
                State state = State.ERROR;
                this.lIH = state;
                this.lIG = state;
                vg(false);
                try {
                    this.lIx.a(this, this.lII, turbonetException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Exception exc) {
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
