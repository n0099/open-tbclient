package com.baidu.tieba.voice;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        VoiceManager voiceManager3;
        voiceManager = this.a.a;
        ae aeVar = voiceManager.a;
        voiceManager2 = this.a.a;
        aeVar.a(4, voiceManager2.d.getString(R.string.voice_error_file_md5));
        voiceManager3 = this.a.a;
        voiceManager3.H = 1;
    }
}
