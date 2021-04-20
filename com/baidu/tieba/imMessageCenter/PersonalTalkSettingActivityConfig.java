package com.baidu.tieba.imMessageCenter;

import android.content.Context;
import com.alibaba.fastjson.asm.Label;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes4.dex */
public class PersonalTalkSettingActivityConfig extends IntentConfig {
    public PersonalTalkSettingActivityConfig(Context context, long j) {
        super(context);
        getIntent().addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        getIntent().putExtra("userId", j);
    }
}
