package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.ExcPbPage.UserInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e cyN;
    private final /* synthetic */ UserInfo cyO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, UserInfo userInfo) {
        this.cyN = eVar;
        this.cyO = userInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cyN.h(this.cyO.id.longValue(), this.cyO.name);
    }
}
