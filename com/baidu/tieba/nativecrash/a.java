package com.baidu.tieba.nativecrash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.nativecrash.BdNativeCrash;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private static String juy = "native_crash_log.log";
    private static List<String> juz = new ArrayList();
    private static BroadcastReceiver Qz = new BroadcastReceiver() { // from class: com.baidu.tieba.nativecrash.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(stringExtra) && "com.baidu.adp.plugin.installed".equals(intent.getAction())) {
                    b.aTX().putInt("native_crash_count_" + stringExtra, 0);
                }
            }
        }
    };
    private static BdNativeCrash.a juA = new BdNativeCrash.a() { // from class: com.baidu.tieba.nativecrash.a.2
    };

    public static void czy() {
        if (BdNativeCrash.jux) {
            BdNativeCrash.czx().eO(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.czx().a(juA);
            czz();
        }
    }

    private static void czz() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.setPriority(-1000);
            applicationContext.registerReceiver(Qz, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
