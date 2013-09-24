package com.baidu.tieba.voice;

import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.voice.a.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ r f2027a;

    private ah(r rVar) {
        this.f2027a = rVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(r rVar, ah ahVar) {
        this(rVar);
    }

    @Override // com.baidu.tieba.voice.a.c
    public void a(String str, String str2, int i, String str3) {
        ai aiVar;
        ac acVar;
        ac acVar2;
        ai aiVar2;
        ac acVar3;
        ai aiVar3;
        ai aiVar4;
        ai aiVar5;
        aiVar = this.f2027a.u;
        if (aiVar != null) {
            acVar = this.f2027a.x;
            if (acVar != null) {
                if (!com.baidu.adp.lib.f.h.a(str) && !com.baidu.adp.lib.f.h.a(str2)) {
                    aiVar3 = this.f2027a.u;
                    if (aiVar3.b.equals(str2)) {
                        aiVar4 = this.f2027a.u;
                        if (r.b(aiVar4.h.intValue())) {
                            r rVar = this.f2027a;
                            aiVar5 = this.f2027a.u;
                            rVar.a(aiVar5, str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.d.b("VoiceManager", "onLoaded", "error while download file not exist:");
                if (i == 3 || i == 2) {
                    acVar2 = this.f2027a.x;
                    acVar2.a(5, str3);
                } else {
                    av.b("VoiceManager", "VoiceLoaderCallback::voiceLoaded", "error code:" + i + " error msg:" + str3);
                    acVar3 = this.f2027a.x;
                    acVar3.a(5, ak.a(R.string.voice_err_no_file));
                }
                r rVar2 = this.f2027a;
                aiVar2 = this.f2027a.u;
                rVar2.c(aiVar2);
            }
        }
    }
}
