package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.facebook.common.util.UriUtil;
import java.util.List;
/* loaded from: classes5.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
    public static final int ID_PATH_SEGMENTS = 1;
    public static final int NAME_PATH_SEGMENT_INDEX = 1;
    public static final int NAME_URI_PATH_SEGMENTS = 2;
    public static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    public static final int TYPE_PATH_SEGMENT_INDEX = 0;
    public final Context context;

    public ResourceDrawableDecoder(Context context) {
        this.context = context.getApplicationContext();
    }

    @NonNull
    private Context getContextForPackage(Uri uri, String str) {
        try {
            return this.context.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int loadResourceIdFromUri(Uri uri) {
        Integer valueOf;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            String str = pathSegments.get(1);
            valueOf = Integer.valueOf(this.context.getResources().getIdentifier(str, pathSegments.get(0), authority));
        } else {
            if (pathSegments.size() == 1) {
                try {
                    valueOf = Integer.valueOf(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                }
            }
            valueOf = null;
        }
        if (valueOf != null) {
            if (valueOf.intValue() != 0) {
                return valueOf.intValue();
            }
            throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    public Resource<Drawable> decode(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        int loadResourceIdFromUri = loadResourceIdFromUri(uri);
        String authority = uri.getAuthority();
        return NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, authority.equals(this.context.getPackageName()) ? this.context : getContextForPackage(uri, authority), loadResourceIdFromUri));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@NonNull Uri uri, @NonNull Options options) {
        return uri.getScheme().equals(UriUtil.QUALIFIED_RESOURCE_SCHEME);
    }
}
