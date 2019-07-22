package com.baidu.tieba.nativecrash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.nativecrash.BdNativeCrash;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private static String hzp = "native_crash_log.log";
    private static List<String> hzq = new ArrayList();
    private static BroadcastReceiver HZ = new BroadcastReceiver() { // from class: com.baidu.tieba.nativecrash.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(Constants.PACKAGE_NAME);
                if (!TextUtils.isEmpty(stringExtra) && "com.baidu.adp.plugin.installed".equals(intent.getAction())) {
                    b.ahO().putInt("native_crash_count_" + stringExtra, 0);
                }
            }
        }
    };
    private static BdNativeCrash.a hzr = new BdNativeCrash.a() { // from class: com.baidu.tieba.nativecrash.a.2
    };

    public static void bPX() {
        if (BdNativeCrash.hzo) {
            BdNativeCrash.bPW().dI(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.bPW().a(hzr);
            bPY();
        }
    }

    private static void bPY() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.setPriority(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
            applicationContext.registerReceiver(HZ, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
