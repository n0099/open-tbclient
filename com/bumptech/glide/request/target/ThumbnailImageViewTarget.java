package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public abstract Drawable getDrawable(T t);

    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f1196view).getLayoutParams();
        Drawable drawable = getDrawable(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawable = new FixedSizeDrawable(drawable, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f1196view).setImageDrawable(drawable);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
