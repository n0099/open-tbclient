package com.baidu.tieba.keepLive.startActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.keepLive.util.RomTypeUtil;
/* loaded from: classes2.dex */
public class ScreenChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!RomTypeUtil.isEmui() && intent != null && "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            ScreenManager.getInstance(context).finishActivity();
        }
    }
}
