package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity this$0;

    private ad(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(MainTabActivity mainTabActivity, ad adVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
            refreshNewVersion();
        }
    }

    private void refreshNewVersion() {
        boolean z;
        boolean checkNeedShowNewVersion = TbadkApplication.checkNeedShowNewVersion();
        if (checkNeedShowNewVersion) {
            z = this.this$0.P;
            if (!z) {
                this.this$0.Q = true;
            }
        }
        if (checkNeedShowNewVersion) {
            this.this$0.P = true;
        } else {
            this.this$0.P = false;
        }
        this.this$0.a(false);
    }
}
