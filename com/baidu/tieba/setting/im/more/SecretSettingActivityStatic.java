package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SecretSettingActivityConfig;
/* loaded from: classes.dex */
public class SecretSettingActivityStatic {
    static {
        TbadkCoreApplication.m411getInst().RegisterIntent(SecretSettingActivityConfig.class, SecretSettingActivity.class);
    }
}
