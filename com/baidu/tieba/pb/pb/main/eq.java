package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class eq {
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
        if (qVar == null || qVar.bgi() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bgi = qVar.bgi();
        if (bgi.fge) {
            int bfE = bgi.bfE();
            return bfE == 2 || bfE == 1 || bfE == 3;
        }
        return false;
    }
}
