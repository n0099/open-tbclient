package com.baidu.zeus;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public class NotificationManagerThread {
    private static final int MAX_SHOW_NOTIFICATION_NUM = 50;
    private static final int MSG_CANCEL_NOTIFICATION = 4;
    private static final int MSG_DISPATCH_EVENT = 5;
    private static final int MSG_REGISTER_CLIENT = 1;
    private static final int MSG_SHOW_NOTIFICATION = 3;
    private static final int MSG_UNREGISTER_CLIENT = 2;
    public static final String NOTIFICATION_CLICK_ACTION = "android.intent.action.NOTIFICATIONCLICK";
    public static final String NOTIFICATION_CLOSE_ACTION = "android.intent.action.NOTIFICATIONCLOSE";
    public static final String NOTIFICATION_SERVICE_CLOSE_ACTION = "android.intent.action.NOTIFICATIONSERVICE_CLOSE";
    private static final String TAG = "NotificationManagerThread";
    private static NotificationManagerThread mInstance;
    public Context mActivityContext;
    public Context mContext;
    private ThreadHandler mHandler;
    private String mPackageName;
    private final HashMap mNotificationProxys = new HashMap();
    private final HashMap mReplaceIdMap = new HashMap();
    private final ArrayList mDefaultIdArray = new ArrayList();
    private NotificationResource mNotificationRes = new NotificationResource();
    private BroadcastReceiver mServiceInitReceiver = null;
    private Messenger mService = null;
    private Messenger mMessenger = null;
    private boolean isInit = false;
    private boolean initResSuccess = false;
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.baidu.zeus.NotificationManagerThread.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (NotificationManagerThread.this.mServiceInitReceiver == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(NotificationManagerThread.NOTIFICATION_SERVICE_CLOSE_ACTION);
                NotificationManagerThread.this.mServiceInitReceiver = new BroadcastReceiver() { // from class: com.baidu.zeus.NotificationManagerThread.1.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        NotificationManagerThread.this.clearFromBroadcast();
                        NotificationManagerThread.this.doBindService();
                    }
                };
                NotificationManagerThread.this.mContext.registerReceiver(NotificationManagerThread.this.mServiceInitReceiver, intentFilter);
            }
            NotificationManagerThread.this.mService = new Messenger(iBinder);
            try {
                Message obtain = Message.obtain((Handler) null, 1);
                Bundle bundle = new Bundle();
                bundle.putString("packageName", NotificationManagerThread.this.mPackageName);
                obtain.replyTo = NotificationManagerThread.this.mMessenger;
                obtain.setData(bundle);
                NotificationManagerThread.this.mService.send(obtain);
            } catch (RemoteException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class NotificationResource {
        public int mAppIcon = 0;
        public int mSimpleIcon = 0;
        public int mWebIcon = 0;

        NotificationResource() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ThreadHandler extends Handler {
        ThreadHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 3:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    synchronized (NotificationManagerThread.this.mNotificationProxys) {
                        NotificationProxy notificationProxy = (NotificationProxy) NotificationManagerThread.this.mNotificationProxys.get(Integer.valueOf(i));
                        if (notificationProxy != null) {
                            notificationProxy.showNotification(i2);
                        }
                    }
                    return;
                case 4:
                    int i3 = message.arg1;
                    int i4 = message.arg2;
                    synchronized (NotificationManagerThread.this.mNotificationProxys) {
                        NotificationProxy notificationProxy2 = (NotificationProxy) NotificationManagerThread.this.mNotificationProxys.get(Integer.valueOf(i3));
                        if (notificationProxy2 != null && notificationProxy2.mSystemId == i4) {
                            NotificationManagerThread.this.removeNotificationProxy(notificationProxy2);
                            notificationProxy2.cancelFromUser();
                        }
                    }
                    return;
                case 5:
                    int i5 = message.arg1;
                    int i6 = message.arg2;
                    int i7 = message.getData().getInt("event");
                    synchronized (NotificationManagerThread.this.mNotificationProxys) {
                        NotificationProxy notificationProxy3 = (NotificationProxy) NotificationManagerThread.this.mNotificationProxys.get(Integer.valueOf(i5));
                        if (notificationProxy3 != null && notificationProxy3.mSystemId == i6) {
                            Log.d(NotificationManagerThread.TAG, "handleMessage:MSG_DISPATCH_EVENT------proxy=" + notificationProxy3 + " hashCode=" + i5 + " event = " + i7 + " systemId=" + i6);
                            if (i7 == 4) {
                                NotificationManagerThread.this.removeNotificationProxy(notificationProxy3);
                                notificationProxy3.cancelFromUser();
                            } else if (i7 == 3) {
                                notificationProxy3.dispatchEvent(i7);
                                if (notificationProxy3.mUrl == null) {
                                    NotificationManagerThread.this.removeNotificationProxy(notificationProxy3);
                                    notificationProxy3.cancelFromUser();
                                }
                            }
                        }
                    }
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public NotificationProxy creatNotificationProxy(Context context, WebViewCore webViewCore, String str, String str2, int i) {
        if (!this.initResSuccess) {
            if (i != 0 && webViewCore != null) {
                Log.e(TAG, "Web Notification init Resource Fail\n");
                webViewCore.notificationEventDispatch(i, 1);
            }
            return null;
        }
        int allocateReplaceId = allocateReplaceId(str2);
        if (allocateReplaceId == 0) {
            if (i != 0 && webViewCore != null) {
                Log.e(TAG, "Web Notification is given up, because the list is full\n");
                webViewCore.notificationEventDispatch(i, 1);
            }
            return null;
        }
        NotificationProxy notificationProxy = new NotificationProxy(context, webViewCore, this, str, allocateReplaceId, i);
        if (notificationProxy != null) {
            synchronized (this.mNotificationProxys) {
                int hashCode = notificationProxy.hashCode();
                if (((NotificationProxy) this.mNotificationProxys.get(Integer.valueOf(hashCode))) != null) {
                    notificationProxy.cancelFromJs();
                    notificationProxy.dispatchEvent(1);
                    Log.e(TAG, "some web notification has the same hash code !\n");
                    notificationProxy = null;
                } else {
                    this.mNotificationProxys.put(Integer.valueOf(hashCode), notificationProxy);
                    notificationProxy.mHashCode = hashCode;
                    notificationProxy.initResource(this.mNotificationRes.mAppIcon, this.mNotificationRes.mSimpleIcon, this.mNotificationRes.mWebIcon);
                }
            }
            return notificationProxy;
        }
        return notificationProxy;
    }

    private int allocateReplaceId(String str) {
        int nextInt;
        if (this.mNotificationProxys.size() >= MAX_SHOW_NOTIFICATION_NUM) {
            if (str != null || str.length() != 0) {
                int APHash = APHash(str) + 51;
                while (true) {
                    int i = APHash;
                    if (!this.mReplaceIdMap.containsKey(Integer.valueOf(i))) {
                        break;
                    } else if (((String) this.mReplaceIdMap.get(Integer.valueOf(i))).compareTo(str) != 0) {
                        APHash = i + 1;
                    } else {
                        return i;
                    }
                }
            }
            return 0;
        } else if (str == null || str.length() == 0) {
            do {
                nextInt = new Random().nextInt(MAX_SHOW_NOTIFICATION_NUM) + 1;
            } while (this.mDefaultIdArray.contains(Integer.valueOf(nextInt)));
            this.mDefaultIdArray.add(Integer.valueOf(nextInt));
            return nextInt;
        } else {
            int APHash2 = APHash(str) + 51;
            while (true) {
                int i2 = APHash2;
                if (this.mReplaceIdMap.containsKey(Integer.valueOf(i2))) {
                    if (((String) this.mReplaceIdMap.get(Integer.valueOf(i2))).compareTo(str) != 0) {
                        APHash2 = i2 + 1;
                    } else {
                        return i2;
                    }
                } else {
                    this.mReplaceIdMap.put(Integer.valueOf(i2), str);
                    return i2;
                }
            }
        }
    }

    private int APHash(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            i ^= (i2 & 1) == 0 ? ((i << 7) ^ str.charAt(i2)) ^ (i >> 3) : (((i << 11) ^ str.charAt(i2)) ^ (i >> 5)) ^ (-1);
        }
        return Integer.MAX_VALUE & i;
    }

    private void initNotificationResource() {
        String str = this.mPackageName;
        int identifier = this.mContext.getResources().getIdentifier("notification_bar_icon", "drawable", this.mPackageName);
        int identifier2 = this.mContext.getResources().getIdentifier("simple_notification_icon", "drawable", this.mPackageName);
        int identifier3 = this.mContext.getResources().getIdentifier("web_notification_icon", "drawable", this.mPackageName);
        Log.e(TAG, "initNotificationResource appIcon=" + identifier + " simpleIcon=" + identifier2 + " webIcon=" + identifier3);
        if (identifier != 0 && identifier2 != 0 && identifier3 != 0) {
            this.initResSuccess = true;
            this.mNotificationRes.mAppIcon = identifier;
            this.mNotificationRes.mSimpleIcon = identifier2;
            this.mNotificationRes.mWebIcon = identifier3;
            return;
        }
        this.initResSuccess = false;
        Log.e(TAG, "initNotificationResource error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBindService() {
        Intent intent = new Intent();
        intent.setClassName(this.mPackageName, "com.baidu.htmlNotification.WebNotificationManagerService");
        if (!this.mContext.bindService(intent, this.mConnection, 1)) {
            Log.e(TAG, this.mPackageName + "bind WebNotificationManagerService error");
        }
    }

    private void doUnbindService() {
        if (this.mService != null) {
            try {
                Message obtain = Message.obtain((Handler) null, 2);
                Bundle bundle = new Bundle();
                bundle.putString("packageName", this.mPackageName);
                obtain.setData(bundle);
                this.mService.send(obtain);
            } catch (RemoteException e) {
                Log.e(TAG, this.mPackageName + "unbind WebNotificationManagerService error");
            }
        }
        if (this.mContext != null && this.mConnection != null) {
            this.mContext.unbindService(this.mConnection);
        }
    }

    NotificationManagerThread() {
    }

    public static NotificationManagerThread getInstance() {
        if (mInstance == null) {
            mInstance = new NotificationManagerThread();
        }
        return mInstance;
    }

    public void initInstance(Context context) {
        if (!this.isInit) {
            Log.i(TAG, "initInstance function-----!!!");
            this.mActivityContext = context;
            this.mContext = context.getApplicationContext();
            this.mPackageName = this.mContext.getPackageName();
            this.mHandler = new ThreadHandler();
            this.mMessenger = new Messenger(this.mHandler);
            initNotificationResource();
            doBindService();
            this.isInit = true;
        }
    }

    public void sendShowRequest(NotificationProxy notificationProxy) {
        if (notificationProxy != null && this.mService != null) {
            Log.i(TAG, "enter sendShow replaceId=" + notificationProxy.mReplaceId + " hashCode=" + notificationProxy.mHashCode);
            try {
                Message obtain = Message.obtain((Handler) null, 3);
                Bundle bundle = new Bundle();
                bundle.putString("packageName", notificationProxy.mPkgName);
                bundle.putString("appId", notificationProxy.mAppId);
                bundle.putBoolean("isUrl", notificationProxy.mUrl != null);
                obtain.setData(bundle);
                obtain.arg1 = notificationProxy.mReplaceId;
                obtain.arg2 = notificationProxy.mHashCode;
                this.mService.send(obtain);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in function sendShowRequest");
            }
        } else if (this.mService == null) {
            notificationProxy.dispatchEvent(1);
            Log.e(TAG, "did not connect to the notification manager service !!!");
        }
    }

    private int getReplaceIdNum(int i) {
        int i2;
        synchronized (this.mNotificationProxys) {
            i2 = 0;
            for (Map.Entry entry : this.mNotificationProxys.entrySet()) {
                if (i == ((NotificationProxy) entry.getValue()).mReplaceId) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void sendCancelNotify(NotificationProxy notificationProxy) {
        if (notificationProxy != null && this.mService != null) {
            Log.i(TAG, "enter sendCancel replaceId=" + notificationProxy.mReplaceId + " mHashCode=" + notificationProxy.mHashCode);
            try {
                Message obtain = Message.obtain((Handler) null, 4);
                Bundle bundle = new Bundle();
                bundle.putString("packageName", notificationProxy.mPkgName);
                bundle.putString("appId", notificationProxy.mAppId);
                obtain.setData(bundle);
                obtain.arg1 = notificationProxy.mHashCode;
                this.mService.send(obtain);
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in function sendCancelNotify");
            }
        } else if (this.mService == null) {
            Log.e(TAG, "did not connect to the notification manager service !!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFromBroadcast() {
        Map.Entry entry;
        while (true) {
            synchronized (this.mNotificationProxys) {
                Iterator it = this.mNotificationProxys.entrySet().iterator();
                if (it.hasNext()) {
                    entry = (Map.Entry) it.next();
                } else {
                    this.mNotificationProxys.clear();
                    this.mService = null;
                    return;
                }
            }
            NotificationProxy notificationProxy = (NotificationProxy) entry.getValue();
            removeNotificationProxy(notificationProxy);
            notificationProxy.cancelFromUser();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNotificationProxy(NotificationProxy notificationProxy) {
        int indexOf;
        if (getReplaceIdNum(notificationProxy.mReplaceId) <= 1) {
            this.mReplaceIdMap.remove(Integer.valueOf(notificationProxy.mReplaceId));
            if (this.mDefaultIdArray.contains(Integer.valueOf(notificationProxy.mReplaceId)) && (indexOf = this.mDefaultIdArray.indexOf(Integer.valueOf(notificationProxy.mReplaceId))) != -1) {
                this.mDefaultIdArray.remove(indexOf);
            }
        }
        synchronized (this.mNotificationProxys) {
            this.mNotificationProxys.remove(Integer.valueOf(notificationProxy.mHashCode));
        }
    }

    private void cancelNotificationInner(NotificationProxy notificationProxy) {
        if (notificationProxy != null) {
            Log.i(TAG, "enter cancelNotificationInner replaceId=" + notificationProxy.mReplaceId + " mHashCode=" + notificationProxy.mHashCode);
            removeNotificationProxy(notificationProxy);
            notificationProxy.clear();
        }
    }

    public void destroy() {
        Map.Entry entry;
        while (true) {
            synchronized (this.mNotificationProxys) {
                Iterator it = this.mNotificationProxys.entrySet().iterator();
                if (!it.hasNext()) {
                    break;
                }
                entry = (Map.Entry) it.next();
            }
            cancelNotificationInner((NotificationProxy) entry.getValue());
        }
        this.mNotificationProxys.clear();
        if (this.mServiceInitReceiver != null) {
            this.mContext.unregisterReceiver(this.mServiceInitReceiver);
        }
        doUnbindService();
        this.mService = null;
        mInstance = null;
        this.isInit = false;
    }
}
