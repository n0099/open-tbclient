package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class ew {
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

    public static boolean g(com.baidu.tieba.tbadkCore.data.q qVar) {
        if (qVar == null || qVar.bjm() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bjm = qVar.bjm();
        if (bjm.fsh) {
            int biI = bjm.biI();
            return biI == 2 || biI == 1 || biI == 3;
        }
        return false;
    }
}
