package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.PayActivityConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
/* loaded from: classes.dex */
public class WebNativeReceiver extends BroadcastReceiver {
    private static final String DEFAULT_FROM = "aladdin_wake";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, DealIntentService.class);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("from");
            if (stringExtra2 == null) {
                stringExtra2 = DEFAULT_FROM;
            }
            if (stringExtra != null) {
                if (stringExtra.equals("web")) {
                    intent2.putExtra("class", 0);
                    intent2.putExtra("url", intent.getStringExtra("url"));
                    intent2.putExtra("from", stringExtra2);
                    new az(stringExtra2, "url").start();
                } else if (stringExtra.equals("pb")) {
                    intent2.putExtra("class", 1);
                    intent2.putExtra("id", intent.getStringExtra("id"));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("frs")) {
                    intent2.putExtra("class", 2);
                    intent2.putExtra("fname", intent.getStringExtra("fname"));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("groupinfo")) {
                    intent2.putExtra("class", 13);
                    intent2.putExtra("groupid", intent.getStringExtra("groupid"));
                } else if (stringExtra.equals("pay")) {
                    intent2.putExtra("class", 15);
                    intent2.putExtra(PayActivityConfig.PAY_TYPE, intent.getStringExtra(PayActivityConfig.PAY_TYPE));
                    intent2.putExtra(PayActivityConfig.PROPS_ID, intent.getStringExtra(PayActivityConfig.PROPS_ID));
                    intent2.putExtra(PayActivityConfig.QUAN_NUM, intent.getStringExtra(PayActivityConfig.QUAN_NUM));
                    intent2.putExtra(PayActivityConfig.IS_LEFT, intent.getStringExtra(PayActivityConfig.IS_LEFT));
                    intent2.putExtra(PayActivityConfig.PROPS_MON, intent.getStringExtra(PayActivityConfig.PROPS_MON));
                } else if (stringExtra.equals("livegroup")) {
                    intent2.putExtra("class", 17);
                    intent2.putExtra("groupid", intent.getStringExtra("groupid"));
                } else {
                    return;
                }
                context.startService(intent2);
            }
        }
    }
}
