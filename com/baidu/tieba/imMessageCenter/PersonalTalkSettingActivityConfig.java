package com.baidu.tieba.imMessageCenter;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class PersonalTalkSettingActivityConfig extends IntentConfig {
    public PersonalTalkSettingActivityConfig(Context context, long j) {
        super(context);
        getIntent().addFlags(268435456);
        getIntent().putExtra("userId", j);
    }
}
