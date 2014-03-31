package com.baidu.tieba.tbluncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class t extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    private t(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(MainTabActivity mainTabActivity, byte b) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(com.baidu.tbadk.core.data.n.z())) {
            if (TbadkApplication.az()) {
                MainTabActivity.a(this.a, true);
            } else {
                MainTabActivity.a(this.a, false);
            }
            MainTabActivity.f(this.a);
        }
    }
}
