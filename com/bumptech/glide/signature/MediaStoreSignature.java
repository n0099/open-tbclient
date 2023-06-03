package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* loaded from: classes9.dex */
public class MediaStoreSignature implements Key {
    public final long dateModified;
    @NonNull
    public final String mimeType;
    public final int orientation;

    public MediaStoreSignature(@Nullable String str, long j, int i) {
        this.mimeType = str == null ? "" : str;
        this.dateModified = j;
        this.orientation = i;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaStoreSignature.class != obj.getClass()) {
            return false;
        }
        MediaStoreSignature mediaStoreSignature = (MediaStoreSignature) obj;
        if (this.dateModified == mediaStoreSignature.dateModified && this.orientation == mediaStoreSignature.orientation && this.mimeType.equals(mediaStoreSignature.mimeType)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putLong(this.dateModified).putInt(this.orientation).array());
        messageDigest.update(this.mimeType.getBytes(Key.CHARSET));
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        long j = this.dateModified;
        return (((this.mimeType.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.orientation;
    }
}
