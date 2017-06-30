package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView flO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.flO = quickVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        v vVar;
        boolean z2;
        v vVar2;
        Context context;
        Uri uri;
        Map<String, String> map;
        int i3;
        v vVar3;
        v vVar4;
        Context context2;
        Uri uri2;
        Map<String, String> map2;
        Uri uri3;
        z = this.flO.flD;
        if (!z) {
            vVar = this.flO.flz;
            if (vVar != null) {
                z2 = this.flO.flH;
                if (z2) {
                    vVar2 = this.flO.flz;
                    context = this.flO.mContext;
                    uri = this.flO.mUri;
                    map = this.flO.AN;
                    i3 = this.flO.flG;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.flO.flD = false;
            vVar3 = this.flO.flz;
            if (vVar3 != null) {
                vVar4 = this.flO.flz;
                context2 = this.flO.mContext;
                uri2 = this.flO.mUri;
                map2 = this.flO.AN;
                uri3 = this.flO.mUri;
                vVar4.a(context2, uri2, map2, surfaceTexture, uri3.getHost());
            }
        }
        this.flO.flI = surfaceTexture;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v vVar;
        boolean z;
        QuickVideoView.a aVar;
        QuickVideoView.b bVar;
        QuickVideoView.b bVar2;
        QuickVideoView.a aVar2;
        v vVar2;
        vVar = this.flO.flz;
        if (vVar != null) {
            vVar2 = this.flO.flz;
            vVar2.release();
        }
        z = this.flO.flD;
        if (!z) {
            aVar = this.flO.flC;
            if (aVar != null) {
                aVar2 = this.flO.flC;
                aVar2.onStop();
            }
            bVar = this.flO.bBO;
            if (bVar != null) {
                bVar2 = this.flO.bBO;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.flO.flI = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
