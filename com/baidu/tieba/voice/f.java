package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        q qVar6;
        q qVar7;
        q qVar8;
        q qVar9;
        q qVar10;
        q qVar11;
        q qVar12;
        q qVar13;
        String str;
        q qVar14;
        q qVar15;
        switch (message.what) {
            case 0:
                qVar12 = e.d;
                if (qVar12 != null) {
                    qVar13 = e.d;
                    str = e.c;
                    qVar13.a(str, message.arg1);
                    e.d = null;
                    break;
                }
                break;
            case 1:
            case 3:
                qVar = e.d;
                if (qVar != null) {
                    if (com.baidu.adp.lib.f.b.b()) {
                        qVar3 = e.d;
                        qVar3.a(message.what, ak.a(R.string.voice_err_create_file_fail));
                    } else {
                        qVar2 = e.d;
                        qVar2.a(message.what, ak.a(R.string.voice_err_sdcard_nospace));
                    }
                    e.d = null;
                    break;
                }
                break;
            case 2:
            case 5:
            case 6:
            default:
                qVar14 = e.d;
                if (qVar14 != null) {
                    qVar15 = e.d;
                    qVar15.a(message.what, ak.a(R.string.voice_err_other));
                    e.d = null;
                    break;
                }
                break;
            case 4:
                qVar10 = e.d;
                if (qVar10 != null) {
                    qVar11 = e.d;
                    qVar11.a(message.arg1);
                    break;
                }
                break;
            case 7:
                qVar6 = e.d;
                if (qVar6 != null) {
                    qVar7 = e.d;
                    qVar7.a(message.what, ak.a(R.string.voice_record_timeout_tip));
                    e.d = null;
                    break;
                }
                break;
            case 8:
                qVar4 = e.d;
                if (qVar4 != null) {
                    qVar5 = e.d;
                    qVar5.a(message.what, ak.a(R.string.voice_record_short_tip));
                    e.d = null;
                    com.baidu.adp.lib.f.d.b("----record too short......");
                    break;
                }
                break;
            case 9:
                qVar8 = e.d;
                if (qVar8 != null) {
                    qVar9 = e.d;
                    qVar9.b(message.arg1);
                    break;
                }
                break;
        }
        e.f2032a = 0;
        return false;
    }
}
