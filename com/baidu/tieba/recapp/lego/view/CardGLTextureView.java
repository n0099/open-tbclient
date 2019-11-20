package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class CardGLTextureView extends GLTextureView {
    private boolean WK;

    public CardGLTextureView(Context context) {
        super(context);
        this.WK = false;
    }

    public CardGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WK = false;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.WK = true;
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public boolean isDestroyed() {
        return this.WK;
    }
}
