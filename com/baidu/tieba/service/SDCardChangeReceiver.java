package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.editortool.aa;
/* loaded from: classes.dex */
public class SDCardChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            aa.rB().rC();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
