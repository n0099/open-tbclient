package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ b bJo;
    private final /* synthetic */ User_Info bJr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, User_Info user_Info) {
        this.bJo = bVar;
        this.bJr = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJo.d(this.bJr.id.longValue(), this.bJr.name);
    }
}
