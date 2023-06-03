package com.bumptech.glide.signature;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
/* loaded from: classes9.dex */
public final class EmptySignature implements Key {
    public static final EmptySignature EMPTY_KEY = new EmptySignature();

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
    }

    @NonNull
    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }
}
