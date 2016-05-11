package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
/* loaded from: classes.dex */
public class VcodeActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
    }
}
