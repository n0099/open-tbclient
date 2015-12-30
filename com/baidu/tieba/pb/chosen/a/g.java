package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.ExcPbPage.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e cCt;
    private final /* synthetic */ UserInfo cCu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, UserInfo userInfo) {
        this.cCt = eVar;
        this.cCu = userInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cCt.h(this.cCu.id.longValue(), this.cCu.name);
    }
}
