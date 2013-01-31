package com.baidu.zeus;

import android.os.Handler;
import android.os.Message;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
/* loaded from: classes.dex */
public final class GeolocationPermissions {
    static final int ALLOW = 3;
    private static final String ALLOWED = "allowed";
    private static final String CALLBACK = "callback";
    static final int CLEAR = 2;
    static final int CLEAR_ALL = 4;
    static final int GET_ALLOWED = 1;
    static final int GET_ORIGINS = 0;
    private static final String ORIGIN = "origin";
    private static final String ORIGINS = "origins";
    static final int RETURN_ALLOWED = 1;
    static final int RETURN_ORIGINS = 0;
    private static final String TAG = "geolocationPermissions";
    private static GeolocationPermissions sInstance;
    private Handler mHandler;
    private Vector mQueuedMessages;
    private Handler mUIHandler;

    /* loaded from: classes.dex */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeAllow(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClear(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClearAll();

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nativeGetAllowed(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Set nativeGetOrigins();

    public static GeolocationPermissions getInstance() {
        if (sInstance == null) {
            sInstance = new GeolocationPermissions();
        }
        return sInstance;
    }

    public void createUIHandler() {
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler() { // from class: com.baidu.zeus.GeolocationPermissions.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            Map map = (Map) message.obj;
                            ((ValueCallback) map.get(GeolocationPermissions.CALLBACK)).onReceiveValue((Set) map.get(GeolocationPermissions.ORIGINS));
                            return;
                        case 1:
                            Map map2 = (Map) message.obj;
                            ((ValueCallback) map2.get(GeolocationPermissions.CALLBACK)).onReceiveValue((Boolean) map2.get(GeolocationPermissions.ALLOWED));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
    }

    public synchronized void createHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler() { // from class: com.baidu.zeus.GeolocationPermissions.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            Set nativeGetOrigins = GeolocationPermissions.nativeGetOrigins();
                            HashMap hashMap = new HashMap();
                            hashMap.put(GeolocationPermissions.CALLBACK, (ValueCallback) message.obj);
                            hashMap.put(GeolocationPermissions.ORIGINS, nativeGetOrigins);
                            GeolocationPermissions.this.postUIMessage(Message.obtain(null, 0, hashMap));
                            return;
                        case 1:
                            Map map = (Map) message.obj;
                            boolean nativeGetAllowed = GeolocationPermissions.nativeGetAllowed((String) map.get(GeolocationPermissions.ORIGIN));
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(GeolocationPermissions.CALLBACK, (ValueCallback) map.get(GeolocationPermissions.CALLBACK));
                            hashMap2.put(GeolocationPermissions.ALLOWED, new Boolean(nativeGetAllowed));
                            GeolocationPermissions.this.postUIMessage(Message.obtain(null, 1, hashMap2));
                            return;
                        case 2:
                            GeolocationPermissions.nativeClear((String) message.obj);
                            return;
                        case 3:
                            GeolocationPermissions.nativeAllow((String) message.obj);
                            return;
                        case 4:
                            GeolocationPermissions.nativeClearAll();
                            return;
                        default:
                            return;
                    }
                }
            };
            if (this.mQueuedMessages != null) {
                while (!this.mQueuedMessages.isEmpty()) {
                    this.mHandler.sendMessage((Message) this.mQueuedMessages.remove(0));
                }
                this.mQueuedMessages = null;
            }
        }
    }

    private synchronized void postMessage(Message message) {
        if (this.mHandler == null) {
            if (this.mQueuedMessages == null) {
                this.mQueuedMessages = new Vector();
            }
            this.mQueuedMessages.add(message);
        } else {
            this.mHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUIMessage(Message message) {
        if (this.mUIHandler != null) {
            this.mUIHandler.sendMessage(message);
        }
    }

    public void getOrigins(ValueCallback valueCallback) {
        if (valueCallback != null) {
            if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                valueCallback.onReceiveValue(nativeGetOrigins());
            } else {
                postMessage(Message.obtain(null, 0, valueCallback));
            }
        }
    }

    public void getAllowed(String str, ValueCallback valueCallback) {
        if (valueCallback != null) {
            if (str == null) {
                valueCallback.onReceiveValue(null);
            } else if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                valueCallback.onReceiveValue(new Boolean(nativeGetAllowed(str)));
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(ORIGIN, str);
                hashMap.put(CALLBACK, valueCallback);
                postMessage(Message.obtain(null, 1, hashMap));
            }
        }
    }

    public void clear(String str) {
        postMessage(Message.obtain(null, 2, str));
    }

    public void allow(String str) {
        postMessage(Message.obtain(null, 3, str));
    }

    public void clearAll() {
        postMessage(Message.obtain((Handler) null, 4));
    }
}
