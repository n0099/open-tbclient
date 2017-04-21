package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eWL = quickVideoView;
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
        z = this.eWL.eWB;
        if (!z) {
            vVar = this.eWL.eWx;
            if (vVar != null) {
                z2 = this.eWL.eWF;
                if (z2) {
                    vVar2 = this.eWL.eWx;
                    context = this.eWL.mContext;
                    uri = this.eWL.mUri;
                    map = this.eWL.AN;
                    i3 = this.eWL.eWE;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.eWL.eWB = false;
            vVar3 = this.eWL.eWx;
            if (vVar3 != null) {
                vVar4 = this.eWL.eWx;
                context2 = this.eWL.mContext;
                uri2 = this.eWL.mUri;
                map2 = this.eWL.AN;
                vVar4.a(context2, uri2, map2, surfaceTexture);
            }
        }
        this.eWL.eWG = surfaceTexture;
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
        vVar = this.eWL.eWx;
        if (vVar != null) {
            vVar2 = this.eWL.eWx;
            vVar2.release();
        }
        z = this.eWL.eWB;
        if (!z) {
            aVar = this.eWL.eWA;
            if (aVar != null) {
                aVar2 = this.eWL.eWA;
                aVar2.onStop();
            }
            bVar = this.eWL.aTv;
            if (bVar != null) {
                bVar2 = this.eWL.aTv;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.eWL.eWG = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
