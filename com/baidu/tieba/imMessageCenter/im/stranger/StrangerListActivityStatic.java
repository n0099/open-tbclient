package com.baidu.tieba.imMessageCenter.im.stranger;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
/* loaded from: classes4.dex */
public class StrangerListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(StrangerListActivityConfig.class, StrangerListActivity.class);
    }
}
