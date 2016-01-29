package com.baidu.tieba.pb.view;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements MediaPlayer.OnBufferingUpdateListener {
    final /* synthetic */ TextureVideoView cWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TextureVideoView textureVideoView) {
        this.cWq = textureVideoView;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.cWq.cWe = i;
    }
}
