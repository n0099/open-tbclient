package com.baidu.zeus;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WebBackForwardList implements Serializable, Cloneable {
    private final CallbackProxy mCallbackProxy;
    private boolean mClearPending;
    private int mCurrentIndex = -1;
    private ArrayList<WebHistoryItem> mArray = new ArrayList<>();

    private static native void nativeClose(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native synchronized void restoreIndex(int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebBackForwardList(CallbackProxy callbackProxy) {
        this.mCallbackProxy = callbackProxy;
    }

    public synchronized WebHistoryItem getCurrentItem() {
        return getItemAtIndex(this.mCurrentIndex);
    }

    public synchronized int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public synchronized WebHistoryItem getItemAtIndex(int i) {
        WebHistoryItem webHistoryItem;
        if (i >= 0) {
            if (i < getSize()) {
                webHistoryItem = this.mArray.get(i);
            }
        }
        webHistoryItem = null;
        return webHistoryItem;
    }

    public synchronized int getSize() {
        return this.mArray.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setClearPending() {
        this.mClearPending = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean getClearPending() {
        return this.mClearPending;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void addHistoryItem(WebHistoryItem webHistoryItem) {
        this.mCurrentIndex++;
        int size = this.mArray.size();
        int i = this.mCurrentIndex;
        if (i != size) {
            for (int i2 = size - 1; i2 >= i; i2--) {
                this.mArray.remove(i2);
            }
        }
        this.mArray.add(webHistoryItem);
        if (this.mCallbackProxy != null) {
            this.mCallbackProxy.onNewHistoryItem(webHistoryItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void close(int i) {
        this.mArray.clear();
        this.mCurrentIndex = -1;
        nativeClose(i);
        this.mClearPending = false;
    }

    private synchronized void removeHistoryItem(int i) {
        this.mArray.remove(i);
        this.mCurrentIndex--;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized WebBackForwardList m250clone() {
        WebBackForwardList webBackForwardList;
        WebBackForwardList webBackForwardList2 = new WebBackForwardList(null);
        if (this.mClearPending) {
            webBackForwardList2.addHistoryItem(getCurrentItem());
            webBackForwardList = webBackForwardList2;
        } else {
            webBackForwardList2.mCurrentIndex = this.mCurrentIndex;
            int size = getSize();
            webBackForwardList2.mArray = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                webBackForwardList2.mArray.add(this.mArray.get(i).m251clone());
            }
            webBackForwardList = webBackForwardList2;
        }
        return webBackForwardList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setCurrentIndex(int i) {
        this.mCurrentIndex = i;
        if (this.mCallbackProxy != null) {
            this.mCallbackProxy.onIndexChanged(getItemAtIndex(i), i);
        }
    }
}
