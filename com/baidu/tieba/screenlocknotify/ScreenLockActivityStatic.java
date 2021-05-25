package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.n0.v2.a;
/* loaded from: classes5.dex */
public class ScreenLockActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            a.j();
            new IntentConfig(TbadkApplication.getInst()).startService(ScreenLockNotifyService.class);
        } catch (Exception e2) {
            BdLog.e(e2);
            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
            b2.r("plugin_load", "screenlock_failed", null, e2.getMessage() + "---" + e2.getClass().getName());
        }
    }
}
