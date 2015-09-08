package com.baidu.tieba.screenlocknotify;

import android.content.Intent;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ScreenLockActivityConfig;
/* loaded from: classes.dex */
public class ScreenLockActivityStatic {
    static {
        TbadkApplication.getInst().RegisterIntent(ScreenLockActivityConfig.class, ScreenLockActivity.class);
        try {
            TbadkApplication.getInst().getApp().getClassLoader().loadClass(ScreenLockNotifyService.class.getName());
            f.aoj();
            TbadkApplication.getInst().getApp().startService(new Intent(TbadkApplication.getInst().getApp(), ScreenLockNotifyService.class));
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lE().e("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }
}
