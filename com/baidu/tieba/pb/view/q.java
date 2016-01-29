package com.baidu.tieba.pb.view;

import android.media.MediaPlayer;
import android.widget.MediaController;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements MediaPlayer.OnCompletionListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaController mediaController;
        MediaPlayer.OnCompletionListener onCompletionListener;
        MediaPlayer.OnCompletionListener onCompletionListener2;
        MediaPlayer mediaPlayer2;
        MediaController mediaController2;
        this.cWq.cVZ = 5;
        this.cWq.cWa = 5;
        mediaController = this.cWq.cWb;
        if (mediaController != null) {
            mediaController2 = this.cWq.cWb;
            mediaController2.hide();
        }
        onCompletionListener = this.cWq.cWc;
        if (onCompletionListener != null) {
            onCompletionListener2 = this.cWq.cWc;
            mediaPlayer2 = this.cWq.bxu;
            onCompletionListener2.onCompletion(mediaPlayer2);
        }
    }
}
