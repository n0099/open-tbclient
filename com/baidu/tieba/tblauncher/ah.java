package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity this$0;

    private ah(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ah(MainTabActivity mainTabActivity, ah ahVar) {
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
            z = this.this$0.adC;
            if (!z) {
                this.this$0.bPj = true;
            }
        }
        if (checkNeedShowNewVersion) {
            this.this$0.adC = true;
        } else {
            this.this$0.adC = false;
        }
        this.this$0.eJ(false);
    }
}
