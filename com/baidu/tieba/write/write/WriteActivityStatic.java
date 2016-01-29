package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tieba.write.video.WriteVideoActivity;
import com.baidu.tieba.write.vote.WriteVoteActivity;
/* loaded from: classes.dex */
public class WriteActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(WriteVoteActivityConfig.class, WriteVoteActivity.class);
        TbadkCoreApplication.m411getInst().RegisterIntent(WriteVideoActivityConfig.class, WriteVideoActivity.class);
        com.baidu.tieba.tbadkCore.location.d.aNh();
    }
}
