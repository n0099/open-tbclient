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
/* loaded from: classes22.dex */
public class a {
    private static String loY = "native_crash_log.log";
    private static List<String> loZ = new ArrayList();
    private static BroadcastReceiver Tl = new BroadcastReceiver() { // from class: com.baidu.tieba.nativecrash.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("package_name");
                if (!TextUtils.isEmpty(stringExtra) && "com.baidu.adp.plugin.installed".equals(intent.getAction())) {
                    b.bsO().putInt("native_crash_count_" + stringExtra, 0);
                }
            }
        }
    };
    private static BdNativeCrash.a lpa = new BdNativeCrash.a() { // from class: com.baidu.tieba.nativecrash.a.2
    };

    public static void djU() {
        if (BdNativeCrash.loX) {
            BdNativeCrash.djT().fS(TbConfig.getTempDirName(), TbConfig.FATAL_ERROR_NATIVE_DIR);
            BdNativeCrash.djT().a(lpa);
            djV();
        }
    }

    private static void djV() {
        try {
            Context applicationContext = BdBaseApplication.getInst().getApplicationContext();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.adp.plugin.installed");
            intentFilter.setPriority(-1000);
            applicationContext.registerReceiver(Tl, intentFilter);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
