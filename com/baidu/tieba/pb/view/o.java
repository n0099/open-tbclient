package com.baidu.tieba.pb.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements MediaPlayer.OnVideoSizeChangedListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        int i3;
        int i4;
        this.cWq.mVideoWidth = mediaPlayer.getVideoWidth();
        this.cWq.mVideoHeight = mediaPlayer.getVideoHeight();
        i3 = this.cWq.mVideoWidth;
        if (i3 != 0) {
            i4 = this.cWq.mVideoHeight;
            if (i4 != 0) {
                this.cWq.requestLayout();
            }
        }
    }
}
