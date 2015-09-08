package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.User_Info;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e cav;
    private final /* synthetic */ User_Info caw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, User_Info user_Info) {
        this.cav = eVar;
        this.caw = user_Info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cav.e(this.caw.id.longValue(), this.caw.name);
    }
}
