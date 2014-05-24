package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.a;
        textView = this.a.B;
        mainTabActivity2.a(textView, 0);
        MainTabActivity.c = false;
        MainTabActivity mainTabActivity3 = this.a;
        mainTabActivity = this.a.F;
        mainTabActivity3.a(new CustomMessage(2017003, new com.baidu.tbadk.core.frameworkData.a(mainTabActivity)));
    }
}
