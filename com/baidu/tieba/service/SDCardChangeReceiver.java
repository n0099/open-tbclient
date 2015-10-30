package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.editortools.emotiontool.r;
/* loaded from: classes.dex */
public class SDCardChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            r.AZ().Ba();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
