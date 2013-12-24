package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.aq;
        pbListView.c();
        bw bwVar = this.a.f;
        z = this.a.ar;
        bwVar.a(z);
        this.a.ai();
    }
}
