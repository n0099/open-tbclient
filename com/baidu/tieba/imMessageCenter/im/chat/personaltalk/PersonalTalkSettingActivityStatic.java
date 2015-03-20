package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalTalkSettingActivityConfig;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
    }
}
