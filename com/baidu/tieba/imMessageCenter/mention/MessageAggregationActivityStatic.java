package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.MessageAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMessageActivityConfig;
/* loaded from: classes2.dex */
public class MessageAggregationActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(MessageAggregationActivityConfig.class, g.class);
        MessageAggregationActivityConfig.setMentionActivityClass(g.class);
        TbadkCoreApplication.getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ReplyMessageActivityConfig.class, ReplyMessageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtMessageActivityConfig.class, AtMessageActivity.class);
    }
}
