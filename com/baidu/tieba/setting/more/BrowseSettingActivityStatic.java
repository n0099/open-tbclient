package com.baidu.tieba.setting.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BrowseSettingActivityConfig;
/* loaded from: classes.dex */
public class BrowseSettingActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(BrowseSettingActivityConfig.class, BrowseSettingActivity.class);
    }
}
