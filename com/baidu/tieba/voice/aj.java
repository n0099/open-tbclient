package com.baidu.tieba.voice;

import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.voice.a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VoiceManager f2567a;

    private aj(VoiceManager voiceManager) {
        this.f2567a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(VoiceManager voiceManager, t tVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tieba.voice.a.c
    public void a(String str, String str2, int i, String str3) {
        VoiceManager.VoiceModel voiceModel;
        ae aeVar;
        ae aeVar2;
        VoiceManager.VoiceModel voiceModel2;
        ae aeVar3;
        VoiceManager.VoiceModel voiceModel3;
        VoiceManager.VoiceModel voiceModel4;
        VoiceManager.VoiceModel voiceModel5;
        voiceModel = this.f2567a.v;
        if (voiceModel != null) {
            aeVar = this.f2567a.y;
            if (aeVar != null) {
                if (!com.baidu.adp.lib.h.h.a(str) && !com.baidu.adp.lib.h.h.a(str2)) {
                    voiceModel3 = this.f2567a.v;
                    if (voiceModel3.voiceId.equals(str2)) {
                        voiceModel4 = this.f2567a.v;
                        if (VoiceManager.b(voiceModel4.voice_status.intValue())) {
                            VoiceManager voiceManager = this.f2567a;
                            voiceModel5 = this.f2567a.v;
                            voiceManager.a(voiceModel5, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.h.d.b("VoiceManager", "onLoaded", "error while download file not exist:");
                if (i <= 0 || com.baidu.adp.lib.h.h.a(str3) || (i != 2 && i != 4 && i != 3 && i != 7)) {
                    aeVar2 = this.f2567a.y;
                    aeVar2.b(5, al.a(R.string.voice_err_load_fail));
                } else {
                    aeVar3 = this.f2567a.y;
                    aeVar3.b(5, str3);
                }
                VoiceManager voiceManager2 = this.f2567a;
                voiceModel2 = this.f2567a.v;
                voiceManager2.c(voiceModel2);
            }
        }
    }
}
