package com.baidu.tieba.person.data;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class PersonFriendActivityConfig extends IntentConfig {
    public static final String KEY_CURRENT_TAB = "key_current_tab";
    public static final String KEY_SEX = "key_sex";
    public static final String KEY_UID = "key_uid";

    public PersonFriendActivityConfig(Context context, String str, int i2) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
    }

    public PersonFriendActivityConfig(Context context, String str, int i2, int i3) {
        super(context);
        Intent intent = getIntent();
        intent.putExtra("key_uid", str);
        intent.putExtra("key_sex", i2);
        intent.putExtra("key_current_tab", i3);
    }
}
