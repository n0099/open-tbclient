package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn implements View.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.aU;
        pbListView.d();
        az azVar = this.a.l;
        z = this.a.aV;
        azVar.a(z);
        this.a.ai();
    }
}
