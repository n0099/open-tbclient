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
/* loaded from: classes10.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    @GuardedBy("mNativeStreamLock")
    private long naA;
    @GuardedBy("mNativeStreamLock")
    private State naB;
    @GuardedBy("mNativeStreamLock")
    private State naC;
    private UrlResponseInfo naD;
    private a naE;
    private Runnable naF;
    private final CronetUrlRequestContext nar;
    private final BidirectionalStream.Callback nas;
    private final String nat;
    private final String nau;
    private final Object nav;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> naw;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nax;
    @GuardedBy("mNativeStreamLock")
    private boolean nay;
    @GuardedBy("mNativeStreamLock")
    private boolean naz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream naH;
        boolean naK;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.naH.nav) {
                    if (!this.naH.dKj()) {
                        if (this.naK) {
                            this.naH.naB = State.READING_DONE;
                            if (this.naH.naC == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.naH.naB = State.WAITING_FOR_READ;
                        }
                        this.naH.nas.a(this.naH, this.naH.naD, byteBuffer, this.naK);
                        if (z) {
                            this.naH.dKk();
                        }
                    }
                }
            } catch (Exception e) {
                this.naH.y(e);
            }
        }
    }

    /* loaded from: classes10.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean naK;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.naK = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.nav) {
                    if (!CronetBidirectionalStream.this.dKj()) {
                        if (this.naK) {
                            CronetBidirectionalStream.this.naC = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.naB == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.nas.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.naD, byteBuffer, this.naK);
                        if (z) {
                            CronetBidirectionalStream.this.dKk();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void dKi() {
        boolean z = true;
        if (!$assertionsDisabled && this.naC != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.nax.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.nax.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.nax.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.naC = State.WRITING;
        if (!nativeWritevData(this.naA, byteBufferArr, iArr, iArr2, (this.nay && this.naw.isEmpty()) ? false : false)) {
            this.naC = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dKj() {
        return this.naB != State.NOT_STARTED && this.naA == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKk() {
        synchronized (this.nav) {
            if (!dKj()) {
                if (this.naC == State.WRITING_DONE && this.naB == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.naC = state;
                    this.naB = state;
                    xz(false);
                    try {
                        this.nas.b(this, this.naD);
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
                synchronized (CronetBidirectionalStream.this.nav) {
                    if (!CronetBidirectionalStream.this.dKj()) {
                        CronetBidirectionalStream.this.naz = z;
                        CronetBidirectionalStream.this.naB = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Tf(CronetBidirectionalStream.this.nau) && CronetBidirectionalStream.this.naz) {
                            CronetBidirectionalStream.this.naC = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.naC = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.nas.a(CronetBidirectionalStream.this);
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
            this.naD = a(i, str, strArr, j);
            y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.nav) {
                        if (!CronetBidirectionalStream.this.dKj()) {
                            CronetBidirectionalStream.this.naB = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.nas.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.naD);
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
        this.naD.gf(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.naE.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.naE.mByteBuffer = byteBuffer;
            this.naE.naK = i == 0;
            y(this.naE);
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
        synchronized (this.nav) {
            this.naC = State.WAITING_FOR_FLUSH;
            if (!this.nax.isEmpty()) {
                dKi();
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
                synchronized (CronetBidirectionalStream.this.nav) {
                    if (!CronetBidirectionalStream.this.dKj()) {
                        try {
                            CronetBidirectionalStream.this.nas.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.naD, headerBlock);
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
        if (this.naD != null) {
            this.naD.gf(j);
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
                    CronetBidirectionalStream.this.nas.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.naD);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Tf(String str) {
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
            synchronized (this.nav) {
                State state = State.ERROR;
                this.naC = state;
                this.naB = state;
                xz(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.nat), i, "", T(strArr), false, str, null);
        urlResponseInfo.gf(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void xz(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.naA != 0) {
            nativeDestroy(this.naA, z);
            this.naA = 0L;
            this.nar.dKz();
            if (this.naF != null) {
                this.naF.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.nav) {
            if (!dKj()) {
                State state = State.ERROR;
                this.naC = state;
                this.naB = state;
                xz(false);
                try {
                    this.nas.a(this, this.naD, turbonetException);
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
