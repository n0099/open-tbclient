package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        j jVar8;
        String unused;
        switch (message.what) {
            case 0:
                jVar5 = a.d;
                if (jVar5 != null) {
                    jVar6 = a.d;
                    unused = a.c;
                    jVar6.a(message.arg1);
                    break;
                }
                break;
            case 1:
                jVar3 = a.d;
                if (jVar3 != null) {
                    jVar4 = a.d;
                    jVar4.a(message.what, ak.a(R.string.voice_err_no_file));
                    break;
                }
                break;
            case 6:
                jVar = a.d;
                if (jVar != null) {
                    jVar2 = a.d;
                    jVar2.b(message.arg1);
                }
                return true;
            default:
                jVar7 = a.d;
                if (jVar7 != null) {
                    jVar8 = a.d;
                    jVar8.a(message.what, ak.a(R.string.voice_err_play));
                    break;
                }
                break;
        }
        a.a = 0;
        a.d = null;
        return false;
    }
}
