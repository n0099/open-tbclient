package com.baidu.zeus;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class SslErrorHandler extends Handler {
    private static final int HANDLE_RESPONSE = 100;
    private static final String LOGTAG = "network";
    private final LoadListener mLoadListener;
    private LinkedList mLoaderQueue;
    private final SslErrorHandler mOriginHandler;
    private Bundle mSslPrefTable;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                LoadListener loadListener = (LoadListener) message.obj;
                synchronized (this) {
                    handleSslErrorResponse(loadListener, loadListener.sslError(), message.arg1 == 1);
                    this.mLoaderQueue.remove(loadListener);
                    fastProcessQueuedSslErrors();
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SslErrorHandler() {
        this.mLoaderQueue = new LinkedList();
        this.mSslPrefTable = new Bundle();
        this.mOriginHandler = null;
        this.mLoadListener = null;
    }

    private SslErrorHandler(SslErrorHandler sslErrorHandler, LoadListener loadListener) {
        this.mOriginHandler = sslErrorHandler;
        this.mLoadListener = loadListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean saveState(Bundle bundle) {
        boolean z;
        z = bundle != null;
        if (z) {
            bundle.putBundle("ssl-error-handler", this.mSslPrefTable);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean restoreState(Bundle bundle) {
        boolean z;
        z = bundle != null;
        if (z) {
            z = bundle.containsKey("ssl-error-handler");
            if (z) {
                this.mSslPrefTable = bundle.getBundle("ssl-error-handler");
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void clear() {
        this.mSslPrefTable.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void handleSslErrorRequest(LoadListener loadListener) {
        if (!loadListener.cancelled()) {
            this.mLoaderQueue.offer(loadListener);
            if (loadListener == this.mLoaderQueue.peek()) {
                fastProcessQueuedSslErrors();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean checkSslPrefTable(LoadListener loadListener, SslError sslError) {
        boolean z = true;
        synchronized (this) {
            String host = loadListener.host();
            int primaryError = sslError.getPrimaryError();
            if (!this.mSslPrefTable.containsKey(host) || primaryError > this.mSslPrefTable.getInt(host)) {
                z = false;
            } else {
                handleSslErrorResponse(loadListener, sslError, true);
            }
        }
        return z;
    }

    void fastProcessQueuedSslErrors() {
        do {
        } while (processNextLoader());
    }

    private synchronized boolean processNextLoader() {
        boolean z;
        LoadListener loadListener = (LoadListener) this.mLoaderQueue.peek();
        if (loadListener != null) {
            if (loadListener.cancelled()) {
                this.mLoaderQueue.remove(loadListener);
                z = true;
            } else {
                SslError sslError = loadListener.sslError();
                if (checkSslPrefTable(loadListener, sslError)) {
                    this.mLoaderQueue.remove(loadListener);
                    z = true;
                } else {
                    loadListener.getFrame().getCallbackProxy().onReceivedSslError(new SslErrorHandler(this, loadListener), sslError);
                }
            }
        }
        z = false;
        return z;
    }

    public void proceed() {
        this.mOriginHandler.sendMessage(this.mOriginHandler.obtainMessage(100, 1, 0, this.mLoadListener));
    }

    public void cancel() {
        this.mOriginHandler.sendMessage(this.mOriginHandler.obtainMessage(100, 0, 0, this.mLoadListener));
    }

    synchronized void handleSslErrorResponse(LoadListener loadListener, SslError sslError, boolean z) {
        if (!loadListener.cancelled()) {
            if (z) {
                int primaryError = sslError.getPrimaryError();
                String host = loadListener.host();
                if (!this.mSslPrefTable.containsKey(host) || primaryError > this.mSslPrefTable.getInt(host)) {
                    this.mSslPrefTable.putInt(host, primaryError);
                }
            }
            loadListener.handleSslErrorResponse(z);
        }
    }
}
