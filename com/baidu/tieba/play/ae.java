package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eSP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eSP = quickVideoView;
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
        z = this.eSP.eSF;
        if (!z) {
            vVar = this.eSP.eSB;
            if (vVar != null) {
                z2 = this.eSP.eSJ;
                if (z2) {
                    vVar2 = this.eSP.eSB;
                    context = this.eSP.mContext;
                    uri = this.eSP.mUri;
                    map = this.eSP.tU;
                    i3 = this.eSP.eSI;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.eSP.eSF = false;
            vVar3 = this.eSP.eSB;
            if (vVar3 != null) {
                vVar4 = this.eSP.eSB;
                context2 = this.eSP.mContext;
                uri2 = this.eSP.mUri;
                map2 = this.eSP.tU;
                vVar4.a(context2, uri2, map2, surfaceTexture);
            }
        }
        this.eSP.eSK = surfaceTexture;
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
        vVar = this.eSP.eSB;
        if (vVar != null) {
            vVar2 = this.eSP.eSB;
            vVar2.release();
        }
        z = this.eSP.eSF;
        if (!z) {
            aVar = this.eSP.eSE;
            if (aVar != null) {
                aVar2 = this.eSP.eSE;
                aVar2.onStop();
            }
            bVar = this.eSP.aNr;
            if (bVar != null) {
                bVar2 = this.eSP.aNr;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.eSP.eSK = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
