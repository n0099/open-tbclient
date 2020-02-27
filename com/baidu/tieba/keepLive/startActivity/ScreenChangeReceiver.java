package com.baidu.tieba.keepLive.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes8.dex */
public class ScreenChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!ak.isEmui() && intent != null && "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            ScreenManager.getInstance(context).finishActivity();
        }
    }
}
