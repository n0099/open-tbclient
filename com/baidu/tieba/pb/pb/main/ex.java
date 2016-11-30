package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class ex {
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

    public static boolean h(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar == null || qVar.bmt() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bmt = qVar.bmt();
        if (bmt.fBZ) {
            int blP = bmt.blP();
            return blP == 2 || blP == 1 || blP == 3;
        }
        return false;
    }
}
