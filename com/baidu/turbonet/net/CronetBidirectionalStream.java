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
    private final Executor mExecutor;
    private final CronetUrlRequestContext myQ;
    private final BidirectionalStream.Callback myR;
    private final String myS;
    private final String myT;
    private final Object myU;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> myV;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> myW;
    @GuardedBy("mNativeStreamLock")
    private boolean myX;
    @GuardedBy("mNativeStreamLock")
    private boolean myY;
    @GuardedBy("mNativeStreamLock")
    private long myZ;
    @GuardedBy("mNativeStreamLock")
    private State mza;
    @GuardedBy("mNativeStreamLock")
    private State mzb;
    private UrlResponseInfo mzc;
    private a mzd;
    private Runnable mze;

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
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream mzg;
        boolean mzj;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.mzg.myU) {
                    if (!this.mzg.duV()) {
                        if (this.mzj) {
                            this.mzg.mza = State.READING_DONE;
                            if (this.mzg.mzb == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.mzg.mza = State.WAITING_FOR_READ;
                        }
                        this.mzg.myR.a(this.mzg, this.mzg.mzc, byteBuffer, this.mzj);
                        if (z) {
                            this.mzg.duW();
                        }
                    }
                }
            } catch (Exception e) {
                this.mzg.u(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mzj;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mzj = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.myU) {
                    if (!CronetBidirectionalStream.this.duV()) {
                        if (this.mzj) {
                            CronetBidirectionalStream.this.mzb = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.mza == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.myR.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mzc, byteBuffer, this.mzj);
                        if (z) {
                            CronetBidirectionalStream.this.duW();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.u(e);
            }
        }
    }

    private void duU() {
        boolean z = true;
        if (!$assertionsDisabled && this.mzb != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.myW.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.myW.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.myW.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mzb = State.WRITING;
        if (!nativeWritevData(this.myZ, byteBufferArr, iArr, iArr2, (this.myX && this.myV.isEmpty()) ? false : false)) {
            this.mzb = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean duV() {
        return this.mza != State.NOT_STARTED && this.myZ == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duW() {
        synchronized (this.myU) {
            if (!duV()) {
                if (this.mzb == State.WRITING_DONE && this.mza == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mzb = state;
                    this.mza = state;
                    wc(false);
                    try {
                        this.myR.b(this, this.mzc);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.myU) {
                    if (!CronetBidirectionalStream.this.duV()) {
                        CronetBidirectionalStream.this.myY = z;
                        CronetBidirectionalStream.this.mza = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Pu(CronetBidirectionalStream.this.myT) && CronetBidirectionalStream.this.myY) {
                            CronetBidirectionalStream.this.mzb = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.mzb = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.myR.a(CronetBidirectionalStream.this);
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
            this.mzc = a(i, str, strArr, j);
            C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.myU) {
                        if (!CronetBidirectionalStream.this.duV()) {
                            CronetBidirectionalStream.this.mza = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.myR.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mzc);
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
        this.mzc.fE(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.mzd.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.mzd.mByteBuffer = byteBuffer;
            this.mzd.mzj = i == 0;
            C(this.mzd);
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
        synchronized (this.myU) {
            this.mzb = State.WAITING_FOR_FLUSH;
            if (!this.myW.isEmpty()) {
                duU();
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
            C(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(U(strArr));
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.myU) {
                    if (!CronetBidirectionalStream.this.duV()) {
                        try {
                            CronetBidirectionalStream.this.myR.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mzc, headerBlock);
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
        if (this.mzc != null) {
            this.mzc.fE(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.myR.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mzc);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Pu(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> U(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void C(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.myU) {
                State state = State.ERROR;
                this.mzb = state;
                this.mza = state;
                wc(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.myS), i, "", U(strArr), false, str, null);
        urlResponseInfo.fE(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void wc(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.myZ != 0) {
            nativeDestroy(this.myZ, z);
            this.myZ = 0L;
            this.myQ.dvl();
            if (this.mze != null) {
                this.mze.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.myU) {
            if (!duV()) {
                State state = State.ERROR;
                this.mzb = state;
                this.mza = state;
                wc(false);
                try {
                    this.myR.a(this, this.mzc, turbonetException);
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
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
