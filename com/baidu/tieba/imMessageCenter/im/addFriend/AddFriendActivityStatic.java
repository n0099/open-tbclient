package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes.dex */
public class AddFriendActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
    }
}
