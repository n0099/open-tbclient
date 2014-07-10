package com.baidu.tieba.pb.main;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.a.aS;
        pbListView.d();
        if (this.a.j != null) {
            bb bbVar = this.a.j;
            z = this.a.aT;
            bbVar.a(z);
        }
        this.a.ak();
    }
}
