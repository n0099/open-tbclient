package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class et {
    public static Intent I(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean g(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar == null || sVar.aTC() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i aTC = sVar.aTC();
        if (aTC.epn) {
            int aSU = aTC.aSU();
            return aSU == 2 || aSU == 1;
        }
        return false;
    }
}
