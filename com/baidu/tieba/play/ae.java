package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eSL = quickVideoView;
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
        z = this.eSL.eSB;
        if (!z) {
            vVar = this.eSL.eSx;
            if (vVar != null) {
                z2 = this.eSL.eSF;
                if (z2) {
                    vVar2 = this.eSL.eSx;
                    context = this.eSL.mContext;
                    uri = this.eSL.mUri;
                    map = this.eSL.AN;
                    i3 = this.eSL.eSE;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.eSL.eSB = false;
            vVar3 = this.eSL.eSx;
            if (vVar3 != null) {
                vVar4 = this.eSL.eSx;
                context2 = this.eSL.mContext;
                uri2 = this.eSL.mUri;
                map2 = this.eSL.AN;
                vVar4.a(context2, uri2, map2, surfaceTexture);
            }
        }
        this.eSL.eSG = surfaceTexture;
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
        vVar = this.eSL.eSx;
        if (vVar != null) {
            vVar2 = this.eSL.eSx;
            vVar2.release();
        }
        z = this.eSL.eSB;
        if (!z) {
            aVar = this.eSL.eSA;
            if (aVar != null) {
                aVar2 = this.eSL.eSA;
                aVar2.onStop();
            }
            bVar = this.eSL.aTQ;
            if (bVar != null) {
                bVar2 = this.eSL.aTQ;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.eSL.eSG = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
