package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e cfL;
    private final /* synthetic */ User_Info cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, User_Info user_Info) {
        this.cfL = eVar;
        this.cfM = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfL.f(this.cfM.id.longValue(), this.cfM.name);
    }
}
