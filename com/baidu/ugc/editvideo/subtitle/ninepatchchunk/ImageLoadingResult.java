package com.baidu.ugc.editvideo.subtitle.ninepatchchunk;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
/* loaded from: classes7.dex */
public class ImageLoadingResult {
    public final Bitmap bitmap;
    public final NinePatchChunk chunk;

    public ImageLoadingResult(Bitmap bitmap, NinePatchChunk ninePatchChunk) {
        this.bitmap = bitmap;
        this.chunk = ninePatchChunk;
    }

    public NinePatchDrawable getNinePatchDrawable(Resources resources, String str) {
        if (this.bitmap == null) {
            return null;
        }
        return this.chunk == null ? new NinePatchDrawable(resources, this.bitmap, null, new Rect(), str) : new NinePatchDrawable(resources, this.bitmap, this.chunk.toBytes(), this.chunk.padding, str);
    }
}
