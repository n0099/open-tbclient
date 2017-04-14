package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eUv = quickVideoView;
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
        z = this.eUv.eUl;
        if (!z) {
            vVar = this.eUv.eUh;
            if (vVar != null) {
                z2 = this.eUv.eUp;
                if (z2) {
                    vVar2 = this.eUv.eUh;
                    context = this.eUv.mContext;
                    uri = this.eUv.mUri;
                    map = this.eUv.AK;
                    i3 = this.eUv.eUo;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.eUv.eUl = false;
            vVar3 = this.eUv.eUh;
            if (vVar3 != null) {
                vVar4 = this.eUv.eUh;
                context2 = this.eUv.mContext;
                uri2 = this.eUv.mUri;
                map2 = this.eUv.AK;
                vVar4.a(context2, uri2, map2, surfaceTexture);
            }
        }
        this.eUv.eUq = surfaceTexture;
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
        vVar = this.eUv.eUh;
        if (vVar != null) {
            vVar2 = this.eUv.eUh;
            vVar2.release();
        }
        z = this.eUv.eUl;
        if (!z) {
            aVar = this.eUv.eUk;
            if (aVar != null) {
                aVar2 = this.eUv.eUk;
                aVar2.onStop();
            }
            bVar = this.eUv.aTt;
            if (bVar != null) {
                bVar2 = this.eUv.aTt;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.eUv.eUq = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
