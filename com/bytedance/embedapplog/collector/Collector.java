package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import d.b.b.r0;
import d.b.b.x1;
/* loaded from: classes5.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra != null && stringArrayExtra.length > 0) {
            x1.e(stringArrayExtra);
        } else {
            r0.b(null);
        }
    }
}
