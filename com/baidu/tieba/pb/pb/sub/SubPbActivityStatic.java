package com.baidu.tieba.pb.pb.sub;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
/* loaded from: classes.dex */
public class SubPbActivityStatic {
    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(SubPbActivityConfig.class, NewSubPbActivity.class);
    }
}
