package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AppsActivityConfig;
/* loaded from: classes.dex */
public class AppsActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
    }
}
