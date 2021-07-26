package com.bytedance.sdk.component.image;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public interface IImageLoader {
    IImageLoader cache(boolean z);

    IImageLoader cache(boolean z, boolean z2);

    IImageLoader config(Bitmap.Config config);

    IImageLoader from(String str);

    IImageLoader headers(boolean z);

    IImageLoader height(int i2);

    IImageLoader key(String str);

    IImageLoader requestTime(boolean z);

    IImageLoader scaleType(ImageView.ScaleType scaleType);

    IImageHandler to(ImageView imageView);

    IImageHandler to(ILoaderListener iLoaderListener);

    IImageHandler to(ILoaderListener iLoaderListener, ImageThread imageThread);

    IImageLoader track(IStepTracker iStepTracker);

    IImageLoader type(ResultType resultType);

    IImageLoader width(int i2);
}
