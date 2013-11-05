package com.baidu.tieba.voice.service;

import android.media.MediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements MediaPlayer.OnCompletionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MediaService f2590a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaService mediaService) {
        this.f2590a = mediaService;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        g gVar;
        Voice voice;
        g gVar2;
        gVar = this.f2590a.mPlayer;
        if (gVar != null) {
            voice = this.f2590a.mVoice;
            if (voice != null) {
                gVar2 = this.f2590a.mPlayer;
                gVar2.b();
                this.f2590a.stopVoice(null);
            }
        }
    }
}
