package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class dj {
    public static Intent L(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean e(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar == null || rVar.aFA() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h aFA = rVar.aFA();
        if (aFA.dGJ) {
            int aET = aFA.aET();
            return aET == 2 || aET == 1;
        }
        return false;
    }
}
