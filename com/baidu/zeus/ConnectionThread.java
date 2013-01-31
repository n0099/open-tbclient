package com.baidu.zeus;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.baidu.zeus.RequestQueue;
/* loaded from: classes.dex */
class ConnectionThread extends Thread {
    static final int WAIT_TICK = 1000;
    static final int WAIT_TIMEOUT = 5000;
    Connection mConnection;
    private RequestQueue.ConnectionManager mConnectionManager;
    private Context mContext;
    long mCurrentThreadTime;
    private int mId;
    private RequestFeeder mRequestFeeder;
    private volatile boolean mRunning = true;
    long mTotalThreadTime;
    private boolean mWaiting;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionThread(Context context, int i, RequestQueue.ConnectionManager connectionManager, RequestFeeder requestFeeder) {
        this.mContext = context;
        setName("http" + i);
        this.mId = i;
        this.mConnectionManager = connectionManager;
        this.mRequestFeeder = requestFeeder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestStop() {
        synchronized (this.mRequestFeeder) {
            this.mRunning = false;
            this.mRequestFeeder.notify();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(1);
        this.mCurrentThreadTime = 0L;
        this.mTotalThreadTime = 0L;
        while (this.mRunning) {
            if (this.mCurrentThreadTime == -1) {
                this.mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
            }
            Request request = this.mRequestFeeder.getRequest();
            if (request == null) {
                synchronized (this.mRequestFeeder) {
                    this.mWaiting = true;
                    try {
                        this.mRequestFeeder.wait();
                    } catch (InterruptedException e) {
                    }
                    this.mWaiting = false;
                    if (this.mCurrentThreadTime != 0) {
                        this.mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
                    }
                }
            } else {
                this.mConnection = this.mConnectionManager.getConnection(this.mContext, request.mHost);
                this.mConnection.processRequests(request);
                if (this.mConnection.getCanPersist()) {
                    if (!this.mConnectionManager.recycleConnection(this.mConnection)) {
                        this.mConnection.closeConnection();
                    }
                } else {
                    this.mConnection.closeConnection();
                }
                this.mConnection = null;
                if (this.mCurrentThreadTime > 0) {
                    long j = this.mCurrentThreadTime;
                    this.mCurrentThreadTime = SystemClock.currentThreadTimeMillis();
                    this.mTotalThreadTime = (this.mCurrentThreadTime - j) + this.mTotalThreadTime;
                }
            }
        }
    }

    @Override // java.lang.Thread
    public synchronized String toString() {
        return "cid " + this.mId + " " + (this.mWaiting ? "w" : "a") + " " + (this.mConnection == null ? "" : this.mConnection.toString());
    }
}
