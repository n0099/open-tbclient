package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
/* loaded from: classes.dex */
public class PersonalTalkSettingActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
    }
}
