package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class CardGLTextureView extends GLTextureView {
    private boolean Xd;

    public CardGLTextureView(Context context) {
        super(context);
        this.Xd = false;
    }

    public CardGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xd = false;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.Xd = true;
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public boolean isDestroyed() {
        return this.Xd;
    }
}
