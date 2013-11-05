package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class g implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        s sVar;
        s sVar2;
        s sVar3;
        s sVar4;
        s sVar5;
        s sVar6;
        s sVar7;
        s sVar8;
        s sVar9;
        s sVar10;
        s sVar11;
        s sVar12;
        s sVar13;
        s sVar14;
        s sVar15;
        String str;
        s sVar16;
        s sVar17;
        switch (message.what) {
            case 0:
                sVar14 = f.d;
                if (sVar14 != null) {
                    sVar15 = f.d;
                    str = f.c;
                    sVar15.a(str, message.arg1);
                    s unused = f.d = null;
                    break;
                }
                break;
            case 1:
            case 3:
                sVar3 = f.d;
                if (sVar3 != null) {
                    if (com.baidu.adp.lib.h.b.b()) {
                        sVar5 = f.d;
                        sVar5.a(message.what, al.a(R.string.voice_err_create_file_fail));
                    } else {
                        sVar4 = f.d;
                        sVar4.a(message.what, al.a(R.string.voice_err_sdcard_nospace));
                    }
                    s unused2 = f.d = null;
                    break;
                }
                break;
            case 4:
                sVar12 = f.d;
                if (sVar12 != null) {
                    sVar13 = f.d;
                    sVar13.a(message.arg1);
                    break;
                }
                break;
            case 7:
                sVar8 = f.d;
                if (sVar8 != null) {
                    sVar9 = f.d;
                    sVar9.a(message.what, al.a(R.string.voice_record_timeout_tip));
                    s unused3 = f.d = null;
                    break;
                }
                break;
            case 8:
                sVar6 = f.d;
                if (sVar6 != null) {
                    sVar7 = f.d;
                    sVar7.a(message.what, al.a(R.string.voice_record_short_tip));
                    s unused4 = f.d = null;
                    com.baidu.adp.lib.h.d.c("----record too short......");
                    break;
                }
                break;
            case 9:
                sVar10 = f.d;
                if (sVar10 != null) {
                    sVar11 = f.d;
                    sVar11.b(message.arg1);
                    break;
                }
                break;
            case 100:
                sVar = f.d;
                if (sVar != null) {
                    sVar2 = f.d;
                    sVar2.a();
                    break;
                }
                break;
            default:
                sVar16 = f.d;
                if (sVar16 != null) {
                    sVar17 = f.d;
                    sVar17.a(message.what, al.a(R.string.voice_err_other));
                    s unused5 = f.d = null;
                    break;
                }
                break;
        }
        int unused6 = f.f2572a = 0;
        return false;
    }
}
