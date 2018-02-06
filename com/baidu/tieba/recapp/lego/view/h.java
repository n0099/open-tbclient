package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.baidu.tieba.vr.player.framework.GLTextureView;
/* loaded from: classes3.dex */
public class h extends GLTextureView {
    private boolean isDestroyed;

    public h(Context context) {
        super(context);
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
