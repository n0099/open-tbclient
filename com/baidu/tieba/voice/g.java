package com.baidu.tieba.voice;

import android.os.Handler;
import android.os.Message;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class g implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        r rVar5;
        r rVar6;
        r rVar7;
        r rVar8;
        r rVar9;
        r rVar10;
        r rVar11;
        r rVar12;
        r rVar13;
        r rVar14;
        r rVar15;
        r rVar16;
        r rVar17;
        r rVar18;
        r rVar19;
        r rVar20;
        r rVar21;
        String str;
        r rVar22;
        r rVar23;
        switch (message.what) {
            case 0:
                rVar20 = f.d;
                if (rVar20 != null) {
                    rVar21 = f.d;
                    str = f.c;
                    rVar21.a(str, message.arg1);
                    r unused = f.d = null;
                    break;
                }
                break;
            case 1:
            case 3:
                rVar9 = f.d;
                if (rVar9 != null) {
                    if (com.baidu.adp.lib.h.b.b()) {
                        rVar11 = f.d;
                        rVar11.a(message.what, ak.a(R.string.voice_err_create_file_fail));
                    } else {
                        rVar10 = f.d;
                        rVar10.a(message.what, ak.a(R.string.voice_err_sdcard_nospace));
                    }
                    r unused2 = f.d = null;
                    break;
                }
                break;
            case 2:
                rVar3 = f.d;
                if (rVar3 != null) {
                    rVar4 = f.d;
                    rVar4.a(message.what, ak.a(R.string.voice_err_file_fail));
                    r unused3 = f.d = null;
                    break;
                }
                break;
            case 4:
                rVar18 = f.d;
                if (rVar18 != null) {
                    rVar19 = f.d;
                    rVar19.a(message.arg1);
                    break;
                }
                break;
            case 5:
                rVar5 = f.d;
                if (rVar5 != null) {
                    rVar6 = f.d;
                    rVar6.a(message.what, ak.a(R.string.voice_err_load_lib_fail));
                    r unused4 = f.d = null;
                    break;
                }
                break;
            case 6:
                rVar = f.d;
                if (rVar != null) {
                    rVar2 = f.d;
                    rVar2.a(message.what, ak.a(R.string.voice_err_init_fail));
                    r unused5 = f.d = null;
                    break;
                }
                break;
            case 7:
                rVar14 = f.d;
                if (rVar14 != null) {
                    rVar15 = f.d;
                    rVar15.a(message.what, ak.a(R.string.voice_record_timeout_tip));
                    r unused6 = f.d = null;
                    break;
                }
                break;
            case 8:
                rVar12 = f.d;
                if (rVar12 != null) {
                    rVar13 = f.d;
                    rVar13.a(message.what, ak.a(R.string.voice_record_short_tip));
                    r unused7 = f.d = null;
                    com.baidu.adp.lib.h.d.c("----record too short......");
                    break;
                }
                break;
            case 9:
                rVar16 = f.d;
                if (rVar16 != null) {
                    rVar17 = f.d;
                    rVar17.b(message.arg1);
                    break;
                }
                break;
            case 100:
                rVar7 = f.d;
                if (rVar7 != null) {
                    rVar8 = f.d;
                    rVar8.a();
                    break;
                }
                break;
            default:
                rVar22 = f.d;
                if (rVar22 != null) {
                    rVar23 = f.d;
                    rVar23.a(message.what, ak.a(R.string.voice_err_other));
                    r unused8 = f.d = null;
                    break;
                }
                break;
        }
        int unused9 = f.f2608a = 0;
        return false;
    }
}
