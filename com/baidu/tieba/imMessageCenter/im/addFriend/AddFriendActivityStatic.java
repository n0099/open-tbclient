package com.baidu.tieba.imMessageCenter.im.addFriend;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
/* loaded from: classes4.dex */
public class AddFriendActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AddFriendActivityConfig.class, AddFriendActivity.class);
    }
}
