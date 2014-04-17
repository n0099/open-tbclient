package com.baidu.tieba.tbluncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class z extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private z(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ z(MainTabActivity mainTabActivity, byte b) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(com.baidu.tbadk.core.data.n.z())) {
            if (TbadkApplication.aB()) {
                MainTabActivity.b(this.a, true);
            } else {
                MainTabActivity.b(this.a, false);
            }
            MainTabActivity.a(this.a, false);
        }
    }
}
