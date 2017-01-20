package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class ey {
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

    public static boolean g(com.baidu.tieba.tbadkCore.data.p pVar) {
        if (pVar == null || pVar.bhY() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bhY = pVar.bhY();
        if (bhY.fpt) {
            int bhu = bhY.bhu();
            return bhu == 2 || bhu == 1 || bhu == 3;
        }
        return false;
    }
}
