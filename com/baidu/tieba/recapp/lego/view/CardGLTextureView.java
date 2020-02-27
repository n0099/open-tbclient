package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes13.dex */
public class CardGLTextureView extends GLTextureView {
    private boolean isDestroyed;

    public CardGLTextureView(Context context) {
        super(context);
        this.isDestroyed = false;
    }

    public CardGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isDestroyed = false;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.isDestroyed = true;
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public boolean isDestroyed() {
        return this.isDestroyed;
    }
}
