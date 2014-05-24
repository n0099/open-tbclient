package com.baidu.tieba.tblauncher;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity this$0;

    private aa(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(MainTabActivity mainTabActivity, aa aaVar) {
        this(mainTabActivity);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(TbConfig.getBroadcastActionNewVersion())) {
            refreshNewVersion();
        }
    }

    private void refreshNewVersion() {
        if (TbadkApplication.checkNeedShowNewVersion()) {
            this.this$0.R = true;
        } else {
            this.this$0.R = false;
        }
        this.this$0.a(false);
    }
}
