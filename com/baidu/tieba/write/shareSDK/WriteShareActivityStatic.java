package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
/* loaded from: classes.dex */
public class WriteShareActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }
}
