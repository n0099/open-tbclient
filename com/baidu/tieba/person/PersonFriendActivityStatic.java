package com.baidu.tieba.person;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.person.data.PersonFriendActivityConfig;
/* loaded from: classes.dex */
public class PersonFriendActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(PersonFriendActivityConfig.class, PersonFriendActivity.class);
    }
}
