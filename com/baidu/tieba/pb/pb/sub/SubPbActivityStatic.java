package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class SubPbActivityStatic {
    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
    }
}
