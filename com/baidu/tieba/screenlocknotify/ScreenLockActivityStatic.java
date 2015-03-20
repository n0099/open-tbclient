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
            f.afN();
            TbadkApplication.getInst().getApp().startService(new Intent(TbadkApplication.getInst().getApp(), ScreenLockNotifyService.class));
            BdLog.i("-------------------启动ScreenlockManager,service!");
        } catch (Exception e) {
            BdLog.e(e);
            com.baidu.adp.plugin.b.a.lh().d("plugin_load", "screenlock_failed", null, String.valueOf(e.getMessage()) + "---" + e.getClass().getName());
        }
    }
}
