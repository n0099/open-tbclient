package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class ek {
    public static Intent J(Context context, String str) {
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
        if (sVar == null || sVar.aUi() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i aUi = sVar.aUi();
        if (aUi.esx) {
            int aTB = aUi.aTB();
            return aTB == 2 || aTB == 1;
        }
        return false;
    }
}
