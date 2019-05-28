package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.Random;
/* loaded from: classes4.dex */
public class ap {
    private static final int[] hMY = {R.string.i_have_a_bold_idea, R.string.give_you_a_god_comment_chance, R.string.wait_for_you_so_long_time_finally_you_come, R.string.hot_or_not_hot_up_to_you, R.string.let_us_talk_dont_shy};

    public static Intent av(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra(DealIntentService.KEY_CLASS, 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        intent.putExtra("key_start_from", 5);
        return intent;
    }

    public static boolean m(PostData postData) {
        if (postData == null || postData.cmF() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.i cmF = postData.cmF();
        if (cmF.iYj) {
            int cmd = cmF.cmd();
            return cmd == 2 || cmd == 1 || cmd == 3;
        }
        return false;
    }

    public static int bUa() {
        return hMY[new Random().nextInt(hMY.length)];
    }
}
