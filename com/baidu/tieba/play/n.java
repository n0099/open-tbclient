package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class n implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eYQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(QuickVideoView quickVideoView) {
        this.eYQ = quickVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        e eVar;
        e eVar2;
        Context context;
        Uri uri;
        Map<String, String> map;
        z = this.eYQ.eYK;
        if (z) {
            this.eYQ.eYK = false;
            eVar = this.eYQ.eYG;
            if (eVar != null) {
                eVar2 = this.eYQ.eYG;
                context = this.eYQ.mContext;
                uri = this.eYQ.mUri;
                map = this.eYQ.uc;
                eVar2.a(context, uri, map, surfaceTexture);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        e eVar;
        QuickVideoView.a aVar;
        QuickVideoView.b bVar;
        QuickVideoView.b bVar2;
        QuickVideoView.a aVar2;
        e eVar2;
        z = this.eYQ.eYK;
        if (!z) {
            eVar = this.eYQ.eYG;
            if (eVar != null) {
                eVar2 = this.eYQ.eYG;
                eVar2.release();
            }
            aVar = this.eYQ.eYJ;
            if (aVar != null) {
                aVar2 = this.eYQ.eYJ;
                aVar2.onStop();
            }
            bVar = this.eYQ.aMS;
            if (bVar != null) {
                bVar2 = this.eYQ.aMS;
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
