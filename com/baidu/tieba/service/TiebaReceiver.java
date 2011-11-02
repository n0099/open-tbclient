package com.baidu.tieba.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
public class TiebaReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent dialog = new Intent(context, PersonInfoActivity.class);
        dialog.setFlags(268435456);
        context.startActivity(dialog);
    }
}
