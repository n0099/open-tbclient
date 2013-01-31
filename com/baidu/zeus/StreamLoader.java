package com.baidu.zeus;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class StreamLoader implements Handler.Callback {
    private static final int MSG_DATA = 102;
    private static final int MSG_END = 103;
    private static final int MSG_HEADERS = 101;
    private static final int MSG_STATUS = 100;
    protected long mContentLength;
    protected final Context mContext;
    private byte[] mData;
    protected InputStream mDataStream;
    private Handler mHandler;
    protected final LoadListener mLoadListener;

    protected abstract void buildHeaders(Headers headers);

    protected abstract boolean setupStreamAndSendStatus();

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreamLoader(LoadListener loadListener) {
        this.mLoadListener = loadListener;
        this.mContext = loadListener.getContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void load() {
        synchronized (this) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(this);
            }
        }
        if (!this.mLoadListener.isSynchronous()) {
            this.mHandler.sendEmptyMessage(100);
        } else if (setupStreamAndSendStatus()) {
            this.mData = new byte[8192];
            sendHeaders();
            while (!sendData() && !this.mLoadListener.cancelled()) {
            }
            closeStreamAndSendEndData();
            this.mLoadListener.loadSynchronousMessages();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.mLoadListener.isSynchronous()) {
            throw new AssertionError();
        }
        if (this.mLoadListener.cancelled()) {
            closeStreamAndSendEndData();
            return true;
        }
        switch (message.what) {
            case 100:
                if (setupStreamAndSendStatus()) {
                    this.mData = new byte[8192];
                    this.mHandler.sendEmptyMessage(101);
                    return true;
                }
                return true;
            case 101:
                sendHeaders();
                this.mHandler.sendEmptyMessage(102);
                return true;
            case 102:
                if (sendData()) {
                    this.mHandler.sendEmptyMessage(103);
                    return true;
                }
                this.mHandler.sendEmptyMessage(102);
                return true;
            case 103:
                closeStreamAndSendEndData();
                return true;
            default:
                return false;
        }
    }

    private void sendHeaders() {
        Headers headers = new Headers();
        if (this.mContentLength > 0) {
            headers.setContentLength(this.mContentLength);
        }
        buildHeaders(headers);
        this.mLoadListener.headers(headers);
    }

    private boolean sendData() {
        if (this.mDataStream != null) {
            try {
                int read = this.mDataStream.read(this.mData);
                if (read > 0) {
                    this.mLoadListener.data(this.mData, read);
                    return false;
                }
            } catch (IOException e) {
                this.mLoadListener.error(-13, e.getMessage());
            }
        }
        return true;
    }

    private void closeStreamAndSendEndData() {
        if (this.mDataStream != null) {
            try {
                this.mDataStream.close();
            } catch (IOException e) {
            }
        }
        this.mLoadListener.endData();
    }
}
