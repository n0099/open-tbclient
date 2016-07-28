package com.baidu.tieba.write.vcode.newVcode;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
/* loaded from: classes.dex */
public class NewVcodeActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
    }
}
