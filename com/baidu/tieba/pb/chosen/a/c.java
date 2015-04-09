package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bGw;
    private final /* synthetic */ User_Info bGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, User_Info user_Info) {
        this.bGw = aVar;
        this.bGx = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGw.c(this.bGx.id.longValue(), this.bGx.name);
    }
}
