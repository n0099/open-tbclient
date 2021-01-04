package com.baidu.tieba.imMessageCenter;

import android.content.Context;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class PersonalTalkSettingActivityConfig extends IntentConfig {
    public PersonalTalkSettingActivityConfig(Context context, long j) {
        super(context);
        getIntent().addFlags(268435456);
        getIntent().putExtra(TbEnum.SystemMessage.KEY_USER_ID, j);
    }
}
