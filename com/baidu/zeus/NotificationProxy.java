package com.baidu.zeus;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.PushConstants;
/* loaded from: classes.dex */
public class NotificationProxy extends Notification {
    public static final int EVENT_TYPE_CLEAN = 20;
    public static final int EVENT_TYPE_CLICK = 3;
    public static final int EVENT_TYPE_CLOSE = 4;
    public static final int EVENT_TYPE_ERROR = 1;
    public static final int EVENT_TYPE_SHOW = 2;
    public static final int EVENT_TYPE_START_ACTIVITY = 5;
    private static final int MAX_BITMAP_SIZE = 2097152;
    public static final int MAX_BODY_LENGTH = 10240;
    public static final int MAX_TITLE_LENGTH = 10240;
    public static final int MAX_URL_LENGTH = 1024;
    private static final String TAG = "NotificationProxy";
    private static final String WEBCONTENT_CLOSE_ACTION = "android.intent.action.WEBCONTENTCLOSE";
    boolean isShow;
    private int mAppIcon;
    public String mAppId;
    private Bitmap mBitmap;
    public Context mContext;
    public int mHashCode;
    private byte[] mIconData;
    private int mNativePointer;
    private NotificationManager mNotificationManager;
    private NotificationManagerThread mNotificationManagerThread;
    public String mPkgName;
    public int mReplaceId;
    private int mSimpleIcon;
    public int mSystemId;
    private String mText;
    private String mTitle;
    public String mUrl;
    private int mWebIcon;
    public WebViewCore mWebViewCore;

    public NotificationProxy(Context context, WebViewCore webViewCore, NotificationManagerThread notificationManagerThread, String str, int i, int i2) {
        this.mReplaceId = 0;
        this.mSystemId = 0;
        this.isShow = false;
        this.mAppIcon = 0;
        this.mSimpleIcon = 0;
        this.mWebIcon = 0;
        Log.i(TAG, "new a NotificationProxy instance context=" + context + " replaceId=" + i + " nativePointer=" + i2 + " domain=" + str);
        this.mContext = context;
        this.mWebViewCore = webViewCore;
        this.mPkgName = this.mContext.getPackageName();
        this.mAppId = str;
        this.mReplaceId = i;
        this.mNativePointer = i2;
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        this.mNotificationManagerThread = notificationManagerThread;
    }

    public NotificationProxy() {
        this.mReplaceId = 0;
        this.mSystemId = 0;
        this.isShow = false;
        this.mAppIcon = 0;
        this.mSimpleIcon = 0;
        this.mWebIcon = 0;
    }

    public void initResource(int i, int i2, int i3) {
        this.mAppIcon = i;
        this.mSimpleIcon = i2;
        this.mWebIcon = i3;
    }

    public boolean simpleNotificationInit(byte[] bArr, String str, String str2) {
        if (!checkLength(str, 10240) || !checkLength(str2, 10240)) {
            Log.e(TAG, "normal notification title or body text is too long to display !");
            dispatchEvent(1);
            cancelFromJs();
            return false;
        }
        this.mIconData = bArr;
        this.mTitle = str;
        this.mText = str2;
        this.mNotificationManagerThread.sendShowRequest(this);
        return true;
    }

    public boolean webNotificationInit(String str) {
        if (!checkLength(str, MAX_URL_LENGTH)) {
            Log.e(TAG, "HtmlNotification url is invalid");
            dispatchEvent(1);
            cancelFromJs();
            return false;
        }
        this.mTitle = "WebNotification";
        this.mText = "this is " + str + " web notification";
        this.mUrl = str;
        this.mNotificationManagerThread.sendShowRequest(this);
        return true;
    }

    public void cancelFromJs() {
        this.mNotificationManagerThread.sendCancelNotify(this);
    }

