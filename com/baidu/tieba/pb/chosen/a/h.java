package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e bZB;
    private final /* synthetic */ User_Info bZC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, User_Info user_Info) {
        this.bZB = eVar;
        this.bZC = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bZB.e(this.bZC.id.longValue(), this.bZC.name);
    }
}
