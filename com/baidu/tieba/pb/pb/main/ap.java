package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.Random;
/* loaded from: classes4.dex */
public class ap {
    private static final int[] hvM = {d.j.i_have_a_bold_idea, d.j.give_you_a_god_comment_chance, d.j.wait_for_you_so_long_time_finally_you_come, d.j.hot_or_not_hot_up_to_you, d.j.let_us_talk_dont_shy};

    public static Intent aI(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        intent.putExtra("key_start_from", 5);
        return intent;
    }

    public static boolean m(PostData postData) {
        if (postData == null || postData.ceA() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i ceA = postData.ceA();
        if (ceA.iFR) {
            int cdY = ceA.cdY();
            return cdY == 2 || cdY == 1 || cdY == 3;
        }
        return false;
    }

    public static int bMk() {
        return hvM[new Random().nextInt(hvM.length)];
    }
}
