package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ez {
    public static Intent ae(Context context, String str) {
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
        if (postData == null || postData.bhL() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bhL = postData.bhL();
        if (bhL.ftO) {
            int bhh = bhL.bhh();
            return bhh == 2 || bhh == 1 || bhh == 3;
        }
        return false;
    }
}
