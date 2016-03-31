package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PushThreadActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_THREAD_ID = "thread_id";
    public static final String KEY_USER_ID = "user_id";

    public PushThreadActivityConfig(Context context, int i, long j, long j2, long j3) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
        getIntent().putExtra("forum_id", j);
        getIntent().putExtra("thread_id", j2);
        getIntent().putExtra("user_id", j3);
    }
}
