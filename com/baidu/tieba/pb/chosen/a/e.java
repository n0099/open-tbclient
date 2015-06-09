package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ b bJp;
    private final /* synthetic */ User_Info bJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, User_Info user_Info) {
        this.bJp = bVar;
        this.bJs = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bJp.d(this.bJs.id.longValue(), this.bJs.name);
    }
}
