package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
/* loaded from: classes.dex */
public class NewVcodeActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
    }
}
