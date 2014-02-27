package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cv implements View.OnClickListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.at;
        pbListView.c();
        cc ccVar = this.a.g;
        z = this.a.au;
        ccVar.a(z);
        this.a.Z();
    }
}
