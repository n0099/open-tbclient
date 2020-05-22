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
    private final CronetUrlRequestContext mbR;
    private final BidirectionalStream.Callback mbS;
    private final String mbT;
    private final String mbU;
    private final Object mbV;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mbW;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mbX;
    @GuardedBy("mNativeStreamLock")
    private boolean mbY;
    @GuardedBy("mNativeStreamLock")
    private boolean mbZ;
    @GuardedBy("mNativeStreamLock")
    private long mca;
    @GuardedBy("mNativeStreamLock")
    private State mcb;
    @GuardedBy("mNativeStreamLock")
    private State mcc;
    private UrlResponseInfo mcd;
    private a mce;
    private Runnable mcf;

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
        final /* synthetic */ CronetBidirectionalStream mch;
        boolean mck;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.mch.mbV) {
                    if (!this.mch.dqc()) {
                        if (this.mck) {
                            this.mch.mcb = State.READING_DONE;
                            if (this.mch.mcc == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.mch.mcb = State.WAITING_FOR_READ;
                        }
                        this.mch.mbS.a(this.mch, this.mch.mcd, byteBuffer, this.mck);
                        if (z) {
                            this.mch.dqd();
                        }
                    }
                }
            } catch (Exception e) {
                this.mch.u(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mck;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mck = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mbV) {
                    if (!CronetBidirectionalStream.this.dqc()) {
                        if (this.mck) {
                            CronetBidirectionalStream.this.mcc = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.mcb == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.mbS.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mcd, byteBuffer, this.mck);
                        if (z) {
                            CronetBidirectionalStream.this.dqd();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.u(e);
            }
        }
    }

    private void dqb() {
        boolean z = true;
        if (!$assertionsDisabled && this.mcc != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.mbX.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mbX.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mbX.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mcc = State.WRITING;
        if (!nativeWritevData(this.mca, byteBufferArr, iArr, iArr2, (this.mbY && this.mbW.isEmpty()) ? false : false)) {
            this.mcc = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dqc() {
        return this.mcb != State.NOT_STARTED && this.mca == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqd() {
        synchronized (this.mbV) {
            if (!dqc()) {
                if (this.mcc == State.WRITING_DONE && this.mcb == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mcc = state;
                    this.mcb = state;
                    vE(false);
                    try {
                        this.mbS.b(this, this.mcd);
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
                synchronized (CronetBidirectionalStream.this.mbV) {
                    if (!CronetBidirectionalStream.this.dqc()) {
                        CronetBidirectionalStream.this.mbZ = z;
                        CronetBidirectionalStream.this.mcb = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.OH(CronetBidirectionalStream.this.mbU) && CronetBidirectionalStream.this.mbZ) {
                            CronetBidirectionalStream.this.mcc = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.mcc = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.mbS.a(CronetBidirectionalStream.this);
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
            this.mcd = a(i, str, strArr, j);
            C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mbV) {
                        if (!CronetBidirectionalStream.this.dqc()) {
                            CronetBidirectionalStream.this.mcb = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.mbS.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mcd);
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
        this.mcd.fz(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.mce.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.mce.mByteBuffer = byteBuffer;
            this.mce.mck = i == 0;
            C(this.mce);
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
        synchronized (this.mbV) {
            this.mcc = State.WAITING_FOR_FLUSH;
            if (!this.mbX.isEmpty()) {
                dqb();
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
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(V(strArr));
        C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mbV) {
                    if (!CronetBidirectionalStream.this.dqc()) {
                        try {
                            CronetBidirectionalStream.this.mbS.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mcd, headerBlock);
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
        if (this.mcd != null) {
            this.mcd.fz(j);
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
                    CronetBidirectionalStream.this.mbS.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mcd);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean OH(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> V(String[] strArr) {
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
            synchronized (this.mbV) {
                State state = State.ERROR;
                this.mcc = state;
                this.mcb = state;
                vE(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.mbT), i, "", V(strArr), false, str, null);
        urlResponseInfo.fz(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void vE(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mca != 0) {
            nativeDestroy(this.mca, z);
            this.mca = 0L;
            this.mbR.dqs();
            if (this.mcf != null) {
                this.mcf.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.mbV) {
            if (!dqc()) {
                State state = State.ERROR;
                this.mcc = state;
                this.mcb = state;
                vE(false);
                try {
                    this.mbS.a(this, this.mcd, turbonetException);
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
