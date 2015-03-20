package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.StrangerListActivityConfig;
/* loaded from: classes.dex */
public class StrangerListActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
    }
}
