package com.baidu.tieba.person.god;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class GodThreadListActivityConfig extends IntentConfig {
    public static final String KEY_AUTHOR = "key_author";
    public static final String KEY_PAGE = "key_page";
    public static final String KEY_UID = "key_uid";

    public GodThreadListActivityConfig(Context context, long j, int i, MetaData metaData) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", j);
        intent.putExtra(KEY_PAGE, i);
        intent.putExtra(KEY_AUTHOR, metaData);
    }
}
