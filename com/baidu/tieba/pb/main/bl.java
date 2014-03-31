package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl implements View.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.aS;
        pbListView.d();
        ax axVar = this.a.l;
        z = this.a.aT;
        axVar.a(z);
        this.a.ai();
    }
}
