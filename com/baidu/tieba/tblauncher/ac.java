package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity this$0;

    private ac(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(MainTabActivity mainTabActivity, ac acVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
            refreshNewVersion();
        }
    }

    private void refreshNewVersion() {
        if (TbadkCoreApplication.checkNeedShowNewVersion()) {
            this.this$0.mHasNewVersion = true;
        } else {
            this.this$0.mHasNewVersion = false;
        }
        this.this$0.fl(false);
    }
}
