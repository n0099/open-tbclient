package com.baidu.tieba.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaService f2642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.f2642a = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        g gVar;
        Voice voice;
        g gVar2;
        gVar = this.f2642a.mPlayer;
        if (gVar != null) {
            voice = this.f2642a.mVoice;
            if (voice != null) {
                gVar2 = this.f2642a.mPlayer;
                gVar2.b();
                this.f2642a.stopVoice(null);
            }
        }
    }
}
