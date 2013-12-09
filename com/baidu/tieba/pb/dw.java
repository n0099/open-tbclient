package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f2246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(cr crVar) {
        this.f2246a = crVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.f2246a.aq;
        pbListView.c();
        bw bwVar = this.f2246a.f;
        z = this.f2246a.ar;
        bwVar.a(z);
        this.f2246a.ai();
    }
}
