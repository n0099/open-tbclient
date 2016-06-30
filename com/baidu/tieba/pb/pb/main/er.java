package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class er {
    public static Intent K(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean f(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar == null || sVar.bcw() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bcw = sVar.bcw();
        if (bcw.eXl) {
            int bbO = bcw.bbO();
            return bbO == 2 || bbO == 1 || bbO == 3;
        }
        return false;
    }
}
