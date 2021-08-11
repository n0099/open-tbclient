package com.bytedance.sdk.component.image;

import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public interface ILoaderListener<T> {
    void onFailed(int i2, String str, @Nullable Throwable th);

    void onSuccess(ImageResponse<T> imageResponse);
}
