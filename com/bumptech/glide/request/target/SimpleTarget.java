package com.bumptech.glide.request.target;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
@Deprecated
/* loaded from: classes5.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    public final int height;
    public final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
        if (Util.isValidDimensions(this.width, this.height)) {
            sizeReadyCallback.onSizeReady(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }
}
