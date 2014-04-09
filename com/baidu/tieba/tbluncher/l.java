package com.baidu.tieba.tbluncher;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
final class l implements View.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextView textView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.a;
        textView = this.a.A;
        MainTabActivity.a(mainTabActivity2, textView, 0);
        MainTabActivity.c = false;
        MainTabActivity mainTabActivity3 = this.a;
        mainTabActivity = this.a.E;
        mainTabActivity3.a(new com.baidu.adp.framework.message.a(2015003, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity)));
    }
}
