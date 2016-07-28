package com.baidu.tieba.write.vcode.oldVcode;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
/* loaded from: classes.dex */
public class VcodeActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
    }
}
