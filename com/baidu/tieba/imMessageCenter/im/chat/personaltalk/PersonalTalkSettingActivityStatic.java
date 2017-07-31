package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.PersonalTalkSettingActivityConfig;
/* loaded from: classes2.dex */
public class PersonalTalkSettingActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonalTalkSettingActivityConfig.class, PersonalTalkSettingActivity.class);
    }
}
