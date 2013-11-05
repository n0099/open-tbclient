package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PlayVoiceBnt f2576a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PlayVoiceBnt playVoiceBnt) {
        this.f2576a = playVoiceBnt;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.VoiceModel voiceModel;
        PlayVoiceBnt playVoiceBnt = this.f2576a;
        voiceModel = this.f2576a.b;
        playVoiceBnt.a(voiceModel);
    }
}
