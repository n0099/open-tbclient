package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ac implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(QuickVideoView quickVideoView) {
        this.eJu = quickVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        t tVar;
        t tVar2;
        Context context;
        Uri uri;
        Map<String, String> map;
        z = this.eJu.eJn;
        if (z) {
            this.eJu.eJn = false;
            tVar = this.eJu.eJj;
            if (tVar != null) {
                tVar2 = this.eJu.eJj;
                context = this.eJu.mContext;
                uri = this.eJu.mUri;
                map = this.eJu.ud;
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
        tVar = this.eJu.eJj;
        if (tVar != null) {
            tVar2 = this.eJu.eJj;
            tVar2.release();
        }
        z = this.eJu.eJn;
        if (!z) {
            aVar = this.eJu.eJm;
            if (aVar != null) {
                aVar2 = this.eJu.eJm;
                aVar2.onStop();
            }
            bVar = this.eJu.aOo;
            if (bVar != null) {
                bVar2 = this.eJu.aOo;
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
