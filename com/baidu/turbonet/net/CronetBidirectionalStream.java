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
/* loaded from: classes12.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final Executor mExecutor;
    private final CronetUrlRequestContext omV;
    private final BidirectionalStream.Callback omW;
    private final String omX;
    private final String omY;
    private final Object omZ;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> ona;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> onb;
    @GuardedBy("mNativeStreamLock")
    private boolean onc;
    @GuardedBy("mNativeStreamLock")
    private boolean ond;
    @GuardedBy("mNativeStreamLock")
    private long onf;
    @GuardedBy("mNativeStreamLock")
    private State ong;
    @GuardedBy("mNativeStreamLock")
    private State onh;
    private UrlResponseInfo oni;
    private a onj;
    private Runnable onk;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetBidirectionalStream onm;
        boolean onp;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.onm.omZ) {
                    if (!this.onm.ebs()) {
                        if (this.onp) {
                            this.onm.ong = State.READING_DONE;
                            if (this.onm.onh == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.onm.ong = State.WAITING_FOR_READ;
                        }
                        this.onm.omW.a(this.onm, this.onm.oni, byteBuffer, this.onp);
                        if (z) {
                            this.onm.ebt();
                        }
                    }
                }
            } catch (Exception e) {
                this.onm.y(e);
            }
        }
    }

    /* loaded from: classes12.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean onp;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.onp = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.omZ) {
                    if (!CronetBidirectionalStream.this.ebs()) {
                        if (this.onp) {
                            CronetBidirectionalStream.this.onh = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.ong == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.omW.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oni, byteBuffer, this.onp);
                        if (z) {
                            CronetBidirectionalStream.this.ebt();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void ebr() {
        boolean z = true;
        if (!$assertionsDisabled && this.onh != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.onb.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.onb.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.onb.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.onh = State.WRITING;
        if (!nativeWritevData(this.onf, byteBufferArr, iArr, iArr2, (this.onc && this.ona.isEmpty()) ? false : false)) {
            this.onh = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean ebs() {
        return this.ong != State.NOT_STARTED && this.onf == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebt() {
        synchronized (this.omZ) {
            if (!ebs()) {
                if (this.onh == State.WRITING_DONE && this.ong == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.onh = state;
                    this.ong = state;
                    zx(false);
                    try {
                        this.omW.b(this, this.oni);
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
                synchronized (CronetBidirectionalStream.this.omZ) {
                    if (!CronetBidirectionalStream.this.ebs()) {
                        CronetBidirectionalStream.this.ond = z;
                        CronetBidirectionalStream.this.ong = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.VU(CronetBidirectionalStream.this.omY) && CronetBidirectionalStream.this.ond) {
                            CronetBidirectionalStream.this.onh = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.onh = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.omW.a(CronetBidirectionalStream.this);
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
            this.oni = a(i, str, strArr, j);
            z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.omZ) {
                        if (!CronetBidirectionalStream.this.ebs()) {
                            CronetBidirectionalStream.this.ong = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.omW.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oni);
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
        this.oni.hr(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.onj.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.onj.mByteBuffer = byteBuffer;
            this.onj.onp = i == 0;
            z(this.onj);
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
        synchronized (this.omZ) {
            this.onh = State.WAITING_FOR_FLUSH;
            if (!this.onb.isEmpty()) {
                ebr();
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
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(Z(strArr));
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.omZ) {
                    if (!CronetBidirectionalStream.this.ebs()) {
                        try {
                            CronetBidirectionalStream.this.omW.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oni, headerBlock);
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
        if (this.oni != null) {
            this.oni.hr(j);
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
                    CronetBidirectionalStream.this.omW.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oni);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean VU(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> Z(String[] strArr) {
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
            synchronized (this.omZ) {
                State state = State.ERROR;
                this.onh = state;
                this.ong = state;
                zx(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.omX), i, "", Z(strArr), false, str, null);
        urlResponseInfo.hr(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void zx(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.onf != 0) {
            nativeDestroy(this.onf, z);
            this.onf = 0L;
            this.omV.ebI();
            if (this.onk != null) {
                this.onk.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.omZ) {
            if (!ebs()) {
                State state = State.ERROR;
                this.onh = state;
                this.ong = state;
                zx(false);
                try {
                    this.omW.a(this, this.oni, turbonetException);
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
