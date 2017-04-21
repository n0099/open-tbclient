package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ex {
    public static Intent ah(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean g(PostData postData) {
        if (postData == null || postData.bjx() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bjx = postData.bjx();
        if (bjx.fxO) {
            int biT = bjx.biT();
            return biT == 2 || biT == 1 || biT == 3;
        }
        return false;
    }
}
