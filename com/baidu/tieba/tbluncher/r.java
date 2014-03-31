package com.baidu.tieba.tbluncher;

import android.view.View;
/* loaded from: classes.dex */
final class r implements View.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.a;
        mainTabActivity = this.a.D;
        mainTabActivity2.a(new com.baidu.adp.framework.message.a(2015003, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity)));
    }
}
