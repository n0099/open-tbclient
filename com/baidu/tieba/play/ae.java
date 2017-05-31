package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView fby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.fby = quickVideoView;
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
        z = this.fby.fbn;
        if (!z) {
            vVar = this.fby.fbj;
            if (vVar != null) {
                z2 = this.fby.fbr;
                if (z2) {
                    vVar2 = this.fby.fbj;
                    context = this.fby.mContext;
                    uri = this.fby.mUri;
                    map = this.fby.AN;
                    i3 = this.fby.fbq;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.fby.fbn = false;
            vVar3 = this.fby.fbj;
            if (vVar3 != null) {
                vVar4 = this.fby.fbj;
                context2 = this.fby.mContext;
                uri2 = this.fby.mUri;
                map2 = this.fby.AN;
                uri3 = this.fby.mUri;
                vVar4.a(context2, uri2, map2, surfaceTexture, uri3.getHost());
            }
        }
        this.fby.fbs = surfaceTexture;
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
        vVar = this.fby.fbj;
        if (vVar != null) {
            vVar2 = this.fby.fbj;
            vVar2.release();
        }
        z = this.fby.fbn;
        if (!z) {
            aVar = this.fby.fbm;
            if (aVar != null) {
                aVar2 = this.fby.fbm;
                aVar2.onStop();
            }
            bVar = this.fby.bAV;
            if (bVar != null) {
                bVar2 = this.fby.bAV;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.fby.fbs = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
