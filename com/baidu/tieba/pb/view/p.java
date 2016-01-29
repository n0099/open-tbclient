package com.baidu.tieba.pb.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements MediaPlayer.OnPreparedListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer.OnPreparedListener onPreparedListener;
        MediaController mediaController;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        MediaController mediaController2;
        MediaController mediaController3;
        MediaController mediaController4;
        MediaController mediaController5;
        MediaController mediaController6;
        MediaPlayer.OnPreparedListener onPreparedListener2;
        MediaPlayer mediaPlayer2;
        this.cWq.cVZ = 2;
        TextureVideoView textureVideoView = this.cWq;
        TextureVideoView textureVideoView2 = this.cWq;
        this.cWq.cWj = true;
        textureVideoView2.cWi = true;
        textureVideoView.cWh = true;
        onPreparedListener = this.cWq.cWd;
        if (onPreparedListener != null) {
            onPreparedListener2 = this.cWq.cWd;
            mediaPlayer2 = this.cWq.bxu;
            onPreparedListener2.onPrepared(mediaPlayer2);
        }
        mediaController = this.cWq.cWb;
        if (mediaController != null) {
            mediaController6 = this.cWq.cWb;
            mediaController6.setEnabled(true);
        }
        this.cWq.mVideoWidth = mediaPlayer.getVideoWidth();
        this.cWq.mVideoHeight = mediaPlayer.getVideoHeight();
        i = this.cWq.cWg;
        if (i != 0) {
            this.cWq.seekTo(i);
        }
        i2 = this.cWq.mVideoWidth;
        if (i2 != 0) {
            i4 = this.cWq.mVideoHeight;
            if (i4 != 0) {
                this.cWq.requestLayout();
                i5 = this.cWq.cWa;
                if (i5 == 3) {
                    this.cWq.start();
                    mediaController4 = this.cWq.cWb;
                    if (mediaController4 != null) {
                        mediaController5 = this.cWq.cWb;
                        mediaController5.show();
                        return;
                    }
                    return;
                } else if (!this.cWq.isPlaying()) {
                    if (i != 0 || this.cWq.getCurrentPosition() > 0) {
                        mediaController2 = this.cWq.cWb;
                        if (mediaController2 != null) {
                            mediaController3 = this.cWq.cWb;
                            mediaController3.show(0);
                            return;
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        i3 = this.cWq.cWa;
        if (i3 == 3) {
            this.cWq.start();
        }
    }
}
