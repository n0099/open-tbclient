package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.TextureView;
import com.baidu.tieba.play.QuickVideoView;
import java.util.Map;
/* loaded from: classes.dex */
class ae implements TextureView.SurfaceTextureListener {
    final /* synthetic */ QuickVideoView eWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(QuickVideoView quickVideoView) {
        this.eWw = quickVideoView;
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
        z = this.eWw.eWm;
        if (!z) {
            vVar = this.eWw.eWi;
            if (vVar != null) {
                z2 = this.eWw.eWq;
                if (z2) {
                    vVar2 = this.eWw.eWi;
                    context = this.eWw.mContext;
                    uri = this.eWw.mUri;
                    map = this.eWw.Bj;
                    i3 = this.eWw.eWp;
                    vVar2.a(context, uri, map, surfaceTexture, i3);
                }
            }
        } else {
            this.eWw.eWm = false;
            vVar3 = this.eWw.eWi;
            if (vVar3 != null) {
                vVar4 = this.eWw.eWi;
                context2 = this.eWw.mContext;
                uri2 = this.eWw.mUri;
                map2 = this.eWw.Bj;
                vVar4.a(context2, uri2, map2, surfaceTexture);
            }
        }
        this.eWw.eWr = surfaceTexture;
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
        vVar = this.eWw.eWi;
        if (vVar != null) {
            vVar2 = this.eWw.eWi;
            vVar2.release();
        }
        z = this.eWw.eWm;
        if (!z) {
            aVar = this.eWw.eWl;
            if (aVar != null) {
                aVar2 = this.eWw.eWl;
                aVar2.onStop();
            }
            bVar = this.eWw.aTe;
            if (bVar != null) {
                bVar2 = this.eWw.aTe;
                bVar2.onSurfaceDestroyed();
            }
        }
        this.eWw.eWr = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
