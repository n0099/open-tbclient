package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class fl {
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

    public static boolean h(PostData postData) {
        if (postData == null || postData.bgU() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h bgU = postData.bgU();
        if (bgU.ftS) {
            int bgq = bgU.bgq();
            return bgq == 2 || bgq == 1 || bgq == 3;
        }
        return false;
    }
}
