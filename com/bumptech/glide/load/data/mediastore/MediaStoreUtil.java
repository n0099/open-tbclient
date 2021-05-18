package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
import com.baidubce.services.vod.VodClient;
/* loaded from: classes4.dex */
public final class MediaStoreUtil {
    public static final int MINI_THUMB_HEIGHT = 384;
    public static final int MINI_THUMB_WIDTH = 512;

    public static boolean isMediaStoreImageUri(Uri uri) {
        return isMediaStoreUri(uri) && !isVideoUri(uri);
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && VodClient.PATH_MEDIA.equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        return isMediaStoreUri(uri) && isVideoUri(uri);
    }

    public static boolean isThumbnailSize(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