    public void cancelFromUser() {
        if (this.isShow) {
            if (this.mUrl != null) {
                Intent intent = new Intent(WEBCONTENT_CLOSE_ACTION);
                intent.putExtra("com.android.notification.ReplaceId", this.mReplaceId);
                intent.putExtra("com.android.notification.PackageName", this.mPkgName);
                intent.putExtra("com.android.notification.AppId", this.mAppId);
                this.mContext.sendBroadcast(intent);
            }
            this.mNotificationManager.cancel(this.mAppId, this.mReplaceId);
            dispatchEvent(4);
            this.isShow = false;
        }
        if (this.contentIntent != null) {
            this.contentIntent.cancel();
        }
        if (this.deleteIntent != null) {
            this.deleteIntent.cancel();
        }
        clear();
    }

    private int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    private Bitmap resizeImage(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x01bb -> B:40:0x00ae). Please submit an issue!!! */
    private boolean creatRemoteViews() {
        Bitmap decodeByteArray;
        int i = 25;
        int sDKVersion = getSDKVersion();
        int identifier = this.mContext.getResources().getIdentifier("notification_icon", "id", this.mPkgName);
        int identifier2 = this.mContext.getResources().getIdentifier(PushConstants.EXTRA_NOTIFICATION_TITLE, "id", this.mPkgName);
        int identifier3 = this.mContext.getResources().getIdentifier("notification_text", "id", this.mPkgName);
        Log.i(TAG, "enter creatRemoteViews imageId=" + identifier + " titleId=" + identifier2 + " textId=" + identifier3);
        switch (sDKVersion) {
            case 7:
                int identifier4 = this.mContext.getResources().getIdentifier("notification_remoteviews_content_7", "layout", this.mPkgName);
                Log.i(TAG, "sdk:" + sDKVersion + " enter creatRemoteViews layoutId=" + identifier4);
                this.contentView = new RemoteViews(this.mPkgName, identifier4);
                break;
            case 8:
                int identifier5 = this.mContext.getResources().getIdentifier("notification_remoteviews_content_8", "layout", this.mPkgName);
                Log.i(TAG, "sdk:" + sDKVersion + " enter creatRemoteViews layoutId=" + identifier5);
                this.contentView = new RemoteViews(this.mPkgName, identifier5);
                break;
            case 9:
            case 10:
                int identifier6 = this.mContext.getResources().getIdentifier("notification_remoteviews_content_9", "layout", this.mPkgName);
                Log.i(TAG, "sdk:" + sDKVersion + " enter creatRemoteViews layoutId=" + identifier6);
                this.contentView = new RemoteViews(this.mPkgName, identifier6);
                break;
            case 11:
            case 12:
            case 13:
            default:
                return false;
            case 14:
            case 15:
                i = 64;
                int identifier7 = this.mContext.getResources().getIdentifier("notification_remoteviews_content_14", "layout", this.mPkgName);
                Log.i(TAG, "sdk:" + sDKVersion + " enter creatRemoteViews layoutId=" + identifier7);
                this.contentView = new RemoteViews(this.mPkgName, identifier7);
                break;
        }
        if (this.mUrl != null) {
            this.contentView.setImageViewResource(identifier, this.mWebIcon);
        } else if (this.mIconData != null && this.mIconData.length != 0) {
            if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                this.mBitmap.recycle();
            }
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(this.mIconData, 0, this.mIconData.length);
            } catch (Throwable th) {
                Log.e(TAG, "BitmapFactory decode icon data error:: OutOfMemoryError");
                this.contentView.setImageViewResource(identifier, this.mSimpleIcon);
            }
            if (decodeByteArray != null) {
                this.mBitmap = resizeImage(decodeByteArray, i, i);
                decodeByteArray.recycle();
                if (this.mBitmap != null) {
                    this.contentView.setImageViewBitmap(identifier, this.mBitmap);
                }
            }
            this.contentView.setImageViewResource(identifier, this.mSimpleIcon);
        } else {
            Log.e(TAG, "icon data is null");
            this.contentView.setImageViewResource(identifier, this.mSimpleIcon);
        }
        if (this.mTitle != null) {
            this.contentView.setTextViewText(identifier2, this.mTitle);
        }
        if (this.mText != null) {
            this.contentView.setTextViewText(identifier3, this.mText);
        }
        return true;
    }

    public void showNotification(int i) {
        this.mSystemId = i;
        if (this.mUrl != null) {
            Intent intent = new Intent("baidu.intent.action.NOTIFICATION", Uri.fromParts("package", this.mPkgName + this.mHashCode, null));
            intent.putExtra("com.android.notification.ReplaceId", this.mReplaceId);
            intent.putExtra("com.android.notification.PackageName", this.mPkgName);
            intent.putExtra("com.android.notification.AppId", this.mAppId);
            intent.putExtra("com.android.notification.Event", 5);
            intent.putExtra("com.android.notification.Url", this.mUrl);
            intent.setClassName(this.mPkgName, "com.baidu.browser.apps.BrowserActivity");
            this.contentIntent = PendingIntent.getActivity(this.mContext, 0, intent, 0);
            Intent intent2 = new Intent(NotificationManagerThread.NOTIFICATION_CLOSE_ACTION, Uri.fromParts("package", this.mPkgName + this.mHashCode, null));
            intent2.putExtra("com.android.notification.ReplaceId", this.mReplaceId);
            intent2.putExtra("com.android.notification.PackageName", this.mPkgName);
            intent2.putExtra("com.android.notification.AppId", this.mAppId);
            intent2.putExtra("com.android.notification.Event", 4);
            this.deleteIntent = PendingIntent.getBroadcast(this.mContext, 0, intent2, 0);
            this.flags |= 16;
            this.icon = this.mAppIcon;
            if (!creatRemoteViews()) {
                setLatestEventInfo(this.mContext, this.mTitle, this.mText, this.contentIntent);
            }
        } else {
            Intent intent3 = new Intent(NotificationManagerThread.NOTIFICATION_CLICK_ACTION, Uri.fromParts("package", this.mPkgName + this.mHashCode, null));
            intent3.putExtra("com.android.notification.ReplaceId", this.mReplaceId);
            intent3.putExtra("com.android.notification.PackageName", this.mPkgName);
            intent3.putExtra("com.android.notification.AppId", this.mAppId);
            intent3.putExtra("com.android.notification.Event", 3);
            intent3.setClassName(this.mPkgName, "com.baidu.htmlNotification.WebNotificationManagerService");
            this.contentIntent = PendingIntent.getService(this.mContext, 0, intent3, 0);
            Intent intent4 = new Intent(NotificationManagerThread.NOTIFICATION_CLOSE_ACTION, Uri.fromParts("package", this.mPkgName + this.mHashCode, null));
            intent4.putExtra("com.android.notification.ReplaceId", this.mReplaceId);
            intent4.putExtra("com.android.notification.PackageName", this.mPkgName);
            intent4.putExtra("com.android.notification.AppId", this.mAppId);
            intent4.putExtra("com.android.notification.Event", 4);
            this.deleteIntent = PendingIntent.getBroadcast(this.mContext, 0, intent4, 0);
            this.flags |= 16;
            this.icon = this.mAppIcon;
            if (!creatRemoteViews()) {
                setLatestEventInfo(this.mContext, this.mTitle, this.mText, this.contentIntent);
            }
        }
        dispatchEvent(2);
        this.isShow = true;
        this.mNotificationManager.notify(this.mAppId, this.mReplaceId, this);
    }

    public void dispatchEvent(int i) {
        if (this.mNativePointer != 0) {
            this.mWebViewCore.notificationEventDispatch(this.mNativePointer, i);
        }
    }

    private boolean checkLength(String str, int i) {
        return ((str == null || "".equals(str.trim())) ? 0 : str.length()) <= i;
    }

    public void clear() {
        this.mWebViewCore.notificationEventDispatch(this.mNativePointer, 20);
        this.mNativePointer = 0;
        this.isShow = false;
        this.mIconData = null;
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
        }
    }
}
