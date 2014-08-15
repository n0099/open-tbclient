package com.baidu.tieba.tblauncher;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.view.m mVar;
        MainTabActivity mainTabActivity;
        mVar = this.a.p;
        mVar.dismiss();
        MainTabActivity mainTabActivity2 = this.a;
        mainTabActivity = this.a.I;
        mainTabActivity2.a(new CustomMessage(2002001, new aw(mainTabActivity)));
    }
}
