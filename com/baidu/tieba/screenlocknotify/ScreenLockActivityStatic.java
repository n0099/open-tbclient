package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ScreenLockActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            i.beX();
            new IntentConfig(TbadkApplication.getInst()).startService(ScreenLockNotifyService.class);
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.io().f("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }
}
