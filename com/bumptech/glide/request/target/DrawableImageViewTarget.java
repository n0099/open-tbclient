package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    public void setResource(@Nullable Drawable drawable) {
        ((ImageView) this.f1196view).setImageDrawable(drawable);
    }

    @Deprecated
    public DrawableImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
