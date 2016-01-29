package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.ExcPbPage.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e cIY;
    private final /* synthetic */ UserInfo cIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, UserInfo userInfo) {
        this.cIY = eVar;
        this.cIZ = userInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cIY.h(this.cIZ.id.longValue(), this.cIZ.name);
    }
}
