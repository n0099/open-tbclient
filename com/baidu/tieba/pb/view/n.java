package com.baidu.tieba.pb.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.widget.MediaController;
import com.baidu.tieba.pb.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextureView.SurfaceTextureListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.cWq.mSurfaceTexture = surfaceTexture;
        this.cWq.asW();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        TextureVideoView.a aVar;
        MediaController mediaController;
        MediaController mediaController2;
        TextureVideoView.a aVar2;
        aVar = this.cWq.cKK;
        if (aVar != null) {
            aVar2 = this.cWq.cKK;
            aVar2.ape();
        }
        this.cWq.mSurfaceTexture = null;
        mediaController = this.cWq.cWb;
        if (mediaController != null) {
            mediaController2 = this.cWq.cWb;
            mediaController2.hide();
        }
        this.cWq.fP(true);
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
