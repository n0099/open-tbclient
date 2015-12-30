package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
/* loaded from: classes.dex */
public class SingleMentionActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SingleMentionActivityConfig.class, bd.class);
        SingleMentionActivityConfig.setMentionActivityClass(bd.class);
    }
}
