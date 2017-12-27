package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.data.LotteryUserChanceInfo;
/* loaded from: classes2.dex */
public class GetLotteryChanceActivityConfig extends IntentConfig {
    public static final int ACTION_CODE_NONE = 0;
    public static final int ACTION_CODE_REPLY = 2;
    public static final int ACTION_CODE_SHARE = 1;
    public static final String AWARD_ACT_ID = "act_id";
    public static final String HAS_SIGN = "is_sign";
    public static final String KEY_ACTION = "key_action";
    public static final String LOTTERY_USER_CHANCE = "lottery_user_chance";

    public GetLotteryChanceActivityConfig(Context context, LotteryUserChanceInfo lotteryUserChanceInfo, int i, String str, String str2, String str3, long j, boolean z) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra(LOTTERY_USER_CHANCE, lotteryUserChanceInfo);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("forum_id", str2);
        getIntent().putExtra("thread_id", str3);
        getIntent().putExtra(AWARD_ACT_ID, j);
        getIntent().putExtra(HAS_SIGN, z);
    }
}
