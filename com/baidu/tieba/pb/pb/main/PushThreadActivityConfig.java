package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.tbadk.core.data.PushStatusData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes5.dex */
public class PushThreadActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_PUSH_DATA = "push_data";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_USER_ID = "user_id";

    public PushThreadActivityConfig(Context context, int i2, long j, long j2, long j3, PushStatusData pushStatusData) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i2);
        getIntent().putExtra("forum_id", j);
        getIntent().putExtra("thread_id", j2);
        getIntent().putExtra("user_id", j3);
        getIntent().putExtra(KEY_PUSH_DATA, pushStatusData);
    }
}
