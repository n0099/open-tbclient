package com.baidu.tieba.screenlocknotify;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
import d.a.n0.v2.a;
/* loaded from: classes5.dex */
public class ScreenLockActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            a.j();
            TbadkCoreApplication.getInst().getApp().startService(new Intent(TbadkCoreApplication.getInst().getApp(), ScreenLockNotifyService.class));
        } catch (Exception e2) {
            BdLog.e(e2);
            d.a.c.h.h.a b2 = d.a.c.h.h.a.b();
            b2.r("plugin_load", "screenlock_failed", null, e2.getMessage() + "---" + e2.getClass().getName());
        }
    }
}
