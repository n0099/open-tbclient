package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
/* loaded from: classes.dex */
public class AtListActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
    }
}
