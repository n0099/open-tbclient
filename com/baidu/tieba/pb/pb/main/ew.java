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
        if (qVar == null || qVar.bjY() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bjY = qVar.bjY();
        if (bjY.fuN) {
            int bjt = bjY.bjt();
            return bjt == 2 || bjt == 1 || bjt == 3;
        }
        return false;
    }
}
