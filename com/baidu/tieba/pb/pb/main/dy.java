package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class dy {
    public static Intent R(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean g(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar == null || rVar.aMF() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h aMF = rVar.aMF();
        if (aMF.dWF) {
            int aLZ = aMF.aLZ();
            return aLZ == 2 || aLZ == 1;
        }
        return false;
    }
}
