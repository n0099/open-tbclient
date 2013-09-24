package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5;
        i iVar6;
        String str;
        i iVar7;
        i iVar8;
        switch (message.what) {
            case 0:
                iVar5 = a.d;
                if (iVar5 != null) {
                    iVar6 = a.d;
                    str = a.c;
                    iVar6.a(str, message.arg1);
                    break;
                }
                break;
            case 1:
                iVar3 = a.d;
                if (iVar3 != null) {
                    iVar4 = a.d;
                    iVar4.a(message.what, ak.a(R.string.voice_err_no_file));
                    break;
                }
                break;
            case 6:
                iVar = a.d;
                if (iVar != null) {
                    iVar2 = a.d;
                    iVar2.a(message.arg1);
                }
                return true;
            default:
                iVar7 = a.d;
                if (iVar7 != null) {
                    iVar8 = a.d;
                    iVar8.a(message.what, ak.a(R.string.voice_err_play));
                    break;
                }
                break;
        }
        a.f2017a = 0;
        a.d = null;
        return false;
    }
}
