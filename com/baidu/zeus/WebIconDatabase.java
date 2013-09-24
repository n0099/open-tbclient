package com.baidu.zeus;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.Browser;
import android.util.Log;
import java.util.HashMap;
import java.util.Vector;
/* loaded from: classes.dex */
public final class WebIconDatabase {
    private static final String LOGTAG = "WebIconDatabase";
    private static WebIconDatabase sIconDatabase;
    private final EventHandler mEventHandler = new EventHandler();

    /* loaded from: classes.dex */
    public interface IconListener {
        void onReceivedIcon(String str, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeClose();

    /* JADX INFO: Access modifiers changed from: private */
    public static native Bitmap nativeIconForPageUrl(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOpen(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeReleaseIconForPageUrl(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRemoveAllIcons();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRetainIconForPageUrl(String str);

    /* loaded from: classes.dex */
    class EventHandler extends Handler {
        static final int BULK_REQUEST_ICON = 6;
        static final int CLOSE = 1;
        private static final int ICON_RESULT = 10;
        static final int OPEN = 0;
        static final int RELEASE_ICON = 5;
        static final int REMOVE_ALL = 2;
        static final int REQUEST_ICON = 3;
        static final int RETAIN_ICON = 4;
        private Handler mHandler;
        private Vector<Message> mMessages;

        private EventHandler() {
            this.mMessages = new Vector<>();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class IconResult {
            private final Bitmap mIcon;
            private final IconListener mListener;
            private final String mUrl;

            IconResult(String str, Bitmap bitmap, IconListener iconListener) {
                this.mUrl = str;
                this.mIcon = bitmap;
                this.mListener = iconListener;
            }

            void dispatch() {
                this.mListener.onReceivedIcon(this.mUrl, this.mIcon);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 10:
                    ((IconResult) message.obj).dispatch();
                    return;
                default:
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void createHandler() {
            if (this.mHandler == null) {
                this.mHandler = new Handler() { // from class: com.baidu.zeus.WebIconDatabase.EventHandler.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        switch (message.what) {
                            case 0:
                                WebIconDatabase.nativeOpen((String) message.obj);
                                return;
                            case 1:
                                WebIconDatabase.nativeClose();
                                return;
                            case 2:
                                WebIconDatabase.nativeRemoveAllIcons();
                                return;
                            case 3:
                                String string = message.getData().getString("url");
                                EventHandler.this.requestIconAndSendResult(string, (IconListener) message.obj);
                                return;
                            case 4:
                                WebIconDatabase.nativeRetainIconForPageUrl((String) message.obj);
                                return;
                            case 5:
                                WebIconDatabase.nativeReleaseIconForPageUrl((String) message.obj);
                                return;
                            case 6:
                                EventHandler.this.bulkRequestIcons(message);
                                return;
                            default:
                                return;
                        }
                    }
                };
                for (int size = this.mMessages.size(); size > 0; size--) {
                    this.mHandler.sendMessage(this.mMessages.remove(0));
                }
                this.mMessages = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean hasHandler() {
            return this.mHandler != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void postMessage(Message message) {
            if (this.mMessages != null) {
                this.mMessages.add(message);
            } else {
                this.mHandler.sendMessage(message);
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0060 */
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0045  */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.HashMap] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void bulkRequestIcons(Message message) {
            Cursor cursor;
            ?? r1 = (HashMap) message.obj;
            IconListener iconListener = (IconListener) r1.get("listener");
            try {
                try {
                    cursor = ((ContentResolver) r1.get("contentResolver")).query(Browser.BOOKMARKS_URI, new String[]{"url"}, (String) r1.get("where"), null, null);
                    try {
                        if (cursor.moveToFirst()) {
                            do {
                                requestIconAndSendResult(cursor.getString(0), iconListener);
                            } while (cursor.moveToNext());
                            if (cursor == null) {
                                cursor.close();
                            }
                        } else if (cursor == null) {
                        }
                    } catch (IllegalStateException e) {
                        e = e;
                        Log.e(WebIconDatabase.LOGTAG, "BulkRequestIcons", e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        r1.close();
                    }
                    throw th;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestIconAndSendResult(String str, IconListener iconListener) {
            Bitmap nativeIconForPageUrl = WebIconDatabase.nativeIconForPageUrl(str);
            if (nativeIconForPageUrl != null) {
                sendMessage(obtainMessage(10, new IconResult(str, nativeIconForPageUrl, iconListener)));
            }
        }
    }

    public void open(String str) {
        if (str != null) {
            this.mEventHandler.postMessage(Message.obtain(null, 0, str));
        }
    }

    public void close() {
        this.mEventHandler.postMessage(Message.obtain((Handler) null, 1));
    }

    public void removeAllIcons() {
        this.mEventHandler.postMessage(Message.obtain((Handler) null, 2));
    }

    public void requestIconForPageUrl(String str, IconListener iconListener) {
        if (iconListener != null && str != null) {
            Message obtain = Message.obtain(null, 3, iconListener);
            obtain.getData().putString("url", str);
            this.mEventHandler.postMessage(obtain);
        }
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, IconListener iconListener) {
        if (iconListener != null && this.mEventHandler.hasHandler()) {
            HashMap hashMap = new HashMap();
            hashMap.put("contentResolver", contentResolver);
            hashMap.put("where", str);
            hashMap.put("listener", iconListener);
            this.mEventHandler.postMessage(Message.obtain(null, 6, hashMap));
        }
    }

    public void retainIconForPageUrl(String str) {
        if (str != null) {
            this.mEventHandler.postMessage(Message.obtain(null, 4, str));
        }
    }

    public void releaseIconForPageUrl(String str) {
        if (str != null) {
            this.mEventHandler.postMessage(Message.obtain(null, 5, str));
        }
    }

    public static WebIconDatabase getInstance() {
        if (sIconDatabase == null) {
            sIconDatabase = new WebIconDatabase();
        }
        return sIconDatabase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createHandler() {
        this.mEventHandler.createHandler();
    }

    private WebIconDatabase() {
    }
}
