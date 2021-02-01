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
/* loaded from: classes6.dex */
class CronetBidirectionalStream extends BidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled;
    @GuardedBy("mNativeStreamLock")
    private boolean mEndOfStreamWritten;
    private final Executor mExecutor;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final String mInitialUrl;
    @GuardedBy("mNativeStreamLock")
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private Runnable mOnDestroyedCallbackForTesting;
    @GuardedBy("mNativeStreamLock")
    private LinkedList<ByteBuffer> mPendingData;
    @GuardedBy("mNativeStreamLock")
    private boolean mRequestHeadersSent;
    private final CronetUrlRequestContext oPd;
    private final BidirectionalStream.Callback oPe;
    @GuardedBy("mNativeStreamLock")
    private State oPf;
    @GuardedBy("mNativeStreamLock")
    private State oPg;
    private UrlResponseInfo oPh;
    private a oPi;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    private final class a implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream oPj;

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (this.oPj.mNativeStreamLock) {
                    if (!this.oPj.isDoneLocked()) {
                        if (this.mEndOfStream) {
                            this.oPj.oPf = State.READING_DONE;
                            if (this.oPj.oPg == State.WRITING_DONE) {
                                z = true;
                            }
                        } else {
                            this.oPj.oPf = State.WAITING_FOR_READ;
                        }
                        this.oPj.oPe.a(this.oPj, this.oPj.oPh, byteBuffer, this.mEndOfStream);
                        if (z) {
                            this.oPj.efZ();
                        }
                    }
                }
            } catch (Exception e) {
                this.oPj.onCallbackException(e);
            }
        }
    }

    /* loaded from: classes6.dex */
    private final class b implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;

        b(ByteBuffer byteBuffer, boolean z) {
            this.mByteBuffer = byteBuffer;
            this.mEndOfStream = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                ByteBuffer byteBuffer = this.mByteBuffer;
                this.mByteBuffer = null;
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        if (this.mEndOfStream) {
                            CronetBidirectionalStream.this.oPg = State.WRITING_DONE;
                            if (CronetBidirectionalStream.this.oPf == State.READING_DONE) {
                                z = true;
                            }
                        }
                        CronetBidirectionalStream.this.oPe.b(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oPh, byteBuffer, this.mEndOfStream);
                        if (z) {
                            CronetBidirectionalStream.this.efZ();
                        }
                    }
                }
            } catch (Exception e) {
                CronetBidirectionalStream.this.onCallbackException(e);
            }
        }
    }

    private void sendFlushDataLocked() {
        boolean z = true;
        if (!$assertionsDisabled && this.oPg != State.WAITING_FOR_FLUSH) {
            throw new AssertionError();
        }
        int size = this.mFlushData.size();
        ByteBuffer[] byteBufferArr = new ByteBuffer[size];
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        for (int i = 0; i < size; i++) {
            ByteBuffer poll = this.mFlushData.poll();
            byteBufferArr[i] = poll;
            iArr[i] = poll.position();
            iArr2[i] = poll.limit();
        }
        if (!$assertionsDisabled && !this.mFlushData.isEmpty()) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && byteBufferArr.length < 1) {
            throw new AssertionError();
        }
        this.oPg = State.WRITING;
        if (!nativeWritevData(this.mNativeStream, byteBufferArr, iArr, iArr2, (this.mEndOfStreamWritten && this.mPendingData.isEmpty()) ? false : false)) {
            this.oPg = State.WAITING_FOR_FLUSH;
            throw new IllegalArgumentException("Unable to call native writev.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mNativeStreamLock")
    public boolean isDoneLocked() {
        return this.oPf != State.NOT_STARTED && this.mNativeStream == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efZ() {
        synchronized (this.mNativeStreamLock) {
            if (!isDoneLocked()) {
                if (this.oPg == State.WRITING_DONE && this.oPf == State.READING_DONE) {
                    State state = State.SUCCESS;
                    this.oPg = state;
                    this.oPf = state;
                    destroyNativeStreamLocked(false);
                    try {
                        this.oPe.b(this, this.oPh);
                    } catch (Exception e) {
                        com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in onSucceeded method", e);
                    }
                }
            }
        }
    }

    @CalledByNative
    private void onStreamReady(final boolean z) {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        CronetBidirectionalStream.this.mRequestHeadersSent = z;
                        CronetBidirectionalStream.this.oPf = State.WAITING_FOR_READ;
                        if (!CronetBidirectionalStream.WL(CronetBidirectionalStream.this.mInitialMethod) && CronetBidirectionalStream.this.mRequestHeadersSent) {
                            CronetBidirectionalStream.this.oPg = State.WRITING_DONE;
                        } else {
                            CronetBidirectionalStream.this.oPg = State.WAITING_FOR_FLUSH;
                        }
                        try {
                            CronetBidirectionalStream.this.oPe.a(CronetBidirectionalStream.this);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onResponseHeadersReceived(int i, String str, String[] strArr, long j) {
        try {
            this.oPh = a(i, str, strArr, j);
            postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                        if (!CronetBidirectionalStream.this.isDoneLocked()) {
                            CronetBidirectionalStream.this.oPf = State.WAITING_FOR_READ;
                            try {
                                CronetBidirectionalStream.this.oPe.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oPh);
                            } catch (Exception e) {
                                CronetBidirectionalStream.this.onCallbackException(e);
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
        this.oPh.hT(j);
        if (byteBuffer.position() != i2 || byteBuffer.limit() != i3) {
            b(new TurbonetException("ByteBuffer modified externally during read", null));
        } else if (i < 0 || i2 + i > i3) {
            b(new TurbonetException("Invalid number of bytes read", null));
        } else {
            byteBuffer.position(i2 + i);
            if (!$assertionsDisabled && this.oPi.mByteBuffer != null) {
                throw new AssertionError();
            }
            this.oPi.mByteBuffer = byteBuffer;
            this.oPi.mEndOfStream = i == 0;
            postTaskToExecutor(this.oPi);
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
        synchronized (this.mNativeStreamLock) {
            this.oPg = State.WAITING_FOR_FLUSH;
            if (!this.mFlushData.isEmpty()) {
                sendFlushDataLocked();
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
            postTaskToExecutor(new b(byteBuffer, z && i == byteBufferArr.length + (-1)));
            i++;
        }
    }

    @CalledByNative
    private void onResponseTrailersReceived(String[] strArr) {
        final UrlResponseInfo.HeaderBlock headerBlock = new UrlResponseInfo.HeaderBlock(headersListFromStrings(strArr));
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (CronetBidirectionalStream.this.mNativeStreamLock) {
                    if (!CronetBidirectionalStream.this.isDoneLocked()) {
                        try {
                            CronetBidirectionalStream.this.oPe.a(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oPh, headerBlock);
                        } catch (Exception e) {
                            CronetBidirectionalStream.this.onCallbackException(e);
                        }
                    }
                }
            }
        });
    }

    @CalledByNative
    private void onError(int i, int i2, int i3, String str, long j) {
        if (this.oPh != null) {
            this.oPh.hT(j);
        }
        if (i == 11) {
            b(new QuicException("Exception in BidirectionalStream: " + str, i2, i3));
        } else {
            b(new TurbonetException("Exception in BidirectionalStream: " + str, i, i2));
        }
    }

    @CalledByNative
    private void onCanceled() {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CronetBidirectionalStream.this.oPe.c(CronetBidirectionalStream.this, CronetBidirectionalStream.this.oPh);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in onCanceled method", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean WL(String str) {
        return (str.equals("GET") || str.equals(HttpHead.METHOD_NAME)) ? false : true;
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] strArr) {
        ArrayList<Map.Entry<String, String>> arrayList = new ArrayList<>(strArr.length / 2);
        for (int i = 0; i < strArr.length; i += 2) {
            arrayList.add(new AbstractMap.SimpleImmutableEntry(strArr[i], strArr[i + 1]));
        }
        return arrayList;
    }

    private void postTaskToExecutor(Runnable runnable) {
        try {
            this.mExecutor.execute(runnable);
        } catch (RejectedExecutionException e) {
            com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception posting task to executor", e);
            synchronized (this.mNativeStreamLock) {
                State state = State.ERROR;
                this.oPg = state;
                this.oPf = state;
                destroyNativeStreamLocked(false);
            }
        }
    }

    private UrlResponseInfo a(int i, String str, String[] strArr, long j) {
        UrlResponseInfo urlResponseInfo = new UrlResponseInfo(Arrays.asList(this.mInitialUrl), i, "", headersListFromStrings(strArr), false, str, null);
        urlResponseInfo.hT(j);
        return urlResponseInfo;
    }

    @GuardedBy("mNativeStreamLock")
    private void destroyNativeStreamLocked(boolean z) {
        com.baidu.turbonet.base.a.i("ChromiumNetwork", "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mNativeStream != 0) {
            nativeDestroy(this.mNativeStream, z);
            this.mNativeStream = 0L;
            this.oPd.onRequestDestroyed();
            if (this.mOnDestroyedCallbackForTesting != null) {
                this.mOnDestroyedCallbackForTesting.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TurbonetException turbonetException) {
        synchronized (this.mNativeStreamLock) {
            if (!isDoneLocked()) {
                State state = State.ERROR;
                this.oPg = state;
                this.oPf = state;
                destroyNativeStreamLocked(false);
                try {
                    this.oPe.a(this, this.oPh, turbonetException);
                } catch (Exception e) {
                    com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception notifying of failed request", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallbackException(Exception exc) {
        TurbonetException turbonetException = new TurbonetException("CalledByNative method has thrown an exception", exc);
        com.baidu.turbonet.base.a.e("ChromiumNetwork", "Exception in CalledByNative method", exc);
        a(turbonetException);
    }

    private void b(final TurbonetException turbonetException) {
        postTaskToExecutor(new Runnable() { // from class: com.baidu.turbonet.net.CronetBidirectionalStream.5
            @Override // java.lang.Runnable
            public void run() {
                CronetBidirectionalStream.this.a(turbonetException);
            }
        });
    }
}
