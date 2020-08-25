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
    private final CronetUrlRequestContext mZZ;
    private final BidirectionalStream.Callback naa;
    private final String nab;
    private final String nac;
    private final Object nad;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> nae;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> naf;
    @GuardedBy("mNativeStreamLock")
    private boolean nag;
    @GuardedBy("mNativeStreamLock")
    private boolean nah;
    @GuardedBy("mNativeStreamLock")
    private long nai;
    @GuardedBy("mNativeStreamLock")
    private State naj;
    @GuardedBy("mNativeStreamLock")
    private State nak;
    private UrlResponseInfo nal;
    private a nam;
    private Runnable nan;

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
        final /* synthetic */ CronetBidirectionalStream nap;
        boolean nas;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.nap.nad) {
                    if (!this.nap.dKa()) {
                        if (this.nas) {
                            this.nap.naj = State.READING_DONE;
                            if (this.nap.nak == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.nap.naj = State.WAITING_FOR_READ;
                        }
                        this.nap.naa.a(this.nap, this.nap.nal, byteBuffer, this.nas);
                        if (z) {
                            this.nap.dKb();
                        }
                    }
                }
            } catch (Exception e) {
                this.nap.y(e);
            }
        }
    }

    /* loaded from: classes10.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean nas;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.nas = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.nad) {
                    if (!CronetBidirectionalStream.this.dKa()) {
                        if (this.nas) {
                            CronetBidirectionalStream.this.nak = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.naj == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.naa.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nal, byteBuffer, this.nas);
                        if (z) {
                            CronetBidirectionalStream.this.dKb();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.y(e);
            }
        }
    }

    private void dJZ() {
        boolean z = true;
        if (!$assertionsDisabled && this.nak != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.naf.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.naf.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.naf.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.nak = State.WRITING;
        if (!nativeWritevData(this.nai, byteBufferArr, iArr, iArr2, (this.nag && this.nae.isEmpty()) ? false : false)) {
            this.nak = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean dKa() {
        return this.naj != State.NOT_STARTED && this.nai == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dKb() {
        synchronized (this.nad) {
            if (!dKa()) {
                if (this.nak == State.WRITING_DONE && this.naj == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.nak = state;
                    this.naj = state;
                    xx(false);
                    try {
                        this.naa.b(this, this.nal);
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
                synchronized (CronetBidirectionalStream.this.nad) {
                    if (!CronetBidirectionalStream.this.dKa()) {
                        CronetBidirectionalStream.this.nah = z;
                        CronetBidirectionalStream.this.naj = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.Tf(CronetBidirectionalStream.this.nac) && CronetBidirectionalStream.this.nah) {
                            CronetBidirectionalStream.this.nak = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.nak = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.naa.a(CronetBidirectionalStream.this);
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
            this.nal = a(i, str, strArr, j);
            y(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.nad) {
                        if (!CronetBidirectionalStream.this.dKa()) {
                            CronetBidirectionalStream.this.naj = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.naa.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nal);
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
        this.nal.gd(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.nam.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.nam.mByteBuffer = byteBuffer;
            this.nam.nas = i == 0;
            y(this.nam);
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
        synchronized (this.nad) {
            this.nak = State.WAITING_FOR_FLUSH;
            if (!this.naf.isEmpty()) {
                dJZ();
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
                synchronized (CronetBidirectionalStream.this.nad) {
                    if (!CronetBidirectionalStream.this.dKa()) {
                        try {
                            CronetBidirectionalStream.this.naa.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nal, headerBlock);
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
        if (this.nal != null) {
            this.nal.gd(j);
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
                    CronetBidirectionalStream.this.naa.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.nal);
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
            synchronized (this.nad) {
                State state = State.ERROR;
                this.nak = state;
                this.naj = state;
                xx(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.nab), i, "", T(strArr), false, str, null);
        urlResponseInfo.gd(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void xx(boolean z) {
        com.baidu.turbonet.base.a.f("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.nai != 0) {
            nativeDestroy(this.nai, z);
            this.nai = 0L;
            this.mZZ.dKq();
            if (this.nan != null) {
                this.nan.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.nad) {
            if (!dKa()) {
                State state = State.ERROR;
                this.nak = state;
                this.naj = state;
                xx(false);
                try {
                    this.naa.a(this, this.nal, turbonetException);
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
