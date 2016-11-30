package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ac implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView fgc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(QuickVideoView quickVideoView) {
        this.fgc = quickVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        t tVar;
        t tVar2;
        Context context;
        Uri uri;
        Map<String, String> map;
        z = this.fgc.ffV;
        if (z) {
            this.fgc.ffV = false;
            tVar = this.fgc.ffR;
            if (tVar != null) {
                tVar2 = this.fgc.ffR;
                context = this.fgc.mContext;
                uri = this.fgc.mUri;
                map = this.fgc.ud;
                tVar2.a(context, uri, map, surfaceTexture);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        t tVar;
        boolean z;
        QuickVideoView.a aVar;
        QuickVideoView.b bVar;
        QuickVideoView.b bVar2;
        QuickVideoView.a aVar2;
        t tVar2;
        tVar = this.fgc.ffR;
        if (tVar != null) {
            tVar2 = this.fgc.ffR;
            tVar2.release();
        }
        z = this.fgc.ffV;
        if (!z) {
            aVar = this.fgc.ffU;
            if (aVar != null) {
                aVar2 = this.fgc.ffU;
                aVar2.onStop();
            }
            bVar = this.fgc.aOX;
            if (bVar != null) {
                bVar2 = this.fgc.aOX;
                bVar2.onSurfaceDestroyed();
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
