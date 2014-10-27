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
            aa.rz().rA();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
