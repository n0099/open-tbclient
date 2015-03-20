package com.baidu.tieba.write.selectpoi;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
/* loaded from: classes.dex */
public class SelectLocationActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SelectLocationActivityConfig.class, SelectLocationActivity.class);
    }
}
