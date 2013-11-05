package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(bt btVar) {
        this.f2111a = btVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.f2111a.aA;
        pbListView.c();
        bn bnVar = this.f2111a.b;
        z = this.f2111a.aB;
        bnVar.a(z);
    }
}
