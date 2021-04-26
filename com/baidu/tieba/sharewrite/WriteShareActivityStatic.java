package com.baidu.tieba.sharewrite;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
/* loaded from: classes5.dex */
public class WriteShareActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(WriteShareActivityConfig.class, WriteShareActivity.class);
    }
}
