package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
/* loaded from: classes.dex */
public class InviteFriendListActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }
}
