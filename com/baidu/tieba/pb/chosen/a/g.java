package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e cfA;
    private final /* synthetic */ User_Info cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, User_Info user_Info) {
        this.cfA = eVar;
        this.cfB = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfA.f(this.cfB.id.longValue(), this.cfB.name);
    }
}
