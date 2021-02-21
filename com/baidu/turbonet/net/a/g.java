package com.baidu.turbonet.net.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class g implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final String mUrl;
    private boolean oSA = false;
    private boolean oSB = false;
    private long mThreadId = -1;
    private final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue();

    static {
        $assertionsDisabled = !g.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str) {
        this.mUrl = str;
    }

    private boolean ehy() {
        if (this.mThreadId != -1) {
            return this.mThreadId == Thread.currentThread().getId();
        }
        this.mThreadId = Thread.currentThread().getId();
        return true;
    }

    private Runnable p(boolean z, long j) throws InterruptedIOException {
        Runnable poll;
        try {
            if (!z) {
                poll = this.mQueue.take();
            } else {
                poll = this.mQueue.poll(j, TimeUnit.NANOSECONDS);
            }
            if (poll == null) {
                com.baidu.turbonet.base.a.e("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.mUrl);
                throw new SocketTimeoutException();
            }
            return poll;
        } catch (InterruptedException e) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e);
            throw interruptedIOException;
        }
    }

    public void ehz() throws IOException {
        Ng(0);
    }

    public void Ng(int i) throws IOException {
        if (!$assertionsDisabled && !ehy()) {
            throw new AssertionError();
        }
        long nanoTime = System.nanoTime();
        long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
        if (this.oSB) {
            throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
        }
        if (this.oSA) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.oSA = true;
        while (this.oSA) {
            if (i == 0) {
                try {
                    p(false, 0L).run();
                } catch (InterruptedIOException | RuntimeException e) {
                    this.oSA = false;
                    this.oSB = true;
                    throw e;
                }
            } else {
                p(true, (convert - System.nanoTime()) + nanoTime).run();
            }
        }
    }

    public void quit() {
        if (!$assertionsDisabled && !ehy()) {
            throw new AssertionError();
        }
        this.oSA = false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.mQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(e);
        }
    }
}
