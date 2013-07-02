package com.baidu.zeus;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class HttpAuthHandler extends Handler {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int AUTH_CANCEL = 200;
    private static final int AUTH_PROCEED = 100;
    private static final String LOGTAG = "network";
    private Network mNetwork;
    String mPassword;
    boolean mRequestInFlight;
    String mUsername;
    Object mRequestInFlightLock = new Object();
    private LinkedList mLoaderQueue = new LinkedList();

    static {
        $assertionsDisabled = !HttpAuthHandler.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpAuthHandler(Network network) {
        this.mNetwork = network;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        LoadListener loadListener;
        synchronized (this.mLoaderQueue) {
            loadListener = (LoadListener) this.mLoaderQueue.poll();
        }
        if (!$assertionsDisabled && loadListener.isSynchronous()) {
            throw new AssertionError();
        }
        switch (message.what) {
            case 100:
                loadListener.handleAuthResponse(message.getData().getString("username"), message.getData().getString("password"));
                break;
            case 200:
                loadListener.handleAuthResponse(null, null);
                break;
        }
        processNextLoader();
    }

    private boolean handleResponseForSynchronousRequest(String str, String str2) {
        LoadListener loadListener;
        synchronized (this.mLoaderQueue) {
            loadListener = (LoadListener) this.mLoaderQueue.peek();
        }
        if (loadListener.isSynchronous()) {
            this.mUsername = str;
            this.mPassword = str2;
            return true;
        }
        return false;
    }

    private void signalRequestComplete() {
        synchronized (this.mRequestInFlightLock) {
            if (!$assertionsDisabled && !this.mRequestInFlight) {
                throw new AssertionError();
            }
            this.mRequestInFlight = false;
            this.mRequestInFlightLock.notify();
        }
    }

    public void proceed(String str, String str2) {
        if (handleResponseForSynchronousRequest(str, str2)) {
            signalRequestComplete();
            return;
        }
        Message obtainMessage = obtainMessage(100);
        obtainMessage.getData().putString("username", str);
        obtainMessage.getData().putString("password", str2);
        sendMessage(obtainMessage);
        signalRequestComplete();
    }

    public void cancel() {
        if (handleResponseForSynchronousRequest(null, null)) {
            signalRequestComplete();
            return;
        }
        sendMessage(obtainMessage(200));
        signalRequestComplete();
    }

    public boolean useHttpAuthUsernamePassword() {
        LoadListener loadListener;
        synchronized (this.mLoaderQueue) {
            loadListener = (LoadListener) this.mLoaderQueue.peek();
        }
        return (loadListener == null || loadListener.authCredentialsInvalid()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleAuthRequest(LoadListener loadListener) {
        boolean z;
        if (loadListener.isSynchronous()) {
            waitForRequestToComplete();
            synchronized (this.mLoaderQueue) {
                this.mLoaderQueue.addFirst(loadListener);
            }
            processNextLoader();
            waitForRequestToComplete();
            synchronized (this.mLoaderQueue) {
                if (!$assertionsDisabled && this.mLoaderQueue.peek() != loadListener) {
                    throw new AssertionError();
                }
                this.mLoaderQueue.poll();
            }
            loadListener.handleAuthResponse(this.mUsername, this.mPassword);
            return;
        }
        synchronized (this.mLoaderQueue) {
            this.mLoaderQueue.offer(loadListener);
            z = this.mLoaderQueue.size() == 1;
        }
        if (z) {
            processNextLoader();
        }
    }

    private void waitForRequestToComplete() {
        synchronized (this.mRequestInFlightLock) {
            while (this.mRequestInFlight) {
                try {
                    this.mRequestInFlightLock.wait();
                } catch (InterruptedException e) {
                    Log.e(LOGTAG, "Interrupted while waiting for request to complete");
                }
            }
        }
    }

    private void processNextLoader() {
        LoadListener loadListener;
        synchronized (this.mLoaderQueue) {
            loadListener = (LoadListener) this.mLoaderQueue.peek();
        }
        if (loadListener != null) {
            synchronized (this.mRequestInFlightLock) {
                if (!$assertionsDisabled && this.mRequestInFlight) {
                    throw new AssertionError();
                }
                this.mRequestInFlight = true;
            }
            loadListener.getFrame().getCallbackProxy().onReceivedHttpAuthRequest(this, loadListener.proxyAuthenticate() ? this.mNetwork.getProxyHostname() : loadListener.host(), loadListener.realm());
        }
    }

    public static void onReceivedCredentials(LoadListener loadListener, String str, String str2, String str3, String str4) {
        loadListener.getFrame().getCallbackProxy().onReceivedHttpAuthCredentials(str, str2, str3, str4);
    }

    public boolean suppressDialog() {
        return false;
    }
}
