package com.baidu.tieba.tblauncher;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bn;
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
        textView = this.a.C;
        mainTabActivity2.a(textView, 0);
        MainTabActivity.c = false;
        mainTabActivity = this.a.G;
        this.a.a(new CustomMessage(2002001, new bn(mainTabActivity)));
    }
}
