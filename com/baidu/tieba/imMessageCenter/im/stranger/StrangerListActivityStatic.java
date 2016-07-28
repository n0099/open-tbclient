package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
/* loaded from: classes.dex */
public class StrangerListActivityStatic {
    static {
        TbadkCoreApplication.m10getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
    }
}
