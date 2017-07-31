package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
/* loaded from: classes2.dex */
public class InviteFriendListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }
}
