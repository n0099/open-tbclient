package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(br brVar) {
        this.f1564a = brVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.f1564a.aA;
        pbListView.c();
        bm bmVar = this.f1564a.b;
        z = this.f1564a.aB;
        bmVar.a(z);
    }
}
