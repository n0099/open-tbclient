package com.baidu.tieba.pb;

import android.view.View;
import com.baidu.tieba.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(cp cpVar) {
        this.f2153a = cpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbListView pbListView;
        boolean z;
        pbListView = this.f2153a.aq;
        pbListView.c();
        bu buVar = this.f2153a.f;
        z = this.f2153a.ar;
        buVar.a(z);
        this.f2153a.ai();
    }
}
