package com.baidu.tieba.voice;

import com.baidu.tieba.util.bg;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tieba.voice.a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2603a;

    private ai(VoiceManager voiceManager) {
        this.f2603a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(VoiceManager voiceManager, s sVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tieba.voice.a.c
    public void a(String str, String str2, int i, String str3) {
        VoiceManager.VoiceModel voiceModel;
        ad adVar;
        ad adVar2;
        VoiceManager.VoiceModel voiceModel2;
        ad adVar3;
        VoiceManager.VoiceModel voiceModel3;
        VoiceManager.VoiceModel voiceModel4;
        VoiceManager.VoiceModel voiceModel5;
        voiceModel = this.f2603a.v;
        if (voiceModel != null) {
            adVar = this.f2603a.y;
            if (adVar != null) {
                if (!com.baidu.adp.lib.h.h.a(str) && !com.baidu.adp.lib.h.h.a(str2)) {
                    voiceModel3 = this.f2603a.v;
                    if (voiceModel3.voiceId.equals(str2)) {
                        voiceModel4 = this.f2603a.v;
                        if (VoiceManager.b(voiceModel4.voice_status.intValue())) {
                            VoiceManager voiceManager = this.f2603a;
                            voiceModel5 = this.f2603a.v;
                            voiceManager.a(voiceModel5, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                bg.a(4, "VoiceManager", "VoiceLoaderCallback::voiceLoaded", "error code:" + i + " error msg:" + str3);
                if (i <= 0 || com.baidu.adp.lib.h.h.a(str3) || (i != 2 && i != 4 && i != 3 && i != 7)) {
                    adVar2 = this.f2603a.y;
                    adVar2.b(5, ak.a(R.string.voice_err_load_fail));
                } else {
                    adVar3 = this.f2603a.y;
                    adVar3.b(5, str3);
                }
                VoiceManager voiceManager2 = this.f2603a;
                voiceModel2 = this.f2603a.v;
                voiceManager2.c(voiceModel2);
            }
        }
    }
}
