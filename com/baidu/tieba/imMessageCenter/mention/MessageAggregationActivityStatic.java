package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.MessageAggregationActivityConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMessageActivityConfig;
/* loaded from: classes2.dex */
public class MessageAggregationActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(MessageAggregationActivityConfig.class, ad.class);
        MessageAggregationActivityConfig.setMentionActivityClass(ad.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(MessageCenterActivityConfig.class, MessageCenterActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(ReplyMessageActivityConfig.class, ReplyMessageActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(AtMessageActivityConfig.class, AtMessageActivity.class);
    }
}
