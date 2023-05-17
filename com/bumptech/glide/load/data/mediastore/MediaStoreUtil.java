package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;
/* loaded from: classes8.dex */
public final class MediaStoreUtil {
    public static final int MINI_THUMB_HEIGHT = 384;
    public static final int MINI_THUMB_WIDTH = 512;

    public static boolean isThumbnailSize(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean isMediaStoreImageUri(Uri uri) {
        if (isMediaStoreUri(uri) && !isVideoUri(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreUri(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean isMediaStoreVideoUri(Uri uri) {
        if (isMediaStoreUri(uri) && isVideoUri(uri)) {
            return true;
        }
        return false;
    }

    public static boolean isVideoUri(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
