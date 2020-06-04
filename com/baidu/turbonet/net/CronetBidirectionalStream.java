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
    private final CronetUrlRequestContext mdb;
    private final BidirectionalStream.Callback mdc;
    private final String mdd;
    private final String mde;
    private final Object mdf;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mdg;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mdh;
    @GuardedBy("mNativeStreamLock")
    private boolean mdi;
    @GuardedBy("mNativeStreamLock")
    private boolean mdj;
    @GuardedBy("mNativeStreamLock")
    private long mdk;
    @GuardedBy("mNativeStreamLock")
    private State mdl;
    @GuardedBy("mNativeStreamLock")
    private State mdm;
    private UrlResponseInfo mdn;
    private a mdo;
    private Runnable mdp;

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
        final /* synthetic */ CronetBidirectionalStream mdr;
        boolean mdu;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.mdr.mdf) {
                    if (!this.mdr.dqq()) {
                        if (this.mdu) {
                            this.mdr.mdl = State.READING_DONE;
                            if (this.mdr.mdm == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.mdr.mdl = State.WAITING_FOR_READ;
                        }
                        this.mdr.mdc.a(this.mdr, this.mdr.mdn, byteBuffer, this.mdu);
                        if (z) {
                            this.mdr.dqr();
                        }
                    }
                }
            } catch (Exception e) {
                this.mdr.u(e);
            }
        }
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mdu;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mdu = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mdf) {
                    if (!CronetBidirectionalStream.this.dqq()) {
                        if (this.mdu) {
                            CronetBidirectionalStream.this.mdm = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.mdl == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.mdc.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mdn, byteBuffer, this.mdu);
                        if (z) {
                            CronetBidirectionalStream.this.dqr();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.u(e);
            }
        }
    }

    private void dqp() {
        boolean z = true;
        if (!$assertionsDisabled && this.mdm != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.mdh.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mdh.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mdh.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.mdm = State.WRITING;
        if (!nativeWritevData(this.mdk, byteBufferArr, iArr, iArr2, (this.mdi && this.mdg.isEmpty()) ? false : false)) {
            this.mdm = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dqq() {
        return this.mdl != State.NOT_STARTED && this.mdk == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dqr() {
        synchronized (this.mdf) {
            if (!dqq()) {
                if (this.mdm == State.WRITING_DONE && this.mdl == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.mdm = state;
                    this.mdl = state;
                    vG(false);
                    try {
                        this.mdc.b(this, this.mdn);
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
                synchronized (CronetBidirectionalStream.this.mdf) {
                    if (!CronetBidirectionalStream.this.dqq()) {
                        CronetBidirectionalStream.this.mdj = z;
                        CronetBidirectionalStream.this.mdl = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.OI(CronetBidirectionalStream.this.mde) && CronetBidirectionalStream.this.mdj) {
                            CronetBidirectionalStream.this.mdm = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.mdm = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.mdc.a(CronetBidirectionalStream.this);
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
            this.mdn = a(i, str, strArr, j);
            C(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mdf) {
                        if (!CronetBidirectionalStream.this.dqq()) {
                            CronetBidirectionalStream.this.mdl = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.mdc.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mdn);
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
        this.mdn.fz(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.mdo.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.mdo.mByteBuffer = byteBuffer;
            this.mdo.mdu = i == 0;
            C(this.mdo);
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
        synchronized (this.mdf) {
            this.mdm = State.WAITING_FOR_FLUSH;
            if (!this.mdh.isEmpty()) {
                dqp();
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
                synchronized (CronetBidirectionalStream.this.mdf) {
                    if (!CronetBidirectionalStream.this.dqq()) {
                        try {
                            CronetBidirectionalStream.this.mdc.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mdn, headerBlock);
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
        if (this.mdn != null) {
            this.mdn.fz(j);
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
                    CronetBidirectionalStream.this.mdc.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.mdn);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.h("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean OI(String str) {
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
            synchronized (this.mdf) {
                State state = State.ERROR;
                this.mdm = state;
                this.mdl = state;
                vG(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.mdd), i, "", V(strArr), false, str, null);
        urlResponseInfo.fz(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void vG(boolean z) {
        com.baidu.turbonet.base.a.g("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mdk != 0) {
            nativeDestroy(this.mdk, z);
            this.mdk = 0L;
            this.mdb.dqG();
            if (this.mdp != null) {
                this.mdp.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.mdf) {
            if (!dqq()) {
                State state = State.ERROR;
                this.mdm = state;
                this.mdl = state;
                vG(false);
                try {
                    this.mdc.a(this, this.mdn, turbonetException);
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
