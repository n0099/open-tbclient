package com.baidu.tieba.person.data;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PersonListActivityConfig extends IntentConfig {
    public static final String FOLLOW = "follow";

    public PersonListActivityConfig(Context context, boolean z, String str, int i) {
        super(context);
        getIntent().putExtra(FOLLOW, z);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(IntentConfig.USER_SEX, i);
    }
}
