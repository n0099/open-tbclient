package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.BackupMyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.view.MorePopupWindow;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MorePopupWindow morePopupWindow;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2;
        morePopupWindow = this.this$0.mPopWindow;
        com.baidu.adp.lib.g.j.a(morePopupWindow, this.this$0);
        if (TbadkApplication.m251getInst().isLiveSDKOpen()) {
            MainTabActivity mainTabActivity3 = this.this$0;
            mainTabActivity2 = this.this$0.bOO;
            mainTabActivity3.sendMessage(new CustomMessage(2002001, new MyLiveActivityConfig(mainTabActivity2)));
            return;
        }
        MainTabActivity mainTabActivity4 = this.this$0;
        mainTabActivity = this.this$0.bOO;
        mainTabActivity4.sendMessage(new CustomMessage(2002001, new BackupMyLiveActivityConfig(mainTabActivity)));
    }
}
