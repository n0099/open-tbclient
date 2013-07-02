package com.baidu.zeus;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class WebSyncManager implements Runnable {
    protected static final String LOGTAG = "websync";
    private static final int SYNC_MESSAGE = 101;
    protected WebViewDatabase mDataBase;
    protected Handler mHandler;
    private int mStartSyncRefCount;
    private Thread mSyncThread;
    private String mThreadName;
    private static int SYNC_NOW_INTERVAL = 100;
    private static int SYNC_LATER_INTERVAL = 300000;

    abstract void syncFromRamToFlash();

    /* loaded from: classes.dex */
    class SyncHandler extends Handler {
        private SyncHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 101) {
                WebSyncManager.this.syncFromRamToFlash();
                sendMessageDelayed(obtainMessage(101), WebSyncManager.SYNC_LATER_INTERVAL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WebSyncManager(Context context, String str) {
        this.mThreadName = str;
        if (context != null) {
            this.mDataBase = WebViewDatabase.getInstance(context);
            this.mSyncThread = new Thread(this);
            this.mSyncThread.setName(this.mThreadName);
            this.mSyncThread.start();
            return;
        }
        throw new IllegalStateException("WebSyncManager can't be created without context");
    }

    protected Object clone() {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    @Override // java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.mHandler = new SyncHandler();
        onSyncInit();
        Process.setThreadPriority(10);
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), SYNC_LATER_INTERVAL);
        Looper.loop();
    }

    public void sync() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(101);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), SYNC_NOW_INTERVAL);
        }
    }

    public void resetSync() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(101);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), SYNC_LATER_INTERVAL);
        }
    }

    public void startSync() {
        if (this.mHandler != null) {
            int i = this.mStartSyncRefCount + 1;
            this.mStartSyncRefCount = i;
            if (i == 1) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101), SYNC_LATER_INTERVAL);
            }
        }
    }

    public void stopSync() {
        if (this.mHandler != null) {
            int i = this.mStartSyncRefCount - 1;
            this.mStartSyncRefCount = i;
            if (i == 0) {
                this.mHandler.removeMessages(101);
            }
        }
    }

    protected void onSyncInit() {
    }
}
