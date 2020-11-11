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
    @GuardedBy("mNativeStreamLock")
    private boolean olA;
    @GuardedBy("mNativeStreamLock")
    private long olB;
    @GuardedBy("mNativeStreamLock")
    private State olC;
    @GuardedBy("mNativeStreamLock")
    private State olD;
    private UrlResponseInfo olE;
    private a olF;
    private Runnable olG;
    private final CronetUrlRequestContext ols;
    private final BidirectionalStream.Callback olt;
    private final String olu;
    private final String olv;
    private final Object olw;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> olx;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> oly;
    @GuardedBy("mNativeStreamLock")
    private boolean olz;

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
        final /* synthetic */ CronetBidirectionalStream olI;
        boolean olL;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.olI.olw) {
                    if (!this.olI.ebt()) {
                        if (this.olL) {
                            this.olI.olC = State.READING_DONE;
                            if (this.olI.olD == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.olI.olC = State.WAITING_FOR_READ;
                        }
                        this.olI.olt.a(this.olI, this.olI.olE, byteBuffer, this.olL);
                        if (z) {
                            this.olI.ebu();
                        }
                    }
                }
            } catch (Exception e) {
                this.olI.y(e);
            }
        }
    }

    /* loaded from: classes17.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean olL;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.olL = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.olw) {
                    if (!CronetBidirectionalStream.this.ebt()) {
                        if (this.olL) {
                            CronetBidirectionalStream.this.olD = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.olC == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.olt.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.olE, byteBuffer, this.olL);
                        if (z) {
                            CronetBidirectionalStream.this.ebu();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void ebs() {
        boolean z = true;
        if (!$assertionsDisabled && this.olD != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.oly.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.oly.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.oly.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.olD = State.WRITING;
        if (!nativeWritevData(this.olB, byteBufferArr, iArr, iArr2, (this.olz && this.olx.isEmpty()) ? false : false)) {
            this.olD = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean ebt() {
        return this.olC != State.NOT_STARTED && this.olB == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebu() {
        synchronized (this.olw) {
            if (!ebt()) {
                if (this.olD == State.WRITING_DONE && this.olC == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.olD = state;
                    this.olC = state;
                    zq(false);
                    try {
                        this.olt.b(this, this.olE);
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
                synchronized (CronetBidirectionalStream.this.olw) {
                    if (!CronetBidirectionalStream.this.ebt()) {
                        CronetBidirectionalStream.this.olA = z;
                        CronetBidirectionalStream.this.olC = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Wj(CronetBidirectionalStream.this.olv) && CronetBidirectionalStream.this.olA) {
                            CronetBidirectionalStream.this.olD = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.olD = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.olt.a(CronetBidirectionalStream.this);
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
            this.olE = a(i, str, strArr, j);
            z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.olw) {
                        if (!CronetBidirectionalStream.this.ebt()) {
                            CronetBidirectionalStream.this.olC = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.olt.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.olE);
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
        this.olE.ho(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.olF.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.olF.mByteBuffer = byteBuffer;
            this.olF.olL = i == 0;
            z(this.olF);
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
        synchronized (this.olw) {
            this.olD = State.WAITING_FOR_FLUSH;
            if (!this.oly.isEmpty()) {
                ebs();
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
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(Y(strArr));
        z(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.olw) {
                    if (!CronetBidirectionalStream.this.ebt()) {
                        try {
                            CronetBidirectionalStream.this.olt.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.olE, headerBlock);
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
        if (this.olE != null) {
            this.olE.ho(j);
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
                    CronetBidirectionalStream.this.olt.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.olE);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.g("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Wj(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> Y(String[] strArr) {
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
            synchronized (this.olw) {
                State state = State.ERROR;
                this.olD = state;
                this.olC = state;
                zq(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.olu), i, "", Y(strArr), false, str, null);
        urlResponseInfo.ho(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void zq(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.olB != 0) {
            nativeDestroy(this.olB, z);
            this.olB = 0L;
            this.ols.ebJ();
            if (this.olG != null) {
                this.olG.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.olw) {
            if (!ebt()) {
                State state = State.ERROR;
                this.olD = state;
                this.olC = state;
                zq(false);
                try {
                    this.olt.a(this, this.olE, turbonetException);
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
