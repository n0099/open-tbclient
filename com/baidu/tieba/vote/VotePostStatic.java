package com.baidu.tieba.vote;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tieba.write.vote.WriteVoteActivity;
/* loaded from: classes3.dex */
public class VotePostStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(WriteVoteActivityConfig.class, WriteVoteActivity.class);
    }
}
