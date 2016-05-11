package com.baidu.tieba.pb.account.forbid;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
/* loaded from: classes.dex */
public class ForbidActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(ForbidActivityConfig.class, ForbidActivity.class);
    }
}
