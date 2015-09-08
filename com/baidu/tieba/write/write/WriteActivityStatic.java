package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
/* loaded from: classes.dex */
public class WriteActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        com.baidu.tieba.tbadkCore.location.d.auW();
    }
}
