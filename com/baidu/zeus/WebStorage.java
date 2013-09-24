package com.baidu.zeus;

import android.os.Handler;
import android.os.Message;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class WebStorage {
    private static final String CALLBACK = "callback";
    static final int DELETE_ALL = 3;
    static final int DELETE_ORIGIN = 2;
    static final int GET_ORIGINS = 4;
    static final int GET_QUOTA_ORIGIN = 6;
    static final int GET_USAGE_ORIGIN = 5;
    private static final String ORIGIN = "origin";
    private static final String ORIGINS = "origins";
    private static final String QUOTA = "quota";
    static final int RETURN_ORIGINS = 0;
    static final int RETURN_QUOTA_ORIGIN = 2;
    static final int RETURN_USAGE_ORIGIN = 1;
    static final int SET_QUOTA_ORIGIN = 1;
    private static final String TAG = "webstorage";
    static final int UPDATE = 0;
    private static final String USAGE = "usage";
    private static WebStorage sWebStorage;
    private Map<String, Origin> mOrigins;
    private Handler mHandler = null;
    private Handler mUIHandler = null;

    /* loaded from: classes.dex */
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDeleteAllData();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDeleteOrigin(String str);

    private static native Set nativeGetOrigins();

    private static native long nativeGetQuotaForOrigin(String str);

    private static native long nativeGetUsageForOrigin(String str);

    private static native void nativeSetAppCacheMaximumSize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeSetQuotaForOrigin(String str, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Origin {
        String mOrigin;
        long mQuota;
        long mUsage;

        public Origin(String str, long j, long j2) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = str;
            this.mQuota = j;
            this.mUsage = j2;
        }

        public Origin(String str, long j) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = str;
            this.mQuota = j;
        }

        public Origin(String str) {
            this.mOrigin = null;
            this.mQuota = 0L;
            this.mUsage = 0L;
            this.mOrigin = str;
        }

        public String getOrigin() {
            return this.mOrigin;
        }

        public long getQuota() {
            return this.mQuota;
        }

        public long getUsage() {
            return this.mUsage;
        }
    }

    public void createUIHandler() {
        if (this.mUIHandler == null) {
            this.mUIHandler = new Handler() { // from class: com.baidu.zeus.WebStorage.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            Map map = (Map) message.obj;
                            ((ValueCallback) map.get(WebStorage.CALLBACK)).onReceiveValue((Map) map.get(WebStorage.ORIGINS));
                            return;
                        case 1:
                            Map map2 = (Map) message.obj;
                            ((ValueCallback) map2.get(WebStorage.CALLBACK)).onReceiveValue((Long) map2.get(WebStorage.USAGE));
                            return;
                        case 2:
                            Map map3 = (Map) message.obj;
                            ((ValueCallback) map3.get(WebStorage.CALLBACK)).onReceiveValue((Long) map3.get(WebStorage.QUOTA));
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
            this.mHandler = new Handler() { // from class: com.baidu.zeus.WebStorage.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            WebStorage.this.syncValues();
                            return;
                        case 1:
                            Origin origin = (Origin) message.obj;
                            WebStorage.nativeSetQuotaForOrigin(origin.getOrigin(), origin.getQuota());
                            return;
                        case 2:
                            WebStorage.nativeDeleteOrigin(((Origin) message.obj).getOrigin());
                            return;
                        case 3:
                            WebStorage.nativeDeleteAllData();
                            return;
                        case 4:
                            WebStorage.this.syncValues();
                            HashMap hashMap = new HashMap(WebStorage.this.mOrigins);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put(WebStorage.CALLBACK, (ValueCallback) message.obj);
                            hashMap2.put(WebStorage.ORIGINS, hashMap);
                            WebStorage.this.postUIMessage(Message.obtain(null, 0, hashMap2));
                            return;
                        case 5:
                            WebStorage.this.syncValues();
                            Map map = (Map) message.obj;
                            Origin origin2 = (Origin) WebStorage.this.mOrigins.get((String) map.get(WebStorage.ORIGIN));
                            HashMap hashMap3 = new HashMap();
                            hashMap3.put(WebStorage.CALLBACK, (ValueCallback) map.get(WebStorage.CALLBACK));
                            if (origin2 != null) {
                                hashMap3.put(WebStorage.USAGE, new Long(origin2.getUsage()));
                            }
                            WebStorage.this.postUIMessage(Message.obtain(null, 1, hashMap3));
                            return;
                        case 6:
                            WebStorage.this.syncValues();
                            Map map2 = (Map) message.obj;
                            Origin origin3 = (Origin) WebStorage.this.mOrigins.get((String) map2.get(WebStorage.ORIGIN));
                            HashMap hashMap4 = new HashMap();
                            hashMap4.put(WebStorage.CALLBACK, (ValueCallback) map2.get(WebStorage.CALLBACK));
                            if (origin3 != null) {
                                hashMap4.put(WebStorage.QUOTA, new Long(origin3.getQuota()));
                            }
                            WebStorage.this.postUIMessage(Message.obtain(null, 2, hashMap4));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        if (valueCallback != null) {
            if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valueCallback.onReceiveValue(this.mOrigins);
                return;
            }
            postMessage(Message.obtain(null, 4, valueCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Origin> getOriginsSync() {
        if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
            update();
            return this.mOrigins.values();
        }
        return null;
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        if (valueCallback != null) {
            if (str == null) {
                valueCallback.onReceiveValue(null);
            } else if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valueCallback.onReceiveValue(new Long(this.mOrigins.get(str).getUsage()));
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(ORIGIN, str);
                hashMap.put(CALLBACK, valueCallback);
                postMessage(Message.obtain(null, 5, hashMap));
            }
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        if (valueCallback != null) {
            if (str == null) {
                valueCallback.onReceiveValue(null);
            } else if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                syncValues();
                valueCallback.onReceiveValue(new Long(this.mOrigins.get(str).getUsage()));
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(ORIGIN, str);
                hashMap.put(CALLBACK, valueCallback);
                postMessage(Message.obtain(null, 6, hashMap));
            }
        }
    }

    public void setQuotaForOrigin(String str, long j) {
        if (str != null) {
            if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                nativeSetQuotaForOrigin(str, j);
            } else {
                postMessage(Message.obtain(null, 1, new Origin(str, j)));
            }
        }
    }

    public void deleteOrigin(String str) {
        if (str != null) {
            if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
                nativeDeleteOrigin(str);
            } else {
                postMessage(Message.obtain(null, 2, new Origin(str)));
            }
        }
    }

    public void deleteAllData() {
        if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
            nativeDeleteAllData();
        } else {
            postMessage(Message.obtain((Handler) null, 3));
        }
    }

    public void setAppCacheMaximumSize(long j) {
        nativeSetAppCacheMaximumSize(j);
    }

    private synchronized void postMessage(Message message) {
        if (this.mHandler != null) {
            this.mHandler.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postUIMessage(Message message) {
        if (this.mUIHandler != null) {
            this.mUIHandler.sendMessage(message);
        }
    }

    public static WebStorage getInstance() {
        if (sWebStorage == null) {
            sWebStorage = new WebStorage();
        }
        return sWebStorage;
    }

    public void update() {
        if ("WebViewCoreThread".equals(Thread.currentThread().getName())) {
            syncValues();
        } else {
            postMessage(Message.obtain((Handler) null, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncValues() {
        Set<String> nativeGetOrigins = nativeGetOrigins();
        this.mOrigins = new HashMap();
        for (String str : nativeGetOrigins) {
            this.mOrigins.put(str, new Origin(str, nativeGetQuotaForOrigin(str), nativeGetUsageForOrigin(str)));
        }
    }
}
