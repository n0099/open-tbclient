package com.baidu.tieba.imMessageCenter.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalMsgImageActivityConfig;
/* loaded from: classes.dex */
public class PersonalMsgImageActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonalMsgImageActivityConfig.class, PersonalMsgImageActivity.class);
    }
}
