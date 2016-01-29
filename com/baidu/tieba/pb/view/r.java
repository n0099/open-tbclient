package com.baidu.tieba.pb.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements MediaPlayer.OnErrorListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        MediaController mediaController;
        MediaPlayer.OnErrorListener onErrorListener;
        MediaPlayer.OnErrorListener onErrorListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.cWq.cVZ = -1;
        this.cWq.cWa = -1;
        mediaController = this.cWq.cWb;
        if (mediaController != null) {
            mediaController2 = this.cWq.cWb;
            mediaController2.hide();
        }
        onErrorListener = this.cWq.cWf;
        if (onErrorListener != null) {
            onErrorListener2 = this.cWq.cWf;
            mediaPlayer2 = this.cWq.bxu;
            if (onErrorListener2.onError(mediaPlayer2, i, i2)) {
            }
        }
        return true;
    }
}
