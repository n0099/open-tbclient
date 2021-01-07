package com.baidu.tieba.memberCenter.tail.data;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes9.dex */
public class TailEditActivityConfig extends IntentConfig {
    public static final String IS_NO_TAIL = "is_no_tail";
    public static final String TAIL_COLOR = "tail_color";
    public static final String TAIL_CONTENT = "tail_content";
    public static final String TAIL_ID = "tail_id";

    public TailEditActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IS_NO_TAIL, z);
    }

    public TailEditActivityConfig(Context context, int i, String str, String str2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra(TAIL_CONTENT, str);
        intent.putExtra(TAIL_ID, i);
        intent.putExtra(TAIL_COLOR, str2);
    }
}
