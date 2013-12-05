package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.account.ai;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
/* loaded from: classes.dex */
public class WebNativeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2 = new Intent(context, DealIntentService.class);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("from");
            if (stringExtra2 == null) {
                stringExtra2 = "aladdin_wake";
            }
            if (stringExtra != null) {
                if (stringExtra.equals("web")) {
                    intent2.putExtra("class", 0);
                    intent2.putExtra(SocialConstants.PARAM_URL, intent.getStringExtra(SocialConstants.PARAM_URL));
                    new ai(stringExtra2, SocialConstants.PARAM_URL).start();
                } else if (stringExtra.equals("pb")) {
                    intent2.putExtra("class", 1);
                    intent2.putExtra(LocaleUtil.INDONESIAN, intent.getStringExtra(LocaleUtil.INDONESIAN));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("frs")) {
                    intent2.putExtra("class", 2);
                    intent2.putExtra("fname", intent.getStringExtra("fname"));
                    intent2.putExtra("from", stringExtra2);
                } else if (stringExtra.equals("groupinfo")) {
                    intent2.putExtra("class", 13);
                    intent2.putExtra("groupid", intent.getStringExtra("groupid"));
                } else {
                    return;
                }
                context.startService(intent2);
            }
        }
    }
}
