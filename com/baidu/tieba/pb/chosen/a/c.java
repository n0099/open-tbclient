package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bGj;
    private final /* synthetic */ User_Info bGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, User_Info user_Info) {
        this.bGj = aVar;
        this.bGk = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGj.c(this.bGk.id.longValue(), this.bGk.name);
    }
}
