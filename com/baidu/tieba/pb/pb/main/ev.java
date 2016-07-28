package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class ev {
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

    public static boolean g(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar == null || sVar.bfL() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i bfL = sVar.bfL();
        if (bfL.fkn) {
            int bfd = bfL.bfd();
            return bfd == 2 || bfd == 1 || bfd == 3;
        }
        return false;
    }
}
