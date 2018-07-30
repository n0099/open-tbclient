package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ScreenLockActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            a.boJ();
            new IntentConfig(TbadkApplication.getInst()).startService(ScreenLockNotifyService.class);
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lA().g("plugin_load", "screenlock_failed", null, e.getMessage() + "---" + e.getClass().getName());
        }
    }
}
