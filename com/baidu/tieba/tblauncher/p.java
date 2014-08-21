package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ MainTabActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        MainTabActivity mainTabActivity;
        MainTabActivity mainTabActivity2 = this.a;
        textView = this.a.E;
        mainTabActivity2.a(textView, 0);
        MainTabActivity.d = false;
        mainTabActivity = this.a.I;
        this.a.a(new CustomMessage(2002001, new bx(mainTabActivity)));
    }
}
