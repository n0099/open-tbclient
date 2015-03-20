package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
/* loaded from: classes.dex */
public class AboutActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
    }
}
