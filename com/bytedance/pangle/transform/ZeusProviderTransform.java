package com.bytedance.pangle.transform;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.MethodUtils;
@Keep
/* loaded from: classes8.dex */
public class ZeusProviderTransform {
    public static Bundle call(Object obj, Uri uri, String str, String str2, Bundle bundle, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().call((ContentResolver) obj, uri, str, str2, bundle, str3);
        }
        try {
            return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{uri, str, str2, bundle}, new Class[]{Uri.class, String.class, String.class, Bundle.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequiresApi(api = 26)
    public static Cursor query(Object obj, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, bundle, cancellationSignal, str);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, bundle, cancellationSignal}, new Class[]{Uri.class, String[].class, Bundle.class, CancellationSignal.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Bundle call(Object obj, String str, String str2, String str3, Bundle bundle, String str4) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().call((ContentResolver) obj, str, str2, str3, bundle, str4);
        }
        try {
            return (Bundle) MethodUtils.invokeMethod(obj, NotificationCompat.CATEGORY_CALL, new Object[]{str, str2, str3, bundle}, new Class[]{String.class, String.class, String.class, Bundle.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(Object obj, Uri uri, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, bundle, str);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, bundle}, new Class[]{Uri.class, Bundle.class})).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int delete(Object obj, Uri uri, String str, String[] strArr, String str2) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().delete((ContentResolver) obj, uri, str, strArr, str2);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, "delete", new Object[]{uri, str, strArr}, new Class[]{Uri.class, String.class, String[].class})).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, bundle, str);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, StickerDataChangeType.UPDATE, new Object[]{uri, contentValues, bundle}, new Class[]{Uri.class, ContentValues.class, Bundle.class})).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getType(Object obj, Uri uri, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().getType((ContentResolver) obj, uri, str);
        }
        try {
            return (String) MethodUtils.invokeMethod(obj, "getType", new Object[]{uri}, new Class[]{Uri.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Uri insert(Object obj, Uri uri, ContentValues contentValues, String str) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().insert((ContentResolver) obj, uri, contentValues, str);
        }
        try {
            return (Uri) MethodUtils.invokeMethod(obj, "insert", new Object[]{uri, contentValues}, new Class[]{Uri.class, ContentValues.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, str, strArr2, str2, cancellationSignal}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class, CancellationSignal.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Cursor query(Object obj, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().query((ContentResolver) obj, uri, strArr, str, strArr2, str2, str3);
        }
        try {
            return (Cursor) MethodUtils.invokeMethod(obj, "query", new Object[]{uri, strArr, str, strArr2, str2}, new Class[]{Uri.class, String[].class, String.class, String[].class, String.class});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int update(Object obj, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        if (obj instanceof ContentResolver) {
            return ContentProviderManager.getInstance().update((ContentResolver) obj, uri, contentValues, str, strArr, str2);
        }
        try {
            return ((Integer) MethodUtils.invokeMethod(obj, StickerDataChangeType.UPDATE, new Object[]{uri, contentValues, str, strArr}, new Class[]{Uri.class, ContentValues.class, String.class, String[].class})).intValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
